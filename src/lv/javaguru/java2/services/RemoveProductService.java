package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.db.Database;

import java.util.Optional;

public class RemoveProductService {

    private Database database;

    public RemoveProductService(Database database) {
        this.database = database;
    }

    public boolean remove(String title) {
        Optional<Product> foundProduct = database.findProductByTitle(title);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            return database.deleteProduct(product);
        } else {
            return false;
        }
    }

}
