package lv.javaguru.java2.console.services.users.get;

import lv.javaguru.java2.console.database.UserRepository;
import lv.javaguru.java2.console.services.ShoppingListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
class GetUserServiceImpl implements GetUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public GetUserResponse get(GetUserRequest request) {
        return userRepository.findById(request.getUserId())
                .map(GetUserResponse::new)
                .orElseGet(this::buildUserNotFoundResponse);
    }

    private GetUserResponse buildUserNotFoundResponse() {
        ShoppingListError error = new ShoppingListError("id", "not found");
        return new GetUserResponse(error);
    }

}