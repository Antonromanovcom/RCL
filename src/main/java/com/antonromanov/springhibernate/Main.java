package com.antonromanov.springhibernate;

import com.antonromanov.springhibernate.config.AppConfig;
import com.antonromanov.springhibernate.service.PremiumService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 *  Main class.
 */
public final class Main {

    /**
     * Do not construct me.
     */
    private Main() {
    }

    /**
     * Main method.
     *
     * @param args - args Command line args. Not used.
     */
    public static void main(final String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PremiumService greeterService = context.getBean(PremiumService.class);
        greeterService.printAll();

        System.out.println(greeterService.getOne());

    }

}
