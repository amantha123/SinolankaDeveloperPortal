package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterDataManagementPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'Master Data Management')]")
    WebElement MasterDataManagement;

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'Master Device List')]")
    WebElement MasterDeviceListLabel;

    @FindBy(xpath = "//a[@href='/master-data/add']")
    WebElement AddDeviceBtn;

    @FindBy(xpath = "//input[contains(@id,'model')]")
    WebElement ModelField;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-master-data/app-master-data-list-form/form/div/div[1]/div[1]/div/div/div[3]/div/div[2]/div/div[3]/ng-select/div")
    WebElement Brand;

    @FindBy(xpath = "//input[contains(@id,'manufactur_name')]")
    WebElement ManufacturerName;

    @FindBy(xpath = "//input[contains(@id,'description')]")
    WebElement Description;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Model is required.')]")
    WebElement Validation;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Brand is required.')]")
    WebElement Validation1;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Description is required.')]")
    WebElement Validation2;

    @FindBy(xpath = "//p[@class='text-danger'][contains(.,'Manufacturer’s Name is required.')]")
    WebElement Validation3;

    public MasterDataManagementPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateMasterDataManagementPageTitle(){
        return driver.getTitle();
    }

    public MasterDataManagementPage clickOnMasterDataManagementPageLink(){
        MasterDataManagement.click();
        return new MasterDataManagementPage();
    }

    public boolean verifyMasterDeviceListLabel(){
        return MasterDeviceListLabel.isDisplayed();
    }

    public boolean verifyAddDeviceBtn(){
        return AddDeviceBtn.isDisplayed();
    }

    public void verifyMandatoryFields(){
        AddDeviceBtn.click();
        ModelField.click();
        ModelField.sendKeys(Keys.TAB);
        Validation.isDisplayed();

        Description.click();
        Description.sendKeys(Keys.TAB);
        Validation2.isDisplayed();

        ManufacturerName.click();
        ManufacturerName.sendKeys(Keys.TAB);
        Validation3.isDisplayed();
    }
}
