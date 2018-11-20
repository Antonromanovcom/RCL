package com.antonromanov.springhibernate.DAO;

import com.antonromanov.springhibernate.model.Premium;
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
    @Inject
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public List<Premium> getPremiumList() {
        return sessionFactory.openSession().createCriteria(Premium.class).list();

    }
}
