package com.antonromanov.springhibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity.
 */
@Entity
@SuppressWarnings("PMD")
@Table(name = "WS_DCT_PREMIUM")
public class Premium {


    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;


    /**
     * Name.
     */
    @Getter
    @Setter
    private String name;

    /**
     * Descripotion.
     */
    @Getter
    @Setter
    private String description;

    /**
     * Risk.
     */
    @Getter
    @Setter
    private String risk;



    @Override
    public final String toString() {
        return "Premium{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

}
