package com.amazon.ninja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ConnectedSetTest {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("connected.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			int matrixSize = Integer.parseInt(br.readLine());
			int[][] matrix = new int[matrixSize][matrixSize];
			
			//populate the matrix with the input
			for(int j=0;j<matrixSize;j++)
			{
				String inputStr = br.readLine();
				StringTokenizer token = new StringTokenizer(inputStr, " ");
				for(int k=0;k<matrixSize;k++)
				{
					int input = Integer.parseInt(token.nextToken());
					matrix[j][k] = input;
				}
			}
			
			/*
			 * Initialize a HashSet of size n/2 - max no of distinct connect components
			 */
			//HashSet[] graph_set = new HashSet[matrixSize/2];
			Node[][] graph_node_set = new Node[matrixSize/2][matrixSize*matrixSize];
			int graph_node_count = 0;
			int graph_node_elem_count = 0;
			//int count_set = 0;
			
			/*
			 * 1. Iterate over each element of the matrix
			 * 2. When the current index has 1 
			 * 		Check whether any of its pre-traversed neighbor is one . i.e. top, left, top-left, top-right
			 * 		 If any of its neighbor is one
			 * 			iterate over the array of HashSet and find out the set which contains the neighbour.
			 * 			If there are more than one HashSet as the neighbour, 
			 * 			add the current node the same set
			 * 		else
			 * 			create a new HashSet
			 * 			add the current node the new set. 
			 */
			
			for(int j=0;j<matrixSize;j++)
			{
				for(int k=0;k<matrixSize;k++)
				{
					if(matrix[j][k] == 1)
					{
						boolean hasNeighbour = false;
						int[] neighbour_set = new int[4];
						int neighbour_count = 0;
						//top neighbour
						if(j>0)
						{
							if(matrix[j-1][k] == 1)
							{
								hasNeighbour = true;
								Node node = new ConnectedSetTest().new Node(j-1,k);
								//neighbour_set[neighbour_count] = FindSet(graph_set, node);
								//neighbour_set[neighbour_count] = FindSet(graph_node_set, node);
								neighbour_set[neighbour_count] = FindNode(graph_node_set, node);
								neighbour_count++;
								
							}
						}
						//left neighbour
						if(k>0)
						{
							if(matrix[j][k-1] == 1)
							{
								hasNeighbour = true;
								Node node = new ConnectedSetTest().new Node(j,k-1);
								//neighbour_set[neighbour_count] = FindSet(graph_set, node);
								neighbour_set[neighbour_count] = FindNode(graph_node_set, node);
								neighbour_count++;								
							}
						}
						//top-left
						if(k>0 && j>0)
						{
							if(matrix[j-1][k-1] == 1)
							{
								hasNeighbour = true;
								Node node = new ConnectedSetTest().new Node(j-1,k-1);
								//neighbour_set[neighbour_count] = FindSet(graph_set, node);
								neighbour_set[neighbour_count] = FindNode(graph_node_set, node);
								neighbour_count++;
							}
						}
						//top-right
						if(j>0 && k<matrixSize-1)
						{
							if(matrix[j-1][k+1] == 1)
							{
								hasNeighbour = true;
								Node node = new ConnectedSetTest().new Node(j-1,k+1);
								//neighbour_set[neighbour_count] = FindSet(graph_set, node);
								neighbour_set[neighbour_count] = FindNode(graph_node_set, node);
								neighbour_count++;								
							}
						}
						
						if(!hasNeighbour)
						{
							//create a new hashset
							//graph_set[count_set] = new HashSet<Node>();
							graph_node_set[graph_node_count] = new Node[matrixSize*matrixSize];
							graph_node_set[graph_node_count][0] = (new ConnectedSetTest()).new Node(j,k);
							//graph_set[count_set].add((new ConnectedSetTest()).new Node(j,k));
							graph_node_count++;
						}
						else
						{
							int start = 0;
							//get the end of the first node_array
							while(graph_node_set[neighbour_set[0]][start] != null) start++;
							//merge all the neighbour sets
							if(neighbour_count > 1)
							{

								
								for(int ll=1;ll<neighbour_count;ll++)
								{
									for(int kk=0;kk<neighbour_set[ll];kk++)
									{
										graph_node_set[neighbour_set[0]][start] = graph_node_set[neighbour_set[ll]][kk];
										graph_node_set[neighbour_set[ll]][kk] = null;
										start++;
									}
								}
							}
							//add the new node to the graph_node_set
							graph_node_set[neighbour_set[0]][start] = (new ConnectedSetTest()).new Node(j,k);
							//neighbour_set[0].add(new ConnectedSetTest().new Node(j,k));
						}
					}
					//System.out.println("Here");
				}
			}
			/*
			int final_count = 0;
			for(int kk=0;kk<graph_set.length;kk++)
			{
				if(graph_set[kk]!=null && graph_set[kk].size()>0)
				{
					final_count++;
				}
			}
			System.out.println(final_count);
			System.out.println(count_set);
*/
			System.out.println("Here");
		}
	}
	
	public static HashSet<Node> FindSet(HashSet[] set_array, Node node)
	{
		for(int i=0;i<set_array.length;i++)
		{
			if(set_array[i] != null)
			{
				Iterator iter = set_array[i].iterator();
				while(iter.hasNext())
				{
					Node temp = (Node)iter.next();
					if(temp.equals(node))
						return set_array[i];
				}
				
			}
		}
		return null;
	}
	
	/**
	 * Find index of the node array which contains this node
	 * @param node_array
	 * @param node
	 * @return
	 */
	public static int FindNode(Node[][] node_array, Node node)
	{
		for(int i=0;i<node_array.length;i++)
		{
			for(int j=0;j<node_array[i].length;j++)
			{
				if(node_array[i][j]!= null && node_array[i][j].equals(node))
					return i;
			}
		}
		return -1;
	}
	
	public class Node{
		private int x;
		private int y;
		public Node(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public int getX()
		{
			return this.x;
		}
		
		public int getY()
		{
			return this.y;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			if(obj != null && obj instanceof Node && 
					(((Node)obj).getX() == this.getX() && ((Node)obj).getY() == this.getY()))
				return true;
			else
				return false;
		}
		
		@Override
		public int hashCode()
		{
			return (this.getX()+this.getY());
		}
	}
}
