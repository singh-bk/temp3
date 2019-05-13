package com.pattern.design.www;

public class ObservorTest {

	public static void main(String[] args){
		int count = 7;
		ObservorSubjectImpl subject = new ObservorSubjectImpl();
		Observor[] observor = new Observor[count];
		for(int i=0;i<observor.length;i++)
		{
			observor[i] = new ObservorImpl(i);
			subject.addObservor(observor[i]);
		}
		subject.setState("Running");
		
	}
}
