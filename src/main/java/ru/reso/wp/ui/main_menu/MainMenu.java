package ru.reso.wp.ui.main_menu;

import ru.reso.wp.ui.base.BaseMenu;


public class MainMenu extends BaseMenu {

    public MainMenu() {
        factory = new MainMenuFactory();

        handler = factory.createHandler();
        data = factory.createData();
    }


}
