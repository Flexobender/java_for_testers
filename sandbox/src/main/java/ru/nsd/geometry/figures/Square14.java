package ru.nsd.geometry.figures;

public record Square14(double side) {
    public double perimetr() {
        return side * 4;
    }

    public double area() {
        return side * side;
    }

}
