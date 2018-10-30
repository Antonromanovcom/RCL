package ru.reso.comparator.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.reso.comparator.dtos.Greeting;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class WebRestController {

    String json = "{\"id\":2488,\"content\":\"Hello!\"}";
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/rest")
    public String hi(@RequestParam(value = "name", required=false, defaultValue="World") String name){
        //    return name+" - TEST";
        return json;
    }

   /* @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public Greeting[] hello(@RequestParam(value = "name", required=false, defaultValue="World") String name){
        Greeting[] consultations = new Greeting[2];

        for (int i = 0; i < consultations.length; i++) {
            try {
                consultations[i] = new Greeting(counter.incrementAndGet(),
                        String.format(template, name));
            } catch (Exception ex) {

            }

        }
        return consultations;
    }
*/
}
