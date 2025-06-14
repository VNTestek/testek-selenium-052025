package com.testek.study.lesson09.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
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
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Objects;

import static java.lang.Thread.sleep;

@Slf4j
@Getter
@Setter
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;
    private WebDriverWait wait;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
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
        Actions action = new Actions(mWebDriver);
        JavascriptExecutor js = (JavascriptExecutor) mWebDriver;

        //Dynamic format
        String FORM_TITLE_BUTTON_ID = "%s";
        String FORM_LABEL_ID = "//label[@test-id='%s']";
        String FORM_INPUT_PLACEHOLDER = "//input[@placeholder='%s']";
        String FORM_RADIO_CHECKBOX_DAT = "//input[@id='%s' and @type='%s']";
        String textareaAddress = "//textarea[@test-id='textarea-address']";

        // Find elements with dynamic locator
        //Title
        String[] lblTitles = {"student-registration-title", "submitted-info-title"};
        String[] lblTitleNames = {"Form đăng ký sinh viên", "Thông tin bạn đã nhập:"};
        for (int i = 0; i < lblTitles.length; i ++) {
            String lblTitle = lblTitles[i];
            String lblTitleName = lblTitleNames[i];
            waitForEleVisible(By.id(String.format(FORM_TITLE_BUTTON_ID, lblTitle)), lblTitleName);
        }

        //Label text:
        String[] lblIds = {"label-firstName", "label-lastName", "label-email", "label-gender", "label-mobile", "label-dob",
        "label-subjects", "label-hobbies", "label-address"};
        String[] lblNames = {"First Name", "last Name", "Email", "Gender", "Mobile", "Date of birth", "Subject", "Hobbies", "Address"};
        for (int i = 0; i < lblIds.length; i++){
            String lblId = lblIds[i];
            String lblName = lblNames[i];
            waitForEleVisible(By.xpath(String.format(FORM_LABEL_ID, lblId)), lblName);
        }

        //TEXT BOX
        sendKeysToEle(By.xpath(String.format(FORM_INPUT_PLACEHOLDER,"Enter your first name")), "Kim", "First Name", true);
        sendKeysToEle(By.xpath(String.format(FORM_INPUT_PLACEHOLDER,"Enter your last name")), "Chi", "Last Name", true);
        sendKeysToEle(By.xpath(String.format(FORM_INPUT_PLACEHOLDER,"Enter your email")), "vukimchi023@gmail.com", "Email", true);
        sendKeysToEle(By.xpath(String.format(FORM_INPUT_PLACEHOLDER,"Enter your mobile number")), "0374975400", "Mobile phone", true);
        sendKeysToEle(By.xpath(String.format(FORM_INPUT_PLACEHOLDER,"Enter your subjects")), "Automation Test", "Subject", true);

        //RADIO BUTTON
        clickOnEle(By.xpath(String.format(FORM_RADIO_CHECKBOX_DAT,"male","radio")), "Radio button Male");
        clickOnEle(By.xpath(String.format(FORM_RADIO_CHECKBOX_DAT,"female","radio")), "Radio button Female");

        //CHECK BOX
        clickOnEle(By.xpath(String.format(FORM_RADIO_CHECKBOX_DAT,"reading","checkbox")), "Checkbox Reading");
        clickOnEle(By.xpath(String.format(FORM_RADIO_CHECKBOX_DAT,"sports","checkbox")), "Checkbox Sports");
        clickOnEle(By.xpath(String.format(FORM_RADIO_CHECKBOX_DAT,"music","checkbox")), "Checkbox Music");

        //BIRTHDAY
        sendKeysToEle(By.xpath(String.format(FORM_RADIO_CHECKBOX_DAT,"dob","date")),"18102000", "Date picker date of birth",true);

        //TEXTAREA
        sendKeysToEle(By.xpath(textareaAddress), "Ha Noi", "Text area Address", true);

        //BUTTON SUBMIT
        clickOnEle(By.id(String.format(FORM_TITLE_BUTTON_ID,"submit-button")), "Button Submit");

        //TEXTAREA RESULT
        printInfo(By.id(String.format(FORM_TITLE_BUTTON_ID,"outputTextStudent")), "Text area Thong tin ban da nhap");

        //BUTTON RESET
        clickOnEle(By.id(String.format(FORM_TITLE_BUTTON_ID, "reset-button")), "Button Clear");
    }

    /**
     * Wait for element visible
     */
    private WebElement waitForEleVisible(By by, String title) {
        log.info("Wait for element [{}] visible: [{}]", title, by);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (Exception e) {
            log.error("Element [{}] not found or timeout: [{}]", title, by, e);
            throw new RuntimeException("Failed to find element [{}]: [{}]" + title + by, e);
        }
    }

    /**
     * Send keys to element
     */
    private WebElement sendKeysToEle(By by, String text, String title, boolean isClear) {
        WebElement element = waitForEleVisible(by, title);
        if (element == null) {
            log.error("Element [{}] not found [{}]", title, by);
            throw new RuntimeException("Cannot send keys to null element [{}]: [{}]" + title + by);
        }
        // Clear the text if isClear = true
        if (isClear){
            element.clear();
        }
        element.sendKeys(text);
        log.info("Send keys to element [{}]: [{}] with text: [{}]", title, by, text);
        return element;
    }

    /**
     * Wait for element clickable
     */
    private WebElement waitForEleClickable(By by, String title) {
        log.info("Waiting for element [{}] clickable: [{}]", title, by);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Click on element
     */
    private WebElement clickOnEle(By by, String title) {
        WebElement element = waitForEleClickable(by, title);
        if(element == null) {
            log.error("Element [{}} not found: [{}]", title, by);
            throw new RuntimeException("Cannot click on element [{}}: [{}]" + title + by);
        }
        element.click();
        log.info("Click on element [{}] successful: [{}]", title, by);
        return element;
    }

    /**
     * Print information
     */
    private WebElement printInfo(By by, String title) {
        WebElement element = waitForEleVisible(by, title);
        String result = element.getAttribute("value");
        log.info("Information [{}]: [{}]", title, result);
        return element;
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
