package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class AppTest {

    private Configuration configure;

    @Test
    public void saveCategory() {
        configure = new Configuration().configure("hibernate-test.cfg.xml");
        configure.addAnnotatedClass(Category.class);
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Category category = new Category();
        category.name = "Test";     

        session.save(category);

        CategoryRepository categoryRepository = new CategoryRepository(session);
        long id = 1;
		Category output = categoryRepository.loadById(id);
        assertNotNull(output);
        assertEquals(output.name, category.name);

        session.close();
		sessionFactory.close();        
    }
}
