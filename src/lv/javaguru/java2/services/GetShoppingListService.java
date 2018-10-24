package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.db.Database;

import java.util.List;

public class GetShoppingListService {
    
    private Database database;

    public GetShoppingListService(Database database) {
        this.database = database;
    }
    
    public List<Product> getAllProducts() {
        return database.getAllProducts();
    }
    
}
