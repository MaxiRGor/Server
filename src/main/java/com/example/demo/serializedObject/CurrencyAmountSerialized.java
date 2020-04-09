package com.example.demo.serializedObject;

import java.io.Serializable;

public class CurrencyAmountSerialized implements Serializable {

    private int coinsAmount;
    private int crystalsAmount;

    public CurrencyAmountSerialized() {
    }

    public CurrencyAmountSerialized(int coinsAmount, int crystalsAmount) {
        this.coinsAmount = coinsAmount;
        this.crystalsAmount = crystalsAmount;
    }

    public int getCrystalsAmount() {
        return crystalsAmount;
    }

    public void setCrystalsAmount(int crystalsAmount) {
        this.crystalsAmount = crystalsAmount;
    }

    public int getCoinsAmount() {
        return coinsAmount;
    }

    public void setCoinsAmount(int coinsAmount) {
        this.coinsAmount = coinsAmount;
    }
}
