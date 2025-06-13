package com.testek.study.lesson09.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
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

import java.time.Duration;
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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
        mWebDriverWait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
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
        Actions actions = new Actions(mWebDriver);

        // Define the locator format
        String XPATH_H3_TITLE_FORM = "//h3[@id = '%s']";
        String XPATH_LBL_FORM = "//label[@for = '%s']";
        String XPATH_INPUT_TEXT_FORM = "//input[@placeholder = '%s']";
        String XPATH_RADIO_FORM = "//input[@type = 'radio' and @id = '%s']";
        String XPATH_DATE_FORM = "//input[@type = 'date' and @id = '%s']";
        String XPATH_CHECKBOX_FORM = "//input[@type = 'checkbox' and @id = '%s']";
        String XPATH_BUTTON_FORM = "//button[@test-id = '%s']";
        String XPATH_TXT_AREA_FORM = "//textarea[@id = '%s']";

        // Find elements & interact
        // Browser Windows lbl
        String lblBrowserWindowsTitleXPath = String.format(XPATH_H3_TITLE_FORM, "browser-windows-title");
        waitForElement(By.xpath(lblBrowserWindowsTitleXPath));

        // Form đăng ký sinh viên lbl
        String lblFormTitleXPath = String.format(XPATH_H3_TITLE_FORM, "student-registration-title");
        waitForElement(By.xpath(lblFormTitleXPath));

        //First Name lbl
        String lblFirstNameXPath = String.format(XPATH_LBL_FORM, "firstName");
        waitForElement(By.xpath(lblFirstNameXPath));
        //First Name txt
        String txtFirstNameXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your first name");
        sendKeysToElement(By.xpath(txtFirstNameXPath), "Trinh", true);

        //Last Name lbl
        String lblLastNameXPath = String.format(XPATH_LBL_FORM, "lastName");
        waitForElement(By.xpath(lblLastNameXPath));
        //Last Name txt
        String txtLastNameXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your last name");
        sendKeysToElement(By.xpath(txtLastNameXPath), "Toan", true);

        //Email lbl
        String lblEmailXPath = String.format(XPATH_LBL_FORM, "email");
        mWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lblEmailXPath)));
//        mWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblEmailXPath))); => fail
//        waitForElement(By.xpath(lblEmailXPath));
        //Email txt
        String txtEmailXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your email");
        sendKeysToElement(By.xpath(txtEmailXPath), "toan@mail.com", true);

        //Gender lbl
        String lblGenderXPath = String.format(XPATH_LBL_FORM, "gender");
        waitForElement(By.xpath(lblGenderXPath));
        //Male RDO
        String rdoMaleXPath = String.format(XPATH_RADIO_FORM, "male");
        WebElement rdoMaleEle = waitForElementClickable(By.xpath(rdoMaleXPath));
        //Female RDO
        String rdoFemaleXPath = String.format(XPATH_RADIO_FORM, "female");
        waitForElementClickable(By.xpath(rdoFemaleXPath));
        //select Male RRO
        actions.click(rdoMaleEle).perform();

        //Mobile lbl
        String lblMobileXPath = String.format(XPATH_LBL_FORM, "mobile");
        waitForElement(By.xpath(lblMobileXPath));
        //Mobile txt
        String txtMobileXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your mobile number");
        sendKeysToElement(By.xpath(txtMobileXPath), "091098987", true);

        //Date of Birth lbl
        String lblDobXPath = String.format(XPATH_LBL_FORM, "dob");
        waitForElement(By.xpath(lblDobXPath));
        //Date of Birth input
        String dateDobXPath = String.format(XPATH_DATE_FORM, "dob");
        sendKeysToElement(By.xpath(dateDobXPath), "20102999", true);

        //Subjects lbl
        String lblSubjectsXPath = String.format(XPATH_LBL_FORM, "subjects");
        waitForElement(By.xpath(lblSubjectsXPath));
        //Subjects txt
        String txtSubjectsXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your subjects");
        sendKeysToElement(By.xpath(txtSubjectsXPath), "Auto web by Selenium", true);

        //Hobbies lbl
        String lblHobbiesXPath = String.format(XPATH_LBL_FORM, "hobbies");
        mWebDriver.findElement(By.xpath(lblHobbiesXPath));
        //Reading CHK
        String chkReadingXPath = String.format(XPATH_CHECKBOX_FORM, "reading");
        WebElement chkReadingEle = waitForElement(By.xpath(chkReadingXPath));
        //Sports CHK
        String chkSportsXPath = String.format(XPATH_CHECKBOX_FORM, "sports");
        WebElement chkSportsEle = waitForElement(By.xpath(chkSportsXPath));
        //Music CHK
        String chkMusicXPath = String.format(XPATH_CHECKBOX_FORM, "music");
        WebElement chkMusicEle = waitForElement(By.xpath(chkMusicXPath));
        //select only Music CHK
        boolean isReadingChecked = chkReadingEle.isSelected();
        boolean isSportsChecked = chkSportsEle.isSelected();
        boolean isMusicChecked = chkMusicEle.isSelected();
        if (isReadingChecked) {
            actions.click(chkReadingEle).perform();
        }
        if (isSportsChecked) {
            actions.click(chkSportsEle).perform();
        }
        if (!isMusicChecked) {
            clickOnElement(By.xpath(chkMusicXPath));
        }

        //Address lbl
        String lblAddressXPath = String.format(XPATH_LBL_FORM, "address");
        mWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lblAddressXPath)));
//        waitForElement(By.xpath(lblAddressXPath));
        //Address txt
        String txtAddressXPath = String.format(XPATH_TXT_AREA_FORM, "address");
        sendKeysToElement(By.xpath(txtAddressXPath), "VNM", true);

        //submit btn
        String btnSubmitXPath = String.format(XPATH_BUTTON_FORM, "submit-button");
        clickOnElement(By.xpath(btnSubmitXPath));
        waitForDebug(2000);

        // Get the value of outputTextStudent
        String txtAreaOutputTextXPath = String.format(XPATH_TXT_AREA_FORM, "outputTextStudent");
        WebElement txtAreaOutputTextEle = waitForElement(By.xpath(txtAreaOutputTextXPath));
        System.out.println(txtAreaOutputTextEle.getAttribute("value"));

        //clear btn
        String btnClearFormXPath = String.format(XPATH_BUTTON_FORM, "reset-button");
        clickOnElement(By.xpath(btnClearFormXPath));

        waitForDebug(2000);
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
     *
     * @param by : The locator of the element (By object)
     * @return : The WebElement
     */
    private WebElement waitForElement(By by) {
        log.info("Waiting for element visibility: {}", by);
        return mWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
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
}
