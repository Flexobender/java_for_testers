package ru.nsd.geometry.figures;

public class Square {
    public static void PrintSquareArea(double side) {
        System.out.println("Площадь квадрата - " + (side * 2) + " кв.см");
    }

    public static double GetSquareArea(double side) {
        return side * 2;
    }
}
