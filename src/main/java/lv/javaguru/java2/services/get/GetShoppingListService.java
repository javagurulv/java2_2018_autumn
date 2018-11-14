package lv.javaguru.java2.services.get;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.database.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetShoppingListService {
    
    private ProductRepository database;

    public GetShoppingListService(ProductRepository database) {
        this.database = database;
    }
    
    public List<Product> getAllProducts() {
        return database.getAll();
    }
    
}
