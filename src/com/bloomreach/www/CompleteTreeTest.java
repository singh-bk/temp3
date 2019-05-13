package com.bloomreach.www;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.hp.binarytree.TreeNode;

public class CompleteTreeTest {

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
		TreeNode node14 = new TreeNode(240, null, null);
		
		insertViaBFS(root,node1);
		insertViaBFS(root,node2);
		insertViaBFS(root,node3);
		insertViaBFS(root,node4);
		insertViaBFS(root,node5);
		//insertViaBFS(root,node6);
		insertViaBFS(root,node7);
		insertViaBFS(root,node8);
		insertViaBFS(root,node9);
		insertViaBFS(root,node10);
		insertViaBFS(root,node11);
		insertViaBFS(root,node12);
		insertViaBFS(root,node13);
		//insertViaBFS(root,node14);
		print(root);
	}
	
	public static void insert(TreeNode root, TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		boolean added = false;
		int maxLevel = 0;
		int currentLevel = 0;
		while(!stack.isEmpty()){
			TreeNode peek = stack.peek();
			TreeNode left = peek.getLeftNode();
			TreeNode right = peek.getRightNode();
			
			if(left !=null && right == null){
				peek.setRightNode(node);
				added = true;
				System.out.println("Added in first iteration:"+node.getData());
				break;
			}
			else if(left !=null && right != null){
				if(!left.isVisited()){
					stack.push(left);
					currentLevel++;
					if(maxLevel < currentLevel) maxLevel = currentLevel;
				} 
				else if(!right.isVisited()){
					stack.push(right);
					currentLevel++;
				}else{
					TreeNode pop = stack.pop();
					pop.setVisited(true);
					currentLevel--;
				}
			}
			else if(left == null && right == null){
				if(currentLevel < maxLevel){
					peek.setLeftNode(node);
					added = true;
					break;
				}else{
					TreeNode pop = stack.pop();
					pop.setVisited(true);
					currentLevel--;
				}
				
			}
		}
		if(!added){
			stack.push(root);
			while(true){
				TreeNode nodeX = stack.peek();
				TreeNode left = nodeX.getLeftNode();
				if(left == null){
					nodeX.setLeftNode(node);
					added = true;
					System.out.println("Added in second iteration:"+node.getData());
					break;
				}else{
					stack.push(left);
				}
			}
		}
		clearVisited(root);
		System.out.println();
	}
	
	public static void clearVisited(TreeNode node){
		if(node!=null)
		{
			clearVisited(node.getLeftNode());
			System.out.print(node.getData()+" ");
			node.setVisited(false);
			clearVisited(node.getRightNode());
		}
	}
	
	public static void insertViaBFS(TreeNode root, TreeNode node){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(true){
			TreeNode poll = queue.poll();
			TreeNode left = poll.getLeftNode();
			TreeNode right = poll.getRightNode();
			if(left == null){
				poll.setLeftNode(node);
				break;
			}else if(right == null){
				poll.setRightNode(node);
				break;
			}else{
				queue.add(left);
				queue.add(right);
			}
		}
	}
	
	public static void print(TreeNode node){
		if(node!=null)
		{
			print(node.getLeftNode());
			System.out.print(node.getData()+" ");
			print(node.getRightNode());
		}
	}
	
}
