package com.example.demo.port;

import java.util.concurrent.Callable;

public class ThreadWorker implements Callable<String> {
    private CalculateInterest calculateInterest;

    public ThreadWorker(CalculateInterest calculateInterest) {
        this.calculateInterest = calculateInterest;
    }

    @Override
    public String call() throws Exception {
//        calculateInterest.calculateTotalAmount();
        return "Calculation completed for Principle Amount: " + calculateInterest.getPrincipleAmount();
    }

}
