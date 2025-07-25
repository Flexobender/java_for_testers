package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsd.addressbook.manager.ContactHelper;
import ru.nsd.addressbook.manager.HelperBase;
import ru.nsd.addressbook.model.ContactData;
import ru.nsd.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {
    @Test
    void canModifyContact(){
        if(app.contact().getCount() == 0) app.contact().contactCreation(new ContactData("", "", "", "","","",""));
        var oldContacts = app.contact().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withLastAndFirstNames("modified lastname", "modified firstname");
        app.contact().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.contact().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> comparedById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(comparedById);
        expectedList.sort(comparedById);
        Assertions.assertEquals(newContacts, expectedList);

    }
}
