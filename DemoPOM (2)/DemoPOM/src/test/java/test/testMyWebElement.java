package test;

import core.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import lib.myWebElement;

public class testMyWebElement extends BaseTest {
    @Test
    public void TC_02() {

        WebDriver driver = getDriver();
        driver.get("https://google.com");
        myWebElement searchBox = new myWebElement(driver,"//input[@name='q']");
        searchBox.withDuration(5).waitUntilClickAble().click();
        searchBox.sendKeys("Selenium with Java");

        myWebElement searchButton = new myWebElement(driver, "(//input[@class='gNO89b'])[1]");
        searchButton.withDuration(5).waitUntilClickAble().click();

    }

}
