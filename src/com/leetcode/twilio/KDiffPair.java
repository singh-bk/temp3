package com.leetcode.twilio;

import java.util.HashSet;
import java.util.Set;

public class KDiffPair {

    public static void main(String[] args) {
        //final int[] nums = {1, 2, 3, 4, 5};
        // final int[] nums = {3, 1, 4, 1, 5};
        final int[] nums = {1, 3, 1, 5, 4};
        //final int[] nums = {1, 1, 1, 1, 1};
        final int k = 0;
        final KDiffPair obj = new KDiffPair();
        final int op = obj.findPairs(nums, k);
        System.out.println(op);
    }

    public int findPairs(int[] nums, int k) {
        //Arrays.sort(nums);
        final Set<String> pairsSet = new HashSet<String>();
        int i = 0;
        int j = 1;

        int count = 1;
        int pairs = 0;
        while (j < nums.length) {

            if (i == j) {
                j++;
            } else {
                if (nums[j] - nums[i] == k) {
                    System.out.println(nums[j] + ":" + nums[i]);
                    pairsSet.add(nums[j] + ":" + nums[i]);
                    pairs++;
                    i++;
                    j++;
                } else if (nums[j] - nums[i] < k) {
                    j++;
                } else if (nums[j] - nums[i] > k) {
                    i++;
                }
            }
            count++;
        }
        System.out.println(pairsSet.size());
        return pairsSet.size();
    }
}
