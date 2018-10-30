package ru.reso.wp.ui.consts;

public interface UIConsts {
    /**
     * Main menu
     */

    public static final String FILE_MAINMENU_JSON = "json/main_menu.json";

    public static enum MENU_ITEM_TYPE {TITLE, ITEM, DIVIDER};

    public static final String MENU_ITEMS = "menu-items";
    public static final String TYPE = "type";
    public static final String NAME = "name";
    public static final String ICON = "icon";
    public static final String ACTION = "action";
    public static final String DISABLED = "disabled";
    public static final String RENDERED = "rendered";
    public static final String ITEMS = "items";

    public static final String MAIN_MENU_DIVIDER_HTML = "<li class=\"divider\"></li>";
    public static final String MAIN_MENU_TITLE_HTML = "<li class=\"nav-title\">{0}</li>";

    public static final String MAIN_MENU_ITEM_HTML =
            "<li class=\"nav-item\">\n" +
                    "<a class=\"nav-link\" href=\"{0}\">\n" +
                    "    <i class=\"nav-icon {1}\"></i> {2}</a>\n" +
                    "</li>";

    public static final String MAIN_MENU_DROPDOWN_ITEM_HTML_START =
            "<li class=\"nav-item nav-dropdown\">\n" +
                    "<a class=\"nav-link nav-dropdown-toggle\" href=\"{0}\">\n" +
                    "    <i class=\"nav-icon {1}\"></i> {2}</a>";

    public static final String MAIN_MENU_ITEM_HTML_END = "</li>";

    public static final String MAIN_MENU_DROPDOWN_ITEMS_HTML_START = "<ul class=\"nav-dropdown-items\">";
    public static final String MAIN_MENU_DROPDOWN_ITEMS_HTML_END = "</ul>";


    public static final String NAV_CLASS = "nav";
    public static final String NAV_ITEM_CLASS = "nav-item";
    public static final String NAV_LINK_CLASS = "nav-link";
    public static final String NAV_TITLE_CLASS = "nav-title";
    public static final String NAV_ICON_CLASS = "nav-icon";
    public static final String NAV_DROPDOWN_CLASS = "nav-dropdown";
    public static final String NAV_DROPDOWNTOGGLE_CLASS = "nav-dropdown-toggle";
    public static final String NAV_DROPDOWNITEMS_CLASS = "nav-dropdown-items";

}
