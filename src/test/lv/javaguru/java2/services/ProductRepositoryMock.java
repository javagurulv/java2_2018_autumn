package lv.javaguru.java2.services;

import lv.javaguru.java2.database.jdbc.ProductRepositoryImpl;
import lv.javaguru.java2.domain.Product;

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
