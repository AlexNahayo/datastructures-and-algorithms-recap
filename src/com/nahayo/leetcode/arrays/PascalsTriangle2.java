package com.nahayo.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    /**Space 0(n) & Time O(n^2)**/
    public static List<Integer> getRow(int rowIndex) {
        // Declare the array that will store the row of Pascal's triangle
        List<Integer> row = new ArrayList<>();

        // The very first row is always [1]
        row.add(1);

        // Outer loop: build rows one by one until reaching rowIndex(the row we are looking for)
        for (int i = 1; i <= rowIndex; i++) {
            // Insert 0 at the beginning (shifts everything right)
            // This makes it easy to calculate the next row in-place
            row.add(0, 0);

            // Inner loop: update values in one pass (from left to right)
            for (int j = 0; j < i; j++) {
                // Each element is sum of the element at j and j+1
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }

        // After finishing, row contains the correct rowIndex row
        return row;
    }
}
