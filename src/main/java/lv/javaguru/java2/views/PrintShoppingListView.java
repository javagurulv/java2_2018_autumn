package lv.javaguru.java2.views;

import lv.javaguru.java2.services.GetShoppingListService;
import lv.javaguru.java2.domain.Product;

public class PrintShoppingListView {

    private GetShoppingListService service;

    public PrintShoppingListView(GetShoppingListService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println();
        System.out.println("Print shopping list to console execution start!");
        
        for (Product product : service.getAllProducts()) {
            System.out.println(product.getTitle() + "[" + product.getDescription() + "]");
        }
        
        System.out.println("Print shopping list to console execution end!");
        System.out.println();
    }

}
