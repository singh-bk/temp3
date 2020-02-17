package com.uber.www;

public class BinarySearchWithoutRecursion {
    
    public static void main(String[] args) {
        final int[][] input = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        //final int[][] input = {{}};
        
        final int target = 3;
        final BinarySearchWithoutRecursion obj = new BinarySearchWithoutRecursion();
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
        
        int start = 0;
        int end = row*col -1;
        
        while(start <= end) {
            final int mid = (start+end)/2;
            final int rIndex = mid/col;
            final int cIndex = mid%col;
            if(matrix[rIndex][cIndex] == target) {
                return true;
            }
            else if(matrix[rIndex][cIndex] > target) {
                end = mid-1;
            }else if(matrix[rIndex][cIndex] < target){
                start = mid+1;
            }
        }
        
        return false;
    }




}
