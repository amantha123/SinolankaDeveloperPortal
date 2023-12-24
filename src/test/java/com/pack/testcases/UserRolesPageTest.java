package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import com.pack.pages.UserRolesPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserRolesPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserRolesPage userRolesPage;

    public UserRolesPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        userRolesPage = new UserRolesPage();
    }

    @Test(priority = 1)
    public void usersRolesPageTitleTest(){
        String title = userRolesPage.validateUserRolesPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void navigateUserRolesPageTest(){
        userRolesPage.clickOnUserRolesPageLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
