package dev.chernykh.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new BarAction());
        System.out.println("Start...");
        new MyThread("A", barrier);
        new MyThread("B", barrier);
        new MyThread("C", barrier);
        new MyThread("D", barrier);
        new MyThread("E", barrier);
        new MyThread("F", barrier);
    }
}
