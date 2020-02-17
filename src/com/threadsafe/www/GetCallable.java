package com.threadsafe.www;

import java.time.Instant;
import java.util.concurrent.Callable;

public class GetCallable implements Callable<String> {


    @Override
    public String call() throws Exception {
        final long tt = Instant.now().toEpochMilli();
        final String s = Sample.get("sample");
        System.out.println(s);
        return s;
    }
}
