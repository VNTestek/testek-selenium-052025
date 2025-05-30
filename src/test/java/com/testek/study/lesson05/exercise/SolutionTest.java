package com.testek.study.lesson05.exercise;

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
import com.testek.study.common.Menu;
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
        String containsTitleCss = "[id*='registration']";
        WebElement containsTitleCssEle = webDriver.findElement(By.cssSelector(containsTitleCss));
        String titleIdCss = "#student-registration-title";
        WebElement titleIdCssEle = webDriver.findElement(By.cssSelector(titleIdCss));

        String containsFirstNameCss = "[id*='first']";
        WebElement containsFirstNameCssEle = webDriver.findElement(By.cssSelector(containsFirstNameCss));
        String firstNameIdCss = "#firstName";
        WebElement firstNameIdCssEle = webDriver.findElement(By.cssSelector(firstNameIdCss));

        String startsLastNameCss = "[id^='last']";
        WebElement startsLastNameCssEle = webDriver.findElement(By.cssSelector(startsLastNameCss));
        String lastNameIdCss = "#lastName";
        WebElement lastNameIdCssEle = webDriver.findElement(By.cssSelector(lastNameIdCss));

        String containsEmailCss = "[placeholder*='your e']";
        WebElement containsEmailCssEle = webDriver.findElement(By.cssSelector(containsEmailCss));
        String emailIdCss = "#email";
        WebElement emailIdCssEle = webDriver.findElement(By.cssSelector(emailIdCss));

        String containsMobileCss = "[placeholder*='your m']";
        WebElement containsMobileCssEle = webDriver.findElement(By.cssSelector(containsMobileCss));
        String mobileIdCss = "#mobile";
        WebElement mobileIdCssEle = webDriver.findElement(By.cssSelector(mobileIdCss));

        String containsSubjectCss = "[placeholder*='your m']";
        WebElement containsSubjectCssEle = webDriver.findElement(By.cssSelector(containsMobileCss));
        String subjectIdCss = "#subjects";
        WebElement subjectIdCssEle = webDriver.findElement(By.cssSelector(subjectIdCss));

        String containsDobCss = "[test-id$='ut-dob']";
        WebElement containsDobCssEle = webDriver.findElement(By.cssSelector(containsDobCss));
        String dobIdCss = "#dob";
        WebElement dobIdCssEle = webDriver.findElement(By.cssSelector(dobIdCss));

        String rdoMaleCss = "[name='gender'][value='Male']";
        WebElement rdoMaleCssEle = webDriver.findElement(By.cssSelector(rdoMaleCss));
        String rdoMaleIdCss = "#male";
        WebElement rdoMaleIdCssEle = webDriver.findElement(By.cssSelector(rdoMaleIdCss));
        String rdoContainsFemaleCss = "[id*='fe']";
        WebElement rdoContainsFemaleCssEle = webDriver.findElement(By.cssSelector(rdoContainsFemaleCss));

        String chkReadingCss = "[name='hobbies'][value='Reading']";
        WebElement chkReadingCssEle = webDriver.findElement(By.cssSelector(chkReadingCss));
        String chkSportsIdCss = "#sports";
        WebElement chkSportsIdCssEle = webDriver.findElement(By.cssSelector(chkSportsIdCss));
        String startsMusicCss = "[id^='mus']";
        WebElement startsMusicCssEle = webDriver.findElement(By.cssSelector(startsMusicCss));

        String tarAddressIdCss = "textarea[id='address']";
        WebElement tarAddressIdCssEle = webDriver.findElement(By.cssSelector(tarAddressIdCss));
        String tarLastAddressCss = "[placeholder$='address']";
        WebElement tarLastAddressCssEle = webDriver.findElement(By.cssSelector(tarLastAddressCss));

        String btnSubmitIdCss = "#submit-button";
        WebElement btnSubmitIdCssEle = webDriver.findElement(By.cssSelector(btnSubmitIdCss));
        String btnContainsResetCss = "[id*='reset-b']";
        WebElement btnContainsResetCssEle = webDriver.findElement(By.cssSelector(btnContainsResetCss));

        String tarLastResCss = "[id$='TextStudent']";
        WebElement tarLastResCssEle = webDriver.findElement(By.cssSelector(tarLastResCss));
        String tarResIdCss = "#outputTextStudent";
        WebElement tarResIdCssEle = webDriver.findElement(By.cssSelector(tarResIdCss));
    }

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

        // Handle other elements similarly
        String containsTitleXpath = "//h3[contains(@id,'registration')]";
        WebElement containsTitleXpathEle = webDriver.findElement(By.xpath(containsTitleXpath));
        String startsTitleXpath = "//h3[starts-with(@test-id,'textbox-form-t')]";
        WebElement startsTitleXpathEle = webDriver.findElement(By.xpath(startsTitleXpath));

        String containsFirstNameCss = "//input[contains(@placeholder,'first')]";
        WebElement containsFirstNameCssEle = webDriver.findElement(By.xpath(containsFirstNameCss));
        String startsFirstNameXpath = "//input[starts-with(@id,'first')]";
        WebElement startsFirstNameXpathEle = webDriver.findElement(By.xpath(startsFirstNameXpath));

        String normalizeTitle = "//h3[normalize-space()='Nhập thông tin người dùng:']";
        WebElement normalizeTitleEle = webDriver.findElement(By.xpath(normalizeTitle));
        String ancestorTitle = "//input[@id='email']/ancestor::form/preceding::h3[@test-id='textbox-form-title']";
        WebElement ancestorTitleEle = webDriver.findElement(By.xpath(ancestorTitle));

        String precedingSibEmail = "//label[@test-id='label-gender']/preceding-sibling::input[@id='email']";
        WebElement precedingSibEmailEle = webDriver.findElement(By.xpath(precedingSibEmail));
        String descendantEmail = "//form[@id='studentRegistrationForms']/descendant::input[@id='email']";
        WebElement descendantEmailEle = webDriver.findElement(By.xpath(descendantEmail));

        String followingSibMobile = "//label[@test-id='label-mobile']/following-sibling::input[@id='mobile']";
        WebElement followingSibMobileEle = webDriver.findElement(By.xpath(followingSibMobile));
        String precedingMobile = "//h3[@id='submitted-info-title']/preceding::input[@id='mobile']";
        WebElement precedingMobileEle = webDriver.findElement(By.xpath(precedingMobile));

        String followingSubject = "//input[@id='firstName']/following::input[@id='subjects']";
        WebElement followingSubjectEle = webDriver.findElement(By.xpath(followingSubject));
        String childSubject = "//form[@id='studentRegistrationForms']/child::input[@id='subjects']";
        WebElement childSubjectEle = webDriver.findElement(By.xpath(childSubject));

        String containsDobXpath = "//input[contains(@test-id,'t-dob')]";
        WebElement containsDobXpathEle = webDriver.findElement(By.xpath(containsDobXpath));
        String startsDobXpath = "//input[starts-with(@type,'da')]";
        WebElement startsDobXpathEle = webDriver.findElement(By.xpath(startsDobXpath));

        String rdoMaleXpath = "//input[@name='gender' and @value='Male']";
        WebElement rdoMaleXpathEle = webDriver.findElement(By.xpath(rdoMaleXpath));
        String rdoContainsFemaleXpath = "//input[contains(@id,'fe')]";
        WebElement rdoContainsFemaleXpathEle = webDriver.findElement(By.xpath(rdoContainsFemaleXpath));

        String chkReadingXpath = "//input[@value='Reading']";
        WebElement chkReadingXpathEle = webDriver.findElement(By.xpath(chkReadingXpath));
        String chkSportsXpath = "//input[@id='sports']";
        WebElement chkSportsXpathEle = webDriver.findElement(By.xpath(chkSportsXpath));
        String startsMusicXpath = "//input[starts-with(@id,'mus')]";
        WebElement startsMusicXpathEle = webDriver.findElement(By.xpath(startsMusicXpath));

        String tarDescendantAddress = "//form[@id='studentRegistrationForms']/descendant::textarea[@id='address']";
        WebElement tarDescendantAddressEle = webDriver.findElement(By.xpath(tarDescendantAddress));
        String followingSibAddress = "//div[@test-id='hobbies-options']/following-sibling::textarea[@id='address']";
        WebElement followingSibAddressEle = webDriver.findElement(By.xpath(followingSibAddress));

        String btnPrecedingSubmit = "//div[@id='browser-windows-section']/preceding::button[@id='submit-button']";
        WebElement btnPrecedingSubmitEle = webDriver.findElement(By.xpath(btnPrecedingSubmit));
        String btnFollowingClear = "//div[@test-id='gender-options']/following::button[@id='reset-button']";
        WebElement btnFollowingClearEle = webDriver.findElement(By.xpath(btnFollowingClear));

        String tarLastResXpath = "//textarea[@id='outputTextStudent']";
        WebElement tarLastResXpathEle = webDriver.findElement(By.xpath(tarLastResXpath));
        String tarContainsResXpath = "//textarea[contains(@id,'TextS')]";
        WebElement tarContainsResXpathEle = webDriver.findElement(By.xpath(tarContainsResXpath));
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();

        String FORM_H3_TEXT = "//h3[normalize-space()='%s']";
        String FORM_INPUT_PLACEHOLDER = "//input[@placeholder='%s']";
        String FORM_RADIO_CHECKBOX_DAT = "//input[@id='%s' and @type='%s']";
        String FORM_BUTTON_TEXT = "//button[normalize-space()='%s']";
        String FORM_TEXTAREA_ID = "//textarea[@id='%s']";

        String lblTitleXpath = String.format(FORM_H3_TEXT,"Form đăng ký sinh viên");
        String lblResTitleXpath = String.format(FORM_H3_TEXT,"Thông tin bạn đã nhập:");
        
        String inputFirstNameXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your first name");
        String inputLastNameXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your last name");
        String inputEmailXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your email");
        String inputPhoneXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your mobile number");
        String inputSubjectXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your subjects");

        String radioMaleXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"male","radio");
        String radioFemaleXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"female","radio");

        //HongThai => id là reading , sports, music mới chuẩn.
        String checkboxReadingXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"Reading","checkbox");
        String checkboxSportsXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"Sports","checkbox");
        String checkboxMusicXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"Music","checkbox");

        String datXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"dob","date");

        String textareaAddressXpath = String.format(FORM_TEXTAREA_ID,"address");
        String textareaResXpath = String.format(FORM_TEXTAREA_ID,"outputTextStudent");

        String btnSubmitXpath = String.format(FORM_BUTTON_TEXT,"Submit");
        String btnResetXpath = String.format(FORM_BUTTON_TEXT,"Clear");
        
        //HongThai: thiếu các lbl First name, lastname và element Thông tin bạn đã nhập với text area ở dưới
        
        webDriver.findElement(By.xpath(lblTitleXpath));
        webDriver.findElement(By.xpath(lblResTitleXpath));
        webDriver.findElement(By.xpath(inputFirstNameXpath));
        webDriver.findElement(By.xpath(inputLastNameXpath));
        webDriver.findElement(By.xpath(inputEmailXpath));
        webDriver.findElement(By.xpath(inputPhoneXpath));
        webDriver.findElement(By.xpath(inputSubjectXpath));
        webDriver.findElement(By.xpath(radioMaleXpath));
        webDriver.findElement(By.xpath(radioFemaleXpath));
        webDriver.findElement(By.xpath(checkboxReadingXpath));
        webDriver.findElement(By.xpath(checkboxSportsXpath));
        webDriver.findElement(By.xpath(checkboxMusicXpath));
        webDriver.findElement(By.xpath(datXpath));
        webDriver.findElement(By.xpath(textareaAddressXpath));
        webDriver.findElement(By.xpath(textareaResXpath));
        webDriver.findElement(By.xpath(btnSubmitXpath));
        webDriver.findElement(By.xpath(btnResetXpath));
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
