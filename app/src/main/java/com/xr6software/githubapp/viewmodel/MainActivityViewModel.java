package com.xr6software.githubapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xr6software.githubapp.model.Dice;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<Integer> rollValueLivedata = new MutableLiveData<>();
    private Dice dice = new Dice(1);

    public void createDice(String diceSides) {
        if (dice.getDiceSides() != Integer.valueOf(diceSides)) {
            dice.setDiceSides(Integer.valueOf(diceSides));
        }
        rollValueLivedata.setValue(dice.rollDice());
    }

    public LiveData<Integer> getRollValue() {
        return rollValueLivedata;
    }

}
