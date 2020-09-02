package com.axelerant.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddedToCartPopUp {
    WebDriver driver;

    By ProceedToCheckOut = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");

    public AddedToCartPopUp(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Objective: Click on the ProceedToCheckOut Button present in the CheckOut Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    public void ClickProceedToCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(ProceedToCheckOut));
        driver.findElement(ProceedToCheckOut).click();
    }
}
