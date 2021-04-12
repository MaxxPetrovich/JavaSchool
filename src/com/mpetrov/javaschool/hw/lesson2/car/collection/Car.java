package com.mpetrov.javaschool.hw.lesson2.car.collection;

public class Car {
    private String model;
    private carType type;

    public Car(String model, carType type) {
        this.model = model;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public carType getType() {
        return type;
    }
}
