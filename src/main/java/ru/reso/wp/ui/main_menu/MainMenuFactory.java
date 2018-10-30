package ru.reso.wp.ui.main_menu;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.component.menu.AbstractMenu;
import org.primefaces.component.menu.Menu;
import org.primefaces.component.panelmenu.PanelMenu;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import ru.reso.wp.ui.base.*;
import ru.reso.wp.ui.consts.UIConsts;

import java.io.*;
import java.util.ArrayList;

/**
 * 2-х уровневое меню (main item > groups > element > subelement)
 */
public class MainMenuFactory extends MenuFactory {

    private static final Logger log = LogManager.getLogger(MainMenuFactory.class);

    public BaseMenuItem createMenuItem(JsonObject jsonObject) {
        BaseMenuItem item = new MainMenuItem();
        item.setSubItems(new ArrayList<BaseMenuItem>());
        initMenuItem(jsonObject, item);

        if (jsonObject.has(UIConsts.ITEMS)) {
            JsonArray jsonItems = jsonObject.getAsJsonArray(UIConsts.ITEMS);

            if (jsonItems.size() > 0) {
                for (JsonElement jsonItem : jsonItems) {
                    if (jsonItem.isJsonObject()) {
                        JsonObject jsonItemObj = (JsonObject) jsonItem;
                        item.getSubItems().add(createMenuItem(jsonItemObj));
                    }
                }
            }
        }

        return item;
    }

    private void initMenuItem(JsonObject jsonObject, BaseMenuItem menuItem) {
        menuItem.setType(UIConsts.MENU_ITEM_TYPE.valueOf(jsonObject.get(UIConsts.TYPE).getAsString().toUpperCase()));

        if ((menuItem.getType() == UIConsts.MENU_ITEM_TYPE.TITLE)
                || (menuItem.getType() == UIConsts.MENU_ITEM_TYPE.ITEM)) {
            menuItem.setName(jsonObject.get(UIConsts.NAME).getAsString());
            menuItem.setIcon(jsonObject.get(UIConsts.ICON).getAsString());
            menuItem.setDisabled(jsonObject.get(UIConsts.DISABLED).getAsBoolean());
            menuItem.setRendered(jsonObject.get(UIConsts.RENDERED).getAsBoolean());
        }

        if (menuItem.getType() == UIConsts.MENU_ITEM_TYPE.ITEM) {
            menuItem.setAction(jsonObject.get(UIConsts.ACTION).getAsString());
        }
    }

    private JsonObject getJsonMenu() {
        JsonObject jsonObject = null;

        try {
            Gson gson = new Gson();
            File jsonFile = new File(getClass().getClassLoader().getResource(UIConsts.FILE_MAINMENU_JSON).getFile());
            BufferedReader inJson = new BufferedReader(new InputStreamReader(new FileInputStream(jsonFile), "UTF8"));
            jsonObject = gson.fromJson(inJson, JsonObject.class);
        } catch (FileNotFoundException e) {
            log.error(e.toString());
        } catch (UnsupportedEncodingException e) {
            log.error(e.toString());
        }

        return jsonObject;
    }

    @Override
    public MenuData createData() {
        MenuData menu = new MainMenuData();
        menu.setItems(new ArrayList<BaseMenuItem>());
        JsonObject jsonRootObject = getJsonMenu();

        JsonArray jsonItems = jsonRootObject.getAsJsonArray(UIConsts.MENU_ITEMS);

        if (jsonItems.size() > 0) {
            for (JsonElement jsonItem : jsonItems) {
                if (jsonItem.isJsonObject()) {
                    JsonObject jsonItemObj = (JsonObject) jsonItem;
                    menu.getItems().add(createMenuItem(jsonItemObj));
                }
            }
        }

        return menu;
    }

    @Override
    public MenuHandler createHandler() {
        return new MainMenuHandler();
    }

    @Override
    public MenuModel createModel() {
        return new DefaultMenuModel();
    }

    @Override
    public AbstractMenu createMenu() {
        return new Menu();
    }
}
