package ru.nsd.geometry.figures;

import java.util.Objects;

public class Triangle {

 double a ;
 double b ;
 double c ;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0)
                || (Double.compare(a, triangle.b) == 0 && Double.compare(b, triangle.c) == 0 && Double.compare(c, triangle.a) == 0)
                || (Double.compare(a, triangle.c) == 0 && Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.b) == 0)
                || (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.c) == 0)
                || (Double.compare(a, triangle.b) == 0 && Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.c) == 0)
                || (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.c) == 0 && Double.compare(c, triangle.c) == 0)
                || (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.a) == 0)
                || (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.b) == 0)
                || (Double.compare(a, triangle.b) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0)
                || (Double.compare(a, triangle.c) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0)
                || (Double.compare(a, triangle.c) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.a) == 0)
                || (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.c) == 0 && Double.compare(c, triangle.b) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public Triangle (double a, double b, double c) {
     this.a = a;
     this.b = b;
     this.c = c;
     if(a < 0 || b < 0 || c < 0){
         throw new IllegalArgumentException("No negative sides in triangle allowed");
     }
     if(a + b < c || a + c < b || b + c < a){
         throw new IllegalArgumentException("Two sides in triangle are too short");
     }
    }
    public  double perimetr() {
        return a + b + c;
    }

    public double aria() {
        var p = a + b + c;
        return (double) Math.round(Math.sqrt(p*(p-a)*(p-b)*(p-c))*100d)/100d;
    }
}
