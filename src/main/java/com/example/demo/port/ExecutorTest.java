package com.example.demo.port;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
    public static void main(String args[]) {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(10);

            CalculateInterest intrest1 = new CalculateInterest();
            intrest1.setPrincipleAmount(1000.00f);
            intrest1.setRateOfIntrest(12.00f);
            intrest1.setTime(2.5f);

            CalculateInterest intrest2 = new CalculateInterest();
            intrest2.setPrincipleAmount(2000.00f);
            intrest2.setRateOfIntrest(14.00f);
            intrest2.setTime(3.5f);

            CalculateInterest intrest3 = new CalculateInterest();
            intrest3.setPrincipleAmount(3000.00f);
            intrest3.setRateOfIntrest(15.00f);
            intrest3.setTime(3.5f);


            ThreadWorker worker1 = new ThreadWorker(intrest1);
            ThreadWorker worker2 = new ThreadWorker(intrest2);
            ThreadWorker worker3 = new ThreadWorker(intrest3);


            List<ThreadWorker> callableTasks = new ArrayList<ThreadWorker>();

            callableTasks.add(worker1);
            callableTasks.add(worker2);
            callableTasks.add(worker3);

            List<Future<String>> futures = executorService.invokeAll(callableTasks);

            for (Future<String> future: futures) {
                System.out.println(future.get());
            }

            System.out.println(intrest1.getTotalAmount());
            System.out.println(intrest2.getTotalAmount());
            System.out.println(intrest3.getTotalAmount());


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
