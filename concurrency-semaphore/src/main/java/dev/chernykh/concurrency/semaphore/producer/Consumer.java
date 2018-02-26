package dev.chernykh.concurrency.semaphore.producer;

public class Consumer implements Runnable {
    private Item item;
    
    public Consumer(Item item) {
        this.item = item;
        new Thread(this).start();
    }
    
    public void run() {
        for (int i = 0; i < 7; i++) {
            item.get();
        }
    }
}
