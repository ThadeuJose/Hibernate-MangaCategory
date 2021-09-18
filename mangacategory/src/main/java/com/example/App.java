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
        Configuration configure = new Configuration().configure("hibernate-production.cfg.xml");
        configure.addAnnotatedClass(Category.class);
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Category category = new Category();
        // category.name = "Test2";     

        // System.out.println(session.save(category));

        CategoryRepository categoryRepository = new CategoryRepository(session);
        long id = 4;
		Category output = categoryRepository.loadById(id);
        System.out.println(output.name);

        session.close();
		sessionFactory.close();
    }
}
