package ru.nsd.geometry.figures;

public class Triangle {

    public static double trianglePerimetrCalc(  double a, double b, double c){
        return  a + b + c;

    }
    public   static double triangleAriaCalc (double a, double b, double c){
        double p = trianglePerimetrCalc(a,b,c)/2;
        return (double) Math.round(Math.sqrt(p*(p-a)*(p-b)*(p-c))*100d)/100d;
        // Округление честно нагуглено
    }
}
