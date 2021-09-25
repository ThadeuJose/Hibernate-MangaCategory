package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Manga {
    private String name;
    private int nextNumber = 1;
    private String date = "";
    private List<String> categories; 

    public Manga(String name) {
        this(name, 1, "");
    }

    public Manga(String name, int nextNumber) {
        this(name, nextNumber, "");
    }

    public Manga(String name, int nextNumber, String date) {
        this.name = name;
        this.nextNumber = nextNumber;
        this.date = date;
        this.categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String[] getCategory() {
        return this.categories.toArray(String[]::new);
    }

    public boolean hasCategory(String category){
        return categories.contains(category);
    }

    public void addCategories(String... category) {
        for (String string : category) {
            categories.add(string);    
        }        
    }
}
