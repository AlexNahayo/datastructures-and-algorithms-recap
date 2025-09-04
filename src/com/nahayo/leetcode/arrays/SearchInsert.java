package com.nahayo.leetcode.arrays;

public class SearchInsert {

    /**Space (1) & Time (log(O))**/
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle; //we will return index of item here if it exists otherwise
            }
            //check value is in the left partition
            if (target < nums[middle]) {
                right= middle - 1;
            } else {
            //value is in the right partition
                left = middle + 1;
            }
        }
        return left; //binary search except you are sending left instead - 1;
    }

}
