package lv.javaguru.java2.services.products.add.validation.rules;

import lv.javaguru.java2.database.ProductRepository;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.services.ShoppingListError;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DuplicateProductTitleRule {

    private ProductRepository repository;

    public DuplicateProductTitleRule(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<ShoppingListError> execute(String title) {
        if (title != null) {
            Optional<Product> product = repository.findByTitle(title);
            if (product.isPresent()) {
                ShoppingListError error = new ShoppingListError("title", "Duplicate title not allowed");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }

}
