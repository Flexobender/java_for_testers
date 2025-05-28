package ru.nsd.geometry.figures;

public class Triangle {

    static double a = 3.;
    static double b = 4.;
    static double c = 5.;

    public static double Perimetr(){
        return  a + b + c;

    }
    public static double Aria(){
        double p = Perimetr()/2;
        return (double) Math.round(Math.sqrt(p*(p-a)*(p-b)*(p-c))*100d)/100d;
        // Округление честно нагуглено
    }

}
