import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;


public class GroupCreationTests extends TestBase{


    @Test
    public void canCreateGroup() {
        openGroupsPage();

        groupCreation("Group1 name", "Group1 header", "Group1 footer");

    }

    @Test
    public void canCreateGroupWithEmptyName() {

        driver.findElement(By.linkText("groups")).click();
        groupCreation("", "", "");

    }
}
