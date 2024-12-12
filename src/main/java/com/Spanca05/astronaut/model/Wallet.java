package com.Spanca05.astronaut.model;

public class Wallet {
    private static int total = 0;

    public int getTotal() {
        return total;
    }

    public void addToTotal(int amount) {
        total += amount;
    }

    public void subtractFromTotal(int amount) {
        total -= amount;
    }
}
