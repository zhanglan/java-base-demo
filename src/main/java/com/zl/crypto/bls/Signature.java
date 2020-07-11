package com.zl.crypto.bls;

import it.unisa.dia.gas.jpbc.Element;
import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/10
 */
@Data
public class Signature {

	private byte[] message;

	// 公钥，实质是一个点，CurveElement
	private Element publicKey;

	// 签名，实质也是一个点，CurveElement
	private Element signature;

}
