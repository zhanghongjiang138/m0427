package com.m0427.web.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptAlgorithm {

	private static String MD5 = "md5";
	private static String SHA = "sha";
	//private static String HMAC = "HmacMD5";

	/* 得到MD5加密后的str */
	public static String hexMD5(String str) throws Exception{
		return toHex(encryptMD5(str.getBytes()));
	}
	/* 得到sha加密后的str */
	public static String hexSHA(String str) throws Exception{
		return toHex(encryptSHA(str.getBytes()));
	}
	
	/* MD5 加密 */
	private  static byte[] encryptMD5(byte[] data) throws NoSuchAlgorithmException{
		MessageDigest md5 = MessageDigest.getInstance(MD5);
		md5.update(data);
		return md5.digest();
	}

	/* SHA 加密 */
	private static byte[] encryptSHA(byte[] data) throws Exception {
		MessageDigest sha = MessageDigest.getInstance(SHA);
		sha.update(data);
		return sha.digest();
	}


	private static String toHex(byte[] buffer) {
		StringBuffer sb = new StringBuffer(buffer.length * 3);
		for (int i = 0; i < buffer.length; i++) {
			sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
			sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
		}
		return sb.toString();
	}
}