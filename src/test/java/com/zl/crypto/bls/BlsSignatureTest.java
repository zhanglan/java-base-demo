package com.zl.crypto.bls;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/10
 */
public class BlsSignatureTest {
	private BlsSignature blsSignature;
	private List<Signature> signatures = new ArrayList<>();

	@Before
	public void setUp() {
		blsSignature = new BlsSignature();
		for (int i = 0; i < 10; i++) {
			byte[] secretKey = blsSignature.getPairing().getZr().newRandomElement().toBytes();
			Signature signature = blsSignature.sign(("hahaha"+i).getBytes(), secretKey);
			signatures.add(signature);
		}
		blsSignature.setSignatures(signatures);
	}

	@Test
	public void baseTest() {
		assertTrue(blsSignature.validate());
	}
}
