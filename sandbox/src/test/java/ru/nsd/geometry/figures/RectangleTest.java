package ru.nsd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    void cannotCreateRectangleWithNegativeSide () {

        try {
            new Rectangle(-5., -3.);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Rectangle with negative side(s)");
        }
    }
}
