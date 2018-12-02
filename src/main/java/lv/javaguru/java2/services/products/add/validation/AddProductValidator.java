package lv.javaguru.java2.services.products.add.validation;

import lv.javaguru.java2.services.ShoppingListError;
import lv.javaguru.java2.services.products.add.AddProductRequest;

import java.util.List;

public interface AddProductValidator {

    List<ShoppingListError> validate(AddProductRequest request);

}
