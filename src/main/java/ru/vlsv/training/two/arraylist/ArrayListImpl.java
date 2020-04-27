package ru.vlsv.training.two.arraylist;

import java.util.Iterator;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 26.04.2020
 * @link https://github.com/Centnerman
 */

public class ArrayListImpl<E> implements ArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private Object[] dataIn;

    public ArrayListImpl() {
        dataIn = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayListImpl(int capacity) {
        dataIn = new Object[capacity];
        size = 0;
    }

    @Override
    public void add(E value) {
        autoResize();
        dataIn[size] = value;
        size++;
    }

    @Override
    public E get(int index) {
        return (E) dataIn[index];
    }

    @Override
    public void remove(int index) {
        if (indexIn(index)) {
            if (dataIn.length - 1 - index >= 0)
                System.arraycopy(dataIn, index + 1, dataIn, index, dataIn.length - 1 - index);
            size--;
        }
    }

    private boolean indexIn(int index) {
        return index <= dataIn.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void autoResize() {
        if (size == dataIn.length - 1) {
            Object[] tempArr = new Object[dataIn.length * 2];
            System.arraycopy(dataIn, 0, tempArr, 0, dataIn.length);
            dataIn = tempArr;
        }
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
