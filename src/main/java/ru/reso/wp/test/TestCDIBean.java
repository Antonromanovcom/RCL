package ru.reso.wp.test;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.reso.wp.srv.ResoRemoteObject;
import ru.reso.wp.srv.db.models.StmtParamList;


@Named(value = "test")
@ViewScoped
public class TestCDIBean extends ResoRemoteObject implements Serializable {

    private static final Logger log = LogManager.getLogger(TestCDIBean.class);

    private String testStr = "Dima1";
    private String testStr1 = "Alex";

    /**
     * Constructor
     *
     * @throws NamingException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public TestCDIBean() throws NamingException {
        super();
    }

    public String getTestStr() throws SQLException {
        StmtParamList paramList = new StmtParamList();

        this.getResobj_EjbDatabaseInteraction().prepareStatementExecute("select 10 from dual", paramList);

        log.warn("Test logger WARN log4j");

        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public String getTestStr1() {
        log.error("Test logger ERROR log4j");
        return testStr1;
    }

    public void setTestStr1(String testStr1) {
        this.testStr1 = testStr1;
    }
}
