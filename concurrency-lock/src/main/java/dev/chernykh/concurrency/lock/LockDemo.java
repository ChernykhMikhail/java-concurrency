package dev.chernykh.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new MyThread("A", lock);
        new MyThread("B", lock);
    }
}
