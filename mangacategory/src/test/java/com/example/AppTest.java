package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeClass
    public static void beforeAllTest(){
        String testFilename = "hibernate-test.cfg.xml";
        ConfigurationFactory cf = new ConfigurationFactory();
        configuration = cf.createConfiguration(testFilename);
        
        sessionFactory = configuration.buildSessionFactory();
    }

    @Before
    public void beforeEachTest(){
        session = sessionFactory.openSession();
    }

    @Test
    public void saveCategory() {
        Category category = new Category();
        category.name = "Test";     

        session.save(category);

        CategoryRepository categoryRepository = new CategoryRepository(session);
        long id = 1;
		Category output = categoryRepository.loadById(id);
        assertNotNull(output);
        assertEquals(output.name, category.name);
    }

    @Test
    public void saveCategoryNull() {
        CategoryRepository categoryRepository = new CategoryRepository(session);
        long id = 1;
        Category output = categoryRepository.loadById(id);
        assertNull(output);
    }

    @After
	public void afterEachTest() {
		session.close();
	}

    @AfterClass
	public static void afterAllTest() {
		sessionFactory.close();
	}

}
