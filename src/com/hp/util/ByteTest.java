package com.hp.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;


public class ByteTest {

	public static void main(String[] args)
	{
		try
		{
		System.out.println(encode("admin", "iso*help"));
		}catch(Exception ex)
		{
			
		}
	}
	
	public static String encode(String username, String password) throws UnsupportedEncodingException{
		String encodedData = "";
		try 
		{
			if(username==null || username.isEmpty()==true || password==null || password.isEmpty()==true)
			{
				return encodedData;
			}
			else
			{
				String input = username+":"+password;
				//encodedData = new sun.misc.BASE64Encoder().encode(input.getBytes("UTF-8"));
				System.out.println(encodedData);
				byte[] encodedDataByte = Base64.encodeBase64(input.getBytes("UTF-8"));
				encodedData = new String(encodedDataByte);
				System.out.println(encodedData);
				
				return ""+encodedData;
			}
		} catch (UnsupportedEncodingException ex) 
		{
			throw ex;
		}
	}
}
