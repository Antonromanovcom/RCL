package ru.reso.medchat.service;

import ru.reso.medchat.model.ComparableValues;
import ru.reso.resocalc.Entity.ComparedParam;
import ru.reso.resocalc.Service.Factories.MainFactory;
import ru.reso.resocalc.Utils.Factories.ConcreteFactories.*;
import ru.reso.resocalc.Utils.Factories.EntitiesUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import static ru.reso.resocalc.Service.ComplexCompair.*;
import static ru.reso.resocalc.Service.Factories.MainFactory.getResult;

/**
 * @author ROMAB
 */
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
            name = getDescriptionForWsCoeffCalc(name);
            result.put(name, comparableValues);
        }


        return result;
    }

    public LinkedHashMap<String, ComparableValues> coeffCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        String description;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        System.out.println("Мы в coeffCompare");

        for (String name : getFullCompare4Coefs(calcIdFirst, calcIdSecond).keySet()) {

            if (onlyDif==2) {
                if (!((getFullCompare4Coefs(calcIdFirst, calcIdSecond)).get(name)).getCompare()) {
                    ComparableValues comparableValues = new ComparableValues((getFullCompare4Coefs(calcIdFirst, calcIdSecond)).get(name));

                    name = getDescriptionForCoeff(name);
                    result.put(name, comparableValues);
                }
            } else{

                ComparableValues comparableValues = new ComparableValues((getFullCompare4Coefs(calcIdFirst, calcIdSecond)).get(name));
                name = getDescriptionForCoeff(name);
                result.put(name, comparableValues);

            }
        }


        return result;
    }

    public Integer checkMoreOrLess(Integer calcIdFirst, Integer calcIdSecond) {
        return checkCoefs(calcIdFirst, calcIdSecond);
    }

    public ArrayList<ComparableValues> getComparableValues() {
        return comparableValues;
    }

    public LinkedHashMap<String, ComparableValues> bonusesCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        String description;
        MainFactory mainFactory = new MainFactory();
        EntitiesUtils factory;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

      //  System.out.println("Мы в premiumCompare");
        factory = new BonusFactory();
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);

       if (hash!=null) {
           for (String name : hash.keySet()) {
            //   System.out.println("premiumCompare ---- " + name);

               if (onlyDif == 2) {
                   if (!(hash.get(name)).getCompare()) {

                       ComparableValues comparableValues = new ComparableValues((hash).get(name));
                       name = getDescriptionForBonuses(name);
                       result.put(name, comparableValues);

                   }
               } else {

                   ComparableValues comparableValues = new ComparableValues((hash).get(name));
                   name = getDescriptionForBonuses(name);
                   result.put(name, comparableValues);

               }

           }
       }
        return result;
    }

    public LinkedHashMap<String, ComparableValues> driversCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

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

        if (hash!=null) {
            for (String name : hash.keySet()) {

                if (onlyDif == 2) {
                    if (!(hash.get(name)).getCompare()) {

                        ComparableValues comparableValues = new ComparableValues((hash).get(name));
                        result.put(name, comparableValues);

                    }
                } else {

                    ComparableValues comparableValues = new ComparableValues((hash).get(name));
                    result.put(name, comparableValues);
                }
            }
        }


        return result;
    }

    public LinkedHashMap<String, ComparableValues> partnersCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

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

        if (hash!=null) {
            for (String name : hash.keySet()) {
                if (onlyDif == 2) {
                    if (!(hash.get(name)).getCompare()) {
                        ComparableValues comparableValues = new ComparableValues((hash).get(name));
                        result.put(name, comparableValues);
                    }
                } else {
                    ComparableValues comparableValues = new ComparableValues((hash).get(name));
                    result.put(name, comparableValues);
                }
            }
        }

        return result;
    }

    public LinkedHashMap<String, ComparableValues> commonLogsCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        EntitiesUtils factory;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        System.out.println("Мы в ComonLogsCompare");
        factory = new CommonLogsFactory();
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);

        if (hash!=null) {
            for (String name : hash.keySet()) {
                if (onlyDif == 2) {
                    if (!(hash.get(name)).getCompare()) {
                        ComparableValues comparableValues = new ComparableValues((hash).get(name));

                        if (!(getDescriptionForCommonLogs(name)==null)) {
                            name = getDescriptionForCommonLogs(name);
                        }

                        result.put(name, comparableValues);
                    }
                } else {
                    ComparableValues comparableValues = new ComparableValues((hash).get(name));

                    if (!(getDescriptionForCommonLogs(name)==null)) {
                        name = getDescriptionForCommonLogs(name);
                    }

                    result.put(name, comparableValues);
                }
            }
        }

        return result;
    }

    public LinkedHashMap<String, ComparableValues> fullCompareButOnlyDofference(Integer calcIdFirst, Integer calcIdSecond) {


        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {

            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;

        }

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();

        for (String name : getFullCompare(calcIdFirst, calcIdSecond).keySet()) {
            if (!((getFullCompare(calcIdFirst, calcIdSecond)).get(name)).getCompare()) {
                ComparableValues comparableValues = new ComparableValues((getFullCompare(calcIdFirst, calcIdSecond)).get(name));
                name = getDescriptionForWsCoeffCalc(name);
                result.put(name, comparableValues);
            }
        }


        return result;


    }

    public LinkedHashMap<String, ComparableValues> wsCalcLogsNewCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        EntitiesUtils factory;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }


        factory = new WsCalcLogFactory();
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);

        if (hash!=null) {
            for (String name : hash.keySet()) {
                if (onlyDif == 2) {
                    if (!(hash.get(name)).getCompare()) {
                        ComparableValues comparableValues = new ComparableValues((hash).get(name));

                        if (!(getDescriptionForWsCoeffCalc(name)==null)) {
                            name = getDescriptionForWsCoeffCalc(name);
                        }
                        result.put(name, comparableValues);
                    }
                } else {
                    ComparableValues comparableValues = new ComparableValues((hash).get(name));

                    if (!(getDescriptionForWsCoeffCalc(name)==null)) {
                        name = getDescriptionForWsCoeffCalc(name);
                    }

                    result.put(name, comparableValues);
                }
            }
        }

        return result;
    }

    public LinkedHashMap<String, ComparableValues> coeffCompare2(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();
        EntitiesUtils factory;

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }


        factory = new WsCoeffCalcFactory2();
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);

        if (hash!=null) {
            for (String name : hash.keySet()) {
                if (onlyDif == 2) {
                    if (!(hash.get(name)).getCompare()) {
                        ComparableValues comparableValues = new ComparableValues((hash).get(name));

                        if (!(getDescriptionForCoeff(name)==null)) {
                               name = getDescriptionForCoeff(name);
                         }

                        result.put(name, comparableValues);
                    }
                } else {
                    ComparableValues comparableValues = new ComparableValues((hash).get(name));

                      if (!(getDescriptionForCoeff(name)==null)) {
                         name = getDescriptionForCoeff(name);
                      }

                    result.put(name, comparableValues);
                }
            }
        }

        return result;
    }


    private String getDescriptionForCoeff(String name){
        String description="";


        if ((name != null) || (name != "")) {

            description = getDescriptionByCoefID(Integer.parseInt(name));

        }


        return description;
    }
    private String getDescriptionForBonuses(String name){
        String description="";


        if ((name != null) || (name != "")) {
       //     System.out.println("Мы в Ифе изменения дискрипшена для ПРЕМИЙ/БОНУСОВ");
            description = getDescriptionByPremiumID(Integer.parseInt(name));
        //    System.out.println("Дискрипшен достали для Премии - " + description);
        }


        return description;
    }
    private String getDescriptionForWsCoeffCalc(String name){
        String description="";


        if ((name != null) || (name != "")) {
            System.out.println("Мы в Ифе изменения дискрипшена для WsCoeffCals");
            description = getDescription4WsCoeffCalc(name);
            System.out.println("Дискрипшен достали для WsCoeffCals - " + description);
        }


        return description;
    }
    private String getDescriptionForCommonLogs(String name){
        String description="";


        if ((name != null) || (name != "")) {
            System.out.println("Мы в Ифе изменения дискрипшена для WsCommonLogs");
            description = getDescription4WsCommonLogs(name);
            System.out.println("Дискрипшен достали для WsCommonLogs - " + description);
        }


        return description;
    }


}
