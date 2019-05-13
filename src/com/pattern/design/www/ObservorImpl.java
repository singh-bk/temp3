package com.pattern.design.www;

public class ObservorImpl implements Observor{

	private int id = 0;
	public ObservorImpl(int id)
	{
		this.id = id;
	}
	private String state;
	@Override
	public void update(ObservorSubject subj) {
		this.state = subj.getState();
		System.out.println("State Changed. New state:"+this.state+"for id:"+this.id);
	}

}
