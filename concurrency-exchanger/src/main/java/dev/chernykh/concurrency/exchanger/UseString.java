package dev.chernykh.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class UseString implements Runnable {
    private Exchanger<String> exchanger;
    private String str;
    
    public UseString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }
    
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = exchanger.exchange(new String());
                System.out.println("Got: " + str);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
