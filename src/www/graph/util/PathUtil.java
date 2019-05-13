package www.graph.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PathUtil {

	public static void AllPathInGraph(Graph graph){
		HashSet<GraphNode> vertices = graph.getVertices();
		Iterator<GraphNode> iter = vertices.iterator();
		Queue<GraphNode> vQueue = new LinkedList<GraphNode>();
		Stack<GraphNode>[] stack = new Stack[vertices.size()];
		int count = 0;
		while(iter.hasNext()){
			GraphNode node = iter.next();
			vQueue.add(node);
		}
		
	}
}
