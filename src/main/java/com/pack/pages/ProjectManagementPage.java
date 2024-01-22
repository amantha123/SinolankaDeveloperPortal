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

    @FindBy(xpath = "//a[@href='/project/init/add']")
    WebElement AddProjectBtn;

    @FindBy(xpath = "//input[contains(@formcontrolname,'name')]")
    WebElement ProjectName;

    @FindBy(xpath = "//input[contains(@autocomplete,'acbf7ae03725')]")
    WebElement Type;

    @FindBy(xpath = "//input[contains(@autocomplete,'ac5bf6141529')]")
    WebElement Customer;

    @FindBy(xpath = "//input[contains(@formcontrolname,'from_date')]")
    WebElement FromDate;

    @FindBy(xpath = "//input[contains(@formcontrolname,'to_date')]")
    WebElement ToDate;

    @FindBy(xpath = "//input[contains(@mask,'0*')]")
    WebElement Reference;

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

    public boolean verifyAddProjectBtn(){
        return AddProjectBtn.isDisplayed();
    }

    public boolean verifyProjectName(){
        return ProjectName.isDisplayed();
    }

    public  boolean verifyTypes(){
        return Type.isDisplayed();
    }

    public boolean verifyCustomer(){
        return Customer.isDisplayed();
    }

    public boolean verifyFromDate(){
        return FromDate.isDisplayed();
    }

    public boolean verifyToDate(){
        return ToDate.isDisplayed();
    }

    public boolean verifyReference(){
        return Reference.isDisplayed();
    }
}
