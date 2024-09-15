import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Light> product = new ArrayList<>();

        while (true) {
            displayMenu();
            int choice = getMenuChoice();
            boolean keepRunning = processChoice(choice, product);
            Scanner waitForEnter = new Scanner(System.in);
            System.out.println("Press enter to continue...");
            String input = waitForEnter.nextLine();

            // Pass product as an argument
            if (!keepRunning) {
                System.out.println("Good Bye!!");
                break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Welcome to Lighting Product Catalogue");
        System.out.println("Please enter your choice");
        System.out.println("1. Add new product");
        System.out.println("2. List all products");
        System.out.println("3. Edit product");
        System.out.println("4. Delete product");
        System.out.println("5. Quit!");
    }

    // Get the choice that the user has entered
    public static int getMenuChoice() {
        Scanner choice = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return choice.nextInt();
    }

    // Display the product that is in the ArrayList "product"
    public static void displayArray(ArrayList<Light>product){

        for (int i = 0; i < product.size(); i++) {
            System.out.print((i+1)+". Name: " + product.get(i).getName() + " ");
            System.out.print("Power: " + product.get(i).getPower() + " W ");
            System.out.print("Price: $" + product.get(i).getPrice() + " ");
            // Check the type of light and display additional information
            if (product.get(i) instanceof Downlight) {
                System.out.println("Mounting: " + ((Downlight) product.get(i)).getMounting() + " ");
                product.get(i).displayType();
            } else if (product.get(i) instanceof Floodlight) {
                System.out.println("Type: " + ((Floodlight) product.get(i)).getType() + " ");
                product.get(i).displayType();
            }


        }

    }

    // Create a new product and store in ArrayList "product"
    public static void createProduct(ArrayList<Light>product){
        Scanner sc = new Scanner(System.in); // Create a single Scanner instance

        System.out.println("Which type of product do you want to add?");
        System.out.println("Press D for Downlight and F for Floodlight");
        String selection = sc.nextLine();

        while (!selection.equalsIgnoreCase("D") && !selection.equalsIgnoreCase("F")) {
            System.out.println("Enter the type of product to create");
            System.out.println("D for Downlight or F for Floodlight");
            selection = sc.nextLine();
        }

        // Parent class data entry
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter power: ");
        int power = sc.nextInt();
        sc.nextLine(); // Consume the newline character left after nextInt()
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine(); // Consume the newline character left after nextDouble()

        // Create a placeholder and set it to empty
        Light newLight = null;

        // If product is Downlight
        if (selection.equalsIgnoreCase("D")) {
            System.out.print("Enter mounting: ");
            String mounting = sc.nextLine();
            newLight = new Downlight(name, power, price, mounting);
        }
        // If product is Floodlight
        else if (selection.equalsIgnoreCase("F")) {
            System.out.print("Enter type: ");
            String type = sc.nextLine();
            newLight = new Floodlight(name, power, price, type);
        }

        product.add(newLight);

    }

    // Delete the selected product from the ArrayList "product"
    public static void deleteProduct(ArrayList<Light>product) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please choose the product to delete: ");
        int selection = sc.nextInt();
        selection = selection - 1;
        product.remove(selection);
    }

    // Edit the selected product and enter new parameters in ArrayList "product"
    public static void editProduct(ArrayList<Light> product){
        displayArray(product);
        System.out.print("Please choose the product to edit: ");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        selection = selection - 1;
        Light productToEdit = product.get(selection);

        System.out.println("1. edit everything!");
        System.out.println("2. edit selected parameter");
        System.out.printf("What do you want to edit: ");
        int editPara = sc.nextInt();
        if(editPara == 1){
            productToEdit.edit();
        }
        if(editPara ==2){
            paraToEdit(productToEdit);
        }

    }

    public static void paraToEdit(Light productToEdit){
        Scanner sc = new Scanner(System.in);
        int editChoice = 0;
        String check = productToEdit.displayType();
        System.out.println("1. Name: "+productToEdit.getName());
        System.out.println("2. Power: "+productToEdit.getPower());
        System.out.println("3. Price: "+productToEdit.getPrice());
        if (productToEdit instanceof Downlight) {
            System.out.println("4. Mounting: " + ((Downlight) productToEdit).getMounting());
            System.out.println("choose which parameter to edit: ");
            editChoice = sc.nextInt();
            if(editChoice >0 && editChoice<4) {
                mainParaToEdit(editChoice, productToEdit);
            }
            else if(editChoice ==4){
                Scanner input = new Scanner(System.in);
                System.out.print("Enter new mounting: ");
                String newMounting = input.nextLine();
                System.out.println(newMounting);
                productToEdit.setMounting(newMounting);
            }


        }
        if (productToEdit instanceof Floodlight) {
            System.out.println("4. Type: " + ((Floodlight) productToEdit).getType());
            System.out.println("choose which parameter to edit: ");
            editChoice = sc.nextInt();
            if(editChoice >0 && editChoice<4) {
                mainParaToEdit(editChoice, productToEdit);
            }
            else if(editChoice ==4){
                Scanner input = new Scanner(System.in);
                System.out.print("Enter new type: ");
                String newType = input.nextLine();
                productToEdit.setType(newType);
            }
        }
    }

    public static void mainParaToEdit(int editChoice,Light productToEdit){
        Scanner sc = new Scanner(System.in);
        if(editChoice == 1){
            System.out.println("Enter new name: ");
            String newName = sc.nextLine();
            productToEdit.setName(newName);
        }
        if(editChoice == 2){
            System.out.println("Enter new power: ");
            int newPower = sc.nextInt();
            productToEdit.setPower(newPower);
        }
        if(editChoice == 3){
            System.out.println("Enter new price: ");
            double newPrice = sc.nextDouble();
            productToEdit.setPrice(newPrice);
        }


    }

    // Depending on the user has entered at the menu, do something
    // If return true, keep running the program
    // If return false, quit the program
    public static boolean processChoice(int choice, ArrayList<Light> product) {

        if (choice == 1) {
            createProduct(product);
            return true;}
        else if (choice == 2) {
            System.out.println("Listing all products:");
            displayArray(product);
            return true;
        }
        else if(choice ==3){
            System.out.println("edit");
            editProduct(product);
            return true;
        }
        else if(choice ==4){
            System.out.println("delete");
            displayArray(product);
            deleteProduct(product);
            return true;
        }
        else if (choice == 5) {
            return false;
        }
        else {
            // If the choice is not recognized, inform the user
            System.out.println("Invalid choice. Please try again.");
            return true; // Continue the process for invalid choices
        }


    }


}