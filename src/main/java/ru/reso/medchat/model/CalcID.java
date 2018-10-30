package ru.reso.medchat.model;

public class CalcID {

    private Integer calcIdFirst;
    private Integer calcIdSecond;
    private Integer type;



    public Integer getCalcId() {
        return calcIdFirst;
    }

    public void setCalcId(Integer calcId) {
        this.calcIdFirst = calcId;
    }

    public Integer getCalcIdSecond() {
        return calcIdSecond;
    }

    public void setCalcIdSecond(Integer calcIdSecond) {
        this.calcIdSecond = calcIdSecond;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
