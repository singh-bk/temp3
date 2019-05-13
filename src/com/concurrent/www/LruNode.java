package com.concurrent.www;

public class LruNode {

	private String domain;

	public LruNode(String domain){
		this.domain = domain;
	}
	
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
}
