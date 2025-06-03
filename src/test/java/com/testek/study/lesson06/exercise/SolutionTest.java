package com.testek.study.lesson06.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Handle your code here
        //Form đăng ký sinh viên
        String lblTtlXPath = "//h3[@test-id='textbox-form-output-title']";
        WebElement lblTtlEle = webDriver.findElement(By.xpath(lblTtlXPath));

        //First name
        String inputFirstNameXPath = "//input[@test-id='input-firstName']";
        WebElement inputFirstNameEle = webDriver.findElement(By.xpath(inputFirstNameXPath));
        inputFirstNameEle.clear();
        inputFirstNameEle.sendKeys("a");

        //Last name
        String inputLastNameXPath = "//input[@test-id='input-lastName']";
        WebElement inputLastNameEle = webDriver.findElement(By.xpath(inputLastNameXPath));
        inputLastNameEle.clear();
        inputLastNameEle.sendKeys("b");

        //Email
        String inputEmailXPath = "//input[@test-id='input-email']";
        WebElement inputEmailEle = webDriver.findElement(By.xpath(inputEmailXPath));
        inputEmailEle.clear();
        inputEmailEle.sendKeys("c@gmail.com");

        //Gender
        String rdoMaleXPath = "//input[@test-id='input-male']";
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(rdoMaleXPath));
        String rdoFemaleXPath = "//input[@id='female']";
        WebElement rdoFemaleEle = webDriver.findElement(By.xpath(rdoFemaleXPath));
        rdoFemaleEle.click();

        boolean isFemaleChecked = rdoFemaleEle.isSelected();
        System.out.println("isFemaleChecked " + isFemaleChecked);
        boolean isMaleChecked = rdoMaleEle.isSelected();
        System.out.println("isMaleChecked " + isMaleChecked);

        //Mobile
        String inputMobileXPath = "//input[@test-id='input-mobile']";
        WebElement inputMobileEle = webDriver.findElement(By.xpath(inputMobileXPath));
        inputMobileEle.clear();
        inputMobileEle.sendKeys("123");

        //Date of Birth
        String datePickerXPath = "//input[@test-id='input-dob']";
        WebElement datePickerEle = webDriver.findElement(By.xpath(datePickerXPath));
        datePickerEle.clear();
        datePickerEle.sendKeys("01/06/2025");

        //Subjects
        String inputSubjectXPath = "//input[@test-id='input-subjects']";
        WebElement inputSubjectEle = webDriver.findElement(By.xpath(inputSubjectXPath));
        inputSubjectEle.clear();
        inputSubjectEle.sendKeys("d");

        //Hobbies
        String chkReadingXPath = "//label[@test-id='label-reading']";
        WebElement chkReadingEle = webDriver.findElement(By.xpath(chkReadingXPath));
        if (!chkReadingEle.isSelected()) {
            chkReadingEle.click();
        }
        String chkSportsXPath = "//label[@test-id='label-sports']";
        WebElement chkSportsEle = webDriver.findElement(By.xpath(chkSportsXPath));
        String chkMusicXPath = "//label[@test-id='label-music']";
        WebElement chkMusicEle = webDriver.findElement(By.xpath(chkMusicXPath));

        boolean isReadingChecked = chkReadingEle.isSelected();
        boolean isSportChecked = chkSportsEle.isSelected();
        boolean isMusicChecked = chkMusicEle.isSelected();
        System.out.println("isReadingChecked " + isReadingChecked);
        System.out.println("isSportChecked " + isSportChecked);
        System.out.println("isMusicChecked " + isMusicChecked);

        //Address
        String inputAddressXPath = "//textarea[@test-id='textarea-address']";
        WebElement inputAddressEle = webDriver.findElement(By.xpath(inputAddressXPath));
        inputAddressEle.clear();
        inputAddressEle.sendKeys("e");

        //Button Submit
        String btnSubmitXPath = "//button[@test-id='submit-button']";
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(btnSubmitXPath));
        btnSubmitEle.click();

        waitForDebug(5000);

        //Thông tin bạn đã nhập
        String txtInfoXPath = "//textarea[@test-id='outputTextStudent']";
        WebElement txtInfoEle = webDriver.findElement(By.xpath(txtInfoXPath));
        String info = txtInfoEle.getAttribute("value");
        System.out.println("Your info: " + info);

        //Button Clear
        String btnClearXPath = "//button[@test-id='reset-button']";
        WebElement btnClearEle = webDriver.findElement(By.xpath(btnClearXPath));
        btnClearEle.click();
    }

    @Test
    public void testButtonsInteraction() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.BUTTONS);

        //Buttons
        String lblButtonXPath = "//h3[@test-id='buttons-title']";
        WebElement lblButtonEle = webDriver.findElement(By.xpath(lblButtonXPath));

        //Click me
        String btnClickMeXPath = "//button[@test-id='button-click-me']";
        WebElement btnClickMeEle = webDriver.findElement(By.xpath(btnClickMeXPath));
        Actions clickMe = new Actions(webDriver);
        clickMe.moveToElement(btnClickMeEle).click();

        //Confirm me
        String btnConfirmMeXPath = "//button[@test-id='button-confirm-me']";
        WebElement btnConfirmMeEle = webDriver.findElement(By.xpath(btnConfirmMeXPath));
        Actions confirmMe = new Actions(webDriver);
        confirmMe.moveToElement(btnConfirmMeEle).click();

        //Prompt me
        String btnPromptMeXPath = "//button[@test-id='button-prompt-me']";
        WebElement btnPromptMeEle = webDriver.findElement(By.xpath(btnPromptMeXPath));
        Actions promptMe = new Actions(webDriver);
        promptMe.moveToElement(btnPromptMeEle).click();

        //Buttons with Different Actions (Click, Right-Click, Double-Click):
        String lblBtnWithDifferentActionsXPath = "//h3[@test-id='buttons-different-actions-title']";
        WebElement lblBtnWithDifferentActionsEle = webDriver.findElement(By.xpath(lblBtnWithDifferentActionsXPath));

        //Button1
        String btn1XPath = "//button[@test-id='button1']";
        WebElement btn1Ele = webDriver.findElement(By.xpath(btn1XPath));
        Actions clickBtn1 = new Actions(webDriver);
        clickBtn1.moveToElement(btn1Ele).click();

