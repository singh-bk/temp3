package com.softwareag.www;

import java.util.Date;

public class BetterPersonTest {

	public static void main(String[] args)
	{

		Date today = new Date();
		BetterPerson myPerson =
		  new BetterPerson( "David", "O'Meara", today );
		System.out.println( myPerson.getDOB() );
		Date myDate = myPerson.getDOB();
		myDate.setMonth( myDate.getMonth() + 1 );
		today.setDate(11);
		System.out.println( myPerson.getDOB() );
	}
}
