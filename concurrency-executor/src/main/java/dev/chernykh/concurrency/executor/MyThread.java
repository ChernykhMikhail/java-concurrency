package dev.chernykh.concurrency.executor;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {
    private Object[] arr;
    private int index;
    private int numThread;
    private CountDownLatch latch;
    
    public MyThread(Object[] arr, int index, int numThread, CountDownLatch latch) {
        this.arr = arr;
        this.index = index;
        this.numThread = numThread;
        this.latch = latch;
    }
    
    public void run() {
        for (int i = index; i < arr.length / numThread; i++) {
            arr[i] = i;
        }
        latch.countDown();
    }
}
