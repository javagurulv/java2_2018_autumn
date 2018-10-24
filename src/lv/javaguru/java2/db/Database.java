package lv.javaguru.java2.db;

import lv.javaguru.java2.domain.Product;

import java.util.List;
import java.util.Optional;

public interface Database {

    void addProduct(Product product);

    Optional<Product> findProductByTitle(String title);

    boolean deleteProduct(Product product);
    
    List<Product> getAllProducts();
    
}
