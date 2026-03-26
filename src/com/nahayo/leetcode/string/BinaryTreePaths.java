package com.nahayo.leetcode.string;

import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        // root can be null
        if (root == null) return result;

        // make string of the root value
        String current_path = Integer.toString(root.val);

        // if root is a leaf node
        if (root.left == null && root.right == null)
            result.add(current_path);

        // recursive calls if children exist
        if (root.left != null)
            dfs(root.left, current_path, result);

        if (root.right != null)
            dfs(root.right, current_path, result);

        return result;
    }

    // helper method for DFS recursion
    public void dfs(TreeNode node, String current_path, List<String> result) {

        // add current node to path
        current_path += "->" + node.val;

        // base case: leaf node
        if (node.left == null && node.right == null) {
            result.add(current_path);
            return;
        }

        // recursive calls if children exist
        if (node.left != null)
            dfs(node.left, current_path, result);

        if (node.right != null)
            dfs(node.right, current_path, result);
    }

}
 */
