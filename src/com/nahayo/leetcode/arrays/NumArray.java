package com.nahayo.leetcode.arrays;

/**Space O(n) & Time (n + q) - n is length of input array and q is number queries on sumRange method**/
public class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        //we will store prefixes of input array -> prefix's being the sum of the running total of the array elements.
        prefix = new int[nums.length];

        int sum = 0;
        for(int i = 0; i < nums.length; i++) { //here we are simply looping through nums array and saving prefix's of each element.
            sum += nums[i];
            prefix[i] = sum;
        }
    }

    //this calculates the left and right ranges - using indexes
    public int sumRange(int left, int right) {
        int leftSum = (left > 0) ? prefix[left - 1] : 0; //edge case condition for when left < 0  we simply set to 0. Otherwise, always take the left - 1 number
        int rightSum = prefix[right]; //setting right prefix from pre calculates prefix array.
        return rightSum - leftSum; //to get sum range we subtract right & left.
    }
}
