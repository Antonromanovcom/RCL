package ru.reso.calclogcompare.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reso.calclogcompare.DAO.test.PremiumDAO;
import ru.reso.calclogcompare.DAO.wscalclogsnew.WsCalcLogsNewDAO;
import ru.reso.calclogcompare.DAO.wscommonlogs.WsCommonLogsRepository;
import ru.reso.calclogcompare.model.*;
import ru.reso.calclogcompare.model.common.ComparedParam;
import ru.reso.calclogcompare.model.common.Request;
import ru.reso.calclogcompare.model.test.Premium;
import ru.reso.calclogcompare.service.PremiumService;
import ru.reso.calclogcompare.utils.Entities;
import ru.reso.calclogcompare.utils.Utils;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static ru.reso.calclogcompare.service.dispatcher.MainDispatcher.getResult;
import static ru.reso.calclogcompare.utils.Entities.*;


/**
 * Сервис, реализующий основной
 * персистент функционал.
 */
@Service
public class PremiumServiceImpl implements PremiumService {

    /**
     * Основной ДАО репозиторий.
     */
    @Autowired
    private PremiumDAO daoRepository;


    @Autowired
    private WsCalcLogsNewDAO wsCalcLogsNewDAO;

    @Autowired
    private WsCommonLogsRepository wsCommonLogsRepository;


    /**
     * Выдать премию по id
     * базовым методом findOne.
     *
     * @param id - id премии.
     * @return - Премия.
     */
    public Premium getPremById(final Long id) {
        return daoRepository.findOne(id);
    }

    /**
     * Выдать все премии
     * через @Query.
     *
     * @return - список Премий.
     */
    @Override
    public List<Premium> getAllInString() {
        List<Premium> result = new ArrayList<>();


        for (String name : daoRepository.getAllSerials()) {
            result.add(new Premium(name));
        }

        return result;
    }

    /**
     * Выдать премию по id
     * через @Query.
     *
     * @return - Премия.
     */
    @Override
    public Premium getPremById2(final Integer id) {
        return daoRepository.getPremiumById(Long.valueOf(id));
    }

    /**
     * Выдать премию по RISK
     * через @Query.
     *
     * @return - список премий.
     */
    @Override
    public List<Premium> getPremByRisk(String risk) {
        return daoRepository.getPremiumListByRisk(risk);
    }

    @Override
    public void test() {

        //   AbstractFactory factory; // Фабрика
        //     factory = new
        //     WsCalcLogsNew wsCalcLogsNew1;
        //    wsCalcLogsNew1 = wsCalcLogsNewDAO.findOne(Long.valueOf(122866996));
        //    factory = new WsCalcLogFactory(wsCalcLogsNew1); // создаем Конкретную фабрику - Премии
        //    LinkedHashMap<String, ComparedParam> hash = getResult(factory, Long.valueOf(122866996), Long.valueOf(122866996)); // Наполняем ХэшМеп


    }

    @Override
    public Request test2() {
        //     AbstractFactory factory; // Фабрика
        //   WsCalcLogsNew wsCalcLogsNew1;
        //  wsCalcLogsNew1 = wsCalcLogsNewDAO.findOne(Long.valueOf(122866996));
        //      factory = new WsCalcLogFactory(wsCalcLogsNew1); // создаем Конкретную фабрику - Премии
        //      LinkedHashMap<String, ComparedParam> hash = getResult(factory, Long.valueOf(122866996), Long.valueOf(122866996)); // Наполняем ХэшМеп

        return new Request(null, Long.valueOf(100));
    }

    @Override
    public Request test2(Long id1, Long id2) {

        long startTime = System.currentTimeMillis(); //Стартовое время на операцию.
        LinkedHashMap<String, ComparedParam> hash = getResult(this.getEntity(id1, 1), this.getEntity(id2, 1)); // Наполняем ХэшМеп
        System.out.println((System.currentTimeMillis() - startTime) + ": time exec"); // Время выполнения.
        return new Request(hash, Long.valueOf(100));
    }

