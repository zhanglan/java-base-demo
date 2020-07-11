package com.zl.crypto.bls;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/10
 */
public class Sha256Hash {
	private static final MessageDigest DIGEST;
	public static final Charset UTF_8 = Charset.forName("UTF-8");

	static {
		try {
			DIGEST = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new Error(e);
		}
	}

	public static synchronized byte[] hash(byte[] data){
		return DIGEST.digest(data);
	}

	public static synchronized byte[] hash(byte[] data, int offset, int length){
		DIGEST.update(data, offset, length);
		return DIGEST.digest();
	}

	public static synchronized byte[] hash(String data){
		return hash(data.getBytes(UTF_8));
	}
}
