package dev.chernykh.concurrency.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorDemo {
    private static final int numThread = 2;
    
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(1);
        CountDownLatch cdl2 = new CountDownLatch(1);
        ExecutorService es = Executors.newFixedThreadPool(numThread);
        Object[] arr = new Object[10000000];
        
        System.out.println("Starting...");
        long start = System.currentTimeMillis();
        es.execute(new MyThread(arr, 0, numThread, cdl));
        es.execute(new MyThread(arr, arr.length / 2, numThread, cdl2));
        
        try {
            cdl.await();
            cdl2.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long stop = System.currentTimeMillis();
        es.shutdown();
        System.out.println("Done");
        System.out.println("Duration: " + (stop - start) + " millis");
    }
}
