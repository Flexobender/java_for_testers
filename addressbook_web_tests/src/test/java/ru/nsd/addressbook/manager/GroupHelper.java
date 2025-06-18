package ru.nsd.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.nsd.addressbook.model.GroupData;

import java.util.List;

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
        goToGroupPage();
    }


    public   void deleteGroups() {
        selectGroup();
        click("delete");
        goToGroupPage();
    }

    public void goToGroupPage() {
        clickLink("group page");
    }

    public void selectGroup() {
        click("selected[]");
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            clickLink("groups");
        }
    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void deleteAllGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        selectAllGroups(checkboxes);
        click("delete");
    }

    private static void selectAllGroups(List<WebElement> checkboxes) {
        for (var checkbox : checkboxes){
          checkbox.click();
        }
    }
}
