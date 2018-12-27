package ru.reso.calclogcompare.service.dispatcher;

import ru.reso.calclogcompare.DAO.SomeFabric;
import ru.reso.calclogcompare.model.ComparedParam;
import ru.reso.calclogcompare.model.LoggingEntity;
import ru.reso.calclogcompare.model.WsCalcLogsNew;
import ru.reso.calclogcompare.service.factories.AbstractFactory;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;

import static ru.reso.calclogcompare.utils.ComplexCompair.getFullCompare;

public class MainDispatcher {

    private static LoggingEntity _entity1st; //Энтити для calcid I.
    private static LoggingEntity _entity2d; //Энтити для calcid II.
    private static WsCalcLogsNew wsCalcLogsNew;
    private static LinkedHashMap<String, String> entity1st; //Энтити для calcid I.
    private static LinkedHashMap<String, String> entity2d; //Энтити для calcid II.


    /**
     * Собственно, главный метод класса, который и возвращает хэшмеп с результатами сравнения.
     *
     * @param factory      - фабрику передаем из клиента. В зависимости от типа отчета.
     * @param calcIdFirst
     * @param calcIdSecond
     * @return
     */
    //public static LinkedHashMap<String, ComparedParam> getResult(SomeFabric factory, long calcIdFirst, long calcIdSecond) {
    public static LinkedHashMap<String, ComparedParam> getResult(LoggingEntity entity1, LoggingEntity entity2) {

        LinkedHashMap<String, ComparedParam> result;

      //  _entity1st = factory.getEntity(calcIdFirst);
     //   _entity2d = factory.getEntity(calcIdSecond);


        entity1st = getHash(entity1);
        entity2d = getHash(entity2);

        System.out.println("............... PRINT FIRST IN HASH MAP....................");
        for (String name : entity1st.keySet()) {
            System.out.println(name + " - " + entity1st.get(name));
        }


        // Вызываем соответствующий метод из ComplexCompair
        result = getFullCompare(entity1st, entity2d);


        System.out.println("............... PRINT SECOND IN HASH MAP....................");
        for (String name : entity2d.keySet()) {
            System.out.println(name + " - " + entity2d.get(name));
        }

        System.out.println("............... PRINT OUR HASH MAP....................");
        for (String name : result.keySet()) {
            System.out.println(name + " - " + result.get(name).getVal1() + " : " + result.get(name).getVal2());
        }

        return result;
    }


    public static LinkedHashMap<String, String> getHash(LoggingEntity entity) {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        String className = getClassName(entity); //Вытаскиваем имя класса

        try {
            Class<?> clazz = Class.forName(className); //Берем сам класс
            for (Field field : clazz.getDeclaredFields()) { //Бегаем по полям класса
                if ((field.getName()) != null) { // Проверяем, что у нас не ноль и переданное в параметре метода имя и текунщее пробегаемое в цикле поле класса
                    field.setAccessible(true); // Открываем поле класса
                    System.out.println("NAME OF FIELD - " + field.getName() + " | VALUE - " + String.valueOf(field.get(entity)));
                    result.put(field.getName(), String.valueOf(field.get(entity))); // кладем в Хэш
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    /**
     * Получаем имя класса из Объекта.
     *
     * @param - объект.
     * @return - имя класса с путем пакета.
     */
    public static String getClassName(Object cls) {
        String res = "";
        res = cls.getClass().getName();
        return res;
    }


}
