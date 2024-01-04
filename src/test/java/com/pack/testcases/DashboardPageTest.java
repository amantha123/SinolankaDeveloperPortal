package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    public DashboardPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority=1)
    public void dashboardPageTitleTest(){
        String title = dashboardPage.validateDashboardPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority=2)
    public void verifyWelcomeDashboardLabelTest(){
        dashboardPage.verifyWelcomeDashboardLabel();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
