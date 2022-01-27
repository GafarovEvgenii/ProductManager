package ru.netology.domain;

import Repository.Repository;

public class ProductManager {
    private Repository repository;

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public void removedByID (int id) {
        repository.removeById(id);
    }

    public Product [] getAll () {
        Product [] item = repository.findAll();
        return item;
    }


    public Product [] searchBy (String text) {
        Product [] result = new Product[0];
        for (Product product: repository.findAll()){
            if (product.matches(text)) {
                int length = result.length + 1;
                Product [] tmp = new Product[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp [tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


}