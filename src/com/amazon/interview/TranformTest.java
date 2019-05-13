package com.amazon.interview;

public class TranformTest {

	public static void main(String[] args) {
		String str = "internationalizationasdasdasdasdsad" +
				"dsdadasdasdsadsadsdasdasinternationalizationasdasdasdas" +
				"dsaddsdadasdasdsadsadsdasdasinternationalizationasdasdasdasdsaddsd" +
				"adasdasdsadsadsdasdasinternationalizationasdasdasdasdsaddsdadasdasdsadsadsdasdas\0";
		char[] input = str.toCharArray();
		
		
		//char[] input = {'A','m','a','z','o','n','\0'};
		
		int index = 1;
		int count = 0;
		char end = input[index];
		while(input[index] != '\0'){
			count++;
			end = input[index];
			index++;
		}
		count--;
		
		index = 1;
		int len = countChars(count);
		System.out.println(len);
		int rem = count;
		for(int x =1; x<=len;x++){
			int current = rem/(int)(Math.pow(10, len-x));
			rem = rem %(int)(Math.pow(10, len-x));
			input[index] =  (char)(current+'0');
			index++;
		}
		input[index] = end;
		System.out.println(index+":"+count);
		for(int x= index; x<count+1;x++){
			input[x] = '\0';
		}
		System.out.println(input);
		System.out.println(count+":"+end);
	}
	
	private static int countChars(int input){
		int count = 0;
		while(input != 0){
			input = input/10;
			++count;
		}
		return count;
	}
}
