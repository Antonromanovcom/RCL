package ru.reso.medchat.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.reso.medchat.model.ComparableValues;
import ru.reso.medchat.model.ComparableValuesList;

/** Rest-контроллер для Light-версии. Пока оставлендля ссовестимости со следующими версиями. На данный момент,
 * выдача данных по REST-протоколу не осуществляется.
 */
@RestController
public class ResoRestController {


    @RequestMapping("/greeting")
    public ComparableValues greeting(@RequestParam(value="id", defaultValue="World") String name) {

        ComparableValuesList comparableValues = new ComparableValuesList();
        return new ComparableValues("1", "2", "3");
    }


}
