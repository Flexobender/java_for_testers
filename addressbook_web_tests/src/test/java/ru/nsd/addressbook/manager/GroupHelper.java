package ru.nsd.addressbook.manager;

import org.openqa.selenium.By;
import ru.nsd.addressbook.model.GroupData;

public class GroupHelper extends HelperBase{

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public  void groupCreation(GroupData group) {
        click("new");

        fillIn(group.name(), "group_name");

        fillIn(group.name(), "group_header");

        fillIn(group.name(), "group_footer");
        click("submit");
        clickLink("group page");
    }

    public   void deleteGroup() {
        click("selected[]");
        click("delete");
        clickLink("group page");
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            clickLink("groups");
        }
    }

    public void isGroupPresent() {
        if (!manager.isElementPresent(By.name("selected[]"))) {

            groupCreation(new GroupData("", "", ""));
        }
    }
}
