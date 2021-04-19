package com.mpetrov.javaschool.hw.lesson4.exceptions_1;

public class Program {
    public static void main(String[] args) {
        TerminalImpl term = new TerminalImpl();

        while(true){
            System.out.println("Input pin");
            if(term.inputPin()) break;
            System.out.println("Try again");
        }
        term.putMoney(1000);
        term.getMoney(33);
        term.getMoney(100);
        term.getMoney(1100);
    }
}
