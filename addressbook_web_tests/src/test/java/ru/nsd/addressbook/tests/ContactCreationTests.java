package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.nsd.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


class ContactCreationTests extends TestBase {
    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("firstName","")){
            for(var address : List.of("address","")){
                for(var mobile : List.of("mobile","")){
                    for(var email : List.of("email","")){
                    result.add(new ContactData(firstName,address,mobile,email));
                }
            }
        }
        }
        for(int i=0; i < 5; i++){
            result.add(new ContactData(randomString( i * 10), randomString( i * 10), randomString( i * 10), randomString( i * 10)));
        }
        return result;
    }
    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<>(List.of(
                new ContactData("first name'","address", "mobile", "email"),
                new ContactData("first name","address'", "mobile", "email"),
                new ContactData("first name","address", "mobile'", "email"),
                new ContactData("first name","address", "mobile", "email'")));

        return result;
    }

    @Test
    public void canCreateContact() {


        int contactCount = app.contact().getCount();
        app.contact().contactCreation(new ContactData("firstname", "address", "mobile", "mail"));
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }
    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact){
        int contactCount = app.contact().getCount();
        app.contact().openHomePage();
        app.contact().contactCreation(contact);
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }
    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact){
        int contactCount = app.contact().getCount();
        app.contact().openHomePage();
        app.contact().contactCreation(contact);
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }

}
