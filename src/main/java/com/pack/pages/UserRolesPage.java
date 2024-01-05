package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRolesPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'User Roles')]")
    WebElement UserRoles;

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'User Roles')]")
    WebElement UserRolesLabel;

    @FindBy(xpath = "//a[contains(@id,'addButton')]")
    WebElement AddPermissionRolesBtn;

    @FindBy(xpath = "//input[contains(@type,'text')]")
    WebElement Name;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
    WebElement SearchBtn;

    @FindBy(xpath = "//input[contains(@formcontrolname,'name')]")
    WebElement RoleName;

    @FindBy(xpath = "//input[contains(@formcontrolname,'description')]")
    WebElement Description;

    @FindBy(xpath = "//div[contains(@role,'combobox')]")
    WebElement Permissions;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Name is required.')]")
    WebElement Validation1;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Description is required.')]")
    WebElement Validation2;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'permissions is required.')]")
    WebElement Validation3;

    public UserRolesPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateUserRolesPageTitle(){
        return driver.getTitle();
    }

    public UserRolesPage clickOnUserRolesPageLink(){
        UserRoles.click();
        return new UserRolesPage();
    }

    public boolean verifyUserRolesLabel(){
        return UserRolesLabel.isDisplayed();
    }

    public boolean verifyAddPermissionRolesBtn(){
        return AddPermissionRolesBtn.isDisplayed();
    }

    public boolean verifyNameField(){
        return Name.isDisplayed();
    }

    public void verifyFilteringUserRolesPageByName(){
        Name.click();
        Name.sendKeys("Testing Role");
        SearchBtn.click();
    }

    public void verifyMandatoryFieldsAddPermissionRoles(){
        AddPermissionRolesBtn.click();
        RoleName.click();
        RoleName.sendKeys(Keys.TAB);
        Validation1.isDisplayed();
        Description.click();
        Description.sendKeys(Keys.TAB);
        Validation2.isDisplayed();
        Permissions.click();
        Permissions.click();
        Validation3.isDisplayed();
    }
}
