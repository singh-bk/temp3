package com.linkedin.www;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ClosestBST272 {

    public static void main(String[] args) {

        final TreeNode root = new TreeNode(4);
        final TreeNode node1 = new TreeNode(2);
        final TreeNode node2 = new TreeNode(5);
        final TreeNode node3 = new TreeNode(1);
        final TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        
        final ClosestBST272 obj = new ClosestBST272();
        obj.closestKValues(root, 3.14, 2);
        
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        final List<Integer> op = new ArrayList<Integer>();
        final PriorityQueue<Double> minHeap = new PriorityQueue<Double>(k+1, new Comparator<Double>() {
            @Override
            public int compare(Double d1, Double d2) {
                if(d1 > d2) {
                    return 1;
                }else if(d2 > d1) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        
        
        final PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(k+1, new Comparator<Double>() {
            @Override
            public int compare(Double d1, Double d2) {
                if(d1 > d2) {
                    return -1;
                }else if(d2 > d1) {
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        
        minHeap.add(target);
        maxHeap.add(target);
        
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            final TreeNode node = queue.remove();
            if(node.val > target) {
                minHeap.add(Double.valueOf(node.val));
            }else if (node.val < target) {
                maxHeap.add(Double.valueOf(node.val));
            }
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        
        minHeap.remove();
        maxHeap.remove();
        for(int i=0;i<k; i++) {
            final int one = minHeap.peek().intValue();
            final int two = maxHeap.peek().intValue();
            if(one - target > target - two) {
                maxHeap.remove();
                op.add(two);
            }else {
                minHeap.remove();
                op.add(one);
            }
        }
        return op;
    }
}


class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
