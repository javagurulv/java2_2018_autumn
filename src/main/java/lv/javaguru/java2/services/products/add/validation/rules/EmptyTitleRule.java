package lv.javaguru.java2.services.products.add.validation.rules;

import lv.javaguru.java2.services.ShoppingListError;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmptyTitleRule {

    public Optional<ShoppingListError> execute(String title) {
        if (title == null || title.isEmpty()) {
            ShoppingListError error = new ShoppingListError("title", "Empty title not allowed");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }

}
