package com.pool.www;

public class SampleFactory {

    
    public static Sample create() {
        final Sample sample = new Sample();
        sample.url = "http://www.google.com";
        return sample;
    }

}
