package com.softwareag.www;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ImmutableObject {

	private final String name;
	private final int age;
	private List<ImmutableObject> dependents;
	private Date depDOB;
	
	public ImmutableObject(String name, int age, List<ImmutableObject> dependents, Date depDOB)
	{
		this.name = name;
		this.age = age;
		if(dependents != null)
		{
			this.dependents = dependents;
		}
		if(depDOB != null)
		{
			this.depDOB = new Date(depDOB.getTime());
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}


	public List<ImmutableObject> getDependents() {
		List<ImmutableObject> deps = new ArrayList<ImmutableObject>();
		deps.addAll(dependents);
		return deps;
	}

	public Date getDepDOB() {
			
		 return new Date( this.depDOB.getTime() );
	}

}
