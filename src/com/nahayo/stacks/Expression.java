package com.nahayo.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(','<','{');
    private final List<Character> rightBrackets = Arrays.asList(')','>','}');

    public boolean isABalancedString(String s){
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if(isLeftExpression(ch)){
                stack.push(ch);
            }
            if(isRightExpression(ch)){
                if (stack.isEmpty()) {
                    return false;
                }
                var top = stack.pop();
                if(bracketsMatch(ch, top)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftExpression(char ch){
        return leftBrackets.contains(ch);
    }
    private boolean isRightExpression(char ch){
        return rightBrackets.contains(ch);
    }
    private boolean bracketsMatch(char left, char right){
        return ((left == ')' && right != '(') || (left == '}' && right != '{') || (left == '>' && right != '<'));
    }
}
