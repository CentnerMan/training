package ru.vlsv.training.two.arraylist;

import java.io.Serializable;
import java.util.List;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 26.04.2020
 * @link https://github.com/Centnerman
 */

public interface ArrayList<E> extends Iterable<E>{

    void add(E value);

    E get(int index);

    void remove(int index);

    int size();

}
