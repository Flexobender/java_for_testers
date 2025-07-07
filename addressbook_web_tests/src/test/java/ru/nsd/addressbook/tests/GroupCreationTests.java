package ru.nsd.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.nsd.addressbook.common.CommonFunctions;
import ru.nsd.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
//        for (var name : List.of("group name", "")) {
//            for (var header : List.of("header name", "")) {
//                for (var footer : List.of("footer name", "")) {
//                    result.add(new GroupData()
//                            .withName(name)
//                            .withHeader(header)
//                            .withFooter(footer));
//                }
//            }
//        }
        var json = "";
        try (var reader = new FileReader(app.properties.getProperty("groups.json"));
             var breader = new BufferedReader(reader)) {
            var line = breader.readLine();
            while (line != null) {
                json = json + line;
                line = breader.readLine();
            }
        }
//      var json = Files.readString(Paths.get("groups.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<GroupData>>() {});
        result.addAll(value);
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<>(List.of(
                new GroupData(app.properties.getProperty("group.id") + "",
                        app.properties.getProperty("group.name") + "'",
                        app.properties.getProperty("group.header") + "",
                        app.properties.getProperty("group.footer") + "")));

        return result;
    }

    public static List<GroupData> singleRandomGroup() throws IOException {
        return List.of(new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(20))
                .withFooter(CommonFunctions.randomString(30)));
    }


    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroups(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().openGroupsPage();
        app.groups().groupCreation(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().openGroupsPage();
        app.groups().groupCreation(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount, newGroupCount);
    }
// Тест на создание группы с проверками через jdbc
    @ParameterizedTest
    @MethodSource("singleRandomGroup")
    public void canCreateGroupJdbc(GroupData group) {
        var oldGroups = app.jdbc().getGroupList();
        app.groups().openGroupsPage();
        app.groups().groupCreation(group);
        var newGroups = app.jdbc().getGroupList();
        Comparator<GroupData> comparedById = (o1, o2) -> {
            return  Integer.compare(Integer.parseInt(o1.id()),Integer.parseInt(o2.id()));
        };
        newGroups.sort(comparedById);
        var maxId = newGroups.get(newGroups.size() - 1).id();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(maxId));
        expectedList.sort(comparedById);

        Assertions.assertEquals(newGroups, expectedList);
    }
    // Тест на создание группы с проверками через hibernate
    @ParameterizedTest
    @MethodSource("singleRandomGroup")
    public void canCreateGroup(GroupData group) {
        var oldGroups = app.hbm().getGroupList();
        app.groups().openGroupsPage();
        app.groups().groupCreation(group);
        var newGroups = app.hbm().getGroupList();
        Comparator<GroupData> comparedById = (o1, o2) -> {
            return  Integer.compare(Integer.parseInt(o1.id()),Integer.parseInt(o2.id()));
        };
        newGroups.sort(comparedById);
        var maxId = newGroups.get(newGroups.size() - 1).id();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(maxId));
        expectedList.sort(comparedById);

        Assertions.assertEquals(newGroups, expectedList);
    }
}
