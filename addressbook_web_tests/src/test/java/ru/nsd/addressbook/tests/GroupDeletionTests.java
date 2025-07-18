package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsd.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupDeletionTests extends TestBase {



    @Test
    public void canDeleteGroup() {

        app.groups().openGroupsPage();

        if(app.hbm().getGroupCount() == 0) app.hbm().groupCreation(new GroupData("", "", "", ""));

        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().deleteGroups(oldGroups.get(index));

        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);


        Assertions.assertEquals(newGroups, expectedList);
    }

    @Test
    void canDeleteAllGroupsAtOnce(){
        if(app.hbm().getGroupCount() == 0) app.hbm().groupCreation(new GroupData("", "", "", ""));

        app.groups().deleteAllGroups();
        Assertions.assertEquals(0,app.hbm().getGroupCount());
    }

}
