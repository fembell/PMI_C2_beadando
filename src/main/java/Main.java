import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int menu = -1;

        while(menu != 0) {
            System.out.println("");
            String Title = "INVENTORY FINDER";
            System.out.printf("%94s\n",Title);
            String Q="WHAT WOULD YOU LIKE TO DO?\n";
            String rlines = "----------------------------";
            System.out.printf("%100s\n",rlines);
            System.out.printf("%100s\n", Q);
            System.out.println(String.format("%75s %24s" , "[1]", "List items" ));
            System.out.println(String.format("%75s %24s" , "[2]", "Add new item" ));
            System.out.println(String.format("%75s %24s" , "[3]", "Remove item" ));
            System.out.println(String.format("%75s %24s" , "[4]", "Save inventory" ));
            System.out.println(String.format("%75s %24s" , "[5]", "Remove inventory" ));
            System.out.println(String.format("%75s %24s" , "[0]", "Exit" ));


            menu = sc.nextInt();
            switch (menu) {
                case 1: listItems(); break;
                case 2: addNewItem(); break;
                case 3: removeItem(); break;
                case 4: Write.saveInventory(); break;
                case 5: Read.loadInventory(); break;
                case 0: break;
            }
        }
    }

    /**
     * Prints out all existing items, and allows the user to modify them.
     */
    public static void listItems() {
        ArrayList<Product> getList;
        getList = Inventory.getList();
        System.out.printf("Name\tCategory\tPrice\tQuantity\n");
        for (int i = 0; i < getList.size(); i++){
            Object[] data = getList.get(i).getProductData();
            String output = data[0].toString()+"\t"+data[1]+"\t"+data[2].toString()+"\t\t"+data[3].toString();
            System.out.println(output);
        }
        System.out.println("Press any button to continue or 'm' to modify!");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        if (Objects.equals(x, "m")){
            System.out.println("Which product would you like to modify?");
            sc.nextLine();
            String toBeModded = sc.nextLine();
            System.out.println("What is the desired new name?");
            String moddedName = sc.nextLine();
            System.out.println("What is the desired new category?");
            String moddedCategory = sc.nextLine();
            System.out.println("What is the desired new price?");
            Integer moddedPrice = sc.nextInt();
            System.out.println("What is the desire new quantity?");
            Integer moddedQuantity = sc.nextInt();
            Inventory.updateProduct(toBeModded,new Product(moddedName,moddedCategory,moddedPrice,moddedQuantity));
            System.out.println("The product has been successfully modified.");
            System.out.println("Please press any button");
            sc.nextLine();
        }
    }

    /**
     * Adds a new item to the inventory.
     */
    public static void addNewItem() {
        //name, category, price, quantity
        System.out.println("Please enter the name of the product!");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Please name the category!");
        String category = sc.nextLine();
        System.out.println("Please enter the price!");
        Integer price = sc.nextInt();
        System.out.println("Please enter the quantity!");
        Integer quantity = sc.nextInt();
        Inventory.addProduct(name,category,price,quantity);
    }

    /**
     * Removes an item from the inventory.
     */
    public static void removeItem() {
        System.out.println("Please enter the name of the product you wish to remove!");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Inventory.removeProduct(name);
        System.out.println("The product was removed.");
        System.out.println("Press Enter to continue.");
        sc.nextLine();
    }


}
