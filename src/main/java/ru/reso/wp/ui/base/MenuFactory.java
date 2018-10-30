package ru.reso.wp.ui.base;

import org.primefaces.component.menu.AbstractMenu;
import org.primefaces.model.menu.MenuModel;

public abstract class MenuFactory {

    public abstract MenuData createData();
    public abstract MenuHandler createHandler();
    public abstract MenuModel createModel();
    public abstract AbstractMenu createMenu();
}
