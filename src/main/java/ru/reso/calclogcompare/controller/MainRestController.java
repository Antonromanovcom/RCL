package ru.reso.calclogcompare.controller;

// This class created by Anton Romanov 03.12.2018 at 11:44
// Git Hub repo - ...
// https://192.*.*.*:33246/RCCT-2.0-SNAPSHOT/rest/getone?id=1
// http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/check?id=1


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.reso.calclogcompare.Service.PremiumService;
import ru.reso.calclogcompare.model.Premium;
import ru.reso.calclogcompare.model.PremiumList;
import ru.reso.calclogcompare.model.RequestFromClient;
import ru.reso.calclogcompare.model.Risk;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class MainRestController {

    /**
     * Сервис, работающий с ДАО.
     */
    @Autowired
    private PremiumService premiumService;

    @RequestMapping(value = "check", method = RequestMethod.GET)
    public ResponseEntity<?> CheckSerial(@RequestParam("id") String id) {
        System.out.println("Пришел запрос");
        return ResponseEntity.ok((premiumService.getPremById2(Integer.parseInt(id))));
    }


    /**
     * Клиент запрашивает данные по calcid.
     * Клиент отсылает на сервер calcid.
     * Ловим его тут.
     *
     * @return - табличку через обычное ДАО.
     * @throws Exception - эксепшн.
     */
    @PostMapping("/get")
    public Premium getCompareResult(@RequestBody RequestFromClient newRequest) throws Exception {
        //  List<Premium> listUsers = new ArrayList<>();
        //  listUsers.add(premiumService.getPremById2(1));
        System.out.println("POST captured " + newRequest.toString());
        return premiumService.getPremById2(1);
    }


    /**
     * Клиент запрашивает данные по RISK.
     * Выдаем список подходящих Премий.
     *
     * @return - табличку через обычное ДАО.
     * @throws Exception - эксепшн.
     */
    //PostMapping(value = "/getallbyrisk", consumes = "application/json", produces = "application/json")

    //@RequestMapping(method = RequestMethod.GET, path = "/getallbyrisk")
    //public PremiumList getAllByRisk(@RequestBody Risk risk) throws Exception {
    //RequestMapping(value = "getallbyrisk", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET, path = "/v2")
    public PremiumList getAllByRisk() {
        //List<Premium> premiumList = new ArrayList<>();
        PremiumList premiumList = new PremiumList();
        premiumList.getPremiumList().addAll(premiumService.getPremByRisk("R001"));
        //premiumList.getPremiumList().add(premiumService.getPremById2(1));

        System.out.println("WE ARE HERE !!!!");
        return premiumList;

    }




    /**
     * Клиент запрашивает данные по RISK.
     * Выдаем список подходящих Премий.
     *
     * @return - табличку через обычное ДАО.
     * @throws Exception - эксепшн.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v3")
    public PremiumList getAllByRisk2(@RequestParam("id1") Integer id1, @RequestParam("id2") Integer id2) {

        PremiumList premiumList = new PremiumList();
        premiumList.getPremiumList().add(premiumService.getPremById2(id1));
        System.out.println("Params: " + String.valueOf(id1) + " - " + String.valueOf(id2));
        return premiumList;

    }



}
