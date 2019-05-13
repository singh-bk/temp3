package www.graph.util;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraphNode {

	private int data;
	private Map<GraphNode, Integer> adjacencyMap;// Contains all node adjacent to it along with the weight of the edge
	private boolean isVisited = false;
	
	public WeightedGraphNode(int data){
		this.data = data;
		this.adjacencyMap = new HashMap<GraphNode, Integer>();
	}
	
	public void addAdjacencyMap(GraphNode node, int distance){
		this.adjacencyMap.put(node, distance);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Map<GraphNode, Integer> getAdjacencyMap() {
		return adjacencyMap;
	}

	public void setAdjacencyMap(Map<GraphNode, Integer> adjacencyMap) {
		this.adjacencyMap = adjacencyMap;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
}
