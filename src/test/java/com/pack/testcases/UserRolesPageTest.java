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

    @Test(priority=1)
    public void UserRolesPageTitleTest(){
        String title = userRolesPage.validateUserRolesPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void navigateUserRolesPageTest(){
        userRolesPage.clickOnUserRolesPageLink();
    }

    @Test(priority = 3)
    public void verifyUserRolesPageTest(){
        userRolesPage.clickOnUserRolesPageLink();
        userRolesPage.verifyUserRolesLabel();
        userRolesPage.verifyAddPermissionRolesBtn();
        userRolesPage.verifyNameField();
    }

    @Test(priority = 4)
    public void verifyMandatoryFieldsAddPermissionRolesTest(){
        userRolesPage.clickOnUserRolesPageLink();
        userRolesPage.verifyMandatoryFieldsAddPermissionRoles();
    }

    @Test(priority = 5)
    public void verifyAddingUserRoleTest() throws InterruptedException{
        userRolesPage.clickOnUserRolesPageLink();
        userRolesPage.verifyAddingPermissionRoles();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void verifyFilteringUserRolesPageByNameTest() throws InterruptedException{
        userRolesPage.clickOnUserRolesPageLink();
        userRolesPage.verifyFilteringUserRolesPageByName();
        Thread.sleep(2000);
    }

  /*  @Test(priority = 7)
    public void verifyEditingUserRolesTest(){
        userRolesPage.clickOnUserRolesPageLink();
        userRolesPage.verifyEditingUserRoles();
    }*/

    @Test(priority = 8)
    public void verifyViewingUserRolesDetailsTest(){
        userRolesPage.clickOnUserRolesPageLink();
        userRolesPage.verifyViewingUserRolesDetails();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
