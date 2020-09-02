package com.axelerant.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class TShirtsPage {
    WebDriver driver;
    By FirstItemLink = By.xpath("//a[@class = \"product_img_link\" and @title = \"Faded Short Sleeve T-shirts\"]");
    By AddToCartButton = By.xpath("//*[@id=\"add_to_cart\"]/button");



    public TShirtsPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Objective: Click on the FirstItem present in the TShirt Page.
     *             Please note the use of frames here, as clicking an item will lead to a new iframe in the DOM
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickFirstItemLink() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(FirstItemLink));
        String base = driver.getWindowHandle();
        driver.findElement(FirstItemLink).click();
        Set<String> handles = driver.getWindowHandles();
        for (String winhandle : handles) {
            driver.switchTo().window(winhandle);
        }
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        wait.until(ExpectedConditions.elementToBeClickable(AddToCartButton));
        driver.findElement(AddToCartButton).click();
        driver.switchTo().defaultContent();
    }


}
