package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Catalog {
    private List<Manga> mangas;
    
    public Catalog (){
        this.mangas = new ArrayList<>();
    }

    public void add(Manga manga){
        mangas.add(manga);
    }

    @Override
    public String toString() {
        return mangas.stream().map(Manga::getName).collect(Collectors.joining("\n"));
    }

    public List<Manga> getAllByCategory(String category) {
        return mangas.stream().filter(m -> m.hasCategory(category)).collect(Collectors.toList());
    }
}
