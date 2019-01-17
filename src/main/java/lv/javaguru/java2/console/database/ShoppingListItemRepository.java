package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.ShoppingListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItem, Long> {

}