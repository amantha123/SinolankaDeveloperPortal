package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.CustomerManagementPage;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerManagementPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerManagementPage customerManagementPage;

    public CustomerManagementPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        customerManagementPage = new CustomerManagementPage();
    }

    @Test(priority=1)
    public void verifyCustomerManagementPageTitleTest(){
        String title = customerManagementPage.validateCustomerManagementPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void navigateCustomerManagementPageTest(){
        customerManagementPage.clickOnCustomerManagementPageLink();
    }

    @Test(priority = 3)
    public void verifyCustomerManagementPageTest(){
        customerManagementPage.clickOnCustomerManagementPageLink();
        customerManagementPage.verifyCustomerListLabel();
        customerManagementPage.verifyAddCustomerBtn();
        customerManagementPage.verifyName();
        customerManagementPage.verifyContactNo();
        customerManagementPage.verifyEmail();
    }

    @Test(priority = 4)
    public void verifyMandatoryFieldsTest(){
        customerManagementPage.clickOnCustomerManagementPageLink();
        customerManagementPage.verifyMandatoryFields();
    }

    @Test(priority = 5)
    public void verifyAddingCustomersTest() throws InterruptedException{
        customerManagementPage.clickOnCustomerManagementPageLink();
        customerManagementPage.verifyAddingCustomers();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void verifyFilteringCustomerListByNameTest() throws InterruptedException{
        customerManagementPage.clickOnCustomerManagementPageLink();
        customerManagementPage.verifyFilteringCustomerListByName();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void verifyFilteringCustomersListByContactNoTest() throws InterruptedException{
        customerManagementPage.clickOnCustomerManagementPageLink();
        customerManagementPage.verifyFilteringCustomersListByContactNo();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void verifyFilteringCustomersListByEmailTest() throws InterruptedException{
        customerManagementPage.clickOnCustomerManagementPageLink();
        customerManagementPage.verifyFilteringCustomersListByEmail();
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void verifyEditingCustomerDetailsTest() throws InterruptedException{
        customerManagementPage.clickOnCustomerManagementPageLink();
        customerManagementPage.verifyEditingCustomerDetails();
    }

    @Test(priority = 10)
    public void verifyViewingCustomerDetailsTest() throws InterruptedException{
        customerManagementPage.clickOnCustomerManagementPageLink();
        customerManagementPage.verifyViewingCustomerDetails();
    }

    @Test(priority = 11)
    public void verifyDeletingCustomersTest() throws InterruptedException{
        customerManagementPage.clickOnCustomerManagementPageLink();
        customerManagementPage.verifyDeletingCustomers();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
