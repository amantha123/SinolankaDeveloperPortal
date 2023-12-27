package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import com.pack.pages.UserRolesPage;
import com.pack.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRolesPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserRolesPage userRolesPage;

    String sheetName = "User Roles";

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

    @Test(priority = 3)
    public void verifyNameFieldTest(){
        userRolesPage.clickOnUserRolesPageLink();
        userRolesPage.verifyNameField();
    }

    @DataProvider
    public Object[][] getTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return new Object[][] {
                {"Admin"},
        };
    }

    @Test(priority = 4, dataProvider = "getTestData")
    public void filterUserRolesPageTest(String name){
        userRolesPage.clickOnUserRolesPageLink();
        userRolesPage.filterUserRolesPage(name);
        synchronized (this){
            try{
                this.wait(100);
                System.out.println("Thread in runnable state");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(priority = 5)
    public void verifyAddUserRolesBtnTest(){
        userRolesPage.clickOnUserRolesPageLink();
        userRolesPage.verifyAddUserRolesBtn();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
