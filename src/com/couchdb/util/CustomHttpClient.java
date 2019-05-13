package com.couchdb.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PutMethod;

public class CustomHttpClient {

	public static void main(String...strings )
	{
		try
		{
		System.out.println();
		String url = "http://127.0.0.1:5984/_all_dbs";
		url="http://127.0.0.1:5984/_utils/database.html?_users";
		System.out.println(GET(url));
		String newDB = "http://127.0.0.1:5984/baseball";
		System.out.println(PUT(newDB));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static String GET(String url) throws HttpException, IOException
	{
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		try
		{
			httpClient.executeMethod(getMethod);
			return getMethod.getResponseBodyAsString();
		}
		finally
		{
			getMethod.releaseConnection();
		}
	}
	public static String PUT(String url) throws HttpException, IOException
	{
		HttpClient httpClient = new HttpClient();
		PutMethod putMethod = new PutMethod(url);
		try
		{
			httpClient.executeMethod(putMethod);
			return putMethod.getResponseBodyAsString();
		}
		finally
		{
			putMethod.releaseConnection();
		}
	}	
}
