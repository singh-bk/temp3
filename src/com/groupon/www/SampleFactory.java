package com.groupon.www;

import java.util.UUID;


public class SampleFactory implements ObjectFactory<Sample>{

	@Override
	public Sample create() {
		Sample sample = new Sample();
		sample.setId((long)Math.random());
		sample.setName(UUID.randomUUID().toString());
		return sample;
	}


}
