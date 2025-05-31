package ru.nsd.geometry.figures;

public class Triangle {

 double a ;
 double b ;
 double c ;

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
