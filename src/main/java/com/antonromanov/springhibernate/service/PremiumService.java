package com.antonromanov.springhibernate.service;


/**
 * User greeting interface.
 */
public interface PremiumService {

    /**
     * Print all entities.
     */
    void printAll();

    /**
     * Get one entity.
     *
      * @return - one entities in String.
     */
    String getOne();

}
