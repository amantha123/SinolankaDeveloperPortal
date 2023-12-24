package com.pack.pages;

import com.pack.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//input[contains(@id,'exampleInputEmail1')]")
    WebElement Email;

    @FindBy(xpath = "//input[contains(@formcontrolname,'password')]")
    WebElement Password;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Login')]")
    WebElement LoginBtn;

    @FindBy(xpath = "//img[@src='assets/images/login.png']")
    WebElement Logo;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCRMImage(){
        return Logo.isDisplayed();
    }

    public DashboardPage login(String un, String pwd){
        Email.sendKeys(un);
        Password.sendKeys(pwd);
        LoginBtn.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", LoginBtn);

        return new DashboardPage();
    }
}
