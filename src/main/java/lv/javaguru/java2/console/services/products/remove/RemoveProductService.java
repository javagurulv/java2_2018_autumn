package lv.javaguru.java2.console.services.products.remove;

import lv.javaguru.java2.console.domain.Product;
import lv.javaguru.java2.console.database.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveProductService {

    private ProductRepository database;

    public RemoveProductService(ProductRepository database) {
        this.database = database;
    }

    public boolean remove(String title) {
        Optional<Product> foundProduct = database.findByTitle(title);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            database.delete(product);
            return true;
        } else {
            return false;
        }
    }

}
