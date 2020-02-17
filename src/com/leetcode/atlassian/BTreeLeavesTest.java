package com.leetcode.atlassian;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.atlassian.BTreeLeaves.TreeNode;

public class BTreeLeavesTest {

    public static void main(String[] args) {
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        final BTreeLeaves obj = new BTreeLeaves();
        final TreeNode root = obj.prepareInput();
        obj.findLeafLevel(result, root);
        System.out.println(result);
        System.out.println(obj.findDepth(root));
    }
}
