package com.nahayo.leetcode.string;

public class AddStrings {

    /***Time O(n) & Space O(n)***/
    public String addStrings(String num1, String num2) {

        // This will store the sum of digits + carry
        int sum = 0;

        // Pointer for the end of num1 (rightmost digit)
        int i = num1.length() - 1;

        // Pointer for the end of num2 (rightmost digit)
        int j = num2.length() - 1;

        // StringBuilder is used because strings are immutable in Java
        // We build the answer in reverse order
        StringBuilder sb = new StringBuilder();

        // Continue while there are still digits in either string
        while (i >= 0 || j >= 0) {

            // If num1 still has digits left
            if (i >= 0) {
                // Convert char digit to int and add to sum
                // '0' subtraction converts char to numeric value
                sum += num1.charAt(i) - '0';

                // Move to next digit (left side)
                i--;
            }

            // If num2 still has digits left
            if (j >= 0) {
                // Convert char digit to int and add to sum
                sum += num2.charAt(j) - '0';

                // Move to next digit (left side)
                j--;
            }

            // Append last digit of sum to result
            // (sum % 10 gives the current digit)
            sb.append(sum % 10);

            // Carry for next iteration
            // (sum / 10 gives carry value)
            sum = sum / 10;
        }

        // If there is still a carry left after loop
        if (sum > 0) {
            sb.append(sum);
        }

        // Reverse the result because digits were added backwards
        return sb.reverse().toString();
    }
}
