package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends TestBase {

    @FindBy(xpath = "//h4[@class='mb-3 mb-md-0'][contains(.,'Welcome to Dashboard')]")
    WebElement WelcomeDashboardLabel;

    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateDashboardPageTitle(){
        return driver.getTitle();
    }

    public boolean verifyWelcomeDashboardLabel(){
        return WelcomeDashboardLabel.isDisplayed();
    }
}
