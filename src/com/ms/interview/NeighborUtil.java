package com.ms.interview;

public class NeighborUtil {
	
	public static Node getRightNeighbor(Node node){
		Node neighbor = null;
		return neighbor;
	}
	
	public static boolean isLeftChildOfParent(Node node){
		boolean leftChild = false;
		Node parent = node.getParent();
		if(parent.getLeft().equals(node)){
			leftChild = true;
		}
		else{
			leftChild = false;
		}
		return leftChild;
	}
}
