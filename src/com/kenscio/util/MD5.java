package com.kenscio.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	public static String getMD5(String val)
	{
		byte[] pass = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(val.getBytes());
			pass=md5.digest();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception:" + e);
			e.printStackTrace();
		}
		return new BigInteger(pass).toString(16);
		
	}

}
