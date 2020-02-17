package com.leetcode.twilio;

public class FizzBuzzTest {

    public static void main(String[] args) {
        final FizzBuzzTest obj = new FizzBuzzTest();
        obj.print(100);
    }
    
    public void print(int n) {
        for(int i=1;i<n;i++) {
            if(i%15 ==0) {
                System.out.println("fizzbuzz");
            }else if(i%5 == 0) {
                System.out.println("buzz");
            }else if(i%3 == 0) {
                System.out.println("fixx");
            }else {
                System.out.println(i);
            }
        }
    }
}
