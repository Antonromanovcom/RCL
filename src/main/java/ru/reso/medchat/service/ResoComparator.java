package ru.reso.medchat.service;

import ru.reso.medchat.model.ComparableValues;
import ru.reso.resocalc.Entity.ComparedParam;
import ru.reso.resocalc.Service.Factories.MainFactory;
import ru.reso.resocalc.Utils.Factories.ConcreteFactories.BonusFactory;
import ru.reso.resocalc.Utils.Factories.ConcreteFactories.CommonLogsFactory;
import ru.reso.resocalc.Utils.Factories.ConcreteFactories.DriverFactory;
import ru.reso.resocalc.Utils.Factories.ConcreteFactories.PartnerFactory;
import ru.reso.resocalc.Utils.Factories.EntitiesUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import static ru.reso.resocalc.Service.ComplexCompair.*;
import static ru.reso.resocalc.Service.Factories.MainFactory.getResult;


public class ResoComparator {

    private ArrayList<ComparableValues> comparableValues;

    public LinkedHashMap<String, Integer> lightCompare(Integer calcIdFirst, Integer calcIdSecond) {
        return getLightCompare(calcIdFirst, calcIdSecond);
    }

    public LinkedHashMap<String, ComparableValues> fullCompare(Integer calcIdFirst, Integer calcIdSecond) {

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {

            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;

        }

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();

        for (String name : getFullCompare(calcIdFirst, calcIdSecond).keySet()) {
            ComparableValues comparableValues = new ComparableValues((getFullCompare(calcIdFirst, calcIdSecond)).get(name));
            result.put(name, comparableValues);
        }


        return result;
    }

    public LinkedHashMap<String, ComparableValues> coeffCompare(Integer calcIdFirst, Integer calcIdSecond) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        String description;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        System.out.println("Мы в coeffCompare");

        for (String name : getFullCompare4Coefs(calcIdFirst, calcIdSecond).keySet()) {

            ComparableValues comparableValues = new ComparableValues((getFullCompare4Coefs(calcIdFirst, calcIdSecond)).get(name));

            //if ((comparableValues.getKey()!=null)||(comparableValues.getKey()!="")) {
            if ((name!=null)||(name!="")) {
                System.out.println("Мы в Ифе изменения дискрипшена");
                //description = getDescriptionByCoefID(Integer.parseInt(comparableValues.getKey()));
                description = getDescriptionByCoefID(Integer.parseInt(name));
                System.out.println("Дискрипшен достали - " + description);
                //comparableValues.setKey(description);
                name = description;
            }


            result.put(name, comparableValues);
        }


        return result;
    }

    public Integer checkMoreOrLess (Integer calcIdFirst, Integer calcIdSecond){
        return checkCoefs(calcIdFirst, calcIdSecond);
    }

    public ArrayList<ComparableValues> getComparableValues() {
        return comparableValues;
    }

    public LinkedHashMap<String, ComparableValues> bonusesCompare(Integer calcIdFirst, Integer calcIdSecond) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        //String description;
        MainFactory mainFactory = new MainFactory();
        EntitiesUtils factory;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        System.out.println("Мы в premiumCompare");
        factory = new BonusFactory();
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);

        for (String name : hash.keySet()) {

            ComparableValues comparableValues = new ComparableValues((hash).get(name));


            /*if ((name!=null)||(name!="")) {
                System.out.println("Мы в Ифе изменения дискрипшена");
                description = getDescriptionByCoefID(Integer.parseInt(name));
                System.out.println("Дискрипшен достали - " + description);
                name = description;
            } */


            result.put(name, comparableValues);
        }


        return result;
    }

    public LinkedHashMap<String, ComparableValues> driversCompare(Integer calcIdFirst, Integer calcIdSecond) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        MainFactory mainFactory = new MainFactory();
        EntitiesUtils factory;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        System.out.println("Мы в DriversCompare");
        factory = new DriverFactory();
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);

        for (String name : hash.keySet()) {

            ComparableValues comparableValues = new ComparableValues((hash).get(name));


            /*if ((name!=null)||(name!="")) {
                System.out.println("Мы в Ифе изменения дискрипшена");
                description = getDescriptionByCoefID(Integer.parseInt(name));
                System.out.println("Дискрипшен достали - " + description);
                name = description;
            } */


            result.put(name, comparableValues);
        }


        return result;
    }

    public LinkedHashMap<String, ComparableValues> partnersCompare(Integer calcIdFirst, Integer calcIdSecond) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        MainFactory mainFactory = new MainFactory();
        EntitiesUtils factory;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        System.out.println("Мы в PartnersCompare");
        factory = new PartnerFactory();
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);

        for (String name : hash.keySet()) {
            ComparableValues comparableValues = new ComparableValues((hash).get(name));
            result.put(name, comparableValues);
        }

        return result;
    }

    public LinkedHashMap<String, ComparableValues> commonLogsCompare(Integer calcIdFirst, Integer calcIdSecond) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        EntitiesUtils factory;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        System.out.println("Мы в CoomonLogsCompare");
        factory = new CommonLogsFactory();
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);

        for (String name : hash.keySet()) {
            ComparableValues comparableValues = new ComparableValues((hash).get(name));
            result.put(name, comparableValues);
        }

        return result;
    }



}
