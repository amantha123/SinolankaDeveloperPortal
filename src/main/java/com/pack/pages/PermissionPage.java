package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PermissionPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'Permission')]")
    WebElement Permission;

    @FindBy(xpath = "//input[contains(@formcontrolname,'id')]")
    WebElement ReferenceNo;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-authorization/app-permissions/div[2]/div/div/div/div/form/div[1]/div[2]/div/select")
    WebElement StatusField;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-authorization/app-permissions/div[2]/div/div/div/div/form/div[1]/div[2]/div/select/option[1]")
    WebElement All;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-authorization/app-permissions/div[2]/div/div/div/div/form/div[1]/div[2]/div/select/option[2]")
    WebElement Active;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div[2]/div/div/app-authorization/app-permissions/div[2]/div/div/div/div/form/div[1]/div[2]/div/select/option[3]")
    WebElement Inactive;

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

    public boolean verifyReferenceNoField(){
        return ReferenceNo.isDisplayed();
    }

    public void filterPermissionPageByReferenceNo(String referenceno){
        ReferenceNo.click();
        ReferenceNo.sendKeys(referenceno);
        SearchBtn.click();
    }

    public boolean verifyStatusField(){
        return StatusField.isDisplayed();
    }

    public void filterPermissionPageByStatusAll(){
        StatusField.click();
        All.click();
        SearchBtn.click();
    }

    public void filterPermissionPageByStatusActive(){
        StatusField.click();
        Active.click();
        SearchBtn.click();
    }

    public void filterPermissionPageByStatusInactive(){
        StatusField.click();
        Inactive.click();
        SearchBtn.click();
    }

}
