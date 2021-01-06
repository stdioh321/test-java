package com.stdioh321.sboot;

import com.google.common.reflect.ClassPath;
import com.stdioh321.sboot.annotations.CustomAnn;
import com.stdioh321.sboot.services.CityService;
import lombok.Getter;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

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
