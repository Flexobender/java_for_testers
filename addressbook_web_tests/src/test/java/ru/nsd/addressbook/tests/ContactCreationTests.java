package ru.nsd.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.nsd.addressbook.common.CommonFunctions;
import ru.nsd.addressbook.model.ContactData;
import ru.nsd.addressbook.model.ContactData;
import ru.nsd.addressbook.model.GroupData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
//        for (var firstName : List.of("firstName","")){
//            for(var address : List.of("address","")){
//                for(var mobile : List.of("mobile","")){
//                    for(var email : List.of("email","")){
//                    result.add(new ContactData("", "Куклачев", firstName,address,mobile,email,""));
//                }
//            }
//        }
//        }
//        for(int i=0; i < 5; i++){
//            result.add(new ContactData("", "Куклачев", CommonFunctions.randomString( i * 10), CommonFunctions.randomString( i * 10), CommonFunctions.randomString( i * 10), CommonFunctions.randomString( i * 10), CommonFunctions.randomString( i * 10)));
//        }
        var json = Files.readString(Paths.get("contacts.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;

    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<>(List.of(
                new ContactData(app.properties.getProperty("contact.id") + "",
                        app.properties.getProperty("contact.lastname") + "'",
                        app.properties.getProperty("contact.firstname") + "",
                        app.properties.getProperty("contact.address") + "",
                        app.properties.getProperty("contact.mobile") + "",
                        app.properties.getProperty("contact.email") + "",
                        CommonFunctions.randomFile(app.properties.getProperty("paths.images"))),
                new ContactData(app.properties.getProperty("contact.id") + "",
                        app.properties.getProperty("contact.lastname") + "",
                        app.properties.getProperty("contact.firstname") + "'",
                        app.properties.getProperty("contact.address") + "",
                        app.properties.getProperty("contact.mobile") + "",
                        app.properties.getProperty("contact.email") + "",
                        CommonFunctions.randomFile(app.properties.getProperty("paths.images"))),
                new ContactData(app.properties.getProperty("contact.id") + "",
                        app.properties.getProperty("contact.lastname") + "",
                        app.properties.getProperty("contact.firstname") + "",
                        app.properties.getProperty("contact.address") + "'",
                        app.properties.getProperty("contact.mobile") + "",
                        app.properties.getProperty("contact.email") + "",
                        CommonFunctions.randomFile(app.properties.getProperty("paths.images"))),
                new ContactData(app.properties.getProperty("contact.id") + "",
                        app.properties.getProperty("contact.lastname") + "",
                        app.properties.getProperty("contact.firstname") + "",
                        app.properties.getProperty("contact.address") + "",
                        app.properties.getProperty("contact.mobile") + "'",
                        app.properties.getProperty("contact.email") + "",
                        CommonFunctions.randomFile(app.properties.getProperty("paths.images")))));



        return result;
    }

    public static List<ContactData> singleRandomContact() {
        return List.of(new ContactData()
//                .withId(CommonFunctions.randomString(3))
                .withLastAndFirstNames(CommonFunctions.randomString(5),CommonFunctions.randomString(5))
                .withAddress(CommonFunctions.randomString(15)));
//                .withPhoto(CommonFunctions.randomFile("src/test/resources/images")));
    }

    @Test
    public void canCreateContact() {


        int contactCount = app.contact().getCount();
        //app.contact().contactCreation(new ContactData("", "Куклачев", "firstname", "address", "mobile", "mail","src/test/resources/images/avatar.png"));
        app.contact().contactCreation(new ContactData().withLastAndFirstNames("Smith","John").withPhoto(CommonFunctions.randomFile("src/test/resources/images")));
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contact().getCount();
        app.contact().openHomePage();
        app.contact().contactCreation(contact);
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactCount = app.contact().getCount();
        app.contact().openHomePage();
        app.contact().contactCreation(contact);
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }

    // Тест на создание контакта с проверками через hibernate
    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void canCreateContactByHbm(ContactData contact) {

        var oldContacts = app.hbm().getContactList();
        app.contact().contactCreation(contact);
        var newContacts = app.hbm().getContactList();
        Comparator<ContactData> comparedById = (o1, o2) -> {
            return  Integer.compare(Integer.parseInt(o1.id()),Integer.parseInt(o2.id()));
        };
        newContacts.sort(comparedById);
        var maxIdIndex = newContacts.size() - 1;
        var maxId = newContacts.get(maxIdIndex).id();
        var expectedList = new ArrayList<>(oldContacts);

        expectedList.add(contact.withId(maxId).withPhoto(newContacts.get(maxIdIndex).file())); // меняем строку пути к фото метаинформацией из бд

        expectedList.sort(comparedById);

        Assertions.assertEquals(newContacts, expectedList);
    }

}
