package www.graph.util;

import java.util.List;
import java.util.Stack;

public class GraphUtil2 {

	public static void DepthFirstTraversal(GraphNode source){
		source.setIsVisited(true);
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(source);
		while(!stack.isEmpty()){
			GraphNode node = stack.peek();
			List<GraphNode> neighbors = node.getAdjacencyList();
			GraphNode neighbor = null;
			for(GraphNode neigh: neighbors){
				if(!neigh.getIsVisited()){
					neighbor = neigh;
					break;
				}
			}
			if(neighbor != null){
				neighbor.setIsVisited(true);
				stack.push(neighbor);
			}else{
				System.out.print(node.getData()+" ");
				stack.pop();
			}
		}
	}
}
