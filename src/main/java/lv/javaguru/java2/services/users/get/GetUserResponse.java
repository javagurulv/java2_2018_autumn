package lv.javaguru.java2.services.users.get;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ShoppingListError;

public class GetUserResponse {

    private User user;

    private ShoppingListError error;

    public GetUserResponse(User user) {
        this.user = user;
    }

    public GetUserResponse(ShoppingListError error) {
        this.error = error;
    }

    public User getUser() {
        return user;
    }

    public ShoppingListError getError() {
        return error;
    }

    public boolean isSuccess() {
        return user != null && (error == null) ;
    }

}
