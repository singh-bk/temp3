package com.snapdeal.www;

public class LruNode {

	private String domain;
	
	private LruNode next;
	
	private LruNode prev;

	public LruNode(String domain, LruNode prev, LruNode next) {
		super();
		this.domain = domain;
		this.next = next;
		this.prev = prev;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public LruNode getNext() {
		return next;
	}

	public void setNext(LruNode next) {
		this.next = next;
	}

	public LruNode getPrev() {
		return prev;
	}

	public void setPrev(LruNode prev) {
		this.prev = prev;
	}
	
}
