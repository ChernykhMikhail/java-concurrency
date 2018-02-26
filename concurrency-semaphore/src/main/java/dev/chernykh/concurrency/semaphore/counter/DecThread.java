package dev.chernykh.concurrency.semaphore.counter;

import java.util.concurrent.Semaphore;

public class DecThread extends IncDec {
    public DecThread(String threadName, Semaphore semaphore) {
        super(threadName, semaphore);
        new Thread(this).start();
    }
    
    public void specificAction() {
        Shared.counter--;
        System.out.println("Shared counter: " + Shared.counter);
    }
}
