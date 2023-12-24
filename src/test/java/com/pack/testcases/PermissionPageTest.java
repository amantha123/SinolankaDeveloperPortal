package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import com.pack.pages.PermissionPage;
import com.pack.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PermissionPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    PermissionPage permissionPage;

    String sheetName = "Permission";

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

    @Test(priority = 1)
    public void permissionPageTitleTest(){
        String title = permissionPage.validatePermissionPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void navigatePermissionPageTest(){
        permissionPage.clickOnPermissionPageLink();
    }

    @Test(priority = 3)
    public void verifyReferenceNoFieldTest(){
        permissionPage.clickOnPermissionPageLink();
        permissionPage.verifyReferenceNoField();
    }

    @DataProvider
    public Object[][] getTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return new Object[][] {
                {"1"},
        };
    }

    @Test(priority = 4, dataProvider = "getTestData")
    public void filterPermissionPageByReferenceNoTest(String referenceno){
        permissionPage.clickOnPermissionPageLink();
        permissionPage.filterPermissionPageByReferenceNo(referenceno);
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
    public void verifyStatusFieldTest(){
        permissionPage.clickOnPermissionPageLink();
        permissionPage.verifyStatusField();
    }

    @Test(priority = 6)
    public void filterPermissionPageByStatusAllTest(){
        permissionPage.clickOnPermissionPageLink();
        permissionPage.filterPermissionPageByStatusAll();
    }

    @Test(priority = 7)
    public void filterPermissionPageByStatusActiveTest(){
        permissionPage.clickOnPermissionPageLink();
        permissionPage.filterPermissionPageByStatusActive();
    }

    @Test(priority = 8)
    public void filterPermissionPageByStatusInactiveTest(){
        permissionPage.clickOnPermissionPageLink();
        permissionPage.filterPermissionPageByStatusInactive();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
