package com.example.demo.serializedObject;

import java.io.Serializable;

public class CoinsAmountSerialized implements Serializable {
    private int coinsAmount;

    public CoinsAmountSerialized() {
    }

    public CoinsAmountSerialized(int coinsAmount) {
        this.coinsAmount = coinsAmount;
    }

    public int getCoinsAmount() {
        return coinsAmount;
    }

    public void setCoinsAmount(int coinsAmount) {
        this.coinsAmount = coinsAmount;
    }
}
