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

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if(root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if(root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root){
        if(root == null)
            return;
        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root){
        if(root == null)
            return -1;
        if(isLeafNode(root))
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeafNode(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    public int minInBinarySearchTree(){
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public int min(){
        return min(root);
    }

    private int min(Node root){
        if(isLeafNode(root)){
            return root.value;
        }
        var left = min(root.leftChild);
        var right = min(root.leftChild);

        return Math.min(Math.min(left,right), root.value);
    }
}
