package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'User Management')]")
    WebElement UserManagement;

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'User List')]")
    WebElement UserListLabel;

    @FindBy(xpath = "//a[@href='/users/add']")
    WebElement AddUserBtn;

    @FindBy(xpath = "//input[contains(@type,'text')]")
    WebElement Name;

    @FindBy(xpath = "//input[contains(@mask,'0*')]")
    WebElement ContactNo;

    @FindBy(xpath = "//input[contains(@type,'email')]")
    WebElement Email;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
    WebElement SearchBtn;

    public UserManagementPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateUserManagementPageTitle(){
        return driver.getTitle();
    }

    public UserManagementPage clickOnUserManagementPageLink(){
        UserManagement.click();
        return new UserManagementPage();
    }

    public boolean verifyUserListLabel(){
        return UserListLabel.isDisplayed();
    }

    public boolean verifyAddUserBtn(){
        return AddUserBtn.isDisplayed();
    }

    public boolean verifyNameField(){
        return Name.isDisplayed();
    }

    public boolean verifyContactNoField(){
        return ContactNo.isDisplayed();
    }

    public boolean verifyEmailField(){
        return Email.isDisplayed();
    }

    public void verifyFilteringUserListByName(){
        Name.click();
        Name.sendKeys("Amantha Gunawardena");
        SearchBtn.click();
    }
}
