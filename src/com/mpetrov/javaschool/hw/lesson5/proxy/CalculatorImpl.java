package com.mpetrov.javaschool.hw.lesson5.proxy;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int number) {
        if (number == 1) return 1;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * calc(number - 1);
    }
}
