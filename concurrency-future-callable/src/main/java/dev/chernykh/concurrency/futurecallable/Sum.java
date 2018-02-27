package dev.chernykh.concurrency.futurecallable;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {
    private int number;
    
    public Sum(int number) {
        this.number = number;
    }
    
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }
}
