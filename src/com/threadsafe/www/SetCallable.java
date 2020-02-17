package com.threadsafe.www;

import java.time.Instant;
import java.util.concurrent.Callable;

public class SetCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        final long tt = Instant.now().toEpochMilli();
        Sample.set("sample", "sample"+tt);
        return null;
    }

}
