package www.graph.util;

import java.util.HashSet;

public class Graph {

	HashSet<GraphNode> vertices;
	
	public Graph(){
		this.vertices = null;
	}
	public Graph(HashSet<GraphNode> vertices)
	{
		this.vertices = vertices;
	}
	
	public HashSet<GraphNode> getVertices()
	{
		return this.vertices;
	}
	
	public void addVertex(GraphNode node)
	{
		if(this.vertices != null){
			this.vertices.add(node);
		}
		else{
			this.vertices = new HashSet<GraphNode>();
			this.vertices.add(node);
		}
	}
}
