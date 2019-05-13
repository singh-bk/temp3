package www.graph.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class GraphUtilTest {

	public static void main(String[] args){
		int noOfNodes = 5;
		HashMap<Integer, GraphNode> graph = CreateGraph(noOfNodes);
		//System.out.println(graph.size());
		AddUnDirectedEdge(graph, 0, 1);
	    AddUnDirectedEdge(graph, 0, 4);
	    AddUnDirectedEdge(graph, 1, 2);
	    AddUnDirectedEdge(graph, 1, 3);
	    AddUnDirectedEdge(graph, 1, 4);
	    AddUnDirectedEdge(graph, 2, 3);
	    AddUnDirectedEdge(graph, 3, 4);
		
	    GraphNode source = graph.get(0);
	    GraphUtil2.DepthFirstTraversal(source);
	    
	    //System.out.println(DepthFirstSearch(graph, 0, 5));
	    //ResetIsVisited(graph);
	    //System.out.println(BreadthFirstSearch(graph, 0, 5));
	    
	}
	
	public static HashMap<Integer, GraphNode> CreateGraph(int noOfNodes){
		HashMap<Integer, GraphNode> graph = new HashMap<Integer, GraphNode>();
		for(int i=0;i<noOfNodes;i++){
			GraphNode node = new GraphNode(i,null);
			graph.put(i, node);
		}
		return graph;
	}
	
	public static void AddDirectedEdge(HashMap<Integer, GraphNode> graph, int src, int dest){
		GraphNode node1 = graph.get(src);
		GraphNode node2 = graph.get(dest);
		node1.addAdjacenyNode(node2);
	}
	
	public static void AddUnDirectedEdge(HashMap<Integer, GraphNode> graph, int src, int dest){
		GraphNode node1 = graph.get(src);
		GraphNode node2 = graph.get(dest);
		node1.addAdjacenyNode(node2);
		node2.addAdjacenyNode(node1);
	}

	public static boolean DepthFirstSearch(HashMap<Integer, GraphNode> graph, int startIndex, int search){
		boolean found = false;
		Stack<GraphNode> stack = new Stack<GraphNode>();
		GraphNode node = graph.get(startIndex);
		stack.push(node);
		node.setIsVisited(true);
		node = stack.pop();
		System.out.print(node.getData()+" ");
		while(node != null){
			if(node.getData() == search){
				found = true;
				break;
			}
			else{
				for(int i=0;i<node.getAdjacencyList().size();i++){
					GraphNode child = node.getAdjacencyList().get(i);
					if(!child.getIsVisited()){
						stack.push(child);
						System.out.print(child.getData()+" ");
						child.setIsVisited(true);
					}
				}
			}
			
			if(!stack.isEmpty()){
				node = stack.pop();
			}
			else{
				break;
			}
		}
		return found;
	}
	
	public static boolean BreadthFirstSearch(HashMap<Integer, GraphNode> graph, int startIndex, int search){
		boolean found = false;
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		GraphNode node = graph.get(startIndex);
		queue.add(node);
		node.setIsVisited(true);
		//System.out.print(node.getData()+" ");
		while(!queue.isEmpty()){
			node = queue.remove();
			System.out.print(node.getData()+" ");
			if(node.getData() == search){
				found = true;
				break;
			}
			else{
				for(int i=0;i<node.getAdjacencyList().size();i++){
					GraphNode child = node.getAdjacencyList().get(i);
					if(!child.getIsVisited()){
						queue.add(child);
						child.setIsVisited(true);
					}
				}
			}
		}
		return found;
	}
	
	public static void ResetIsVisited(HashMap<Integer, GraphNode> graph){
		Iterator<Map.Entry<Integer, GraphNode>> iter = graph.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<Integer, GraphNode> pairs = iter.next();
			GraphNode node = pairs.getValue();
			node.setIsVisited(false);
		}
	}
}
