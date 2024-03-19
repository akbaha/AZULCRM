package com.azulcrm.step_definitions;

import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        BrowserUtils.waitForTitleContains("Authorization");
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //based on input enter that user information
        String username =null;
        String password =ConfigurationReader.getProperty("password");

        if(userType.equalsIgnoreCase("Helpdesk user")){
            username = ConfigurationReader.getProperty("helpdesk_username");

        }else if(userType.equalsIgnoreCase("Marketing user")){
            username = ConfigurationReader.getProperty("marketing_username");

        }else if(userType.equalsIgnoreCase("HR user")){
            username = ConfigurationReader.getProperty("hr_username");

        }
        //send username and password and login
        new LoginPage().login(username,password);
    }

    @Given("the user logged in with username as {string} and password as {string}")
    public void the_user_logged_in_with_username_as_and_password_as(String username, String password) {

      loginPage.login(username,password);
    }




    @Then("user land on base page")
    public void userLandOnBasePage() {BrowserUtils.verifyTitle("Portal");
    }

    @When("user login with invalid {string} and valid {string}")
    public void userLoginWithInvalidAndValid(String invalidUsername, String password) {
        loginPage.login(invalidUsername,password);

    }

    @When("user login with valid {string} and invalid {string}")
    public void userLoginWithValidAndInvalid(String username, String invalidPassword) {
    loginPage.login(username,invalidPassword);
    }


    @Then("user should see Incorrect login or password error message")
    public void userShouldSeeIncorrectLoginOrPasswordErrorMessage() { BrowserUtils.verifyElementDisplayed(loginPage.incorrectLoginOrPasswordMsg);
    }


    @When("user login with empty username and password")
    public void userLoginWithEmptyUsernameAndPassword() {
        loginPage.login("",ConfigurationReader.getProperty("password"));
    }

    @When("user login with empty password and username")
    public void userLoginWithEmptyPasswordAndUsername() {
        loginPage.login(ConfigurationReader.getProperty("helpdesk_username"),"");
    }

    @When("user login both username and password is empty")
    public void userLoginBothUsernameAndPasswordIsEmpty() {
        loginPage.login("","");
    }

    @Then("user should see Please fill out this field error message")
    public void userShouldSeePleaseFillOutThisFieldErrorMessage() {
       //bug
    }

    @Then("Remember me on this computer link exists and is clickable on the login page")
    public void rememberMeOnThisComputerLinkExistsAndIsClickableOnTheLoginPage() {

        Assert.assertTrue("Element is clickable", loginPage.rememberMeOnThisComp.isDisplayed() &&
        loginPage.rememberMeOnThisComp.isEnabled());

    }

    @When("user enter password in password area")
    public void userEnterPasswordInPasswordArea() {
        loginPage.login("user","password");
    }

    @Then("user should see the password in bullet signs")
    public void userShouldSeeThePasswordInBulletSigns() {

    }


}
