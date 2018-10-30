package ru.reso.medchat.model;

import java.util.ArrayList;

/**
 * Класс под удаление....
 */
public class ComparableValuesList {

    private ArrayList<ComparableValues> comparableValues;

    public ArrayList<ComparableValues> getComparableValues() {
        return comparableValues;
    }

    public void setComparableValues(ArrayList<ComparableValues> comparableValues) {
        this.comparableValues = comparableValues;
    }

    public ArrayList<ComparableValues> getTestValues() {

        ArrayList<ComparableValues> mockComparableValues = new ArrayList<>();
        mockComparableValues.add(new ComparableValues("NOTAPPLYSPECPROGDISCOUNT", "14", "15"));

        return comparableValues;
    }


    public void fill() {



    }
}
