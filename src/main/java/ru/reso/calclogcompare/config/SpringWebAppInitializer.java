package ru.reso.calclogcompare.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * The type Spring web app initializer.
 */
public class SpringWebAppInitializer implements WebApplicationInitializer {

    /**
     *  Основной метод данного интерфейса,
     *  который мы оверрайдим и прописываем
     *  туда СервлетДиспатчер. Нужно для работы
     *  WEB-части приложения.
     *
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }



}
