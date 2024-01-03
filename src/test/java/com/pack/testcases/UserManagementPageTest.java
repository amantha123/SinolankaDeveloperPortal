package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import com.pack.pages.UserManagementPage;
import com.pack.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserManagementPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserManagementPage userManagementPage;

    String sheetName = "User Management";

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

    @Test(priority = 1)
    public void verifyUserManagementPageTitleTest(){
        String userManagementPageTitle = userManagementPage.validateUserManagementPageTitle();
        Assert.assertEquals(userManagementPageTitle, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void navigateUserManagementPageTest(){
        userManagementPage.clickOnUserManagementPageLink();
    }

    @Test(priority = 3)
    public void verifyUserManagementPageTest(){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyUserListLabel();
        userManagementPage.verifyAddUserBtn();
        userManagementPage.verifyNameField();
        userManagementPage.verifyContactNoField();
        userManagementPage.verifyEmailField();
        userManagementPage.verifySearchBtn();
    }


    @Test(priority = 4)
    public void verifyFilteringUserListByNameTest(){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyFilteringUserListByName();
    }


    @Test(priority = 5)
    public void verifyFilteringUserListByContactNoTest(){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyFilteringUserListByContactNo();

    }

    @Test(priority = 6)
    public void verifyFilteringUserListByEmailTest(){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyFilteringUserListByEmail();
    }

    @Test(priority = 7)
    public void verifyMandatoryFieldsTest(){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyMandatoryFields();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
