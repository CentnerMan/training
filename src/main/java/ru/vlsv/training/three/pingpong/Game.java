package ru.vlsv.training.three.pingpong;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 27.04.2020
 * @link https://github.com/Centnerman
 */

public class Game {

    private final Object mon = new Object();
    private volatile String currentWord = "ping";
    private final int count = 100;

    public static void main(String[] args) {

        Game game = new Game();

        Thread t1 = new Thread(() -> {
            game.printPing();
        });

        Thread t2 = new Thread(() -> {
            game.printPong();
        });

        t1.start();
        t2.start();
    }

    public void printPing() {
        synchronized (mon) {
            try {
                for (int i = 0; i < count; i++) {
                    while (!currentWord.equals("ping")) {
                        mon.wait();
                    }
                    System.out.println("ping");
                    Thread.sleep(100);
                    currentWord = "pong";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printPong() {
        synchronized (mon) {
            try {
                for (int i = 0; i < count; i++) {
                    while (!currentWord.equals("pong")) {
                        mon.wait();
                    }
                    System.out.println("pong");
                    Thread.sleep(100);
                    currentWord = "ping";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
