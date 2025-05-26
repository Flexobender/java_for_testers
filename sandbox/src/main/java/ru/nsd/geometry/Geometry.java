package ru.nsd.geometry;

import ru.nsd.geometry.figures.Rectangle;
import ru.nsd.geometry.figures.Square;

import static ru.nsd.geometry.figures.Triangle.triangleAriaCalc;
import static ru.nsd.geometry.figures.Triangle.trianglePerimetrCalc;

public class Geometry {
    public static void main(String[] args) {
        Square.PrintSquareArea(4.0);
        Rectangle.PrintRectangleArea(3.4, 5.8);
        System.out.println(Square.GetSquareArea( 5.4));
        System.out.println(Math.round(Rectangle.GetRectangleArea( 6.0, 5.2)*100d)/100d);

        System.out.println("Периметр треугольника составляет "+ (4.3 + 4.4 + 4.5) + " см");
        System.out.println("Периметр треугольника составляет "+ trianglePerimetrCalc(8.0,8.9,7.0) + " см");
        System.out.println("Площадь треугольника по формуле Герона составляет "+ triangleAriaCalc(2.2,2.2,1.3) + " кв.см");
        }
    }


