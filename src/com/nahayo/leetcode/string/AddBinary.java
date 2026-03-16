package com.nahayo.leetcode.string;

public class AddBinary {

    /***Time O(n) & Space O(n)***/
    public String addBinary(String a, String b) {

        // StringBuilder is used to efficiently build the resulting binary string
        // (Strings in Java are immutable, so repeated concatenation would be slower)
        StringBuilder result = new StringBuilder();

        // Pointers starting at the end of each string (rightmost binary digit)
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Carry value used during binary addition
        int carry = 0;

        // Continue looping while there are still digits to process
        // OR if a carry still needs to be added
        while (i >= 0 || j >= 0 || carry != 0) {

            // Start sum with the carry from the previous step
            int sum = carry;

            // If we still have digits left in string 'a'
            if (i >= 0) {
                // Convert char ('0' or '1') to integer (0 or 1)
                sum += a.charAt(i) - '0';

                // Move pointer left
                i--;
            }
            // If we still have digits left in string 'b'
            if (j >= 0) {
                // Convert char ('0' or '1') to integer (0 or 1)
                sum += b.charAt(j) - '0';

                // Move pointer left
                j--;
            }

            // The resulting binary digit is sum % 2
            // (same as how binary addition works)
            result.append(sum % 2);

            // Compute new carry (either 0 or 1)
            carry = sum / 2;
        }

        // Digits were added from right → left, so reverse the result
        return result.reverse().toString();
    }
}
