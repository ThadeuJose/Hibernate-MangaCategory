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
        ConfigurationFactory cf = new ConfigurationFactory();
        String productionFilename = "hibernate-production.cfg.xml";
        Configuration configuration = cf.createConfiguration(productionFilename);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Category category = new Category();
        category.name = "Test1";

        System.out.println(session.save(category));

        CategoryRepository categoryRepository = new CategoryRepository(session);
        long id = 1;
		Category output = categoryRepository.loadById(id);
        System.out.println(output);

        session.close();
		sessionFactory.close();
    }
}
