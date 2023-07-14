package com.nahayo.tree;


public class Tree {
    private Node root;

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        while (true){
            if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean value(int value){
        if (root == null) {
            return false;
        }
        Node current = root;
        while (true) {
            if (value == current.value) {
                return true;
            } else {
                if (value < current.value) {
                    if (current.leftChild == null) {
                        return false;
                    }
                    current = current.leftChild;
                } else {
                    if (current.rightChild == null) {
                        return false;
                    }
                    current = current.rightChild;
                }
            }
        }
    }
}
