/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.reso.medchat.model;

import ru.reso.resocalc.Entity.WsCalcLogsNew;
import ru.reso.resocalc.Service.WsCalcLogDao;
import ru.reso.wp.srv.ResoRemoteObject;
import ru.reso.wp.srv.db.models.StmtParam;
import ru.reso.wp.srv.db.models.StmtParamList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import static ru.reso.resocalc.Service.WsCalcLogDao.getLogByCalcID;
import static ru.reso.resocalc.Service.WsCalcLogDao.testPing;
import static ru.reso.wp.srv.db.ResoDatabaseInvoke.decodeWebRowSet;

/**
 * @author ROMAB
 *
 * Test CALCID = 6627908
 */
public class HelloMessage extends ResoRemoteObject {
    //public class HelloMessage {

    private final String name = "1111";

    public String getName() {
        return name;
    }


    public String getCalcLog() {

        //String sql = "select t.agentid from webauto.ws_calc_logs t where t.calcid = ?";
        //String sql = "select t.agentid from webauto.ws_calc_logs_new@osago t where t.calcid = ?";
        //String sql = "select t.agentid from webauto.ws_calc_logs_new@osago t where t.calcid = ?";
        String sql = "select t.insurantid from  webauto.WS_CALC_LOGS_NEW t where t.calcid=?";
        return testPing(sql);
    }

    public String Test() {

        String test = "";
        StmtParamList paramList = new StmtParamList();
        paramList.add(new StmtParam(Types.INTEGER, 122865181));
      //  String sql1 = "select pu.name from adm.partner_users pu where pu.ID = ?";
       // String sql2 = "select t.agentid from webauto.ws_calc_logs t where t.calcid = ?"; // ACTUARY
        String sql3 = "select t.insurantid from webauto.ws_calc_logs_new t where t.calcid = ?"; // OSAGO

        try {

            String res = getResobj_EjbDatabaseInteraction().prepareStatementExecuteQuery(sql3, paramList);
            ResultSet rs = decodeWebRowSet(res);

            if (rs.next()) {
                //test = rs.getString("NAME");
                test = rs.getString(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
        }

        //test = test + " - " + this.getCalcLog();
        test = test + " - " + this.getCalcLog();

        return test;

    }
}