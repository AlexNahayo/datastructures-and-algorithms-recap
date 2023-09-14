package com.nahayo.tree;

public class AVLTree {

    private AVLNode root;
    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value=" + this.value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }
        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        }
        else {
            root.rightChild = insert(root.rightChild, value);
        }
        return root;
    }
}
