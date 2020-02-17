package com.uber.www;

public class CircularBinaryArray {

    public static void main(String[] args) {
        final CircularBinaryArray obj = new CircularBinaryArray();
        final int[] input = {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1,1,1,1,1,1, 0, 1, 1,1,1};
        System.out.println(obj.maxConsecutiveOnes(input));
    }

    public int maxConsecutiveOnes(int[] arr) {
        int max = 0;
        boolean startIncluded = false;
        int startMax = 0;
        int current = 0;

        for (int i = 0; i < arr.length; i++) {

            if (i == 0 && arr[i] == 1) {
                startIncluded = true;
            }
            if (arr[i] == 1) {
                current++;
                if (startIncluded) {
                    startMax++;
                }
                if (i == arr.length - 1 && !startIncluded && max < (startMax + current)) {
                    max = startMax + current;
                }
            } else {
                if (max < current) {
                    max = current;
                }
                current = 0;
                startIncluded = false;
            }
        }

        return max;
    }
}
