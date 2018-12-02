package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.ProductRepository;
import lv.javaguru.java2.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ProductRepositoryImpl extends ORMRepository
        implements ProductRepository {

    @Override
    public void save(Product product) {
        session().save(product);
    }

    @Override
    public Optional<Product> findByTitle(String title) {
        String query = "from Product p where p.title = :title";
        Product product = (Product) session().createQuery(query)
                .setParameter("title", title)
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public boolean remove(Product product) {
        session().delete(product);
        return true;
    }

    @Override
    public List<Product> getAll() {
        String query = "from Product p";
        return session().createQuery(query).list();
    }

}
