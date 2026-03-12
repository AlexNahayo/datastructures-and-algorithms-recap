package com.nahayo.leetcode.string;

import java.util.Stack;

public class ValidParentheses {

    /**Time 0(n) & Space O(n)**/
    public boolean isValid(String s) {

        // Convert the string into a character array for easy traversal
        char[] brackets = s.toCharArray();

        // Stack will store opening brackets we encounter
        // Stack follows LIFO (Last In First Out)
        Stack<Character> sk = new Stack<>();

        // Traverse through every character in the array
        for (int i = 0; i < brackets.length; i++) {

            // If we encounter an opening bracket, push it onto the stack
            if (brackets[i] == '(' || brackets[i] == '{' || brackets[i] == '[') {
                sk.push(brackets[i]);
            }

            // If we encounter a closing bracket
            else if (brackets[i] == ')' || brackets[i] == '}' || brackets[i] == ']') {

                // If stack is empty, there is no matching opening bracket
                if (sk.isEmpty()) {
                    return false;
                }

                // Look at the top element of the stack without removing it
                char top = sk.peek();

                // Check if the top opening bracket matches the current closing bracket
                if ((top == '(' && brackets[i] == ')') ||
                        (top == '{' && brackets[i] == '}') ||
                        (top == '[' && brackets[i] == ']')) {

                    // If it matches, remove the opening bracket from the stack
                    sk.pop();
                } else {
                    // If it doesn't match, the parentheses are invalid
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        // If not empty, there are unmatched opening brackets
        return sk.isEmpty();
    }
}
