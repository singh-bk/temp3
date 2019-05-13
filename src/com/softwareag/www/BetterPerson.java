package com.softwareag.www;

import java.util.Date;

public final class BetterPerson
{
	private String firstName;
	private String lastName;
	private Date dob;

	public BetterPerson( String firstName,
	  String lastName, Date dob)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = new Date( dob.getTime() );
	}

	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public Date getDOB()
	{
		return new Date( this.dob.getTime() );
	}
}
