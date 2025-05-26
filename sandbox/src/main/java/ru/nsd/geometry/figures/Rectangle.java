package ru.nsd.geometry.figures;

public class Rectangle {
    public static void PrintRectangleArea(double side1, double side2) {
        System.out.println("Площадь прямоугольника - " + (side1 * side2) + " кв.см");
    }

    public static double GetRectangleArea(double side1, double side2) {
        return side1 * side2;
    }
}
