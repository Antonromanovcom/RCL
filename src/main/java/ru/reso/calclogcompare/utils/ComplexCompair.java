package ru.reso.calclogcompare.utils;

import ru.reso.calclogcompare.model.ComparedParam;

import java.util.LinkedHashMap;

public class ComplexCompair {

    /**
     * Основной метод сравнения calcId. Работает для всех типов Энтити и Фабрик
     * @param calcEntity1st
     * @param calcEntity2d
     * @return
     */
    public static LinkedHashMap<String, ComparedParam> getFullCompare(LinkedHashMap<String, String> calcEntity1st, LinkedHashMap<String, String> calcEntity2d) {

        LinkedHashMap<String, ComparedParam> result = new LinkedHashMap<>();

        if ((calcEntity1st != null) && (calcEntity2d != null)) { //проверка, что оба энтити не нулевые
            for (String name : calcEntity1st.keySet()) { // циклим по первому энтити (по ключам)
                if ((calcEntity1st.get(name)) != null) { //проверяем, чтобы запись по ключу в цикле у хэша первого энтити была не ноль
                    if ((calcEntity2d.get(name)) != null) { //проверяем, чтобы запись по ключу в цикле у хэша второго энтити была не ноль
                        if ((calcEntity1st.get(name)).equals(calcEntity2d.get(name))) { //если записи в хэшах обоих энтити совпали....
                            result.put(name, new ComparedParam(name, (calcEntity1st.get(name)), (calcEntity2d.get(name)), true)); //кладем в новый хэш
                        } else {
                            result.put(name, new ComparedParam(name, (calcEntity1st.get(name)), (calcEntity2d.get(name)), false)); //тоже кладем, но ставим флаг - ложь
                        }
                    } else {
                        result.put(name, new ComparedParam(name, calcEntity1st.get(name), "", false)); //calcEntity2d - нулевой хэш. Пишем Ложь и "" вместо второго параметра
                    }
                } else { // Хэш calcEntity1st дал НОЛЬ
                    if ((calcEntity2d.get(name)) != null) { // если второй хэш таки не ноль
                        result.put(name, new ComparedParam(name, "", calcEntity2d.get(name), false)); // первый параметр - ноль, результат сравнения - ложь
                    } else {
                        result.put(name, new ComparedParam(name, "", "", true)); // все ноль. результат сравнения - тру
                    }
                }
            }
        } else if ((calcEntity1st == null) && (calcEntity2d == null)) { // если оба энтити вообще ноль.
            result = null; // в хэш просто пишем ноль
        } else if ((calcEntity1st != null) && (calcEntity2d == null)) { // если первый энтити не ноль, а второй ноль
            for (String name : calcEntity1st.keySet()) { // циклим по первому хэшу чтобы собрать поля
                result.put(name, new ComparedParam(name, calcEntity1st.get(name), "", false)); //везде пишем первый хэш, второй параметр - "", булеан - ложь.
            }
        } else if ((calcEntity1st == null) && (calcEntity2d != null)) { // если первый энтити ноль, а втлорой не ноль....
            for (String name : calcEntity2d.keySet()) { // циклим по второму энтити, чтобы собрать имена
                result.put(name, new ComparedParam(name, "", calcEntity2d.get(name), false)); // пишем "", значения со второго хэша, булеан - ложь.
            }
        }


        return result;
    }


}
