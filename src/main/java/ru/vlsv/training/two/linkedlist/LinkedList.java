package ru.vlsv.training.two.linkedlist;

import ru.vlsv.training.two.linkedlist.entries.Entry;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 24.04.2020
 * @link https://github.com/Centnerman
 */

public interface LinkedList<E> extends Iterable<E> {

    void insert(E value);

    E remove();

    boolean remove(E value);

    boolean isEmpty();

    int getSize();

    boolean find(E value);

    void display();

    E getFirstElement();

    Entry<E> getFirst();

}
