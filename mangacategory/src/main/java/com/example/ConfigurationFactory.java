package com.example;

import com.example.model.Category;

import org.hibernate.cfg.Configuration;

public class ConfigurationFactory {

    public Configuration createConfiguration(String configurationFilename) {
        Configuration configuration = new Configuration();
        configuration.configure(configurationFilename);
        configuration.addAnnotatedClass(Category.class);
        return configuration;
    }

}
