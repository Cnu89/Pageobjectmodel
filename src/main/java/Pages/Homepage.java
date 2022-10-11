package Pages;

import Base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Testbase {

    @FindBy(xpath = "//span[text()='Contacts']")
    WebElement conactslink;
    public Homepage(){
        PageFactory.initElements(driver,this);
    }

    public Contactspage Clickoncontactslink(){
        conactslink.click();
        return new Contactspage();
    }

}
