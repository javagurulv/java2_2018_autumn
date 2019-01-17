package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByTitle(String title);

}
