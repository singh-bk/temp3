package com.moraganstanley.www;

import java.util.Comparator;

public class MyComparator implements Comparator<Object>{

	@Override
	public int compare(Object arg0, Object arg1) {
		Class1 obj1 = (Class1) arg0;
		Class2 obj2 = (Class2) arg1;
		
		if(obj1.getData() == obj2.getData())
			return 0;
		else if(obj1.getData() > obj2.getData())
			return 1;
		else 
			return -1;
	}

}
