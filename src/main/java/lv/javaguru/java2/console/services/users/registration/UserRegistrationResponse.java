package lv.javaguru.java2.console.services.users.registration;

import lv.javaguru.java2.console.services.ShoppingListError;

import java.util.List;

public class UserRegistrationResponse {

    private Long userId;
    private List<ShoppingListError> errors;

    public UserRegistrationResponse(Long userId) {
        this.userId = userId;
    }

    public UserRegistrationResponse(List<ShoppingListError> errors) {
        this.errors = errors;
    }

    public Long getUserId() {
        return userId;
    }

    public List<ShoppingListError> getErrors() {
        return errors;
    }

    public boolean isSuccess() {
        return userId != null
                && (errors == null || errors.isEmpty()) ;
    }

}