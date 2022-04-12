package ru.netology.domain;

public class Repository {

    private Ticket[] items = new Ticket[0];


    // добавление
    public void save(Ticket item) {
        Ticket[] tmp = new Ticket[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        this.items = tmp;
    }

    // вывод всех
    public Ticket[] findAll() {
        return items;
    }

    // удаление по параметру
    public Ticket[] removeById(int id) {
        int length = items.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return tmp;
    }

    // поиск
    public Ticket findById(int id) {
        for (Ticket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
