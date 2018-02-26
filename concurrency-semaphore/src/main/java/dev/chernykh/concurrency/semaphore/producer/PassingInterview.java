package dev.chernykh.concurrency.semaphore.producer;

public class PassingInterview {
    public static void main(String[] args) {
        Item item = new Item();
        new Producer(item);
        new Consumer(item);
    }
}
