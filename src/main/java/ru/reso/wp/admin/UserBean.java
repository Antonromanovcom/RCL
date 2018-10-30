package ru.reso.wp.admin;

import ru.reso.wp.admin.base.User;
import ru.reso.wp.admin.base.UserManager;
import ru.reso.wp.admin.consts.AdminTypeConsts.*;
import ru.reso.wp.admin.models.UserAccessReso;
import ru.reso.wp.common.message.UserMessageSystem;
import ru.reso.wp.consts.Consts;
import ru.reso.wp.srv.ResoRemoteObject;
import ru.reso.wp.srv.config.ConfigManager;
import ru.reso.wp.utils.JSFUtils;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named("userBean")
@SessionScoped
public class UserBean extends ResoRemoteObject {

    private UserSystem system;
    private UserMessageSystem messages;


    /**
     * Constructor
     */
    public UserBean() {
        super();

        this.messages = new UserMessageSystem();
        this.system = new UserSystem(TUserType.EMPLOYEE, this.messages);
    }

    public UserSystem getSystem() {
        return system;
    }

    public UserManager getManager() {
        return system.getUserManager();
    }

    public User getUser() {
        return system.getUser();
    }

    public UserAccessReso getAccess() {
        return system.getAccess();
    }

    public UserMessageSystem getMessages() {
        return messages;
    }

    public String login() {
//        system.getUserManager().login();
        system.getUserManager().setAuthenticated(true);
        return "login";
    }

    public void logOut() {
        JSFUtils.sessionTerminate();
    }

    public String back() {
        system.getUserManager().setAuthenticated(false);
        return "login";
    }

    public String confirm() {
        return "main";
    }

    /**
     * Для каждого ЛК своя форма авторизации
     *
     * @return
     */
    public String getLoginPage() {
        String result = Consts.WPRESORU_LOGIN_FIRSTSTEP_PATH;

        switch (ConfigManager.getAppName()) {
            case WP:
                switch (ConfigManager.getInsCompany()) {
                    case RESO:
                        if (system.getUserManager().isAuthenticated()) {
                            result = Consts.WPRESORU_LOGIN_SECONDSTEP_PATH;
                        } else {
                            result = Consts.WPRESORU_LOGIN_FIRSTSTEP_PATH;
                        }

                        break;
                    case CHANCE:
                        result = Consts.WPRESORU_LOGIN_FIRSTSTEP_PATH;
                        break;
                }
                break;
            case CLIENT:
                switch (ConfigManager.getInsCompany()) {
                    case RESO:
                        result = Consts.WPRESORU_LOGIN_FIRSTSTEP_PATH;
                        break;
                    case CHANCE:
                        result = Consts.WPRESORU_LOGIN_FIRSTSTEP_PATH;
                        break;
                }
                break;
        }

        return result;
    }

}
