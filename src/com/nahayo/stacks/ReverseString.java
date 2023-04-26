package com.nahayo.stacks;

import java.util.Stack;

public class ReverseString {
    public String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder reversed = new StringBuilder();
        if (str == null) {
        throw new IllegalArgumentException();
        } else {
            for (char c : str.toCharArray()) {
                stack.push(c);
            }
            while (!stack.isEmpty()) {
                reversed.append(stack.pop());
            }
        }
        return reversed.toString();
    }
}