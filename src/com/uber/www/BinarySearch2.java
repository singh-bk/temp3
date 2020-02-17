package com.uber.www;

public class BinarySearch2 {
    
    public static void main(String[] args) {
        //final int[][] input = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        final int[][] input = {{}};
        final int target = 13;
        final BinarySearch2 obj = new BinarySearch2();
        System.out.println(obj.searchMatrix(input, target));
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = 0;
        if (matrix.length > 0) {
            row = matrix.length;
            if (matrix[0].length > 0) {
                col = matrix[0].length;
            }
        }
        if (row == 0 || col == 0) {
            return false;
        }
        return binarySearch(matrix, 0, row * col - 1, target);
    }

    public boolean binarySearch(int[][] matrix, int start, int end, int target) {
        final int mid = (start + end) / 2;
        final int rlen = matrix.length;
        final int clen = matrix[0].length;
        final int row = (mid / clen);
        final int col = mid % clen;

        if (matrix[row][col] == target) {
            return true;
        }
        if (matrix[row][col] < target && mid + 1 <= end) {
            return binarySearch(matrix, mid+1, end, target);
        }
        if (matrix[row][col] > target && mid - 1 >= start) {
            return binarySearch(matrix, start, mid-1, target);
        }
        return false;
    }
}
