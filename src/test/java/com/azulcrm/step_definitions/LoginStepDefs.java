package com.azulcrm.step_definitions;

import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();


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
}
