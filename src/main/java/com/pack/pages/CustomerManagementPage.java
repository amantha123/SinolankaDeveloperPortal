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
}
