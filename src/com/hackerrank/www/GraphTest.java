package com.hackerrank.www;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class GraphTest {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vertexCnt = in.nextInt();
        int edgeCnt = in.nextInt();
        int colorCnt = in.nextInt();
        
        
        List<Node> nodes = new ArrayList<Node>();
 
        for(int i=0;i<edgeCnt;i++){
        	int src = in.nextInt();
        	int dest = in.nextInt();
        	int color = in.nextInt();
        	
        	Node node1 = new Node();Node node2 = new Node();
        	for(Node x: nodes){
        		if(x.getVertex() == src){
        			node1 = x;
        		}else if(x.getVertex() == dest){
        			node2 = x;
        		}
        	}
        	node1.setVertex(src); node2.setVertex(dest);
        	node1.addNeighbor(node2); node2.addNeighbor(node1);
        	node1.addColor(color); node2.addColor(color);
        	nodes.add(node1); nodes.add(node2);
        }

        int testCnt = in.nextInt();
        List<Integer> solutions = new ArrayList<Integer>();
        
        for(int i=0;i<testCnt;i++){
        	
        	int x = in.nextInt();
        	int y = in.nextInt();
        	
        	Node src = new Node();
        	
        	for(Node nn: nodes){
        		if(nn.getVertex() == x){
        			src = nn;
        			break;
        		}
        	}
        	
        	Stack<Node> stack = new Stack<Node>();
        	stack.push(src);
        	src.setVisited(true);
        	
        	List<Integer> colorList = new ArrayList<Integer>();
        	Set<Integer> colorSet = new HashSet<Integer>();
        	int count = 0;
        	
        	int total = 0;
        	
        	while(!stack.isEmpty()){
        		Node node = stack.peek();
        		List<Node> neighbors = node.getNeighbors();
        		boolean last = false;
        		
        		int index = 0;
        		boolean added = false;
        		boolean found = false;
        		for(Node neighbor: neighbors){
        			
        			if(!neighbor.isVisited()){
        				neighbor.setVisited(true);
        				colorList.add(node.getColors().get(index));
        				count++;
        				stack.add(neighbor);
        				added = true;
        				if(neighbor.getVertex() == y){
        					found = true;
        				}
        				break;
        			}
        			index++;
        		}
        		
        		if(!added || found){
        			Node popped = stack.pop();
        			if(popped.getVertex() == y){
        				colorSet.addAll(colorList);
        				colorList.remove(colorList.size()-1);
        			}else{
        				if(colorList.size() > 0){
        					colorList.remove(colorList.size()-1);
        				}
        			}
        		}
        		
        	}
        	for(Node xxx: nodes){
    			xxx.setVisited(false);
    		}
        	solutions.add(colorSet.size());
        }
        
        for(int i=0;i<testCnt;i++){
        	System.out.println(solutions.get(i));
        }
	}

}

class Node{
	int vertex;
	List<Node> neighbors;
	List<Integer> colors;
	boolean visited;
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Node(){
		
	}
	
	public int getVertex() {
		return vertex;
	}
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public void addNeighbor(Node node){
		if(neighbors == null){
			neighbors = new ArrayList<Node>();
		}
		neighbors.add(node);
	}

	public List<Integer> getColors() {
		return colors;
	}

	public void addColor(Integer color){
		if(colors == null){
			colors = new ArrayList<Integer>();
		}
		colors.add(color);
	}
	
}
