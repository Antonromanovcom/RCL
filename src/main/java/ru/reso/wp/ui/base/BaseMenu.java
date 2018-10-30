package ru.reso.wp.ui.base;

import org.primefaces.model.menu.MenuModel;

public abstract class BaseMenu {
    protected MenuData data;
    protected MenuFactory factory;
    protected MenuHandler handler;

    public MenuFactory getFactory() { return factory; }
    public MenuData getData() {
        return data;
    }
    public MenuHandler getHandler() {
        return handler;
    }
}
