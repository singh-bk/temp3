package com.uber.www;

import java.util.ArrayList;
import java.util.List;

/*

    0 1 2 3 4 5
0  |.|.|.|.|.|.|
1  |.|.|o|.|.|.|
2  |.|o|x|o|.|.|
3  |.|.|o|.|.|.|
4  |.|.|.|.|.|.|
5  |.|.|.|.|.|.|
The 'x' stone is captured

    0 1 2 3 4 5
0  |.|.|.|.|.|.|
1  |.|.|x|.|.|.|
2  |.|x|o|x|.|.|
3  |.|x|o|o|x|.|
4  |.|.|x|x|.|.|
5  |.|.|.|.|.|.|
All of the 'o' stones are captured

    0 1 2 3 4 5
0  |.|.|.|.|.|.|
1  |.|.|x|.|.|.|
2  |.|x|o|x|.|.|
3  |.|x|o|o|.|.|
4  |.|.|x|x|.|.|
5  |.|.|.|.|.|.|
none of the 'o' stones are captured

boolean isCaptured(x, y) => true if the stone at position (x,y) is captured, false otherwise

*/

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    
        Board board = new Board(6);
        Cell O1 = new Cell(2,2);
        Cell X1 = new Cell(2,1);
        Cell X2 = new Cell(2,3);
        Cell X3 = new Cell(3,2);
        Cell X4 = new Cell(1,2);
        List<Cell> list1 = new ArrayList<Cell>();
        list1.add(O1);
        
        List<Cell> list2 = new ArrayList<Cell>();
        list2.add(X1);
        list2.add(X2);
        list2.add(X3);list2.add(X4);
        
        board.addToList(list1, list2);
        
        boolean captured = board.isCaptured(2,2);
        System.out.println(captured);
    }
    
    static class Board{
        
        int STONE_X = 0;
        int STONE_0 = 1;
        
        int size;
        
        public Board(int size){
            this.size = size;
        }
        
        List<Cell> listOfX = new ArrayList<Cell>();
        List<Cell> listOfO = new ArrayList<Cell>();
        
        public void addToList(List<Cell> listOfX, List<Cell> listOfO){
            this.listOfX = listOfX;
            this.listOfO = listOfO;
        }
        
        
       boolean isPresent(List<Cell> list){
           return list.stream().filter(a-> a.getX() == this.x && a.getY() == this.y).findFirst();
       }
       
       int stoneType(int x, int y){
           if(isPresent(listOfX)){
            return STONE_X;
           }
            else if(isPresent(listOfO)){
                return STONE_0;
            }
            return -1;
       }
       
        boolean isCaptured(int x, int y){
            //get the stoneType
            int a = stoneType(x, y);
            boolean captured = false;
            
            for(int i=x;i<size;i++){
                if(stoneType(i,y) != a && stoneType(i,y)!= -1){
                    captured = true;
                }
            }
            for(int i=x;i>=0;i--){
                if(stoneType(i,y) != a && stoneType(i,y)!= -1){
                    captured = captured & true;
                }
            }
            for(int i=y;i<size;i++){
                if(stoneType(x,i) != a && stoneType(x, i)!= -1){
                    captured = captured & true;
                }
            }
            for(int i=y;i>=0;i++){
                if(stoneType(x,i) != a && stoneType(x,i)!= -1){
                    captured = captured & true;
                }
            }
            return captured;
        }
    }
    
    static class Cell{
        int x;
        int y;
        
        public Cell(int x, int y){
        	this.x = x;
        	this.y = y;
        }
        
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
        
        public void setX(int x){
            this.x = x;
        }
        
        public void setY(int y){
            this.y = y;
        }
        
    }
}