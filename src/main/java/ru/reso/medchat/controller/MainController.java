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
 * @author ROMAB
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

        model.addAttribute("calcid1", calcID.getCalcId());
        model.addAttribute("calcid2", calcID.getCalcIdSecond());
        model.addAttribute("type", calcID.getType());



        if ((calcID.getType()==null) ||(calcID.getCalcId()==null) || (calcID.getCalcIdSecond()==null)){
            return "error1";
        } else{


        //1 - full
        //2 - light

        ResoComparator resoComparator = new ResoComparator();


    switch (calcID.getType()) {
        case 1:
            System.out.println("Type выбран - " + calcID.getType());


            if ((resoComparator.checkMoreOrLess(calcID.getCalcId(), calcID.getCalcIdSecond())) == 2) {
                model.addAttribute("calcid1", calcID.getCalcIdSecond());
                model.addAttribute("calcid2", calcID.getCalcId());
            }

            LinkedHashMap<String, ComparableValues> fullCompareResult = resoComparator.fullCompare(calcID.getCalcId(), calcID.getCalcIdSecond());
            LinkedHashMap<String, ComparableValues> fullCoefsCompareResult = resoComparator.coeffCompare(calcID.getCalcId(), calcID.getCalcIdSecond(),1);

            if (fullCoefsCompareResult.isEmpty()) {
                System.out.println("fullCoefsCompareResult is NULL");
                fullCoefsCompareResult.clear();
            }


            LinkedHashMap<String, ComparableValues> bonuses = resoComparator.bonusesCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);

            if (bonuses.isEmpty()) {
                System.out.println("bonuses is NULL");
                bonuses.clear();
            }

            LinkedHashMap<String, ComparableValues> drivers = resoComparator.driversCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);


            if (drivers.isEmpty()) {
                System.out.println("DRIVERS is NULL");
                drivers.clear();
            }

                /*for (String name : drivers.keySet()) {

                    String key = name;
                    ComparableValues value = drivers.get(name);
                    System.out.println(key + " -  " + value.getValue1());
                    //     Logger.getLogger("").log(Level.SEVERE, key + " -  " + value, "Инфо");
                } */


            LinkedHashMap<String, ComparableValues> partners = resoComparator.partnersCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);

            if (partners.isEmpty()) {
                System.out.println("PARTNERS is NULL");
                partners.clear();
            }


            LinkedHashMap<String, ComparableValues> commonLogs = resoComparator.commonLogsCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);

            if (commonLogs.isEmpty()) {
                System.out.println("commonLogs is NULL");
                commonLogs.clear();
            }

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
            model.addAttribute("map", lightCompareResult);
            break;

        case 3:
            System.out.println("Type выбран - " + calcID.getType());

            if ((resoComparator.checkMoreOrLess(calcID.getCalcId(), calcID.getCalcIdSecond())) == 2) {
                model.addAttribute("calcid1", calcID.getCalcIdSecond());
                model.addAttribute("calcid2", calcID.getCalcId());
            }

            LinkedHashMap<String, ComparableValues> fullCompareResultOnlyDifference = resoComparator.fullCompareButOnlyDofference(calcID.getCalcId(), calcID.getCalcIdSecond());
            LinkedHashMap<String, ComparableValues> fullCompareCoefsOnlyDifference = resoComparator.coeffCompare(calcID.getCalcId(), calcID.getCalcIdSecond(),2);
            LinkedHashMap<String, ComparableValues> bonusesOnlyDifference = resoComparator.bonusesCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);
            LinkedHashMap<String, ComparableValues> driversOnlyDifference = resoComparator.driversCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);


            if (driversOnlyDifference.isEmpty()) {
                System.out.println("DRIVERS is NULL");
                driversOnlyDifference.clear();
            }


            LinkedHashMap<String, ComparableValues> partnersOnlyDifference = resoComparator.partnersCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);

            if (partnersOnlyDifference.isEmpty()) {
                System.out.println("DRIVERS is NULL");
                partnersOnlyDifference.clear();
            }

            LinkedHashMap<String, ComparableValues> commonLogsOnlyDifference = resoComparator.commonLogsCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);

            model.addAttribute("map", fullCompareResultOnlyDifference);
            model.addAttribute("coefs", fullCompareCoefsOnlyDifference);
            model.addAttribute("bonuses", bonusesOnlyDifference);
            model.addAttribute("drivers", driversOnlyDifference);
            model.addAttribute("partners", partnersOnlyDifference);
            model.addAttribute("commonLogs", commonLogsOnlyDifference);
            returnURL = "fullreport";
            break;
    }
        }

        return returnURL;
    }

    @RequestMapping(value = "/ho", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "CalcId", new CalcID());
    }


}
