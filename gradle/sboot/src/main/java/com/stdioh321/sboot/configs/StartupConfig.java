package com.stdioh321.sboot.configs;

import com.stdioh321.sboot.annotations.CustomAnn;
import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class StartupConfig {

    /*@Bean*/
    /*public void startupCustomAnn() {
        System.out.println("startupCustomAnn------------------------------------------------------");
        Reflections r = new Reflections("com.stdioh321.sboot.services");
        Set<Class<?>> cClasses = r.getTypesAnnotatedWith(CustomAnn.class);
        System.out.println(cClasses.stream().count());
        for (Class<?> c : cClasses){
            System.out.println("___________________________");
            System.out.println(c);
            System.out.println("___________________________");
        }

        System.out.println("----------------------------------------------------------------------");
    }*/
}
