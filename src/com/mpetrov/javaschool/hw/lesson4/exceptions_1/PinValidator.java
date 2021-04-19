package com.mpetrov.javaschool.hw.lesson4.exceptions_1;

import com.mpetrov.javaschool.hw.lesson4.exceptions_1.exceptions.AccountIsLockedException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PinValidator {
    private int attemptsLeft = 3;
    private final int pinCode = 1234;
    private LocalDateTime accountBlocked = LocalDateTime.now().minusDays(1);


    public boolean validatePin(int pin) throws AccountIsLockedException {
        if (LocalDateTime.now().until(accountBlocked, ChronoUnit.SECONDS) > 0)
            throw new AccountIsLockedException("Your account is locked, please try to input pin after " + accountBlocked);
        if (attemptsLeft > 0) {
            if (pin == pinCode) {
                attemptsLeft = 3;
                return true;
            } else {
                attemptsLeft--;
            }
        } else {
            accountBlocked = LocalDateTime.now();
            attemptsLeft = 3;
        }
        return false;
    }
}
