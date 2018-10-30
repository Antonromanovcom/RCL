package ru.reso.medchat.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.reso.medchat.model.ComparableValues;
import ru.reso.medchat.model.ComparableValuesList;

@RestController
public class ResoRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public ComparableValues greeting(@RequestParam(value="id", defaultValue="World") String name) {
        System.out.println("ПАРАМЕТР.... " + name);

        ComparableValuesList comparableValues = new ComparableValuesList();
        //comparableValues.fill();

        //;

        return comparableValues.getValuesByKey(name);
        //return new ComparableValues("1", "2", "3");
    }


}
