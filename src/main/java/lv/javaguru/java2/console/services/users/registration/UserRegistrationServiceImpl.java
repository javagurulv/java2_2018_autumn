package lv.javaguru.java2.console.services.users.registration;

import lv.javaguru.java2.console.database.UserRepository;
import lv.javaguru.java2.console.domain.User;
import lv.javaguru.java2.console.services.ShoppingListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired private UserRegistrationValidator validator;
    @Autowired private UserRepository userRepository;

    @Override
    @Transactional
    public UserRegistrationResponse register(UserRegistrationRequest request) {

        // validate login and password
        List<ShoppingListError> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            return new UserRegistrationResponse(validationErrors);
        }

        // create new user
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());

        // store to db
        userRepository.save(user);

        return new UserRegistrationResponse(user.getId());
    }

}