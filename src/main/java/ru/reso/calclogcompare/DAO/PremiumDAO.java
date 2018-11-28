package ru.reso.calclogcompare.DAO;

import ru.reso.calclogcompare.model.Premium;
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
