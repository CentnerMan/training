package ru.vlsv.training.two.linkedlist.entries;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 24.04.2020
 * @link https://github.com/Centnerman
 */

public interface Entry<T> {

    T getValue();

    Entry<T> getNext();

    void setNext(Entry<T> nextElement);
}
