package ru.reso.calclogcompare.service;

import ru.reso.calclogcompare.model.*;
import ru.reso.calclogcompare.model.common.Request;
import ru.reso.calclogcompare.model.test.Premium;

import java.util.List;


/**
 * Сервис, обслуживающий DAO.
 */
public interface PremiumService {

    /**
     * Выдать премию по id
     * через findOne.
     *
     * @param id - id премии.
     * @return - премия.
     */
    Premium getPremById(Long id);

    /**
     * Выдать все премии.
     *
     * @return список премий.
     */
    List<Premium> getAllInString();

    /**
     * Выдать конкретную премию
     * по id через @Query.
     *
     * @param id - id премии.
     * @return - премия.
     */
    Premium getPremById2(Integer id);

    List<Premium> getPremByRisk(String risk);

    void test();

    Request test2();

    Request test2(Long id1, Long id2);

    Integer getMismatchesCount (Long id1, Long id2, Integer entityType);

    LoggingEntity getEntity(Long calcId, Integer entityType);

    Request getCompare(Long id1, Long id2, Integer entityType);


}
