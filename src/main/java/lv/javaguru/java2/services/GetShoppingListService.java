package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.database.ProductRepository;

import java.util.List;

public class GetShoppingListService {
    
    private ProductRepository database;

    public GetShoppingListService(ProductRepository database) {
        this.database = database;
    }
    
    public List<Product> getAllProducts() {
        return database.getAll();
    }
    
}
