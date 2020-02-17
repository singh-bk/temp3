package com.uber.www;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Codec {

    public static void main(String[] args) {
        final Codec codec = new Codec();
        final TreeNode root = new TreeNode(1);
        final TreeNode node2 = new TreeNode(2);
        final TreeNode node3 = new TreeNode(3);
        final TreeNode node4 = new TreeNode(4);
        final TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(codec.serialize(root));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final StringBuilder sb = new StringBuilder("");
        final Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        final Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        boolean nonNullElem1 = false;
        boolean nonNullElem2 = false;
        if (root != null) {
            queue1.add(root);
            nonNullElem1 = true;
        }
        while (!queue1.isEmpty() || !queue2.isEmpty()) {

            while (!queue1.isEmpty()) {

                final TreeNode current = queue1.poll();
                if (nonNullElem1) {
                    if (current != null) {
                        sb.append(current.val);
                        queue2.add(current.left);
                        queue2.add(current.right);
                        if (current.left != null || current.right != null) {
                            nonNullElem2 = true;
                        } else {
                            nonNullElem2 = false;
                        }
                    } else {
                        sb.append("null");
                    }
                }
            }

            while (!queue2.isEmpty()) {
                final TreeNode current = queue2.poll();
                if (nonNullElem2) {
                    if (current != null) {
                        sb.append(current.val);
                        queue1.add(current.left);
                        queue1.add(current.right);
                        if (current.left != null || current.right != null) {
                            nonNullElem1 = true;
                        } else {
                            nonNullElem1 = false;
                        }
                    } else {
                        sb.append("null");
                    }
                }
            }
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
