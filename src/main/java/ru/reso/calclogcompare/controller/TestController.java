package ru.reso.calclogcompare.controller;

import ru.reso.calclogcompare.DAO.PremiumDAO;
import ru.reso.calclogcompare.Service.PremiumService;
import ru.reso.calclogcompare.model.Premium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * Основной контроллер, который и выплевывает
 * данные на jsp
 */
@Controller
public class TestController {

    @Autowired
    PremiumService premiumService;


    //PremiumDAO licenseRepository;

    /*@Autowired
    public void setUserService(PremiumService premiumService) {
        this.premiumService = premiumService;
    }*/



    /**
     * Инжектим ДАО
     *//*
    @Autowired
    private PremiumDAO mainDao;*/

    /**
     * Отрабатываем запрос /hi.
     * Сюда выплюнем список из тестовой
     * таблицы БД.
     *
     * @return the model and view
     * @throws Exception the exception
     */
   /* @RequestMapping("/hi")
    public ModelAndView handleRequest() throws Exception {
        List<Premium> listUsers = licenseRepository.getPremiumList();
        ModelAndView model = new ModelAndView("UserList");
        model.addObject("userList", listUsers);
        return model;
    }*/


    @RequestMapping("/ho")
    public ModelAndView handleRequest2() throws Exception {
        List<Premium> listUsers = new ArrayList<>() ;
        listUsers.add(premiumService.getPremById(Long.valueOf(1)));
        listUsers.add(premiumService.getPremById(Long.valueOf(2)));
        listUsers.add(premiumService.getPremById(Long.valueOf(3)));
        ModelAndView model = new ModelAndView("UserList");
        model.addObject("userList", listUsers);
        return model;
    }


    /**
     * Просто пустая тестовая страничка.
     *
     * @param map the map
     * @return the string
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("msg", "Hello Spring 4 Web MVC!");
        return "index";
    }

}
