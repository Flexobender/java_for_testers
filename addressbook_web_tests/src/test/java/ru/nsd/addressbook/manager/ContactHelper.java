package ru.nsd.addressbook.manager;

import org.openqa.selenium.By;
import ru.nsd.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{


    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public   void contactCreation(ContactData contactData) {

        fillIn(contactData.firstname(),"firstname");
        fillIn(contactData.address(),"address");
        fillIn(contactData.mobile(),"mobile");
        fillIn(contactData.email(),"email");
        clickXpath("(//input[@name=\'submit\'])[2]");
        clickLink("home page");

    }

    public void openContactPage() {
        if (manager.isElementPresent(By.linkText("add new"))) {
            clickLink("add new");
        }
    }

    public void contactDeletion() {
        click("selected[]");
        clickXpath("//input[@value=\'Delete\']");

    }

    public void isContactPresent() {

        if (!manager.isElementPresent(By.name("selected[]"))){
            openContactPage();
            contactCreation(new ContactData("test", "test", "test", "test"));
        }
    }
}
