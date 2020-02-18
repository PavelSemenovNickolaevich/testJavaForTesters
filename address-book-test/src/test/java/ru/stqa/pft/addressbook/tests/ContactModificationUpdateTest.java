package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationUpdateTest extends TestBase{

    @Test
    public void testContactUpdate() {
        applicationManager.getContactHelper().editContact();
        applicationManager.getContactHelper().fillContactInfo(new ContactData("Ivan", "Groznie", "Skynet", "Moscow","777777777"));
        applicationManager.getContactHelper().updateContact();
       // applicationManager.getContactHelper().returnHomeContact();
    }
}
