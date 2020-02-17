package com.uber.www;

public class BitTest {

    public static void main(String[] args) {
        final BitTest obj = new BitTest();
        final int n = 17;
        System.out.println(obj.countOnes(n));
        System.out.println(obj.isPowerofTwo(n));
        final char[] ch = {'a', 'b', 'c', 'd', 'e'};
        System.out.println(obj.powerSet(5, ch));
        obj.hasOneAtIPos(n, 4);
        System.out.println(obj.setBitToOne(17, 1));
    }

    public int countOnes(int n) {
        int count = 0;
        while (n > 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }

    public boolean isPowerofTwo(int n) {
        if (n == 0) {
            return false;
        }
        if ((n & n - 1) == 0) {
            return true;
        }
        return false;
    }

    public boolean hasOneAtIPos(int n, int i) {
        final int x = 1 << i;
        return ((x & n) != 0);
    }

    public int powerSet(int n, char[] input) {
        final int p = 1 << n;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < i; j++) {
                if (hasOneAtIPos(i, j)) {
                    System.out.print(input[j]);
                }
            }
            System.out.println();
        }
        return p;
    }
    
    public int setBitToOne(int x, int pos) {
        final int tt = 1<<pos;
        return x | tt;
    }
}
