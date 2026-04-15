package com.nahayo.leetcode.string;

public class NumberOfSegments {

    /***Time O(n) & Space O(n)***/
    public int countSegments(String s) {
        if (s == null || s.trim().isEmpty()){
            return 0;
        }

        String str[] = s.trim().split("\\s+");

        return str.length;
    }
}
