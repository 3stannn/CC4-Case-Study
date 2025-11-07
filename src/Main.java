import java.util.Scanner;

public class Main {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_WHITE_BG = "\u001B[47m";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        My_System sys = new My_System();

        boolean is_running = true;

        System.out.println("\nWelcome to our " + ANSI_WHITE_BG + "Inventory Tracker System" + ANSI_RESET);

        while (is_running) {
            System.out.println("\n" + ANSI_GREEN + "[1]"+ ANSI_RESET+ " Add Product");
            System.out.println(ANSI_GREEN + "[2]"+ ANSI_RESET+ " Update Stock");
            System.out.println(ANSI_GREEN + "[3]"+ ANSI_RESET+ " Romove Product");
            System.out.println(ANSI_GREEN + "[4]"+ ANSI_RESET+ " Display Inventory");
            System.out.println(ANSI_RED + "[5]"+ ANSI_RESET+ " Exit");

            System.out.print("\nEnter your choice (1 - 5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sys.add_product();
                    break;
                case 2:
                    sys.update_stock();
                    break;
                case 3:
                    sys.remove_product();
                    break;
                case 4:
                    sys.display_inventory();
                    break;
                case 5:
                    System.out.println(ANSI_YELLOW + "\nThank you! Have a Great Day!\n" + ANSI_RESET);
                    is_running = false;
                    break;
                default:
                    System.out.println(ANSI_RED + "\nInvalid choice! Please Try Again..." + ANSI_RESET);
            }
        }
        scanner.close();
    }
}