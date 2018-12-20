package lv.javaguru.java2.console.services.products.add.validation;

import lv.javaguru.java2.console.services.ShoppingListError;
import lv.javaguru.java2.console.services.products.add.AddProductRequest;

import java.util.List;

public interface AddProductValidator {

    List<ShoppingListError> validate(AddProductRequest request);

}
