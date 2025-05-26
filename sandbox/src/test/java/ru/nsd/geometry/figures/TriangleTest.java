package ru.nsd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void canCalculateArea(){
        var result = Triangle.triangleAriaCalc(2.2, 2.2, 1.3);
        Assertions.assertEquals(1.37, result);
    }
    @Test
    void canCalculatePerimetr() {
        Assertions.assertEquals(23.9, Triangle.trianglePerimetrCalc(8.0, 8.9, 7.0));
    }
}
