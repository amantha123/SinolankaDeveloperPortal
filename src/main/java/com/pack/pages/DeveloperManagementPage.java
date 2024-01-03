package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeveloperManagementPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'Developer Management')]")
    WebElement DeveloperManagement;

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'Developer List')]")
    WebElement DeveloperListLabel;

    @FindBy(xpath = "//a[@href='/developer/add']")
    WebElement AddDeveloper;

    @FindBy(xpath = "//input[contains(@type,'text')]")
    WebElement Name;

    @FindBy(xpath = "//input[contains(@mask,'0*')]")
    WebElement ContactNo;

    @FindBy(xpath = "//input[contains(@type,'email')]")
    WebElement Email;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
    WebElement SearchBtn;

    public DeveloperManagementPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateDeveloperManagementPageTitle(){
        return driver.getTitle();
    }

    public DeveloperManagementPage clickOnDeveloperManagementPageLink(){
        DeveloperManagement.click();
        return new DeveloperManagementPage();
    }

    public boolean verifyDeveloperListLabel(){
        return DeveloperListLabel.isDisplayed();
    }

    public boolean verifyAddDeveloperBtn(){
        return AddDeveloper.isDisplayed();
    }

    public boolean verifyNameField(){
        return  Name.isDisplayed();
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

    public void verifyFilteringDeveloperListPageByName(){
        Name.click();
        Name.sendKeys("Chamika Dilshanie");
        SearchBtn.click();
    }

    public void verifyFilteringDeveloperListPageByContactNo(){
        ContactNo.click();
        ContactNo.sendKeys("769897190");
        SearchBtn.click();
    }

    public void verifyFilteringDeveloperListPageByEmail(){
        Email.click();
        Email.sendKeys("chamika.dilshanie@veracitygp.com");
        SearchBtn.click();
    }
}
