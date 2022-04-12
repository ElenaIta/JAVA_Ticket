package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    @Override
    public int compareTo(Ticket o) {
        Ticket items = (Ticket) o;
        return this.price - items.price;
//        return 0;
    }
}
