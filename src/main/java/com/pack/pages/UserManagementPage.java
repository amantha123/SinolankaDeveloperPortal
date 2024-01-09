package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.View;
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
    WebElement EmailField;

    @FindBy(xpath = "//input[contains(@id,'mobile')]")
    WebElement Mobile;

    @FindBy(xpath = "//div[contains(@role,'combobox')]")
    WebElement UserRoles;

    @FindBy(xpath = "//span[@class='ng-option-label'][contains(.,'Testing Role')]")
    WebElement UserRolesOption;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Save')]")
    WebElement SaveBtn;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-visit-request/app-visit-req-list/div[3]/div/div/div/div[2]/div/div[1]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div/div/a[1]")
    WebElement EditIcon;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-visit-request/app-visit-req-list/div[3]/div/div/div/div[2]/div/div[1]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div/div/a[2]")
    WebElement ViewIcon;

    @FindBy(xpath = "//a[@routerlink='/users'][contains(.,'Cancel')]")
    WebElement CancelBtn;

    @FindBy(xpath = "//input[contains(@class,'checkbox form-check-input ng-untouched ng-pristine ng-valid')]")
    WebElement ToggleBtn;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-visit-request/app-visit-req-list/div[3]/div/div/div/div[2]/div/div[1]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div/div/a[3]")
    WebElement PasswordResetIcon;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Yes')]")
    WebElement Yes;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-visit-request/app-visit-req-list/div[3]/div/div/div/div[2]/div/div[1]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div/div/a[4]")
    WebElement DeleteIcon;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Delete')]")
    WebElement DeleteBtn;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'First Name is required.')]")
    WebElement Validation;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Last Name is required.')]")
    WebElement Validation1;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Email is required.')]")
    WebElement Validation2;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Contact Number is required.')]")
    WebElement Validation3;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'User role is required.')]")
    WebElement Validation4;

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

    public void verifyFilteringUserListByContactNo(){
        ContactNo.click();
        ContactNo.sendKeys("774848813");
        SearchBtn.click();
    }

    public void verifyFilteringUserListByEmail(){
        Email.click();
        Email.sendKeys("amantha.gunawardena@veracitygp.com");
        SearchBtn.click();
    }

    public void verifyMandatoryFields(){
        AddUserBtn.click();
        FirstName.click();
        FirstName.sendKeys(Keys.TAB);
        Validation.isDisplayed();

        LastName.click();
        LastName.sendKeys(Keys.TAB);
        Validation1.isDisplayed();

        EmailField.click();
        EmailField.sendKeys(Keys.TAB);
        Validation2.isDisplayed();

        Mobile.click();
        Mobile.sendKeys(Keys.TAB);
        Validation3.isDisplayed();

        UserRoles.click();
        UserRoles.click();
        Validation4.isDisplayed();
    }

    public void verifyAddingUser(){
        AddUserBtn.click();
        FirstName.click();
        FirstName.sendKeys("Amantha");
        LastName.click();
        LastName.sendKeys("Gunawardena");
        EmailField.click();
        EmailField.sendKeys("amanthag1@gmail.com");
        Mobile.click();
        Mobile.sendKeys("779590981");
        UserRoles.click();
        UserRolesOption.click();
        SaveBtn.click();
    }

    public void verifyEditingUser(){
        EditIcon.click();
        SaveBtn.click();
    }

    public void verifyViewingUserDetails(){
        ViewIcon.click();
        CancelBtn.click();
    }

    public void verifyInactivatingUser(){
        ToggleBtn.click();
    }

    public void verifyActivatingUser(){
        ToggleBtn.click();
    }

    public void verifyResettingUserPassword(){
        PasswordResetIcon.click();
        Yes.click();
    }

    public void verifyDeletingUser(){
        DeleteIcon.click();
        DeleteBtn.click();
    }


}
