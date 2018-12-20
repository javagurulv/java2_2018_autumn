package lv.javaguru.java2;

import lv.javaguru.java2.console.config.SpringAppConfig;
import lv.javaguru.java2.console.views.AddProductView;
import lv.javaguru.java2.console.views.PrintShoppingListView;
import lv.javaguru.java2.console.views.RemoveProductView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ShoppingListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add product to list
        // 2. Remove product from list
        // 3. Print shopping list to console
        // 4. Exit

        ApplicationContext context
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        AddProductView addProductView = context.getBean(AddProductView.class);
        RemoveProductView removeProductView = context.getBean(RemoveProductView.class);
        PrintShoppingListView printShoppingListView = context.getBean(PrintShoppingListView.class);

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            }
            switch (menuItem) {
                case 1: {
                    addProductView.execute();
                    break;
                }
                case 2: {
                    removeProductView.execute();
                    break;
                }
                case 3: {
                    printShoppingListView.execute();
                    break;
                }
            }
        }
    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add product to list");
        System.out.println("2. Remove product from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

}