package com.video.www;

/**
 * Test Class
 * @author Birendra Kumar Singh
 *
 */
public class CustomListImplTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		//create an empty list
		CustomListImpl<Integer> list = new CustomListImpl<Integer>();
		//add elements to the list
		list.PrintList();
		list.add(5);
		list.add(10);
		list.add(16);
		list.PrintList();
	}
}
