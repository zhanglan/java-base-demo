package com.zl.crypto.bls;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.PairingParametersGenerator;
import it.unisa.dia.gas.plaf.jpbc.pairing.a.TypeACurveGenerator;
import it.unisa.dia.gas.plaf.jpbc.pairing.a.TypeAPairing;
import lombok.Data;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 一定注意，这里困惑了我很久
 * CurveElement代表曲线上的点，其mul方法就是曲线上两点的加法，powZn则是曲线上一点与数字的乘法
 * ZrElement代表Zp有限域上的取值，即一个数，其mul就是乘，powZn就是取幂
 * 以上说的运算都是经过取模运算的
 *
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/10
 */
@Data
public class BlsSignature {

	private Pairing pairing;

	// 曲线基点G
	private Element pointG;

	public BlsSignature() {
		PairingParametersGenerator generator = new TypeACurveGenerator(256, 512);
		pairing = new TypeAPairing(generator.generate());
		// 其实G1,G2相同，G2域上取一个随机点作为基点G
		pointG = pairing.getG2().newRandomElement();
	}

	private List<Signature> signatures = new ArrayList<>();

	public Signature sign(byte[] message, byte[] prvKey) {
		Element secretKey = pairing.getZr().newElementFromBytes(prvKey);
		// 公钥：P=G*k
		Element pubKey = pointG.duplicate().powZn(secretKey);

		// 普通哈希（sha256上稍做修改）
		byte[] hash = hash(message, pubKey);

		// 曲线哈希，将一个哈希表示的数字映射到曲线上的一个点
		Element h = pairing.getG1().newElementFromHash(hash, 0, hash.length);

		// 签名：S=h*k
		Element signatureElement = h.powZn(secretKey);


		Signature signature = new Signature();
		signature.setMessage(message);
		signature.setPublicKey(pubKey);
		signature.setSignature(signatureElement);
		return signature;
	}

	public void addSignature(Signature signature) {
		signatures.add(signature);
	}

	public boolean validate() {
		// 聚合签名 S = S0+S1+S2+...+S9
		Element compactSignature = signatures.get(0).getSignature().duplicate();
		for (int i = 1; i < signatures.size(); i++) {
			compactSignature = compactSignature.mul(signatures.get(i).getSignature());
		}
		// paraing方法即曲线配对函数e，这里即e(S, G)
		Element compactPairing = pairing.pairing(compactSignature, pointG.duplicate());

		// 这里的哈希是与公钥相关的
		byte[] hash0 = hash(signatures.get(0).getMessage(), signatures.get(0).getPublicKey());

		// 将哈希映射到曲线上 H(m,P)
		Element hashElement0 = pairing.getG1().newElementFromHash(hash0, 0, hash0.length);

		// e(H(m,P0), P0)
		Element fullPairing = pairing.pairing(hashElement0, signatures.get(0).getPublicKey());
		for (int i = 1; i < signatures.size(); i++) {
			byte[] messageHash = hash(signatures.get(i).getMessage(), signatures.get(i).getPublicKey());

			Element hashElement = pairing.getG1().newElementFromHash(messageHash, 0, messageHash.length);
			Element publicKey = signatures.get(i).getPublicKey();
			Element p = pairing.pairing(hashElement, publicKey);
			// e(H(m,P0), P0)+e(H(m,P1), P1)+...+e(H(m,P9), P9)
			fullPairing.mul(p);
		}

		return compactPairing.isEqual(fullPairing);
	}

	/**
	 * hash(message, pubKey) = sha256(sha256(message)+pubKey)
	 * @param message
	 * @param publicKey
	 * @return
	 */
	private byte[] hash(byte[] message, Element publicKey) {
		byte[] bytes1 = Sha256Hash.hash(message);
		byte[] bytes2 = publicKey.toBytes();
		ByteBuffer buffer = ByteBuffer.allocate(bytes1.length + bytes2.length);
		buffer.put(bytes1);
		buffer.put(bytes2);

		return Sha256Hash.hash(buffer.array());
	}

}
