package ru.netology.manager;

import ru.netology.domain.Repository;
import ru.netology.domain.Ticket;

public class TicketManager {
    Repository rep = new Repository();

    public void save(Ticket items) {
        rep.save(items);
    }

    public Ticket[] findAll(String departureAirport, String arrivalAirpor) {

        Ticket[] result = new Ticket[0];

        for (Ticket items : rep.findAll()) {
            if (items.getDepartureAirport() == departureAirport) {
                if (items.getArrivalAirport() == arrivalAirpor) {
                    int length = result.length + 1;
                    Ticket[] tmp = new Ticket[length];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    int lastIndex = tmp.length - 1;
                    tmp[lastIndex] = items;
                    result = tmp;
                }
            }
        }
        return result;
    }
}
