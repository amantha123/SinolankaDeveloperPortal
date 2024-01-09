package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import com.pack.pages.MasterDataManagementPage;
import com.pack.pages.UserManagementPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MasterDataManagementPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    MasterDataManagementPage masterDataManagementPage;

    public MasterDataManagementPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        masterDataManagementPage = new MasterDataManagementPage();
    }

    @Test(priority=1)
    public void UserRolesPageTitleTest(){
        String title = masterDataManagementPage.validateMasterDataManagementPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void navigateMasterDataManagementPageTest(){
        masterDataManagementPage.clickOnMasterDataManagementPageLink();
    }

    @Test(priority = 3)
    public void verifyMasterDataManagementPageTest(){
       masterDataManagementPage.clickOnMasterDataManagementPageLink();
       masterDataManagementPage.verifyMasterDeviceListLabel();
       masterDataManagementPage.verifyAddDeviceBtn();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
