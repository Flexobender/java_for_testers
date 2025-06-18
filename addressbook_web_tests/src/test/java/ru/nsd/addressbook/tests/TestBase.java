package ru.nsd.addressbook.tests;

import ru.nsd.addressbook.manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestBase {
    protected static ApplicationManager app;

    protected static String randomString(int n) {
        String result = "";
        for(int i = 0; i < n; i++){
            result = result + (char)('a' + new Random().nextInt(26));
        }
        return result;
    }


    @BeforeEach
    public void setUp() {
        if(app == null){
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser","chrome"));

    }
}
