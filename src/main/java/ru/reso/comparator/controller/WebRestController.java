package ru.reso.comparator.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebRestController {

    String json = "{\"id\":2488,\"content\":\"Hello!\"}";


    @RequestMapping("/rest")
    public String hi(@RequestParam(value = "name", required=false, defaultValue="World") String name){
        //    return name+" - TEST";
        return json;
    }

}
