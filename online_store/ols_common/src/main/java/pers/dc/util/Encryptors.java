package pers.dc.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class Encryptors {

	public static String getMD5Str(String strValue) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String md5Str = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
		return md5Str;
	}

	public static void main(String[] args) {
		try {
			String md5 = getMD5Str("Test");
			System.out.println(md5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
