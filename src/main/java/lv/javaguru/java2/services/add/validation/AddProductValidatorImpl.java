package lv.javaguru.java2.services.add.validation;

import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.add.AddProductRequest;
import lv.javaguru.java2.services.add.validation.rules.DuplicateProductTitleRule;
import lv.javaguru.java2.services.add.validation.rules.EmptyTitleRule;
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
    public List<Error> validate(AddProductRequest request) {
        List<Error> errors = new ArrayList<>();

        emptyTitleRule.execute(request.getTitle()).ifPresent(errors::add);
/*
        emptyTitleRule.execute(request.getTitle()).ifPresent(new Consumer<Error>() {
            @Override
            public void accept(Error error) {
                errors.add(error);
            }
        });
*/

        /*Optional<Error> errorOpt = emptyTitleRule.execute(request.getTitle());
        if (errorOpt.isPresent()) {
            Error error = errorOpt.get();
            errors.add(error);
        }
        */

        duplicateProductTitleRule.execute(request.getTitle()).ifPresent(errors::add);

        return errors;
    }

}
