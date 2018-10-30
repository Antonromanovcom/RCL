package ru.reso.wp.ui.main_menu.renderer;

import org.primefaces.component.api.AjaxSource;
import org.primefaces.component.api.UIOutcomeTarget;
import org.primefaces.component.menu.AbstractMenu;
import org.primefaces.component.menu.Menu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.Separator;
import org.primefaces.model.menu.Submenu;
import org.primefaces.util.ComponentTraversalUtils;
import ru.reso.wp.ui.consts.UIConsts;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuRenderer extends org.primefaces.component.menu.MenuRenderer {
    public MenuRenderer() {
        super();
    }

    @Override
    protected void encodeMarkup(FacesContext context, AbstractMenu abstractMenu) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        Menu menu = (Menu) abstractMenu;
        String clientId = menu.getClientId(context);
        String style = menu.getStyle();
        String styleClass = menu.getStyleClass();
        String defaultStyleClass = menu.isOverlay() ? Menu.DYNAMIC_CONTAINER_CLASS : Menu.STATIC_CONTAINER_CLASS;
        if (menu.isToggleable()) {
            defaultStyleClass = defaultStyleClass + " " + Menu.TOGGLEABLE_MENU_CLASS;
        }
        styleClass = styleClass == null ? defaultStyleClass : defaultStyleClass + " " + styleClass;

        writer.startElement("div", menu);
        writer.writeAttribute("id", clientId, "id");
        writer.writeAttribute("class", styleClass, "styleClass");
        if (style != null) {
            writer.writeAttribute("style", style, "style");
        }
        writer.writeAttribute("role", "menu", null);

        encodeKeyboardTarget(context, menu);

        if (menu.getElementsCount() > 0) {
            writer.startElement("ul", null);
            writer.writeAttribute("class", Menu.LIST_CLASS + " " + UIConsts.NAV_CLASS, null);
            encodeElements(context, menu, menu.getElements());
            writer.endElement("ul");
        }

        writer.endElement("div");
    }

    @Override
    protected void encodeElements(FacesContext context, Menu menu, List<MenuElement> elements) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        boolean toggleable = menu.isToggleable();

        for (MenuElement element : elements) {
            if (element.isRendered()) {
                if (element instanceof MenuItem) {
                    MenuItem menuItem = (MenuItem) element;
                    String containerStyle = menuItem.getContainerStyle();
                    String containerStyleClass = menuItem.getContainerStyleClass();
                    containerStyleClass = (containerStyleClass == null) ? Menu.MENUITEM_CLASS : Menu.MENUITEM_CLASS + " " + containerStyleClass;

                    if (toggleable) {
                        UIComponent parent = ((UIComponent) menuItem).getParent();
                        containerStyleClass = (parent instanceof Submenu) ? containerStyleClass + " " + Menu.SUBMENU_CHILD_CLASS : containerStyleClass;
                    }

                    writer.startElement("li", null);
                    containerStyleClass += " " + UIConsts.NAV_ITEM_CLASS;
                    writer.writeAttribute("class", containerStyleClass, null);

                    writer.writeAttribute("role", "menuitem", null);
                    if (containerStyle != null) {
                        writer.writeAttribute("style", containerStyle, null);
                    }
                    encodeMenuItem(context, menu, menuItem);
                    writer.endElement("li");
                } else if (element instanceof Submenu) {
                    encodeSubmenu(context, menu, (Submenu) element);
                } else if (element instanceof Separator) {
                    encodeSeparator(context, (Separator) element);
                }
            }
        }

    }

    @Override
    protected void encodeSeparator(FacesContext context, Separator separator) throws IOException {

        if (separator instanceof UIMainMenuSeparator) {

            ResponseWriter writer = context.getResponseWriter();
            String style = separator.getStyle();
            String styleClass = separator.getStyleClass();
            styleClass = styleClass == null ? UIConsts.NAV_TITLE_CLASS : UIConsts.NAV_TITLE_CLASS + " " + styleClass;

            //title
            writer.startElement("li", null);
            writer.writeAttribute("class", styleClass, null);
            if (style != null) {
                writer.writeAttribute("style", style, null);
            }
            writer.write(separator.getTitle());

            writer.endElement("li");
        } else {
            super.encodeSeparator(context, separator);
        }
    }

    @Override
    protected void encodeSubmenu(FacesContext context, Menu menu, Submenu submenu) throws IOException {
        if (submenu instanceof UIMainMenuSubmenu) {
            ResponseWriter writer = context.getResponseWriter();
            String label = submenu.getLabel();
            String icon = submenu.getIcon();
            String style = submenu.getStyle();
            String styleClass = submenu.getStyleClass();
            styleClass = styleClass == null ? Menu.SUBMENU_TITLE_CLASS : Menu.SUBMENU_TITLE_CLASS + " " + styleClass;
            boolean toggleable = menu.isToggleable();

            //title
            writer.startElement("li", null);
            if (toggleable) {
                writer.writeAttribute("id", submenu.getClientId(), null);
            }
            writer.writeAttribute("class", styleClass, null);
            if (style != null) {
                writer.writeAttribute("style", style, null);
            }

            writer.startElement("h3", null);

            writer.writeAttribute("class", UIConsts.NAV_LINK_CLASS, null);

            encodeIcon(context, label, "nav-icon " + submenu.getIcon());

            if (menu.isToggleable()) {
                encodeIcon(context, label, Menu.EXPANDED_SUBMENU_HEADER_ICON_CLASS);
            }

            if (label != null) {
                writer.writeText(label, "value");
            }

            writer.endElement("h3");

            writer.endElement("li");

            encodeElements(context, menu, submenu.getElements());
        } else {
            super.encodeSubmenu(context, menu, submenu);
        }
    }

    @Override
    protected void encodeMenuItem(FacesContext context, AbstractMenu menu, MenuItem menuitem) throws IOException {
        if (menuitem instanceof UIMainMenuItem) {
            ResponseWriter writer = context.getResponseWriter();
            String title = menuitem.getTitle();
            String style = menuitem.getStyle();
            boolean disabled = menuitem.isDisabled();
            String rel = menuitem.getRel();

            writer.startElement("a", null);
            writer.writeAttribute("tabindex", "-1", null);
            if (shouldRenderId(menuitem)) {
                writer.writeAttribute("id", menuitem.getClientId(), null);
            }
            if (title != null) {
                writer.writeAttribute("title", title, null);
            }

            String styleClass = this.getLinkStyleClass(menuitem);
            styleClass += " " + UIConsts.NAV_LINK_CLASS;

            if (disabled) {
                styleClass = styleClass + " ui-state-disabled";
            }

            writer.writeAttribute("class", styleClass, null);

            if (style != null) {
                writer.writeAttribute("style", style, null);
            }

            if (rel != null) {
                writer.writeAttribute("rel", rel, null);
            }

            if (disabled) {
                writer.writeAttribute("href", "#", null);
                writer.writeAttribute("onclick", "return false;", null);
            } else {
                setConfirmationScript(context, menuitem);
                String onclick = menuitem.getOnclick();

                //GET
                if (menuitem.getUrl() != null || menuitem.getOutcome() != null) {
                    String targetURL = getTargetURL(context, (UIOutcomeTarget) menuitem);
                    writer.writeAttribute("href", targetURL, null);

                    if (menuitem.getTarget() != null) {
                        writer.writeAttribute("target", menuitem.getTarget(), null);
                    }
                }
                //POST
                else {
                    writer.writeAttribute("href", "#", null);

                    UIComponent form = ComponentTraversalUtils.closestForm(context, menu);
                    if (form == null) {
                        throw new FacesException("MenuItem must be inside a form element");
                    }

                    String command;
                    if (menuitem.isDynamic()) {
                        String menuClientId = menu.getClientId(context);
                        Map<String, List<String>> params = menuitem.getParams();
                        if (params == null) {
                            params = new LinkedHashMap<String, List<String>>();
                        }
                        List<String> idParams = new ArrayList<String>();
                        idParams.add(menuitem.getId());
                        params.put(menuClientId + "_menuid", idParams);

                        command = menuitem.isAjax() ? buildAjaxRequest(context, menu, (AjaxSource) menuitem, form, params) : buildNonAjaxRequest(context, menu, form, menuClientId, params, true);
                    } else {
                        command = menuitem.isAjax() ? buildAjaxRequest(context, (AjaxSource) menuitem, form) : buildNonAjaxRequest(context, ((UIComponent) menuitem), form, ((UIComponent) menuitem).getClientId(context), true);
                    }

                    onclick = (onclick == null) ? command : onclick + ";" + command;
                }

                if (onclick != null) {
                    if (menuitem.requiresConfirmation()) {
                        writer.writeAttribute("data-pfconfirmcommand", onclick, null);
                        writer.writeAttribute("onclick", menuitem.getConfirmationScript(), "onclick");
                    } else {
                        writer.writeAttribute("onclick", onclick, null);
                    }
                }
            }

            encodeMenuItemContent(context, menu, menuitem);

            writer.endElement("a");
        } else {
            super.encodeMenuItem(context, menu, menuitem);
        }
    }

    @Override
    protected void encodeMenuItemContent(FacesContext context, AbstractMenu menu, MenuItem menuitem) throws IOException {
        if (menuitem instanceof UIMainMenuItem) {
            ResponseWriter writer = context.getResponseWriter();
            String icon = menuitem.getIcon();
            Object value = menuitem.getValue();

            if(icon != null) {
                writer.startElement("span", null);
                writer.writeAttribute("class", "ui-menuitem-icon" + " " + icon, null);
                writer.endElement("span");
            }

            writer.startElement("span", null);
            writer.writeAttribute("class", AbstractMenu.MENUITEM_TEXT_CLASS, null);

            if(value != null) {
                if(menuitem.isEscape())
                    writer.writeText(value, "value");
                else
                    writer.write(value.toString());
            }
            else if(menuitem.shouldRenderChildren()) {
                renderChildren(context, (UIComponent) menuitem);
            }

            writer.endElement("span");
        } else {
            super.encodeMenuItemContent(context, menu, menuitem);
        }
    }

}
