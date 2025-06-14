package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Test;

class ContactDeletionTests extends TestBase {
  @Test
  public void canDeleteContact(){
    app.contact().isContactPresent();
    app.contact().contactDeletion();

  }
}
