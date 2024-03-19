package com.azulcrm.pages;


import com.azulcrm.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "div[id='feed-add-post-form-tab']")
    public WebElement moduleFeedAddPostForm;

    @FindBy(css = "span[id='feed-add-post-form-tab-message']")
    public WebElement messageModule;



    @FindBy(css = "span[id='feed-add-post-form-tab-tasks']")
    public WebElement taskModule;

    @FindBy(css = "span[id='feed-add-post-form-tab-calendar']")
    public WebElement eventModule;
    @FindBy(css = "span[id='feed-add-post-form-tab-vote']")
    public WebElement pollModule;

    @FindBy(css = "span[id='feed-add-post-form-link-more']")
    public WebElement moreModule;




    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
