package ru.netology.domain;

import Repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private Repository repository = new Repository();
    private ProductManager manager = new ProductManager(repository);
    private Smartphone appleIphone12 = new Smartphone(1, 50000, "Apple", "Iphone 12" );
    private Smartphone samsungGalaxyA51 = new Smartphone(2, 25000, "Samsung", "Galaxy A51");
    private Book triompheArc = new Book(3, 250, "Remark","The arc de triomphe");
    private Book flowersForAlgernon = new Book(4, 300, "Daniel Keyes", "Flowers for Algernon");
    private Smartphone appleIphone11 = new Smartphone(5, 37000, "Apple", "Iphone 11");
    private Book nineteenEightyFour = new Book(6, 320, "George Orwell", "1984");

    @BeforeEach
    public void setUp (){
    manager.add(triompheArc);
    manager.add(nineteenEightyFour);
    manager.add(samsungGalaxyA51);
    manager.add(appleIphone11);
    manager.add(appleIphone12);
    manager.add(flowersForAlgernon);
    manager.add(new Product());
    }


     @Test
    public void shouldSearchSmartphoneApple (){
        Product [] expected = new Product[] {appleIphone11, appleIphone12};
        Product [] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneModel (){
        Product [] expected = new Product[] {samsungGalaxyA51};
        Product [] actual = manager.searchBy("Galaxy A51");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneSamsung (){
        Product [] expected = new Product[] {samsungGalaxyA51};
        Product [] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBook (){
        Product [] expected = new Product[] {triompheArc};
        Product [] actual = manager.searchBy("The arc de triomphe");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAuthor (){
        Product [] expected = new Product[] {flowersForAlgernon};
        Product [] actual = manager.searchBy("Daniel Keyes");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNonBook (){
        Product [] expected = new Product[] {};
        Product [] actual = manager.searchBy("Idiot");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookName (){
        Product [] expected = new Product[] {nineteenEightyFour};
        Product [] actual = manager.searchBy("1984");
        assertArrayEquals(expected, actual);
    }

}