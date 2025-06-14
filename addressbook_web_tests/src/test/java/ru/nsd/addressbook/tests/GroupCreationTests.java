package ru.nsd.addressbook.tests;

import ru.nsd.addressbook.model.GroupData;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase{


    @Test
    public void canCreateGroup() {

        app.group().openGroupsPage();
        app.group().groupCreation(new GroupData("name", "header", "footer"));

    }

    @Test
    public void canCreateGroupWithEmptyName() {

        app.group().openGroupsPage();
        app.group().groupCreation(new GroupData("", "", ""));

    }
    @Test
    public void canCreateGroupWithNameOnly() {

        app.group().openGroupsPage();
        app.group().groupCreation(new GroupData().withName("some name"));
    }

    @Test
    public void canCreateGroupWithHeaderOnly() {

        app.group().openGroupsPage();
        app.group().groupCreation(new GroupData().withHeader("some header"));
    }
    @Test
    public void canCreateGroupWithFooterOnly() {

        app.group().openGroupsPage();
        app.group().groupCreation(new GroupData().withFooter("some footer"));

    }
}
