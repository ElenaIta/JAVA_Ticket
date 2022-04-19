package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketManager manager = new TicketManager();

    private final Ticket first = new Ticket(1, 7_000, "IST", "VKO", 135);
    private final Ticket second = new Ticket(2, 5_000, "VKO", "LED", 150);
    private final Ticket third = new Ticket(3, 3_400, "LED", "IST", 500);
    private final Ticket fourth = new Ticket(4, 29_000, "IST", "CMB", 480);
    private final Ticket fifth = new Ticket(5, 35_000, "CMB", "ADA", 150);
    private final Ticket sixth = new Ticket(6, 2_000, "ADA", "IST", 100);
    private final Ticket seventh = new Ticket(7, 5_700, "VKO", "LED", 150);

    @BeforeEach
    void Save() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
    }

    @Test
    void findTicket() {
        Ticket[] expected = new Ticket[]{sixth};
        Ticket[] actual = manager.findAll("ADA", "IST");

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllTicket() {
        Ticket[] expected = new Ticket[]{second, seventh};
        Ticket[] actual = manager.findAll("VKO", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    void sortByPrice() {
        Ticket[] expected = new Ticket[]{sixth, third, second, seventh};
        Ticket[] actual = new Ticket[]{sixth, third, second, seventh};

        Arrays.sort(actual);
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
}