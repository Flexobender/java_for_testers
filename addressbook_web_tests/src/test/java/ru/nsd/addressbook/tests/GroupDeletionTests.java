package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Test;

public class GroupDeletionTests extends TestBase {



    @Test
    public void canDeleteGroup() {

        app.group().openGroupsPage();

        app.group().isGroupPresent();
        app.group().deleteGroup();
    }

}
