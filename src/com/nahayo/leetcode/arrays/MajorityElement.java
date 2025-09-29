package com.nahayo.leetcode.arrays;

public class MajorityElement {

    /**Space (1) & Time (n)**/
        public static int majorityElement(int[] nums) {
            // Step 1: Initialize
            int majority = nums[0]; // start with the first element as the majority candidate
            int vote = 1;           // candidate has 1 vote initially

            // Step 2: Traverse the array
            for (int i = 1; i < nums.length; i++) {

                if (vote == 0) {
                    // No current candidate → set new candidate
                    majority = nums[i];
                    vote = 1;
                } else if (majority == nums[i]) {
                    // If current element matches the candidate, increment vote
                    vote++;
                } else {
                    // If current element differs, decrement vote
                    vote--;
                }
            }
            // Step 3: Return the majority candidate
            // The problem guarantees that a majority element exists,
            // so 'majority' will be the correct answer.
            return majority;
        }
}
