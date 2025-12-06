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
        
        int id = 0;
        String name = "";
        int quantity = 0;
        double price = 0.0;
        boolean validInput = false;
        
        // Get Product ID with validation
        while (!validInput) {
            System.out.print("\nEnter product ID: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                
                if (product_id.contains(id)) {
                    System.out.println(ANSI_RED + "\nDuplicate ID Found! Please enter a unique ID." + ANSI_RESET);
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid integer!" + ANSI_RESET);
            }
        }
        
        // Get Product Name
        System.out.print("Enter product Name: ");
        name = scanner.nextLine();
        
        // Get Product Quantity with validation
        validInput = false;
        while (!validInput) {
            System.out.print("Enter product Quantity: ");
            try {
                quantity = scanner.nextInt();
                scanner.nextLine();
                if (quantity < 0) {
                    System.out.println(ANSI_RED + "\nQuantity cannot be negative!" + ANSI_RESET);
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid integer!" + ANSI_RESET);
            }
        }
        
        // Get Product Price with validation
        validInput = false;
        while (!validInput) {
            System.out.print("Enter product Price: $");
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price < 0) {
                    System.out.println(ANSI_RED + "\nPrice cannot be negative!" + ANSI_RESET);
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid number!" + ANSI_RESET);
            }
        }
        
        product_id.add(id);
        product_name.add(name);
        product_quantity.add(quantity);
        product_price.add(price);

        System.out.println(ANSI_GREEN + "\nAdded Successfully..." + ANSI_RESET);
    }

    void update_stock() {

        if (product_id.isEmpty()) {
            System.out.println(ANSI_RED + "\nNo Product in Inventory" + ANSI_RESET);
        } 
        else {
            System.out.println("\n" + ANSI_YELLOW + "========================================");
            System.out.println("            Update Stock");
            System.out.println("========================================" + ANSI_RESET);
            
            boolean continueUpdating = true;
            while (continueUpdating) {
                int id = 0;
                boolean validID = false;
                
                // Get Product ID with validation
                while (!validID) {
                    System.out.print("\nEnter Product ID (or -1 to go back): ");
                    try {
                        id = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (id == -1) {
                            continueUpdating = false;
                            validID = true;
                        } else if (product_id.contains(id)) {
                            validID = true;
                        } else {
                            System.out.println(ANSI_RED + "\nNo such ID Found!" + ANSI_RESET);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine();
                        System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid integer!" + ANSI_RESET);
                    }
                }
                
                if (!continueUpdating) break;
                
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

                int choice = 0;
                boolean validChoice = false;
                
                // Get choice with validation
                while (!validChoice) {
                    System.out.print("\nEnter your choice (1-5): ");
                    try {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (choice >= 1 && choice <= 5) {
                            validChoice = true;
                        } else {
                            System.out.println(ANSI_RED + "\nInvalid choice! Please enter a number between 1-5." + ANSI_RESET);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine();
                        System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid integer!" + ANSI_RESET);
                    }
                }

                switch (choice) {
                    case 1:
                        boolean validNewID = false;
                        while (!validNewID) {
                            System.out.print("\nEnter new product ID: ");
                            try {
                                int new_id = scanner.nextInt();
                                scanner.nextLine();

                                if (product_id.contains(new_id) && product_id.indexOf(new_id) != index) {
                                    System.out.println(ANSI_RED + "\nDuplicate ID Found! Please enter a unique ID." + ANSI_RESET);
                                } else {
                                    product_id.set(index, new_id);
                                    System.out.println(ANSI_GREEN + "\nProduct ID Updated Successfully..." + ANSI_RESET);
                                    validNewID = true;
                                }
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid integer!" + ANSI_RESET);
                            }
                        }
                        break;
                        
                    case 2:
                        System.out.print("Enter new Product Name: ");
                        String name = scanner.nextLine();
                        product_name.set(index, name);
                        System.out.println(ANSI_GREEN + "\nProduct Name Updated Successfully..." + ANSI_RESET);
                        break;
                        
                    case 3:
                        boolean validQuantity = false;
                        while (!validQuantity) {
                            System.out.print("Enter new Product Quantity: ");
                            try {
                                int quantity = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (quantity < 0) {
                                    System.out.println(ANSI_RED + "\nQuantity cannot be negative!" + ANSI_RESET);
                                } else {
                                    product_quantity.set(index, quantity);
                                    System.out.println(ANSI_GREEN + "\nProduct Quantity Updated Successfully..." + ANSI_RESET);
                                    validQuantity = true;
                                }
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid integer!" + ANSI_RESET);
                            }
                        }
                        break;
                        
                    case 4:
                        boolean validPrice = false;
                        while (!validPrice) {
                            System.out.print("Enter new Product Price: $");
                            try {
                                double price = scanner.nextDouble();
                                scanner.nextLine();
                                
                                if (price < 0) {
                                    System.out.println(ANSI_RED + "\nPrice cannot be negative!" + ANSI_RESET);
                                } else {
                                    product_price.set(index, price);
                                    System.out.println(ANSI_GREEN + "\nProduct Price Updated Successfully..." + ANSI_RESET);
                                    validPrice = true;
                                }
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid number!" + ANSI_RESET);
                            }
                        }
                        break;
                        
                    case 5:
                        // Update all fields with validation
                        boolean validAllNewID = false;
                        int allnew_id = 0;
                        while (!validAllNewID) {
                            System.out.print("\nEnter new product ID: ");
                            try {
                                allnew_id = scanner.nextInt();
                                scanner.nextLine();

                                if (product_id.contains(allnew_id) && product_id.indexOf(allnew_id) != index) {
                                    System.out.println(ANSI_RED + "\nDuplicate ID Found! Please enter a unique ID." + ANSI_RESET);
                                } else {
                                    validAllNewID = true;
                                }
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid integer!" + ANSI_RESET);
                            }
                        }
                        
                        System.out.print("Enter new Product Name: ");
                        String allname = scanner.nextLine();
                        
                        int allquantity = 0;
                        boolean validAllQuantity = false;
                        while (!validAllQuantity) {
                            System.out.print("Enter new Product Quantity: ");
                            try {
                                allquantity = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (allquantity < 0) {
                                    System.out.println(ANSI_RED + "\nQuantity cannot be negative!" + ANSI_RESET);
                                } else {
                                    validAllQuantity = true;
                                }
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid integer!" + ANSI_RESET);
                            }
                        }
                        
                        double allprice = 0.0;
                        boolean validAllPrice = false;
                        while (!validAllPrice) {
                            System.out.print("Enter new Product Price: $");
                            try {
                                allprice = scanner.nextDouble();
                                scanner.nextLine();
                                
                                if (allprice < 0) {
                                    System.out.println(ANSI_RED + "\nPrice cannot be negative!" + ANSI_RESET);
                                } else {
                                    validAllPrice = true;
                                }
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid number!" + ANSI_RESET);
                            }
                        }

                        product_id.set(index, allnew_id);
                        product_name.set(index, allname);
                        product_quantity.set(index, allquantity);
                        product_price.set(index, allprice);

                        System.out.println(ANSI_GREEN + "\nProduct Updated Successfully..." + ANSI_RESET);
                        break;
                }
                
                // Ask if user wants to update another product
                String continueChoice = "";
                boolean validContinue = false;
                while (!validContinue) {
                    System.out.print("\nDo you want to update another product? (y/n): ");
                    continueChoice = scanner.nextLine().toLowerCase();
                    
                    if (continueChoice.equals("y") || continueChoice.equals("n")) {
                        validContinue = true;
                    } else {
                        System.out.println(ANSI_RED + "Invalid input! Please enter 'y' or 'n'." + ANSI_RESET);
                    }
                }
                
                if (continueChoice.equals("n")) {
                    continueUpdating = false;
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
            
            boolean continueRemoving = true;
            while (continueRemoving) {
                int id = 0;
                boolean validID = false;
                
                while (!validID) {
                    System.out.print("\nEnter Product ID (or -1 to go back): ");
                    try {
                        id = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (id == -1) {
                            continueRemoving = false;
                            validID = true;
                        } else if (product_id.contains(id)) {
                            validID = true;
                        } else {
                            System.out.println(ANSI_RED + "\nNo such ID Found!" + ANSI_RESET);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine();
                        System.out.println(ANSI_RED + "\nInvalid Input. Please enter a valid integer!" + ANSI_RESET);
                    }
                }
                
                if (!continueRemoving) break;
                
                int index = product_id.indexOf(id);
                
                // Display product details before removal
                System.out.println(ANSI_YELLOW + "\nProduct Details:" + ANSI_RESET);
                System.out.printf("    Product Name: %s\n", product_name.get(index));
                System.out.printf("    Product Quantity: %d\n", product_quantity.get(index));
                System.out.printf("    Product Price: $%,.2f\n", product_price.get(index));
                
                // Confirm removal
                String confirm = "";
                boolean validConfirm = false;
                while (!validConfirm) {
                    System.out.print("\nAre you sure you want to remove this product? (y/n): ");
                    confirm = scanner.nextLine().toLowerCase();
                    
                    if (confirm.equals("y") || confirm.equals("n")) {
                        validConfirm = true;
                    } else {
                        System.out.println(ANSI_RED + "Invalid input! Please enter 'y' or 'n'." + ANSI_RESET);
                    }
                }
                
                if (confirm.equals("y")) {
                    product_id.remove(index);
                    product_name.remove(index);
                    product_quantity.remove(index);
                    product_price.remove(index);

                    System.out.println(ANSI_GREEN + "\nProduct Removed Successfully..." + ANSI_RESET);
                } else {
                    System.out.println(ANSI_YELLOW + "\nRemoval cancelled." + ANSI_RESET);
                }
                
                // Ask if user wants to remove another product
                if (product_id.isEmpty()) {
                    System.out.println(ANSI_YELLOW + "\nNo more products in inventory." + ANSI_RESET);
                    continueRemoving = false;
                } else {
                    String continueChoice = "";
                    boolean validContinue = false;
                    while (!validContinue) {
                        System.out.print("\nDo you want to remove another product? (y/n): ");
                        continueChoice = scanner.nextLine().toLowerCase();
                        
                        if (continueChoice.equals("y") || continueChoice.equals("n")) {
                            validContinue = true;
                        } else {
                            System.out.println(ANSI_RED + "Invalid input! Please enter 'y' or 'n'." + ANSI_RESET);
                        }
                    }
                    
                    if (continueChoice.equals("n")) {
                        continueRemoving = false;
                    }
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
