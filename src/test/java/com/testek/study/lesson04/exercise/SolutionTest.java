package com.testek.study.lesson04.exercise;

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

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // Handle other elements similarly
        //Locate the text: Textbox form title
        String lblTitleContainsCSS = "h3[test-id*='form-title']";
        webDriver.findElement(By.cssSelector(lblTitleContainsCSS));

        String lblTitleStartsWithCSS = "h3[test-id^='textbox-form-tit']";
        webDriver.findElement(By.cssSelector(lblTitleStartsWithCSS));

        //Locate Name label
        String lblNameContainsCSS = "label[test-id*='form-label-name']";
        webDriver.findElement(By.cssSelector(lblNameContainsCSS));

        String lblNameStartsWithCSS = "label[test-id*='textbox-form-label-na']";
        webDriver.findElement(By.cssSelector(lblNameStartsWithCSS));

        //Locate Name textbox
        String txtNameContainsCSS = "input[test-id*='form-input-name']";
        webDriver.findElement(By.cssSelector(txtNameContainsCSS));

        String txtNameStartsWithCSS = "input[test-id^='textbox-form-input-na']";
        webDriver.findElement(By.cssSelector(txtNameStartsWithCSS));

        //Locate Email label
        String lblEmailContainsCSS = "label[test-id*='form-label-email']";
        webDriver.findElement(By.cssSelector(lblEmailContainsCSS));

        String lblEmailStartsWithCSS = "label[test-id^='textbox-form-label-e']";
        webDriver.findElement(By.cssSelector(lblEmailStartsWithCSS));

        //Locate Email textbox
        String txtEmailContainsCSS = "input[test-id*='form-input-email']";
        webDriver.findElement(By.cssSelector(txtEmailContainsCSS));

        String txtEmailStartsWithCSS = "input[test-id^='textbox-form-input-e']";
        webDriver.findElement(By.cssSelector(txtEmailStartsWithCSS));

        //Locate Phone label
        String lblPhoneContainsCSS = "label[test-id*='form-label-phone']";
        webDriver.findElement(By.cssSelector(lblPhoneContainsCSS));

        String lblPhoneStartsWithCSS = "label[test-id^='textbox-form-label-p']";
        webDriver.findElement(By.cssSelector(lblPhoneStartsWithCSS));

        //Locate Phone textbox
        String txtPhoneContainsCSS = "input[test-id*='input-phone']";
        webDriver.findElement(By.cssSelector(txtPhoneContainsCSS));

        String txtPhoneStartsWithCSS = "input[test-id^='textbox-form-input-p']";
        webDriver.findElement(By.cssSelector(txtPhoneStartsWithCSS));

        //Locate Address label
        String lblAddressContainsCSS = "label[test-id*='-address']";
        webDriver.findElement(By.cssSelector(lblAddressContainsCSS));

        String lblAddressStartsWithCSS = "label[test-id^='textbox-form-label-a']";
        webDriver.findElement(By.cssSelector(lblAddressStartsWithCSS));

        //Locate Address textbox
        String txtAddressContainsCSS = "input[test-id*='address']";
        webDriver.findElement(By.cssSelector(txtAddressContainsCSS));

        String txtAddressStartsWithCSS = "input[test-id^='textbox-form-input-a']";
        webDriver.findElement(By.cssSelector(txtAddressStartsWithCSS));

        //Locate Button submit
        String btnSubmitContainsCSS = "button[test-id*='form-submit']";
        webDriver.findElement(By.cssSelector(btnSubmitContainsCSS));

        String btnSubmitStartsWithCSS = "button[test-id^='textbox-form-s']";
        webDriver.findElement(By.cssSelector(btnSubmitStartsWithCSS));

        //Locate Button clear
        String btnClearContainsCSS = "button[test-id*='form-reset']";
        webDriver.findElement(By.cssSelector(btnClearContainsCSS));

        String btnClearStartsWithCSS = "button[test-id^='textbox-form-r']";
        webDriver.findElement(By.cssSelector(btnClearStartsWithCSS));

        //Locate Textbox form output title
        String lblOutputTitleContainsCSS = "h3[test-id*='output-title']";
        webDriver.findElement(By.cssSelector(lblOutputTitleContainsCSS));

        String lblOutputTitleStartsWithCSS = "h3[test-id^='textbox-form-output']";
        webDriver.findElement(By.cssSelector(lblOutputTitleStartsWithCSS));

        //Locate Output textarea
        String taOutputTextContainsCSS = "textarea[test-id*='form-output']";
        webDriver.findElement(By.cssSelector(taOutputTextContainsCSS));

        String taOutputTextStartsWithCSS = "textarea[test-id^='textbox-fo']";
        webDriver.findElement(By.cssSelector(taOutputTextStartsWithCSS));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // Handle other elements similarly

        //Locate Textbox form title
        String lblTextboxFormTitleContainsXPath = "//h3[contains(@test-id,'form-title')]";
        webDriver.findElement(By.xpath(lblTextboxFormTitleContainsXPath));

        String lblTextboxFormTitleTextXPath = "//h3[text()='Nhập thông tin người dùng:']";
        webDriver.findElement(By.xpath(lblTextboxFormTitleTextXPath));

        //Locate Name label
        String lblNameStartsWithXPath = "//label[starts-with(@test-id,'textbox-form-label-n')]";
        webDriver.findElement(By.xpath(lblNameStartsWithXPath));

        String lblNameTextXPath = "//label[text()='Họ và tên:']";
        webDriver.findElement(By.xpath(lblNameTextXPath));

        //Locate Name textbox
        String txtNameDescendantXPath = "//div[@test-id='content-root']/descendant::input[@test-id='textbox-form-input-name']";
        webDriver.findElement(By.xpath(txtNameDescendantXPath));

        String txtNameFollowingXpath = "//div[@test-id='sidebar-root']/following::input[@test-id='textbox-form-input-name']";
        webDriver.findElement(By.xpath(txtNameFollowingXpath));

        //Locate Email label
        String lblEmailStartsWithXPath = "//label[starts-with(@test-id,'textbox-form-label-e')]";
        webDriver.findElement(By.xpath(lblEmailStartsWithXPath));

        String lblEmailTextXPath = "//label[text()='Email:'and @test-id='textbox-form-label-email']";
        webDriver.findElement(By.xpath(lblEmailTextXPath));

        //Locate Email textbox
        String txtEmailStartsWithXPath = "//input[starts-with(@test-id,'textbox-form-input-e')]";
        webDriver.findElement(By.xpath(txtEmailStartsWithXPath));

        String txtEmailChildXPath = "//form[@test-id='textbox-form']/child::input[@test-id='textbox-form-input-email']";
        webDriver.findElement(By.xpath(txtEmailChildXPath));

        //Locate Phone label
        String lblPhoneStartsWithXPath = "//label[starts-with(@test-id,'textbox-form-label-p')]";
        webDriver.findElement(By.xpath(lblPhoneStartsWithXPath));

        String lblPhoneTextXPath = "//label[text()='Số điện thoại:']";
        webDriver.findElement(By.xpath(lblPhoneTextXPath));

        //Locate Phone textbox
        String txtPhoneContainsXPath = "//input[contains(@test-id,'input-phone')]";
        webDriver.findElement(By.xpath(txtPhoneContainsXPath));

        String txtPhoneStartsWithXPath = "//input[starts-with(@test-id,'textbox-form-input-p')]";
        webDriver.findElement(By.xpath(txtPhoneStartsWithXPath));

        //Locate Address label
        String lblAddressStartsWithXPath = "//label[starts-with(@test-id,'textbox-form-label-a')]";
        webDriver.findElement(By.xpath(lblAddressStartsWithXPath));

        String lblAddressTextXPath = "//label[text()='Địa chỉ:']";
        webDriver.findElement(By.xpath(lblAddressTextXPath));

        //Locate Address textbox
        String txtAddressContainsXPath = "//input[contains(@test-id,'input-address')]";
        webDriver.findElement(By.xpath(txtAddressContainsXPath));

        String txtAddressStartsWithXPath = "//input[starts-with(@test-id,'textbox-form-input-a')]";
        webDriver.findElement(By.xpath(txtAddressStartsWithXPath));

        //Locate Submit button
        String btnSubmitStartsWithXPath = "//button[starts-with(@test-id,'textbox-form-s')]";
        webDriver.findElement(By.xpath(btnSubmitStartsWithXPath));

        String btnSubmitTextXPath = "//button[text()='Gửi thông tin']";
        webDriver.findElement(By.xpath(btnSubmitTextXPath));

        //Locate Button clear
        String btnClearStartsWithXPath = "//button[starts-with(@test-id,'textbox-form-r')]";
        webDriver.findElement(By.xpath(btnClearStartsWithXPath));

        String btnClearTextXPath = "//button[text()='Clear']";
        webDriver.findElement(By.xpath(btnClearTextXPath));

        //Locate Textbox form output title
        String lblOutputStartsWithXPath = "//h3[starts-with(@test-id,'textbox-form-o')]";
        webDriver.findElement(By.xpath(lblOutputStartsWithXPath));

        String lblOutputTextXPath = "//h3[text()='Thông tin bạn đã nhập:'and @test-id='textbox-form-output-title']";
        webDriver.findElement(By.xpath(lblOutputTextXPath));
        //Locate Output text
        String taOutputStartsWithXPath = "//textarea[starts-with(@test-id,'textb')]";
        webDriver.findElement(By.xpath(taOutputStartsWithXPath));

        String taOutputDescendantXPath = "//div[@test-id='content-root']/descendant::textarea[@test-id='textbox-form-output']";
        webDriver.findElement(By.xpath(taOutputDescendantXPath));

        String taOutputFollowingSiblingXPath = "//h3[@test-id='textbox-form-output-title']/following-sibling::textarea[@test-id='textbox-form-output']";
        webDriver.findElement(By.xpath(taOutputFollowingSiblingXPath));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly

        //Locate Radio title
        String lblRadioTitleContainsCSS = "h3[test-id*='radio-title']";
        webDriver.findElement(By.cssSelector(lblRadioTitleContainsCSS));

        String lblRadioTitleStartsWithCSS = "h3[test-id^='radio-t']";
        webDriver.findElement(By.cssSelector(lblRadioTitleStartsWithCSS));

        //Locate Radio button yes
        String rdoYesContainsCSS = "label[test-id*='label-yes'";
        webDriver.findElement(By.cssSelector(rdoYesContainsCSS));

        String rdoYesStartsWithCSS = "label[test-id^='radio-label-y']";
        webDriver.findElement(By.cssSelector(rdoYesStartsWithCSS));

        //Locate Radio Impressive
        String rdoImpressiveContainsCSS = "label[test-id*='label-impressive']";
        webDriver.findElement(By.cssSelector(rdoImpressiveContainsCSS));

        String rdoImpressiveStartsWithCSS = "label[test-id^='radio-label-i']";
        webDriver.findElement(By.cssSelector(rdoImpressiveStartsWithCSS));

        //Locate Radio No
        String rdoNoContainsCSS = "label[test-id*='label-no']";
        webDriver.findElement(By.cssSelector(rdoNoContainsCSS));

        String rdoNoStartsWithCSS = "label[test-id^='radio-label-n']";
        webDriver.findElement(By.cssSelector(rdoNoStartsWithCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly

        //Locate Rado title
        String lblRadioTitleContainsXPath = "//h3[contains(@test-id,'radio-title')]";
        webDriver.findElement(By.xpath(lblRadioTitleContainsXPath));

        String lblRadioTitleStartsWithXPath = "//h3[starts-with(@test-id,'radio-')]";
        webDriver.findElement(By.xpath(lblRadioTitleStartsWithXPath));


        //Locate Radio button yes
        String rdoYesContainsXPath = "//input[contains(@test-id,'radio-input-yes')]";
        webDriver.findElement(By.xpath(rdoYesContainsXPath));

        String rdoYesStartsWithXPath = "//input[starts-with(@test-id,'radio-input-y')]";
        webDriver.findElement(By.xpath(rdoYesStartsWithXPath));


        //Locate Radio button impressive
        String rdoImpressiveContainsXPath = "//input[contains(@test-id,'radio-input-impressive')]";
        webDriver.findElement(By.xpath(rdoImpressiveContainsXPath));

        String rdoImpressiveStartsWithXPath = "//input[starts-with(@test-id,'radio-input-i')]";
        webDriver.findElement(By.xpath(rdoImpressiveStartsWithXPath));


        //Locate Radio button no
        String rdoNoContainsXPath = "//input[contains(@test-id,'radio-input-no')]";
        webDriver.findElement(By.xpath(rdoNoContainsXPath));

        String rdoNoStartsWithXPath = "//input[starts-with(@test-id,'radio-input-n')]";
        webDriver.findElement(By.xpath(rdoNoStartsWithXPath));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly

        //Locate Button title
        String lblButtonTitleContainsCSS = "h3[test-id*='buttons-title']";
        webDriver.findElement(By.cssSelector(lblButtonTitleContainsCSS));

        String lblButtonTitleStartsWithCSS = "h3[test-id^='buttons-t']";
        webDriver.findElement(By.cssSelector(lblButtonTitleStartsWithCSS));

        //Locate Button click me
        String btnClickMeContainsCSS = "button[test-id*='button-click-me']";
        webDriver.findElement(By.cssSelector(btnClickMeContainsCSS));

        String btnClickMeStartsWithCSS = "button[test-id^='button-cli']";
        webDriver.findElement(By.cssSelector(btnClickMeStartsWithCSS));

        //Locate Button confirm me
        String btnConfirmMeContainsCSS = "button[test-id*='button-confirm-me']";
        webDriver.findElement(By.cssSelector(btnConfirmMeContainsCSS));

        String btnConfirmMeStartsWithCSS = "button[test-id^='button-conf']";
        webDriver.findElement(By.cssSelector(btnConfirmMeStartsWithCSS));

        //Locate Button prompt me
        String btnPromptMeContainsCSS = "button[test-id*='button-prompt-me']";
        webDriver.findElement(By.cssSelector(btnPromptMeContainsCSS));

        String btnPromptMeStartsWithCSS = "button[test-id^='button-p']";
        webDriver.findElement(By.cssSelector(btnPromptMeStartsWithCSS));

        //Locate Button different actions title
        String lblButtonDifferentActionsTitleContainsCSS = "h3[test-id*='actions-title']";
        webDriver.findElement(By.cssSelector(lblButtonDifferentActionsTitleContainsCSS));

        String lblButtonDifferentActionsTitleStartsWithCSS = "h3[test-id^='buttons-d']";
        webDriver.findElement(By.cssSelector(lblButtonDifferentActionsTitleStartsWithCSS));

        //Locate Button 1
        String btn1ContainsCSS = "button[test-id*='button1']";
        webDriver.findElement(By.cssSelector(btn1ContainsCSS));

        String btn1StartsWithCSS = "button[test-id*='button1']";
        webDriver.findElement(By.cssSelector(btn1StartsWithCSS));

        //Locate Button 2
        String btn2CSS = "#button1";
        webDriver.findElement(By.cssSelector(btn2CSS));

        //Locate Button3
        String btn3CSS = "#button3";
        webDriver.findElement(By.cssSelector(btn3CSS));

        //Locate Result
        String lblResultContainsCSS = "p[test-id*='t-text']";
        webDriver.findElement(By.cssSelector(lblResultContainsCSS));

        String lblResultStartsWithCSS = "p[test-id^='buttons-r']";
        webDriver.findElement(By.cssSelector(lblResultStartsWithCSS));

        String lblResultCSS = "#resultText";
        webDriver.findElement(By.cssSelector(lblResultCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly

        //Locate Button title
        String lblButtonTitleDescendantXPath = "//div[@test-id='content-root']/descendant::h3[@test-id='buttons-title']";
        webDriver.findElement(By.xpath(lblButtonTitleDescendantXPath));

        String lblButtonTitleTextXPath = "//h3[text()='Buttons']";
        webDriver.findElement(By.xpath(lblButtonTitleTextXPath));

        String lblButtonTitlePrecedingSiblingXPath = "//button[@test-id='button-click-me']/preceding-sibling::h3";
        webDriver.findElement(By.xpath(lblButtonTitlePrecedingSiblingXPath));

        String lblButtonTitleChildXPath = "//div[@test-id='buttons-section']/child::h3[@test-id='buttons-title']";
        webDriver.findElement(By.xpath(lblButtonTitleChildXPath));

        //Locate Button click me
        String btnClickMeTextXPath = "//button[text()='Click Me']";
        webDriver.findElement(By.xpath(btnClickMeTextXPath));

        String btnClickMePrecedingXPath = "//div[@test-id='links-section']/preceding::button[@test-id='button-click-me']";
        webDriver.findElement(By.xpath(btnClickMePrecedingXPath));

        //Locate Button confirm me
        String btnConfirmMeTextXPath = "//button[text()='Confirm Me']";
        webDriver.findElement(By.xpath(btnConfirmMeTextXPath));

        String btnConfirmMeFollowingXPath = "//button[@test-id='button-click-me']/following::button[@test-id='button-confirm-me']";
        webDriver.findElement(By.xpath(btnConfirmMeFollowingXPath));

        //Locate Button Prompt me
        String btnPromptMeTextXPath = "//button[text()='Prompt Me']";
        webDriver.findElement(By.xpath(btnPromptMeTextXPath));

        String btnPromptMePrecedingSiblingXPath = "//button[@test-id='button1']/preceding-sibling::button[@test-id='button-prompt-me']";
        webDriver.findElement(By.xpath(btnPromptMePrecedingSiblingXPath));

        //Locate Buttons different actions title
        String lblButtonDifferentActionsTitleNormalizeSpaceXPath = "//h3[text()='Buttons with Different Actions (Click, Right-Click, Double-Click)://h3[normalize-space()='Buttons with Different Actions (Click, Right-Click, Double-Click):']";
        webDriver.findElement(By.xpath(lblButtonDifferentActionsTitleNormalizeSpaceXPath));

        String lblButtonDifferentActionsTitleChildXpath = "//div[@test-id='buttons-section']/h3[@test-id='buttons-different-actions-title']";
        webDriver.findElement(By.xpath(lblButtonDifferentActionsTitleChildXpath));

        //Locate Button 1
        String btn1TextXPath = "//button[text()='Button 1']";
        webDriver.findElement(By.xpath(btn1TextXPath));

        String btn1PrecedingSiblingXPath = "//button[@test-id='button2']/preceding-sibling::button[@test-id='button1']";
        webDriver.findElement(By.xpath(btn1PrecedingSiblingXPath));

        //Locate Button 2
        String btn2TextXPath = "//button[text()='Button 2']";
        webDriver.findElement(By.xpath(btn2TextXPath));

        String btn2FollowingSiblingXPath = "//button[@test-id='button1']/following-sibling::button[@test-id='button2']";
        webDriver.findElement(By.xpath(btn2FollowingSiblingXPath));

        //Locate Button 3
        String btn3TextXPath = "//button[text()='Button 3']";
        webDriver.findElement(By.xpath(btn3TextXPath));

        String btn3FollowingXPath = "//div[@test-id='radio-section']/following::button[@test-id='button3']";
        webDriver.findElement(By.xpath(btn3FollowingXPath));

        //Locate Interaction result
        String lblResultTextXPath = "p[text()='Hãy nhấn vào một nút để kiểm tra sự kiện.']";
        webDriver.findElement(By.xpath(lblResultTextXPath));

        String lblResultDescendantXPath = "//div[@test-id='buttons-section']/descendant::p";
        webDriver.findElement(By.xpath(lblResultDescendantXPath));

    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly

        //Locate Dynamic properties title
        String lblDynamicPropertiesTitleContainsCSS = "h3[test-id*='ies-title']";
        webDriver.findElement(By.cssSelector(lblDynamicPropertiesTitleContainsCSS));

        String lblDynamicPropertiesTitleStartsWithCSS = "h3[test-id^='dynamic-properties']";
        webDriver.findElement(By.cssSelector(lblDynamicPropertiesTitleStartsWithCSS));

        String lblDynamicPropertiesTitleCSS = "#dynamic-properties-title";
        webDriver.findElement(By.cssSelector(lblDynamicPropertiesTitleCSS));

        //Locate Change color button
        String btnChangeColorContainsCSS = "button[test-id*='change-color-button']";
        webDriver.findElement(By.cssSelector(btnChangeColorContainsCSS));

        String btnChangeColorStartsWithCSS = "button[test-id^='change']";
        webDriver.findElement(By.cssSelector(btnChangeColorStartsWithCSS));

        String btnChangeColorCSS = "#change-color-button";
        webDriver.findElement(By.cssSelector(btnChangeColorCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly
        //Locate Dynamic properties title
        String lblDynamicPropertiesTitleStartsWithXPath = "//h3[starts-with(@test-id,'dynamic-pro')]";
        webDriver.findElement(By.xpath(lblDynamicPropertiesTitleStartsWithXPath));

        String lblDynamicPropertiesTitleTextXPath = "//h3[text()='Dynamic Properties']";
        webDriver.findElement(By.xpath(lblDynamicPropertiesTitleTextXPath));

        String lblDynamicPropertiesTitlePrecedingSiblingXPath = "//button[@test-id='change-color-button']/preceding-sibling::h3";
        webDriver.findElement(By.xpath(lblDynamicPropertiesTitlePrecedingSiblingXPath));

        //Locate Change color button
        String btnChangeColorStartsWithXPath = "//button[starts-with(@test-id,'change')]";
        webDriver.findElement(By.xpath(btnChangeColorStartsWithXPath));

        String btnChangeColorTextXPath = "//button[text()='Click to Change Color']";
        webDriver.findElement(By.xpath(btnChangeColorTextXPath));

        String btnChangeColorChildXPath = "//div[@test-id='dynamic-section']/child::button";
        webDriver.findElement(By.xpath(btnChangeColorChildXPath));

    }


    /**
     * Go to Test Website
     */
    void gotoTestWebsite(Menu menu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        // Access: Elements > [Menu]
        String mnuElementXPath = "//div[@test-id='menu-elements']";
        WebElement mnuElementEle = webDriver.findElement(By.xpath(mnuElementXPath));
        mnuElementEle.click();

        String mnuXPath = String.format("//div[@test-id='%s']", menu.getName());
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
}
