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
    @Test(description = "Student Form Interaction Test", priority = 1)
    public void testInteraction() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Handle your code here
        // Define the locator format
        String FORM_XPATH_TITLE = "//h3[@test-id='%s']";
        String FORM_XPATH_LABEL = "//label[@test-id='%s']";
        String FORM_XPATH_PLACEHOLDER_INPUT = "//input[@placeholder='%s']";
        String FORM_XPATH_RADIOBUTTON_INPUT = "//label[@test-id='%s']";
        String dateDobXPath = "//input[@test-id='input-dob']";
        String FORM_XPATH_CHECKBOX_INPUT = "//label[@test-id='%s']";
        String FORM_XPATH_BUTTON = "//button[@test-id='%s']";
        String FORM_XPATH_TEXTAREA = "//textarea[@test-id='%s']";

        //Form Label
        String lblFirstName = String.format(FORM_XPATH_LABEL, "label-firstName");
        String lblLastName = String.format(FORM_XPATH_LABEL, "label-lastName");
        String lblEmail = String.format(FORM_XPATH_LABEL, "label-email");
        String lblGender = String.format(FORM_XPATH_LABEL, "label-gender");
        String lblMobile = String.format(FORM_XPATH_LABEL, "label-mobile");
        String lblDateOfBirth = String.format(FORM_XPATH_LABEL, "label-dob");
        String lblSubjects = String.format(FORM_XPATH_LABEL, "label-subjects");
        String lblHobbies = String.format(FORM_XPATH_LABEL, "label-hobbies");
        String lblAddress = String.format(FORM_XPATH_LABEL, "label-address");

        //Find Element label
        webDriver.findElement(By.xpath(lblFirstName));
        webDriver.findElement(By.xpath(lblLastName));
        webDriver.findElement(By.xpath(lblEmail));
        webDriver.findElement(By.xpath(lblMobile));
        webDriver.findElement(By.xpath(lblGender));
        webDriver.findElement(By.xpath(lblDateOfBirth));
        webDriver.findElement(By.xpath(lblSubjects));
        webDriver.findElement(By.xpath(lblHobbies));
        webDriver.findElement(By.xpath(lblAddress));

        //Title
        String lblBrowserWindowsXPath = String.format(FORM_XPATH_TITLE, "browser-windows-title");
        String lblStudentRegistrationXpath = String.format(FORM_XPATH_TITLE, "student-registration-title");
        String lblSubmittedInfoXPath = String.format(FORM_XPATH_TITLE, "submitted-info-title");

        WebElement lblBrowserWindowsEle = webDriver.findElement(By.xpath(lblBrowserWindowsXPath));
        WebElement lblStudentRegistrationEle = webDriver.findElement(By.xpath(lblStudentRegistrationXpath));
        WebElement lblSubmittedInfoEle = webDriver.findElement(By.xpath(lblSubmittedInfoXPath));


        //Form textbox
        String txtFirstNameXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your first name");
        WebElement txtFirstNameEle = webDriver.findElement(By.xpath(txtFirstNameXPath));
        txtFirstNameEle.clear();
        txtFirstNameEle.sendKeys("Vu");

        String txtLastNameXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your last name");
        WebElement txtLastNameEle = webDriver.findElement(By.xpath(txtLastNameXPath));
        txtLastNameEle.clear();
        txtLastNameEle.sendKeys("Hiep");

        String txtEmailXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your email");
        WebElement txtEmailEle = webDriver.findElement(By.xpath(txtEmailXPath));
        txtEmailEle.clear();
        txtEmailEle.sendKeys("vuhiep465@gmail.com");

        String txtMobileXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your mobile number");
        WebElement txtMobileEle = webDriver.findElement(By.xpath(txtMobileXPath));
        txtMobileEle.clear();
        txtMobileEle.sendKeys("0327457186");

        String txtSubjectsXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your subjects");
        WebElement txtSubjectsEle = webDriver.findElement(By.xpath(txtSubjectsXPath));
        txtSubjectsEle.clear();
        txtSubjectsEle.sendKeys("Automation Web Testing");

        //Gender Radio button
        String rdoMaleXPath = String.format(FORM_XPATH_RADIOBUTTON_INPUT, "label-male");
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(rdoMaleXPath));

        String rdoFemaleXPath = String.format(FORM_XPATH_RADIOBUTTON_INPUT, "label-female");
        WebElement rdoFemaleEle = webDriver.findElement(By.xpath(rdoFemaleXPath));

        rdoMaleEle.click();

        //Hobbies Checkbox
        String chkReadingXPath = String.format(FORM_XPATH_CHECKBOX_INPUT, "label-reading");
        WebElement chkReadingEle = webDriver.findElement(By.xpath(chkReadingXPath));
        chkReadingEle.click();

        String chkSportsXPath = String.format(FORM_XPATH_CHECKBOX_INPUT, "label-sports");
        WebElement chkSportSEle = webDriver.findElement(By.xpath(chkSportsXPath));
        chkSportSEle.click();

        String chkMusicXPath = String.format(FORM_XPATH_CHECKBOX_INPUT, "label-music");
        WebElement chkMusicEle = webDriver.findElement(By.xpath(chkMusicXPath));
        chkMusicEle.click();


        //dob
        WebElement dateDobEle = webDriver.findElement(By.xpath(dateDobXPath));
        dateDobEle.clear();
        dateDobEle.sendKeys("09102003");

        //Address
        String taAddressXPath = String.format(FORM_XPATH_TEXTAREA, "textarea-address");
        WebElement taAddressEle = webDriver.findElement(By.xpath(taAddressXPath));
        taAddressEle.clear();
        taAddressEle.sendKeys("Ha Noi");

        waitForDebug(3000);

        //Submit Button
        String btnSubmitXPath = String.format(FORM_XPATH_BUTTON, "submit-button");
        WebElement btnSubmitELe = webDriver.findElement(By.xpath(btnSubmitXPath));
        btnSubmitELe.click();


        waitForDebug(5000);

        //Text area
        String taOutputTextXPath = String.format(FORM_XPATH_TEXTAREA, "outputTextStudent");
        WebElement taOutputTextEle = webDriver.findElement(By.xpath(taOutputTextXPath));
        String info = taOutputTextEle.getAttribute("value");
        System.out.println("Your information: " + info);

        //Clear button
        String btnClearXPath = String.format(FORM_XPATH_BUTTON, "reset-button");
        WebElement btnClearEle = webDriver.findElement(By.xpath(btnClearXPath));
        btnClearEle.click();

        waitForDebug(3000);
    }

    @Test(description = "Buttons Interaction Test", priority = 2)
    public void testButtonsInteraction() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.BUTTONS);

        // Define the locator format
        String FORM_XPATH_BUTTONS_TITLE = "//h3[@test-id='%s']";
        String FORM_XPATH_BUTTONS = "//button[@test-id='%s']";

        //Title
        String lblButtonsTitleXPath = String.format(FORM_XPATH_BUTTONS_TITLE, "buttons-title");
        WebElement lblButtonsTitleEle = webDriver.findElement(By.xpath(lblButtonsTitleXPath));

        String lblButtonActionsTitleXPath = String.format(FORM_XPATH_BUTTONS_TITLE, "buttons-different-actions-title");
        WebElement lblButtonActionsTitleEle = webDriver.findElement(By.xpath(lblButtonActionsTitleXPath));

        //Buttons
        //Click Me
        String btnClickMeXPath = String.format(FORM_XPATH_BUTTONS, "button-click-me");
        WebElement btnClickMeEle = webDriver.findElement(By.xpath(btnClickMeXPath));
        btnClickMeEle.click();
        waitForDebug(3000);
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

        //Confirm Me
        String btnConfirmMeXPath = String.format(FORM_XPATH_BUTTONS, "button-confirm-me");
        WebElement btnConfirmMeEle = webDriver.findElement(By.xpath(btnConfirmMeXPath));
        btnConfirmMeEle.click();
        waitForDebug(3000);
        alert = webDriver.switchTo().alert();
        alert.accept();

        //Prompt Me
        String btnPromptMeXPath = String.format(FORM_XPATH_BUTTONS, "button-prompt-me");
        WebElement btnPromptMeEle = webDriver.findElement(By.xpath(btnPromptMeXPath));
        btnPromptMeEle.click();
        alert.sendKeys("Minh Hiep");
        waitForDebug(3000);
        alert.accept();

        //Buttons different actions
        //Button 1
        String btn1Xpath = String.format(FORM_XPATH_BUTTONS, "button1");
        WebElement btn1Ele = webDriver.findElement(By.xpath(btn1Xpath));
        btn1Ele.click();
        waitForDebug(3000);

        //Button 2
        String btn2XPath = String.format(FORM_XPATH_BUTTONS, "button2");
        WebElement btn2Ele = webDriver.findElement(By.xpath(btn2XPath));
        btn2Ele.click();
        waitForDebug(3000);

        //Button 3
        String btn3XPath = String.format(FORM_XPATH_BUTTONS, "button3");
        WebElement btn3Ele = webDriver.findElement(By.xpath(btn3XPath));
        btn3Ele.click();
        waitForDebug(3000);
    }

    @Test(description = "Buttons Interaction Test", priority = 3)
    public void testRadioButtonsInteraction() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.RADIO_BUTTON);

        //Radio title
        String lblRadioTitleXPath = "//h3[@test-id='radio-title']";
        WebElement lblRadioTitleEle = webDriver.findElement(By.xpath(lblRadioTitleXPath));

        //Radio buttons
        String FORM_XPATH_RADIO_BUTTONS = "//label[@test-id='%s']";

        //Yes
        String rdoYesXPath = String.format(FORM_XPATH_RADIO_BUTTONS, "radio-label-yes");
        WebElement rdoYesEle = webDriver.findElement(By.xpath(rdoYesXPath));
        rdoYesEle.click();
        waitForDebug(3000);

        //Impressive
        String rdoImpressiveXPath = String.format(FORM_XPATH_RADIO_BUTTONS, "radio-label-impressive");
        WebElement rdoImpressiveEle = webDriver.findElement(By.xpath(rdoImpressiveXPath));
        rdoImpressiveEle.click();
        waitForDebug(3000);

        //No
        String rdoNoXPath = String.format(FORM_XPATH_RADIO_BUTTONS, "radio-label-no");
        WebElement rdoNoEle = webDriver.findElement(By.xpath(rdoNoXPath));
        rdoNoEle.click();
        waitForDebug(3000);
    }
    /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu parent, Menu submenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, parent.getName())));
        mnuElementEle.click();

        WebElement mnuEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, submenu.getName())));
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
