package com.mpetrov.javaschool.hw.lesson5.proxy;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number
     */
    @Logging
    @Cache
    int calc (int number);
}
