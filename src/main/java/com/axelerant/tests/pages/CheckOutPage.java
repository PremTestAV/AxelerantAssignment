package com.axelerant.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
    WebDriver driver;
    By ProceedToCheckOut_Summary = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
    By ProceedToCheckOut_Address = By.xpath("//*[@name=\"processAddress\"]");
    By TermsConditionCheckBox = By.xpath("//*[@id=\"uniform-cgv\"]");
    By ProceedToCheckOut_Carrier = By.xpath("//*[@name=\"processCarrier\"]");
    By PaymentBankWire = By.xpath("//*[@class=\"bankwire\"]");
    By OrderConfirmation = By.xpath("//*[@id=\"cart_navigation\"]/button");
    By ConfirmationMessage = By.xpath("//*[@id=\"center_column\"]/div/p/strong");
    By CallUsLink = By.xpath("//*[@class=\"shop-phone\"]");

    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }


    /**
     * Objective: Click on the ProceedToCheckOut Button present in the Summary section of CheckOut Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickProceedToCheckOut_Summary() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(ProceedToCheckOut_Summary));
        driver.findElement(ProceedToCheckOut_Summary).click();
    }
    /**
     * Objective: Click on the ProceedToCheckOut Button present in the Address section of CheckOut Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickProceedToCheckOut_Address() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(ProceedToCheckOut_Address));
        driver.findElement(ProceedToCheckOut_Address).click();
    }

    /**
     * Objective: Click on the Terms Conditions Checkbox present in the CheckOut Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickTermsConditionCheckBox() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(TermsConditionCheckBox));
        driver.findElement(TermsConditionCheckBox).click();
    }

    /**
     * Objective: Click on the ProceedToCheckOut Button present in the Carrier section of CheckOut Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickProceedToCheckOut_Carrier() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(ProceedToCheckOut_Carrier));
        driver.findElement(ProceedToCheckOut_Carrier).click();
    }

    /**
     * Objective: Click on the Payment through Bank Wire Button present in the CheckOut Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickPaymentBankWire() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(PaymentBankWire));
        driver.findElement(PaymentBankWire).click();
    }

    /**
     * Objective: Click on the OrderConfirmation Button present in the CheckOut Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickOrderConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(OrderConfirmation));
        driver.findElement(OrderConfirmation).click();
    }

    /**
     * Objective: Extract the Confirmation message after the checkout completion
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    public String GetConfMessage() {

            WebDriverWait wait = new WebDriverWait(driver,15);
            wait.until(ExpectedConditions.elementToBeClickable(ConfirmationMessage));
            return driver.findElement(ConfirmationMessage).getText();

    }

}
