package com.testek.study.lesson05.exercise;

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


    @Test(description = "Find element with CSS")
    public void findBasicLocatorWithCSS() {
        gotoTestWebsite();

        // Handle other elements similarly
        //Locate the title "Form đăng ký sinh viên"
        String lblTitleContainsCss = "[id*='registration']";
        webDriver.findElement(By.cssSelector(lblTitleContainsCss));
        String lblTitleIdCss = "#student-registration-title";
        webDriver.findElement(By.cssSelector(lblTitleIdCss));

        //Locate the title First Name
        String lblFirstNameContainsCss = "[id*='first']";
        webDriver.findElement(By.cssSelector(lblFirstNameContainsCss));
        String lblFirstNameIdCss = "#firstName";
        webDriver.findElement(By.cssSelector(lblFirstNameIdCss));

        //Locate the title Last Name
        String lblLastNameStartWithCss = "[id^='last']";
        webDriver.findElement(By.cssSelector(lblLastNameStartWithCss));
        String lblLastNameIdCss = "#lastName";
        webDriver.findElement(By.cssSelector(lblLastNameIdCss));

        //Locate the title Email
        String lblEmailContainsCss = "[placeholder*='your e']";
        webDriver.findElement(By.cssSelector(lblEmailContainsCss));
        String lblEmailIdCss = "#email";
        webDriver.findElement(By.cssSelector(lblEmailIdCss));

        //Locate the title Mobile
        String lblMobileContainsCss = "[placeholder*='your m']";
        webDriver.findElement(By.cssSelector(lblMobileContainsCss));
        String lblMobileIdCss = "#mobile";
        webDriver.findElement(By.cssSelector(lblMobileIdCss));

        //Locate the title Subject
        String lblSubjectContainsCss = "[placeholder*='your m']";
        webDriver.findElement(By.cssSelector(lblSubjectContainsCss));
        String lblSubjectIdCss = "#subjects";
        webDriver.findElement(By.cssSelector(lblSubjectIdCss));

        //Locate the title DOB
        String lblDobContainsCss = "[test-id$='ut-dob']";
        webDriver.findElement(By.cssSelector(lblDobContainsCss));
        String lblDobIdCss = "#dob";
        webDriver.findElement(By.cssSelector(lblDobIdCss));

        //Locate the radio button gender
        String rdoMaleCss = "[name='gender'][value='Male']";
        webDriver.findElement(By.cssSelector(rdoMaleCss));
        String rdoMaleIdCss = "#male";
        webDriver.findElement(By.cssSelector(rdoMaleIdCss));
        String rdoFemaleContainsCss = "[id*='fe']";
        webDriver.findElement(By.cssSelector(rdoFemaleContainsCss));

        //Locate the checkbox Hobbies
        String chkReadingCss = "[name='hobbies'][value='Reading']";
        webDriver.findElement(By.cssSelector(chkReadingCss));
        String chkSportsIdCss = "#sports";
        webDriver.findElement(By.cssSelector(chkSportsIdCss));
        String chkMusicStartWithCss = "[id^='mus']";
        webDriver.findElement(By.cssSelector(chkMusicStartWithCss));

        //Locate the textarea Address
        String txtAddressIdCss = "textarea[id='address']";
        webDriver.findElement(By.cssSelector(txtAddressIdCss));
        String txtLastAddressCss = "[placeholder$='address']";
        webDriver.findElement(By.cssSelector(txtLastAddressCss));

        //Locate the button submit
        String btnSubmitIdCss = "#submit-button";
        webDriver.findElement(By.cssSelector(btnSubmitIdCss));

        //Locate the button clear
        String btnResetContainsCss = "[id*='reset-b']";
        webDriver.findElement(By.cssSelector(btnResetContainsCss));

        //Locate the textarea Thông tin bạn đã nhập
        String txtTextStudentCss = "[id$='TextStudent']";
        webDriver.findElement(By.cssSelector(txtTextStudentCss));
        String txtTextStudentIdCss = "#outputTextStudent";
        webDriver.findElement(By.cssSelector(txtTextStudentIdCss));
    }

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

        // Handle other elements similarly
        //Locate the title: "Form đăng ký sinh viên"
        String lblTitleContainsXpath = "//h3[contains(@id,'registration')]";
        webDriver.findElement(By.xpath(lblTitleContainsXpath));
        String lblTitleStartsWithXpath = "//h3[starts-with(@test-id,'textbox-form-t')]";
        webDriver.findElement(By.xpath(lblTitleStartsWithXpath));

        //Locate the textbox First Name
        String txtFirstNameContainsXpath = "//input[contains(@placeholder,'first')]";
        webDriver.findElement(By.xpath(txtFirstNameContainsXpath));
        String txtFirstNameStartsWithXpath = "//input[starts-with(@id,'first')]";
        webDriver.findElement(By.xpath(txtFirstNameStartsWithXpath));

        //Locate the textbox Last Name
        String txtLastNameNormalizeXpath = "//h3[normalize-space()='Nhập thông tin người dùng:']";
        webDriver.findElement(By.xpath(txtLastNameNormalizeXpath));
        String txtLastNameAncestorXpath = "//input[@id='email']/ancestor::form/preceding::h3[@test-id='textbox-form-title']";
        webDriver.findElement(By.xpath(txtLastNameAncestorXpath));

        //Locate the textbox Email
        String txtPrecedingSibEmailXpath = "//label[@test-id='label-gender']/preceding-sibling::input[@id='email']";
        webDriver.findElement(By.xpath(txtPrecedingSibEmailXpath));
        String txtDescendantEmailXpath = "//form[@id='studentRegistrationForms']/descendant::input[@id='email']";
        webDriver.findElement(By.xpath(txtDescendantEmailXpath));

        //Locate the textbox Mobile
        String followingSibMobileXpath = "//label[@test-id='label-mobile']/following-sibling::input[@id='mobile']";
        webDriver.findElement(By.xpath(followingSibMobileXpath));
        String precedingMobileXpath = "//h3[@id='submitted-info-title']/preceding::input[@id='mobile']";
        webDriver.findElement(By.xpath(precedingMobileXpath));

        //Locate the textbox Subject
        String txtSubjectFollowingXpath = "//input[@id='firstName']/following::input[@id='subjects']";
        webDriver.findElement(By.xpath(txtSubjectFollowingXpath));
        String txtSubjectChildXpath = "//form[@id='studentRegistrationForms']/child::input[@id='subjects']";
        webDriver.findElement(By.xpath(txtSubjectChildXpath));

        //Locate the textbox DOB
        String txtDobContainsXpath = "//input[contains(@test-id,'t-dob')]";
        webDriver.findElement(By.xpath(txtDobContainsXpath));
        String txtDobStartWithXpath = "//input[starts-with(@type,'da')]";
        webDriver.findElement(By.xpath(txtDobStartWithXpath));

        //Locate the radio button GENDER
        String rdoMaleXpath = "//input[@name='gender' and @value='Male']";
        webDriver.findElement(By.xpath(rdoMaleXpath));
        String rdoContainsFemaleXpath = "//input[contains(@id,'fe')]";
        webDriver.findElement(By.xpath(rdoContainsFemaleXpath));

        //Locate the checkbox Hobbies
        String chkReadingXpath = "//input[@value='Reading']";
        webDriver.findElement(By.xpath(chkReadingXpath));
        String chkSportsXpath = "//input[@id='sports']";
        webDriver.findElement(By.xpath(chkSportsXpath));
        String chkMusicStartWithXpath = "//input[starts-with(@id,'mus')]";
        webDriver.findElement(By.xpath(chkMusicStartWithXpath));

        //Locate the textarea Address
        String txtAddressDescendantXpath = "//form[@id='studentRegistrationForms']/descendant::textarea[@id='address']";
        webDriver.findElement(By.xpath(txtAddressDescendantXpath));
        String txtAddressFollowingSibXpath = "//div[@test-id='hobbies-options']/following-sibling::textarea[@id='address']";
        webDriver.findElement(By.xpath(txtAddressFollowingSibXpath));

        //Locate the button submit
        String btnPrecedingSubmitXpath = "//div[@id='browser-windows-section']/preceding::button[@id='submit-button']";
        webDriver.findElement(By.xpath(btnPrecedingSubmitXpath));
        String btnFollowingClearXpath = "//div[@test-id='gender-options']/following::button[@id='reset-button']";
        webDriver.findElement(By.xpath(btnFollowingClearXpath));

        //Locate the textarea Thông tin bạn đã nhập
        String txtOutputXpath = "//textarea[@id='outputTextStudent']";
        webDriver.findElement(By.xpath(txtOutputXpath));
        String txtOutputContainsXpath = "//textarea[contains(@id,'TextS')]";
        webDriver.findElement(By.xpath(txtOutputContainsXpath));
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();

        // Define the locator format then apply to elements
        gotoTestWebsite();

        // Define the locator format then apply to elements
        String XPATH_TITLE_TEST_ID_FORMAT = "//h3[@test-id = '%s']";
        String XPATH_LABEL_FOR_FORMAT = "//label[@for = '%s']";
        String XPATH_INPUT_TEST_ID_FORMAT = "//input[@test-id = '%s' ]";
        String XPATH_BUTTON_TYPE_FORMAT = "//button[@type = '%s']";
        String XPATH_TEXT_AREA_ID_FORMAT = "//textarea[@test-id = '%s']";

        // Locate elements using dynamic XPath
        // Locate the title: "Browser Windows"
        String lblBrowserWindowsTitleDynamicXpath = String.format(XPATH_TITLE_TEST_ID_FORMAT,"browser-windows-title");
        webDriver.findElement(By.xpath(lblBrowserWindowsTitleDynamicXpath));

        // Locate the title: "Student Registration Form"
        String lblStudentFormDynamicXpath = String.format(XPATH_TITLE_TEST_ID_FORMAT,"student-registration-title");
        webDriver.findElement(By.xpath(lblStudentFormDynamicXpath));

        // Locate the title: "First Name:"
        String lblFirstNameDynamicXpath = String.format(XPATH_LABEL_FOR_FORMAT,"firstName");
        webDriver.findElement(By.xpath(lblFirstNameDynamicXpath));

        // Locate the title: "Last Name:"
        String lblLastNameDynamicXPath =String.format(XPATH_LABEL_FOR_FORMAT,"lastName");
        webDriver.findElement(By.xpath(lblLastNameDynamicXPath));

        // Locate the title: "Email:"
        String lblEmailDynamicXPath = String.format(XPATH_LABEL_FOR_FORMAT,"email");
        webDriver.findElement(By.xpath(lblEmailDynamicXPath));

        // Locate the title: "Gender:"
        String lblGenderDynamicXPath = String.format(XPATH_LABEL_FOR_FORMAT,"gender");
        webDriver.findElement(By.xpath(lblGenderDynamicXPath));

        // Locate the title: "Mobile:"
        String lblMobileDynamicXPath = String.format(XPATH_LABEL_FOR_FORMAT,"mobile");
        webDriver.findElement(By.xpath(lblMobileDynamicXPath));

        // Locate the title: "Date of Birth:"
        String lblDateOfBirthDynamicXPath = String.format(XPATH_LABEL_FOR_FORMAT,"dob");
        webDriver.findElement(By.xpath(lblDateOfBirthDynamicXPath));

        // Locate the title: "Subjects:"
        String lblSubjectDynamicXPath = String.format(XPATH_LABEL_FOR_FORMAT,"subjects");
        webDriver.findElement(By.xpath(lblSubjectDynamicXPath));

        // Locate the title: "Hobbies:"
        String lblHobbiesDynamicXPath = String.format(XPATH_LABEL_FOR_FORMAT,"hobbies");
        webDriver.findElement(By.xpath(lblHobbiesDynamicXPath));

        // Locate the title: "Address:"
        String lblAddressDynamicXPath = String.format(XPATH_LABEL_FOR_FORMAT,"address");
        webDriver.findElement(By.xpath(lblAddressDynamicXPath));

        // Locate the textbox: "Submit"
        String txtFirstNameDynamicXPath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-firstName");
        webDriver.findElement(By.xpath(txtFirstNameDynamicXPath));

        // Locate the textbox: "Last Name"
        String txtLastNameDynamicXPath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-lastName");
        webDriver.findElement(By.xpath(txtLastNameDynamicXPath));

        // Locate the textbox: "Email"
        String txtEmailDynamicXPath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-email");
        webDriver.findElement(By.xpath(txtEmailDynamicXPath));

        // Locate the textbox: "Mobile"
        String txtMobileDynamicXPath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-mobile");
        webDriver.findElement(By.xpath(txtMobileDynamicXPath));

        // Locate the textbox: "Date of Birth"
        String txtDateOfBirthDynamicXPath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-dob");
        webDriver.findElement(By.xpath(txtDateOfBirthDynamicXPath));

        // Locate the textbox: "Subjects"
        String txtSubjectDynamicXpath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-subjects");
        webDriver.findElement(By.xpath(txtSubjectDynamicXpath));

        // Locate the textarea: "Address"
        String txtAddressDynamicXpath = String.format(XPATH_TEXT_AREA_ID_FORMAT,"textarea-address");
        webDriver.findElement(By.xpath(txtAddressDynamicXpath));

        // Locate the checkbox: "Hobbies"
        String chbReadingDynamicXpath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-reading");
        webDriver.findElement(By.xpath(chbReadingDynamicXpath));

        String chbSportsDynamicXpath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-sports");
        webDriver.findElement(By.xpath(chbSportsDynamicXpath));

        String chbMusicDynamicXPath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-music");
        webDriver.findElement(By.xpath(chbMusicDynamicXPath));

        // Locate the radio button: "Gender"
        String rdoMaleDynamicXPath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-male");
        webDriver.findElement(By.xpath(rdoMaleDynamicXPath));

        String rdoFemaleDynamicXPath = String.format(XPATH_INPUT_TEST_ID_FORMAT,"input-female");
        webDriver.findElement(By.xpath(rdoFemaleDynamicXPath));

        // Locate the button: "Submit"
        String btnSubmitDynamicXpath = String.format(XPATH_BUTTON_TYPE_FORMAT,"submit");
        webDriver.findElement(By.xpath(btnSubmitDynamicXpath));

        // Locate the button: "Clear"
        String btnClearDynamicXpath = String.format(XPATH_BUTTON_TYPE_FORMAT,"reset");
        webDriver.findElement(By.xpath(btnClearDynamicXpath));
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
