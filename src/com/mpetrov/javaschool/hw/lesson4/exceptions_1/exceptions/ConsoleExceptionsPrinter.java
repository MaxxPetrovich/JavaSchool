package com.mpetrov.javaschool.hw.lesson4.exceptions_1.exceptions;

public class ConsoleExceptionsPrinter {
    public static void printException(Throwable throwable){
        System.out.println(throwable.getMessage());
    }
}
