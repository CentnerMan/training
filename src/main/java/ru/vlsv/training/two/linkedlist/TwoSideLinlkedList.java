package ru.geekbrains.datastructures.linkedlist.twoside;

import ru.geekbrains.datastructures.linkedlist.LinkedList;

public interface TwoSideLinlkedList<E> extends LinkedList<E> {

    void insertLeft(E value);
    void insertRight(E value);

    E removeLeft();
}
