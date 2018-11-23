package com.antonromanov.springhibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entity.
 */
@Entity
@SuppressWarnings("PMD")
@Table(name = "WS_PREM_TEST")
public class Premium {


    /**
     * Primary key.
     */
    @Id
    @Column(name="ID", nullable=false)
    @SequenceGenerator(name="my_seq", sequenceName="WS_PREM_TEST_ID_SEQ")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="my_seq")
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
