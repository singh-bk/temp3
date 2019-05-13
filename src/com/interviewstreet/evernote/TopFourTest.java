package com.interviewstreet.evernote;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TopFourTest {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("topfour.txt")));
		int count = Integer.parseInt(br.readLine());
		
		int[] top = new int[4];
		if()
	}
}
