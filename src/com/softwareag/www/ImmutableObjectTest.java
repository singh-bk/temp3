package com.softwareag.www;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImmutableObjectTest {

	public static void main(String[] args){
		Date today = new Date();
		ImmutableObject child = new ImmutableObject("Child",30,null,today );
		List<ImmutableObject> dependents = new ArrayList<ImmutableObject>();
		dependents.add(child);
		ImmutableObject parent = new ImmutableObject("Parent",60,dependents, today);
		for(int i=0;i<parent.getDependents().size();i++)
		{
			System.out.println(parent.getDependents().get(i).getName());
			System.out.println(parent.getDepDOB());
		}
		ImmutableObject newChild = new ImmutableObject("New Child",30,null, today);
		child = new ImmutableObject("Modified Child",30,null, today);
		today.setMonth(1);
		parent.getDependents().add(newChild);
		for(int i=0;i<parent.getDependents().size();i++)
		{
			System.out.println(parent.getDependents().get(i).getName());
			System.out.println(parent.getDepDOB());
		}
	}
}
