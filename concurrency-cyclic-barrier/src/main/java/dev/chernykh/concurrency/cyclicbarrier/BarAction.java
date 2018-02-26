package dev.chernykh.concurrency.cyclicbarrier;

public class BarAction implements Runnable {
    private int counter = 0;
    
    public void run() {
        System.out.println("The barrier has been reached " + (++counter) + " time");
    }
}
