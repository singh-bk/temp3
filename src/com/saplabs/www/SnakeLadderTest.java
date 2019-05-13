package com.saplabs.www;

import java.util.Scanner;

public class SnakeLadderTest {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		SnakeLadderPlayer[] players = new SnakeLadderPlayer[count];
		
		SnakeLadder game = new SnakeLadder();
		SnakeLadderNode[] grid = game.getGrid();
		boolean isGameOver = false;
		for(int i=0;i<count;i++){
			players[i] = new SnakeLadderPlayer(-1);
		}
		while(!isGameOver){
			for(int i=0;i<count;i++){
				System.out.println("Enter the die and input the number on top:");
				int index = players[i].getIndex()+sc.nextInt();
				
				if(grid[index].isSnakeBite() == true){
					index = grid[index].getSnakeTail();
				}
				else if(grid[index].isLadderTail() == true){
					index = grid[index].getLadderHead();
				}
				players[i].setIndex(index);
				if(index == 99){
					System.out.println("The Winner is Player:"+i);
					isGameOver = true;
				}
				System.out.println("Player "+i+" is on index:"+index);
			}
		}
		
	}
}
