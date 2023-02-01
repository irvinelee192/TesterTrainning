package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
    private WebElement forgotPasswordButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLogin(String url) {
        getDriver().get(url);
    }

    public boolean verifyLoginPage() {
        getWait().until(ExpectedConditions.visibilityOf(userName));
        getWait().until(ExpectedConditions.visibilityOf(password));
        getWait().until(ExpectedConditions.visibilityOf(loginButton));
        getWait().until(ExpectedConditions.visibilityOf(forgotPasswordButton));
        return userName.isDisplayed() &&
                password.isDisplayed() &&
                loginButton.isDisplayed() &&
                forgotPasswordButton.isDisplayed();
    }
    public void sendkeyLogin (String u,String p) {
        userName.sendKeys(u);
        password.sendKeys(p);
        loginButton.click();
    }
}
