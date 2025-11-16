package com.example.demo.port;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PortThread implements Runnable{
    private Line line;
    private static final Object lock = new Object(); // shared lock

    public PortThread(Line line) {
        this.line = line;
    }

//    List<Line> lines = Arrays.asList(
//            new Line("nag","NYC","9452679109"),
//            new Line("Akhil","DFW","8052982812"),
//            new Line("KAV","DEN","9452976143"),
//            new Line("Shri","LA","9452976153"));


    public void run(){
        System.out.println("Processing thread for: "+line.getName());
        synchronized (lock) { // ensures one thread writes at a time
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("thread_output.txt", true))) {
                writer.write(Thread.currentThread().getName() + ": " + line.toString() + "\n");
                writer.flush(); // make sure data is actually written
                System.out.println(Thread.currentThread().getName() + " finished writing");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
