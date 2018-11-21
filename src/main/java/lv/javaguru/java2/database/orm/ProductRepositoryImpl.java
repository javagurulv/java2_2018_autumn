package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.ProductRepository;
import lv.javaguru.java2.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public Optional<Product> findByTitle(String title) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("title", title))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public boolean remove(Product product) {
        sessionFactory.getCurrentSession().delete(product);
        return true;
    }

    @Override
    public List<Product> getAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Product.class)
                .list();
    }

}
