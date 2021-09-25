package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryHibernateTest {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    @Before
    public void beforeTest(){
        String testFilename = "hibernate-test.cfg.xml";
        ConfigurationFactory cf = new ConfigurationFactory();
        configuration = cf.createConfiguration(testFilename);
        
        sessionFactory = configuration.buildSessionFactory();
    }

    @After
	public void afterTest() {
		sessionFactory.close();
	}

    @Test
    public void testIfSave() {
        Category input = new Category();
        input.name = "Test";  
        try (Session session = sessionFactory.openSession()) { 
            CategoryRepository categoryRepository = new CategoryRepository(); 
            categoryRepository.save(session, input);
        }

        Category output;    
        try (Session session = sessionFactory.openSession()) { 
            CategoryRepository categoryRepository2 = new CategoryRepository();
            output = categoryRepository2.getById(session,1);
        }
        assertEquals(output.name, input.name);
    }

    //Not put first or the test not check 
    @Test
    public void testIfDatabaseStartEmpty() { 
        CategoryRepository categoryRepository = new CategoryRepository();
        try (Session session = sessionFactory.openSession()) {   
            assertEquals(0, categoryRepository.getAll(session).size());
        }
    }

    @Test
    public void testIfSaveMultiples() {  
        CategoryRepository categoryRepository = new CategoryRepository();
        try (Session session = sessionFactory.openSession()) {               

            Category category2 = new Category();
            category2.name = "Test2";
            categoryRepository.save(session, category2);

            Category category3 = new Category();
            category3.name = "Test3";
            categoryRepository.save(session, category3);
            
            Category category4 = new Category();
            category4.name = "Test4";
            categoryRepository.save(session, category4);
            
            Category category5 = new Category();
            category5.name = "Test5";
            categoryRepository.save(session, category5);
        }

        List<Category> output;    
        try (Session session = sessionFactory.openSession()) {
            CategoryRepository categoryRepository2 = new CategoryRepository();
            output = categoryRepository2.getAll(session);  
        }
        assertEquals(4, output.size());
        assertEquals("Test2", output.get(0).name);
        assertEquals("Test3", output.get(1).name);
        assertEquals("Test4", output.get(2).name);
        assertEquals("Test5", output.get(3).name);
    }

    @Test
    public void testIfIsNull() {
        try (Session session = sessionFactory.openSession()) {
            CategoryRepository categoryRepository = new CategoryRepository();
            assertNull(categoryRepository.getById(session, 1));
        }
    }
}
