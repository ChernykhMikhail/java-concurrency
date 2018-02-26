package dev.chernykh.concurrency.semaphore.producer;

public class Producer implements Runnable {
    private Item item;
    
    public Producer(Item item) {
        this.item = item;
        new Thread(this).start();
    }
    
    public void run() {
        for (int i = 0; i < 7; i++) {
            item.put(i);
        }
    }
}
