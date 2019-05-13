package com.hp.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.hp.util.Pair;

public class DepthOfAllNodeTest {

	public static void main(String[] args){
		BinaryNode root = new BinaryNode(30);
		BinaryNode node1 = new BinaryNode(23);
		BinaryNode node2 = new BinaryNode(56);
		BinaryNode node3 = new BinaryNode(20);
		BinaryNode node4 = new BinaryNode(27);
		BinaryNode node5 = new BinaryNode(40);
		BinaryNode node6 = new BinaryNode(65);
		BinaryNode node7 = new BinaryNode(77);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
		node6.setRight(node7);
		PrintDepth(root);
	}
	
	/**
	 * Print Depth of All Nodes using Breadth First.
	 * Use two stacks
	 * 		Stack1 will store the nodes of levels 0,2,4,6 etc
	 * 		Stack2 will store the ndoes of levels 1,3,5,7 etc
	 * @param node
	 */
	public static void PrintDepth(BinaryNode node){
		BinaryNode root = node;
		Stack<BinaryNode> stack1 = new Stack<BinaryNode>();
		Stack<BinaryNode> stack2 = new Stack<BinaryNode>();
		stack1.push(root);
		int count = -1;
		List<Pair<BinaryNode, Integer>> pairList = new ArrayList<Pair<BinaryNode, Integer>>();
		
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			
			if(!stack1.isEmpty())
			{
				count++;
				while(!stack1.isEmpty())
				{
					BinaryNode node1 = stack1.pop();
					Pair<BinaryNode, Integer> pair = new Pair<BinaryNode, Integer>(node1, count);
					pairList.add(pair);
					if(node1.getLeft() != null)
					{
						stack2.push(node1.getLeft());
					}
					if(node1.getRight() != null)
					{
						stack2.push(node1.getRight());
					}
				}
			}
			if(!stack2.isEmpty())
			{
				count++;
				while(!stack2.isEmpty())
				{
					BinaryNode node1 = stack2.pop();
					Pair<BinaryNode, Integer> pair = new Pair<BinaryNode, Integer>(node1, count);
					pairList.add(pair);
					if(node1.getLeft() != null)
					{
						stack1.push(node1.getLeft());
					}
					if(node1.getRight() != null)
					{
						stack1.push(node1.getRight());
					}
				}
			}
		}// end while
		
		System.out.println(pairList.size());
		for(int i=0;i<pairList.size();i++){
			System.out.println(pairList.get(i).getK().getValue()+" "+pairList.get(i).getV());
		}
	}
}
