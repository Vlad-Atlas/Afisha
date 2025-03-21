package ru.netology.afisha;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void addOneMovie() {
        MovieManager manager = new MovieManager();
        manager.add("Джентльмены");
        assertArrayEquals(new String[]{"Джентльмены"}, manager.findAll());
    }

    @Test
    void findAllInOrder() {
        MovieManager manager = new MovieManager();
        String[] expected = {
                "Джентльмены",
                "Бладшот",
                "Вперед",
                "Человек-Невидимка",
                "Отель Белград",
                "Тролли. Мировой тур",
                "Номер один"
        };
        for (String movie : expected) {
            manager.add(movie);
        }
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void findLastWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        String[] movies = {
                "Джентльмены",
                "Бладшот",
                "Вперед",
                "Человек-Невидимка",
                "Отель Белград",
                "Тролли. Мировой тур",
                "Номер один"
        };
        for (String movie : movies) {
            manager.add(movie);
        }
        String[] expected = {"Номер один", "Тролли. Мировой тур", "Отель Белград", "Человек-Невидимка", "Вперед"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void findLastWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.add("Джентльмены");
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Человек-Невидимка");
        String[] expected = {"Человек-Невидимка", "Вперед", "Бладшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void findLastWhenEmpty() {
        MovieManager manager = new MovieManager();
        assertEquals(0, manager.findLast().length);
    }

    @Test
    void findLastWithZeroLimit() {
        MovieManager manager = new MovieManager(0);
        manager.add("Джентльмены");
        assertEquals(0, manager.findLast().length);
    }
}