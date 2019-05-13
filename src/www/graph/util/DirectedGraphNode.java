package www.graph.util;

import java.util.ArrayList;
import java.util.List;

import com.hp.util.Pair;

public class DirectedGraphNode {

	private String id;
	private List<Pair<DirectedGraphNode, Integer>> neighbors = new ArrayList<Pair<DirectedGraphNode, Integer>>();
	private boolean visited;

	public DirectedGraphNode(){
		
	}
	
	public DirectedGraphNode(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addNeighbor(DirectedGraphNode neighbor, int distance) {
		Pair<DirectedGraphNode, Integer> neighborPair = new Pair<DirectedGraphNode, Integer>();
		neighborPair.setK(neighbor);
		neighborPair.setV(distance);
		this.neighbors.add(neighborPair);
	}

	public List<Pair<DirectedGraphNode, Integer>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Pair<DirectedGraphNode, Integer>> neighbors) {
		this.neighbors = neighbors;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
