package com.example.demo.override;

public class Electric extends Car {

    private String engine;
    public Electric(String type, String model) {
        super(type, model);
        this.engine = "Electric";
    }

    @Override
    public void changeGear() {
        System.out.println("Derived .. Auto gear");
    }

    @Override
    public String toString() {
        return "Electric{" + super.toString() +
                "engine='" + engine + '\'' +
                '}';
    }
}
