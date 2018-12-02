package lv.javaguru.java2.services.users.registration;

import lv.javaguru.java2.services.ShoppingListError;

import java.util.List;

public interface UserRegistrationValidator {

    List<ShoppingListError> validate(UserRegistrationRequest request);

}