package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.EngineerManagementPage;
import com.pack.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EngineerManagementPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    EngineerManagementPage engineerManagementPage;

    public EngineerManagementPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        engineerManagementPage = new EngineerManagementPage();
    }

    @Test(priority=1)
    public void verifyEngineerManagementPageTitleTest(){
        String title = engineerManagementPage.validateEngineerManagementPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void navigateEngineerManagementPageTest(){
        engineerManagementPage.clickOnEngineerManagementPageLink();
    }

    @Test(priority = 3)
    public void verifyEngineerManagementPageTest(){
        engineerManagementPage.clickOnEngineerManagementPageLink();
        engineerManagementPage.verifyEngineerListLabel();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
