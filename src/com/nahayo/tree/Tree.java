package com.nahayo.tree;


import java.util.ArrayList;
import java.util.List;

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

    public void insert(int value) {
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

    public boolean value(int value) {
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

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if(root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if(root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root) {
        if(root == null)
            return;
        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if(root == null)
            return -1;
        if(isLeafNode(root))
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeafNode(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public int minInBinarySearchTree() {
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public int min() {
        return min(root);
    }

    public int max() {
        return max(root);
    }

    private int min(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE; // or throw an exception if null is invalid
        }

        if(isLeafNode(root)) {
            return root.value;
        }
        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left,right), root.value);
    }

    private int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE; // or throw an exception if null is invalid
        }

        if(isLeafNode(root)) {
            return root.value;
        }
        var left = max(root.leftChild);
        var right = max(root.rightChild);

        return Math.max(Math.max(left,right), root.value);
    }

    public boolean equals(Tree t2) {
        if(t2 == null) {
            return false;
        }
        return identicalTrees(this.root,t2.root);
    }

    private boolean identicalTrees(Node a, Node b) {
        if(a == null && b == null) {
            return true;
        }
        if(a != null && b != null) {
            return (a.value == b.value && identicalTrees(a.leftChild, b.leftChild)
                    && identicalTrees(a.rightChild, b.rightChild));
        }
        return false;
    }

    public boolean isBinarySearchTree() {
       return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.value < min || root.value > max) {
            return false;
        }
        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max) ;
    }

    public ArrayList<Integer> getNodesAtKDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtKDistance(root, distance , list);
        return list;
    }

    public void getNodesAtKDistance(Node root, int distance, ArrayList<Integer> list) {
        if(root == null){
            return;
        }
        if(distance == 0){
            list.add(root.value);
            return;
        }
        getNodesAtKDistance(root.leftChild, distance - 1, list);
        getNodesAtKDistance(root.rightChild, distance - 1,  list);
    }

    public void traverseLevelOrder(){
        for (int i = 0; i <= height() ; i++) {
            for (var value : getNodesAtKDistance(i)) {
                System.out.println(value);
            }
        }
    }

    public  List<Integer> getAncestors(int target) {
        List<Integer> ancestors = new ArrayList<>();
        findAncestors(root, target, ancestors);
        return ancestors;
    }

    private  boolean findAncestors(Node node, int target, List<Integer> ancestors) {
        if (node == null) return false;

        // If current node is the target
        if (node.value == target) return true;

        // If target is found in left or right subtree
        if (findAncestors(node.leftChild, target, ancestors) || findAncestors(node.rightChild, target, ancestors)) {
            ancestors.add(node.value);  // Add current node as an ancestor
            return true;
        }

        return false;  // Target not found in either subtree
    }

}
