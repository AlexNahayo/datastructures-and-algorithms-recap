package com.nahayo.tree;


public class Tree {

    Node root;
    private class Node {
        private int value;

        Node leftChild;

        Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    public Tree(Node root) {
        this.root = root;
    }

    //Todo  
    public void insert(int value){
        Node pointer;
        if(root.value == 0) {
            root.value = value;
        }
        else {
            var newNode = new Node(value);
            // pointer needs to start at root
            // check value of current node you are pointing to
            // 1. if value > than current node value then
            //  a) if the current node.rightChild == null then point, right child to current pointer node -- point new node to current pointer, then current pointer to new node.
            //  b) if the current node.rightChild != null then keep drilling down until you get to
            // 2. if value < than current node value then
            //  a) if the current node.leftChild == null then point, left child to current pointer node -- point new node to current pointer, then current pointer to new node.
            //  b) if the current node.leftChild != null then keep drilling down until you get to
            pointer = this.root;
            while (pointer.leftChild != null || pointer.rightChild !=null){
                if(pointer.value > newNode.value) {
                    pointer = pointer.rightChild;
                }
                else if (pointer.value < newNode.value) {
                    pointer = pointer.leftChild;
                }
            }
        }

    }

    //Todo
    public boolean value(int value){
        return true;
    }

}
