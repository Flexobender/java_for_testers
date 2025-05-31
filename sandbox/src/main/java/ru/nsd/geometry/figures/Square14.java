package ru.nsd.geometry.figures;

public record Square14(double side) {
    public Square14 {
        if (side < 0){
            throw new IllegalArgumentException("Side has to be non-negative");
        }
    }
    public double perimetr() {
        return side * 4;
    }

    public double area() {
        return side * side;
    }

}
