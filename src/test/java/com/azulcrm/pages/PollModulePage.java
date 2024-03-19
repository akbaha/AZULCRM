package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class PollModulePage {

    public PollModulePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
