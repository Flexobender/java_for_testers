package ru.nsd.addressbook.tests;

import ru.nsd.addressbook.manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected static ApplicationManager app;


    @BeforeEach
    public void setUp() {
        if(app == null){
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser","chrome"));

    }
}
