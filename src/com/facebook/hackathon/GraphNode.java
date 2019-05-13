package com.facebook.hackathon;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {

	//num is an identifier of the graph. Odd num for elements of set1, even for 2.
	private int num;
	//set indicates the set the node belongs to - 1 for k1, 2 for k2
	private int set;
	//data indicates the chars of the node
	private char[] data;
	//contains the list of neighbour's identifier.
	private List<GraphNode> neighbor;
	
	private boolean singleMatch = false;
	
	public GraphNode(int num, int set, char[] data, List<GraphNode> neighbor){
		this.num = num;
		this.set = set;
		this.data = data;
		this.neighbor = neighbor;
	}

	public List<GraphNode> getNeighbor() {
		return neighbor;
	}
	
	/**
	 * Method to find if two graph node from two different set match with each other.
	 * @param node
	 * @return
	 */
	public boolean matches(GraphNode node){
		boolean matches = true;
		char[] nodeData = node.getData();
		for(int i=0;i<this.data.length;i++)
		{
			if(this.data[i]!=nodeData[i] && this.data[i]!='?' && nodeData[i]!='?')
			{
					matches = false;
					break;
			}
		}
		return matches;
	}

	/**
	 * Add a neighbor based on the identifier
	 * @param neighbour
	 */
	public void addNeighbour(GraphNode neighbor){
		if(this.neighbor== null){
			this.neighbor = new LinkedList<GraphNode>();
		}
		this.neighbor.add(neighbor);
	}
	
	/**
	 * Method to remove all other neighbor and add just one neighbor
	 * @param neighbor
	 */
	public void setNeighbor(GraphNode neighbor){
		this.neighbor = new LinkedList<GraphNode>();
		this.neighbor.add(neighbor);
	}

	public int getNum() {
		return num;
	}

	public int getSet() {
		return set;
	}

	public char[] getData() {
		return data;
	}
	
	public void setSingleMatch(boolean singleMatch){
		this.singleMatch = singleMatch;
	}
	
	public void setData(char[] data){
		this.data = data;
	}
	
	public boolean getSingleMatch(){
		return this.singleMatch;
	}
	
	/**
	 * This method is called only when the node has a single neighbor from the other set
	 * boolean false indicates the method failed
	 * boolean true is the expected result
	 */
	public GraphNode ReplaceCorrectChar(){
		if(this.getNeighbor() != null && this.getNeighbor().size() ==1){
			GraphNode neighborTemp = this.getNeighbor().get(0);
			char[] data1 = this.getData();
			char[] data2 = neighborTemp.getData();
			for(int i=0;i<data1.length;i++){
				if(data1[i] == '?'){
					data1[i] = data2[i];
				}
				if(data2[i] == '?'){
					data2[i] = data1[i];
				}
			}
			this.setData(data1);
		}
		return this;
	}
}
