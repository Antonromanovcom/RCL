package ru.reso.calclogcompare.service.factories.concretefactories;

import ru.reso.calclogcompare.model.WsCommonLogs;
import ru.reso.calclogcompare.service.factories.AbstractFactory;
import ru.reso.calclogcompare.utils.Utils;

import java.util.LinkedHashMap;

public class WsCommonLogsFactory implements AbstractFactory {

    private WsCommonLogs wsCommonLogs;

    @Override
    public LinkedHashMap<String, String> getHash() {
        return Utils.getHash(wsCommonLogs);
    }



}
