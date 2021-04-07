package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationUpdateTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        // app.goTo().groupPage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData("Pave66l"
                    , "Ivanov"
                    , "skynet"
                    , "new-york"
                    , "111111111"));
        }
    }

    @Test(enabled = true)
    public void testContactUpdate() throws InterruptedException {
        Contacts before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData("Ivan"
                , "Groznie"
                , "Skynet"
                , "Moscow"
                , "77777777g7");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifyContact);
        before.add(contact);
//        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        after.sort(byId);
//        before.sort(byId);
//        Assert.assertEquals(after, before);
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    }
}
