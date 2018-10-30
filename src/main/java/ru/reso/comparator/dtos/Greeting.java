package ru.reso.comparator.dtos;

//import ru.reso.wp.srv.ResoRemoteObject;
//import ru.reso.wp.srv.db.models.StmtParamList;

import javax.naming.NamingException;
import java.sql.SQLException;

public class Greeting {
    //public class Greeting extends ResoRemoteObject {

    private final long id;
    private final String content;

    public Greeting(long id, String content) throws NamingException, SQLException, ClassNotFoundException {
        this.id = id;
        this.content = content;

        try {
            //String res = this.getResobj_EjbDatabaseInteraction().prepareStatementExecuteQuery("select 1 from dual", new StmtParamList());
            String res = "111";

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

}
