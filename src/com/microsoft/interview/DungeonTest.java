package com.microsoft.interview;

import java.util.LinkedList;
import java.util.Queue;

public class DungeonTest {

	public static void main(String[] args) {
		int[][] input = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int row = input.length;
		int col = input[0].length;
		int minOfMax = 0;
		int x = 0;
		int y = 0;
		int data = input[x][y];
		DungeonNode root = new DungeonNode(data, x, y);
		Queue<DungeonNode> queue1 = new LinkedList<DungeonNode>();
		Queue<DungeonNode> queue2 = new LinkedList<DungeonNode>();
		queue1.add(root);
		
		boolean first = true;
		
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			if(first){
				int max = -999;
				while(!queue1.isEmpty()){
					DungeonNode node = queue1.remove();
					int curData = node.getData();
					
					if(curData>max) max = curData;
					
					int curX = node.getX();
					int curY = node.getY();
					if(curX < row-1){
						int xx = Math.min(input[curX+1][curY]+curData, curData);
						DungeonNode child = new DungeonNode(xx,curX+1,curY);
						queue2.add(child);
					}
					if(curY < col-1){
						int xx = Math.min(input[curX][curY+1]+curData, curData);
						DungeonNode child = new DungeonNode(xx,curX,curY+1);
						queue2.add(child);						
					}
				}
				if(minOfMax > max) minOfMax = max;
				first = false;
			}
			else{
				int max = -999;
				while(!queue2.isEmpty()){
					
					DungeonNode node = queue2.remove();
					int curData = node.getData();
					
					if(curData>max) max = curData;
					
					int curX = node.getX();
					int curY = node.getY();
					if(curX < row-1){
						int xx = Math.min(input[curX+1][curY]+curData, curData);
						DungeonNode child = new DungeonNode(xx,curX+1,curY);
						queue1.add(child);
					}
					if(curY < col-1){
						int xx = Math.min(input[curX][curY+1]+curData, curData);
						DungeonNode child = new DungeonNode(xx,curX,curY+1);
						queue1.add(child);						
					}
				}	
				if(minOfMax > max) minOfMax = max;
				first = true;
			}
		}
		System.out.println(minOfMax);
	}
}
