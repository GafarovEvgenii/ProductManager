package ru.netology.domain;

import Repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private Repository repository = new Repository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "Jane Air", 150, "Sharlotte Bronte");
    private Book second = new Book(2, "Garry Potter", 200, "Joanne Rowling");
    private Book third = new Book(3, "The wizard of Oz", 100, "L.F.Baum");
    private Smartphone fourth = new Smartphone(4, "A12", 12000, "Sumsung");
    private Smartphone fifth = new Smartphone(5, "iPhone13", 80000, "Apple");
    private Smartphone sixth = new Smartphone(6, "Nova8", 39000, "Huawei");


    @BeforeEach
    public void shouldStartManager() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

    }

    @Test
    public void shouldSearchByText() {
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Sharlotte");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText2() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Joanne");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText3() {
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("A12");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText4() {
        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextFalse() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Dream");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetProducts() {
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetProductsAfterRemove() {
        manager.removeById(1);
        manager.removeById(3);
        manager.removeById(4);
        manager.removeById(6);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{second, fifth};
        assertArrayEquals(expected, actual);
    }
}