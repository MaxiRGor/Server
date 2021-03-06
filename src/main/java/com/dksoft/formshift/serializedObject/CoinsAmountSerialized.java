package com.dksoft.formshift.serializedObject;

import java.io.Serializable;

public class CoinsAmountSerialized implements Serializable {
    public CoinsAmountSerialized() {
    }

    private int coinsAmount;

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
