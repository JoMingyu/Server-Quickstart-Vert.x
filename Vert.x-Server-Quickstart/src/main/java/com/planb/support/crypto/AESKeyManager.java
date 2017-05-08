package com.planb.support.crypto;

public class AESKeyManager {
	private static AES256 aes = new AES256("");
	
	public static AES256 getAES() {
		return aes;
	}
}
