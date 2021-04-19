package com.mpetrov.javaschool.hw.lesson4.exceptions_1;

import com.mpetrov.javaschool.hw.lesson4.exceptions_1.exceptions.AccountIsLockedException;
import com.mpetrov.javaschool.hw.lesson4.exceptions_1.exceptions.ConsoleExceptionsPrinter;
import com.mpetrov.javaschool.hw.lesson4.exceptions_1.exceptions.NotEnoughMoneyException;

import java.util.Scanner;

public class TerminalImpl {

    private int pinDigitLeft;
    private final TerminalServer terminalServer;
    private final PinValidator pinValidator;
    private boolean accessGranted;

    public TerminalImpl() {
        pinValidator = new PinValidator();
        terminalServer = new TerminalServer();
        pinDigitLeft = 4;
        accessGranted = false;
    }

    public boolean inputPin() {
        int pinTry = 0;
        Scanner scanner = new Scanner(System.in);

        while (pinDigitLeft > 0) {
            String input = scanner.next();
            if (input.matches("^\\d$")) {
                pinTry += Integer.parseInt(input) * Math.pow(10, pinDigitLeft - 1);
                pinDigitLeft--;
            } else System.out.println("Wrong input,please input digit");
        }
        pinDigitLeft = 4;
        try {
            accessGranted = pinValidator.validatePin(pinTry);
        } catch (
                AccountIsLockedException e) {
            ConsoleExceptionsPrinter.printException(e);
        }
        return accessGranted;
    }

    public void putMoney(int sum) {
        if (accessGranted == true && sum % 100 == 0) {
            terminalServer.putMoney(sum);
        }
    }

    public void getMoney(int sum) {
        if (accessGranted == true && sum % 100 == 0) {
            try {
                terminalServer.withdrawMoney(sum);
            } catch (NotEnoughMoneyException e) {
                ConsoleExceptionsPrinter.printException(e);
            }
        }
    }
}
