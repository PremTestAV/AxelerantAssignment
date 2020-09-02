package com.axelerant.tests.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//WebElements & Actions performed in the Landing Page(Home Page) of the application are captured in this class
public class LandingPage {
    WebDriver driver;

    By SignInLink = By.xpath("//*[@class=\"login\"]");
    By ContactLink = By.xpath("//*[@id=\"contact-link\"]/a");
    By CallUsLink = By.xpath("//*[@class=\"shop-phone\"]");
    By WomenTab = By.xpath("//a[@class=\"sf-with-ul\" and @title=\"Women\"]");
    By DressesTab = By.xpath("//a[@class=\"sf-with-ul\" and @title=\"Dresses\"]");
    By TShirtsTab = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
    By ShoppingCartLink = By.xpath("//*[@class=\"shopping_cart\"]/a");
    By NewsLetterSubmissionAlert = By.xpath("//*[@id=\"columns\"]/p");
    By NewsLetterBlock = By.xpath("//*[@id=\"newsletter_block_left\"]/h4");
    By NewsLetterInput = By.xpath("//*[@id=\"newsletter-input\"]");
    By NewsLetterInputSubmitBtn = By.xpath("//button[@name=\"submitNewsletter\"]");
    By SocialBlock= By.xpath("//*[@id=\"social_block\"]/h4");


    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Objective: Extract the Text of the SignIn Link present in the application header
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    public String GetHeaderInfo_SignInText(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(SignInLink));
        return driver.findElement(SignInLink).getText();
        
    }

    /**
     * Objective: Click on the SignIn Link present in the application header
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    public void ClickSignInLink(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(SignInLink));
        driver.findElement(SignInLink).click();

    }

    /**
     * Objective: Extract the Text of the ContactUs Link present in the application header
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public String GetHeaderInfo_ContactUsText(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(ContactLink));
        return driver.findElement(ContactLink).getText();
    }

    /**
     * Objective: Extract the Text of the CallUs Link present in the application header
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public String GetHeaderInfo_CallUsText(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(CallUsLink));
        return driver.findElement(CallUsLink).getText();
    }

    /**
     * Objective: Extract the Text of the NewsLetter Block present in the application footer
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public String GetFooterInfo_NewsLetterBlockText(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(NewsLetterBlock));
        return driver.findElement(NewsLetterBlock).getText();
    }

    /**
     * Objective: Extract the Text of the Social Block present in the application header
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public String GetFooterInfo_SocialBlockText(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(SocialBlock));
        return driver.findElement(SocialBlock).getText();
    }

    /**
     * Objective: Click on the WomensTab present in the Landing Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickWomenTab() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(WomenTab));
        driver.findElement(WomenTab).click();
    }

    /**
     * Objective: Click on the Dresses Tab present in the Landing Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickDressesTab() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(DressesTab));
        driver.findElement(DressesTab).click();
    }

    /**
     * Objective: Click on the TShirts Tab present in the Landing Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickTShirtsTab() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(TShirtsTab));
        driver.findElement(TShirtsTab).click();
    }
    /**
     * Objective: Click on the Shopping Cart Link present in the Landing Page
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickShoppingCartLink() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(ShoppingCartLink));
        driver.findElement(ShoppingCartLink).click();
    }
    /**
     * Objective: Enter values as abc@gmail.com to the NewsLEtter subscription input tab.
     *              This value can be dynamically passed later
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void EnterEmailNewsLetterInput() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(NewsLetterInput));
        driver.findElement(NewsLetterInput).sendKeys("abc@gmail.com");

    }
    /**
     * Objective: Click on the SignIn Link present in the application header
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public void ClickNewsLetterInputSubmitBtn() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(NewsLetterInputSubmitBtn));
        driver.findElement(NewsLetterInputSubmitBtn).click();
    }

    /**
     * Objective: Extract the Text of the NewsLetterSubmission Alert after subscribing to News Letter
     * @Author: Premkumar
     * @Date: 09/01/2020
     */
    public String GetNewsLetterSubmissionMessage() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(NewsLetterSubmissionAlert));
        return driver.findElement(NewsLetterSubmissionAlert).getText();
    }


}
