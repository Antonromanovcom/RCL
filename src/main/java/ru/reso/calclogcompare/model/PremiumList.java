package ru.reso.calclogcompare.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


public class PremiumList {

    @Getter
    @Setter
    private ArrayList<Premium> premiumList;


    public PremiumList() {
        premiumList = new ArrayList<>();
    }
}
