package com.facebook.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import www.graph.util.Graph;
import www.graph.util.GraphNode;

public class PowerSetTest {

	public static void main(String[] args){
		int[] input = {1,2,3,4,5};
		int[] powerset = {};
		Graph graph = new Graph();
		for(int i=0;i<input.length;i++)
		{
			GraphNode node = new GraphNode(input[i],null);
			graph.addVertex(node);
		}
		//Add adjacency matrix to the graph.
		HashSet<GraphNode> nodeSet = graph.getVertices();
		System.out.println(nodeSet.size());
		Iterator<GraphNode> iter = nodeSet.iterator();
		while(iter.hasNext())
		{
			GraphNode node = iter.next();
			Iterator<GraphNode> iter2 = nodeSet.iterator();
			while(iter2.hasNext())
			{
				GraphNode node2 = iter2.next();
				if(node2.getData() > node.getData())
				{
					node.addAdjacenyNode(node2);
				}
			}
			if(node.getAdjacencyList() != null)
				System.out.print(node.getAdjacencyList().size()+" ");
		}
		
		iter = nodeSet.iterator();
		while(iter.hasNext())
		{
			GraphNode node = iter.next();
			ArrayList<GraphNode> adjacacenyList = node.getAdjacencyList();
			if(adjacacenyList!=null)
			{
				int i=0;
				while(i<adjacacenyList.size() && adjacacenyList.get(i) != null)
				//for(int i=0; i<adjacacenyList.size();i++)
				{
					GraphNode node1 = adjacacenyList.get(i);
					System.out.print("("+node.getData()+","+node1.getData()+") ");
					i++;
				}
				i=0;
			}
		}
	}
}
