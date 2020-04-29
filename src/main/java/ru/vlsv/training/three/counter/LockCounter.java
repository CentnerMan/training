package ru.vlsv.training.three.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 29.04.2020
 * @link https://github.com/Centnerman
 */

public class SynchronizedCounter {

    Lock lock = new ReentrantLock();

    private int c;

    public SynchronizedCounter() {
        c = 0;
    }

    public int value() {
        return c;
    }

    public void inc() {
        lock.lock();
        c++;
        lock.unlock();
    }

    public void dec() {
        lock.lock();
        c--;
        lock.unlock();
    }
}
