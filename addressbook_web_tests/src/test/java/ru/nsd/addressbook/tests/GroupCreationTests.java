package ru.nsd.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
                    result.add(new GroupData(name,header,footer));
                }
            }
        }
        for(int i=0; i < 5; i++){
            result.add(new GroupData(randomString( i * 10), randomString( i * 10), randomString( i * 10)));
        }
        return result;
    }
    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<>(List.of(
                new GroupData("group name'","header", "footer")));

        return result;
    }
    @Test
    public void canCreateGroup() {
        int groupCount = app.group().getCount();
        app.group().openGroupsPage();
        app.group().groupCreation(new GroupData("name", "header", "footer"));
        int newGroupCount = app.group().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
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
    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroups(GroupData group){
        int groupCount = app.group().getCount();
        app.group().openGroupsPage();
        app.group().groupCreation(group);
        int newGroupCount = app.group().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }
    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData group){
        int groupCount = app.group().getCount();
        app.group().openGroupsPage();
        app.group().groupCreation(group);
        int newGroupCount = app.group().getCount();
        Assertions.assertEquals(groupCount, newGroupCount);
    }
}
