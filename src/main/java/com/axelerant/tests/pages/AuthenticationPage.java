package com.axelerant.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {
    WebDriver driver;
    By EmailAddressInput = By.xpath("//*[@id=\"email\"]");
    By PasswordInput = By.xpath("//*[@id=\"passwd\"]");
    By SubmitSignIn = By.xpath("//*[@id=\"SubmitLogin\"]");

    public AuthenticationPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Objective: Enter details for email address, password & click submit button in Sign In Page
     *
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    public void EnterDetailsAndSignIn() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(EmailAddressInput));
        driver.findElement(EmailAddressInput).sendKeys("zayb@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(PasswordInput));
        driver.findElement(PasswordInput).sendKeys("password");
        wait.until(ExpectedConditions.elementToBeClickable(SubmitSignIn));
        driver.findElement(SubmitSignIn).click();
    }
}
