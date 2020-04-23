package ru.vlsv.training.one.errors;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.04.2020
 * @link https://github.com/Centnerman
 */


interface Moveable {
    default void move() {
        System.out.println("Car is moving");
    }
}

interface Stopable {
    default void stop() {
        System.out.println("Car is stop");
    }
}

class Engine {
    public Engine() {
    }
}

abstract class Car implements Moveable, Stopable{
    public Engine engine;
    private String color;
    private String name;

    protected void start() {
        System.out.println(this.getName() + " starting");
    }

    protected void open() {
        System.out.println(this.getName() + " is open");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class LightWeightCar extends Car {
    public LightWeightCar() {
        this.setName("LightWeightCar");
    }
}

class Lorry extends Car {
    public Lorry() {
        this.setName("Lorry");
    }
}


class MainClass {
    public static void main(String[] args) {
        Car lwc = new LightWeightCar();
        System.out.println(lwc.getName());
        lwc.open();
        lwc.start();
        lwc.move();
        lwc.stop();
        System.out.println("-----------------");
        Car lorry = new Lorry();
        System.out.print(lorry.getName());
        lorry.open();
        lorry.start();
        lorry.move();
        lorry.stop();
    }
}