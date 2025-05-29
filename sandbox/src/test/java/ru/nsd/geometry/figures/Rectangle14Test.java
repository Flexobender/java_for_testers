package ru.nsd.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Rectangle14Test {
    @Test
    void perimetr(){
        var rectangle14 = new Rectangle14(2., 5);
        Assertions.assertEquals(14, rectangle14.perimetr());
    }
    @Test
    void area(){
        var rectangle14 = new Rectangle14(2., 5.);
        Assertions.assertEquals(20., rectangle14.area());
    }

}
