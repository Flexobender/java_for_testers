package ru.nsd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Square14Test {
    @Test
    void perimetr() {
        var square14 = new Square14(5.);
        Assertions.assertEquals(20., square14.perimetr());
    }
    @Test
    void area(){
        var square14 = new Square14( 4);
        Assertions.assertEquals(16., square14.area());
    }

}
