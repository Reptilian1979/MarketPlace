package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Products;
import ru.netology.repo.ProductsRepo;

public class Manager {
    private ProductsRepo repo;

    public Manager(ProductsRepo repo) {
        this.repo = repo;
    }

    public void add(Products item) {
        repo.save(item);
    }

    public Products[] searchBy(String text) {
        Products[] result = new Products[0];
        for (Products product : repo.findAll()) {
            if (matches(product, text)) {
                Products[] tmp = new Products[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Products products, String search) {
        if (products instanceof Book) {
            Book book = (Book) products;
            if (book.getWriter().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }

        if (products instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) products;
            if (smartphone.getBrand().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
