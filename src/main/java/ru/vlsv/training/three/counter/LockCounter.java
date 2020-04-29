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

public class LockCounter {

    Lock lock = new ReentrantLock();

    private int counter;

    public LockCounter() {
        counter = 0;
    }

    public int value() {
        return counter;
    }

    public void inc() {
        lock.lock();
        counter++;
        lock.unlock();
    }

    public void dec() {
        lock.lock();
        counter--;
        lock.unlock();
    }
}
