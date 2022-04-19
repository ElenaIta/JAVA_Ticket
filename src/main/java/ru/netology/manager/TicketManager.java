package ru.netology.manager;

import ru.netology.repository.Repository;
import ru.netology.domain.Ticket;

import java.util.Arrays;

public class TicketManager {
    Repository rep = new Repository();

    public void save(Ticket items) {
        rep.save(items);
    }


    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket items : rep.findAll()) {
            int length = result.length;
            if (items.getDepartureAirport().equals(from) && items.getArrivalAirport().equals(to)) {
                Ticket[] tmp = new Ticket[length + 1];

                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = items;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
