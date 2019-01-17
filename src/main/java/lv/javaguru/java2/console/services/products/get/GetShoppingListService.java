package lv.javaguru.java2.console.services.products.get;

import lv.javaguru.java2.console.domain.Product;
import lv.javaguru.java2.console.database.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetShoppingListService {
    
    private ProductRepository database;

    public GetShoppingListService(ProductRepository database) {
        this.database = database;
    }
    
    public List<Product> getAllProducts() {
        return database.findAll();
    }
    
}
