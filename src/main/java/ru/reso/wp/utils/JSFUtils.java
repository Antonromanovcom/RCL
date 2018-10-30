package ru.reso.wp.utils;

import ru.reso.wp.common.consts.ResoConsts;
import ru.reso.wp.common.utils.ResoUtils;

import javax.el.MethodExpression;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class JSFUtils {

    public static MethodExpression createMethodExpression(String expression, Class<?> returnType, Class<?>... parameterTypes) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory().createMethodExpression(
                facesContext.getELContext(), expression, returnType, parameterTypes);
    }

    /**
     * Веб HTTP сессия
     *
     * @return
     */
    public static HttpSession getHttpSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    /**
     * Веб HTTP запрос
     *
     * @return
     */
    public static HttpServletRequest getHttpRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    /**
     * Веб HTTP запрос. IP адрес откуда сделан запрос.
     *
     * @return
     */
    public static String getHttpRequestIP() {
        String ipAddress = getHttpRequest().getHeader(ResoConsts.X_FORWARDED_FOR);

        if (ResoUtils.isEmpty(ipAddress)) {
            ipAddress = getHttpRequest().getRemoteAddr();
        }

        return ipAddress;
    }

    /**
     * Веб HTTP запрос. Имя хоста откуда сделан запрос.
     *
     * @return
     */
    public static String getHttpRequestRemoteHost() {
        return getHttpRequest().getRemoteHost();
    }

    /**
     *
     */
    public static void sessionTerminate() {
        if (!ResoUtils.isEmpty(FacesContext.getCurrentInstance()) && !ResoUtils.isEmpty(getHttpSession())) {
            getHttpSession().invalidate();
        }
    }

}
