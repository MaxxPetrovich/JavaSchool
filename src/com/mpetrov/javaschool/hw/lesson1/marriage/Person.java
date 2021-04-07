package com.mpetrov.javaschool.hw.lesson1.marriage;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean marry(Person person) {
        if ((man == person.man) ||
                ((spouse != null) && (spouse == person))) {
            return false;
        }

        if (person.spouse != null) {
            person.spouse.divorce();
            person.divorce();
        }

        if (spouse != null) {
            spouse.divorce();
            this.divorce();
        }

        spouse = person;
        person.spouse = this;
        return true;
    }

    public void divorce() {
        spouse = null;
    }

}
