package dev.chernykh.concurrency.semaphore.producer;

import java.util.concurrent.Semaphore;

public class Item {
    private int n;
    private Semaphore semCons = new Semaphore(0);
    private Semaphore semProd = new Semaphore(1);
    
    public void put(int n) {
        try {
            semProd.acquire();
            this.n = n;
            System.out.println("Put: " + this.n);
            semCons.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void get() {
        try {
            semCons.acquire();
            System.out.println("Got: " + this.n);
            semProd.release();
            
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
