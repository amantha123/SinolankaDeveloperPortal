package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class EngineerManagementPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'Engineer Management')]")
    WebElement EngineerManagement;

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'Engineer List')]")
    WebElement EngineerList;

    @FindBy(xpath = "//a[@class='btn btn-primary text-decoration-none'][contains(.,'+ Add Engineer')]")
    WebElement AddEngineerBtn;

    @FindBy(xpath = "//input[contains(@type,'text')]")
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
    WebElement ContactNumberField;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Save')]")
    WebElement SaveBtn;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
    WebElement Search;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-engineer/app-engineer-list-view/div[3]/div/div/div/div[2]/div/div[1]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[4]/div/div/button[1]/svg")
    WebElement EditIcon;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'First Name is required.')]")
    WebElement Validation;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Last Name is required.')]")
    WebElement Validation1;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Email required.')]")
    WebElement Validation2;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Contact Number is required.')]")
    WebElement Validation3;

    public EngineerManagementPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateEngineerManagementPageTitle(){
        return driver.getTitle();
    }

    public EngineerManagementPage clickOnEngineerManagementPageLink(){
        EngineerManagement.click();
        return new EngineerManagementPage();
    }

    public boolean verifyEngineerListLabel(){
        return EngineerList.isDisplayed();
    }

    public boolean verifyAddEngineerBtn(){
        return AddEngineerBtn.isDisplayed();
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
        AddEngineerBtn.click();
        FirstNameField.click();
        FirstNameField.sendKeys(Keys.TAB);
        Validation.isDisplayed();

        LastNameField.click();
        LastNameField.sendKeys(Keys.TAB);
        Validation1.isDisplayed();

        EmailField.click();
        EmailField.sendKeys(Keys.TAB);
        Validation2.isDisplayed();

        ContactNumberField.click();
        ContactNumberField.sendKeys(Keys.TAB);
        Validation3.click();
    }

    public void verifyAddingEngineer(){
        AddEngineerBtn.click();
        FirstNameField.click();
        FirstNameField.sendKeys("Amantha");

        LastNameField.click();
        LastNameField.sendKeys("Gunawardena");

        EmailField.click();
        EmailField.sendKeys("amantha.gunawardena@veracitygp.com");

        ContactNumberField.click();
        ContactNumberField.sendKeys("774848813");

        SaveBtn.click();
    }

    public void verifyFilteringEngineersByName(){
        Name.click();
        Name.sendKeys("Amantha Gunawardena");
        Search.click();
    }

    public void verifyFilteringEngineersByContactNo(){
        ContactNo.click();
        ContactNo.sendKeys("774848813");
        Search.click();
    }

    public void verifyFilteringEngineersByEmail(){
        Email.click();
        Email.sendKeys("amantha.gunawardena@veracitygp.com");
        Search.click();
    }
}
