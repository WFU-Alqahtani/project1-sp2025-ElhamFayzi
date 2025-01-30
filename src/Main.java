//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;

public class Main {
    public static Item[] setupStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Mechanical Keyboard", 80);
        store[1] = new Item("Wireless Mouse", 25);
        store[2] = new Item("External 500GB SSD", 50);
        store[3] = new Item("Bluetooth Speaker", 40);
        store[4] = new Item("Cooling Pad", 15);
        return store;
    }

    public static ArrayList<Item> createCart(String[] args, Item[] store) {
        ArrayList<Item> cart = new ArrayList<Item>();
        int i = 0;

        try {
            int n = (args.length == 0) ? 0 : Integer.parseInt(args[0]);

            if (args.length - 1 != n) {
                if (args.length - 1 < n) {
                    System.out.println("Not enough Input");
                }
                else {
                    for (i = n + 1; i < args.length; i++) {
                        System.out.println("The entered index \"" + args[i] + "\" is extra");
                    }
                }
            }

            for (i = 1; i < args.length; i++) {
                cart.add(store[Integer.parseInt(args[i])]);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The store does not have an item of index " + args[i]);              // FIXME: Improve the message that would print out + Add the index that is not accessible
        } catch (NumberFormatException e) {
            System.out.println("\"" + args[i] + "\" is not a valid integer");                   // FIXME: Improve the message
        }

        return cart;
    }

    public static void printReceiptInOrder(ArrayList<Item> cart) {
        double subTotal = 0;
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getItemName() + " --- " + cart.get(i).getItemPrice());
            subTotal += cart.get(i).getItemPrice();
        }
        System.out.println("____________________");
        System.out.println("Subtotal --- " + subTotal);

        double salesTax = subTotal * 0.05;
        System.out.printf("SalesTax --- %.2f", salesTax);

        double total = subTotal + salesTax;
        System.out.println("\nTotal --- " + total);

    }

    public static void emptyCartReverseOrder(ArrayList<Item> cart) {
        System.out.println("Removing all items from the cart using in \"Last In First Out\" order...");
        for (int i = cart.size() - 1; i >= 0; i--) {
            System.out.println("Removing " + cart.get(i));
        }
    }

    public static void main(String[] args) {
        Item[] listOfItems = setupStore();
        ArrayList<Item> cart = createCart(args, listOfItems);
        printReceiptInOrder(cart);
    }
}