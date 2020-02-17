package com.uber.www;

public class ProdSum {

    public static void main(String[] args) {
        final ProdSum obj = new ProdSum();
        final int x = 999999999;
        System.out.println(x);
        System.out.println(obj.diff(x));
        System.out.println(obj.diff2(x));
    }
    
    public int diff2(int x) {
        int prod = 1;
        int sum = 0;
        int quo = x;
        int rem = 0;
        while(quo > 0) {
            rem = quo % 10;
            quo = quo / 10;
            prod = prod * rem;
            sum = sum + rem;
        }
        return prod - sum;
    }
    
    public int diff(int x) {
        final String str = String.valueOf(x);
        int prod = 1;
        int sum = 0;
        final int[] arr = new int[str.length()];
        for( int i=0;i<str.length();i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }
        for(int i=0;i<str.length();i++) {
            prod = prod * arr[i];
            sum = sum + arr[i];
        }
        System.out.println(prod);
        return prod - sum;
    }
}
