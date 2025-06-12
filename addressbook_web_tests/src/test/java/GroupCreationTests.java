import model.GroupData;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase{


    @Test
    public void canCreateGroup() {

        openGroupsPage();
        groupCreation(new GroupData("Group1 name", "Group1 header", "Group1 footer"));

    }

    @Test
    public void canCreateGroupWithEmptyName() {

        openGroupsPage();
        groupCreation(new GroupData("", "", ""));

    }
    @Test
    public void canCreateGroupWithNameOnly() {

        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        groupCreation(groupWithName);
    }

    @Test
    public void canCreateGroupWithHeaderOnly() {

        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithHeader = emptyGroup.withHeader("some header");
        groupCreation(groupWithHeader);
    }
    @Test
    public void canCreateGroupWithFooterOnly() {

        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithFooter = emptyGroup.withFooter("some footer");
        groupCreation(groupWithFooter);

    }
}
