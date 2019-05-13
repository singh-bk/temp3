package com.olacabs.www;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.hp.binarytree.TreeNode;

public class MirrorTreeTest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(100, null, null);
		TreeNode node1 = new TreeNode(60, null, null);
		TreeNode node2 = new TreeNode(180, null, null);
		TreeNode node3 = new TreeNode(30, null, null);
		TreeNode node4 = new TreeNode(80, null, null);
		TreeNode node5 = new TreeNode(140, null, null);
		TreeNode node6 = new TreeNode(200, null, null);
		TreeNode node7 = new TreeNode(10, null, null);
		TreeNode node8 = new TreeNode(50, null, null);
		TreeNode node9 = new TreeNode(70, null, null);
		TreeNode node10 = new TreeNode(90, null, null);
		TreeNode node11 = new TreeNode(120, null, null);
		TreeNode node12 = new TreeNode(160, null, null);
		TreeNode node13 = new TreeNode(40, null, null);

		root.setLeftNode(node1);
		root.setRightNode(node2);
		node1.setLeftNode(node3);
		node1.setRightNode(node4);
		node2.setLeftNode(node5);
		node2.setRightNode(node6);
		node3.setLeftNode(node7);
		node3.setRightNode(node8);
		node4.setLeftNode(node9);
		node4.setRightNode(node10);
		node5.setLeftNode(node11);
		node5.setRightNode(node12);
		node8.setLeftNode(node13);
		dfs(root, 70);
	}
	
	public static void createMirror(TreeNode root){
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue1.add(root);
		boolean first = true;
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			if(first){
				TreeNode node = queue1.poll();
			}
		}
	}
	
	public static void dfs(TreeNode root, int value){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		boolean found = false;
		if(root.getData() == value){
			System.out.println("Found");
		}
		else{
			System.out.print(root.getData()+ " ");
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				TreeNode right = node.getRightNode();
				TreeNode left = node.getLeftNode();
				if(right != null && right.getData() == value){
					System.out.println("Found");
					break;
				}else if(left != null && left.getData() == value){
					System.out.println("Found");
					break;
				}
				else{
					if(right != null){
						stack.push(right);
						System.out.print(right.getData()+" ");
					}
					if(left != null){
						stack.push(left);
						System.out.print(left.getData()+ " ");
					}
				}
			}
		}
	}
	
	public static void dfs2(TreeNode root, int value){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode lastPopped = null;
		stack.push(root);
		boolean found = false;
		if(root.getData() == value){
			System.out.println("Found");
		}
		else{
			System.out.print(root.getData()+ " ");
			while (!stack.isEmpty()) {
				TreeNode node = stack.peek();
				TreeNode left = node.getLeftNode();
				
				if(left != null){
					if(left.getData() == value){
						System.out.println("Found");
						break;
					}else{
						stack.push(left);
					}
				}else if(node.getRightNode() != null){
					TreeNode right = node.getRightNode();
					if(right.getData() == value){
						System.out.println("Found");
						break;
					}
				}
			}
		}
	}
}
