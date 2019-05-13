package com.hp.util;

public class Triplet<K, V, M> {

	private K k;
	private V v;
	private M m;
	
	public Triplet(){
		
	}
	
	public Triplet(K k, V v, M m){
		this.k = k;
		this.v = v;
		this.m = m;
	}

	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}

	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}

	public M getM() {
		return m;
	}

	public void setM(M m) {
		this.m = m;
	}
}
