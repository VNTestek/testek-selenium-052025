package com.testek.study.lesson09.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
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
        WebDriverWait wait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("student-registration-title")));

        JavascriptExecutor js = (JavascriptExecutor) mWebDriver;


        // Handle your code here

        //Dynamic locator
        String LBL_FORM_XPATH = "//label[@test-id = '%s']";
        String LBL_INPUT_FORM_XPATH = "//input[@placeholder = '%s']";
        String RADIO_FORM_XPATH = "//input[@type = 'radio' and @id = '%s']";
        String DATEPICKER_FORM_XPATH = "//input[@type = 'date']";
        String CHECKBOX_FORM_XPATH = "//input[@type = 'checkbox' and @id = '%s']";
        String TEXTAREA_FORM_XPATH = "//textarea[@test-id='%s']";

        //Find elements & interact

        //Title
        String lblTitleText = mWebDriver.findElement(By.id("student-registration-title")).getText();
        System.out.println(lblTitleText);

        //First name
        String lblFirstNameXPath = String.format(LBL_FORM_XPATH, "label-firstName");
        WebElement lblFirstNameEle = mWebDriver.findElement(By.xpath(lblFirstNameXPath));
        By byFirstName = By.xpath(String.format(LBL_INPUT_FORM_XPATH, "Enter your first name"));
        sendKeysToElement(byFirstName, "Huong", true);

        //Last name
        String lblLastNameXPath = String.format(LBL_FORM_XPATH, "label-lastName");
        WebElement lblLastNameEle = mWebDriver.findElement(By.xpath(lblLastNameXPath));
        By byLastName = By.xpath(String.format(LBL_INPUT_FORM_XPATH, "Enter your last name"));
        sendKeysToElement(byLastName, "Quynh", true);

        //Email
        String lblEmailXPath = String.format(LBL_FORM_XPATH, "label-email");
        WebElement lblEmailEle = mWebDriver.findElement(By.xpath(lblEmailXPath));
        By byEmail = By.xpath(String.format(LBL_INPUT_FORM_XPATH, "Enter your email"));
        sendKeysToElement(byEmail, "huongquynh123@mail.com", true);

        //Gender
        String lblGenderXPath = String.format(LBL_FORM_XPATH, "label-gender");
        WebElement lblGenderEle = mWebDriver.findElement(By.xpath(lblGenderXPath));
        By byRdoMale = By.xpath(String.format(RADIO_FORM_XPATH, "male"));
        clickOnCheckboxOrRadio(byRdoMale, true);

        By byRdoFemale = By.xpath(String.format(RADIO_FORM_XPATH, "female"));
        clickOnCheckboxOrRadio(byRdoFemale, false);

        //Mobile
        String lblMobileXPath = String.format(LBL_FORM_XPATH, "label-mobile");
        WebElement lblMobileEle = mWebDriver.findElement(By.xpath(lblMobileXPath));
        By byMobile = By.xpath(String.format(LBL_INPUT_FORM_XPATH, "Enter your mobile number"));
        sendKeysToElement(byMobile, "023456789", true);

        //DOB
        String lblDOBXPath = String.format(LBL_FORM_XPATH, "label-dob");
        WebElement lblDOBEle = mWebDriver.findElement(By.xpath(lblDOBXPath));
        By byDOB = By.xpath(String.format(DATEPICKER_FORM_XPATH));
        sendKeysToElement(byDOB, "05/05/1995", true);

        //Subjects
        String lblSubjectXPath = String.format(LBL_FORM_XPATH, "label-subjects");
        WebElement lblSubjectEle = mWebDriver.findElement(By.xpath(lblSubjectXPath));
        By bySubject = By.xpath(String.format(LBL_INPUT_FORM_XPATH, "Enter your subjects"));
        sendKeysToElement(bySubject, "Art, English, Math", true);

        //Hobbies
        String lblHobbiesXPath = String.format(LBL_FORM_XPATH, "label-hobbies");
        WebElement lblHobbiesEle = mWebDriver.findElement(By.xpath(lblHobbiesXPath));
        By byChkReading = By.xpath(String.format(CHECKBOX_FORM_XPATH, "reading"));
        clickOnCheckboxOrRadio(byChkReading, true);

        By byChkSports = By.xpath(String.format(CHECKBOX_FORM_XPATH, "sports"));
        clickOnCheckboxOrRadio(byChkSports, false);

        By byChkMusic = By.xpath(String.format(CHECKBOX_FORM_XPATH, "music"));
        clickOnCheckboxOrRadio(byChkMusic, true);

        //Address
        String lblAddressXPath = String.format(LBL_FORM_XPATH, "label-address");
        WebElement lblAddressEle = mWebDriver.findElement(By.xpath(lblAddressXPath));
        By byAddress = By.xpath(String.format(TEXTAREA_FORM_XPATH, "textarea-address"));
        sendKeysToElement(byAddress, "Me Tri - Nam Tu Liem - Ha Noi", true);

        //Submit info
        By bySubmit = By.id("submit-button");
        clickOnElement(bySubmit);
        waitForElementClickable(bySubmit);

        //Thông tin bạn đã nhập:
        By byInfoTitle = By.id("submitted-info-title");
        By byTextareaInputInfo = By.xpath(String.format(TEXTAREA_FORM_XPATH, "outputTextStudent"));
        String infoTitleText = mWebDriver.findElement(byInfoTitle).getText();
        System.out.println(infoTitleText);
        String outputInfoText = mWebDriver.findElement(byTextareaInputInfo).getAttribute("value");
        System.out.println(outputInfoText);

        //Clear input info
        By byClearBtn = By.id("reset-button");
        clickOnElement(byClearBtn);
    }

    //Base method
    //wait for clickable
    private WebElement waitForElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(mWebDriver, Duration.ofSeconds(3));
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            return null;
        }
    }

    //Send keys to element
    private void sendKeysToElement(By by, String text, boolean isClear) {
        WebElement element = waitForElementClickable(by);
        if (element == null) {
            return;
        }
        if (isClear) {
            element.clear();
        }
        element.sendKeys(text);

    }

//    private void setValueByJS(By by, String value) {
//        WebElement element = waitForElementClickable(by);
//        if (element == null) {
//            ((JavascriptExecutor) mWebDriver).executeScript("arguments[0].value='" + value + "'", element);
//        }
//    }

    //Click on element
    private void clickOnElement(By by) {
        WebElement element = waitForElementClickable(by);
        if (element == null) {
            return;
        }
        element.click();

    }

    //Click on checkbox || radio button
    private void clickOnCheckboxOrRadio(By by, boolean shouldSelect) {
        WebDriverWait wait5 = new WebDriverWait(mWebDriver, Duration.ofSeconds(5));
        WebElement element = waitForElementClickable(by);
        if (element == null) {
            return;
        }
        String type = element.getAttribute("type");
        if (!"checkbox".equals(type) && !"radio".equals(type)) {
            return;
        }
        boolean isSelected = element.isSelected();
        if (isSelected != shouldSelect) {
            element.click();
        }

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
