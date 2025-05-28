package ru.nsd.geometry;

import ru.nsd.geometry.figures.Rectangle;
import ru.nsd.geometry.figures.Square;
import ru.nsd.geometry.figures.Triangle;

import static ru.nsd.geometry.figures.Triangle.Aria;
import static ru.nsd.geometry.figures.Triangle.Perimetr;

public class Geometry {
    public static void main(String[] args) {
        Square.PrintSquareArea(4.0);
        Rectangle.PrintRectangleArea(3.4, 5.8);
        System.out.println(Square.GetSquareArea( 5.4));
        System.out.println(Math.round(Rectangle.GetRectangleArea( 6.0, 5.2)*100d)/100d);

        System.out.println("Периметр треугольника составляет "+ (4.3 + 4.4 + 4.5) + " см");
        System.out.println("Периметр треугольника составляет "+ Perimetr() + " см");
        System.out.println("Площадь треугольника по формуле Герона составляет "+ Aria() + " кв.см");
        }
    }


