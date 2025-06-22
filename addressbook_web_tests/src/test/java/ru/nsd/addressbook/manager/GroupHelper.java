package ru.nsd.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.nsd.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase{

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public  void groupCreation(GroupData group) {
        click("new");
        fillGroupForm(group);
        click("submit");
        goToGroupPage();
    }

    public   void deleteGroups(GroupData group) {
        selectGroup(group);
        click("delete");
        goToGroupPage();
    }

    public void modifyGroup(GroupData group, GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup(group);
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        goToGroupPage();
    }


    public void goToGroupPage() {
        clickLink("group page");
    }

    public void selectGroup(GroupData group) {
        clickCssSelector(String.format("input[value='%s']", group.id()));
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

    public List<GroupData> getList() {
        var groups = new ArrayList<GroupData>();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        for (var span : spans){
            var name = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));
            groups.add(new GroupData()
                    .withId(checkbox.getAttribute("value"))
                    .withName(name));
        }
        return groups;
    }

    private void submitGroupModification() {
        click("update");
    }

    private void fillGroupForm(GroupData group) {
        fillIn(group.name(), "group_name");
        fillIn(group.name(), "group_header");
        fillIn(group.name(), "group_footer");
    }

    private void initGroupModification() {
        manager.driver.findElement(By.name("edit")).click();
    }
}
