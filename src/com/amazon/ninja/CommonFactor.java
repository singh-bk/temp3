package com.amazon.ninja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 
 * @author Birendra Kumar Singh
 *
 */
public class CommonFactor {

	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader(new File("factor.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for(int ii=0;ii<testCaseCount;ii++)
		{
			int input = Integer.parseInt(br.readLine());
			//queue to store all the factors of the input - excluding 1.
			LinkedList<Integer> queue = new LinkedList<Integer>();
			
			int i=2;
			int count=0;
			while(i<Math.sqrt(input)){
				count++;
				if((input % i) == 0){
					queue.add(i);
					queue.add(input/i);
				}
				i++;
			}
			//add a condition for pefect square as well
			if(i*i == input ){
				queue.add(i);
			}
			queue.add(input);
			/*System.out.println(count+" "+queue.size());
			for(i=0;i<queue.size();i++){
				System.out.print(queue.get(i)+" ");
			}
			*/
			//initialize the fib sequence
			long[] fib = new long[100];
			fib[0] = 0;
			fib[1] = 1;
			int fibCount = 2;
			//set the maxvalue for fib number
			long maxvalue = 1000000000000000000L;
			long value = -1;
			long fibNum = -1;
			boolean isFound = false;
			int smallestfactor = queue.get(0);
			while(!isFound)
			{
				fib[fibCount] = fib[fibCount-1]+fib[fibCount-2];
				long j=2;
				long inputLong = fib[fibCount];
				/*
				 * If the smallest factor of input is more than the fib num
				 * 		fetching factor of fib num can be avoided
				 */
				if(fib[fibCount] >= smallestfactor)
				{
					//Get all factors of the current fib num and store it in the fibQueue
					LinkedList<Long> fibQueue = new LinkedList<Long>();
					while(j<Math.sqrt(inputLong)){
						if((inputLong % j) == 0){
							fibQueue.add(j);
							fibQueue.add(inputLong/j);
						}
						j++;
					}
					//check for perfect square
					if(j*j == inputLong){
						fibQueue.add(j);
					}
					fibQueue.add(inputLong);//add the num to the queue as well
					
					for(int k=0; k<fibQueue.size();k++){
						int temp = (int)fibQueue.get(k).longValue();
						if(queue.contains(temp)){
							fibNum = fib[fibCount];
							value = temp;
							isFound = true;
							break;
						}
					}
					if(fib[fibCount] >= maxvalue)
					{
						break;
					}
				}
				fibCount++;
			}
			System.out.println(fibNum+" "+value);
		}
	}
}