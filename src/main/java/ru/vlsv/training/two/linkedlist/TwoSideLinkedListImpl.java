package ru.vlsv.training.two.linkedlist;


import ru.vlsv.training.two.linkedlist.entries.Entry;
import ru.vlsv.training.two.linkedlist.entries.EntryImpl;

public class TwoSideLinkedListImpl<E> extends LinkedListImpl<E> implements TwoSideLinlkedList<E> {

    private Entry<E> lastElement;

    @Override
    public void insertLeft(E value) {
        super.insert(value);
        if ( getSize() == 1 ) {
            lastElement = firstElement;
        }
    }

    @Override
    public void insertRight(E value) {
        Entry<E> newElement = new EntryImpl<>(value);
        if (isEmpty()) {
            firstElement = newElement;
        }
        else {
            lastElement.setNext(newElement);
        }

        lastElement = newElement;
        size++;
    }

    @Override
    public E removeLeft() {
        E removedValue = super.remove();
        if (isEmpty()) {
            lastElement = null;
        }
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> currentElement = firstElement;
        Entry<E> previousElement = null;
        while ( currentElement != null ) {
            if ( currentElement.getValue().equals(value) ) {
                break;
            }

            previousElement = currentElement;
            currentElement = currentElement.getNext();
        }

        if (currentElement == null) {
            return false;
        }

        if (currentElement == firstElement) {
            firstElement = firstElement.getNext();
        }
        else if (currentElement == lastElement) {
            lastElement = previousElement;
            previousElement.setNext(null);
        }
        else {
            previousElement.setNext(currentElement.getNext());
        }

        size--;
        return true;
    }
}
