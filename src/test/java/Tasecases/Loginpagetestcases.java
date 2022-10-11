package Tasecases;

import Base.Testbase;
import Pages.Homepage;
import Pages.Loginpage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginpagetestcases extends Testbase {

    Loginpage lpage;
    Homepage hpage;

    public Loginpagetestcases(){
        super();
    }

    @BeforeMethod
    public void Setup(){
        Initilasation();
        lpage=new Loginpage();
    }

    @Test
    public void Logintest(){
        lpage.Login((prop.getProperty("username")),prop.getProperty("password"));
    }

    @AfterMethod
    public void Teardown(){
        driver.quit();
    }


}
