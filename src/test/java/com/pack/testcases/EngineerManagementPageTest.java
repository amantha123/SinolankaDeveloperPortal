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
        engineerManagementPage.verifyAddEngineerBtn();
        engineerManagementPage.verifyName();
        engineerManagementPage.verifyContactNo();
        engineerManagementPage.verifyEmail();
    }

    @Test(priority = 4)
    public void verifyMandatoryFieldsTest(){
        engineerManagementPage.clickOnEngineerManagementPageLink();
        engineerManagementPage.verifyMandatoryFields();
    }

    @Test(priority = 5)
    public void verifyAddingEngineerTest() throws InterruptedException{
        engineerManagementPage.clickOnEngineerManagementPageLink();
        engineerManagementPage.verifyAddingEngineer();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void verifyFilteringEngineersByNameTest(){
        engineerManagementPage.clickOnEngineerManagementPageLink();
        engineerManagementPage.verifyFilteringEngineersByName();
    }

    @Test(priority = 7)
    public void verifyFilteringEngineersByContactNoTest(){
        engineerManagementPage.clickOnEngineerManagementPageLink();
        engineerManagementPage.verifyFilteringEngineersByContactNo();
    }

    @Test(priority = 8)
    public void verifyFilteringEngineersByEmailTest(){
        engineerManagementPage.clickOnEngineerManagementPageLink();
        engineerManagementPage.verifyFilteringEngineersByEmail();
    }

    @Test(priority = 9)
    public void verifyEditingEngineerDetailsTest(){
        engineerManagementPage.clickOnEngineerManagementPageLink();
        engineerManagementPage.verifyEditingEngineerDetails();
    }

    @Test(priority = 10)
    public void verifyViewingEngineerDetailsTest(){
        engineerManagementPage.clickOnEngineerManagementPageLink();
        engineerManagementPage.verifyViewingEngineerDetails();
    }

    @Test(priority = 11)
    public void verifyDeletingEngineersTest(){
        engineerManagementPage.clickOnEngineerManagementPageLink();
        engineerManagementPage.verifyDeletingEngineers();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
