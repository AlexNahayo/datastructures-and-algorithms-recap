package com.nahayo.trie;

public class Trie {
    Node root;
    private class Node {
        char ch;
        Node[] children = new Node[26];
        boolean isEndOfWord;
    }
}
