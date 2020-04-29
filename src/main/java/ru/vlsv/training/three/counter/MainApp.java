package ru.vlsv.training.three.counter;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 29.04.2020
 * @link https://github.com/Centnerman
 */

public class MainApp {
    public static void main(String[] args) {

        LockCounter counter = new LockCounter();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.inc();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.dec();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            incThread.start();
            decThread.start();

            incThread.join();
            decThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Значение синхронизированного счетчика: " + counter.value());
    }
}
