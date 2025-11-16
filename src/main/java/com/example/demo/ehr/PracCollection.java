package com.example.demo.ehr;

import java.util.List;
import java.util.Objects;

public class PracCollection {
    List<Customer> names;

    public PracCollection(List<Customer> names) {
        this.names = names;
    }

    public void printNames() {
        for (Customer name : names) {
            System.out.println(name);
        }
    }

    public void convertToSet() {
        java.util.Set<Customer> nameSet = new java.util.HashSet<>(names);
        System.out.println("Converted Set: " + nameSet.toString());
    }
}

