package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.ShoppingList;
import lv.javaguru.java2.console.domain.ShoppingListItem;
import lv.javaguru.java2.console.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    Optional<ShoppingList> findByUserAndTitle(User user, String title);

}