package com.hp.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hp.util.Pair;
import com.hp.util.Triplet;

public class NearestLeafTest {

	public static void main(String[] args){
		BinaryNode root = new BinaryNode(300);
		BinaryNode node1 = new BinaryNode(23);
		BinaryNode node2 = new BinaryNode(56);
		BinaryNode node3 = new BinaryNode(20);
		BinaryNode node4 = new BinaryNode(27);
		BinaryNode node5 = new BinaryNode(40);
		BinaryNode node6 = new BinaryNode(65);
		BinaryNode node7 = new BinaryNode(77);
		BinaryNode node8 = new BinaryNode(76);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node3.setLeft(node4);
		node4.setLeft(node5);
		node5.setLeft(node6);
		node6.setLeft(node7);
		node6.setRight(node8);
		
		List<Pair<BinaryNode, Integer>> pairs = new ArrayList<Pair<BinaryNode, Integer>>();
		List<Triplet<BinaryNode, Integer, Boolean>> triplet = new ArrayList<Triplet<BinaryNode, Integer, Boolean>>();
		BreadthFirstTravesalToGetRootLeafDistance(root, 0, pairs, triplet);
		System.out.println();
	}
	
	public static List<Pair<BinaryNode, Integer>> BreadthFirstTravesalToGetRootLeafDistance
			(BinaryNode node, int count, List<Pair<BinaryNode, Integer>> pairs, List<Triplet<BinaryNode, Integer, Boolean>> triplet)
{
		if(node.getLeft() == null && node.getRight() == null)
		{
			Pair<BinaryNode, Integer> pair = new Pair<BinaryNode, Integer>(node, count);
			triplet.get
			pairs.add(pair);
		}
		else
		{
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(node);
			while(queue!=null && !queue.isEmpty())
			{
				node = queue.remove();
				if(node.getLeft() == null && node.getRight() == null)
				{ 
					Pair<BinaryNode, Integer> pair = new Pair<BinaryNode, Integer>(node, count);
					pairs.add(pair);
				}
				else
				{
					if(node.getLeft() != null)
						queue.add(node.getLeft());
					if(node.getRight() != null)
						queue.add(node.getRight());
					count++;
				}
			}
		}
		return pairs;
	}
}
