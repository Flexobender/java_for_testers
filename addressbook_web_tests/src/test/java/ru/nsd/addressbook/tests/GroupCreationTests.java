package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.nsd.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


public class GroupCreationTests extends TestBase{


    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>();
        for (var name : List.of("group name","")){
            for(var header : List.of("header name","")){
                for(var footer : List.of("footer name","")){
                    result.add(new GroupData()
                            .withName(name)
                            .withHeader(header)
                            .withFooter(footer));
                }
            }
        }
        for(int i=0; i < 5; i++){
            result.add(new GroupData()
                    .withName(randomString( i * 10))
                    .withHeader(randomString( i * 10))
                    .withFooter(randomString( i * 10)));
        }
        return result;
    }
    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<>(List.of(
                new GroupData("", "group name'","header", "footer")));

        return result;
    }



    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroups(GroupData group){
        int groupCount = app.groups().getCount();
        app.groups().openGroupsPage();
        app.groups().groupCreation(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }
    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData group){
        int groupCount = app.groups().getCount();
        app.groups().openGroupsPage();
        app.groups().groupCreation(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount, newGroupCount);
    }
}
