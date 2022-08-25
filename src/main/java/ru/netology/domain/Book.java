package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode

public class Book extends Products {
    private final String writer;

    public Book(int id, String name, int price, String writer) {
        super(id, name, price);
        this.writer = writer;
    }
}
