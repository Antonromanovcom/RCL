package ru.reso.calclogcompare.controller;

// This class created by Anton Romanov 03.12.2018 at 11:44
// Git Hub repo - ...
// https://192.*.*.*:33246/RCCT-2.0-SNAPSHOT/rest/getone?id=1
// http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/check?id=1


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.reso.calclogcompare.model.*;
import ru.reso.calclogcompare.service.PremiumService;

import java.util.LinkedHashMap;

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
    @RequestMapping(method = RequestMethod.GET, path = "/v2")
    public PremiumList getAllByRisk() {

        PremiumList premiumList = new PremiumList();
        premiumList.getPremiumList().addAll(premiumService.getPremByRisk("R001"));
        System.out.println("WE ARE HERE !!!!");
        premiumService.test();
        return premiumList;

    }

    /**
     * Выбрасываем финальный linkedhashmap
     * на клиента.
     *
     * @return - табличку через обычное ДАО.
     * @throws Exception - эксепшн.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v7")
    public Request getEntityHash() {

        //  PremiumList premiumList = new PremiumList();
        //  premiumList.getPremiumList().addAll(premiumService.getPremByRisk("R001"));
        System.out.println("WE ARE IN getEntityHash !!!!");
        //premiumService.test2();
        return premiumService.test2();

    }


    /**
     * Выбрасываем финальный linkedhashmap
     * на клиента.
     *
     * @return - табличку через обычное ДАО.
     * @throws Exception - эксепшн.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v10")
    public Request getEntityHashWithParametrs(@RequestParam("id1") Integer id1, @RequestParam("id2") Integer id2) {

        System.out.println("WE ARE IN getEntityHash with Parametrs !!!!");

        return premiumService.test2(Long.valueOf(id1), Long.valueOf(id2));

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

    /**
     * Первая попытка подключить боевую таблу.
     * Сделаем на всякий пожарный копию боевой таблы и выдадим ее
     *
     * @return - табличку.
     * @throws Exception - эксепшн.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v4")
    public PremiumList getAllByRisk3(@RequestParam("id1") Integer id1, @RequestParam("id2") Integer id2) {

        PremiumList premiumList = new PremiumList();
        premiumList.getPremiumList().add(premiumService.getPremById2(id1));
        System.out.println("Params: " + String.valueOf(id1) + " - " + String.valueOf(id2));
        return premiumList;

    }


    /**
     * Сколько вообще несовпадений.
     *
     * @return - табличку.
     * @throws Exception - эксепшн.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v11")
    public Integer getMismatchesCount(@RequestParam("id1") Integer id1, @RequestParam("id2") Integer id2) {
        return premiumService.getMismatchesCount(Long.valueOf(id1), Long.valueOf(id2));
    }


}
