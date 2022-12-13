package com.nopcommerce.demo.pages;


import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.nopcommerce.demo.browserfactory.ManageBrowser.driver;

public class ConfirmOrderPage extends Utility {
    public ConfirmOrderPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Credit Card')]")
    WebElement creditCard;
    @CacheLookup
    @FindBy(css = "li[class='shipping-method'] span[class='value']")
    WebElement shippingMethod;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'$2,950.00')]")
    WebElement totalAmountComputers;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    By confirmButton = By.xpath("//button[contains(text(),'Confirm')]");


    public String getTextFromPaymentMethodText() {
        Reporter.log("Payment method is credit card" + creditCard.toString());
        return getTextFromElement(creditCard);
    }


    public String getTextFromShippingMethodText() {
        Reporter.log("Get shipping method text" + shippingMethod.toString());
        return getTextFromElement(shippingMethod);
    }

    public String getTextFromTotalAmountComputersField() {
        Reporter.log("Get total amount computer field" + totalAmountComputers.toString());
        return getTextFromElement(totalAmountComputers);
    }


    public void clickOnConfirmButton() {
        Reporter.log("Click on confirm button" + confirmButton.toString());
        clickOnElement(confirmButton);
    }
}


