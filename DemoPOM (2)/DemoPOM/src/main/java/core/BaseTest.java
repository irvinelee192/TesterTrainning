package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void before(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
    }

    @After
    public void after(){

        if (null !=driver){
            driver.close();
        }
    }

    public WebDriver getDriver() {
        driver = null;
        String broswer = System.getProperty("browser", "chrome");
        if (broswer.contains("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else
        if (broswer.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        return driver;
    }
}
