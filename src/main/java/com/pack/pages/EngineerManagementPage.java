package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EngineerManagementPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'Engineer Management')]")
    WebElement EngineerManagement;

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'Engineer List')]")
    WebElement EngineerList;

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
}
