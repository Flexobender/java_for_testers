package ru.nsd.geometry.figures;

public record Rectangle14(double a, double b) {

    public double perimetr() {
        return (a + b) * 2;
    }

    public double area() {
        return a * b;
    }
}
