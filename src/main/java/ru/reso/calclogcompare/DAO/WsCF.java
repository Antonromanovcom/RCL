package ru.reso.calclogcompare.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reso.calclogcompare.model.LoggingEntity;
import ru.reso.calclogcompare.model.WsCalcLogsNew;


public class WsCF implements SomeFabric {



    @Override
    public LoggingEntity getEntity(Long calcId) {
        WsCalcLogsNew wsCalcLogsNew;
//        wsCalcLogsNew = wsCalcLogsNewDAO.findOne(calcId);
      //  wsCalcLogsNew = wsCalcLogsNewDAO.findOne(Long.valueOf(122866996));
        return null;
    }
}
