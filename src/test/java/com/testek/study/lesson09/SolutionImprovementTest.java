package com.testek.study.lesson10.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

import static java.lang.Thread.sleep;

@Getter
@Setter
@Slf4j
public class SolutionImprovementTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;
    private WebDriverWait webDriverWait;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(mWebDriver)) mWebDriver.quit();
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to @link{Menu#FORM} navigation
     */
    @Test(description = "Element Interaction")
    public void testStudentForm() {
        WebDriverWait webDriverWait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
        String url = "https://testek.vn/lab/auto/web-elements/";

        mWebDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.FORM.getName())));
        mnuElementEle.click();

        WebElement mnuEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.STUDENT_FORM.getName())));
        mnuEle.click();

        // Wait for the page to load
        WebElement edtFirstNameEle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));

        // Handle your code here
        //WebElement edtFirstNameEle = mWebDriver.findElement(By.id("firstName"));
        edtFirstNameEle.clear();
        edtFirstNameEle.sendKeys("Testek");

        WebElement edtLastNameEle = mWebDriver.findElement(By.id("lastName"));
        edtLastNameEle.clear();
        edtLastNameEle.sendKeys("Automation");

        String edtEmailXPath = "//input[@test-id='input-email']";
        WebElement edtEmailEle = mWebDriver.findElement(By.xpath(edtEmailXPath));
        edtEmailEle.clear();
        edtEmailEle.sendKeys("vincent@testek.edu.vn");
        log.info("Email input: {}", edtEmailEle.getAttribute("value"));

        WebElement edtMobileEle = mWebDriver.findElement(By.id("mobile"));
        edtMobileEle.clear();
        edtMobileEle.sendKeys("0123456789");
        log.info("Mobile input: {}", edtMobileEle.getAttribute("value"));

        String radMaleXPath = "//label[@test-id='label-male']";
        WebElement radMaleEle = mWebDriver.findElement(By.xpath(radMaleXPath));
        radMaleEle.click();

        System.out.println("Waiting for the element to be clickable...");
    }

    /**
     * Input text to a WebElement
     *
     * @param element : The WebElement to input text to
     * @param value   : The text value to input
     */
    public void inputTextTo(WebElement element, String value, String title) {
        if (Objects.isNull(element)) {
            log.info("Element is null, cannot input text.");
            return;
        }

        element.clear();
        element.sendKeys(value);
        log.info("Input: [{}] to [{}]", value, title);
    }

    /**
     * Click on a WebElement
     *
     * @param element : The WebElement to click on
     * @param title   : The title or description of the element for logging
     */
    public void clickTo(WebElement element, String title) {
        if (Objects.isNull(element)) {
            log.info("Element is null, cannot click.");
            return;
        }

        element.click();
        log.info("Clicked on [{}]", title);
    }


    @Test
    public void testDemo() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Wait for the page to load
        inputTextTo(findWebElementById("firstName"), "Testek", "First Name");
        inputTextTo(findWebElementById("lastName"), "Automation", "Last Name");

        String edtEmailXPath = "//input[@test-id='input-email']";
        inputTextTo(findWebElementByXPath(edtEmailXPath), "vincent@testek.edu.vn", "Email");

        inputTextTo(findWebElementById("mobile"), "0123456789", "Mobile Phone");

        String radMaleXPath = "//label[@test-id='label-male']";
        clickTo(findWebElementByXPath(radMaleXPath), "Male");

        System.out.println("Waiting for the element to be clickable...");
    }

    public WebElement findWebElementByXPath(String xpath) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement findWebElementById(String id) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }


    public void gotoURL(String url) {
        if (Objects.isNull(mWebDriver)) {
            log.error("WebDriver is not initialized.");
            return;
        }
        mWebDriver.get(url);
        log.info("Navigated to URL: {}", url);
    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu parent, Menu subMenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        gotoURL(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        clickTo(findWebElementByXPath(String.format(XPATH_MENU_FORMAT, parent.getName())), parent.name());
        clickTo(findWebElementByXPath(String.format(XPATH_MENU_FORMAT, subMenu.getName())), subMenu.name());
    }

    /**
     * Sleep for debugging
     *
     * @param milliseconds : number of milliseconds
     */
    private void waitForDebug(long milliseconds) {
        try {
            sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
