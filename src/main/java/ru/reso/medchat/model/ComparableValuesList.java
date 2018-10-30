package ru.reso.medchat.model;

import java.util.ArrayList;

import static ru.reso.resocalc.Service.ComplexCompair.getValuesFrom2LogsByKey;

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


    public ComparableValues getValuesByKey(String key) {



        String[] resulArray = getValuesFrom2LogsByKey(key);

        ComparableValues comparableValue  = new ComparableValues(key.trim(), resulArray[0], resulArray[1]);


       /* for (ComparableValues values : this.comparableValues) {

            if (values.getKey().equalsIgnoreCase(key)){
                ComparableValues result  = values;
            }

            System.out.println(values.getKey());
        } */


        return comparableValue;
    }

    public void fill() {



    }
}
