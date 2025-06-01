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

        /**
         * Voi case dung trinh duyet firefox lam mac dinh
         * */
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("--width=1920");
//        firefoxOptions.addArguments("--height=1080");
//        webDriver = new FirefoxDriver(firefoxOptions);
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
//        gotoTestWebsite();

        // Handle your code here
    }

    /**
     * Go to Test Website
     */
//    private void gotoTestWebsite() {
//        String url = "https://testek.vn/lab/auto/web-elements/";
//        webDriver.get(url);
//
//        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";
//
//        // Access: Form > [Student Form]
//        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.FORM.getName())));
//        mnuElementEle.click();
//
//        WebElement mnuEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.STUDENT_FORM.getName())));
//        mnuEle.click();
//
//        waitForDebug(5000);
//    }

    void gotoTestWebsite(Menu element, Menu subElement) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
//        webDriver.manage().window().fullscreen(); //Hien thi man hinh full

        // Access: Elements > [Menu]
        String mnuElementXPath = String.format("//div[@test-id='%s']", element.getName());
        WebElement mnuElementEle = webDriver.findElement(By.xpath(mnuElementXPath));
        mnuElementEle.click();

        String mnuXPath = String.format("//div[@test-id='%s']", subElement.getName());
        WebElement mnuEle = webDriver.findElement(By.xpath(mnuXPath));
        mnuEle.click();
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

    @Test(description = "Bai 1: Find element with Student Form")
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);
        //TIM TEXT BOX: First Name
        String txtFirstName = "//input[contains(@placeholder,'first')]";
        WebElement txtFirstNameEle = webDriver.findElement(By.xpath(txtFirstName));
        txtFirstNameEle.clear();
        txtFirstNameEle.sendKeys("Vũ Thị Kim");
        waitForDebug(1000);

        //TIM TEXT BOX: Last Name
        String txtLastName = "//input[@id='lastName']";
        WebElement txtLastNameEle = webDriver.findElement(By.xpath(txtLastName));
        txtLastNameEle.clear();
        txtLastNameEle.sendKeys("Chi");
        waitForDebug(1000);

        //TIM TEXT BOX: Email
        String txtEmail = "//label[@test-id='label-gender']/preceding-sibling::input[@id='email']";
        WebElement txtEmailEle = webDriver.findElement(By.xpath(txtEmail));
        txtEmailEle.clear();
        txtEmailEle.sendKeys("vukimchi023@gmail.com");
        waitForDebug(1000);

        //TIM RADIO BUTTON GENDER:
        String rdoMale = "//input[@name='gender' and @value='Male']";
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(rdoMale));
        rdoMaleEle.click();
        boolean isCheckedMale = rdoMaleEle.isSelected();
        System.out.println("Male checked: " + isCheckedMale);
        waitForDebug(1000);

        String rdoFemale = "//input[contains(@id,'fe')]";
        WebElement rdoFemaleEle = webDriver.findElement(By.xpath(rdoFemale));
        rdoFemaleEle.click();
        boolean isCheckedFemale = rdoFemaleEle.isSelected();
        System.out.println("Female checked: " + isCheckedFemale);
        waitForDebug(1000);

        //TIM TEXT BOX: Mobile
        String txtMobile = "//label[@test-id='label-mobile']/following-sibling::input[@id='mobile']";
        WebElement txtMobileEle = webDriver.findElement(By.xpath(txtMobile));
        txtMobileEle.clear();
        txtMobileEle.sendKeys("0374975400");
        waitForDebug(1000);

        //TIM DATEPICKER: DOB
        //TH nhập trực tiếp ngày tháng vào ô input
        String dpcDob = "//input[contains(@test-id,'t-dob')]";
        WebElement dpcDobEle = webDriver.findElement(By.xpath(dpcDob));
        dpcDobEle.sendKeys("01/06/2002");
