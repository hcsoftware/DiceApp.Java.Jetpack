package com.xr6software.githubapp.model;

import java.util.Random;

public class Dice {

    private Integer diceSides;

    public Dice(Integer diceSides) {
        this.diceSides = diceSides;
    }

    public Integer rollDice(){

        return new Random().nextInt(diceSides) + 1;

    }

    public Integer getDiceSides() {
        return diceSides;
    }

    public void setDiceSides(Integer diceSides) {
        this.diceSides = diceSides;
    }
}
