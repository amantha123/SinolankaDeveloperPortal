package com.pack.pages;

import com.pack.base.TestBase;
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
}
