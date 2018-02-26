package dev.chernykh.concurrency.semaphore.counter;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new IncThread("A", sem);
        new DecThread("B", sem);
    }
}
