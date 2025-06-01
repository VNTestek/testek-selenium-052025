package com.testek.study.lesson06.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        //Title
        String lblTtlXPath = "//h3[@test-id='textbox-form-output-title']";
        WebElement lblTtlEle = webDriver.findElement(By.xpath(lblTtlXPath));

        //First name
        String lblFirstNameFieldXPath = "//label[@test-id='label-firstName']";
        WebElement firstNameFieldEle = webDriver.findElement(By.xpath(lblFirstNameFieldXPath));
        String inputFirstNameXPath = "//input[@id='firstName']";
        WebElement inputFirstNameEle = webDriver.findElement(By.xpath(inputFirstNameXPath));
        inputFirstNameEle.clear();
        inputFirstNameEle.sendKeys("La");


        //Last name
        String lblLastNameFieldXPath = "//label[@test-id='label-lastName']";
        WebElement lastNameFieldEle = webDriver.findElement(By.xpath(lblLastNameFieldXPath));
        String inputLastNameXPath = "//input[@id='lastName']";
        WebElement inputLastNameEle = webDriver.findElement(By.xpath(inputLastNameXPath));
        inputLastNameEle.clear();
        inputLastNameEle.sendKeys("Tieu Bao");

        //Email:
        String lblEmailFieldXPath = "//label[@test-id='label-email']";
        WebElement emailFieldEle = webDriver.findElement(By.xpath(lblEmailFieldXPath));
        String inputEmailXPath = "//input[@test-id='input-email']";
        WebElement inputEmailEle = webDriver.findElement(By.xpath(inputEmailXPath));
        inputEmailEle.clear();
        inputEmailEle.sendKeys("abc@gmail.com");


        //Gender:
        String lblGenderFieldXPath = "//label[@test-id='label-gender']";
        WebElement genderFieldEle = webDriver.findElement(By.xpath(lblGenderFieldXPath));
        String rdoMaleXPath = "//input[@id='male']";
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(rdoMaleXPath));
        String rdoFemaleXPath = "//input[@id='female']";
        WebElement rdoFemaleEle = webDriver.findElement(By.xpath(rdoFemaleXPath));
        rdoFemaleEle.click();

        boolean isFemaleChecked = webDriver.findElement(By.xpath(rdoFemaleXPath)).isSelected();

        //Mobile:
        String lblMobileFieldXPath = "//label[@test-id='label-mobile']";
        WebElement mobileFieldEle = webDriver.findElement(By.xpath(lblMobileFieldXPath));
        String inputMobileXPath = "//input[@id='mobile']";
        WebElement inputMobileEle = webDriver.findElement(By.xpath(inputMobileXPath));
        inputMobileEle.clear();
        inputMobileEle.sendKeys("0985666999");

        //Date of Birth:
        String lblDobFieldXPath = "//label[@test-id='label-dob']";
        WebElement dobFieldEle = webDriver.findElement(By.xpath(lblDobFieldXPath));
        String datePickerXPath = "//input[@type='date']";
        WebElement datePickerEle = webDriver.findElement(By.xpath(datePickerXPath));
        datePickerEle.clear();
        datePickerEle.sendKeys("01-01-1991");

        //Subjects:
        String lblSubjectsFieldXPath = "//label[@test-id='label-subjects']";
        WebElement subjectsFieldEle = webDriver.findElement(By.xpath(lblSubjectsFieldXPath));
        String inputSbjXPath = "//input[@id='subjects']";
        WebElement inputSbjEle = webDriver.findElement(By.xpath(inputSbjXPath));
        inputSbjEle.clear();
        inputSbjEle.sendKeys("Automation testing");

        //Hobbies:
        String lblHobbiesFieldXPath = "//label[@test-id='label-hobbies']";
        WebElement hobbiesFieldEle = webDriver.findElement(By.xpath(lblHobbiesFieldXPath));
        String chkReadingXPath = "//input[@id='reading']";
        WebElement chkReadingEle = webDriver.findElement(By.xpath(chkReadingXPath));
        chkReadingEle.click();
        String chkSportsXPath = "//input[@id='sports']";
        WebElement chkSportsEle = webDriver.findElement(By.xpath(chkSportsXPath));
        String chkMusicXPath = "//input[@id='music']";
        WebElement chkMusicEle = webDriver.findElement(By.xpath(chkMusicXPath));
        chkMusicEle.click();

        boolean isReadingChecked = webDriver.findElement(By.xpath(chkReadingXPath)).isSelected();
        boolean isSportChecked = webDriver.findElement(By.xpath(chkSportsXPath)).isSelected();
        boolean isMusicChecked = webDriver.findElement(By.xpath(chkMusicXPath)).isSelected();


        //Address:
        String lblAddressXPath = "//label[@test-id='label-address']";
        WebElement addressFieldEle = webDriver.findElement(By.xpath(lblAddressXPath));
        String inputAddressXPath = "//textarea[@id='address']";
        WebElement inputAddressEle = webDriver.findElement(By.xpath(inputAddressXPath));
        inputAddressEle.clear();
        inputAddressEle.sendKeys("Nam Tu Liem - Ha Noi");

        //Buttons
        String btnSubmitXPath = "//button[@id='submit-button']";
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(btnSubmitXPath));
        btnSubmitEle.click();
        String btnClearXPath = "//button[@id='reset-button']";
        WebElement btnClearEle = webDriver.findElement(By.xpath(btnClearXPath));

        //Wait for processing
        waitForDebug(2000);

        //Thông tin bạn đã nhập:
        String lblInputInfoFieldXPath = "//h3[@test-id='submitted-info-title']";
        WebElement inputInfoFieldEle = webDriver.findElement(By.xpath(lblInputInfoFieldXPath));
        //textarea[@test-id='outputTextStudent']
        String inputtedInfoXPath = "//textarea[@id='outputTextStudent']";
        WebElement inputtedInfoEle = webDriver.findElement(By.xpath(inputtedInfoXPath));
        String getInputInfoVal = inputtedInfoEle.getAttribute("value");
        System.out.println("Your information is: " + inputtedInfoEle.getAttribute("value"));


    }

    @Test
    public void testButtonsInteraction() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.BUTTONS);

        //Title Buttons
        String lblBtnXPath = "//h3[@test-id='buttons-title']";
        WebElement lblBtnEle = webDriver.findElement(By.xpath(lblBtnXPath));
        //Click me
        String btnClickMeXPath = "//button[@test-id='button-click-me']";
        WebElement btnClickMeEle = webDriver.findElement(By.xpath(btnClickMeXPath));
        btnClickMeEle.click();
        waitForDebug(2000);
        Alert alertClickMe = webDriver.switchTo().alert();
        alertClickMe.accept();
        //Confirm me
        String btnConfirmMeXPath = "//button[@test-id='button-confirm-me']";
        WebElement btnConfirmMeEle = webDriver.findElement(By.xpath(btnConfirmMeXPath));
        btnConfirmMeEle.click();
        Alert alertConfirm = webDriver.switchTo().alert();
        alertConfirm.accept();
        waitForDebug(2000);
        //Prompt me
        String btnPromptMeXPath = "//button[@test-id='button-prompt-me']";
        WebElement btnPromptMeEle = webDriver.findElement(By.xpath(btnPromptMeXPath));
        btnPromptMeEle.click();
        Alert alertPrompt = webDriver.switchTo().alert();
        alertPrompt.sendKeys("Automation testing");
        alertPrompt.accept();
        waitForDebug(3000);

        //Title Buttons with Different Actions (Click, Right-Click, Double-Click):
        String lblBtnWithDifferentActionsXPath = "//h3[@test-id='buttons-different-actions-title']";
        WebElement lblBtnWithDifferentActionsEle = webDriver.findElement(By.xpath(lblBtnWithDifferentActionsXPath));
        //Btn1
        String btn1XPath = "//button[@test-id='button1']";
        WebElement btn1Ele = webDriver.findElement(By.xpath(btn1XPath));
        btn1Ele.click();
        System.out.println();
        waitForDebug(2000);
        System.out.println("You clicked " + btn1Ele.getAttribute("textContent"));
        //Btn2
        String btn2XPath = "//button[@test-id='button2']";
        WebElement btn2Ele = webDriver.findElement(By.xpath(btn2XPath));
        btn2Ele.click();
        waitForDebug(2000);
        System.out.println("You clicked " + btn2Ele.getAttribute("textContent"));
        //Btn3
        String btn3XPath = "//button[@test-id='button3']";
        WebElement btn3Ele = webDriver.findElement(By.xpath(btn3XPath));
        btn3Ele.click();
        System.out.println("You clicked " + btn3Ele.getAttribute("textContent"));

        //Hãy nhấn vào một nút để kiểm tra sự kiện.
        String txtXPath = "//p[@test-id='buttons-result-text']";
        WebElement txtEle = webDriver.findElement(By.xpath(txtXPath));

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
        rdoYesEle.click();
        waitForDebug(2000);

        //Impressive
        String rdoImpressiveXPath = "//label[@test-id='radio-label-impressive']";
        WebElement rdoImpressiveEle = webDriver.findElement(By.xpath(rdoImpressiveXPath));
        waitForDebug(2000);

        //No
        String rdoNoXPath = "//label[@test-id='radio-label-no']";
        WebElement rdoNoEle = webDriver.findElement(By.xpath(rdoNoXPath));
        rdoNoEle.click();
    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu form, Menu studentForm) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
//        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.FORM.getName())));
        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, form.getName())));
        mnuElementEle.click();

        WebElement mnuEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, studentForm.getName())));
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
