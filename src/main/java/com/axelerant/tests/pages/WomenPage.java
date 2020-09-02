package com.axelerant.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenPage {
    WebDriver driver;

        By ProductCount = By.xpath("//*[@class=\"product-count\"]");
        By DressesTabByImg = By.xpath("//*[@class=\"img\" and @title = \"Dresses\"]");
        By SummerDressesTabByImg = By.xpath("//*[@class=\"img\" and @title = \"Summer Dresses\"]");
        By DressesNavigationBtn = By.xpath("//*[@id=\"columns\"]/div[1]/a[3]");
        By CasualDressesTabByImg = By.xpath("//*[@class=\"img\" and @title = \"Casual Dresses\"]");
        By EveningDressesTabByImg = By.xpath("//*[@class=\"img\" and @title = \"Evening Dresses\"]");

        By ContactLink = By.xpath("//*[@id=\"contact-link\"]/a");
    public WomenPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Objective: Click on the DressesTab present in the Womens Dresses Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    public void ClickDressesTab() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(DressesTabByImg));
        WebElement DressesElement = driver.findElement(DressesTabByImg);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", DressesElement);
    }
    /**
     * Objective: Click on the Summer DressesTab present in the Womens Dresses Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickSummerDressesTab() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(SummerDressesTabByImg));
        driver.findElement(SummerDressesTabByImg).click();
    }
    /**
     * Objective: Click on the CAsual DressesTab present in the Womens Dresses Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickCasualDressesTab() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(CasualDressesTabByImg));
        driver.findElement(CasualDressesTabByImg).click();
    }
    /**
     * Objective: Click on the Evening DressesTab present in the Womens Dresses Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickEveningDressesTab() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(EveningDressesTabByImg));
        driver.findElement(EveningDressesTabByImg).click();
    }
    /**
     * Objective: Click on the DressesTab present in the Navigation Pane of the Womens Dresses Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickDressesNavigationBtn() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(DressesNavigationBtn));
        driver.findElement(DressesNavigationBtn).click();
    }
    /**
     * Objective: Extract the ProductCount in the Womens Dresses Page after a particular selection
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public String GetProductCount() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(ProductCount));
        return driver.findElement(ProductCount).getText();
    }

}
