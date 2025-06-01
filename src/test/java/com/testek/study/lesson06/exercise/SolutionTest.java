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
    @Test(description = "Student Form Interaction")
    public void testStudentFormInteraction() {
        gotoTestWebsite();

        // Handle your code here

        // Define the locator format
        String XPATH_H3_TITLE_FORM = "//h3[@id = '%s']";
        String XPATH_LBL_FORM = "//label[@for = '%s']";
        String XPATH_INPUT_TEXT_FORM = "//input[@placeholder = '%s']";
        String XPATH_RADIO_FORM = "//input[@type = 'radio' and @id = '%s']";
        String XPATH_DATE_FORM = "//input[@type = 'date' and @id = '%s']";
        String XPATH_CHECKBOX_FORM = "//input[@type = 'checkbox' and @id = '%s']";
        String XPATH_BUTTON_FORM = "//button[normalize-space() = '%s']";
        String XPATH_TXT_AREA_FORM = "//textarea[@id = '%s']";

        // Find elements & interact
        // Browser Windows lbl
        String lblBrowserWindowsTitleXPath = String.format(XPATH_H3_TITLE_FORM, "browser-windows-title");
        webDriver.findElement(By.xpath(lblBrowserWindowsTitleXPath));

        // Form đăng ký sinh viên lbl
        String lblFormTitleXPath = String.format(XPATH_H3_TITLE_FORM, "student-registration-title");
        webDriver.findElement(By.xpath(lblFormTitleXPath));

        //First Name lbl
        String lblFirstNameXPath = String.format(XPATH_LBL_FORM, "firstName");
        webDriver.findElement(By.xpath(lblFirstNameXPath));
        //First Name txt
        String txtFirstNameXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your first name");
        WebElement txtFirstNameEle = webDriver.findElement(By.xpath(txtFirstNameXPath));
        txtFirstNameEle.clear();
        txtFirstNameEle.sendKeys("Trinh");

        //Last Name lbl
        String lblLastNameXPath = String.format(XPATH_LBL_FORM, "lastName");
        webDriver.findElement(By.xpath(lblLastNameXPath));
        //Last Name txt
        String txtLastNameXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your last name");
        WebElement txtLastNameEle = webDriver.findElement(By.xpath(txtLastNameXPath));
        txtLastNameEle.clear();
        txtLastNameEle.sendKeys("Toan");

        //Email lbl
        String lblEmailXPath = String.format(XPATH_LBL_FORM, "email");
        webDriver.findElement(By.xpath(lblEmailXPath));
        //Email txt
        String txtEmailXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your email");
        WebElement txtEmailEle = webDriver.findElement(By.xpath(txtEmailXPath));
        txtEmailEle.clear();
        txtEmailEle.sendKeys("tkt27@gmail.com");

        //Gender lbl
        String lblGenderXPath = String.format(XPATH_LBL_FORM, "gender");
        webDriver.findElement(By.xpath(lblGenderXPath));
        //Male RDO
        String rdoMaleXPath = String.format(XPATH_RADIO_FORM, "male");
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(rdoMaleXPath));
        //Female RDO
        String rdoFemaleXPath = String.format(XPATH_RADIO_FORM, "female");
        webDriver.findElement(By.xpath(rdoFemaleXPath));
        //select Male RRO
        rdoMaleEle.click();

        //Mobile lbl
        String lblMobileXPath = String.format(XPATH_LBL_FORM, "mobile");
        webDriver.findElement(By.xpath(lblMobileXPath));
        //Mobile txt
        String txtMobileXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your mobile number");
        WebElement txtMobileEle = webDriver.findElement(By.xpath(txtMobileXPath));
        txtMobileEle.clear();
        txtMobileEle.sendKeys("09145609999");

        //Date of Birth lbl
        String lblDobXPath = String.format(XPATH_LBL_FORM, "dob");
        webDriver.findElement(By.xpath(lblDobXPath));
        //Date of Birth input
        String dateDobXPath = String.format(XPATH_DATE_FORM, "dob");
        WebElement dateDobEle = webDriver.findElement(By.xpath(dateDobXPath));
        dateDobEle.clear();
        dateDobEle.sendKeys("20101999");

        //Subjects lbl
        String lblSubjectsXPath = String.format(XPATH_LBL_FORM, "subjects");
        webDriver.findElement(By.xpath(lblSubjectsXPath));
        //Subjects txt
        String txtSubjectsXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your subjects");
        WebElement txtSubjectsEle = webDriver.findElement(By.xpath(txtSubjectsXPath));
        txtSubjectsEle.clear();
        txtSubjectsEle.sendKeys("Auto test Selenium");

        //Hobbies lbl
        String lblHobbiesXPath = String.format(XPATH_LBL_FORM, "hobbies");
        webDriver.findElement(By.xpath(lblHobbiesXPath));
        //Reading CHK
        String chkReadingXPath = String.format(XPATH_CHECKBOX_FORM, "reading");
        WebElement chkReadingEle = webDriver.findElement(By.xpath(chkReadingXPath));
        //Sports CHK
        String chkSportsXPath = String.format(XPATH_CHECKBOX_FORM, "sports");
        WebElement chkSportsEle = webDriver.findElement(By.xpath(chkSportsXPath));
        //Music CHK
        String chkMusicXPath = String.format(XPATH_CHECKBOX_FORM, "music");
        WebElement chkMusicEle = webDriver.findElement(By.xpath(chkMusicXPath));
        //select only Music CHK
        boolean isReadingChecked = chkReadingEle.isSelected();
        boolean isSportsChecked = chkSportsEle.isSelected();
        boolean isMusicChecked = chkMusicEle.isSelected();
        if (isReadingChecked) {
            chkReadingEle.click();
        }
        if (isSportsChecked) {
            chkSportsEle.click();
        }
        if (!isMusicChecked) {
            chkMusicEle.click();
        }

        //Address lbl
        String lblAddressXPath = String.format(XPATH_LBL_FORM, "address");
        webDriver.findElement(By.xpath(lblAddressXPath));
        //Address txt
        String txtAddressXPath = String.format(XPATH_TXT_AREA_FORM, "address");
        WebElement txtAddressEle = webDriver.findElement(By.xpath(txtAddressXPath));
        txtAddressEle.clear();
        txtAddressEle.sendKeys("Ha Noi - Viet Nam");

        //submit btn
        String btnSubmitXPath = String.format(XPATH_BUTTON_FORM, "Submit");
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(btnSubmitXPath));
        btnSubmitEle.click();

        /* Fail

        //clear btn
        String btnClearFormXPath = String.format(XPATH_BUTTON_FORM, "Clear");
        WebElement btnClearFormEle = webDriver.findElement(By.xpath(btnClearFormXPath));
        try {
//         Create a wait driver
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//         Wait for your element to ready click
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnClearFormEle));
            btnClearFormEle.click();
        } catch (Exception e) {
//            System.out.println("Click Clear BTN fail ERR: " + e.getMessage());
            throw new RuntimeException("Click Clear BTN fail ERR: ", e);
        }

         */

        waitForDebug(5000);
    }

    @Test(description = "Buttons Interaction")
    public void testButtonsInteraction() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.BUTTONS);

        String XPATH_BUTTON_FORM = "//button[@test-id = '%s']";

        //Buttons Block
        //button-click-me
        String btnClickMeXPath = String.format(XPATH_BUTTON_FORM, "button-click-me");
        WebElement btnClickMeEle = webDriver.findElement(By.xpath(btnClickMeXPath));
        btnClickMeEle.click();
        //Alert popup handle
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

        //button-confirm-me
        String btnConfirmMeXPath = String.format(XPATH_BUTTON_FORM, "button-confirm-me");
        WebElement btnConfirmMeEle = webDriver.findElement(By.xpath(btnConfirmMeXPath));
        btnConfirmMeEle.click();
        //Alert popup handle
        alert = webDriver.switchTo().alert();
        alert.accept();

        //button-prompt-me
        String btnPromptMeXPath = String.format(XPATH_BUTTON_FORM, "button-prompt-me");
        WebElement btnPromptMeEle = webDriver.findElement(By.xpath(btnPromptMeXPath));
        btnPromptMeEle.click();
        //Alert popup handle
        alert = webDriver.switchTo().alert();
        alert.sendKeys("MK");
        waitForDebug(2000);
        alert.accept();

        //Buttons with Different Actions(Click, Right - Click, Double - Click):
        //Hãy nhấn vào một nút để kiểm tra sự kiện.
        WebElement lblButtonsResultTextEle = webDriver.findElement(By.xpath("//p[@test-id='buttons-result-text']"));

        //button1
        String btn1XPath = String.format(XPATH_BUTTON_FORM, "button1");
        WebElement btn1Ele = webDriver.findElement(By.xpath(btn1XPath));
        btn1Ele.click();
        System.out.println(lblButtonsResultTextEle.getText());
        waitForDebug(2000);

        //button2
        String btn2XPath = String.format(XPATH_BUTTON_FORM, "button2");
        WebElement btn2Ele = webDriver.findElement(By.xpath(btn2XPath));
        btn2Ele.click();
        System.out.println(lblButtonsResultTextEle.getText());
        waitForDebug(2000);

        //button3
        String btn3XPath = String.format(XPATH_BUTTON_FORM, "button3");
        WebElement btn3Ele = webDriver.findElement(By.xpath(btn3XPath));
        btn3Ele.click();
        System.out.println(lblButtonsResultTextEle.getText());
        waitForDebug(2000);

        waitForDebug(5000);
    }

    @Test(description = "Radio Button Interaction")
    public void testRadioButtonInteraction() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.RADIO_BUTTON);
        //label[@test-id='radio-label-yes']
        String XPATH_RDO_LBL_FORM = "//label[@test-id = '%s']";

        //radio result
        WebElement lblRadioResultEle = webDriver.findElement(By.cssSelector("div[test-id='radio-result']"));

        //RDO Do you like the site?
        //select Yes
        String lblRDOYesXPath = String.format(XPATH_RDO_LBL_FORM, "radio-label-yes");
        WebElement lblRDOYesEle = webDriver.findElement(By.xpath(lblRDOYesXPath));
        lblRDOYesEle.click();
        System.out.println(lblRadioResultEle.getText());
        waitForDebug(2000);

        //select Impressive
        String lblRDOImpressiveXPath = String.format(XPATH_RDO_LBL_FORM, "radio-label-impressive");
        WebElement lblRDOImpressiveEle = webDriver.findElement(By.xpath(lblRDOImpressiveXPath));
        lblRDOImpressiveEle.click();
        System.out.println(lblRadioResultEle.getText());
        waitForDebug(2000);

        //select No
        String lblRDONoXPath = String.format(XPATH_RDO_LBL_FORM, "radio-label-no");
        WebElement lblRDONoEle = webDriver.findElement(By.xpath(lblRDONoXPath));
        lblRDONoEle.click();
        System.out.println(lblRadioResultEle.getText());
        waitForDebug(2000);

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

    /**
     * Go to Test Website by menu -> subMenu
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
