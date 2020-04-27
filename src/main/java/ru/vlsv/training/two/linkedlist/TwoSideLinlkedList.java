package ru.vlsv.training.two.linkedlist;

public interface TwoSideLinlkedList<E> extends LinkedList<E> {

    void insertLeft(E value);
    void insertRight(E value);

    E removeLeft();
}
