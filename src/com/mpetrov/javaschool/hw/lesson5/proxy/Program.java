package com.mpetrov.javaschool.hw.lesson5.proxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        Map<Integer, Integer> cache = new HashMap<>();
        Calculator delegate = new CalculatorImpl();
        Calculator calculator1 = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new LoggerInvocationHandler(delegate));
        //run(calculator);

        Calculator calculator = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CacheInvocationHandler(calculator1, cache));
        run(calculator);

    }

    private static void run(Calculator calculator) {
        System.out.println(calculator.calc(10));
        System.out.println(calculator.calc(10));
        System.out.println(calculator.calc(10));
        System.out.println(calculator.calc(10));
        System.out.println(calculator.calc(11));
        System.out.println(calculator.calc(9));
        System.out.println(calculator.calc(11));
        System.out.println(calculator.calc(11));
        System.out.println(calculator.calc(11));
    }
}
