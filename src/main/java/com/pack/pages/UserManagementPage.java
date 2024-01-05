package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'User Management')]")
    WebElement UserManagement;

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
}
