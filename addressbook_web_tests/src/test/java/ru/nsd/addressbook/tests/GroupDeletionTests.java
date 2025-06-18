package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsd.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {



    @Test
    public void canDeleteGroup() {

        app.group().openGroupsPage();

        if(app.group().getCount() == 0) app.group().groupCreation(new GroupData("", "", ""));
        int groupCount = app.group().getCount();
        app.group().selectGroup();
        app.group().deleteGroups();
        app.group().goToGroupPage();
        int newGroupCount = app.group().getCount();
        Assertions.assertEquals(groupCount - 1, newGroupCount);
    }

    @Test
    void canDeleteAllGroupsAtOnce(){
        if(app.group().getCount() == 0) app.group().groupCreation(new GroupData("", "", ""));
        int groupCount = app.group().getCount();
        app.group().deleteAllGroups();
        Assertions.assertEquals(0,app.group().getCount());
    }

}
