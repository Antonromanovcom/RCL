package ru.reso.wp.ui.main_menu.renderer;

import org.primefaces.component.menu.AbstractMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.component.menu.Menu;
import ru.reso.wp.ui.base.BaseMenu;
import ru.reso.wp.ui.main_menu.MainMenu;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("uiMainMenuBean")
@SessionScoped
public class UIMainMenuBean implements Serializable {
    private BaseMenu mainMenu;
    private String mainMenuHtml = "";
    private AbstractMenu uiMenu;

    /**
     * Constructor
     */
    public UIMainMenuBean() {
        this.mainMenu = new MainMenu();
        this.mainMenuHtml = this.mainMenu.getHandler().initMenuHtml(this.mainMenu.getData());
        this.uiMenu = this.mainMenu.getHandler().initMenuJsf(this.mainMenu.getData(), this.mainMenu.getFactory().createMenu());
    }

    public String getMenuHtml() { return mainMenuHtml; }

    public AbstractMenu getMenu() { return uiMenu; }
}
