package www.graph.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class GraphTest {

	public static void main(String[] args)
	{
		int[] input = {1,2,3,4,5};
		Graph graph = new Graph();
		for(int i=0;i<input.length;i++)
		{
			GraphNode node = new GraphNode(input[i],null);
			graph.addVertex(node);
		}
		GraphNode node1 = new GraphNode(6,null);
		graph.addVertex(node1);
		//Add adjacency matrix to the graph.
		HashSet<GraphNode> nodeSet = graph.getVertices();
		System.out.println(nodeSet.size());
		Iterator<GraphNode> iter = nodeSet.iterator();
		GraphNode src = null;
		GraphNode dest = null;
		while(iter.hasNext())
		{
			GraphNode node = iter.next();
			if(node.getData() == 1){
				src = node;
			}
			if(node.getData() == 5){
				dest = node;
			}
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
		Queue<GraphNode> queue = GraphUtil.BreadthFirstTraversal(graph);
		System.out.println("BreadthFirstTraversal:");
		Iterator<GraphNode> qIter = queue.iterator();
		while(qIter.hasNext()){
			System.out.print(qIter.next().getData()+" ");
		}
		GraphUtil.ResetIsVisited(graph);
		System.out.println("Depath First ");
		GraphUtil.DepthFirstTraversal(graph);
		GraphUtil.ResetIsVisited(graph);
		//GraphNode src = graph.getVertices().
		System.out.println("src:"+src.getData()+" dest:"+dest.getData());
		System.out.println(GraphUtil.PathExists(graph, src, dest));
		System.out.println("src distance:"+src.getDistance()+" dest distance:"+dest.getDistance());
		GraphUtil.DjikstraAlgo(graph, src);
		System.out.println("src distance:"+src.getDistance()+" dest distance:"+dest.getDistance());
	}
}
