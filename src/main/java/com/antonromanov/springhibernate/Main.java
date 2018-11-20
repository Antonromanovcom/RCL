package com.antonromanov.springhibernate;

import com.antonromanov.springhibernate.DAO.PremiumDAO;
import com.antonromanov.springhibernate.model.Premium;
import com.antonromanov.springhibernate.service.PremiumService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/Spring-Module.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

      //  PremiumDAO personDAO = context.getBean(PremiumDAO.class);
     //   List<Premium> list = personDAO.getPersonList();
     //   for(Premium p : list){
      //      System.out.println("Person List::"+p);
     //   }

        PremiumService greeterService = context.getBean(PremiumService.class);
        PremiumDAO dao = context.getBean(PremiumDAO.class);
        greeterService.printAll();



       // context.close();
    }

}
