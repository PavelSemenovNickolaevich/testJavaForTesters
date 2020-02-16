package ru.stqa.pft.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void logoutContact() {
        clickContact(By.linkText("Logout"));
    }

    public void fillContactInfo(ContactData contactData) {
        typeContact(By.name("firstname"), contactData.getFirstname());
        typeContact(By.name("middlename"), contactData.getMiddlename());
        wd.findElement(By.name("company")).click();
        typeContact(By.name("company"), contactData.getCompany());
        wd.findElement(By.name("theform")).click();
        typeContact(By.name("address"), contactData.getAdress());
        typeContact(By.name("home"), contactData.getPhone());
    }

    public void returnHomeContact() {
        clickContact(By.linkText("home page"));
    }

    public void submitContact() {
        clickContact(By.xpath("(//input[@name='submit'])[2]"));
    }

}