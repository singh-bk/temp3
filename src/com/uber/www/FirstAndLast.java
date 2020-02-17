package com.uber.www;

public class FirstAndLast {

    public static void main(String[] args) {
        final FirstAndLast obj = new FirstAndLast();
        // final int[] nums = {5,7,7,8,8,10};
        final int[] nums = {2, 2};
        final int target = 2;
        obj.searchRange(nums, target);

    }


    public int[] searchRange(int[] nums, int target) {
        final int len = nums.length;
        final int[] op = new int[2];
        op[0] = -1;
        op[1] = -1;
        if (len > 0) binarySearch(nums, 0, len - 1, target, op);
        System.out.println(op[0]);
        System.out.println(op[1]);
        return op;
    }

    public void binarySearch(int[] nums, int start, int end, int target, int[] op) {
        final int mid = (start + end) / 2;

        if (target < nums[mid] && start <= mid - 1) {
            binarySearch(nums, start, mid - 1, target, op);
        }
        if (target > nums[mid] && mid + 1 <= end) {
            binarySearch(nums, mid + 1, end, target, op);
        }
        if (target == nums[mid]) {
            if (mid > 0 && nums[mid - 1] == target && start <= mid - 1) {
                binarySearch(nums, start, mid - 1, target, op);
            } else {
                if (!(op[0] != -1 && op[0] < mid)) {
                    op[0] = mid;
                }
            }
            if (mid + 1 < nums.length && nums[mid + 1] == target && mid + 1 <= end) {

                binarySearch(nums, mid + 1, end, target, op);
            } else {
                if (!(op[0] != -1 && op[1] > mid)) {
                    op[1] = mid;
                }
            }
        }
    }
}
