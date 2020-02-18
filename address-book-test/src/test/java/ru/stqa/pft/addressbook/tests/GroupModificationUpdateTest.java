package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationUpdateTest extends TestBase {

    @Test
    public void testGroupUpdate() {
        applicationManager.getNavigationHelper().goToGroupPage();
        applicationManager.getGroupHelper().selectGroup();
        applicationManager.getGroupHelper().initGroupModification();
        applicationManager.getGroupHelper().fillGroupForm(new GroupData("Terminator", "QAheader", "QAfooter"));
        applicationManager.getGroupHelper().submitGroupModification();
        applicationManager.getGroupHelper().returnToGroupPage();
    }
}
