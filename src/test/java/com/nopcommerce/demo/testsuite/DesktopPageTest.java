package com.nopcommerce.demo.testsuite;


import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class DesktopPageTest extends BaseTest {
    HomePage homepage;
    DesktopPage deskTopPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    PaymentInformationPage paymentInformationPage;
    ConfirmOrderPage confirmOrderPage;
    CheckOutLastPage checkOutLastPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homepage = new HomePage();
        deskTopPage = new DesktopPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
        cartPage = new CartPage();
        checkOutPage = new CheckOutPage();
        paymentInformationPage = new PaymentInformationPage();
        confirmOrderPage = new ConfirmOrderPage();
        checkOutLastPage = new CheckOutLastPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homepage.selectMenu("Computers");
        homepage.mousehoverOnDesktopLinkAndClick();
        deskTopPage.selectSortByOption("Name: A to Z");
        Thread.sleep(2000);
        deskTopPage.clickOnAddToCart();
        //waitUntilVisibilityOfElementLocated(By.cssSelector("div[class='product-name'] h1"), 20;
        //buildYourOwnComputerPage.getTextFromBuildYourOwnComputerMessage();
        buildYourOwnComputerPage.selectGhzIntelPentiumDualCore();
        Thread.sleep(2000);
        buildYourOwnComputerPage.selectRamAs8Gb(3);
        Thread.sleep(2000);
        buildYourOwnComputerPage.selectHDDRadio();
        Thread.sleep(2000);
        buildYourOwnComputerPage.selectOSRadioButton();
        Thread.sleep(2000);
        buildYourOwnComputerPage.clickOnTotalCommander();
        Thread.sleep(2000);
        String expectedTotal = "$1,475.00";
        String actualTotal = buildYourOwnComputerPage.getTextFromActualTotal();
        Assert.assertEquals(expectedTotal, actualTotal, "Total is displayed incorrectly");
        buildYourOwnComputerPage.clickOnAddToCartButton();
        String expectedText = "The product has been added to your shopping cart";
        Assert.assertEquals(buildYourOwnComputerPage.getTextFromProductHasBeenAddedToYourShoppingCart(), expectedText, "not matched");
        buildYourOwnComputerPage.closeTheBarByClickingOnCrossButton();
        buildYourOwnComputerPage.mouseHoverOnShoppingCart();
        cartPage.verifyShoppingCartMessage();
        cartPage.clearQuantity();
        cartPage.changeQuantity("2");
        cartPage.clickOnUpdateShoppingCart();
        cartPage.verifyTotal();
        Thread.sleep(3000);
        cartPage.clickOnTermsOFService();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(checkOutPage.verifyWelcomeText(), "Welcome, Please Sign In!", "User is not on the Sign in Page");
        checkOutPage.clickOnCheckOutasGuestTab();
        checkOutPage.enterNameInTheFirstNameField("Manish");
        checkOutPage.enterLastNameInTheLastNameField("Manish");
        checkOutPage.enterRandomEmailInTheEmailField("james12" + getRandomString(4) + "@gmail.com");
        checkOutPage.selectCountry("United Kingdom");
        checkOutPage.enterDataInTheCityField("London");
        checkOutPage.enterDataInTheAddress1Field("10 Downing Street");
        checkOutPage.enterDataInTheZipPostalCodeField("SW12NW");
        checkOutPage.enterDataInTheMobileNumberField("07334041434");
        checkOutPage.clickOnContinueButton();
        Thread.sleep(2000);
        checkOutPage.clickOnNextDayRadioButton();

        checkOutPage.clickOnContinueButton1();
        checkOutPage.clickOnCreditCardButton();
        checkOutPage.clickOnContinueButton2();
        paymentInformationPage.selectCreditCardType(1);
        paymentInformationPage.inputCardHoldersName("Manish");
        paymentInformationPage.inputCardNumber("5555 5555 5555 4444");
        paymentInformationPage.inputExpireMonth("10");
        paymentInformationPage.inputExpireYear("2024");
        paymentInformationPage.inputCardCode("143");
        paymentInformationPage.clickOnContinueButton3();
        Assert.assertEquals(confirmOrderPage.getTextFromPaymentMethodText(), "Credit Card", "option is not displayed");
        Assert.assertEquals(confirmOrderPage.getTextFromShippingMethodText(), "Next Day Air", "Shipping method is not displayed");
        Assert.assertEquals(confirmOrderPage.getTextFromTotalAmountComputersField(), "$2,950.00", "Total is incorrect");
        confirmOrderPage.clickOnConfirmButton();
        Assert.assertEquals(checkOutLastPage.getTextFromThankYouMessage(), "Thank you", "Message is displayed incorrectly");
        Assert.assertEquals(checkOutLastPage.getTextFromOrderProcessedSuccessfullyMessage(), "Your order has been successfully processed!");
        checkOutLastPage.clickOnContinueButton();
        Assert.assertEquals(homepage.getTextFromWelcomeToStore(), "Welcome to our store", "Message is displayed incorrectly");

    }
}
