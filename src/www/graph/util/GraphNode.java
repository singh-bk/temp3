package www.graph.util;

import java.util.ArrayList;

public class GraphNode {

	private int data;
	private boolean isVisited = false;
	private ArrayList<GraphNode> adjacencyList;
	private int distance = 9999;
	
	public GraphNode(int data, ArrayList<GraphNode> adjacencyList){
		this.data = data;
		if(adjacencyList != null)
			this.adjacencyList = adjacencyList;
		else
			this.adjacencyList = new ArrayList<GraphNode>();
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	public ArrayList<GraphNode> getAdjacencyList() {
		return adjacencyList;
	}
	
	public void setAdjacencyList(ArrayList<GraphNode> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	public void addAdjacenyNode(GraphNode node){
		if(this.getAdjacencyList() != null){
			this.getAdjacencyList().add(node);
		}
		else{
			this.setAdjacencyList(new ArrayList<GraphNode>());
			this.getAdjacencyList().add(node);
		}
	}
	
	public boolean getIsVisited(){
		return this.isVisited;
	}
	
	public void setIsVisited(boolean isVisited){
		this.isVisited = isVisited;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof GraphNode && ((GraphNode) obj).getData()== this.getData()
				&& (((GraphNode) obj).getAdjacencyList() != null && ((GraphNode) obj).getAdjacencyList().equals(this.getAdjacencyList()))){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return this.getData();
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
