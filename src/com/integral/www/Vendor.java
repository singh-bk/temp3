package com.integral.www;

import java.util.HashMap;
import java.util.Map;

public class Vendor {

	private String id;
	private String name;
	private Map<String, Integer> productPriceMap = new HashMap<String, Integer>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getProductPriceMap() {
		return productPriceMap;
	}
	public void setProductPriceMap(Map<String, Integer> productPriceMap) {
		this.productPriceMap = productPriceMap;
	}
	
	
}
