package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.ShoppingList;
import lv.javaguru.java2.console.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from ShoppingList sl where sl.user = :user")
    List<ShoppingList> findShoppingListsByUser(User user);

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long userId);

}