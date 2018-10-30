/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.reso.medchat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.reso.medchat.model.ComparableValues;
import ru.reso.medchat.model.ComparableValuesList;
import ru.reso.medchat.service.ResoComparator;
import ru.reso.medchat.model.CalcID;
import ru.reso.medchat.model.HelloMessage;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author john
 */
@Controller
public class MainController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        //map.put("msg", "Hello Spring 4 Web MVC!");
        return "start";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hello(ModelMap map) {

        HelloMessage helloMessage = new HelloMessage();
        String name = "1";
        map.put("msg", helloMessage.Test());
        return "test";

    }

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public String aGet() {

        //HelloMessage helloMessage = new HelloMessage();
        String name = "1";
        //map.put("msg", helloMessage.Test());
        return name;

    }

    @RequestMapping(value = "/he", method = RequestMethod.POST)
    public String submit(@ModelAttribute("CalcId") CalcID calcID, BindingResult result, ModelMap model) {
        String returnURL = "result";
        System.out.println("Зашли сюда....");

        //ComparableValuesList

        model.addAttribute("calcid1", calcID.getCalcId());
        model.addAttribute("calcid2", calcID.getCalcIdSecond());
        model.addAttribute("type", calcID.getType());

        //1 - full
        //2 - light

        ResoComparator resoComparator = new ResoComparator();

        switch (calcID.getType()) {
            case 1:
                System.out.println("Type выбран - " + calcID.getType());

                //Integer check = resoComparator.checkMoreOrLess(calcID.getCalcId(), calcID.getCalcIdSecond());
                if ((resoComparator.checkMoreOrLess(calcID.getCalcId(), calcID.getCalcIdSecond())) == 2) {
                    model.addAttribute("calcid1", calcID.getCalcIdSecond());
                    model.addAttribute("calcid2", calcID.getCalcId());
                }

                LinkedHashMap<String, ComparableValues> fullCompareResult = resoComparator.fullCompare(calcID.getCalcId(), calcID.getCalcIdSecond());
                LinkedHashMap<String, ComparableValues> fullCoefsCompareResult = resoComparator.coeffCompare(calcID.getCalcId(), calcID.getCalcIdSecond());
                LinkedHashMap<String, ComparableValues> bonuses = resoComparator.bonusesCompare(calcID.getCalcId(), calcID.getCalcIdSecond());
                LinkedHashMap<String, ComparableValues> drivers = resoComparator.driversCompare(calcID.getCalcId(), calcID.getCalcIdSecond());
                LinkedHashMap<String, ComparableValues> partners = resoComparator.partnersCompare(calcID.getCalcId(), calcID.getCalcIdSecond());
                LinkedHashMap<String, ComparableValues> commonLogs = resoComparator.commonLogsCompare(calcID.getCalcId(), calcID.getCalcIdSecond());

                model.addAttribute("map", fullCompareResult);
                model.addAttribute("coefs", fullCoefsCompareResult);
                model.addAttribute("bonuses", bonuses);
                model.addAttribute("drivers", drivers);
                model.addAttribute("partners", partners);
                model.addAttribute("commonLogs", commonLogs);


                returnURL = "fullreport";
                break;

            case 2:
                System.out.println("Type выбран - " + calcID.getType());
                LinkedHashMap<String, Integer> lightCompareResult = resoComparator.lightCompare(calcID.getCalcId(), calcID.getCalcIdSecond());





     /*   for (String name: lightCompareResult.keySet()){

            String key = name;
            Integer value = lightCompareResult.get(name);
            System.out.println(key + " -  " + value);
        }

*/

                //model.addAttribute("compairresult", lightCompareResult.get("TARGETCOMPANY"));
                model.addAttribute("map", lightCompareResult);


                break;
        }


        return returnURL;


    }

    @RequestMapping(value = "/ho", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "CalcId", new CalcID());
    }


}
