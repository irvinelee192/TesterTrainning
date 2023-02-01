package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TC01VerifyLoginPage extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    public void Login(String url,String userName,String password) {
        loginPage = new LoginPage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
        loginPage.navigateToLogin(url);
        Assert.assertTrue(loginPage.verifyLoginPage());
        loginPage.sendkeyLogin(userName, password);
        Assert.assertTrue(dashboardPage.verifyDashboard());
        driver.quit();
    }

    @Test
    public void testCase01 () {
        Login("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", "Admin", "admin123");
    }

}
