package ru.nsd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void canCalculateArea(){
        var result = Triangle.Aria();
        Assertions.assertEquals(6.0, result);
    }
    @Test
    void canCalculatePerimetr() {
        Assertions.assertEquals(12., Triangle.Perimetr());
    }
}
