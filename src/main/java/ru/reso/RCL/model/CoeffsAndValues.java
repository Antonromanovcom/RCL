package ru.reso.RCL.model;

/**
 * Класс необходимый для хранения и обработки коэфициентов в ComparableValues
 */
public class CoeffsAndValues {

    /**ИД расчета     */
    private long calcid;
    /**Ид коэффициента    */
    private int coefid;
    /**Значение коэффициента*/
    private double value;


    public long getCalcid() {
        return calcid;
    }

    public void setCalcid(long calcid) {
        this.calcid = calcid;
    }

    public int getCoefid() {
        return coefid;
    }

    public void setCoefid(int coefid) {
        this.coefid = coefid;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
