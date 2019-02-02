package com.eating;

public class Eating {

    int totalNumberOfItems;
    int eatItems;

    public Eating(int totalNumberOfItems) {
        this.totalNumberOfItems = totalNumberOfItems;
    }

    public void setEatenItems(int aten) {
        eatItems = aten;
    }

    public int getLeftOver() {
        return (totalNumberOfItems - eatItems);
    }

}
