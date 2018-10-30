package ru.reso.RCL.model;

/**
 * @author ROMAB
 *
 * Класс для связи с Моделью (jsp)/ То есть для передачи calc id 1 и calc id 2 ....
 */
public class CalcID {

    private Integer calcIdFirst;
    private Integer calcIdSecond;
    private Integer type; // тип отчета



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
