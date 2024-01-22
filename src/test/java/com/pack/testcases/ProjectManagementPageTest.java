package com.pack.testcases;

import com.pack.base.TestBase;
import com.pack.pages.DashboardPage;
import com.pack.pages.LoginPage;
import com.pack.pages.ProjectManagementPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectManagementPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectManagementPage projectManagementPage;

    public ProjectManagementPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        projectManagementPage = new ProjectManagementPage();
    }

    @Test(priority=1)
    public void verifyProjectManagementPageTitleTest(){
        String title = projectManagementPage.validateProjectManagementPageTitle();
        Assert.assertEquals(title, "SLPG APP - Admin");
    }

    @Test(priority = 2)
    public void navigateProjectManagementPageTest(){
        projectManagementPage.clickOnProjectManagementPageLink();
    }

    @Test(priority = 3)
    public void verifyProjectManagementPageTest(){
        projectManagementPage.clickOnProjectManagementPageLink();
        projectManagementPage.verifyProjectListLabel();
        projectManagementPage.verifyAddProjectBtn();
        projectManagementPage.verifyProjectName();
        projectManagementPage.verifyTypes();
        projectManagementPage.verifyCustomer();
        projectManagementPage.verifyFromDate();
        projectManagementPage.verifyToDate();
        projectManagementPage.verifyReference();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
