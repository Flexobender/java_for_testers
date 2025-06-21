package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsd.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Random;

class ContactDeletionTests extends TestBase {
  @Test
  public void canDeleteContact() throws InterruptedException {
    var oldContacts = app.contact().getList();
    var rnd = new Random();
    var index = rnd.nextInt(oldContacts.size());
    app.contact().contactDeletion(oldContacts.get(index));
    //Thread.sleep(3000);
    var newContacts = app.contact().getList();
    var expectedList = new ArrayList<>(oldContacts);
    expectedList.remove(index);



    Assertions.assertEquals(expectedList, newContacts);

  }
}
