package com.nopcommerce.demo.pages;


import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.nopcommerce.demo.browserfactory.ManageBrowser.driver;

public class CheckOutLastPage extends Utility {
    public CheckOutLastPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Thank you')]")
    WebElement thankYouMessage;
    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
    WebElement successfulOrderMessage;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;

    public String getTextFromThankYouMessage() {
        Reporter.log("get text from thank you message" + thankYouMessage.toString());
        return getTextFromElement(thankYouMessage);
    }


    public String getTextFromOrderProcessedSuccessfullyMessage() {
        Reporter.log("get text order process" + successfulOrderMessage.toString());
        return getTextFromElement(successfulOrderMessage);
    }


    public void clickOnContinueButton() {
        Reporter.log("click on continue button" + continueButton.toString());
        clickOnElement(continueButton);

    }
}
