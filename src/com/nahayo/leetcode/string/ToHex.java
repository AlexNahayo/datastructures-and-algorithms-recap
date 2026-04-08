package com.nahayo.leetcode.string;

public class ToHex {

    /***Time O(1) & Space O(1)***/
    public String toHex(int num) {

        // If number is 0, return "0"
        if (num == 0) {
            return "0";
        }

        // Hex characters
        char[] hex = "0123456789abcdef".toCharArray();

        // Use long to handle negative numbers
        long n = num;

        // If negative, convert to unsigned 32-bit value
        if (n < 0) {
            n += (1L << 32); // 2^32
        }

        // Store result
        StringBuilder result = new StringBuilder();

        // Convert using division
        while (n > 0) {
            int remainder = (int)(n % 16); // get last hex digit
            result.append(hex[remainder]); // convert to hex char
            n = n / 16; // divide by 16
        }

        // reverse because digits were added backwards
        return result.reverse().toString();
    }

}
