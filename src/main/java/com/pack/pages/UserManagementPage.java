package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

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

    @FindBy(xpath = "//input[contains(@id,'call_name')]")
    WebElement FirstName;

    @FindBy(xpath = "//input[contains(@id,'last_name')]")
    WebElement LastName;

    @FindBy(xpath = "//input[contains(@id,'email')]")
    WebElement Emails;

    @FindBy(xpath = "//input[contains(@id,'mobile')]")
    WebElement Mobile;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'First Name is required.')]")
    WebElement Validation;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Last Name is required.')]")
    WebElement Validation1;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Email is required.')]")
    WebElement Validation2;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Contact Number is required.')]")
    WebElement Validation3;

    @FindBy(xpath = "//span[contains(.,'Amantha Gunawardena')]")
    WebElement SearchResult;

    @FindBy(xpath = "//span[@title='+94774848813'][contains(.,'+94774848813')]")
    WebElement SearchResult1;

    @FindBy(xpath = "//span[@title='amantha.gunawardena@veracitygp.com'][contains(.,'amantha.gunawardena@veracitygp.com')]")
    WebElement SearchResult2;

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

    public boolean verifySearchBtn(){
        return SearchBtn.isDisplayed();
    }

    public void verifyFilteringUserListByName(String name){
        Name.click();
        Name.sendKeys(name);
        SearchBtn.click();
        SearchResult.isDisplayed();
    }

    public void verifyFilteringUserListByContactNo(String contactno){
        ContactNo.click();
        ContactNo.sendKeys(contactno);
        SearchBtn.click();
        SearchResult1.isDisplayed();
    }

    public void verifyFilteringUserListByEmail(String email){
        Email.click();
        Email.sendKeys(email);
        SearchBtn.click();
        SearchResult2.isDisplayed();
    }

    public void verifyMandatoryFields(){
        AddUserBtn.click();
        FirstName.click();
        FirstName.sendKeys(Keys.TAB);
        Validation.isDisplayed();
        LastName.click();
        LastName.sendKeys(Keys.TAB);
        Validation1.isDisplayed();
        Emails.click();
        Emails.sendKeys(Keys.TAB);
        Validation2.isDisplayed();
        Mobile.click();
        Mobile.sendKeys(Keys.TAB);
        Validation3.isDisplayed();
    }
}
