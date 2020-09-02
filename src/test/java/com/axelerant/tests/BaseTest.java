package com.axelerant.tests;

import com.axelerant.tests.utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {
    //Using ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests during Parallel Execution
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    ConfigFileReader configfileobj = new ConfigFileReader();

    /**
     * Objective: Performing the driver instantiation by setting up all necessary properties based on the
     *              browser requested in TestNG.xml.
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setup (String browser) throws MalformedURLException {
        //Set Browser to ThreadLocalMap

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", configfileobj.getChromeDriverPath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage"); //overcome limited resource problems
            options.addArguments("start-maximized"); //open browser in maximized mode
            options.addArguments("disable-infobars"); //disabling infobars
            options.addArguments("--disable-extensions"); //disabling extensions
            options.addArguments("--disable-gpu"); //applicable to windows os only
            options.addArguments("--no-sandbox"); //Bypass OS security model
            driver.set(new ChromeDriver(options));
            //driver = new ChromeDriver(options);

        }

        else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", configfileobj.getFirefoxDriverPath());
            driver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", configfileobj.getIEDriverPath());
            driver.set(new InternetExplorerDriver());
        }
        if (browser.equalsIgnoreCase("Headless")) {
            System.setProperty("webdriver.chrome.driver", configfileobj.getChromeDriverPath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-dev-shm-usage"); //overcome limited resource problems
            options.addArguments("start-maximized"); //open browser in maximized mode
            options.addArguments("disable-infobars"); //disabling infobars
            options.addArguments("--disable-extensions"); //disabling extensions
            options.addArguments("--disable-gpu"); //applicable to windows os only
            options.addArguments("--no-sandbox"); //Bypass OS security model
            options.addArguments("--remote-debugging-port=9222");
            driver.set(new ChromeDriver(options));

        }

    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }

    /**
     * Objective: Performing the driver teardown after completion of all the tests
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass
    void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
}
