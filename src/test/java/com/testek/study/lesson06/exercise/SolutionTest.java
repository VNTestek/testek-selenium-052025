package com.testek.study.lesson06.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

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
    @Test(description = "1: Find elements in Student Form")
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);
        //First Name
        String txtFirstName = "//input[contains(@placeholder,'first')]";
        WebElement txtFirstNameEle = webDriver.findElement(By.xpath(txtFirstName));
        txtFirstNameEle.clear();
        txtFirstNameEle.sendKeys("Anh");
        waitForDebug(1000);

        //Last Name
        String txtLastName = "//input[@id='lastName']";
        WebElement txtLastNameEle = webDriver.findElement(By.xpath(txtLastName));
        txtLastNameEle.clear();
        txtLastNameEle.sendKeys("Thai");
        waitForDebug(1000);

        //Email
        String txtEmail = "//label[@test-id='label-gender']/preceding-sibling::input[@id='email']";
        WebElement txtEmailEle = webDriver.findElement(By.xpath(txtEmail));
        txtEmailEle.clear();
        txtEmailEle.sendKeys("anhthai07@gmail.com");
        waitForDebug(1000);

        //GENDER:
        String rdoMale = "//input[@name='gender' and @value='Male']";
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(rdoMale));
        rdoMaleEle.click();
        waitForDebug(1000);

        //Mobile
        String txtMobile = "//label[@test-id='label-mobile']/following-sibling::input[@id='mobile']";
        WebElement txtMobileEle = webDriver.findElement(By.xpath(txtMobile));
        txtMobileEle.clear();
        txtMobileEle.sendKeys("0904549984");
        waitForDebug(1000);

        //DOB
        String dpcDob = "//input[contains(@test-id,'t-dob')]";
        WebElement dpcDobEle = webDriver.findElement(By.xpath(dpcDob));
        dpcDobEle.sendKeys("07301984");
        waitForDebug(1000);

        //Subject
        String txtSubject = "//form[@id='studentRegistrationForms']/child::input[@id='subjects']";
        WebElement txtSubjectEle = webDriver.findElement(By.xpath(txtSubject));
        txtSubjectEle.clear();
        txtSubjectEle.sendKeys("Java Selenium is very Hard :((");
        waitForDebug(1000);

        //Hobbies:
        String chkReading = "//input[@value='Reading']";
        WebElement chkReadingEle = webDriver.findElement(By.xpath(chkReading));
        chkReadingEle.click();
        waitForDebug(1000);

        String chkSports = "//input[@id='sports']";
        WebElement chkSportsEle = webDriver.findElement(By.xpath(chkSports));
        chkSportsEle.click();
        waitForDebug(1000);

        String chkMusic = "//input[starts-with(@id,'mus')]";
        WebElement chkMusicEle = webDriver.findElement(By.xpath(chkMusic));
        chkMusicEle.click();
        waitForDebug(1000);

        //Address:
        String txtAddress = "//textarea[@id = 'address']";
        WebElement txtAddressEle = webDriver.findElement(By.xpath(txtAddress));
        txtAddressEle.clear();
        txtAddressEle.sendKeys("I'm from Hanoi");
        waitForDebug(1000);

        //Submit
        String btnSubmit = "//button[@test-id = 'submit-button']";
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(btnSubmit));
        btnSubmitEle.click();

        //TEXTAREA:
        String textareaRes = "//textarea[@id='outputTextStudent']";
        WebElement textareaResEle = webDriver.findElement(By.xpath(textareaRes));
        System.out.println(textareaResEle.getAttribute("value"));

        //Clear
        String btnClear = "//button[@test-id='reset-button']";
        WebElement btnClearEle = webDriver.findElement(By.xpath(btnClear));
        btnClearEle.click();
        waitForDebug(1000);
    }

    @Test(description = "2: Find elements with Button")
    public void testBtnInteraction() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.BUTTONS);

        String XPATH_BUTTON = "//button[@test-id = '%s']";

        //click-me
        String btnClickMeXPath = String.format(XPATH_BUTTON, "button-click-me");
        WebElement btnClickMeEle = webDriver.findElement(By.xpath(btnClickMeXPath));
        btnClickMeEle.click();
        waitForDebug(1000);
        Alert alertClickMe = webDriver.switchTo().alert();
        alertClickMe.accept();
        System.out.println(btnClickMeEle.getText());

        //confirm-me
        String btnConfirmMeXPath = String.format(XPATH_BUTTON, "button-confirm-me");
        WebElement btnConfirmMeEle = webDriver.findElement(By.xpath(btnConfirmMeXPath));
        btnConfirmMeEle.click();
        waitForDebug(1000);
        Alert alertConfirm = webDriver.switchTo().alert();
        alertConfirm.accept();
        System.out.println(btnConfirmMeEle.getText());

        //prompt-me
        String btnPromptMeXPath = String.format(XPATH_BUTTON, "button-prompt-me");
        WebElement btnPromptMeEle = webDriver.findElement(By.xpath(btnPromptMeXPath));
        btnPromptMeEle.click();
        waitForDebug(2000);
        Alert alertPrompt = webDriver.switchTo().alert();
        alertPrompt.sendKeys("anhTraiSayHi");
        alertPrompt.accept();
        System.out.println(btnPromptMeEle.getText());

        String lblResult = "resultText";
        WebElement lblResultEle = webDriver.findElement(By.id(lblResult));

        //BUTTON 1
        String btn1XPath = String.format(XPATH_BUTTON, "button1");
        WebElement btn1Ele = webDriver.findElement(By.xpath(btn1XPath));
        btn1Ele.click();
        System.out.println(lblResultEle.getText());
        waitForDebug(1000);

        //BUTTON 2
        String btn2XPath = String.format(XPATH_BUTTON, "button2");
        WebElement btn2Ele = webDriver.findElement(By.xpath(btn2XPath));
        btn2Ele.click();
        System.out.println(lblResultEle.getText());
        waitForDebug(1000);

        //BUTTON 3
        String btn3XPath = String.format(XPATH_BUTTON, "button3");
        WebElement btn3Ele = webDriver.findElement(By.xpath(btn3XPath));
        btn3Ele.click();
        System.out.println(lblResultEle.getText());
        waitForDebug(1000);
    }


    @Test(description = "3: Find elements with Radio button")
    public void testRdoInteraction() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.RADIO_BUTTON);

        // Define the locator format
        String XPATH_RADIO = "//input[@type = 'radio' and @test-id  = '%s']";

        String rdoResult = "//div[@test-id='radio-result']";
        WebElement rdoResultEle = webDriver.findElement(By.xpath(rdoResult));

        String rdoYes = String.format(XPATH_RADIO, "radio-input-yes");
        WebElement rdoYesEle = webDriver.findElement(By.xpath(rdoYes));
        rdoYesEle.click();
        System.out.println("Yes: " + rdoResultEle.getText());
        waitForDebug(1000);

        String rdoImpressive = String.format(XPATH_RADIO, "radio-input-impressive");
        WebElement rdoImpressiveEle = webDriver.findElement(By.xpath(rdoImpressive));
        rdoImpressiveEle.click();
        System.out.println("Impressive: " + rdoResultEle.getText());
        waitForDebug(1000);

        String rdoNo = String.format(XPATH_RADIO, "radio-input-no");
        WebElement rdoNoEle = webDriver.findElement(By.xpath(rdoNo));
        rdoNoEle.click();
        System.out.println("No: " + rdoResultEle.getText());
        waitForDebug(1000);
    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu parent, Menu subMenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, parent.getName())));
        mnuElementEle.click();

        WebElement mnuEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, subMenu.getName())));
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
