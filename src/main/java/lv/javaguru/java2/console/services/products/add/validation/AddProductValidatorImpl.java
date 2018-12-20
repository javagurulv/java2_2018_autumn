package lv.javaguru.java2.console.services.products.add.validation;

import lv.javaguru.java2.console.services.ShoppingListError;
import lv.javaguru.java2.console.services.products.add.AddProductRequest;
import lv.javaguru.java2.console.services.products.add.validation.rules.DuplicateProductTitleRule;
import lv.javaguru.java2.console.services.products.add.validation.rules.EmptyTitleRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class AddProductValidatorImpl implements AddProductValidator {

    @Autowired
    private EmptyTitleRule emptyTitleRule;

    @Autowired
    private DuplicateProductTitleRule duplicateProductTitleRule;


    @Override
    public List<ShoppingListError> validate(AddProductRequest request) {
        List<ShoppingListError> errors = new ArrayList<>();

        emptyTitleRule.execute(request.getTitle()).ifPresent(errors::add);
/*
        emptyTitleRule.execute(request.getTitle()).ifPresent(new Consumer<ShoppingListError>() {
            @Override
            public void accept(ShoppingListError error) {
                errors.add(error);
            }
        });
*/

        /*Optional<ShoppingListError> errorOpt = emptyTitleRule.execute(request.getTitle());
        if (errorOpt.isPresent()) {
            ShoppingListError error = errorOpt.get();
            errors.add(error);
        }
        */

        duplicateProductTitleRule.execute(request.getTitle()).ifPresent(errors::add);

        return errors;
    }

}
