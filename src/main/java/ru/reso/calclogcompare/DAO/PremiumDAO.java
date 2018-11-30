package ru.reso.calclogcompare.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.reso.calclogcompare.model.Premium;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Основное DAO.
 */
@Repository
@Transactional
public interface PremiumDAO extends JpaRepository<Premium, Long> {
     /*
      * Вывести все записи.
      *
      * @return список Премий.
      */
  //  List<Premium> getPremiumList();


    /**
     * Вывести конкретную записи по ID.
     * Версия через JPA.
     *
     * @return Премия.
     */
   /* @Query(value = "select s from WS_PREM_TEST s WHERE s.ID =:#{#param}")
    Premium getPremiumByID(@Param("param") Integer param);*/

}
