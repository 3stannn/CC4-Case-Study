import java.util.ArrayList;
import java.util.InputMismatchException;
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
        
        while (true) {
            System.out.print("\nEnter product ID: ");
            try{
                int id = scanner.nextInt();

                if (product_id.contains(id)) {
                    System.out.println(ANSI_RED + "\nDuplicate ID Found!" + ANSI_RESET);
                } else {
                    scanner.nextLine();
                    System.out.print("Enter product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product Price: $");
                    Double price = scanner.nextDouble();
                    scanner.nextLine();
                    
                    product_id.add(id);
                    product_name.add(name);
                    product_quantity.add(quantity);
                    product_price.add(price);

                    System.out.println(ANSI_GREEN + "\nAdded Successfuly..." + ANSI_RESET);
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(ANSI_RED + "\nInavlid Input. Try Again!" + ANSI_RESET);
                continue;
            }
        }
    }

    void update_stock() {

        if (product_id.isEmpty()) {
            System.out.println(ANSI_RED + "\nNo Product in Inventory" + ANSI_RESET);
        } 
        else {
            System.out.println("\n" + ANSI_YELLOW + "========================================");
            System.out.println("            Update Stock");
            System.out.println("========================================" + ANSI_RESET);
            while (true) {
                System.out.print("\nEnter Product ID: ");
                try {
                    int id = scanner.nextInt();

                    if (product_id.contains(id)) {
                        int index = product_id.indexOf(id);

                        System.out.println(ANSI_GREEN + "\nProduct with ID: " + id + " Found." + ANSI_RESET);

                        System.out.printf("\n" + ANSI_YELLOW + "Product Name:%s %s", ANSI_RESET, product_name.get(index));
                        System.out.printf("\n" + ANSI_YELLOW + "Product Quantity:%s %d", ANSI_RESET, product_quantity.get(index));
                        System.out.printf("\n" + ANSI_YELLOW + "Product Price:%s $ %,.2f", ANSI_RESET, product_price.get(index));
                        System.out.println();

                        System.out.println("\n" + ANSI_GREEN + "[1]"+ ANSI_RESET+ " Product ID");
                        System.out.println(ANSI_GREEN + "[2]"+ ANSI_RESET+ " Product Name");
                        System.out.println(ANSI_GREEN + "[3]"+ ANSI_RESET+ " Product Quantity");
                        System.out.println(ANSI_GREEN + "[4]"+ ANSI_RESET+ " Product Price");
                        System.out.println(ANSI_GREEN + "[5]"+ ANSI_RESET+ " All");


                        System.out.print("\nEnter your choice (1-5): ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                System.out.print("\nEnter new product ID: ");
                                int new_id = scanner.nextInt();
                                scanner.nextLine();

                                if (product_id.contains(new_id) && product_id.indexOf(new_id) != index) {
                                    System.out.println(ANSI_RED + "\nDuplicate ID Found!" + ANSI_RESET);
                                } else {
                                    product_id.set(index, new_id);
                                    System.out.println(ANSI_GREEN + "\nProduct ID Updated Successfuly...");
                                }
                                break;
                            case 2:
                                System.out.print("Enter new Product Name: ");
                                String name = scanner.nextLine();

                                product_name.set(index, name);
                                System.out.println(ANSI_GREEN + "\nProduct Name Updated Successfuly...");
                                break;
                            case 3:
                                System.out.print("Enter new Product Quantity: ");
                                int quantity = scanner.nextInt();

                                product_quantity.set(index, quantity);
                                System.out.println(ANSI_GREEN + "\nProduct Quantity Updated Successfuly...");
                                break;
                            case 4:
                                System.out.print("Enter new Product Quantity: ");
                                Double price = scanner.nextDouble();

                                product_price.set(index, price);
                                System.out.println(ANSI_GREEN + "\nProduct Price Updated Successfuly...");
                                break;
                            case 5:
                                System.out.print("\nEnter new product ID: ");
                                int allnew_id = scanner.nextInt();
                                scanner.nextLine();

                                if (product_id.contains(allnew_id) && product_id.indexOf(allnew_id) != index) {
                                    System.out.println(ANSI_RED + "\nDuplicate ID Found!" + ANSI_RESET);
                                } else {
                                    System.out.print("Enter new Product Name: ");
                                    String allname = scanner.nextLine();
                                    System.out.print("Enter new Product Quantity: ");
                                    int allquantity = scanner.nextInt();
                                    System.out.print("Enter new Product Price: ");
                                    Double allprice = scanner.nextDouble();

                                    product_id.set(index, allnew_id);
                                    product_name.set(index, allname);
                                    product_quantity.set(index, allquantity);
                                    product_price.set(index, allprice);

                                    System.out.println(ANSI_GREEN + "\nProduct Updated Successfuly..." + ANSI_RESET);
                                }
                                break;
                            default:
                                System.out.println(ANSI_RED + "\nInvalid choice! Please Try Again..." + ANSI_RESET);
                        }
                    } else {
                        System.out.println(ANSI_RED + "\nNo such ID Found!" + ANSI_RESET);
                    }
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println(ANSI_RED + "\nInavlid Input. Try Again!" + ANSI_RESET);
                    continue;
                }
            }
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
            while (true) {
                System.out.print("\nEnter Product ID: ");
                try {
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (product_id.contains(id)) {
                        int index = product_id.indexOf(id);

                        product_id.remove(index);
                        product_name.remove(index);
                        product_quantity.remove(index);
                        product_price.remove(index);

                        System.out.println(ANSI_GREEN + "\nProduct Removed Successfuly..." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "\nNo such ID Found!" + ANSI_RESET);
                    }   
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println(ANSI_RED + "\nInavlid Input. Try Again!" + ANSI_RESET);
                    continue;
                }
            }
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
