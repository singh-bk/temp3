package com.microsoft.interview;

public class BSTTest {

    public static void main(String[] args) {
        final int[] input = new int[100];
        final Integer counter = 0;
        for(int i=0;i<100;i++) {
            input[i] = i;
        }
        final int srch = 10;
        final BSTTest obj = new BSTTest();
        System.out.println(obj.search(input, 0 , input.length-1, srch, counter));
        System.out.println(counter);
    }
    
    public int search(int[] input, int start, int end, int item, int counter) {
        final int mid = (start+end)/2;
        counter++;
        if(input[mid] == item) {
            return mid;
        }
        if(input[mid] < item && mid < end) {
            
            return search(input, mid+1, end, item, counter);
        }
        if(input[mid] > item && mid > start) {
            return search(input, start, mid, item, counter);
        }
        return -1;
    }
}
