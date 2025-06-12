package com.testek.study.lesson09.exercise;

import com.testek.study.common.Menu;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
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
        // Set Chrome Driver
        mWebDriver = new ChromeDriver(chromeOptions);
        mWebDriver.manage().window().maximize(); // Set the window size to maximum
        // Init Explicit Wait: Wait for 10s with interval 500ms
        mWebDriverWait = new WebDriverWait(mWebDriver, Duration.ofSeconds(20));

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
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);
        // Init Action
        Actions actions = new Actions(mWebDriver);

        // Declare Dynamic XPath
        String DYNAMIC_LABEL_TEXT = "//label[@test-id='%s']";
        String DYNAMIC_INPUT_TEXT = "//input[@test-id = '%s']";
        String DYNAMIC_TEXTAREA_INPUT = "//textarea[@id='%s']";

        // Wait for form to be displayed
        waitForElementVisible(By.id("student-registration-title"));

        // Verify text title
        WebElement tblTitleEle = mWebDriver.findElement(By.id("student-registration-title"));
        Assert.assertEquals(tblTitleEle.getText(), "Form đăng ký sinh viên", "Title text is not correct");

        // Interact with element
        // 1. Wait for First Name input can be clicked and senkey
        waitForElementClickable(By.id("firstName"));
        sendKeysToElement(By.id("firstName"), "Lien", true);

        // 2. Wait for Last Name input can be clicked and senkey
        waitForElementClickable(By.id("lastName"));
        sendKeysToElement(By.id("lastName"), "Bi", true);

        // 3. Wait for Email input can be clicked and sendkey
        String txtEmailXPath = String.format(DYNAMIC_INPUT_TEXT, "input-email");
        waitForElementClickable(By.xpath(txtEmailXPath));
        sendKeysToElement(By.xpath(txtEmailXPath), "lien@gmail.com", true);

        // 4. Wait for gender display and select male
        String rdoMaleXPath = String.format(DYNAMIC_LABEL_TEXT, "label-male");
        waitForElementVisible(By.xpath(rdoMaleXPath));
        clickOnElement(By.xpath(rdoMaleXPath));

        // 5. Wait for Phone input can be clicked and sendkey
        waitForElementClickable(By.id("mobile"));
        sendKeysToElement(By.id("mobile"), "0387123123", true);

        // 6. Wait for Date of Birth input can be clicked and sendkey
        waitForElementClickable(By.id("dob"));
        waitForElementVisible(By.id("dob"));
        WebElement dobInputEle = mWebDriver.findElement(By.id("dob"));
        actions.moveToElement(dobInputEle).click().sendKeys("06/13/2025").perform();

        // 7. Wait for Subject input can be clicked and sendkey
        waitForElementClickable(By.id("subjects"));
        sendKeysToElement(By.id("subjects"), "Subject test", true);

        // 8. Wait for hobbies can be clicked and select
        String chkRedingXPath = String.format(DYNAMIC_LABEL_TEXT, "label-reading");
        String chkSportsXPath = String.format(DYNAMIC_LABEL_TEXT, "label-sports");
        String chkMusicXPath = String.format(DYNAMIC_LABEL_TEXT, "label-music");
        waitForElementClickable(By.xpath(chkRedingXPath));
        clickOnElement(By.xpath(chkRedingXPath));
        waitForElementClickable(By.xpath(chkSportsXPath));
        clickOnElement(By.xpath(chkSportsXPath));
        waitForElementClickable(By.xpath(chkMusicXPath));
        clickOnElement(By.xpath(chkMusicXPath));

        // 9. Wait for Address input can be clicked and sendkey
        String txtAddressXPath = String.format(DYNAMIC_TEXTAREA_INPUT, "address");
        waitForElementClickable(By.xpath(txtAddressXPath));
        sendKeysToElement(By.xpath(txtAddressXPath), "Hà nội", true);

        // 10. Wait for Submit button display and click
        waitForElementVisible(By.id("submit-button"));
        clickOnElement(By.id("submit-button"));

        // 11. Wait for output Text display and print info
        waitForElementPresent(By.id("outputTextStudent"));
        WebElement txaOutputTextEle = mWebDriver.findElement(By.id("outputTextStudent"));
        String actualText = txaOutputTextEle.getAttribute("value");
        System.out.println("Info Student: " + actualText);

        // Scroll to bottom of the page to take screenshot
        ((JavascriptExecutor) mWebDriver).executeScript("arguments[0].scrollIntoView(true);", dobInputEle);

        // Border to take screenshot output text
        ((JavascriptExecutor) mWebDriver).executeScript("arguments[0].style.border='3px solid red'", txaOutputTextEle);
        File file = new File(System.getProperty("user.dir") + "/Images");
        if (!file.exists()) {
            file.mkdirs();
        }
        takeSnapShot(mWebDriver, file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".png");

        // Verify contain "Last Name: Lien"
        Assert.assertTrue(actualText.contains("Last Name: Bi"), "Not found line Last Name");

        // Verify contain "Email: lien@gmail.com"
        Assert.assertTrue(actualText.contains("Email: lien@gmail.com"), "Not found line Email");

        // Verify contain "Subjects: Subject test"
        Assert.assertTrue(actualText.contains("Subjects: Subject test"), "Not found line Subjects");

        // Verify contain "Address: Hà nội"
        Assert.assertTrue(actualText.contains("Address: Hà nội"), "Not found line Address");

        System.out.println("All fields have been verified successfully!!");

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

    /**
     * Wait for element clickable
     */
    private WebElement waitForElementClickable(By by) {
        log.info("Waiting for element clickable: {}", by);
        return mWebDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Wait for element visible
     */
    private WebElement waitForElementVisible(By by) {
        log.info("Waiting for element visible: {}", by);
        return mWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Wait for element present
     */
    private WebElement waitForElementPresent(By by) {
        log.info("Waiting for element present: {}", by);
        return mWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * click on element
     */
    private void clickOnElement(By by) {
        log.info("Click on element: {}", by);
        WebElement element = waitForElementClickable(by);
        if (element == null) {
            log.error("Element not found: {}", by);
            return;
        }
        // JS click on element
        ((JavascriptExecutor) mWebDriver).executeScript("arguments[0].click();", element);
        log.info("Clicked on element: {}", by);
    }

    /**
     * Send keys to element
     */
    private void sendKeysToElement(By by, String text, boolean isClear) {
        log.info("Send keys to element: {}", by);
        WebElement element = waitForElementVisible(by);
        if (element == null) {
            log.error("Element not found: {}", by);
            return;
        }

        // Clear the text if isClear = true
        if (isClear) {
            element.clear();
        }
        ((JavascriptExecutor) mWebDriver).executeScript("arguments[0].value = arguments[1];", element, text);
        log.info("Sent keys to element: {}", text);
    }

    /**
     * This function will take screenshot
     */
    public void takeSnapShot(WebDriver webdriver, String fileWithPath) {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(fileWithPath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}