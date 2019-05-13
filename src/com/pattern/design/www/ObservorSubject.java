package com.pattern.design.www;

public interface ObservorSubject {

	public String getState();
	
	public void addObservor(Observor observor);
	
	public void removeObservor(Observor observor);
	
	public void setState(String state);
}
