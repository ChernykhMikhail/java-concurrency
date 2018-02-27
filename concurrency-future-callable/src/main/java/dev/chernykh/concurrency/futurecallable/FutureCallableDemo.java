package dev.chernykh.concurrency.futurecallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> sum;
        Future<Double> hypo;
        Future<Integer> factorial;
        
        sum = es.submit(new Sum(10));
        hypo = es.submit(new Hypo(3.0, 4.0));
        factorial = es.submit(new Factorial(5));
        
        es.shutdown();
        
        try {
            System.out.println(sum.get());
            System.out.println(hypo.get());
            System.out.println(factorial.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
