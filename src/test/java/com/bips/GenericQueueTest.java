package com.bips;

import static org.junit.Assert.*;

import com.google.common.collect.Ordering;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by ahadcse on 07/04/16.
 */
public class GenericQueueTest<T> {

    private GenericQueue genericQueue;

    @Before
    public void init() {
        genericQueue = new GenericQueue();
    }

    @Test
    public void testQueueInsert() {
        genericQueue.enQueue("Ahad");
        assertEquals(genericQueue.deQueue(), "Ahad");
    }

    @Test
    public  void testSearchQueue() {
        genericQueue.enQueue('C');
        assertEquals(genericQueue.searchQueue('C'), 'C');
        assertEquals(genericQueue.searchQueue('A'), null);
    }

    @Test
    public void testQueueEmpty() {
        genericQueue.enQueue(1);
        genericQueue.deQueue();
        assertEquals(genericQueue.isEmpty(), true);
    }

    @Test
    public void testCountOccurrences() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Bart");
        list.add("Bart");
        list.add("Barney");
        assertEquals(genericQueue.countOccurrences(list, "Bart"), 2);
        assertEquals(genericQueue.countOccurrences(list, "Barney"), 1);
        assertEquals(genericQueue.countOccurrences(list, "Ahad"), 0);
    }

    @Test
    public void testOccurrenceInLinkedList() {
        genericQueue.enQueue("Ahad");
        genericQueue.enQueue(1);
        genericQueue.enQueue(1);
        genericQueue.enQueue('C');
        genericQueue.enQueue('C');
        genericQueue.enQueue('C');
        assertEquals(genericQueue.countOccurrenceInLinkedList("Ahad"), 1);
        assertEquals(genericQueue.countOccurrenceInLinkedList(1), 2);
        assertEquals(genericQueue.countOccurrenceInLinkedList('C'), 3);
        assertEquals(genericQueue.countOccurrenceInLinkedList('D'), 0);
    }

    @Test
    public void testAddAllItemsFromCollectionToEndOfQueue() {
        genericQueue.enQueue("Ahad");
        List<String> testStrings = Arrays.asList("sup1", "sup2", "sup3");
        Set<Integer> testNumbers = new HashSet<>();
        testNumbers.add(1);
        testNumbers.add(2);

        genericQueue.addAllItemsFromCollectionToEndOfQueue(testStrings);
        genericQueue.addAllItemsFromCollectionToEndOfQueue(testNumbers);

        assertEquals(genericQueue.deQueue(), "Ahad");
        assertEquals(genericQueue.deQueue(), "sup1");
        assertEquals(genericQueue.deQueue(), "sup2");
        assertEquals(genericQueue.deQueue(), "sup3");
        assertEquals(genericQueue.deQueue(), 1);
        assertEquals(genericQueue.deQueue(), 2);
    }

    @Test
    public void testAddAllFromQueueToCollection() {
        genericQueue.enQueue(1);
        genericQueue.enQueue(2);
        Set<Integer> testNumbers = new HashSet<>();
        genericQueue.addAllFromQueueToCollection(testNumbers);
        assertEquals(testNumbers.size(), 2);
        assertEquals(testNumbers.contains(1), true);
        assertEquals(testNumbers.contains(2), true);
        List<String> testStrings = Arrays.asList("sup1", "sup2", "sup3");
        genericQueue.addAllFromQueueToCollection(testStrings);
        assertEquals(testStrings.size(), 3);
        assertEquals(testStrings.contains("sup1"), true);
        assertEquals(testStrings.contains("sup2"), true);
        assertEquals(testStrings.contains("sup3"), true);
    }

    @Test
    public void testSortedInsert() {
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(1);
        testNumbers.add(2);
        testNumbers.add(5);
        genericQueue.sortedInsert(testNumbers, 4);
        assertEquals(Ordering.natural().isOrdered(testNumbers), true);

        List<String> testStrings = new ArrayList<>();
        testStrings.add("sup1");
        testStrings.add("sup3");
        genericQueue.sortedInsert(testStrings, "sup2");
        assertEquals(Ordering.natural().isOrdered(testStrings), true);
    }

    @After
    public void destroy() {
        genericQueue = null;
    }
}
