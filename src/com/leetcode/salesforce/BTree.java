package com.leetcode.salesforce;

public class BTree {

    class Node {
        int  val;
        Node left;
        Node right;
    }

    public int getHeight(Node node) {
        if (node.left == null && node.right == null) {
            return 0;
        } else if (node.left != null && node.right != null) {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        } else if (node.left != null) {
            return getHeight(node.left) + 1;
        } else if (node.right != null) {
            return getHeight(node.right) + 1;
        } else {
            return 0;
        }

    }
}
