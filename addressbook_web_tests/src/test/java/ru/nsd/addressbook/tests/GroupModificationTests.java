package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsd.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase{
    @Test
    void canModifyGroup(){
        if(app.hbm().getGroupCount() == 0) app.hbm().groupCreation(new GroupData("", "", "", ""));
        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withName("modified name");
        app.groups().modifyGroup(oldGroups.get(index), testData); // заменяем одну группу на новую
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        Comparator<GroupData> comparedById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(comparedById);
        expectedList.sort(comparedById);
        Assertions.assertEquals(newGroups, expectedList);

    }
}
