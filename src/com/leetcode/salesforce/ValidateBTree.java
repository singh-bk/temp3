package com.leetcode.salesforce;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBTree {

    public TreeNode prepareInput(int[] input) {
        final TreeNode root = new TreeNode(3);
        final TreeNode node1 = new TreeNode(30);
        final TreeNode node2 = new TreeNode(10);
        final TreeNode node3 = new TreeNode(15);
        final TreeNode node4 = new TreeNode(45);
        root.right = node1;
        node1.left = node2;
        node2.right = node3;
        node3.right = node4;
        return root;
    }

    public boolean isValidBST(TreeNode root) {
        final Queue<Tuple> queue1 = new LinkedList<Tuple>();

        final long MIN = Integer.MIN_VALUE - 1;
        final long MAX = Integer.MAX_VALUE + 1;
        if (root != null) {
            queue1.add(new Tuple(root, MIN, MAX));
        }
        while (!queue1.isEmpty()) {
            final Tuple tuple = queue1.remove();
            final TreeNode node = tuple.node;
            if (node.val <= tuple.min || node.val >= tuple.max) {
                return false;
            }
            if (node.left != null) {
                final Tuple l = new Tuple(node.left, tuple.min, node.val);
                queue1.add(l);
            }
            if (node.right != null) {
                final Tuple r = new Tuple(node.right, node.val, tuple.max);
                queue1.add(r);
            }
        }
        return true;
    }

    public boolean isValidBSTRecursive(TreeNode root) {
        final long MIN = Integer.MIN_VALUE - 1;
        final long MAX = Integer.MAX_VALUE + 1;
        if (root == null) {
            return true;
        } else {
            return checkValidBST(root, MIN,MAX);
        }
    }

    public boolean checkValidBST(TreeNode node, long min, long max) {
        if (node.val <= min || node.val >= max) {
            return false;
        } else if (node.left != null && node.right != null) {
            return checkValidBST(node.left, min, node.val) && checkValidBST(node.right, node.val, max);
        } else if (node.left != null) {
            return checkValidBST(node.left, min, node.val);
        } else if (node.right != null) {
            return checkValidBST(node.right, node.val, max);
        } else {
            return true;
        }
    }
    
    public int getHeight(TreeNode node) {
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
    
    public int getDiameter(TreeNode node) {
        if(node.left == null && node.right == null) {
            return 0;
        }else if(node.left != null && node.right != null){
            return getDiameter(node.left) +1 + getDiameter(node.right) +1;
        }else {
            return 0;
        }
    }

    class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int x) {
            val = x;
        }
    }

    class Tuple {
        TreeNode node;
        long     min;
        long     max;

        Tuple(TreeNode h, long a, long b) {
            node = h;
            min = a;
            max = b;
        }
    }
}
