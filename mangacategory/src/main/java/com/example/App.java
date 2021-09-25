package com.example;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        String productionFilename = "hibernate-production.cfg.xml";
        ConfigurationFactory cf = new ConfigurationFactory();
        Configuration configuration = cf.createConfiguration(productionFilename);
        
        final SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            CategoryRepository categoryRepository = new CategoryRepository();
            Category category = new Category();
            category.name = "Test3";
            categoryRepository.save(session,category);
            Category category2 = new Category();
            category2.name = "Test4";
            categoryRepository.save(session,category2);
            Category category3 = new Category();
            category3.name = "Test5";
            categoryRepository.save(session,category3);

            categoryRepository.getAll(session).stream().forEach(s -> System.out.println(s.getId() +" "+ s.name));
        } 
		sessionFactory.close();
    }
}
