package ru.reso.RCL.model;

import ru.reso.resocalc.Entity.ComparedParam;
import java.util.ArrayList;

/**
 * Класс, который мы выплевываем в качестве value в хэшмепе наружу, в модель, на jsp
 */
public class ComparableValues {

    private String key; //ключ. Обычно имя поля
    private String value1; // значение по calc id 1
    private String value2; // значение по calc id 2
    private ArrayList<CoeffsAndValues> coeffCalcList = new ArrayList<>(); // ArrayList исключительно коэфициентов.

    public ComparableValues(String newkey, String val1, String val2) {
        this.key = newkey;
        this.value1 = val1;
        this.value2 = val2;
    }

    public ComparableValues(ComparedParam comparedParam) {
        this.key = comparedParam.getKey();
        this.value1 = comparedParam.getVal1();
        this.value2 = comparedParam.getVal2();
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<CoeffsAndValues> getCoeffCalcList() {
        return coeffCalcList;
    }

    public void setCoeffCalcList(ArrayList<CoeffsAndValues> coeffCalcList) {
        this.coeffCalcList = coeffCalcList;
    }
}
