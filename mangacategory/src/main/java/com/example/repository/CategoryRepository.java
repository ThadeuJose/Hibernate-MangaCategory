package com.example.repository;

import java.util.List;

import com.example.model.Category;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CategoryRepository {
        
    public void save(Session session, Category category){
        Transaction transaction = null;

        transaction = session.beginTransaction();

        session.save(category);          
    
        transaction.commit();
    }

	public Category getById(Session session, long id) {
        return session.get(Category.class, id);
	}

    public List<Category> getAll(Session session){
        String queryString = "from Category";  
        Query<Category> query = session.createQuery(queryString, Category.class);
        return query.getResultList();
    }

}
