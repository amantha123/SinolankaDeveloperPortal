package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import com.pack.pages.PermissionPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PermissionPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    PermissionPage permissionPage;

    public PermissionPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        permissionPage = new PermissionPage();
    }

    @Test(priority=1)
    public void permissionPageTitleTest(){
        String title = permissionPage.validatePermissionPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void verifyNavigatingPermissionPageTest(){
        permissionPage.clickOnPermissionPageLink();
    }

    @Test(priority = 3)
    public void verifyPermissionPageTest(){
        permissionPage.verifyPermissionLabel();
        permissionPage.verifyReferenceNo();
        permissionPage.verifyName();
        permissionPage.verifySearchBtn();
    }

    @Test(priority = 4)
    public void verifyFilteringPermissionPageByReferenceNoTest(){
        permissionPage.clickOnPermissionPageLink();
        permissionPage.verifyFilteringPermissionPageByReferenceNo();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


