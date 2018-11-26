package com.antonromanov.springhibernate.controller;

import com.antonromanov.springhibernate.DAO.PremiumDAO;
import com.antonromanov.springhibernate.model.Premium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private PremiumDAO mainDao;

    @RequestMapping("/hi")
    public ModelAndView handleRequest() throws Exception {
        List<Premium> listUsers = mainDao.getPremiumList();
        ModelAndView model = new ModelAndView("UserList");
        model.addObject("userList", listUsers);
        return model;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("msg", "Hello Spring 4 Web MVC!");
        return "index";
    }

}
