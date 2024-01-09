package com.pack.pages;

import com.pack.base.TestBase;
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
}
