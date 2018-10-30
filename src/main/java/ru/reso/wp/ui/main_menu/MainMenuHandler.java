package ru.reso.wp.ui.main_menu;

import org.primefaces.component.menu.AbstractMenu;
import org.primefaces.model.menu.*;
import ru.reso.wp.ui.base.MenuData;
import ru.reso.wp.ui.base.MenuHandler;
import ru.reso.wp.ui.base.BaseMenuItem;
import ru.reso.wp.ui.consts.UIConsts;
import ru.reso.wp.ui.main_menu.renderer.UIMainMenuItem;
import ru.reso.wp.ui.main_menu.renderer.UIMainMenuSeparator;
import ru.reso.wp.ui.main_menu.renderer.UIMainMenuSubmenu;

import java.text.MessageFormat;

public class MainMenuHandler extends MenuHandler {

    /**
     * Test
     *
     * @param item
     * @return
     */
    private String genMenuHtml(BaseMenuItem item) {
        String result ="";

        switch (item.getType()) {
            case DIVIDER:
                result += MessageFormat.format(UIConsts.MAIN_MENU_DIVIDER_HTML, "");
                break;
            case TITLE:
                result += MessageFormat.format(UIConsts.MAIN_MENU_TITLE_HTML, item.getName());
                break;
            case ITEM:
                if (item.getSubItems().size() > 0) {
                    result += MessageFormat.format(UIConsts.MAIN_MENU_DROPDOWN_ITEM_HTML_START, item.getAction(), item.getIcon(), item.getName());
                    result += MessageFormat.format(UIConsts.MAIN_MENU_DROPDOWN_ITEMS_HTML_START, "");
                } else {
                    result += MessageFormat.format(UIConsts.MAIN_MENU_ITEM_HTML, item.getAction(), item.getIcon(), item.getName());
                }
                break;
            default:
                break;
        }

        for (BaseMenuItem subItem : item.getSubItems()) {
            result += genMenuHtml(subItem);
        }

        if ((item.getType() == UIConsts.MENU_ITEM_TYPE.ITEM) && (item.getSubItems().size() > 0)){
            result += MessageFormat.format(UIConsts.MAIN_MENU_DROPDOWN_ITEMS_HTML_END, "");
            result += MessageFormat.format(UIConsts.MAIN_MENU_ITEM_HTML_END, "");
        }

        return result;
    }

    /**
     * Test
     *
     * @param data
     * @return
     */
    @Override
    public String initMenuHtml(MenuData data) {
        String result = "";

        for (BaseMenuItem item : data.getItems()) {
            result += genMenuHtml(item);
        }

        return result;
    }

    /**
     * Test
     *
     * @param data
     * @param menuModel
     * @return
     */
    public MenuModel initMenuModelJsf_Test(MenuData data, MenuModel menuModel) {
        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

        DefaultMenuItem item = new DefaultMenuItem("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);

        menuModel.addElement(firstSubmenu);

        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuView.save}");
        item.setUpdate("messages");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.addElement(item);

        menuModel.addElement(secondSubmenu);

        return menuModel;
    }

    /**
     * Test
     *
     * @param data
     * @param menu
     * @return
     */
    public AbstractMenu initMenuJsf_Test(MenuData data, AbstractMenu menu) {
        //main page
        UIMainMenuItem item = new UIMainMenuItem();
        item.setValue("Главная");
        item.setUrl("/main.xhtml");
        item.setIcon("icon-diamond");
        menu.getElements().add(item);

        //separator
        UIMainMenuSeparator separator = new UIMainMenuSeparator();
        separator.setTitle("PRODUCTS");
        menu.getElements().add(separator);

        //First submenu
        UIMainMenuSubmenu firstSubmenu = new UIMainMenuSubmenu();
        firstSubmenu.setLabel("Dynamic submenu");
        firstSubmenu.setIcon("icon-diamond");

        //
        item = new UIMainMenuItem();
        item.setValue("Test 1");
        item.setUrl("/main.xhtml");
        item.setIcon("icon-diamond");

        firstSubmenu.getElements().add(item);
        menu.getElements().add(firstSubmenu);

        item = new UIMainMenuItem();
        item.setValue("Test 2");
        item.setUrl("/main.xhtml");
        item.setIcon("icon-diamond");

        firstSubmenu.getElements().add(item);

        //Second submenu
        UIMainMenuSubmenu secondSubmenu = new UIMainMenuSubmenu();
        secondSubmenu.setLabel("Dynamic action");
        secondSubmenu.setIcon("icon-diamond");

        item = new UIMainMenuItem();
        item.setValue("Save");
        item.setUrl("/main.xhtml");
        item.setIcon("icon-diamond");

        secondSubmenu.getElements().add(item);

        menu.getElements().add(secondSubmenu);

        return menu;
    }

    @Override
    public MenuModel initMenuModelJsf(MenuData data, MenuModel menuModel) {
        return null;
    }

    private MenuElement genMenuJsf(BaseMenuItem item) {
        MenuElement uiItem = null;

        switch (item.getType()) {
            case TITLE:
                UIMainMenuSeparator separator = new UIMainMenuSeparator();
                separator.setTitle(item.getName());
                uiItem = separator;
                break;
            case ITEM:
                if (item.getSubItems().size() > 0) {
                    UIMainMenuSubmenu subMenu = new UIMainMenuSubmenu();

                    subMenu.setLabel(item.getName());
                    subMenu.setIcon(item.getIcon());
                    subMenu.setStyleClass(UIConsts.NAV_ITEM_CLASS + " " + UIConsts.NAV_DROPDOWN_CLASS);

                    for (BaseMenuItem subItem : item.getSubItems()) {
                        subMenu.getElements().add(genMenuJsf(subItem));
                    }

                    uiItem = subMenu;
                } else {
                    UIMainMenuItem menuItem = new UIMainMenuItem();
                    menuItem.setValue(item.getName());
                    menuItem.setUrl(item.getAction());
                    menuItem.setIcon(UIConsts.NAV_ICON_CLASS + " " + item.getIcon());
                    uiItem = menuItem;
                }
                break;
            default:
                break;
        }

        return uiItem;
    }

    @Override
    public AbstractMenu initMenuJsf(MenuData data, AbstractMenu menu) {
        for (BaseMenuItem item : data.getItems()) {
            menu.getElements().add(genMenuJsf(item));
        }

        return menu;
    }
}
