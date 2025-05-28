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

        //Browser windows title
        String lblBrowserWindowsContainsCSS = "h3[test-id*='browser-windows-title']";
        WebElement lblBrowserWindowsContainsEle = webDriver.findElement(By.cssSelector(lblBrowserWindowsContainsCSS));

        //Student registration title
        String lblStudentRegistrationTitleCSS = "#student-registration-title";
        WebElement lblStudentRegistrationTitleEle = webDriver.findElement(By.cssSelector(lblStudentRegistrationTitleCSS));

        //First name label
        String lblFirstNameStartsWithCSS = "label[test-id^='label-fi']";
        WebElement lblFirstNameStartsWithEle = webDriver.findElement(By.cssSelector(lblFirstNameStartsWithCSS));

        //First name textbox
        String txtFirstNameCSS = "#firstName";
        WebElement txtFirstNameEle = webDriver.findElement(By.cssSelector(txtFirstNameCSS));

        //Last name label
        String lblLastNameStartsWithCSS = "label[test-id^='label-l']";
        WebElement lblLastNameStartsWithEle = webDriver.findElement(By.cssSelector(lblLastNameStartsWithCSS));

        //Last name textbox
        String txtLastNameCSS = "#lastName";
        WebElement txtLastNameEle = webDriver.findElement(By.cssSelector(txtLastNameCSS));

        //Email label
        String lblEmailStartsWithCSS = "label[test-id^='label-e']";
        WebElement lblEmailStartsWithEle = webDriver.findElement(By.cssSelector(lblEmailStartsWithCSS));

        //Email textbox
        String txtEmailContainsCSS = "input[placeholder*='your email']";
        WebElement txtEmailContainsEle = webDriver.findElement(By.cssSelector(txtEmailContainsCSS));

        //Gender label
        String lblGenderStartsWithCSS = "label[test-id^='label-g']";
        WebElement lblGenderStartsWithEle = webDriver.findElement(By.cssSelector(lblGenderStartsWithCSS));

        //Radio button
        String rdoMaleCSS = "#male";
        WebElement rdoMaleEle = webDriver.findElement(By.cssSelector(rdoMaleCSS));

        String rdoFemaleCSS = "#female";
        WebElement rdoFemaleEle = webDriver.findElement(By.cssSelector(rdoFemaleCSS));

        //Mobile label
        String lblMobileStartsWithCSS ="label[test-id^='label-mo']";
        WebElement lblMobileStartsWithEle = webDriver.findElement(By.cssSelector(lblMobileStartsWithCSS));

        //Mobile textbox
        String txtMobileContainsCSS = "input[placeholder*='mobile']";
        WebElement txtMobileContainsEle = webDriver.findElement(By.cssSelector(txtMobileContainsCSS));

        //Date of birth label
        String lblDateOfBirthCSS = "label[for='dob']";
        WebElement lblDateOfBirthEle = webDriver.findElement(By.cssSelector(lblDateOfBirthCSS));

        //Date of birth dropdown
        String datDateOfBirthCSS = "input[test-id='input-dob']";
        WebElement datDateOfBirthEle = webDriver.findElement(By.cssSelector(datDateOfBirthCSS));

        //Subjects label
        String lblSubjectsStartsWithCSS = "label[test-id^='label-su']";
        WebElement lblSubjectsStartsWithEle = webDriver.findElement(By.cssSelector(lblSubjectsStartsWithCSS));

        //Subjects textbox
        String txtSubjectsContainsCSS = "input[test-id*='subjects']";
        WebElement txtSubjectsContainsEle = webDriver.findElement(By.cssSelector(txtSubjectsContainsCSS));

        //Hobbies label
        String lblHobbiesContainsCSS = "label[test-id*='hobbies']";
        WebElement lblHobbiesContainsEle = webDriver.findElement(By.cssSelector(lblHobbiesContainsCSS));

        //Check box
        String chkReadingCSS = "#reading";
        WebElement chkReadingEle = webDriver.findElement(By.cssSelector(chkReadingCSS));

        String chkSportsCSS = "#sports";
        WebElement chkSportsEle = webDriver.findElement(By.cssSelector(chkSportsCSS));

        String chkMusicCSS = "#music";
        WebElement chkMusicEle = webDriver.findElement(By.cssSelector(chkMusicCSS));

        //Address label
        String lblAddressCSS = "label[test-id='label-address']";
        WebElement lblAddressEle = webDriver.findElement(By.cssSelector(lblAddressCSS));

        //Address textarea
        String taAddressContainsCSS ="textarea[test-id*='address']";
        WebElement taAddressContainsEle = webDriver.findElement(By.cssSelector(taAddressContainsCSS));

        //Button
        String btnSubmitCSS = "#submit-button";
        WebElement btnSubmitEle = webDriver.findElement(By.cssSelector(btnSubmitCSS));

        String btnClearCSS = "#reset-button";
        WebElement btnClearEle = webDriver.findElement(By.cssSelector(btnClearCSS));

        //Submitted info title
        String lblSubmittedInfoStartsWithCSS = "h3[test-id^='submitted']";
        WebElement lblSubmittedInfoStartsWithEle = webDriver.findElement(By.cssSelector(lblSubmittedInfoStartsWithCSS));

        //Output text
        String taOutputContainsCSS = "textarea[test-id*='Student']";
        WebElement taOutputContains = webDriver.findElement(By.cssSelector(taOutputContainsCSS));

    }

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

        // Handle other elements similarly

        //Browser windows title
        String lblBrowseWindowsTextXPath = "//h3[text()='Browser Windows']";
        WebElement lblBrowseWindowsTextEle = webDriver.findElement(By.xpath(lblBrowseWindowsTextXPath));

        //Student registration title
        String lblStudentRegistrationChildXPath = "//div[@test-id='student-form-container']/child::h3[@test-id='student-registration-title']";
        WebElement lblStudentRegistrationChildEle = webDriver.findElement(By.xpath(lblStudentRegistrationChildXPath));

        //First name label
        String lblFirstNamePrecedingSiblingXPath = "//input[@test-id='input-lastName']/preceding-sibling::label[@test-id='label-firstName']";
        WebElement lblFirstNamePrecedingSiblingEle = webDriver.findElement(By.xpath(lblFirstNamePrecedingSiblingXPath));

        //First name textbox
        String txtFirstNameDescendantXPath = "//div[@test-id='form-container']/descendant::input[@test-id='input-firstName']";
        WebElement txtFirstNameDescendant = webDriver.findElement(By.xpath(txtFirstNameDescendantXPath));

        //Last name label
        String lblLastNameTextXPath = "//label[text()='Last Name:']";
        WebElement lblLastNameTextEle = webDriver.findElement(By.xpath(lblLastNameTextXPath));

        //Last name textbox
        String txtLastNameFollowingXPath = "//div[@test-id='dynamic-section']/following::input[@test-id='input-lastName']";
        WebElement txtLastNameFollowingEle = webDriver.findElement(By.xpath(txtLastNameFollowingXPath));

        //Email label
        String lblEmailFollowingSiblingXPath = "//label[@test-id='label-firstName']/following-sibling::label[@test-id='label-email']";
        WebElement lblEmailFollowingSiblingEle = webDriver.findElement(By.xpath(lblEmailFollowingSiblingXPath));

        //Email textbox
        String lblEmailXPath = "//input[@test-id='input-email']";
        WebElement lblEmailEle = webDriver.findElement(By.xpath(lblEmailXPath));

        //Gender label
        String lblGenderContainsXPath = "//label[contains(@test-id,'gender')]";
        WebElement lblGenderContainsEle = webDriver.findElement(By.xpath(lblGenderContainsXPath));

        //Radio button
        String rdoMaleChildXPath = "//div[@test-id='gender-options']/child::label[@test-id='label-male']";
        WebElement rdoMaleChildEle = webDriver.findElement(By.xpath(rdoMaleChildXPath));

        String rdoFemaleFollowingXPath = "//input[@test-id='input-male']/following::input[@test-id='input-female']";
        WebElement rdoFemaleFollowingEle = webDriver.findElement(By.xpath(rdoFemaleFollowingXPath));

        //Mobile label
        String lblMobileTextXPath = "//label[text()='Mobile:']";
        WebElement lblMobileTextEle = webDriver.findElement(By.xpath(lblMobileTextXPath));

        //Mobile textbox
        String txtMobilePrecedingXPath = "//label[@test-id='label-reading']/preceding::input[@test-id='input-mobile']";
        WebElement txtMobilePrecedingEle = webDriver.findElement(By.xpath(txtMobilePrecedingXPath));

        //Dob label
        String lblDobDescendantXPath = "//form[@test-id='studentRegistrationForms']/descendant::label[@test-id='label-dob']";
        WebElement lblDobDescendant = webDriver.findElement(By.xpath(lblDobDescendantXPath));

        //Dob dropdown
        String datDobStartsWithXPath = "//input[starts-with(@test-id,'input-d')]";
        WebElement datDobStartsWithEle = webDriver.findElement(By.xpath(datDobStartsWithXPath));

        //Subjects label
        String lblSubjectsPrecedingSiblingXPath = "//label[@test-id='label-hobbies']/preceding-sibling::label[@test-id='label-subjects']";
        WebElement lblSubjectsPrecedingSiblingEle = webDriver.findElement(By.xpath(lblSubjectsPrecedingSiblingXPath));

        //Subjects textbox
        String txtSubjectsContainsXPath = "//input[contains(@test-id,'subjects')]";
        WebElement txtSubjectsContainsEle = webDriver.findElement(By.xpath(txtSubjectsContainsXPath));

        //Hobbies label
        String lblHobbiesTextXPath = "//label[text()='Hobbies:']";
        WebElement lblHobbiesTextEle = webDriver.findElement(By.xpath(lblHobbiesTextXPath));

        //Checkbox
        String chkReadingChildXPath = "//div[@test-id='hobbies-options']/child::label[@test-id='label-reading']";
        WebElement chkReadingChildEle = webDriver.findElement(By.xpath(chkReadingChildXPath));

        String chkSportsPrecedingSiblingXPath = "//label[@test-id='label-music']/preceding-sibling::label[@test-id='label-sports']";
        WebElement chkSportsPrecedingSiblingEle = webDriver.findElement(By.xpath(chkSportsPrecedingSiblingXPath));

        String chkMusicFollowingSiblingXPath = "//label[@test-id='label-reading']/following-sibling::label[@test-id='label-music']";
        WebElement chkMusicFollowingSiblingEle = webDriver.findElement(By.xpath(chkMusicFollowingSiblingXPath));

        //Address label
        String lblAddressTextXPath = "//label[text()='Address:']";
        WebElement lblAddressTextEle = webDriver.findElement(By.xpath(lblAddressTextXPath));

        //Address textarea
        String taAddressStartsWithXPath = "//textarea[starts-with(@test-id,'texta')]";
        WebElement taAddressStartsWithEle = webDriver.findElement(By.xpath(taAddressStartsWithXPath));

        //Button
        String btnSubmitFollowingSiblingXPath = "//textarea[@test-id='textarea-address']/following-sibling::button[@test-id='submit-button']";
        WebElement btnSubmitFollowingSiblingEle = webDriver.findElement(By.xpath(btnSubmitFollowingSiblingXPath));

        String btnClearStartsWithXPath = "//button[starts-with(@test-id,'reset-bu')]";
        WebElement btnClearStartsWithEle = webDriver.findElement(By.xpath(btnClearStartsWithXPath));

        //Submitted info title
        String lblSubmittedInfoTextXPath = "//h3[text()='Thông tin bạn đã nhập:']";
        WebElement lblSubmittedInfoTextEle = webDriver.findElement(By.xpath(lblSubmittedInfoTextXPath));

        //Output textarea
        String taOutputContainsXPath = "//textarea[contains(@test-id,'outputText')]";
        WebElement taOutputContainsEle = webDriver.findElement(By.xpath(taOutputContainsXPath));
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();

        // Define the locator format then apply to elements

        //Placeholder
        String FORM_XPATH_PLACEHOLDER_INPUT = "//input[@placeholder='%s']";

        String txtFirstNameXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your first name");
        String txtLastNameXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your last name");
        String txtEmailXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your email");
        String txtMobileXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your mobile number");
        String txtSubjectsXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your subjects");


        //Radio button
        String FORM_XPATH_RADIOBUTTON_INPUT = "//input[@value='%s']";

        String rdoMaleXPath = String.format(FORM_XPATH_RADIOBUTTON_INPUT, "Male");
        String rdoFemaleXPath = String.format(FORM_XPATH_RADIOBUTTON_INPUT, "Female");

        //Checkbox
        String FORM_XPATH_CHECKBOX_INPUT = "//input[@value='%s']";

        String chkReadingXPath = String.format(FORM_XPATH_CHECKBOX_INPUT, "Reading");
        String chkSportsXPath = String.format(FORM_XPATH_CHECKBOX_INPUT, "Sports");
        String chkMusicXPath = String.format(FORM_XPATH_CHECKBOX_INPUT, "Music");

        //Button
        String FORM_XPATH_BUTTON = "//button[@test-id='%s']";

        String btnSubmitXPath = String.format(FORM_XPATH_BUTTON, "submit-button");
        String btnClearXPath = String.format(FORM_XPATH_BUTTON, "reset-button");

        //dob
        String datDobXPath = "//input[@test-id='input-dob']";


        //Title
        String FORM_XPATH_TITLE = "//h3[@test-id='%s']";

        String lblBrowserWindowsXPath = String.format(FORM_XPATH_TITLE, "browser-windows-title");
        String lblStudentRegistrationXpath = String.format(FORM_XPATH_TITLE, "student-registration-title");
        String lblSubmittedInfoXPath = String.format(FORM_XPATH_TITLE, "submitted-info-title");

        //Label
        String FORM_XPATH_LABEL = "//label[@test-id='%s']";

        String lblFirstName = String.format(FORM_XPATH_LABEL, "label-firstName");
        String lblLastName = String.format(FORM_XPATH_LABEL, "label-lastName");
        String lblEmail = String.format(FORM_XPATH_LABEL, "label-email");
        String lblGender = String.format(FORM_XPATH_LABEL, "label-gender");
        String lblMobile = String.format(FORM_XPATH_LABEL, "label-mobile");
        String lblDateOfBirth = String.format(FORM_XPATH_LABEL, "label-dob");
        String lblSubjects = String.format(FORM_XPATH_LABEL, "label-subjects");
        String lblHobbies = String.format(FORM_XPATH_LABEL, "label-hobbies");
        String lblAddress = String.format(FORM_XPATH_LABEL, "label-address");

        //Text area
        String FORM_XPATH_TEXTAREA = "//textarea[@test-id='%s']";

        String textAreaXPath = String.format(FORM_XPATH_TEXTAREA, "outputTextStudent");
        String textAddressXPath = String.format(FORM_XPATH_TEXTAREA, "textarea-address");

        //Find web elements
        //placeholder
        webDriver.findElement(By.xpath(txtFirstNameXPath));
        webDriver.findElement(By.xpath(txtLastNameXPath));
        webDriver.findElement(By.xpath(txtEmailXPath));
        webDriver.findElement(By.xpath(txtMobileXPath));
        webDriver.findElement(By.xpath(txtSubjectsXPath));


        //radio button
        webDriver.findElement(By.xpath(rdoMaleXPath));
        webDriver.findElement(By.xpath(rdoFemaleXPath));

        //checkbox
        webDriver.findElement(By.xpath(chkReadingXPath));
        webDriver.findElement(By.xpath(chkSportsXPath));
        webDriver.findElement(By.xpath(chkMusicXPath));

        //button
        webDriver.findElement(By.xpath(btnSubmitXPath));
        webDriver.findElement(By.xpath(btnClearXPath));

        //date
        webDriver.findElement(By.xpath(datDobXPath));

        //title
        webDriver.findElement(By.xpath(lblBrowserWindowsXPath));
        webDriver.findElement(By.xpath(lblStudentRegistrationXpath));
        webDriver.findElement(By.xpath(lblSubmittedInfoXPath));

        //label
        webDriver.findElement(By.xpath(lblFirstName));
        webDriver.findElement(By.xpath(lblLastName));
        webDriver.findElement(By.xpath(lblEmail));
        webDriver.findElement(By.xpath(lblMobile));
        webDriver.findElement(By.xpath(lblGender));
        webDriver.findElement(By.xpath(lblDateOfBirth));
        webDriver.findElement(By.xpath(lblSubjects));
        webDriver.findElement(By.xpath(lblHobbies));
        webDriver.findElement(By.xpath(lblAddress));

        //text area
        webDriver.findElement(By.xpath(textAreaXPath));
        webDriver.findElement(By.xpath(textAddressXPath));

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
