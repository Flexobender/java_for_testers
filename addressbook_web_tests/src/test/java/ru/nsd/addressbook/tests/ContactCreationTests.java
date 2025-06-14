package ru.nsd.addressbook.tests;

import ru.nsd.addressbook.model.ContactData;
import org.junit.jupiter.api.Test;


class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {

        app.contact().openContactPage();
        app.contact().contactCreation(new ContactData("firstname", "address", "mobile", "mail"));
    }

}
