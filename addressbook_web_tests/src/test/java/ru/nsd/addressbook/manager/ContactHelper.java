package ru.nsd.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import ru.nsd.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{


    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public   void contactCreation(ContactData contactData) {
        openContactPage();
        fillIn(contactData.lastname(),"lastname");
        fillIn(contactData.firstname(),"firstname");
        fillIn(contactData.address(),"address");
        fillIn(contactData.mobile(),"mobile");
        fillIn(contactData.email(),"email");
        attach(By.name("photo"), contactData.file());
        clickXpath("(//input[@name=\'submit\'])[2]");
        clickLink("home page");

    }

    public void openContactPage() {
        if (manager.isElementPresent(By.linkText("add new"))) {
            clickLink("add new");
        }
    }
    public void openHomePage() {
        if (manager.isElementPresent(By.linkText("home"))) {
            clickLink("home");
        }
    }

    public void contactDeletion(ContactData contact) {
        selectContact(contact);
        //click("selected[]");
        clickXpath("//input[@value=\'Delete\']");
        clickLink("home");

    }

    private void selectContact(ContactData contact) {
        clickCssSelector(String.format("input[value='%s']", contact.id()));
    }

    public void isContactPresent() {

        if (!manager.isElementPresent(By.name("selected[]"))){
            openContactPage();
            contactCreation(new ContactData("", "Куклачев", "test", "test", "test", "test", ""));
        }
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs){
            var lastname = tr.findElements(By.tagName("td")).get(1).getText();
            var firstname = tr.findElements(By.tagName("td")).get(2).getText();

            var id = tr.findElement(By.tagName("input")).getAttribute("id");
            contacts.add(new ContactData(id, lastname, firstname,"","","",""));
        }
        return contacts;
    }

    public void modifyContact(ContactData contact, ContactData testData) {
        openHomePage();
        manager.driver.findElement(By.id(contact.id())).findElement(By.xpath("../../td[8]/a/img")).click();
        fillIn(testData.lastname(), "lastname");
        fillIn(testData.firstname(), "firstname");
        click("update");
        openHomePage();
    }
}
