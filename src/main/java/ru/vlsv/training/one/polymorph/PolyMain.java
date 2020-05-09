package ru.vlsv.training.one.polymorph;

import java.util.ArrayList;
import java.util.List;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.04.2020
 * @link https://github.com/Centnerman
 */

public class PolyMain {
    public static void main(String[] args) {
        Figure circle = new Circle();
        Figure square = new Square();
        Figure triangle = new Triangle();

        List<Figure> figures = new ArrayList<>() ;
        figures.add(triangle);
        figures.add(circle);
        figures.add(square);

        for (Figure figure : figures) {
            figure.Move();
            figure.Draw();
        }
    }
}
