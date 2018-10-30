package ru.reso.medchat.service;

import ru.reso.medchat.model.ComparableValues;
import ru.reso.resocalc.Entity.ComparedParam;
import ru.reso.resocalc.Factories.ConcreteFactories.*;
import ru.reso.resocalc.Factories.EntitiesUtils;
import ru.reso.resocalc.Factories.MainFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import static ru.reso.resocalc.Factories.MainFactory.getResult;
import static ru.reso.resocalc.Service.ComplexCompair.*;

/**
 * @author ROMAB
 *
 * Главный сервис сравнения. Здесь весь функционал...
 *
 */
public class ResoComparator {

    private ArrayList<ComparableValues> comparableValues; // не факт, что он тут нужен вообще. Думаю, надо удалять...

    // Проверка коэфиционетов: если по второму больше данных, меняем местами...
    public Integer checkMoreOrLess(Integer calcIdFirst, Integer calcIdSecond) {
        return checkCoefs(calcIdFirst, calcIdSecond);
    }

    // Геттер
    public ArrayList<ComparableValues> getComparableValues() {
        return comparableValues;
    }

    /**
     * Сравниваем Премии
     * @param calcIdFirst - первый кальк айди
     * @param calcIdSecond - второй кальк айди
     * @param onlyDif - тип отчета
     * @return - хэш меп
     */
    public LinkedHashMap<String, ComparableValues> bonusesCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>();     // ХэшМеп куда будем пихать результат
        EntitiesUtils factory; // Фабрика

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) { // проверяем кол-во записей по коэфициентам. Не стоит ли менять их местами...
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }


        factory = new BonusFactory(); // создаем Конкретную фабрику - Премии
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond); // Наполняем ХэшМеп

       if (hash!=null) { // проверяем полученый из БД хэш на нуль
           for (String name : hash.keySet()) { // бегаем в цикле по хэшу
               if (onlyDif == 2) { // какой тип отчета выбран? Отчет только по несоответствиям
                   if (!(hash.get(name)).getCompare()) { //если флаг сравнения ложь (то есть не равны)
                       ComparableValues comparableValues = new ComparableValues((hash).get(name)); //создаем новый объект ComparableValues, заполняя в констр-ре данными из хэша
                       name = getDescriptionForBonuses(name); // - подставляем вместо ключа-имени дескрипшен
                       result.put(name, comparableValues); // пихаем в ХэшМэп
                   }
               } else {
                   ComparableValues comparableValues = new ComparableValues((hash).get(name)); //создаем новый объект ComparableValues, заполняя в констр-ре данными из хэша
                   name = getDescriptionForBonuses(name); // - подставляем вместо ключа-имени дескрипшен
                   result.put(name, comparableValues); // пихаем в ХэшМэп
               }
           }
       }
        return result;
    }

    /**
     * Сравниваем водителей...
     * @param calcIdFirst - первый кальк айди
     * @param calcIdSecond - второй кальк айди
     * @param onlyDif - тип отчета
     * @return - хэш меп
     */
    public LinkedHashMap<String, ComparableValues> driversCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>(); // ХэшМеп куда будем пихать результат
        EntitiesUtils factory; // Фабрика

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) { // проверяем кол-во записей по коэфициентам. Не стоит ли менять их местами...
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        factory = new DriverFactory(); // создаем Конкретную фабрику - Водители
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond); // Наполняем ХэшМеп

        if (hash!=null) { // проверяем полученый из БД хэш на нуль
            for (String name : hash.keySet()) { // бегаем в цикле по хэшу

                if (onlyDif == 2) { // какой тип отчета выбран? Отчет только по несоответствиям
                    if (!(hash.get(name)).getCompare()) { //если флаг сравнения ложь (то есть не равны)

                        ComparableValues comparableValues = new ComparableValues((hash).get(name)); //создаем новый объект ComparableValues, заполняя в констр-ре данными из хэша
                        result.put(name, comparableValues); // пихаем в ХэшМэп

                    }
                } else { // тип отчета - 1 (обычный, полный)

                    ComparableValues comparableValues = new ComparableValues((hash).get(name)); //создаем новый объект ComparableValues, заполняя в констр-ре данными из хэша
                    result.put(name, comparableValues); // пихаем в ХэшМэп
                }
            }
        }


        return result;
    }

    /**
     * Сравниваем партнеров...
     * @param calcIdFirst
     * @param calcIdSecond
     * @param onlyDif
     * @return
     */
    public LinkedHashMap<String, ComparableValues> partnersCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>(); // ХэшМеп куда будем пихать результат
        EntitiesUtils factory; // Фабрика

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) {  // проверяем кол-во записей по коэфициентам. Не стоит ли менять их местами...
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        factory = new PartnerFactory(); // создаем Конкретную фабрику - Партнеры
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);  // Наполняем ХэшМеп

        if (hash!=null) { // проверяем полученый из БД хэш на нуль
            for (String name : hash.keySet()) { // бегаем в цикле по хэшу
                if (onlyDif == 2) { // какой тип отчета выбран? Отчет только по несоответствиям
                    if (!(hash.get(name)).getCompare()) {  //если флаг сравнения ложь (то есть не равны)
                        ComparableValues comparableValues = new ComparableValues((hash).get(name)); //создаем новый объект ComparableValues, заполняя в констр-ре данными из хэша
                        result.put(name, comparableValues); // пихаем в ХэшМэп
                    }
                } else { // тип отчета - 1 (обычный, полный)
                    ComparableValues comparableValues = new ComparableValues((hash).get(name)); //создаем новый объект ComparableValues, заполняя в констр-ре данными из хэша
                    result.put(name, comparableValues); // пихаем в ХэшМэп
                }
            }
        }

        return result;
    }

    /**
     * Сравниваем Common Logs...
     *
     * @param calcIdFirst - первый кальк айди
     * @param calcIdSecond - второй кальк айди
     * @param onlyDif - тип отчета
     * @return - хэш меп
     */
    public LinkedHashMap<String, ComparableValues> commonLogsCompare(Integer calcIdFirst, Integer calcIdSecond, Integer onlyDif) {

        LinkedHashMap<String, ComparableValues> result = new LinkedHashMap<String, ComparableValues>(); // ХэшМеп куда будем пихать результат
        EntitiesUtils factory; // Фабрика

        if (checkCoefs(calcIdFirst, calcIdSecond) == 2) { // проверяем кол-во записей по коэфициентам. Не стоит ли менять их местами...
            Integer tempCalcId = calcIdFirst;
            calcIdFirst = calcIdSecond;
            calcIdSecond = tempCalcId;
        }

        factory = new CommonLogsFactory(); // создаем Конкретную фабрику - Common Logs
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, calcIdFirst, calcIdSecond);  // Наполняем ХэшМеп

        if (hash!=null) { // проверяем полученый из БД хэш на нуль
            for (String name : hash.keySet()) { // бегаем в цикле по хэшу
                if (onlyDif == 2) {   // какой тип отчета выбран? Отчет только по несоответствиям
                    if (!(hash.get(name)).getCompare()) { //если флаг сравнения ложь (то есть не равны)
                        ComparableValues comparableValues = new ComparableValues((hash).get(name)); //создаем новый объект ComparableValues, заполняя в констр-ре данными из хэша

                        if (!(getDescriptionForCommonLogs(name)==null)) { // проверяем не ноль ли у нас Дискрипшен
                            name = getDescriptionForCommonLogs(name); // достаем Дискрипшен для имени/ключа
                        }

                        result.put(name, comparableValues); // пихаем в ХэшМэп
                    }
                } else { // тип отчета - 1 (обычный, полный)
                    ComparableValues comparableValues = new ComparableValues((hash).get(name)); //создаем новый объект ComparableValues, заполняя в констр-ре данными из хэша

                    if (!(getDescriptionForCommonLogs(name)==null)) {
                        name = getDescriptionForCommonLogs(name); // достаем Дискрипшен для имени/ключа
                    }

                    result.put(name, comparableValues);
                }
            }
        }

        return result;
    }

    /**
     * Сравниваем Ws Calc Logs
     * @param calcIdFirst
     * @param calcIdSecond
     * @param onlyDif
     * @return
     */
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

    /**
     * Сравниваем Коэфициенты
     * @param calcIdFirst
     * @param calcIdSecond
     * @param onlyDif
     * @return
     */
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

    /**
     * Достаем Дескрипшен для Коэфициент
     * @param name
     * @return
     */
    private String getDescriptionForCoeff(String name){
        String description="";

        if ((name != null) || (name != "")) {
            description = getDescriptionByCoefID(Integer.parseInt(name));
        }


        return description;
    }

    /**
     * Достаем Дескрипшны для Премий
     * @param name
     * @return
     */
    private String getDescriptionForBonuses(String name){
        String description="";

        if ((name != null) || (name != "")) {
            description = getDescriptionByPremiumID(Integer.parseInt(name));
        }

        return description;
    }

    /**
     * Достаем Дескрипшен для Ws Calc Log
     * @param name
     * @return
     */
    private String getDescriptionForWsCoeffCalc(String name){
        String description="";

        if ((name != null) || (name != "")) {
            description = getDescription4WsCoeffCalc(name);
        }


        return description;
    }

    /**
     * Достаем Дескрипшен для CommonLogs
     * ... чтобы был "красивый" дескрипшен вместо обозначения типа DRIVERLICENCE
     * @param name
     * @return
     */
    private String getDescriptionForCommonLogs(String name){
        String description="";

        if ((name != null) || (name != "")) {
            description = getDescription4WsCommonLogs(name);
        }


        return description;
    }
}
