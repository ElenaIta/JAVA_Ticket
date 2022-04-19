package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Repository rep = new Repository();

    private final Ticket first = new Ticket(1, 1_000, "IST", "VKO", 135);
    private final Ticket second = new Ticket(2, 5_000, "VKO", "LED", 150);
    private final Ticket third = new Ticket(3, 3_400, "LED", "IST", 500);

    @BeforeEach
    void initialSave() {
        rep.save(first);
        rep.save(second);
        rep.save(third);
    }

    @Test
    void save() {

        Ticket[] expected = new Ticket[]{first, second, third};
        Ticket[] actual = rep.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        Ticket[] expected = new Ticket[]{second, third};
        Ticket[] actual = rep.removeById(1);

        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        Ticket expected = second;
        Ticket actual = rep.findById(2);

        assertEquals(expected, actual);
    }

    @Test
    void findByIdNoOne() {
        Ticket expected = null;
        Ticket actual = rep.findById(4);

        assertEquals(expected, actual);
    }
}