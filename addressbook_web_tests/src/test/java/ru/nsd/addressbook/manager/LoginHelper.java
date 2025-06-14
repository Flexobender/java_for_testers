package ru.nsd.addressbook.manager;

import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    void login(String user, String password) {
        fillIn(user,"user");
        fillIn(password, "pass");
        clickXpath("//input[@value=\'Login\']");
    }
}
