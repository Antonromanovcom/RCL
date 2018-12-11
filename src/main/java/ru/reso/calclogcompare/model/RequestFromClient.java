package ru.reso.calclogcompare.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Модель запроса со стороны клиента
 */
public class RequestFromClient {

    /**
     * CalcID.
     */
    @Getter
    @Setter
    private Long calcID;


    /**
     * Тип расчета/сравнения.
     */
    @Getter
    @Setter
    private Integer compareType;


    @Override
    public String toString() {
        return "RequestFromClient{" +
                "calcID=" + calcID +
                ", compareType=" + compareType +
                '}';
    }
}
