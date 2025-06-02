package com.testek.study.lesson06.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
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
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver webDriver;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(webDriver)) webDriver.quit();
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Element Interaction")
    public void testInteraction() {
        gotoTestWebsite();
        // Handle your code here

        // button
        String FORM_BUTTON_XPATH = "//button[@test-id='%s']";
        String btnClickMeXpath = "button-click-me";
        String btnConfirmMeXpath = "button-confirm-me";
        String btnPromptXpath = "button-prompt-me";
        String btnOneXpath = "button1";
        String btnTwiceXpath = "button2";
        String btnThirdXpath = "button3";

        WebElement btnClickMeEle = webDriver.findElement(By.xpath(String.format(FORM_BUTTON_XPATH, btnClickMeXpath)));
        WebElement btnConfirmMeEle = webDriver.findElement(By.xpath(String.format(FORM_BUTTON_XPATH, btnConfirmMeXpath)));
        WebElement btnPromptEle = webDriver.findElement(By.xpath(String.format(FORM_BUTTON_XPATH, btnPromptXpath)));
        WebElement btnOneEle = webDriver.findElement(By.xpath(String.format(FORM_BUTTON_XPATH, btnOneXpath)));
        WebElement btnTwiceEle = webDriver.findElement(By.xpath(String.format(FORM_BUTTON_XPATH, btnTwiceXpath)));
        WebElement btnThirdEle = webDriver.findElement(By.xpath(String.format(FORM_BUTTON_XPATH, btnThirdXpath)));



        waitForDebug(5000);

        // chua fix duoc loi khong click dc
        btnOneEle.click();

        // tim thu cach khac nhung cung khong dc
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        WebElement btnClickMeEle2 = wait.until(ExpectedConditions.elementToBeClickable(btnOneEle));
        btnClickMeEle2.click();


        String txtValueXpath = "//div[@test-id='buttons-interaction-result']/child::p";
        WebElement txtValueEle = webDriver.findElement(By.xpath(txtValueXpath));
        System.out.println(txtValueEle.getAttribute("textContent"));

    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.FORM.getName())));
        mnuElementEle.click();

        WebElement mnuEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.STUDENT_FORM.getName())));
        mnuEle.click();

        waitForDebug(5000);
    }


    @Test
    private void findElementWithXpath() {
        gotoTestWebsite();

        // input
        String FORM_INPUT_XPATH = "//input[@test-id='%s']";
        String inputFirstNameXpath = "input-firstName";
        String inputLastNameXpath = "input-lastName";
        String inputEmailXpath = "input-email";
        String inputMobileXpath = "input-mobile";
        String inputSubjectsXpath = "input-subjects";
        String inputDobXpath = "input-dob";
        WebElement inputFirstNameEle = webDriver.findElement(By.xpath(String.format(FORM_INPUT_XPATH, inputFirstNameXpath)));
        WebElement inputLastNameEle = webDriver.findElement(By.xpath(String.format(FORM_INPUT_XPATH, inputLastNameXpath)));
        WebElement inputEmailEle = webDriver.findElement(By.xpath(String.format(FORM_INPUT_XPATH, inputEmailXpath)));
        WebElement inputMobileEle = webDriver.findElement(By.xpath(String.format(FORM_INPUT_XPATH, inputMobileXpath)));
        WebElement inputSubjectsEle = webDriver.findElement(By.xpath(String.format(FORM_INPUT_XPATH, inputSubjectsXpath)));
        WebElement inputDobEle = webDriver.findElement(By.xpath(String.format(FORM_INPUT_XPATH, inputDobXpath)));

        // label radio
        String FORM_RDO_LBL_XPATH = "//label[@test-id='%s']";
        String lblRdoMaleXpath = "label-male";
        String lblRdoFeMaleXpath = "label-female";
        WebElement lblRdoMaleEle = webDriver.findElement(By.xpath(String.format(FORM_RDO_LBL_XPATH, lblRdoMaleXpath)));
        WebElement lblRdoFeMaleEle = webDriver.findElement(By.xpath(String.format(FORM_RDO_LBL_XPATH, lblRdoFeMaleXpath)));

        // radio
        String FORM_RDO_XPATH = "//label[@test-id='%s']/child::input";
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(String.format(FORM_RDO_XPATH, lblRdoMaleXpath)));
        WebElement rdoFeMaleEle = webDriver.findElement(By.xpath(String.format(FORM_RDO_XPATH, lblRdoFeMaleXpath)));

        // label checkbox
        String FORM_LAB_XPATH = "//label[@test-id='%s']";
        String lblReadingXpath = "label-reading";
        String lblSportsXpath = "label-sports";
        String lblMusicXpath = "label-music";
        WebElement lblReadingEle = webDriver.findElement(By.xpath(String.format(FORM_LAB_XPATH, lblReadingXpath)));
        WebElement lblSportsEle = webDriver.findElement(By.xpath(String.format(FORM_LAB_XPATH, lblSportsXpath)));
        WebElement lblMusicEle = webDriver.findElement(By.xpath(String.format(FORM_LAB_XPATH, lblMusicXpath)));

        // checkbox
        String FORM_CB_XPATH = "//label[@test-id='%s']/child::input";
        WebElement cbReadingEle = webDriver.findElement(By.xpath(String.format(FORM_CB_XPATH, lblReadingXpath)));
        WebElement cbSportsEle = webDriver.findElement(By.xpath(String.format(FORM_CB_XPATH, lblSportsXpath)));
        WebElement cbMusicEle = webDriver.findElement(By.xpath(String.format(FORM_CB_XPATH, lblMusicXpath)));

        // button
        String FORM_BUTTON_XPATH = "//button[@test-id='%s']";
        String btnSubmitXpath = "submit-button";
        String btnResetXpath = "reset-button";
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(String.format(FORM_BUTTON_XPATH, btnSubmitXpath)));
        WebElement btnResetEle = webDriver.findElement(By.xpath(String.format(FORM_BUTTON_XPATH, btnResetXpath)));

        // textArea
        String txtInfoXpath = "//textarea[@test-id='outputTextStudent']";
        WebElement txtInfoEle = webDriver.findElement(By.xpath(txtInfoXpath));

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
