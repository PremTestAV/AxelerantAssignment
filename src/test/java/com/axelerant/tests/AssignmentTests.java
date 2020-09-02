package com.axelerant.tests;

import com.aventstack.extentreports.Status;
import com.axelerant.tests.pages.*;
import com.axelerant.tests.utils.ConfigFileReader;
import com.axelerant.tests.utils.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AssignmentTests extends BaseTest{

    WebDriver driver ;
    ConfigFileReader configFileReader = new ConfigFileReader();

    /**
     * Objective: Instantiate driver & setup the browser based on the input passed from testng.xml
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    @BeforeMethod
    public void instantiateBrowser() {

        getDriver().get(configFileReader.getApplicationUrl());
    }

    /**
     * Objective: Navigate to different pages of the application and validate if the header & footer content are displayed
     *            correctly
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    @Test
    public void HeaderFooterContentTest() {
        ExtentTestManager.getTest().log(Status.INFO,"Started test HeaderFooterContentTest");
        driver = getDriver();
        LandingPage lp = new LandingPage(driver);
        Assert.assertEquals(lp.GetHeaderInfo_SignInText(),"Sign in");
        ExtentTestManager.getTest().log(Status.INFO,"Header - Sign In info in Landing Page Validated successfully");
        Assert.assertEquals(lp.GetHeaderInfo_ContactUsText(),"Contact us");
        ExtentTestManager.getTest().log(Status.INFO,"Header - Contact us info in Landing Page Validated successfully");
        Assert.assertEquals(lp.GetHeaderInfo_CallUsText(),"Call us now: 0123-456-789");
        ExtentTestManager.getTest().log(Status.INFO,"Header - Call us now info in Landing Page Validated successfully");
        Assert.assertEquals(lp.GetFooterInfo_NewsLetterBlockText(),"Newsletter");
        ExtentTestManager.getTest().log(Status.INFO,"Footer - Newsletter info in Landing Page Validated successfully");
        Assert.assertEquals(lp.GetFooterInfo_SocialBlockText(),"Follow us");
        ExtentTestManager.getTest().log(Status.INFO,"Footer - Follow Us info in Landing Page Validated successfully");
        lp.ClickWomenTab();
        Assert.assertEquals(lp.GetHeaderInfo_ContactUsText(),"Contact us");
        ExtentTestManager.getTest().log(Status.INFO,"Header - Contact us info in Landing Page Validated successfully");
        lp.ClickShoppingCartLink();
        Assert.assertEquals(lp.GetHeaderInfo_CallUsText(),"Call us now: 0123-456-789");
        ExtentTestManager.getTest().log(Status.INFO,"Header - Call us now info in Shopping Cart Page Validated successfully");
        lp.ClickTShirtsTab();
        Assert.assertEquals(lp.GetFooterInfo_SocialBlockText(),"Follow us");
        ExtentTestManager.getTest().log(Status.INFO,"Footer - Follow Us info in TShirts Page Validated successfully");
        ExtentTestManager.getTest().log(Status.INFO,"Completed test HeaderFooterContentTest Successfully");


    }

    /**
     * Objective: Subscribe to the NewsLetter by entering a valid email ID & click submit button.
     *            Validating if the display message is correct
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    @Test
    public void NewsLetterSubscriptionTest() {
        ExtentTestManager.getTest().log(Status.INFO,"Started test NewsLetterSubscriptionTest");
        driver =getDriver();
        LandingPage lp = new LandingPage(driver);
        lp.EnterEmailNewsLetterInput();
        lp.ClickNewsLetterInputSubmitBtn();
        Assert.assertEquals(lp.GetNewsLetterSubmissionMessage(),"Newsletter : This email address is already registered.");
        ExtentTestManager.getTest().log(Status.INFO,"Completed test NewsLetterSubscriptionTest");
    }

    /**
     * Objective: Subscribe to the NewsLetter by entering a invalid email ID & click submit button.
     *            Validating if the display error message is correct
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    @Test
    public void NewsLetterSubscriptionNegativeTest() {
        ExtentTestManager.getTest().log(Status.INFO,"Started test NewsLetterSubscriptionNegativeTest");
        driver =getDriver();
        LandingPage lp = new LandingPage(driver);
        lp.ClickNewsLetterInputSubmitBtn();
        Assert.assertEquals(lp.GetNewsLetterSubmissionMessage(),"Newsletter : Invalid email address.");
        ExtentTestManager.getTest().log(Status.INFO,"Completed test NewsLetterSubscriptionNegativeTest");
    }

    /**
     * Objective: Navigate to Women's Page from Landing Page & click on different tabs.
     *            Validating if the number of items displayed are correct in each of the tab
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    @Test
    public void WomensPageAutomationTest() {
        ExtentTestManager.getTest().log(Status.INFO,"Started test WomensPageAutomationTest");
        driver =getDriver();
        LandingPage lp = new LandingPage(driver);
        WomenPage wp = new WomenPage(driver);
        lp.ClickWomenTab();
        wp.ClickDressesTab();
        wp.ClickSummerDressesTab();
        Assert.assertEquals(wp.GetProductCount(),"Showing 1 - 3 of 3 items");
        ExtentTestManager.getTest().log(Status.INFO,"Product Count validated in SummerDresses Tab");
        wp.ClickDressesNavigationBtn();
        wp.ClickCasualDressesTab();
        Assert.assertEquals(wp.GetProductCount(),"Showing 1 - 1 of 1 item");
        ExtentTestManager.getTest().log(Status.INFO,"Product Count validated in CasualDresses Tab");
        wp.ClickDressesNavigationBtn();
        wp.ClickEveningDressesTab();
        Assert.assertEquals(wp.GetProductCount(),"Showing 1 - 1 of 1 item");
        ExtentTestManager.getTest().log(Status.INFO,"Product Count validated in EveningDresses Tab");
        ExtentTestManager.getTest().log(Status.INFO,"Completed test WomensPageAutomationTest");
    }
    /**
     * Objective: Navigate to TShirt Page from Landing Page & add an item to the cart.
     *            Validating if the checkout process is complete without any issues
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    @Test
    public void FullCheckOutTest() {
        ExtentTestManager.getTest().log(Status.INFO,"Started test FullCheckOutTest");
        driver =getDriver();
        LandingPage lp = new LandingPage(driver);
        TShirtsPage tp = new TShirtsPage(driver);
        AddedToCartPopUp toCartPopUp = new AddedToCartPopUp(driver);
        AuthenticationPage ap = new AuthenticationPage(driver);
        CheckOutPage cp = new CheckOutPage(driver);
        lp.ClickSignInLink();
        ap.EnterDetailsAndSignIn();
        lp.ClickTShirtsTab();
        tp.ClickFirstItemLink();
        toCartPopUp.ClickProceedToCheckOut();
        ExtentTestManager.getTest().log(Status.INFO,"First item in TShirts added to the cart");
        cp.ClickProceedToCheckOut_Summary();
        cp.ClickProceedToCheckOut_Address();
        cp.ClickTermsConditionCheckBox();
        cp.ClickProceedToCheckOut_Carrier();
        cp.ClickPaymentBankWire();
        ExtentTestManager.getTest().log(Status.INFO,"Payment completed for item added to the cart");
        cp.ClickOrderConfirmation();
        Assert.assertEquals(cp.GetConfMessage(),"Your order on My Store is complete.");
        ExtentTestManager.getTest().log(Status.INFO,"Completed test FullCheckOutTest");
    }

}
