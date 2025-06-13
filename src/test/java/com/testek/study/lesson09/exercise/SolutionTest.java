package com.testek.study.lesson09.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;

import static java.lang.Thread.sleep;

@Getter
@Setter
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
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
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
        // Define the locator format then apply to elements
        Actions mActions = new Actions(mWebDriver);

        // Define the locator
        String FORM_XPATH_TITLE = "//h3[@test-id='%s']";
        String FORM_XPATH_LABEL = "//label[@test-id='%s']";
        String FORM_XPATH_PLACEHOLDER_INPUT = "//input[@placeholder='%s']";
        String FORM_XPATH_RADIOBUTTON_INPUT = "//label[@test-id='%s']";
        String FORM_XPATH_CHECKBOX_INPUT = "//label[@test-id='%s']";
        String FORM_XPATH_BUTTON = "//button[@test-id='%s']";
        String FORM_XPATH_TEXTAREA = "//textarea[@test-id='%s']";
        String dateDobXPath = "//input[@test-id='input-dob']";

        // Verify labels
        String[] labelIds = {
                "label-firstName", "label-lastName", "label-email", "label-gender",
                "label-mobile", "label-dob", "label-subjects", "label-hobbies", "label-address"
        };
        for (String labelId : labelIds) {
            waitForElement(By.xpath(String.format(FORM_XPATH_LABEL, labelId)));
        }

        // Verify titles
        String[] titleIds = {"browser-windows-title", "student-registration-title", "submitted-info-title"};
        for (String titleId : titleIds) {
            waitForElement(By.xpath(String.format(FORM_XPATH_TITLE, titleId)));
        }

        // Interact with text fields
        sendKeysToElement(By.xpath(String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your first name")), "Nguyen", true);
        sendKeysToElement(By.xpath(String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your last name")), "Ngoc Anh", true);
        sendKeysToElement(By.xpath(String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your email")), "ngocanh@gmail.com", true);
        sendKeysToElement(By.xpath(String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your mobile number")), "0931101896", true);
        sendKeysToElement(By.xpath(String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your subjects")), "Automation test", true);

        // Interact with gender radio buttons
        clickOnElement(By.xpath(String.format(FORM_XPATH_RADIOBUTTON_INPUT, "label-female")));
        waitForDebug(2000);
        clickOnElement(By.xpath(String.format(FORM_XPATH_RADIOBUTTON_INPUT, "label-male")));

        // Interact with hobbies
        String[] hobbyIds = {"label-reading", "label-sports", "label-music"};
        for (String hobbyId : hobbyIds) {
            clickOnElement(By.xpath(String.format(FORM_XPATH_CHECKBOX_INPUT, hobbyId)));
        }

        // Interact with DOB
        sendKeysToElement(By.xpath(dateDobXPath), "08081996", true);

        // Interact with address
        sendKeysToElement(By.xpath(String.format(FORM_XPATH_TEXTAREA, "textarea-address")), "Ha Noi", true);

        waitForDebug(3000);

        // Click submit button using JavaScript for reliability
        JavascriptExecutor javaScripts = (JavascriptExecutor) mWebDriver;
        By submitButton = By.xpath(String.format(FORM_XPATH_BUTTON, "submit-button"));
        WebElement submitElement = waitForElement(submitButton);
        javaScripts.executeScript("arguments[0].click();", submitElement);

        waitForDebug(5000);

        // Retrieve and print output text
        By outputTextArea = By.xpath(String.format(FORM_XPATH_TEXTAREA, "outputTextStudent"));
        WebElement outputElement = waitForElement(outputTextArea);
        String info = outputElement.getAttribute("value");
        System.out.println("Your information: " + info);

        // Click clear button
        clickOnElement(By.xpath(String.format(FORM_XPATH_BUTTON, "reset-button")));

        waitForDebug(3000);
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
     *
     * @param by : The locator of the element (By object)
     * @return : The WebElement
     */
    private WebElement waitForElement(By by) {
        log.info("Waiting for element: {}", by);
        try {
            return mWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            log.error("Element not found or timeout: {}", by, e);
            throw new RuntimeException("Failed to find element: " + by, e);
        }
    }

    /**
     * Send keys to element
     */
    private void sendKeysToElement(By by, String text, boolean isClear) {
        log.info("Send keys to element: {}", by);
        WebElement element = waitForElement(by);
        if (element == null) {
            log.error("Element not found: {}", by);
            return;
        }

        // Clear the text if isClear = true
        if (isClear) {
            element.clear();
        }
        element.sendKeys(text);
        log.info("Send keys to element: {}", text);
    }


    /**
     * Click on element
     */
    private void clickOnElement(By by) {
        log.info("Click on element: {}", by);
        WebElement element = waitForElementClickable(by);
        if (element == null) {
            log.error("Element not found: {}", by);
            return;
        }
        element.click();
        // Can add JS click if needed
        log.info("Click on element: {}", by);
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
