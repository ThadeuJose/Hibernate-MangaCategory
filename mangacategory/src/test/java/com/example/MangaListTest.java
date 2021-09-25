package com.example;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.example.model.Catalog;
import com.example.model.Manga;

import org.junit.Test;

public class MangaListTest {
    @Test
    public void addManga1() {
        
        Manga m1 = new Manga("Vigilante: Boku no Hero Academia Illegals", 110);
        Manga m2 = new Manga("Boku no Hero Academia", 327, "18/09/2021");
        Catalog c = new Catalog();
        c.add(m1);
        c.add(m2);

        String output = "Vigilante: Boku no Hero Academia Illegals\nBoku no Hero Academia";
        
        assertEquals(c.toString(), output);
    }

    @Test
    public void addManga2() {
        
        Manga m1 = new Manga("Vigilante: Boku no Hero Academia Illegals", 110);
        Manga m2 = new Manga("Boku no Hero Academia", 327, "18/09/2021");
        Manga m3 = new Manga("The Way of the Househusband - Gokushufudou");
        Catalog c = new Catalog();
        c.add(m1);
        c.add(m2);
        c.add(m3);

        String output = "Vigilante: Boku no Hero Academia Illegals\nBoku no Hero Academia\nThe Way of the Househusband - Gokushufudou";
        
        assertEquals(c.toString(), output);
    }

    @Test
    public void getListBySingleCategory() {
        
        Manga m1 = new Manga("Vigilante: Boku no Hero Academia Illegals", 110);
        Manga m2 = new Manga("Boku no Hero Academia", 327, "18/09/2021");
        Manga m3 = new Manga("The Way of the Househusband - Gokushufudou");
        m1.addCategories("Shonen");
        m2.addCategories("Shonen");        
        Catalog c = new Catalog();
        c.add(m1);
        c.add(m2);
        c.add(m3);

        List<Manga> input = c.getAllByCategory("Shonen"); 

        List<Manga> output = Arrays.asList(m1,m2);
        
        assertEquals(input, output);
    }

    @Test
    public void getListByMultipleCategory() {
        
        Manga m1 = new Manga("Vigilante: Boku no Hero Academia Illegals", 110);
        Manga m2 = new Manga("Boku no Hero Academia", 327, "18/09/2021");
        Manga m3 = new Manga("The Way of the Househusband - Gokushufudou");
        m1.addCategories("Shonen");
        m1.addCategories("Monthly");
        m2.addCategories("Shonen");        
        m3.addCategories("Comedy", "Monthly");
        Catalog c = new Catalog();
        c.add(m1);
        c.add(m2);
        c.add(m3);

        List<Manga> input = c.getAllByCategory("Monthly"); 

        List<Manga> output = Arrays.asList(m1,m3);
        
        assertEquals(input, output);
    }

    @Test
    public void getCategory() {
        
        Manga m1 = new Manga("Vigilante: Boku no Hero Academia Illegals", 110);
        m1.addCategories("Shonen");
        m1.addCategories("Monthly");
 
        String[] input = m1.getCategory(); 

        String[] output = {"Shonen", "Monthly"};
        
        assertArrayEquals(output,input);
    }
}
