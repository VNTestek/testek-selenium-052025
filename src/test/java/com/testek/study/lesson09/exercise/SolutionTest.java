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

import java.time.Duration;
import java.util.Objects;

import static java.lang.Thread.sleep;

@Getter
@Setter
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;

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
        Actions mActions = new Actions(mWebDriver);
        WebDriverWait wait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
        JavascriptExecutor javaScripts = (JavascriptExecutor) mWebDriver;

        // Define the locator format then apply to elements
        String FORM_RADIO_TEST_ID_XPATH = "//input[@test-id = 'input-%s']/ancestor::label";
        String FORM_CHECKBOX_VALUE_XPATH = "//input[@value = '%s']/ancestor::label";

        // Handle your code here
        // Input First Name
        String txtFirstNameId = "firstName";
        WebElement txtFirstNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(txtFirstNameId)));
        txtFirstNameEle.clear();
        mActions.sendKeys(txtFirstNameEle, "Pham").perform();
        txtFirstNameEle.clear();
        javaScripts.executeScript("arguments[0].value = 'Pham js';", txtFirstNameEle);


        // Input Last Name
        String txtLastNameId = "lastName";
        WebElement txtLastNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(txtLastNameId)));
        txtLastNameEle.clear();
        mActions.sendKeys(txtLastNameEle, "Huong").perform();
        txtLastNameEle.clear();
        javaScripts.executeScript("arguments[0].value = 'Huong js';", txtLastNameEle);

        // Input email
        String txtEmailXPath = "//input[@test-id = 'input-email']";
        WebElement txtEmailEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtEmailXPath)));
        txtEmailEle.clear();
        mActions.sendKeys(txtEmailEle, "phamhuong@gmail.com").perform();
        txtEmailEle.clear();
        javaScripts.executeScript("arguments[0].value = 'phamhuongjs@gmail.com';", txtEmailEle);

        // Select Male radio button
        String rdoMaleXPath = String.format(FORM_RADIO_TEST_ID_XPATH, "male");
        WebElement rdoMaleEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(rdoMaleXPath)));
        javaScripts.executeScript("arguments[0].click();", rdoMaleEle);

        // Select Female radio button
        String rdoFemaleXPath = String.format(FORM_RADIO_TEST_ID_XPATH, "female");
        WebElement rdoFemaleEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(rdoFemaleXPath)));
        javaScripts.executeScript("arguments[0].click();", rdoFemaleEle);

        // Input mobile
        String txtMobileId = "mobile";
        WebElement txtMobileEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(txtMobileId)));
        txtMobileEle.clear();
        mActions.sendKeys(txtMobileEle, "03649266").perform();
        txtMobileEle.clear();
        javaScripts.executeScript("arguments[0].value = '0000000';", txtMobileEle);

        // Input Dob
        String txtDobId = "dob";
        WebElement txtDobEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(txtDobId)));
        txtDobEle.clear();
        mActions.sendKeys(txtDobEle, "10291999").perform();
        txtDobEle.clear();
        javaScripts.executeScript("arguments[0].value = '1999-09-21';", txtDobEle);

        // Input Subject
        String txtSubjectId = "subjects";
        WebElement txtSubjectEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(txtSubjectId)));
        txtSubjectEle.clear();
        mActions.sendKeys(txtSubjectEle, "Math").perform();
        txtSubjectEle.clear();
        javaScripts.executeScript("arguments[0].value = 'JS';", txtSubjectEle);

        // Check all hobbies
        String chkReadingXPath = String.format(FORM_CHECKBOX_VALUE_XPATH, "Reading");
        WebElement chkReadingEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(chkReadingXPath)));
        if (!chkReadingEle.isSelected()) {
            javaScripts.executeScript("arguments[0].click();", chkReadingEle);
        }

        String chkSportsXPath = String.format(FORM_CHECKBOX_VALUE_XPATH, "Sports");
        WebElement chkSportsEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(chkSportsXPath)));
        if (!chkSportsEle.isSelected()) {
            javaScripts.executeScript("arguments[0].click();", chkSportsEle);
        }

        String chkMusicXPath = String.format(FORM_CHECKBOX_VALUE_XPATH, "Music");
        WebElement chkMusicEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(chkMusicXPath)));
        if (!chkMusicEle.isSelected()) {
            javaScripts.executeScript("arguments[0].click();", chkMusicEle);
        }

        // Input Address
        String txtAddressXPath = "//textarea[@test-id ='textarea-address']";
        WebElement txtAddressEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtAddressXPath)));
        txtAddressEle.clear();
        mActions.sendKeys(txtAddressEle, "Hanoi").perform();
        txtAddressEle.clear();
        javaScripts.executeScript("arguments[0].value = 'Ha Noi JS';", txtAddressEle);

        // Click Submit button
        String btnSubmitId = "submit-button";
        WebElement btnSubmitEle = wait.until(ExpectedConditions.elementToBeClickable(By.id(btnSubmitId)));
        javaScripts.executeScript("arguments[0].click();", btnSubmitEle);
        waitForDebug(1000);

        // Check info from Output info textbox
        String txtOutputId = "outputTextStudent";
        WebElement txtOutputEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(txtOutputId)));
        System.out.println("Info after submitting: ");
        System.out.println(txtOutputEle.getAttribute("value"));

        // Click Clear button
        String btnClearId = "reset-button";
        WebElement btnClearEle = wait.until(ExpectedConditions.elementToBeClickable(By.id(btnClearId)));
        javaScripts.executeScript("arguments[0].click();", btnClearEle);
        System.out.println("Info after clearing: ");
        System.out.println(txtOutputEle.getAttribute("value"));
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
