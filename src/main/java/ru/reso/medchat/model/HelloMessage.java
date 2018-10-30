/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.reso.medchat.model;

import ru.reso.wp.srv.ResoRemoteObject;
import ru.reso.wp.srv.db.models.StmtParamList;

/**
 *
 * @author Nitrogen
 */
public class HelloMessage extends ResoRemoteObject {
    //public class HelloMessage {

    private final String name = "1111";

    public String getName() {
        return name;
    }

    public String Test() {

        String test = "";

        try {
            //String res = this.getResobj_EjbDatabaseInteraction().prepareStatementExecuteQuery("select 1 from dual", new StmtParamList());
            String res = "test";
            System.out.println("res = " + res);
            // String res = "111";
//            content = res;

            if (res==null){
                test = "null";
            } else {
                test = res;
            }


        } catch (Exception ex) {
            System.out.println("PIZDEC");
        }


        return test;
    }


}