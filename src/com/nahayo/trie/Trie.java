package com.nahayo.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private Node root = new Node(' ');

    private static class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    public void insert(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word != null) {
            var current = root;
            for (var ch : word.toCharArray()) {
                if (!current.hasChild(ch)) {
                    return false;
                }
                current = current.getChild(ch);
            }
            return current.isEndOfWord;
        }
        return false;
    }

    public void traverse(Node root) {
        //Pre-Order: visit the root first
        System.out.println(root.value);

        for (var child: root.getChildren()) {
            traverse(child);
        }
    }

    public void remove(String word) {
        if (word == null){
            return;
        }
        remove(root, word, 0);
    }
    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) {
            return;
        }

        remove(child, word, index + 1);

        //at this point were visit all the child nodes and are at the parent.
        //at this point we need to check if this child node has any children & its not an end of another world we can remove.
        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }

    public List<String> findWords(String prefix) {
        //finding the last node of the prefix.
        List<String> words = new ArrayList<>();
        var lastNode = findLastNode(prefix);
        findWords(lastNode, prefix, words);

        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if (root == null) {
            return;
        }
        //as we call this method recursively we'll populate this word which we will discover in words List.
        if (root.isEndOfWord)
            words.add(prefix);

        for (var child : root.getChildren()) {
            findWords(child, prefix + child.value, words);
        }
    }

    private Node findLastNode(String prefix) {
        if (prefix == null) {
            return null;
        }
        var current = root;
        for (var ch : prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null) {
                return null;
            }
            current = child;
        }
        return current;
    }
}
