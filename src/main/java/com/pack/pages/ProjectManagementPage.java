package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectManagementPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'Project Management')]")
    WebElement ProjectManagement;

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'Project List')]")
    WebElement ProjectListLabel;


    public ProjectManagementPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateProjectManagementPageTitle(){
        return driver.getTitle();
    }

    public ProjectManagementPage clickOnProjectManagementPageLink(){
        ProjectManagement.click();
        return new ProjectManagementPage();
    }

    public boolean verifyProjectListLabel(){
        return ProjectListLabel.isDisplayed();
    }
}
