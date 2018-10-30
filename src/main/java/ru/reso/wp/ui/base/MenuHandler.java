package ru.reso.wp.ui.base;

import org.primefaces.component.menu.AbstractMenu;
import org.primefaces.model.menu.MenuModel;

public abstract class MenuHandler {

    public abstract String initMenuHtml(MenuData data);

    public abstract MenuModel initMenuModelJsf(MenuData data, MenuModel menuModel);
    public abstract AbstractMenu initMenuJsf(MenuData data, AbstractMenu menu);
}

