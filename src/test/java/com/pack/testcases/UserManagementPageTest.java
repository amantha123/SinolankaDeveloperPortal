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

    @Test(priority = 3)
    public void verifyUserManagementPageTest(){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyUserListLabel();
        userManagementPage.verifyAddUserBtn();
        userManagementPage.verifyNameField();
        userManagementPage.verifyContactNoField();
        userManagementPage.verifyEmailField();
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
    public void verifyFilteringUserListByEmail(){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyFilteringUserListByEmail();
    }

    @Test(priority = 7)
    public void verifyMandatoryFieldsTest(){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyMandatoryFields();
    }

    @Test(priority = 8)
    public void verifyAddingUserTest() throws InterruptedException {
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyAddingUser();
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void verifyEditingUserTest() throws InterruptedException{
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyEditingUser();
        Thread.sleep(2000);
    }

    @Test(priority = 10)
    public void verifyViewingUserDetailsTest() throws InterruptedException{
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyViewingUserDetails();
        Thread.sleep(2000);
    }

    @Test(priority = 11)
    public void verifyInactivatingUserTest() throws InterruptedException{
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyInactivatingUser();
        Thread.sleep(2000);
    }

    @Test(priority = 12)
    public void verifyActivatingUserTest() throws InterruptedException{
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyActivatingUser();
        Thread.sleep(2000);
    }

    @Test(priority = 13)
    public void verifyResettingUserPasswordTest(){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyResettingUserPassword();
    }

    @Test(priority = 14)
    public void verifyDeletingUserTest() throws InterruptedException{
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyDeletingUser();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
