package ru.vlsv.training.one.polymorph;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.04.2020
 * @link https://github.com/Centnerman
 */

public class Circle implements Figure{
    @Override
    public void Draw() {
        System.out.println("Draw circle");
    }

    @Override
    public void Move() {
        System.out.println("Move circle");
    }

}
