package ru.netology.repo;

import ru.netology.domain.Products;

public class ProductsRepo {
    private Products[] items = new Products[0];

    public void save(Products item) {
        int length = items.length + 1;
        Products[] tmp = new Products[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Products[] findAll() {
        return items;
    }

    public Products findById(int id) {
        for (Products item : items) {
            if (item.getId() == id) {
            }
            return item;
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Products[] tmp = new Products[length];
        int index = 0;
        for (Products item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
