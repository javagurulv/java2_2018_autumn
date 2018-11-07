package lv.javaguru.java2.services;

import lv.javaguru.java2.database.ProductRepository;
import lv.javaguru.java2.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class AddProductService {

    //@Autowired
    private ProductRepository repository;

    public AddProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(String title,
                    String description) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);

        repository.save(product);
    }

}
