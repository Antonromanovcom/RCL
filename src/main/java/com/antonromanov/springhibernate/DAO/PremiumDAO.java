package com.antonromanov.springhibernate.DAO;

import com.antonromanov.springhibernate.model.Premium;
import java.util.List;

/**
 *  Основное DAO.
 */
public interface PremiumDAO {
    /**
     * Вывести все записи.
     *
     * @return список Премий.
     */
    List<Premium> getPremiumList();
}
