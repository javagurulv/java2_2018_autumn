package lv.javaguru.java2.services.products.add;

import lv.javaguru.java2.services.ShoppingListError;

import java.util.List;

public class AddProductResponse {

    private Long productId;
    private List<ShoppingListError> errors;

    public AddProductResponse(Long productId) {
        this.productId = productId;
    }

    public AddProductResponse(List<ShoppingListError> errors) {
        this.errors = errors;
    }

    public Long getProductId() {
        return productId;
    }

    public List<ShoppingListError> getErrors() {
        return errors;
    }

    public boolean isSuccess() {
        return productId != null
                && (errors == null || errors.isEmpty()) ;
    }

}
