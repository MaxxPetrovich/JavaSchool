package com.mpetrov.javaschool.hw.lesson5.Task1;

import java.lang.reflect.InvocationTargetException;

public class Program {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        ReflectionHelper.printAllMethods(new MyClass("Hello", "World", 10, true));
        System.out.println("-------------------------------");
        ReflectionHelper.printAllGetters(new MyClass("Hello", "World", 10, true));
        System.out.println("-------------------------------");
        ReflectionHelper.checkStringConstants(new MyClass("Hello", "World", 10, true));
        System.out.println("-------------------------------");
        MyClass my1 = new MyClass("Hello", "World", 10, true);
        MyClass2 my2 = new MyClass2("Hello2", "World2", 11L, false);

        ReflectionHelper.assign(my1,my2);
        System.out.println(my1);
        System.out.println(my2);
        System.out.println("-------------------------------");

        MyClass my3 = new MyClass("Hello", "World", 10, true);
        MyClass2 my4 = new MyClass2("Hello2", "World2", 11L, false);

        ReflectionHelper.assign(my4,my3);
        System.out.println(my4);
        System.out.println(my3);
    }
}
