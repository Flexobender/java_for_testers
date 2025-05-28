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
    //public  double aria(){
     //   double p = Perimetr()/2;
        //return (double) Math.round(Math.sqrt(p*(p-a)*(p-b)*(p-c))*100d)/100d;
        // Округление честно нагуглено
    //}

    public  double perimetr() {
        return this.a + this.b + this.c;
    }

    public double aria() {
        var p = this.a + this.b + this.c;
        return (double) Math.round(Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c))*100d)/100d;
    }
}
