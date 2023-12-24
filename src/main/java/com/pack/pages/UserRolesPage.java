package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRolesPage extends TestBase {

    @FindBy(xpath = "//span[@class='link-title'][contains(.,'User Roles')]")
    WebElement UserRoles;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
    WebElement SearchBtn;

    public UserRolesPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateUserRolesPageTitle(){
        return driver.getTitle();
    }

    public UserRolesPage clickOnUserRolesPageLink(){
        UserRoles.click();
        return new UserRolesPage();
    }
}
