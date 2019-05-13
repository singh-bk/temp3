package com.heap.www;

import java.util.HashMap;

public class FindTrendingTopicsTest {

	private static String[] input;
	private static HeapNode[] minHeap = new HeapNode[10];
	static int current = 0;;
	public static void main(String[] args){
		input = new String[]{"amazon","amazon","amazon","amazon","amazon","amazon","amazon",
				"google","google","google","google","google","google","google","google",
				"facebook","facebook","facebook","facebook","facebook","facebook","facebook","facebook",
				"twitter","twitter","twitter","twitter","twitter","twitter","twitter",
				"apple","apple","apple","apple","apple","apple","apple",
				"microsoft","microsoft","microsoft","microsoft","microsoft","microsoft","microsoft","microsoft",
				"intel","intel","intel","intel","intel","intel","intel","intel","intel",
				"yahoo","yahoo","yahoo","yahoo","yahoo","yahoo","yahoo","yahoo","yahoo","yahoo",
				"hp","hp","hp","hp","hp","hp","hp","hp","hp","hp",
				"ibm","ibm","ibm","ibm","ibm","ibm","ibm","ibm","ibm","ibm","ibm","ibm",
				"atari","atari","atari","atari","atari",
				"intuit","intuit","intuit","intuit","intuit","intuit","intuit",
				"orcale","orcale","orcale","orcale","orcale","orcale","orcale","orcale","orcale","orcale","orcale","orcale","orcale","orcale","orcale",
				"kindle","kindle","kindle","kindle","kindle","kindle","kindle","kindle","kindle",
				"bing","bing","bing","bing","bing","bing",
				"iphone","iphone","iphone","iphone",
				"ipod","ipod","ipod","ipod","ipod","ipod","ipod","ipod","ipod",
				"windows","windows","windows","windows","windows","windows","windows","windows","windows",
				"mac","mac","mac","mac","mac","mac","mac","mac","mac",
				"amazon","amazon","amazon","amazon","amazon","amazon","amazon","amazon","amazon","amazon","amazon","amazon","amazon","amazon"};
		
		/*
		 * populate the map with the input data.
		 * This map can be put on an external drive.
		 */
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HeapNode node;
		for(int i=0;i<input.length;i++)
		{
			int count = 0;
			if(map.get(input[i]) != null)
			{
				//The data is present in the map. increment the count by 1.
				count = map.get(input[i]);
				count++;
				map.put(input[i], count);
				/*
				 * If input[i] is present in the heap - isPresentInHeap is true;
				 * 		increment the count for the node
				 * 		run MaintainMinHeap
				 * Else - isPresentInHeap is false 		
				 * 		get the count of the first element of minHeap
				 * 		if the count of input[i] is greater than above
				 * 			replace first element of minHeap with input[i], count
				 * 			run MaintainMinHeap	
				 */
				boolean isPresentInHeap = false;
				for(int j=0;j<minHeap.length;j++)
				{
					if(minHeap[j] != null && minHeap[j].getWord().equals(input[i]))
					{
						isPresentInHeap = true;
						minHeap[j].setCount(count);
						break;
					}
				}
				if(!isPresentInHeap)
				{
					int minCountOfHeap = minHeap[0].getCount();
					if(count > minCountOfHeap)
					{
						minHeap[0].setWord(input[i]);
						minHeap[0].setCount(count);
					}
				}
				MaintainMinHeap();
				
			}
			/*
			 * The data is not present in the map.
			 * add the data to map.
			 * if current is less than minHeap size
			 * 		populate the heap as well.
			 * 		Maintain the heap
			 */
			else
			{
				count = 1;
				map.put(input[i], 1);
				//populate the first 10 distinct words in the min Heap. 
				if(current < minHeap.length)
				{
					//node = new HeapNode(input[i], count);
					minHeap[current] = new HeapNode(input[i], count);
					current++;
				}
				MaintainMinHeap();
			}
		}
		
		for(int i=0;i<minHeap.length;i++)
		{
			System.out.println(minHeap[i].getWord()+" "+minHeap[i].getCount());
		}
		System.out.println(map.size());
	}
	
	/**
	 * 
	 */
	private static void MaintainMinHeap()
	{
		int len = current;
		for(int i=len/2;i>=0;i--)
		{
			MaintainMinHeap(i);
		}
	}
	
	/**
	 * @param index
	 */
	private static void MaintainMinHeap(int index)
	{
		int left = 2*index+1;
		int right = 2*index+2;
		int smallest = index;
		
		if(left<current && minHeap[left].getCount() < minHeap[smallest].getCount()){
			smallest = left;
		}
		if(right<current &&minHeap[right].getCount() < minHeap[smallest].getCount()){
			smallest = right;
		}
		if(smallest != index){
			Swap(smallest, index);
			MaintainMinHeap(smallest);
		}
	}
	
	/**
	 * @param index1
	 * @param index2
	 */
	private static void Swap(int index1, int index2)
	{
		String word = minHeap[index1].getWord();
		int count = minHeap[index1].getCount();
		
		minHeap[index1].setCount(minHeap[index2].getCount());
		minHeap[index1].setWord(minHeap[index2].getWord());
		
		minHeap[index2].setCount(count);
		minHeap[index2].setWord(word);
	}
}
