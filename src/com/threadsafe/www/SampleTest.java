package com.threadsafe.www;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SampleTest {

    public static void main(String[] args) {
        final ExecutorService service = Executors.newFixedThreadPool(100);
        final SetCallable setCallable = new SetCallable();
        final GetCallable[] getCallable = new GetCallable[100];
        final GetCallable[] getCallable2 = new GetCallable[900];
        for(int i=0;i<100;i++) {
            getCallable[i] = new GetCallable();
        }
        for(int i=0;i<900;i++) {
            getCallable2[i] = new GetCallable();
        }
        for(int i=0;i<100;i++) {
            service.submit(getCallable[i]);
        }
        service.submit(setCallable);
        for(int i=0;i<900;i++) {
            service.submit(getCallable2[i]);
            if(i%100 == 0) {
                service.submit(setCallable);
            }
        }
        service.shutdown();
    }
}