    @Override
    public Integer getMismatchesCount(Long id1, Long id2, Integer entityType) {
        int i = 0;
        LinkedHashMap<String, ComparedParam> hash = getResult(this.getEntity(id1, entityType), this.getEntity(id2, entityType)); // Наполняем ХэшМеп
        return Utils.getMismatchesCount(id1, id2, hash);
    }

    @Override
    public LoggingEntity getEntity(Long calcId, Integer entityType) {

       LoggingEntity result;

        switch (entityType) {
            case Entities.WSCALCLOGS:
                result =  wsCalcLogsNewDAO.findOne(calcId);
                if (result == null) { // Если такого айдишника нет
                    result = new WsCalcLogsNew();
                }
                break;

            case Entities.WSCOMMONLOGS:
                result =  wsCommonLogsRepository.findOne(calcId);
                if (result == null) { // Если такого айдишника нет
                    result = new WsCommonLogs();
                }
                break;
            default:
                result =  wsCalcLogsNewDAO.findOne(calcId);
                if (result == null) { // Если такого айдишника нет
                    result = new WsCalcLogsNew();
                }
        }

        return result;
    }

    @Override
    public Request getCompare(Long id1, Long id2, Integer entityType) {
        long startTime = System.currentTimeMillis(); //Стартовое время на операцию.
        LinkedHashMap<String, ComparedParam> hash = getResult(this.getEntity(id1, entityType), this.getEntity(id2, entityType)); // Наполняем ХэшМеп
        long endTime = System.currentTimeMillis() - startTime;
        return new Request(hash, endTime);

    }

    private void fillEntityWithEmptyValues(WsCalcLogsNew wsCalcLogsNew) {

        // wsCalcLogsNew.setAccident();


    }

    /**
     * Получаем имя класса из Объекта
     *
     * @param cls
     * @return - имя класса с путем пакета
     */
    public static String getClassName(Object cls) {
        String res = "";
        res = cls.getClass().getName();
        return res;
    }

    /**
     * Возвращаем тип поля.  Данный метод позволяет вернуть тип поля по его имени, давая нам нужный уровень абстракции и автоматизации
     *
     * @param anyClass - класс в котором мы ищем поле. Собственно его и хотим вернуть.
     * @param name     - имя поля, которое ищем.
     * @return
     */
    public static int getLocalFieldType(Object anyClass, String name) {

        int varType = 0;
        String convertedField = "";
        try {
            String className = getClassName(anyClass); //Вытаскиваем имя класса
            Class<?> clazz = Class.forName(className);
            for (Field field : clazz.getDeclaredFields()) {
                if (name != null && (field.getName()) != null) {


                    if (field.getName().equalsIgnoreCase(name)) { // если имя нашли в классе через рефликсию, то определяем его (поля) тип....

                        if (field.getType().isAssignableFrom(Long.class)) {

                            varType = Types.BIGINT;
                            //convertedField = String.valueOf()
                            break;
                        } else if (field.getType().isAssignableFrom(long.class)) {
                            varType = Types.BIGINT;

                            break;
                        } else if (field.getType().isAssignableFrom(int.class)) {
                            varType = Types.INTEGER;

                            break;
                        } else if (field.getType().isAssignableFrom(String.class)) {
                            varType = Types.VARCHAR;

                            break;
                        } else if (field.getType().isAssignableFrom(Integer.class)) {
                            varType = Types.INTEGER;

                            break;

                        } else if (field.getType().isAssignableFrom(Double.class)) {
                            varType = Types.DOUBLE;

                            break;

                        } else if (field.getType().isAssignableFrom(double.class)) {
                            varType = Types.DOUBLE;

                            break;

                        } else if (field.getType().isAssignableFrom(java.sql.Date.class)) {
                            varType = Types.DATE;

                            break;
                        } else {

                            varType = Types.TIMESTAMP;

                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return varType;


    }


}
