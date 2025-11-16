package com.example.demo.override;

public abstract class Car {
    private String type;
    private String model;

    public Car(String type, String model) {
        this.type = type;
        this.model = model;
    }

    public Car() {
        this.type = "Default";
        this.model =   "DefaultModel";
    }

    public String start() {
        int number;
        System.out.println("Starting Car in Base it type is " + this.type );
        return ("Shrimayi");
    }

    public void changeGear() {
        System.out.println("Changing gear in Base");
    }

    public void stop() {
        System.out.println("Stopping Car in Base" + this.type  + " and model is " + this.model);
    }

    public void doOperations() {
        start();
        changeGear();
        stop();
    }

    @Override
    public String toString() {
        return  "Car{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
