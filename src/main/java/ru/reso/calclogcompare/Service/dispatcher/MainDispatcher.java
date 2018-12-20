package ru.reso.calclogcompare.service.dispatcher;

import ru.reso.calclogcompare.model.ComparedParam;
import ru.reso.calclogcompare.service.factories.AbstractFactory;
import java.util.LinkedHashMap;

import static ru.reso.calclogcompare.utils.ComplexCompair.getFullCompare;

public class MainDispatcher {

    // private static CalcEntity entity1st; //Энтити для calcid I.
    //  private static CalcEntity entity2d; //Энтити для calcid II.

    private static LinkedHashMap<String, String> entity1st; //Энтити для calcid I.
    private static LinkedHashMap<String, String> entity2d; //Энтити для calcid II.


    /**
     * Собственно, главный метод класса, который и возвращает хэшмеп с результатами сравнения.
     *
     * @param factory      - фабрику передаем из клиента. В зависимости от типа отчета.
     * @param calcidFirst
     * @param calcidSecond
     * @return
     */
    public static LinkedHashMap<String, ComparedParam> getResult(AbstractFactory factory, long calcidFirst, long calcidSecond) {

        LinkedHashMap<String, ComparedParam> result = new LinkedHashMap<>();

        /**
         * Вот собственно зачем нам и нужны фабрики. Тут нам вообще по хер какой энтити, какой у нее дао. Я могу добавлять бесконечные количество энтити и отчетов,
         * главное - чтобы все это соответствовало интерфейсу.
         */

        entity1st = factory.getHash();
        entity2d = factory.getHash();

        System.out.println("............... PRINT FIRST IN HASH MAP....................");
        for(String name : entity1st.keySet()) {
            System.out.println(name + " - " + entity1st.get(name));
        }


        // Вызываем соответствующий метод из ComplexCompair
        result = getFullCompare(entity1st, entity2d);





        System.out.println("............... PRINT SECOND IN HASH MAP....................");
        for(String name : entity2d.keySet()) {
            System.out.println(name + " - " + entity2d.get(name));
        }

        System.out.println("............... PRINT OUR HASH MAP....................");
        for(String name : result.keySet()) {
            System.out.println(name + " - " + result.get(name).getVal1() + " : " + result.get(name).getVal2());
        }

        return result;

    }
}
