package ru.nsd.geometry.figures;

public class Rectangle {
    double a;
    double b;
    public Rectangle(double a, double b){
        this.a = a;
        this.b =b;
        if(a < 0 || b < 0){
            throw new IllegalArgumentException("Rectangle should have non-negative sides");
        }
    }

    public static void PrintRectangleArea(double side1, double side2) {
        System.out.println("Площадь прямоугольника - " + (side1 * side2) + " кв.см");
    }

    public static double GetRectangleArea(double side1, double side2) {
        return side1 * side2;
    }
}
