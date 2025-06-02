package ru.nsd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void area(){
        var triangle = new Triangle( 2., 2., 2.);
        var result = triangle.aria();
        Assertions.assertEquals(19.6, result);
    }
    @Test
    void perimetr() {
        var triangle = new Triangle(2.,2.,2.);
        Assertions.assertEquals(6., triangle.perimetr());
    }
    @Test
    void cannotHaveNegativeSide() {
        try {
            new Triangle(5., 3., -4);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Triangle with negative side(s)");
        }
    }
    @Test
    void cannotHaveShortSides(){
        try {
            new Triangle(5., 10., 3);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Triangle with short side(s)");
        }
    }
    @Test
    void testEquality(){
        var t1 = new Triangle(1.,2.,3.);
        var t2 = new Triangle(1.,3.,2.);
        Assertions.assertEquals(t1, t2);
    }

}
