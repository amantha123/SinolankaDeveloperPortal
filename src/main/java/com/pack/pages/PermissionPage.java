package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PermissionPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'Permission')]")
    WebElement Permission;

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'Permission')]")
    WebElement PermissionLabel;

    @FindBy(xpath = "//input[contains(@formcontrolname,'id')]")
    WebElement ReferenceNo;

    @FindBy(xpath = "//input[contains(@formcontrolname,'name')]")
    WebElement Name;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
    WebElement SearchBtn;

    public PermissionPage(){
        PageFactory.initElements(driver, this);
    }

    public String validatePermissionPageTitle(){
        return driver.getTitle();
    }

    public PermissionPage clickOnPermissionPageLink(){
        Permission.click();
        return new PermissionPage();
    }

    public boolean verifyPermissionLabel(){
        return PermissionLabel.isDisplayed();
    }

    public boolean verifyReferenceNo(){
        return ReferenceNo.isDisplayed();
    }

    public boolean verifyName(){
        return Name.isDisplayed();
    }

    public boolean verifySearchBtn(){
        return SearchBtn.isDisplayed();
    }

    public void verifyFilteringPermissionPageByReferenceNo(){
        ReferenceNo.click();
        ReferenceNo.sendKeys("1");
        SearchBtn.click();
    }
}
