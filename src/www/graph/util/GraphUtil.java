package www.graph.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphUtil {

	/**
	 * @param graph
	 * @return
	 */
	public static Queue<GraphNode> BreadthFirstTraversal(Graph graph){
		HashSet<GraphNode> nodeSet = graph.getVertices();
		Iterator<GraphNode> iter = nodeSet.iterator();
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		while(iter.hasNext())
		{
			GraphNode node = iter.next();
			if(node.getIsVisited() == false)
			{
				node.setIsVisited(true);
				queue.add(node);
				System.out.println(node.getData()+" ");
			}
			if(node.getAdjacencyList() != null)
			{
				for(int i=0;i<node.getAdjacencyList().size();i++)
				{
					GraphNode child = node.getAdjacencyList().get(i);
					if(child.getIsVisited() == false)
					{
						child.setIsVisited(true);
						queue.add(child);
						System.out.print(child.getData()+" ");
					}
				}
				System.out.println();
			}
		}
		return queue;
	}
	
	/**
	 * @param graph
	 */
	public static void DepthFirstTraversal(Graph graph){
		HashSet<GraphNode> nodeSet = graph.getVertices();
		Iterator<GraphNode> iter = nodeSet.iterator();
		Stack<GraphNode> stack = new Stack<GraphNode>();
		GraphNode node;
		while(iter.hasNext()){
			node = iter.next();
			node.setIsVisited(false);
			stack.push(node);
			break;
		}
		while(!stack.isEmpty()){
			node = stack.pop();
			System.out.print(node.getData()+" ");
			if(node.getAdjacencyList() != null){
				for(int i=0; i<node.getAdjacencyList().size();i++){
					if(node.getAdjacencyList().get(i).getIsVisited() == false)
					{
						node.getAdjacencyList().get(i).setIsVisited(true);
						stack.push(node.getAdjacencyList().get(i));
						break;
					}
				}
			}
		}
	}
	
	/**
	 * @param graph
	 */
	public static void ResetIsVisited(Graph graph){
		HashSet<GraphNode> vertices = graph.getVertices();
		Iterator<GraphNode> iter = vertices.iterator();
		while(iter.hasNext()){
			GraphNode node = iter.next();
			node.setIsVisited(false);
		}
	}
	
	/**
	 * @param graph
	 * @param src
	 * @param dest
	 * @return
	 */
	public static boolean PathExists(Graph graph, GraphNode src, GraphNode dest){
		boolean pathExists = false;
		Set<GraphNode> vertices = graph.getVertices();
		Iterator<GraphNode> iter = vertices.iterator();
		GraphNode node = null;
		while(iter.hasNext()){
			node = iter.next();
			if(node.equals(src)){
				node.setIsVisited(true);
				break;
			}
		}
		if(node != null){
			ArrayList<GraphNode> neighbours = node.getAdjacencyList();
			Queue<GraphNode> queue = new LinkedList<GraphNode>();
			for(int i=0;i<neighbours.size();i++){
				queue.add(neighbours.get(i));
			}
			while(!queue.isEmpty()){
				GraphNode node2 = queue.remove();
				if(node2.getIsVisited() == false){
					node2.setIsVisited(true);
					if(node2.equals(dest)){
						pathExists = true;
						break;
					}
					else{
						neighbours = node2.getAdjacencyList();
						if(neighbours != null){
							for(int i=0;i<neighbours.size();i++){
								queue.add(neighbours.get(i));
							}
						}
					}
				}
			}
		}
		return pathExists;
	}
	
	/**
	 * Assume that weight of all edges is 1.
	 * @param graph
	 * @param src
	 */
	public static void DjikstraAlgo(Graph graph, GraphNode src){
		src.setDistance(0);
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(src);
		while(!queue.isEmpty()){
			GraphNode node = queue.poll();
			int distanceOfNodeFrmSrc = node.getDistance();
			List<GraphNode> neighbours = node.getAdjacencyList();
			for(int i=0;i<neighbours.size();i++){
				GraphNode neighbour = neighbours.get(i);
				queue.add(neighbour);
				int distOfNeighFrmNode = 1;// All edges are of weight 1
				int distOfNeighFrmSrc = neighbour.getDistance();
				if(distanceOfNodeFrmSrc+distOfNeighFrmNode < distOfNeighFrmSrc){
					neighbour.setDistance(distanceOfNodeFrmSrc+distOfNeighFrmNode);
				}
			}
		}
	}
}
