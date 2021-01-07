package com.stdioh321.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication


public class SbootApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(SbootApplication.class, args);
        SbootApplication app = new SbootApplication();
        app.startupCustomAnn();
        System.out.println("MAIN_____________________________________________");
    }

    public void startupCustomAnn() {
        System.out.println("startupCustomAnn------------------------------------------------------");
        /*var reflects = new Reflections("com.stdioh321", new FieldAnnotationsScanner()).getFieldsAnnotatedWith(CustomAnn.class);

        try {
            for (Field obj : reflects) {
                obj.setAccessible(true);
                System.out.println(obj.getAnnotation(CustomAnn.class).key());
            }
        } catch (Exception e) {
            System.out.println(e);
        }*/

        System.out.println("----------------------------------------------------------------------");
    }
}
