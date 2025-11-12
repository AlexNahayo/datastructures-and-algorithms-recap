package com.nahayo.leetcode.arrays;

public class ThirdMax {

    /**Space O(1) & Time 0(n)**/
    public int thirdMax(int[] nums) {

        // We use long instead of int to handle edge cases where
        // all numbers in the array are Integer.MIN_VALUE.
        // Using long.MIN_VALUE helps us differentiate between
        // "no value assigned yet" and legitimate int values.
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        // Loop through each number in the input array
        for (final int num : nums) {

            // Skip duplicates: if num is equal to one of the existing
            // first, second, or third max values, we ignore it.
            // This ensures we only track *distinct* maximums.
            if (num == first || num == second || num == third) {
                continue;
            }

            // Case 1: current number is greater than the first maximum.
            // We shift all existing max values down one position.
            // Example: if num is now the largest,
            // then old first → second, old second → third.
            if (num > first) {
                third = second;
                second = first;
                first = num;
            }

            // Case 2: current number is between first and second maximums.
            // We shift only the second and third down by one.
            else if (num < first && num > second) {
                third = second;
                second = num;
            }

            // Case 3: current number is between second and third maximums.
            // We only update the third maximum.
            else if (num < second && num > third) {
                third = num;
            }
        }

        // If the third maximum was never updated (still Long.MIN_VALUE),
        // it means the array had fewer than 3 distinct numbers.
        // In that case, we return the largest number (first max).
        // Otherwise, return the third distinct maximum.
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
