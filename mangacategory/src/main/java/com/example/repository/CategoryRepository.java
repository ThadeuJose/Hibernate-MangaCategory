package com.example.repository;

import com.example.model.Category;

import org.hibernate.Session;

public class CategoryRepository {
    
    private Session session;

    public CategoryRepository(Session session){
        this.session = session;
    }

	public Category loadById(long id) {
        Category category = session.get(Category.class, id);
        return category;
	}

}
