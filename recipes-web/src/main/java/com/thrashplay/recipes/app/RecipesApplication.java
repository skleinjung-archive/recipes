package com.thrashplay.recipes.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * TODO: Add class documentation
 *
 * @author Sean Kleinjung
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {
    com.thrashplay.recipes.app.PackageLocator.class,
    com.thrashplay.recipes.controller.PackageLocator.class,
    com.thrashplay.recipes.web.PackageLocator.class
})
public class RecipesApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RecipesApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
    }
}
