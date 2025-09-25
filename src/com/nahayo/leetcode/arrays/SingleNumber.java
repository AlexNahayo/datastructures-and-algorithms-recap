package com.nahayo.leetcode.arrays;

public class SingleNumber {

    /**Space (1) & Time (n)**/
    public static int singleNumber(int[] nums) {
        int num = nums[0]; //variable to store xor result of a

        // xor the element with the previous value;
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }

        //return the result
        return num; //by the accumative law you will end up with a single value if available
    }
}
