package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerManagementPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'Customer Management')]")
    WebElement CustomerManagement;

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'Customer List')]")
    WebElement CustomerList;

    @FindBy(xpath = "//a[@class='btn btn-primary text-decoration-none'][contains(.,'+ Add Customer')]")
    WebElement AddCustomerBtn;

    @FindBy(xpath = "(//input[contains(@class,'form-control ng-untouched ng-pristine ng-valid')])[1]")
    WebElement Name;

    @FindBy(xpath = "//input[contains(@mask,'0*')]")
    WebElement ContactNo;

    @FindBy(xpath = "//input[contains(@type,'email')]")
    WebElement Email;

    @FindBy(xpath = "//input[contains(@formcontrolname,'first_name')]")
    WebElement FirstNameField;

    @FindBy(xpath = "//input[contains(@formcontrolname,'last_name')]")
    WebElement LastNameField;

    @FindBy(xpath = "//input[contains(@id,'email')]")
    WebElement EmailField;

    @FindBy(xpath = "//input[contains(@id,'phone')]")
    WebElement ContactNoField;

    @FindBy(xpath = "//input[contains(@formcontrolname,'address')]")
    WebElement AddressField;

    @FindBy(xpath = "//input[contains(@id,'customFile')]")
    WebElement ChooseFileBtn;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Save')]")
    WebElement SaveBtn;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
    WebElement SearchBtn;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-customer/app-customer-list-view/div[3]/div/div/div/div[2]/div/div[1]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[4]/div/div/button[1]")
    WebElement EditIcon;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-customer/app-customer-list-view/div[3]/div/div/div/div[2]/div/div[1]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[4]/div/div/button[2]")
    WebElement ViewIcon;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Cancel')]")
    WebElement CancelBtn;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-customer/app-customer-list-view/div[3]/div/div/div/div[2]/div/div[1]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[4]/div/div/a")
    WebElement DeleteIcon;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Yes')]")
    WebElement YesBtn;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'First Name is required.')]")
    WebElement Validation;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Last Name is required.')]")
    WebElement Validation1;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Email required.')]")
    WebElement Validation2;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Contact Number is required.')]")
    WebElement Validation3;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Address is required.')]")
    WebElement Validation4;

    public CustomerManagementPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateCustomerManagementPageTitle(){
        return driver.getTitle();
    }

    public CustomerManagementPage clickOnCustomerManagementPageLink(){
        CustomerManagement.click();
        return new CustomerManagementPage();
    }

    public boolean verifyCustomerListLabel(){
        return CustomerList.isDisplayed();
    }

    public boolean verifyAddCustomerBtn(){
        return AddCustomerBtn.isDisplayed();
    }

    public boolean verifyName(){
        return Name.isDisplayed();
    }

    public boolean verifyContactNo(){
        return ContactNo.isDisplayed();
    }

    public boolean verifyEmail(){
        return Email.isDisplayed();
    }

    public void verifyMandatoryFields(){
        AddCustomerBtn.click();

        FirstNameField.click();
        FirstNameField.sendKeys(Keys.TAB);
        Validation.isDisplayed();

        LastNameField.click();
        LastNameField.sendKeys(Keys.TAB);
        Validation1.isDisplayed();

        EmailField.click();
        EmailField.sendKeys(Keys.TAB);
        Validation2.isDisplayed();

        ContactNoField.click();
        ContactNoField.sendKeys(Keys.TAB);
        Validation3.isDisplayed();

        AddressField.click();
        AddressField.sendKeys(Keys.TAB);
        Validation4.isDisplayed();
    }

    public void verifyAddingCustomers() {
        AddCustomerBtn.click();

        FirstNameField.click();
        FirstNameField.sendKeys("Amantha");

        LastNameField.click();
        LastNameField.sendKeys("Gunawardena");

        EmailField.click();
        EmailField.sendKeys("amantha.gunawardena@veracitygp.com");

        ContactNoField.click();
        ContactNoField.sendKeys("774848813");

        AddressField.click();
        AddressField.sendKeys("Galle");

        SaveBtn.click();
    }

    public void verifyFilteringCustomerListByName(){
        Name.click();
        Name.sendKeys("Amantha Gunawardena");
        SearchBtn.click();
    }

    public void verifyFilteringCustomersListByContactNo(){
        ContactNo.click();
        ContactNo.sendKeys("774848813");
        SearchBtn.click();
    }

    public void verifyFilteringCustomersListByEmail(){
        Email.click();
        Email.sendKeys("amantha.gunawardena@veracitygp.com");
        SearchBtn.click();
    }

    public void verifyEditingCustomerDetails(){
        EditIcon.click();
        SaveBtn.click();
    }

    public void verifyViewingCustomerDetails(){
        ViewIcon.click();
        CancelBtn.click();
    }

    public void verifyDeletingCustomers(){
        DeleteIcon.click();
        YesBtn.click();
    }
}
