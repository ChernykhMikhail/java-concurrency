package dev.chernykh.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class MakeString implements Runnable {
    private String buffer;
    private Exchanger<String> exchanger;
    
    public MakeString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        buffer = new String();
        new Thread(this).start();
    }
    
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                buffer += ch++;
            }
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
