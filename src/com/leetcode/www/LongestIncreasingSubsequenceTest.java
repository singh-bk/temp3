package com.leetcode.www;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequenceTest {
	public static int lengthOfLIS(int[] nums) {
		List<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>();
		int max = 1;
		for (int num : nums) {
			ArrayList<Integer> x = new ArrayList<Integer>();
			x.add(num);
			listOfList.add(x);
			List<ArrayList<Integer>> concat = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> list : listOfList) {
				if (list.get(list.size() - 1) < num) {
					ArrayList<Integer> copy = new ArrayList<Integer>();
					copy.addAll(list);
					copy.add(num);
					concat.add(copy);
					if (copy.size() > max)
						max = copy.size();
				}
			}
			listOfList.addAll(concat);
		}
		for(ArrayList<Integer> list: listOfList){
			System.out.println(list);
		}
		return max;

	}
	
	public static void main(String[] args) {
		int[] input = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(input));
	}
}
