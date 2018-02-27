package dev.chernykh.concurrency.futurecallable;

import java.util.concurrent.Callable;

public class Hypo implements Callable<Double> {
    private double side1;
    private double side2;
    
    public Hypo(double v, double v1) {
        side1 = v;
        side2 = v1;
    }
    
    public Double call() throws Exception {
        return Math.sqrt(side1 * side1 + side2 * side2);
    }
}
