package com.moraganstanley.www;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest {

	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new FileReader(new File("a.txt")));
			//System.exit(1);
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}finally{
			System.out.println("Finally Called");
		}
	}
}
