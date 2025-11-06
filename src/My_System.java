import java.util.ArrayList;
import java.util.Scanner;

public class My_System {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_WHITE_BG = "\u001B[47m";

    Scanner scanner = new Scanner(System.in);

    private ArrayList<Integer> product_id = new ArrayList<>();
    private ArrayList<String> product_name = new ArrayList<>();
    private ArrayList<Integer> product_quantity = new ArrayList<>();
    private ArrayList<Double> product_price = new ArrayList<>();

    void add_product() {
        System.out.println("\n" + ANSI_YELLOW + "========================================");
        System.out.println("            Add a Product");
        System.out.println("========================================" + ANSI_RESET);

        System.out.print("\nEnter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product Price: $");
        Double price = scanner.nextDouble();

        product_id.add(id);
        product_name.add(name);
        product_quantity.add(quantity);
        product_price.add(price);

        System.out.println(ANSI_GREEN + "\nAdded Successfuly...");
    }

    void update_stock() {

        if (product_id.isEmpty()) {
            System.out.println(ANSI_RED + "\nNo Product in Inventory" + ANSI_RESET);
        } 
        else {
            System.out.println("\n" + ANSI_YELLOW + "========================================");
            System.out.println("            Update Stock");
            System.out.println("========================================" + ANSI_RESET);
        }
        
    }

    void remove_product() {

        if (product_id.isEmpty()) {
            System.out.println(ANSI_RED + "\nNo Product in Inventory" + ANSI_RESET);
        }
        else {
            System.out.println("\n" + ANSI_YELLOW + "========================================");
            System.out.println("            Remove Product");
            System.out.println("========================================" + ANSI_RESET);
        }
        
    }

    void display_inventory() {

        if (product_id.isEmpty()) {
            System.out.println(ANSI_RED + "\nNo Product in Inventory" + ANSI_RESET);
        }
        else {
            System.out.println("\n" + ANSI_YELLOW + "========================================");
            System.out.println("                Inventory");
            System.out.println("========================================\n" + ANSI_RESET);

            for (int i = 0; i < product_id.size(); i++) {
                System.out.printf("Product [%d] ", i+1);
                System.out.printf("\n    Product ID: %d", product_id.get(i));
                System.out.printf("\n    Product Name: %s", product_name.get(i));
                System.out.printf("\n    Product Quantity: %d", product_quantity.get(i));
                System.out.printf("\n    Product Price: $ %,.2f", product_price.get(i));
                System.out.println();
            }

            System.out.println("\n" + ANSI_YELLOW + "========================================");
            System.out.println("            End of Inventory");
            System.out.println("========================================" + ANSI_RESET);
        }
    }
}
