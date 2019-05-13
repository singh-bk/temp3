package com.facebook.hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LabelMakerTest {

	public static void main(String[] args) throws NumberFormatException, IOException{
	
		BufferedReader br = new BufferedReader(new FileReader(new File("label.txt")));
		int testCaseCount = Integer.parseInt(br.readLine());
		for(int i=0;i<testCaseCount;i++)
		{
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str, " ");
			String input = token.nextToken();
			char[] inputArr = input.toCharArray();
			
			BigDecimal labelCount = new BigDecimal(token.nextToken());
			
			int inputLength = input.length();
			/*
			 * find the total no of chars in output
			 */
			int charInOutput = 1;
			BigDecimal compare = new BigDecimal(Math.pow(inputLength, charInOutput));
			BigDecimal oldCompare = new BigDecimal(Math.pow(inputLength, charInOutput));
			while(labelCount.compareTo(compare)>0){
				charInOutput++;
				BigDecimal compare2 = new BigDecimal(Math.pow(inputLength, charInOutput));
				oldCompare = compare;
				compare = compare.add(compare2);
			}
			//System.out.println("Total chars in output"+charInOutput+" compare:"+oldCompare);
			char[] outputArr = new char[charInOutput];
			
			BigDecimal diff = labelCount.subtract(oldCompare);
			int tempCharInOutput = charInOutput-1;
			int outputCount = 0;
			BigDecimal[] outputStartAndCount = new BigDecimal[2];
			
			//var to store the total count of Strings starting with same char - ex : T
			while(tempCharInOutput>=1)
			{
				BigDecimal totalCountStartingWithSameChar = new BigDecimal(Math.pow(inputLength, tempCharInOutput));
				//First char of the output
				outputStartAndCount = diff.divideAndRemainder(totalCountStartingWithSameChar);			
				//System.out.println("diff:"+diff+" totalCountStartingWithSameChar:"+totalCountStartingWithSameChar+" outputStart:"+(outputStartAndCount[0].intValue()+1)+" remainder:"+outputStartAndCount[1]);
				tempCharInOutput--;
				diff = outputStartAndCount[1];
				outputArr[outputCount] = inputArr[outputStartAndCount[0].intValue()-1];
				outputCount++;
			}
			if(tempCharInOutput==0 && outputStartAndCount[1].intValue()>1)
				outputArr[outputCount] = inputArr[outputStartAndCount[1].intValue()-1];
			
			System.out.print("Case #"+(i+1)+": ");
			for(int k=0;k<outputArr.length;k++)
			{
				System.out.print(outputArr[k]);
			}
			System.out.println();
		}
	}
}
