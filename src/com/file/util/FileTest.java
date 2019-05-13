package com.file.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args)
	{
	
		try 
		{
			File input = new File("input.txt");
			File output = new File("output.txt");
			if(!output.exists())
			{
				output.createNewFile();
			}
			FileReader fr = new FileReader(input);
			FileWriter fw = new FileWriter(output);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			String str="";
			while((str=br.readLine())!= null)
			{
				System.out.println(str);
				bw.write(str);
			}
			br.close();
			bw.close();
			FileInputStream fis = new FileInputStream(input);
			BufferedInputStream bis = new BufferedInputStream(fis);
			int read = 0;
			while((read = bis.read())!=-1)
			{
				System.out.print((char)read);
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
