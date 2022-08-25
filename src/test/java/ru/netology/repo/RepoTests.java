package ru.netology.repo;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Products;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RepoTests {
    private ProductsRepo repo = new ProductsRepo();
    private Book bible = new Book(11, "Holy Bible", 500, "God");
    private Book book1 = new Book(1, "xxx", 10, "Lenin");
    private Smartphone smartphone2 = new Smartphone(5, "AbibasPro", 200, "From China");
    private Smartphone smartphone3 = new Smartphone(16, "AbibasNext", 300, "From Japan");

    @Test
    public void shouldAddAnItem() {
        repo.save(bible);
        Products[] expected = new Products[]{bible};
        Products[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(book1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(5);
        Products[] expected = new Products[]{book1, smartphone3};
        Products[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }


}