//        waitForDebug(5000);
//
//        //Hãy nhấn vào một nút để kiểm tra sự kiện.
//        String txtXPath = "//p[@test-id='buttons-result-text']";
//        WebElement txtEle = webDriver.findElement(By.xpath(txtXPath));
//        System.out.println(txtEle.getAttribute("textContent"));

        //Btn2
        String btn2XPath = "//button[@test-id='button2']";
        WebElement btn2Ele = webDriver.findElement(By.xpath(btn2XPath));
        Actions clickBtn2 = new Actions(webDriver);
        clickBtn2.moveToElement(btn2Ele).click();

//        waitForDebug(5000);
//
//        //Hãy nhấn vào một nút để kiểm tra sự kiện.
//        String txtXPath1 = "//p[@test-id='buttons-result-text']";
//        WebElement txtEle1 = webDriver.findElement(By.xpath(txtXPath1));
//        System.out.println(txtEle1.getAttribute("textContent"));

        //Btn3
        String btn3XPath = "//button[@test-id='button3']";
        WebElement btn3Ele = webDriver.findElement(By.xpath(btn3XPath));
        Actions clickBtn3 = new Actions(webDriver);
        clickBtn3.moveToElement(btn3Ele).click();

        waitForDebug(5000);

        //Hãy nhấn vào một nút để kiểm tra sự kiện.
        String txtXPath2 = "//p[@test-id='buttons-result-text']";
        WebElement txtEle2 = webDriver.findElement(By.xpath(txtXPath2));
        System.out.println(txtEle2.getAttribute("textContent"));
        // need support: làm thế nào để log ra đc text đã thay đổi sau khi click?
    }

    @Test
    public void testRadioButtonInteraction() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.RADIO_BUTTON);

        //Do you like the site?
        String lblTitleXPath = "//h3[@test-id='radio-title']";
        WebElement lblTitleEle = webDriver.findElement(By.xpath(lblTitleXPath));

        //Yes
        String rdoYesXPath = "//label[@test-id='radio-label-yes']";
        WebElement rdoYesEle = webDriver.findElement(By.xpath(rdoYesXPath));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(rdoYesEle).click();

        //Impressive
        String rdoImpressiveXPath = "//label[@test-id='radio-label-impressive']";
        WebElement rdoImpressiveEle = webDriver.findElement(By.xpath(rdoImpressiveXPath));

        //No
        String rdoNoXPath = "//label[@test-id='radio-label-no']";
        WebElement rdoNoEle = webDriver.findElement(By.xpath(rdoNoXPath));

        String txtXPath = "//div[@test-id='radio-result']";
        WebElement txtEle = webDriver.findElement(By.xpath(txtXPath));
        System.out.println(txtEle.getAttribute("textContent"));
        // need support: làm thế nào để log ra đc text đã thay đổi sau khi click?
    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu form, Menu studentForm) {
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
