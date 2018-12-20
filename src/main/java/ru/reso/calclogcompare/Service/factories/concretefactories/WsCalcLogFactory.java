package ru.reso.calclogcompare.service.factories.concretefactories;

import org.springframework.beans.factory.annotation.Autowired;
import ru.reso.calclogcompare.DAO.WsCalcLogsNewDAO;
import ru.reso.calclogcompare.model.WsCalcLogsNew;
import ru.reso.calclogcompare.service.PremiumService;
import ru.reso.calclogcompare.service.factories.AbstractFactory;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

public class WsCalcLogFactory implements AbstractFactory {

  //  @Autowired
  //  private WsCalcLogsNewDAO wsCalcLogsNewDAO;

   private  WsCalcLogsNew wsCalcLogsNew;


    public WsCalcLogFactory(WsCalcLogsNew wsCalcLogsNew) {

        this.wsCalcLogsNew = wsCalcLogsNew;
    }

    @Override
    public LinkedHashMap<String, String> getHash() {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        long startTime = System.currentTimeMillis(); //Стартовое время на операцию.

        //wsCalcLogsNew = wsCalcLogsNewDAO.findOne(Long.valueOf(122866996));
        //wsCalcLogsNew = premiumService.test();
        String className = getClassName(wsCalcLogsNew); //Вытаскиваем имя класса
        System.out.println((System.currentTimeMillis() - startTime) + ": time exec"); // Время выполнения.
        try {
            Class<?> clazz = Class.forName(className); //Берем сам класс
            for (Field field : clazz.getDeclaredFields()) { //Бегаем по полям класса
                if ((field.getName()) != null) { // Проверяем, что у нас не ноль и переданное в параметре метода имя и текунщее пробегаемое в цикле поле класса
                    field.setAccessible(true); // Открываем поле класса
                    System.out.println("NAME OF FIELD - " + field.getName() + " | VALUE - " + String.valueOf(field.get(wsCalcLogsNew)));
                    result.put(field.getName(), String.valueOf(field.get(wsCalcLogsNew))); // кладем в Хэш
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return result;
    }

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

}