//        WebElement dateInput = webDriver.findElement(By.id("dob"));
//        ((JavascriptExecutor) webDriver).executeScript("arguments[0].value = '2025-05-31';", dpcDobEle);
        waitForDebug(1000);

        //TIM TEXT BOX: Subject
        String txtSubject = "//form[@id='studentRegistrationForms']/child::input[@id='subjects']";
        WebElement txtSubjectEle = webDriver.findElement(By.xpath(txtSubject));
        txtSubjectEle.clear();
        txtSubjectEle.sendKeys("Math");
        waitForDebug(1000);

        //TIM CHECKBOX Hobbies:
        String chkReading = "//input[@value='Reading']";
        WebElement chkReadingEle = webDriver.findElement(By.xpath(chkReading));
        chkReadingEle.click();
        boolean isCheckedReading = chkReadingEle.isSelected();
        System.out.println("Reading checked: " + isCheckedReading);
        chkReadingEle.click();
        System.out.println("Reading unchecked: " + chkReadingEle.isSelected());
        waitForDebug(1000);

        String chkSports = "//input[@id='sports']";
        WebElement chkSportsEle = webDriver.findElement(By.xpath(chkSports));
        chkSportsEle.click();
        boolean isCheckedSports = chkSportsEle.isSelected();
        System.out.println("Sports checked: " + isCheckedSports);
        waitForDebug(1000);

        String chkMusic = "//input[starts-with(@id,'mus')]";
        WebElement chkMusicEle = webDriver.findElement(By.xpath(chkMusic));
        chkMusicEle.click();
        boolean isCheckedMusic = chkMusicEle.isSelected();
        System.out.println("Music checked: " + isCheckedMusic);
        waitForDebug(1000);

        //TIM TEXTAREA Address:
        String txtAddress = "//form[@id='studentRegistrationForms']/descendant::textarea[@id='address']";
        WebElement txtAddressEle = webDriver.findElement(By.xpath(txtAddress));
        txtAddressEle.clear();
        txtAddressEle.sendKeys("Hà Nội");
        waitForDebug(1000);

        //TIM BUTTON: #submit-button
        String btnSubmit = "#submit-button";
        WebElement btnSubmitEle = webDriver.findElement(By.cssSelector(btnSubmit));
        btnSubmitEle.click();

        //TIM TEXTAREA Thông tin bạn đã nhập:
        String textareaRes = "//textarea[@id='outputTextStudent']";
        WebElement textareaResEle = webDriver.findElement(By.xpath(textareaRes));
        String outputInfo = textareaResEle.getAttribute("value");
        System.out.println("-------------------BAI 1-------------------");
        System.out.println(outputInfo);
    }

    @Test(description = "Bai 2: Find element with Button")
    public void testBtn() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.BUTTONS);

        //BUTTON CLICK ME:
        String btnClickMe = "//button[@test-id='button-click-me']";
        WebElement btnClickMeEle = webDriver.findElement(By.xpath(btnClickMe));
        btnClickMeEle.click();
        // Chờ alert xuat hiện
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        // Chuyển sang alert và accept
        Alert alert = webDriver.switchTo().alert();
        System.out.println("-------------------BAI 2-------------------");
        System.out.println("Button click me text: " + alert.getText());
        alert.accept(); //alert.dismiss(); //Từ chối Alert (Cancel / Dismiss)
        waitForDebug(1000);

        //BUTTON CONFIRM ME:
        String btnConfirmMe = "//button[@test-id='button-confirm-me']";
        WebElement btnConfirmMeEle = webDriver.findElement(By.xpath(btnConfirmMe));
        btnConfirmMeEle.click();
        // Chờ alert xuất hiện
        wait.until(ExpectedConditions.alertIsPresent());
        // Chuyển sang alert và accept
        alert = webDriver.switchTo().alert();
        System.out.println("Button confirm me text: " + alert.getText());
        alert.accept(); //alert.dismiss(); //Từ chối Alert (Cancel / Dismiss)
        waitForDebug(1000);

        //BUTTON PROMPT ME:
        String btnPromptMe = "//button[@test-id='button-prompt-me']";
        WebElement btnPromptMeEle = webDriver.findElement(By.xpath(btnPromptMe));
        btnPromptMeEle.click();
        // Chờ alert xuất hiện
        wait.until(ExpectedConditions.alertIsPresent());
        // Chuyển sang alert và accept
        alert = webDriver.switchTo().alert();
        //alert.sendKeys("Kim Chi"); //K sendkeys dc ????
        System.out.println("Button Prompt me text: " + alert.getText());
        alert.accept(); //alert.dismiss(); //Từ chối Alert (Cancel / Dismiss)
        waitForDebug(1000);

        //BUTTON 1:
        String btnButton1 = "//button[@id='button1']";
        WebElement btnButton1Ele = webDriver.findElement(By.xpath(btnButton1));
        btnButton1Ele.click();
        String lblResult = "resultText";
        WebElement lblResultEle = webDriver.findElement(By.id(lblResult));
        System.out.println(lblResultEle.getText());
        waitForDebug(1000);

        //BUTTON 2:
        String btnButton2 = "//button[@id='button2']";
        WebElement btnButton2Ele = webDriver.findElement(By.xpath(btnButton2));
        btnButton2Ele.click();
        System.out.println(lblResultEle.getText());
        waitForDebug(1000);

        //BUTTON 3:
        String btnButton3 = "//button[@id='button3']";
        WebElement btnButton3Ele = webDriver.findElement(By.xpath(btnButton3));
        btnButton3Ele.click();
        System.out.println(lblResultEle.getText());
        waitForDebug(1000);
    }

    @Test(description = "Bai 3: Find element with Radio button")
    public void testRdo(){
        gotoTestWebsite(Menu.ELEMENTS, Menu.RADIO_BUTTON);
        String rdoYes = "//label[@test-id='radio-label-yes']";
        WebElement rdoYesEle = webDriver.findElement(By.xpath(rdoYes));
        rdoYesEle.click();

        String rdoResult = "//div[@test-id='radio-result']";
        WebElement rdoResultEle = webDriver.findElement(By.xpath(rdoResult));
        System.out.println("-------------------BAI 3-------------------");
        System.out.println("Yes radio button text: " + rdoResultEle.getText());

        String rdoImpressive  = "//label[@test-id='radio-label-impressive']";
        WebElement rdoImpressiveEle = webDriver.findElement(By.xpath(rdoImpressive));
        rdoImpressiveEle.click();
        System.out.println("Impressive radio button text: " + rdoResultEle.getText());

        String rdoNo  = "//label[@test-id='radio-label-no']";
        WebElement rdoNoEle = webDriver.findElement(By.xpath(rdoNo));
        rdoImpressiveEle.click();
        System.out.println("Impressive radio button text: " + rdoResultEle.getText());
    }
}
