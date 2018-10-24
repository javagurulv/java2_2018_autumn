package lv.javaguru.java2.views;

import lv.javaguru.java2.services.AddProductService;

import java.util.Scanner;

public class AddProductView {

    private AddProductService addProductService;

    public AddProductView(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    public void execute() {
        System.out.println();
        System.out.println("Add product to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        String title = sc.nextLine();
        System.out.print("Enter product description:");
        String description = sc.nextLine();

        addProductService.add(title, description);

        System.out.println("Add product to list execution end!");
        System.out.println();
    }

}
