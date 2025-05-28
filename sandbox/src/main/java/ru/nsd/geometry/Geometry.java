package ru.nsd.geometry;

import ru.nsd.geometry.figures.Rectangle;
import ru.nsd.geometry.figures.Square;
import ru.nsd.geometry.figures.Triangle;

//import static ru.nsd.geometry.figures.Triangle.Aria;


public class Geometry {
    public static void main(String[] args) {
        Square.PrintSquareArea(4.0);
        Rectangle.PrintRectangleArea(3.4, 5.8);
        System.out.println(Square.GetSquareArea( 5.4));
        System.out.println(Math.round(Rectangle.GetRectangleArea( 6.0, 5.2)*100d)/100d);

        System.out.println("Периметр треугольника составляет "+ (4.3 + 4.4 + 4.5) + " см");


        var triangle = new Triangle(2.,2.,2.);
        System.out.println("Периметр треугольника составляет "+ triangle.perimetr() + " см");
        System.out.println("Площадь треугольника по формуле Герона составляет "+ triangle.aria() + " кв.см");
        }
    }


