package lv.javaguru.java2.console.views;

import lv.javaguru.java2.console.services.products.get.GetShoppingListService;
import lv.javaguru.java2.console.domain.Product;
import org.springframework.stereotype.Component;

@Component
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
