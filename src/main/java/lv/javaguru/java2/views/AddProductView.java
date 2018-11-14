package lv.javaguru.java2.views;

import lv.javaguru.java2.services.add.AddProductRequest;
import lv.javaguru.java2.services.add.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddProductView {

    @Autowired
    private AddProductService addProductService;

    public void execute() {
        System.out.println();
        System.out.println("Add product to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        String title = sc.nextLine();
        System.out.print("Enter product description:");
        String description = sc.nextLine();

        AddProductRequest request = new AddProductRequest(title, description);
        addProductService.add(request);

        System.out.println("Add product to list execution end!");
        System.out.println();
    }

}
