package com.antonromanov.springhibernate.service;

import com.antonromanov.springhibernate.DAO.PremiumDAO;
import com.antonromanov.springhibernate.model.Premium;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;


@Service
public class PremiumServiceImpl implements PremiumService{

    /**
     * Our data layer.
     */
    @Inject
    private PremiumDAO dao;

    public void printAll() {

        List<Premium>  prm = dao.getPremiumList();
        Iterator<Premium> it = prm.iterator();
        if (it.hasNext()) {
            System.out.println(it.next().toString());
        }


    }

    public final String getOne() {

        List<Premium>  prm = dao.getPremiumList();
        Iterator<Premium> it = prm.iterator();
        if (!it.hasNext()) {
            return "No greets";
        }
        Premium greeter = it.next();
        return greeter.getName();


    }
}
