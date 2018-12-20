package lv.javaguru.java2.console.services.products.add.validation.rules;

import lv.javaguru.java2.console.database.ProductRepository;
import lv.javaguru.java2.console.domain.Product;
import lv.javaguru.java2.console.services.ShoppingListError;
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
