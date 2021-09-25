package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

	@Column //TODO: Adicionar no final(unique = true, nullable = false)
	public String name;

    public Long getId() {
        return id;
    }
}
