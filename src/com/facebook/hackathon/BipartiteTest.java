package com.facebook.hackathon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BipartiteTest {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		int testCaseCount = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testCaseCount;i++)
		{
			int setSize = Integer.parseInt(br.readLine());
			
			char[] k1 = br.readLine().toCharArray();
			char[] k2 = br.readLine().toCharArray();
			
			int m = k1.length/setSize; //k1.length = k2.length
			GraphNode[] node = new GraphNode[setSize*2];
			int count =0;
			int identifier = 0;
			char[] dataK1 = new char[m];
			char[] dataK2 = new char[m];
			//Prepare the GraphNodes
			for(int j=0;j<k1.length;j++)
			{
				dataK1[count] = k1[j];
				dataK2[count] = k2[j];
				count++;
				if(count==m){
					//node 0, has identifier 1.
					node[identifier] = new GraphNode(identifier+1, 1, dataK1, null); 
					identifier++;
					node[identifier]= new GraphNode(identifier+1, 2, dataK2, null);
					identifier++;
					
					dataK1 = new char[m];
					dataK2 = new char[m];
					count = 0;
				}
			}
			//Add the neighbors to the bipartite graph
			for(int j=0;j<2*setSize;j=j+2){
				for(int k=1;k<2*setSize;k=k+2){
					if(node[j].matches(node[k])){
						node[j].addNeighbour(node[k]);
						node[k].addNeighbour(node[j]);
					}
				}
			}
			char[] k = new char[k1.length];
			count = 0;
			for(int j=0;j<2*setSize;j++){
				if(node[j].getNeighbor() == null || node[j].getNeighbor().size()==0){
					System.out.print("Not Possible"+i);
					break;
				}
				/**
				 *  1. iterate over all graph nodes
				 *  2. if any graph node has just one neighbor from the other set
				 *  		go the neighbor in the other set
				 *  		delete all other neighbor of this graph node.
				 */
				if(node[j].getNeighbor()!= null && node[j].getNeighbor().size() ==1 && node[j].getSingleMatch()!=true){
					node[j].setSingleMatch(true);
					GraphNode temp = node[j].getNeighbor().get(0);
					temp.setNeighbor(node[j]);
					if(j%2 ==0){
						node[j] = node[j].ReplaceCorrectChar();
					}
				}
			}
			count = 0;
			for(int j=0;j<2*setSize;j=j+2){
				for(int l=0;l<node[j].getData().length;l++){
					k[count] = node[j].getData()[l];
					count++;
				}
			}
			for(int j=0;j<k.length;j++){
				if(k[j] == '?'){
					System.out.print('a'+"");
				}
				else{
					System.out.print(k[j]+"");
				}
			}
			System.out.println();
		}
	}
}
