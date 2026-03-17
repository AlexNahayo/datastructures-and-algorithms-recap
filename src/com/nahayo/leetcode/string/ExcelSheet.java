package com.nahayo.leetcode.string;

public class ExcelSheet {

    /***Time O(log n) & Space O(log n)***/
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        // Convert the column number to Excel-style letters
        while (columnNumber > 0) {
            columnNumber--; // Adjust for 0-indexing (Excel columns start at 1)

            // Get the current character for this "digit"
            char c = (char) (columnNumber % 26 + 'A');

            // Move to the next "digit"
            columnNumber /= 26;

            result.append(c);
        }
        // Reverse the result since we constructed it backwards
        return result.reverse().toString();
    }

    /***Time O(n) & Space O(n)***/
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.isEmpty()) {
            return -1; // Handle null or empty input
        }

        int result = 0;
        for (char c : columnTitle.toCharArray()) {
            // Convert char to number: 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26
            result = result * 26 + (c - 'A' + 1);
        }

        return result;
    }

    /***Time O(n) & Space O(1)***/
    public int titleToNumberCleanSol(String columnTitle) {
        if (columnTitle == null || columnTitle.isEmpty()) {
            return -1; // Handle null or empty input
        }

        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            result = result * 26 + (c - 'A' + 1);
        }

        return result;
    }
}
