package lv.javaguru.java2.console.services;

import lv.javaguru.java2.console.database.jdbc.ProductRepositoryImpl;
import lv.javaguru.java2.console.domain.Product;

public class ProductRepositoryMock extends ProductRepositoryImpl {

    private boolean isProductSaved = false;

    @Override
    public void save(Product product) {
        isProductSaved = true;
    }

    public boolean isProductSaved() {
        return isProductSaved;
    }

}
