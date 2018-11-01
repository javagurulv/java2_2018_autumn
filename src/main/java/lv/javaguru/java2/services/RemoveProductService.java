package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.database.ProductRepository;

import java.util.Optional;

public class RemoveProductService {

    private ProductRepository database;

    public RemoveProductService(ProductRepository database) {
        this.database = database;
    }

    public boolean remove(String title) {
        Optional<Product> foundProduct = database.findByTitle(title);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            return database.remove(product);
        } else {
            return false;
        }
    }

}
