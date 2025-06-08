package ru.nsd.geometry.figures;

import java.util.ArrayList;
import java.util.Collections;

public class Triangle {

    double a;
    double b;
    double c;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;

        ArrayList<Double> first = new ArrayList<Double>();
        first.add(a);
        first.add(b);
        first.add(c);
        Collections.sort(first);

        ArrayList<Double> second = new ArrayList<Double>();
        second.add(triangle.a);
        second.add(triangle.b);
        second.add(triangle.c);
        Collections.sort(second);

        return (first.equals(second));
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("No negative sides in triangle allowed");
        }
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("Two sides in triangle are too short");
        }
    }

    public double perimetr() {
        return a + b + c;
    }

    public double aria() {
        var p = a + b + c;
        return (double) Math.round(Math.sqrt(p * (p - a) * (p - b) * (p - c)) * 100d) / 100d;
    }
}
