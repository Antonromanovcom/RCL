/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.reso.medchat.model;

import ru.reso.resocalc.Entity.WsCalcLogsNew;
import ru.reso.resocalc.Service.Factories.ConcreteFactories.WsCoeffCalcFactory;
import ru.reso.resocalc.Service.WsCalcLogDao;
import ru.reso.wp.srv.ResoRemoteObject;
import ru.reso.wp.srv.db.models.StmtParam;
import ru.reso.wp.srv.db.models.StmtParamList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import static ru.reso.resocalc.Service.WsCalcLogDao.*;
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


    /* public String getCalcLog() {

        //String sql = "select t.agentid from webauto.ws_calc_logs t where t.calcid = ?";
        //String sql = "select t.agentid from webauto.ws_calc_logs_new@osago t where t.calcid = ?";
        //String sql = "select t.agentid from webauto.ws_calc_logs_new@osago t where t.calcid = ?";
        String sql = "select t.insurantid from  webauto.WS_CALC_LOGS_NEW t where t.calcid=?";
        //String sql = " select * from WS_CALC_LOGS_NEW t  where t.calcid = ?";
        return testPing(sql);
    } */

    public WsCalcLogsNew getLog() {
        Long calc =  122865290L;
        return getLogByCalcID(calc);
    }

    public void testAdd() {
        addLog(getMockObject(1));
    }

    public void testAdd2() {
        addLogAutomative(getMockObject(1));
    }

    public Long getAnyId() {
        Long anyId = null;
        anyId = getTestCalcId();
        return anyId;
    }

    public String parseWS(WsCalcLogsNew ws) {
        Long calc =  122865290L;
        return String.valueOf(paramListGenerator(ws, calc));
    }

    public String getSQL() {

        //WsCalcLogDao w = new WsCalcLogDao();

        String sql = "1";
        //sql = getInsertSQL();
        sql = getUpdateSQL();

        return sql;
    }

    public String testLog() {
        WsCoeffCalcFactory ws= new WsCoeffCalcFactory();

        //String res = ws.webRowSet2Entity().getTest();

        String res = ws.getEntityByCalcId(122865423).getTest();

        return res;
    }

    public void testUpd() {
      updateLogAutomative(getMockObjectForUpdateTest());
    }



    public String Test() {

        String test = "";
        String res = "";
        StmtParamList paramList = new StmtParamList ();
        paramList.add(new StmtParam(Types.INTEGER, 122865181));
      //  String sql1 = "select pu.name from adm.partner_users pu where pu.ID = ?";
       // String sql2 = "select t.agentid from webauto.ws_calc_logs t where t.calcid = ?"; // ACTUARY
            String sql3 = "select * from webauto.ws_calc_logs_new t where t.calcid = ?"; // OSAGO

     /*   try {

            res = getResobj_EjbDatabaseInteraction().prepareStatementExecuteQuery(sql3, paramList);
            ResultSet rs = decodeWebRowSet(res);

            if (rs.next()) {
                //test = rs.getString("NAME");
                test = rs.getString(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
        } */

      //  String fromLog = this.getLog().getCarbrandname();
        String parse = this.parseWS(this.getLog());

        //String anyId = String.valueOf(this.getAnyId());
//        this.testAdd();
        //this.testAdd2();
        this.testUpd();
        String i = this.getSQL();


        test = this.testLog();
        //test = test + " - " + this.getCalcLog() + " - " + fromLog;
        //test = test + " - " + this.testLog() + " : " + res;
        //test = test + " - " + this.testLog();
        //test = test  + " : " + res;
       // test = "WsCalcLogsNew - " + fromLog;
        // test = "WsCalcLogsNew - " + parse;
        //test = "WsCalcLogsNew";
     //   test = "WsCalcLogsNew - " + i;
        //test = "WsCalcLogsNew - " + anyId;


        return test;

    }
}