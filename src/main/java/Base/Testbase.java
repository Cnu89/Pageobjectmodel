package Base;

import Util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Testbase {
    public static Properties prop;
    public static WebDriver driver;
    public Testbase(){
        try {
            prop=new Properties();
            FileInputStream fs=new FileInputStream("src/main/java/Configuration/Config.properties");
            prop.load(fs);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void Initilasation(){
        String browsername=prop.getProperty("browser");
        if (browsername.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver_win32/chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if (browsername.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","");
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageloadtimeout));
        driver.get(prop.getProperty("url"));
    }
}
