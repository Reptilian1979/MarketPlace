package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Products;
import ru.netology.domain.Smartphone;
import ru.netology.repo.ProductsRepo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {
    private ProductsRepo repo = new ProductsRepo();
    private Manager productManager = new Manager(repo);

    private Book book1 = new Book(1, "xxx", 10, "Lenin");
    private Book book2 = new Book(2, "yyy", 20, "Stalin");
    private Book book3 = new Book(7, "zzz", 30, "Stalin");


    private Smartphone smartphone1 = new Smartphone(3, "Abibas1", 100, "From China");
    private Smartphone smartphone2 = new Smartphone(5, "AbibasPro", 200, "From China");
    private Smartphone smartphone3 = new Smartphone(16, "AbibasNext", 300, "From Japan");


    @BeforeEach
    public void setUp() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
    }

    @Test
    void shouldSearchPhoneByName() {
        String text = "Abibas1";

        Products[] expected = new Products[]{smartphone1};
        Products[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByName() {
        String text = "yyy";

        Products[] expected = new Products[]{book2};
        Products[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchPhoneByBrand() {
        String text = "From Japan";

        Products[] expected = new Products[]{smartphone3};
        Products[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByWriter() {
        String text = "Lenin";

        Products[] expected = new Products[]{book1};
        Products[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBooksByWriter() {
        String text = "Stalin";

        Products[] expected = new Products[]{book2, book3};
        Products[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchPhonesByBrand() {
        String text = "From China";

        Products[] expected = new Products[]{smartphone1, smartphone2};
        Products[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldJustSearch() {
        assertEquals(0, productManager.searchBy("zero").length);
    }
}
