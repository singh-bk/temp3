package com.groupon.www;

public class SampleBlockingPoolImpl extends BlockingPool<Sample>{

	public SampleBlockingPoolImpl(int size) {
		super(size);
	}

	@Override
	public Sample create() {
		SampleFactory factory = new SampleFactory();
		Sample sample = factory.create();
		return sample;
	}

}
