package dev.chernykh.concurrency.semaphore.counter;

import java.util.concurrent.Semaphore;

public abstract class IncDec implements Runnable {
    protected String threadName;
    protected Semaphore semaphore;
    
    public IncDec(String threadName, Semaphore semaphore) {
        this.threadName = threadName;
        this.semaphore = semaphore;
    }
    
    public abstract void specificAction();
    
    public void run() {
        try {
            System.out.println("Thread " + threadName + " is trying to acquire permit");
            semaphore.acquire();
            System.out.println("Thread " + threadName + " acquired permit");
            for (int i = 0; i < 7; i++) {
                System.out.print("Thread: " + threadName + ". ");
                specificAction();
                Thread.sleep(500);
            }
            semaphore.release();
            System.out.println("Thread " + threadName + " released permit");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
