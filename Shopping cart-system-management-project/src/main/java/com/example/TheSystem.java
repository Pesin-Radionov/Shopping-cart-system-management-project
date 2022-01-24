package com.example;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;



public abstract class TheSystem {
     private HashMap<String, Item> itemCollection;

    public TheSystem() throws FileNotFoundException {
        itemCollection = new HashMap<String, Item>();
        if (getClass ().getSimpleName().equals("AppSystem")) {
            try {
                FileReader fr = new FileReader("resources/sample.txt");
                BufferedReader br = new BufferedReader(fr);
                Item item;
                String line = br.readLine();
                while (line != null) {
                String[] itemInfo = line.split("  ");
                item = new Item();
                item.setItemName(itemInfo[0]);
                item.setItemDesc(itemInfo[1]);
                item.setItemPrice(Double.parseDouble(itemInfo[2]));
                item.setAvailableQuantity(Integer.parseInt(itemInfo[3]));
                itemCollection.put(item.getItemName(), item);
                line = br.readLine();

                }
            br.close();
        }// End of try block
        catch (IOException e) {
            System.out.println("Not able to read file.");
        }
        //End of catch block

    }
    }
      public HashMap<String, Item> getItemCollection() {
        return itemCollection;
      }
    public Boolean checkAvailability(Item item) {
        if (item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.println("System is unable to add " + item.getItemName() + "to the card. System only has "
                    + item.getAvailableQuantity() + item.getItemName() + "s");
            return false;
        } else
            return true;
    }

       public Boolean add(Item item) {
        if (item == null) {
            return false;

        } else if (itemCollection.containsKey(item.getItemName()))  {
            item.setQuantity(item.getQuantity() + 1);
            return true;

        } else if (!itemCollection.containsKey(item.getItemName())) {
            itemCollection.put(item.getItemName(), item);
            return true;
        } else {
            return false;
        }
    }

        public Item remove (String itemName){
            return this.itemCollection.remove(itemName);
        }

        public abstract void display ();
    
    }
