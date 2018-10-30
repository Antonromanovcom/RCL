package ru.reso.wp.templates;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "template")
@SessionScoped
public class TemplateSessionBean implements Serializable {
}
