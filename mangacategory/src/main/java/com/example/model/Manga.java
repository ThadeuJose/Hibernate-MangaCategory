package com.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manga {
    private String name;
    private int nextNumber = 1;
    private String dateOfNextRelease = "";
    private LocalDate alterDate; //Date when this register was alter
    private List<String> categories; 

    public Manga(String name) {
        this(name, 1, "");
    }

    public Manga(String name, int nextNumber) {
        this(name, nextNumber, "");
    }

    public Manga(String name, int nextNumber, String dateOfNextRelease) {
        this.name = name;
        this.nextNumber = nextNumber;
        this.dateOfNextRelease = dateOfNextRelease;
        this.categories = new ArrayList<>();
    }

    public boolean hasCategory(String category){
        return categories.contains(category);
    }

    public void addCategories(String... category) {
        for (String string : category) {
            categories.add(string);    
        }        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public LocalDate getAlterDate() {
        return alterDate;
    }

    public void setAlterDate(LocalDate alterDate) {
        this.alterDate = alterDate;
    }

    public String[] getCategory() {
        return this.categories.toArray(String[]::new);
    }
   
}
