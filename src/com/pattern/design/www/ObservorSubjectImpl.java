package com.pattern.design.www;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ObservorSubjectImpl implements ObservorSubject{

	private List<Observor> list = new LinkedList<Observor>();
	private String state;
	private HashMap<String, Integer> price = new HashMap<String, Integer>();
	private HashMap<String, LinkedList<Observor>> subscribers = new HashMap<String, LinkedList<Observor>>();
	
	@Override
	public String getState() {
		return this.state;
	}

	@Override
	public void addObservor(Observor observor) {
		list.add(observor);
	}

	@Override
	public void removeObservor(Observor observor) {
		list.remove(observor);
	}

	@Override
	public void setState(String state) {
		this.state = state;
		notifyObservors();
	}

	public void notifyObservors()
	{
		Iterator<Observor> iter = list.iterator();
		while(iter.hasNext())
		{
			iter.next().update(this);
		}
	}
}
