package dev.chernykh.concurrency.futurecallable;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {
    private int number;
    
    public Factorial(int i) {
        number = i;
    }
    
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
}
