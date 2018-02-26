package dev.chernykh.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {
    private String name;
    private CyclicBarrier barrier;
    
    public MyThread(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
        new Thread(this).start();
    }
    
    public void run() {
        System.out.println(name);
        try {
            barrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
