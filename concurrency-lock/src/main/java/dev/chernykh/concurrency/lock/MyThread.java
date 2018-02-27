package dev.chernykh.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable {
    private String name;
    private ReentrantLock lock;
    
    public MyThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
        new Thread(this).start();
    }
    
    public void run() {
        System.out.println("Thread " + name + " is trying to call lock()");
        lock.lock();
        System.out.println("Thread " + name + " got lock");
        System.out.println("Thread " + name + " is trying to change a shared resource");
        Shared.counter++;
        try {
            System.out.println("The thread " + name + " is suspended");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Shared: " + Shared.counter);
        System.out.println("The thread " + name + " is trying to call unlock()");
        lock.unlock();
        System.out.println("The thread " + name + " finished work");
    }
}
