package com.example.demo.override;

public class Gas extends Car {

    private String engine;
    public Gas(String type, String model) {
        super(type, model);
        this.engine = "Gas";
    }

    @Override
    public void changeGear() {
        System.out.println("Derived .. Manual Shift");
    }

    @Override
    public String toString() {
        return "Gas{" + super.toString() +
                "engine='" + engine + '\'' +
                '}';
    }
}
