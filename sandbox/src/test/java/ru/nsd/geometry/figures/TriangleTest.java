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
}
