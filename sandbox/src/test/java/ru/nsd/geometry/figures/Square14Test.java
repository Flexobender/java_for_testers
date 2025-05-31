package ru.nsd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Square14Test {
    @Test
    void perimetr() {
        var square14 = new Square14(4.);
        var res = square14.perimetr();
        if(res != 20){
            throw new AssertionError(String.format("Expected %f, actual %f", 20., res));
        }

    }
    @Test
    void area(){
        var square14 = new Square14( 4);
        Assertions.assertEquals(16., square14.area());
    }
    @Test
    void cannotCreateSquareWithNegativeSide () {

        try {
            new Square14(-5.);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
        }
    }
}
