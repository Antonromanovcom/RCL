package ru.reso.wp.ui.base;

import java.util.List;

public abstract class MenuData {
    private List<BaseMenuItem> items;

    public List<BaseMenuItem> getItems() {
        return items;
    }

    public void setItems(List<BaseMenuItem> items) {
        this.items = items;
    }
}
