package com.mpetrov.javaschool.hw.lesson2.car.collection;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Car> sedans = new ArrayList<>();
        List<Car> coupes = new ArrayList<>();
        List<Car> hatchbacks = new ArrayList<>();
        List<Car> convertibles = new ArrayList<>();
        List<Car> suvs = new ArrayList<>();
        List<Car> minivans = new ArrayList<>();
        List<Car> estates = new ArrayList<>();

        List<Car> carList = new ArrayList<>();

        carList.add(new Car("Peugeot 206", carType.HATCHBACK));
        carList.add(new Car("Volvo XC90", carType.SUV));
        carList.add(new Car("Ford Focus", carType.HATCHBACK));
        carList.add(new Car("Ford Focus", carType.SEDAN));
        carList.add(new Car("Mercedes S500", carType.SUV));
        carList.add(new Car("Mercedes GLS500", carType.SUV));
        carList.add(new Car("Volvo S80", carType.SEDAN));

        for (Car c : carList) {
            switch (c.getType()) {
                case SEDAN:
                    sedans.add(c);
                    break;
                case COUPE:
                    coupes.add(c);
                    break;
                case HATCHBACK:
                    hatchbacks.add(c);
                    break;
                case CONVERTIBLE:
                    convertibles.add(c);
                    break;
                case SUV:
                    suvs.add(c);
                    break;
                case MINIVAN:
                    minivans.add(c);
                    break;
                case ESTATE:
                    estates.add(c);
                    break;
            }
        }

        printCarCollection(sedans);
        printCarCollection(coupes);
        printCarCollection(hatchbacks);
        printCarCollection(convertibles);
        printCarCollection(suvs);
        printCarCollection(minivans);
        printCarCollection(estates);
    }

    public static void printCarCollection(List<Car> carList) {
        if(!carList.isEmpty()) {
            System.out.println(carList.stream().findFirst().get().getType());
            for (Car c : carList) {
                System.out.println(c.getModel());
            }
        }
    }
}
