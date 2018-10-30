package ru.reso.wp.ui.base;

import ru.reso.wp.ui.consts.UIConsts;

import java.util.List;

public abstract class BaseMenuItem {
    private UIConsts.MENU_ITEM_TYPE type;
    private String name;
    private String icon;
    private String action;
    private boolean disabled;
    private boolean rendered;
    private List<BaseMenuItem> subItems;

    public BaseMenuItem() {
    }

    public UIConsts.MENU_ITEM_TYPE getType() {
        return type;
    }

    public void setType(UIConsts.MENU_ITEM_TYPE type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public List<BaseMenuItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(List<BaseMenuItem> subItems) {
        this.subItems = subItems;
    }
}
