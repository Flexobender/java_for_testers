package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactDeletionTests extends TestBase {
  @Test
  public void canDeleteContact(){
    int contactCount = app.contact().getCount();
    app.contact().contactDeletion();
    int newContactCount = app.contact().getCount();
    Assertions.assertEquals(contactCount - 1, newContactCount);

  }
}
