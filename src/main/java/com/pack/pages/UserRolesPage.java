package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRolesPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'User Roles')]")
    WebElement UserRoles;

    @FindBy(xpath = "//input[contains(@type,'text')]")
    WebElement Name;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
    WebElement SearchBtn;

    @FindBy(xpath = "//span[@title='Admin'][contains(.,'Admin')]")
    WebElement SearchResult;

    @FindBy(xpath = "//a[contains(@id,'addButton')]")
    WebElement AddUserRoles;

    @FindBy(xpath = "//input[contains(@id,'name')]")
    WebElement RoleName;

    @FindBy(xpath = "//input[contains(@id,'description')]")
    WebElement Description;

    @FindBy(xpath = "//div[contains(@role,'combobox')]")
    WebElement Permissions;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Save')]")
    WebElement SaveBtn;

    @FindBy(xpath = "//span[@class='ng-option-label'][contains(.,'admin.permission.list')]")
    WebElement PermissionsOption;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Name is required.')]")
    WebElement Validation;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Description is required.')]")
    WebElement Validation1;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'permissions is required.')]")
    WebElement Validation2;

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

    public boolean verifyNameField(){
        return Name.isDisplayed();
    }

    public void filterUserRolesPageByName(String name){
        UserRoles.click();
        Name.click();
        Name.sendKeys(name);
        SearchBtn.click();
        SearchResult.isDisplayed();
    }

    public boolean verifyAddUserRolesBtn(){
        return AddUserRoles.isDisplayed();
    }

    public void verifyMandatoryFields(){
        AddUserRoles.click();
        RoleName.click();
        RoleName.sendKeys(Keys.TAB);
        Validation.isDisplayed();
        Description.click();
        Description.sendKeys(Keys.TAB);
        Validation1.isDisplayed();
        Permissions.click();
        Permissions.click();
        Validation2.isDisplayed();
    }

    public void verifyAddingUserRoles(String rolename, String description){
        AddUserRoles.click();
        RoleName.click();
        RoleName.sendKeys(rolename);
        Description.click();
        Description.sendKeys(description);
        Permissions.click();
        PermissionsOption.click();
        SaveBtn.click();
    }
}
