package ru.reso.RCL.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.reso.RCL.model.ComparableValues;


/** Rest-контроллер для Light-версии. Пока оставлен для ссовестимости со следующими версиями. На данный момент,
 * выдача данных по REST-протоколу не осуществляется.
 */
@RestController
public class ResoRestController {

    @RequestMapping("/greeting")
    public ComparableValues greeting(@RequestParam(value="id", defaultValue="World") String name) {
        return new ComparableValues("1", "2", "3");
    }


}
