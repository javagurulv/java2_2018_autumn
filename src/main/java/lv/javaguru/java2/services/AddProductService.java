package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.database.ProductRepository;

public class AddProductService {

    private ProductRepository database;

    public AddProductService(ProductRepository database) {
        this.database = database;
    }

    public void add(String title,
                    String description) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);

        database.save(product);
    }

}
