package com.mpetrov.javaschool.hw.lesson1.marriage;

public class Program {
    public static void main(String[] args) {
        Person john = new Person(true, "John");
        Person jane = new Person(false, "Jane");
        Person alex = new Person(true, "Alex");
        Person lisa = new Person(false, "John");

        System.out.println("John marry Alex " + john.marry(alex));
        System.out.println("John marry Jane " + john.marry(jane));
        System.out.println("John marry Jane again" + john.marry(jane));
        System.out.println("Alex marry Lisa " + alex.marry(lisa));
        System.out.println("John marry Lisa " + john.marry(lisa));
        System.out.println("Jane marry Lisa " + jane.marry(lisa));
        System.out.println("John marry Lisa again " + john.marry(lisa));
        System.out.println("Alex marry Jane " + alex.marry(jane));
    }
}
