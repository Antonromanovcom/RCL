package ru.reso.calclogcompare.model.test;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity для запроса Премиум через RISK
 * с помощью REST.
 */
public class Risk {

    /**
     * Risk.
     */
    @Getter
    @Setter
    private String risk;

    @Override
    public String toString() {
        return "Risk{" +
                "risk = '" + risk + '\'' +
                '}';
    }
}
