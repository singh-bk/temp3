package com.microsoft.interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        final List<List<Integer>> op = new LinkedList<List<Integer>>();

        final Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.add(root);
        final Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            final List<Integer> list = new LinkedList<Integer>();
            if (!queue1.isEmpty()) {
                final TreeNode node = queue1.poll();
                list.add(node.val);
                if (node.right != null) {
                    queue2.add(node.right);
                }
                if (node.left != null) {
                    queue2.add(node.left);
                }

            } else {
                final TreeNode node = queue2.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue1.add(node.left);
                }
                if (node.right != null) {
                    queue1.add(node.right);
                }
            }
            op.add(list);
        }
        return op;
    }

    class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
