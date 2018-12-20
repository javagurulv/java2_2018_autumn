package lv.javaguru.java2.console.services.users.registration;

import lv.javaguru.java2.console.services.ShoppingListError;

import java.util.List;

public interface UserRegistrationValidator {

    List<ShoppingListError> validate(UserRegistrationRequest request);

}