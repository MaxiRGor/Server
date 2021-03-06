package com.dksoft.formshift.serializedObject;

import java.io.Serializable;

public class CurrencyAmountSerialized implements Serializable {
    public CurrencyAmountSerialized() {
    }
    
    private int coinsAmount;
    private int crystalsAmount;

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
