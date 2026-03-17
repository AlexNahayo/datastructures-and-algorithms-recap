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
}
