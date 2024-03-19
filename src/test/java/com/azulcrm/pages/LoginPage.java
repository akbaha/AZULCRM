package com.azulcrm.pages;


import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement userName;



    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath ="//input[@type='submit']" )
    public WebElement loginButton;

    @FindBy(id ="USER_REMEMBER" )
    public WebElement rememberMeOnThisComp;

    @FindBy(xpath = "//a[@href='/?forgot_password=yes']")
    public WebElement forgotYourPassword;

    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement incorrectLoginOrPasswordMsg;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
        // verification that we logged
    }

}
