package pers.dc.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class Encryptors {

	public static String getMD5Str(String strValue) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
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
