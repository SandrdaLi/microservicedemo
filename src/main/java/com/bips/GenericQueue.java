package com.bips;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ahadcse on 07/04/16.
 */
public class GenericQueue<T> {

    private LinkedList<T> linkedList = new LinkedList<T>();

    public void enQueue(T item) {
        linkedList.addLast(item);
    }

    public T deQueue() {
        return linkedList.removeFirst();
    }

    public T searchQueue(T item) {
        if (linkedList.contains(item))
            return item;
        return null;
    }

    public boolean isEmpty() {
        return (linkedList.size() == 0);
    }

    public int countOccurrenceInLinkedList(T itemToCount) {
        int count = 0;
        ListIterator<T> listIterator = linkedList.listIterator();
        if (itemToCount == null) {
            while (listIterator.hasNext()) {
                if (listIterator.next() == itemToCount)
                    count++;
            }
        } else {
            while (listIterator.hasNext()) {
                if (listIterator.next() == itemToCount)
                    count++;
            }
        }
        return count;
    }

    public static <T> int countOccurrences(Collection<T> collection, T itemToCount) {
        int count = 0;
        if (itemToCount == null) {
            for (T listItem : collection)
                if (listItem == null)
                    count++;
        } else {
            for (T listItem : collection)
                if (itemToCount.equals(listItem))
                    count++;
        }
        return count;
    }

    public void addAllItemsFromCollectionToEndOfQueue(Collection<? extends T> collection) {
        collection.forEach(item -> enQueue(item));
    }

    public void addAllFromQueueToCollection(Collection<? super T> collection) {
        while ( ! isEmpty() ) {
            T item = deQueue();
            collection.add( item );
        }
    }

    public <T extends Comparable> void sortedInsert(List<T> sortedList, T itemToInsert) {
        ListIterator<T> listIterator = sortedList.listIterator();
        while (listIterator.hasNext()) {
            T item = listIterator.next();
            if (itemToInsert.compareTo(item) <= 0) {
                listIterator.previous();
                break;
            }
        }
        listIterator.add(itemToInsert);
    }
}
