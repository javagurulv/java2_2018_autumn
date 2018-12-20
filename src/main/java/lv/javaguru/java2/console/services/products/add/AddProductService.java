package lv.javaguru.java2.console.services.products.add;

import lv.javaguru.java2.console.database.ProductRepository;
import lv.javaguru.java2.console.domain.Product;
import lv.javaguru.java2.console.services.ShoppingListError;
import lv.javaguru.java2.console.services.products.add.validation.AddProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private AddProductValidator validator;


    public AddProductResponse add(AddProductRequest request) {
        List<ShoppingListError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddProductResponse(errors);
        }

        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());

        repository.save(product);

        return new AddProductResponse(product.getId());
    }

}
