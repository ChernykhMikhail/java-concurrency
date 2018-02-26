package dev.chernykh.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class SecondThread implements Runnable{
    private CountDownLatch latch;
    
    public SecondThread(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}
