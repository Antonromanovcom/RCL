package ru.reso.calclogcompare.model.test;

import lombok.Getter;
import lombok.Setter;
import ru.reso.calclogcompare.model.test.Premium;

import java.util.ArrayList;


public class PremiumList {

    @Getter
    @Setter
    private ArrayList<Premium> premiumList;


    public PremiumList() {
        premiumList = new ArrayList<>();
    }
}
