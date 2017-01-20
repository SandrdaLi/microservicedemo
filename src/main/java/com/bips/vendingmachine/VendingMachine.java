package com.bips.vendingmachine;

import java.util.ArrayList;
import java.util.List;

class VendingMachine {

    private static final List<Item> items = new ArrayList<>();
    private double changeFromLastPurchase = 0;

    VendingMachine() {
    }

    static List<Item> loadItem() {
        Item item1 = new Item("cookie", 5.0);
        Item item2 = new Item("gum", 3.00);
        Item item3 = new Item("coffee", 2.5);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        return items;
    }

    void addItem(Item item) {
        items.add(item);
    }

    void getItemInfo() {
        for(Item item : items) {
            System.out.println(item.toString());
        }
    }

    boolean buyItem(String whichItem, double payment) { //Add error code
        resetLastPurchaseChange();
        Item itemIfExists = getItemIfExists(whichItem);
        if (itemIfExists != null) {
            if (paymentIsEnough(itemIfExists, payment)) {
                dispense(itemIfExists);
                calculateChange(itemIfExists, payment);
                return true;
            }
        }
        return false;
    }

    double getChange() {
        return changeFromLastPurchase;
    }

    private void calculateChange(Item item, double payment) {
        changeFromLastPurchase =  payment - item.getPrice();
    }

    private boolean paymentIsEnough(Item item, double payment) {
        return payment >= item.getPrice();
    }

    private Item getItemIfExists(String whichItem) {
        for (Item item : items) {
            if (whichItem.equalsIgnoreCase(item.getName())) {
                return item;
            }
        }
        return null;
    }

    private void dispense(Item item) {
        System.out.println("Processing item: " + item.getName());
    }

    private void resetLastPurchaseChange() {
        changeFromLastPurchase = 0;
    }
}
