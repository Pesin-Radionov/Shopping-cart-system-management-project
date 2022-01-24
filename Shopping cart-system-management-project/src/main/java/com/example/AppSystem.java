package com.example;

import java.io.FileNotFoundException;

public class AppSystem extends TheSystem {
   AppSystem() throws FileNotFoundException {
       super();
    }

    @Override
    public void display() {
        String heading1 = "Name";
        String heading2 = "Description";
        String heading3 = "Price";
        String heading4 = "Available Quantity";

        System.out.println("AppSystemInventory:");
        System.out.printf("%-20s %-20s %-10s %10s \n", heading1, heading2, heading3, heading4);
        
        for (Item item: getItemCollection().values()) {
            System.out.printf("%-20s %-20s %-10.2f %10d \n", item.getItemName(), item.getItemDesc(), item.getItemPrice(), item.getAvailableQuantity());
        }
        
    }

    @Override // this overwrites the parents class add method
        public Boolean add(Item item) {
        if (item == null)
            return false;

        else if (getItemCollection().containsValue(item)) {
            System.out.println(item.getItemName() + "is already in the App System ");
            return false;
            
        }else {
            getItemCollection().put(item.getItemName(), item);
            return true;
        }


   }
       public Item reduceAvailableQuantity(String item_name) {
        if (getItemCollection().containsKey(item_name)) {
            getItemCollection().get(item_name).setAvailableQuantity(getItemCollection().get(item_name).getAvailableQuantity() - 1);
            return getItemCollection().get(item_name);
        } else
            return null;
    }
}
