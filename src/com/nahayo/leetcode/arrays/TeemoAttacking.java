package com.nahayo.leetcode.arrays;

/**Time 0(n) & Space O(1)**/
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        // If there are no attacks, there is no poison time
        if (timeSeries.length == 0) {
            return 0;
        }

        int total = 0;

        // Iterate through all attacks except the last one
        for (int i = 0; i < timeSeries.length - 1; i++) {

            // Time between this attack and the next attack
            int gap = timeSeries[i + 1] - timeSeries[i];

            // If the next attack happens before the poison expires,
            // we only add the gap to avoid double counting.
            // Otherwise we add the full duration.
            total += Math.min(gap, duration);
        }

        // The last attack always contributes its full duration
        return total + duration;
    }
}
