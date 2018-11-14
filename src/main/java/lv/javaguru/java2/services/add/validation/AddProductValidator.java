package lv.javaguru.java2.services.add.validation;

import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.add.AddProductRequest;

import java.util.List;

public interface AddProductValidator {

    List<Error> validate(AddProductRequest request);

}
