package com.example.demo.ehr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String firstName;
    private String lastName;
    private int id;

    public Customer(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return //id == customer.id &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName);
    }

    public void doSomething(int i, char c, String str, int... numbers) {
        System.out.println(i);
        System.out.println(c);
        System.out.println(str);

        int myInt = 10;

        Integer myInteger = Integer.valueOf(myInt);

        int[] myNumbers = {1, 2, 3, 4, 5};

        List<Integer> numberList = new ArrayList<>();
        numberList.add(100);
        numberList.add(200);
        numberList.add(300);

        System.out.println("Varargs numbers:" + numberList);

        for (int number : numbers) {
            System.out.println("Number: " + number);
        }
    }

    @Override
    public int hashCode() {
//        return Objects.hash(firstName, lastName, id);
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }
}
