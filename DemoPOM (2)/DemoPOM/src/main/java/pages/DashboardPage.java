package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboardTitle;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyDashboard () {
        getWait().until(ExpectedConditions.visibilityOf(dashboardTitle));
        return dashboardTitle.isDisplayed();
    }
}
