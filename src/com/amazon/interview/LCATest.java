package com.amazon.interview;

import java.util.List;

import com.hp.binarytree.BinarySearchTree;
import com.hp.binarytree.TreeNode;

public class LCATest {

	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(8);
		bst.insert(4);
		bst.insert(12);
		bst.insert(3);
		bst.insert(6);
		bst.insert(1);
		bst.insert(2);
		bst.insert(5);
		bst.insert(7);
		bst.insert(10);
		bst.insert(14);
		bst.insert(14);
		bst.insert(9);
		bst.insert(11);
		bst.insert(13);
		bst.insert(15);
		bst.inorderDisplay(bst.getRoot());
		System.out.println();
		bst.preorderDisplay(bst.getRoot());
		System.out.println();
		bst.postOrderDisplay(bst.getRoot());
		//System.out.println(bst.getParent(15).getData());
		//System.out.println(bst.getParent(10).getData());
		int data1 = 7;
		int data2 = 1;
		List<TreeNode> ancestors1 = bst.getAncestors(data1);
		System.out.println();
		System.out.print("Ancestors for 15:");
		for(int i=0;i<ancestors1.size();i++)
		{
			System.out.print(ancestors1.get(i).getData()+" ");
		}
		List<TreeNode> ancestors2 = bst.getAncestors(data2);
		System.out.println();
		System.out.print("Ancestors for 9:");
		for(int i=0;i<ancestors2.size();i++)
		{
			System.out.print(ancestors2.get(i).getData()+" ");
		}
		TreeNode root = bst.getRoot();
		if((data1>root.getData() && data2<root.getData()) || (data1>root.getData() && data2<root.getData()) 
				|| data1==root.getData() || data2==root.getData())
		{
			System.out.println("Least Common Ancestor:"+root.getData());
		}
		else
		{
			
		}
	}
}
