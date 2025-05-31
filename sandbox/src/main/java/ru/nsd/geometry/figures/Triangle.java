package ru.nsd.geometry.figures;

public class Triangle {

 double a ;
 double b ;
 double c ;

 public Triangle (double a, double b, double c) {
     this.a = a;
     this.b = b;
     this.c = c;
    }
    public  double perimetr() {
        return a + b + c;
    }

    public double aria() {
        var p = a + b + c;
        return (double) Math.round(Math.sqrt(p*(p-a)*(p-b)*(p-c))*100d)/100d;
    }
}
