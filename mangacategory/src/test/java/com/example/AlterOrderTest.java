package com.example;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.example.model.Catalog;
import com.example.model.Manga;

import org.junit.Test;

public class AlterOrderTest {
    @Test
    public void order() {
        Manga m4 = new Manga("One Piece");
        Manga m3 = new Manga("Gintama");
        Manga m2 = new Manga("Hunter x Hunter");
        Manga m1 = new Manga("Drifters");

        LocalDate today = LocalDate.parse("2021-09-25");

        m4.setAlterDate(today);
        m3.setAlterDate(today.minusMonths(1));
        m2.setAlterDate(today.minusYears(1));
        m1.setAlterDate(today.minusYears(1).minusMonths(1));

        Catalog c = new Catalog();
        c.add(m4);
        c.add(m3);
        c.add(m2);
        c.add(m1);

        List<Manga> output = Arrays.asList(m1,m2,m3,m4);
        List<Manga> input = c.getOrderByAlterDate();

        assertEquals(output, input);
    }
}
