package lv.javaguru.java2.console.database.orm;

import lv.javaguru.java2.console.database.ShoppingListRepository;
import lv.javaguru.java2.console.domain.ShoppingList;
import lv.javaguru.java2.console.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
class ShoppingListRepositoryImpl extends ORMRepository
        implements ShoppingListRepository {

    @Override
    public void save(ShoppingList shoppingList) {
        session().save(shoppingList);
    }

    @Override
    public Optional<ShoppingList> findByUserAndTitle(User user,
                                                     String title) {
        String query = "from ShoppingList sl where sl.title = :title and sl.user = :user";
        ShoppingList shoppingList = (ShoppingList) session().createQuery(query)
                .setParameter("title", title)
                .setParameter("user", user)
                .uniqueResult();
        return Optional.ofNullable(shoppingList);
    }

}