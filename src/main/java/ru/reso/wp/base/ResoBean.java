package ru.reso.wp.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.reso.wp.common.consts.ResoConsts;
import ru.reso.wp.common.utils.ResoUtils;
import ru.reso.wp.srv.ResoRemoteObject;
import ru.reso.wp.utils.JSFUtils;

import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public abstract class ResoBean extends ResoRemoteObject {

    private static final Logger log = LogManager.getLogger(ResoBean.class);

    public ResoBean() throws NamingException, SQLException, ClassNotFoundException {
        super();
    }

    /**
     * При возникновении фатальной ошибки разрываем сессию и перенаправляем пользователя на страницу авторизации
     */
    public void fatalError(Exception ex) {
        log.fatal(ex.toString());
        JSFUtils.sessionTerminate();
    }

}
