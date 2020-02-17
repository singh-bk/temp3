package com.leetcode.salesforce;

import com.leetcode.salesforce.ValidateBTree.TreeNode;

public class ValidateBTreeTest {

    public static void main(String[] args) {
        final ValidateBTree obj = new ValidateBTree();
        final int[] input = {2,1,3};
        final TreeNode root = obj.prepareInput(input);
        System.out.println(obj.isValidBST(root));
        System.out.println(obj.getHeight(root));
    }
}
