/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.reso.medchat.model;

import ru.reso.wp.srv.ResoRemoteObject;
import ru.reso.wp.srv.db.models.StmtParamList;

import javax.naming.NamingException;
import java.sql.SQLException;

/**
 *
 * @author Nitrogen
 */
public class Greeting extends ResoRemoteObject {




    private final long id;
    private  String content;

    public Greeting(long id, String content) throws NamingException, SQLException, ClassNotFoundException {
        this.id = id;
        this.content = "ноль";

        try {
            String res = this.getResobj_EjbDatabaseInteraction().prepareStatementExecuteQuery("select 1 from dual", new StmtParamList());
           System.out.println("res = " + res);
            // String res = "111";
//            content = res;

            if (res==null){
                this.setContent("ноль");
            } else {
                this.setContent(res);
            }


        } catch (Exception ex) {
            System.out.println("PIZDEC");
        }
    }



    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}