package com.nahayo.leetcode.string;

public class IsSubsequence {

    /***Time O(n + m) & Space O(n + m)***/
    /**where n is length of s and m is length of t**/
    public boolean isSubsequenceBruteForce(String s, String t) {

        // If s is empty, it's always a subsequence
        if (s.length() == 0) {
            return true;
        }

        // If t is empty but s is not, s cannot be a subsequence
        if (t.length() == 0) {
            return false;
        }

        // Convert both strings to character arrays for easier access
        char[] charArray = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // This variable tracks our current position in s
        int count = 0;

        // Iterate through t
        for (int i = 0; i < charArrayT.length; i++) {

            // If current character in t matches current character in s
            // increment count to move to next character in s
            if (charArrayT[i] == charArray[count]) {
                count++;
            }

            // If we've matched all characters in s, return true
            if (count == charArray.length) {
                return true;
            }
        }

        // If we finish looping through t without matching all of s
        // then s is not a subsequence of t
        return false;
    }

    /***Time O(m) & Space O(1)***/
    /**where  m is length of t**/
    public boolean isSubsequenceOptSol(String s, String t) {

        // If s is empty, it's always a subsequence
        if (s.length() == 0) {
            return true;
        }

        // If t is empty but s is not, s cannot be a subsequence
        if (t.length() == 0) {
            return false;
        }

        // This pointer tracks our current position in string s
        int count = 0;

        //If current character in t matches current character in s
        // increment count to move to next character in s
        for (int i = 0; i < t.length(); i++) {

            if (t.charAt(i) == s.charAt(count)) {
                // Move pointer forward in s
                count++;
            }
        }

        // If we matched all characters in s, then s is a subsequence of t
        return count == s.length();
    }
}
