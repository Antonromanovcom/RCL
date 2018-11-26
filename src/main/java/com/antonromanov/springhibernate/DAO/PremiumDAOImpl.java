package com.antonromanov.springhibernate.DAO;

import com.antonromanov.springhibernate.model.Premium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import javax.inject.Inject;
import java.util.List;

/**
 * JPA based implementation of GreeterDao.
 */
@Repository
public class PremiumDAOImpl implements PremiumDAO {

    /**
     * JPA EM factory, provided by Spring.
     */
    @Autowired
    private SessionFactory sessionFactory;


   /* public PremiumDAOImpl() {
    }

    public PremiumDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/


    /**
     * Get all entities.
     *
     * @return - list of all premiums
     */
    public final List<Premium> getPremiumList() {
        return sessionFactory.openSession()
                .createCriteria(Premium.class)
                .list();

    }
}
