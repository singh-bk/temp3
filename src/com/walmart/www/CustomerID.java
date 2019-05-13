package com.walmart.www;

import java.util.HashMap;
import java.util.Map;

public class CustomerID {
	private long crmID;
	private int nameSpace;

	public CustomerID(long crmID, int nameSpace) {
		super();
		this.crmID = crmID;
		this.nameSpace = nameSpace;
	}

	public boolean equals(Object obj) {
		// null instanceof Object will always return false
		System.out.println("Equals Start");
		if (!(obj instanceof CustomerID)) {
			System.out.println("Equals END");
			return false;
		}
		if (obj == this) {
			System.out.println("Equals END");
			return true;
		}
		System.out.println("Equals END");
		return this.crmID == ((CustomerID) obj).crmID
				&& this.nameSpace == ((CustomerID) obj).nameSpace;
	}

	public int hashCode() {
		System.out.println("hashCode Start");
		int result = 0;
		result = (int) (crmID / 12) + nameSpace;
		System.out.println("hashCode end"+result);
		return result;
	}

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put(new CustomerID(2345891234L, 0), "Jeff Smith");
		System.out.println(m.get(new CustomerID(2345891234L, 0)));
	}

}
