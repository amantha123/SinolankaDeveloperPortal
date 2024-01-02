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

    @DataProvider
    public Object[][] getTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return new Object[][] {
                {"Amantha Gunawardena"},
        };
    }

    @Test(priority = 4, dataProvider = "getTestData")
    public void verifyFilteringUserListByNameTest(String name){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyFilteringUserListByName(name);
    }

    @DataProvider
    public Object[][] getTestData1(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return new Object[][] {
                {"774848813"},
        };
    }

    @Test(priority = 5, dataProvider = "getTestData1")
    public void verifyFilteringUserListByContactNoTest(String contactno){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyFilteringUserListByContactNo(contactno);

    }

    @DataProvider
    public Object[][] getTestData2(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return new Object[][] {
                {"amantha.gunawardena@veracitygp.com"},
        };
    }

    @Test(priority = 6, dataProvider = "getTestData2")
    public void verifyFilteringUserListByEmailTest(String email){
        userManagementPage.clickOnUserManagementPageLink();
        userManagementPage.verifyFilteringUserListByEmail(email);
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
