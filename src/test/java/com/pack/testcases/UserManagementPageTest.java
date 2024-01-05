package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import com.pack.pages.UserManagementPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserManagementPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserManagementPage userManagementPage;

    public UserManagementPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        userManagementPage = new UserManagementPage();
    }

    @Test(priority=1)
    public void verifyUserManagementPageTitleTest(){
        String title = userManagementPage.validateUserManagementPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void navigateUserManagementPageTest(){
        userManagementPage.clickOnUserManagementPageLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
