package ru.reso.calclogcompare.utils;

import ru.reso.calclogcompare.model.LoggingEntity;
import ru.reso.calclogcompare.model.WsCalcLogsNew;
import ru.reso.calclogcompare.model.common.ComparedParam;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

import static ru.reso.calclogcompare.service.dispatcher.MainDispatcher.getResult;

public class Utils {

    /**
     * Получаем имя класса из Объекта.
     * @param - объект.
     * @return - имя класса с путем пакета.
     */
    public static String getClassName(Object cls) {
        String res = "";
        res = cls.getClass().getName();
        return res;
    }

    public static LinkedHashMap<String, String> getHash(LoggingEntity loggingEntity) {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        String className = getClassName(loggingEntity); //Вытаскиваем имя класса

        try {
            Class<?> clazz = Class.forName(className); //Берем сам класс
            for (Field field : clazz.getDeclaredFields()) { //Бегаем по полям класса
                if ((field.getName()) != null) { // Проверяем, что у нас не ноль и переданное в параметре метода имя и текунщее пробегаемое в цикле поле класса
                    field.setAccessible(true); // Открываем поле класса
                    System.out.println("NAME OF FIELD - " + field.getName() + " | VALUE - " + String.valueOf(field.get(loggingEntity)));
                    result.put(field.getName(), String.valueOf(field.get(loggingEntity))); // кладем в Хэш
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Integer getMismatchesCount(Long id1, Long id2, LinkedHashMap<String, ComparedParam> hash) {

        int i = 0;
        for (String name : hash.keySet()) {
            if (!hash.get(name).getCompare()){
                i=i+1;
            }
        }
        return i;
    }
}
