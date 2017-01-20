package com.bips.vendingmachine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTest {

    private static final double DELTA = 1e-15;
    private List<Item> items = new ArrayList<>();

    @Before
    public void setUp() {
        items = VendingMachine.loadItem();
    }

    @Test
    public void addItem() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        Item testItem = new Item("Lunchbox", 8.3);
        vendingMachine.addItem(testItem);
        assertTrue(items.contains(testItem));
    }

    @Test
    public void buyItemSuccessful() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(vendingMachine.buyItem("cookie", 5));
    }

    @Test
    public void buyItemFailNotAvailable() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        assertFalse(vendingMachine.buyItem("cookie1", 5));
    }

    @Test
    public void buyItemFailPaymentNotEnough() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        assertFalse(vendingMachine.buyItem("cookie", 4.5));
    }

    @Test
    public void getChange() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.buyItem("gum", 4.5);
        assertEquals(vendingMachine.getChange(), 1.5, DELTA);
    }

    @After
    public void destroy() {
        items.clear();
    }

}