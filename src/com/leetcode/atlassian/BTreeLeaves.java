package com.leetcode.atlassian;

import java.util.ArrayList;
import java.util.List;

public class BTreeLeaves {

    public TreeNode prepareInput() {
        final TreeNode root = new TreeNode();
        root.val = 1;
        final TreeNode node2 = new TreeNode();
        node2.val = 2;
        final TreeNode node3 = new TreeNode();
        node3.val = 3;
        final TreeNode node4 = new TreeNode();
        node4.val = 4;
        final TreeNode node5 = new TreeNode();
        node5.val = 5;
        final TreeNode node6 = new TreeNode();
        node6.val = 6;
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node6;
        return root;
    }

    public int findLeafLevel(List<List<Integer>> list, TreeNode root) {
        if (root == null) {
            return -1;
        }
        final int left = findLeafLevel(list, root.left);
        final int right = findLeafLevel(list, root.right);
        final int curr = Math.max(left, right) + 1;
        if (list.size() <= curr) {
            list.add(new ArrayList<Integer>());
        }
        list.get(curr).add(root.val);
        return curr;
    }
    
    public int findDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }else {
            return Math.max(findDepth(root.left), findDepth(root.right))+1;
        }
    }

    public int getDiameter(TreeNode root) {
        if(root ==null) {
            return -1;
        }
        if(root.left ==null && root.right ==null) {
            return 1;
        }else {
            final int currentDiameter = findDepth(root.left) +1 + findDepth(root.right)+1;
            System.out.println("node:"+root.val+" diameter:"+currentDiameter);
            
        }
    }
    

    class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;
    }
}
