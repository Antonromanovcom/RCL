package com.antonromanov.springhibernate;

import com.antonromanov.springhibernate.DAO.UserDAO;
import com.antonromanov.springhibernate.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/Spring-Module.xml");

        UserDAO personDAO = context.getBean(UserDAO.class);
        List<User> list = personDAO.getPersonList();
        for(User p : list){
            System.out.println("Person List::"+p);
        }

        context.close();
    }

}
