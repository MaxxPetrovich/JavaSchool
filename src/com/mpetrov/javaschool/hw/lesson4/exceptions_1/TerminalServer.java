package com.mpetrov.javaschool.hw.lesson4.exceptions_1;

import com.mpetrov.javaschool.hw.lesson4.exceptions_1.exceptions.NotEnoughMoneyException;

public class TerminalServer {
    private int sum = 0;

    public void putMoney(int sum) {
        this.sum += sum;
    }

    public int withdrawMoney(int sum) throws NotEnoughMoneyException {
        int result = 0;
        if (sum <= this.sum) {
            this.sum -= sum;
            result = sum;
        }
        else throw new NotEnoughMoneyException("There is not enough money on your account");
        return result;
    }
}
