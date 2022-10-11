package Pages;

import Base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Testbase {

    @FindBy(xpath ="//a[text()='Login']")
    WebElement loginlink;
    //WebElement ele=driver.findElement(By.xpath("//a[text()='Login']"));
    @FindBy(xpath ="//input[@placeholder='E-mail address']")
    WebElement emailaddress;
    @FindBy(xpath ="//input[@placeholder='Password']")
    WebElement emailpassword;
    @FindBy(xpath ="//div[text()='Login']")
    WebElement loginbutton;

    public Loginpage(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public Homepage Login(String username,String password){
        loginlink.click();
        emailaddress.sendKeys(username);
        emailpassword.sendKeys(password);
        loginbutton.click();
        return new Homepage();
    }

}
