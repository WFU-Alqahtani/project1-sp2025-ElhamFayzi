//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static Item[] setupStore() {
        Item[] store = new Item[5];
        store[0] = new Item("item1", 1);
        store[1] = new Item("item2", 2);
        store[2] = new Item("item3", 3);
        store[3] = new Item("item4", 4);
        store[4] = new Item("item5", 5);
        return store;
    }

    public static ArrayList<Item> createCart (String[] args, Item[] store) {
        ArrayList<Item> cart = new ArrayList<Item>();

        try {
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                cart.add(store[Integer.parseInt(args[i]) + 1]);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }


        return cart;
    }

    public static void printReceiptInOrder (ArrayList<Item> cart) {
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

    public static void emptyCartReverseOrder (ArrayList<Item> cart) {
        System.out.println("Removing all items from the cart using in \"Last In First Out\" order...");
        for (int i = cart.size() - 1; i >= 0; i--) {
            System.out.println("Removing " + cart.get(i));
        }
    }

    public static void main(String[] args) {
        Item[] listOfItems = setupStore();
        ArrayList<Item> cart = createCart(args, listOfItems);
        printReceiptInOrder(cart);
        System.out.println("fix me!");
    }
}