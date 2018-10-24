package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.db.Database;

public class AddProductService {

    private Database database;

    public AddProductService(Database database) {
        this.database = database;
    }

    public void add(String title,
                    String description) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);

        database.addProduct(product);
    }

}
