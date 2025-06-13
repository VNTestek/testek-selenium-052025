package com.testek.study.lesson10.exercise;

import com.testek.study.common.Menu;
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

@Slf4j
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;
    private WebDriverWait mWebDriverWait;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
        mWebDriverWait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
        mWebDriver.manage().window().maximize(); // Set the window size to maximum
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
    public void testLogin() {
        gotoLoginWebsite();

        // Declare XPATH, Dynamic XPath
        String DYNAMIC_INPUT_TEXT = "//input[@id='%s']";
        String DYNAMIC_BUTTON_TEXT = "//span[text()='%s']";

        // Login
        String txtUsernameXPath = String.format(DYNAMIC_INPUT_TEXT, "normal_login_username");
        sendKeysTo(waitForElementVisible(By.xpath(txtUsernameXPath)), "admin_com_role", "Username");

        String txtPasswordXPath = String.format(DYNAMIC_INPUT_TEXT, "normal_login_password");
        sendKeysTo(waitForElementVisible(By.xpath(txtPasswordXPath)), "aA12345678@", "Password");

        String btnLoginXPath = String.format(DYNAMIC_BUTTON_TEXT, "Đăng nhập");
        clickTo(waitForElementVisible(By.xpath(btnLoginXPath)), "Login Button");

    }

    private WebElement waitForElementVisible(By by) {
        log.info("Waiting for element visible: {}", by);
        return mWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void clickTo(WebElement element, String title) {
        if (Objects.isNull(element)) {
            log.info("Element is null, cannot click.");
            return;
        }
        element.click();
        log.info("Clicked on [{}]", title);

    }

    public void sendKeysTo(WebElement element, String text, String title) {
        if (Objects.isNull(element)) {
            log.info("Element is null, cannot send keys.");
            return;
        }
        element.clear();
        element.sendKeys(text);
        log.info("Sent keys [{}] to [{}]", text, title);
    }

    private void gotoLoginWebsite() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu parent, Menu subMenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        mWebDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, parent.getName())));
        mnuElementEle.click();

        WebElement mnuEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, subMenu.getName())));
        mnuEle.click();

        waitForDebug(5000);
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