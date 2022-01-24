package com.example;

import java.io.FileNotFoundException;


public class CartSystem extends TheSystem {
    CartSystem() throws FileNotFoundException {
        super();

    }

    @Override
    public void display() {
        double subTotal = 0.0;
        double preTaxTotal = 0.0;
        double tax = 0.0;
        double total = 0.0;

        String name = "Name";
        String description = "Description";
        String price = "Price";
        String quantity = "Quantity";

        System.out.println("Cart: ");
        System.out.printf("%-20s %-20s %-10s %-10s %-10s \n", name, description, price, quantity, subTotal);

        for (Item item: getItemCollection().values()) {
            subTotal = item.getItemPrice() * item.getQuantity();
            System.out.printf("%-20s %-20s %-10.2f %-10d \n", item.getItemName(), item.getItemDesc(), item.getItemPrice(), subTotal);
    }
        preTaxTotal +=subTotal;
        tax = subTotal * 0.05;
        total = subTotal + tax;
        
        System.out.printf("%-20s %-20.2f%n", "Pre-tax Total", preTaxTotal);
        System.out.printf("%-20s %-20.2f%n", "Tax", tax);
        System.out.printf("%-20s %-20.2f%n", "Total", total);
        System.out.println();
    }
}
