package com.bloomreach.www;

public class HouseTest {

	private static int RED_COLOR = 1;
	private static int GREEN_COLOR = 2;
	private static int BLUE_COLOR = 3;
	
	static int[] priceRed = {7, 8, 9, 5 , 7 , 7, 6, 6, 5, 9};
	static int[] priceGreen = {6, 7, 8, 9, 5 , 7 , 7, 6, 6, 5};
	static int[] priceBlue = {8, 7, 8, 9, 5 , 7 , 7, 6, 6, 5};
	
	static int count = 10;
	
	static int[] red = new int[count];
	static int[] blue = new int[count];
	static int[] green = new int[count];
	
	public static void main(String[] args) {
		
		
		
		for(int i=0;i<10;i++){
			fetchMinPrice(i, RED_COLOR);
			fetchMinPrice(i, GREEN_COLOR);
			fetchMinPrice(i, BLUE_COLOR);
		}
		
		for(int i=0;i<10;i++){
			System.out.print(red[i]+" ");
		}
		System.out.println();
		for(int i=0;i<10;i++){
			System.out.print(green[i]+" ");
		}
		System.out.println();
		for(int i=0;i<10;i++){
			System.out.print(blue[i]+" ");
		}
	}
	
	public static void fetchMinPrice(int index, int color){
		if(index == 0 ){
			if(color == RED_COLOR){
				red[index] =  priceRed[index];
			}else if(color == GREEN_COLOR){
				green[index] = priceGreen[index];
			}else if(color == BLUE_COLOR){
				blue[index] = priceBlue[index];
			}
		}else{
			if(color == RED_COLOR){
				red[index] =  (priceRed[index] + Math.min(blue[index-1], green[index-1]));
			}else if(color == GREEN_COLOR){
				green[index] = (priceGreen[index] + Math.min(blue[index-1], red[index-1]));
			}else if(color == BLUE_COLOR){
				blue[index] =  (priceBlue[index] + Math.min(green[index-1], red[index-1]));
			}
		}
	}
}
