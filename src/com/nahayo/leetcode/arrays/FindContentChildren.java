package com.nahayo.leetcode.arrays;

import java.util.Arrays;

public class FindContentChildren {

    /**Space O(1) & Time 0(n logn)**/
    public int findContentChildren(int[] g, int[] s) {
        // g: greed factors of children
        // s: sizes of cookies

        // Use two pointers to traverse g and s after sorting
        int l = 0; // pointer for children (greed array)
        int m = 0; // pointer for cookies (size array)

        // Sort both arrays — O(n log n)
        Arrays.sort(g);
        Arrays.sort(s);

        // Try to satisfy as many children as possible
        while (l < g.length && m < s.length) {
            // If the current cookie can satisfy the current child,
            // move to the next child
            if (g[l] <= s[m]) {
                l++;
            }
            // Move to the next cookie in either case
            m++;
        }

        // l represents the number of children satisfied
        return l;
    }
}
