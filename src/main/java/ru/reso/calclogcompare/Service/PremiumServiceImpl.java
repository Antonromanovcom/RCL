package ru.reso.calclogcompare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reso.calclogcompare.DAO.PremiumDAO;
import ru.reso.calclogcompare.DAO.WsCalcLogsNewDAO;
import ru.reso.calclogcompare.model.ComparedParam;
import ru.reso.calclogcompare.model.LoggingEntity;
import ru.reso.calclogcompare.model.Premium;
import ru.reso.calclogcompare.model.WsCalcLogsNew;
import ru.reso.calclogcompare.service.factories.AbstractFactory;
import ru.reso.calclogcompare.service.factories.concretefactories.WsCalcLogFactory;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static ru.reso.calclogcompare.service.dispatcher.MainDispatcher.getResult;


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


      //  LinkedHashMap<String, ComparedParam> result = new LinkedHashMap<String, ComparedParam>();
        AbstractFactory factory; // Фабрика
        WsCalcLogsNew wsCalcLogsNew1;
        wsCalcLogsNew1 = wsCalcLogsNewDAO.findOne(Long.valueOf(122866996));
        factory = new WsCalcLogFactory(wsCalcLogsNew1); // создаем Конкретную фабрику - Премии
        LinkedHashMap<String, ComparedParam> hash = getResult(factory, Long.valueOf(122866996), Long.valueOf(122866996)); // Наполняем ХэшМеп



     //   long startTime = System.currentTimeMillis();

    //    WsCalcLogsNew wsCalcLogsNew2;
      //  WsCalcLogsNew wsCalcLogsNew2 = new WsCalcLogsNew();


        //return wsCalcLogsNew1;
   /*     //wsCalcLogsNew2 = wsCalcLogsNewDAO.findOne(Long.valueOf(122867001));

        String className = getClassName(wsCalcLogsNew1); //Вытаскиваем имя класса
        System.out.println((System.currentTimeMillis() - startTime) + ": time exec");
        try {
            Class<?> clazz = Class.forName(className); //Берем сам класс
            for (Field field : clazz.getDeclaredFields()) { //Бегаем по полям класса
                if ((field.getName()) != null) { // Проверяем, что у нас не ноль и переданное в параметре метода имя и текунщее пробегаемое в цикле поле класса
                    field.setAccessible(true);

                    System.out.println("NAME OF FIELD - " + field.getName() + " | VALUE - " + String.valueOf(field.get(wsCalcLogsNew1)));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // ----------------------------- а теперь через процедуру -------------------------

   /*     long startTime2 = System.currentTimeMillis();
        List<WsCalcLogsNew> wsCalcLogsNewList = wsCalcLogsNewDAO.inOnlyTest(190304724);
        wsCalcLogsNew2 = wsCalcLogsNewList.get(0);


        className = getClassName(wsCalcLogsNew2); //Вытаскиваем имя класса
        System.out.println((System.currentTimeMillis() - startTime2) + ": time exec");
        try {
            Class<?> clazz = Class.forName(className); //Берем сам класс
            for (Field field : clazz.getDeclaredFields()) { //Бегаем по полям класса
                if ((field.getName()) != null) { // Проверяем, что у нас не ноль и переданное в параметре метода имя и текунщее пробегаемое в цикле поле класса
                    field.setAccessible(true);
                    System.out.println("NAME OF FIELD - " + field.getName() + " | TYPE OF FIELD - " + field.getType().toString());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }

    /**
     * Получаем имя класса из Объекта
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
     * @param anyClass - класс в котором мы ищем поле. Собственно его и хотим вернуть.
     * @param name - имя поля, которое ищем.
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
