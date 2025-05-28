package com.testek.study.lesson04.exercise;

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
import com.testek.study.common.Menu;

import javax.print.DocFlavor;

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
        //Textbox form title
        String lblTitleContainsCSS = "h3[test-id*='form-title']";
        WebElement lblTitleContainsEle = webDriver.findElement(By.cssSelector(lblTitleContainsCSS));

        String lblTitleStartsWithCSS = "h3[test-id^='textbox-form-tit']";
        WebElement lblTitleStartsWithEle = webDriver.findElement(By.cssSelector(lblTitleStartsWithCSS));

        //Name label
        String lblNameContainsCSS = "label[test-id*='form-label-name']";
        WebElement lblNameContainsEle = webDriver.findElement(By.cssSelector(lblNameContainsCSS));

        String lblNameStartsWithCSS = "label[test-id*='textbox-form-label-na']";
        WebElement lblNameStartsWithEle = webDriver.findElement(By.cssSelector(lblNameStartsWithCSS));

        //Name textbox
        String txtNameContainsCSS = "input[test-id*='form-input-name']";
        WebElement txtNameContainsEle = webDriver.findElement(By.cssSelector(txtNameContainsCSS));

        String txtNameStartsWithCSS = "input[test-id^='textbox-form-input-na']";
        WebElement txtNameStartsWithEle = webDriver.findElement(By.cssSelector(txtNameStartsWithCSS));

        //Email label
        String lblEmailContainsCSS = "label[test-id*='form-label-email']";
        WebElement lblEmailContainsEle = webDriver.findElement(By.cssSelector(lblEmailContainsCSS));

        String lblEmailStartsWithCSS = "label[test-id^='textbox-form-label-e']";
        WebElement lblEmailStartsWithEle = webDriver.findElement(By.cssSelector(lblEmailStartsWithCSS));

        //Email textbox
        String txtEmailContainsCSS = "input[test-id*='form-input-email']";
        WebElement txtEmailContainsEle = webDriver.findElement(By.cssSelector(txtEmailContainsCSS));

        String txtEmailStartsWithCSS = "input[test-id^='textbox-form-input-e']";
        WebElement txtEmailStartsWithEle = webDriver.findElement(By.cssSelector(txtEmailStartsWithCSS));

        //Phone label
        String lblPhoneContainsCSS = "label[test-id*='form-label-phone']";
        WebElement lblPhoneContainsEle = webDriver.findElement(By.cssSelector(lblPhoneContainsCSS));

        String lblPhoneStartsWithCSS = "label[test-id^='textbox-form-label-p']";
        WebElement lblPhoneStartsWithEle = webDriver.findElement(By.cssSelector(lblPhoneStartsWithCSS));

        //Phone textbox
        String txtPhoneContainsCSS = "input[test-id*='input-phone']";
        WebElement txtPhoneContainsEle = webDriver.findElement(By.cssSelector(txtPhoneContainsCSS));

        String txtPhoneStartsWithCSS = "input[test-id^='textbox-form-input-p']";
        WebElement txtPhoneStartsWithEle = webDriver.findElement(By.cssSelector(txtPhoneStartsWithCSS));

        //Address label
        String lblAddressContainsCSS = "label[test-id*='-address']";
        WebElement lblAddressContainsEle = webDriver.findElement(By.cssSelector(lblAddressContainsCSS));

        String lblAddressStartsWithCSS = "label[test-id^='textbox-form-label-a']";
        WebElement lblAddressStartsWithEle = webDriver.findElement(By.cssSelector(lblAddressStartsWithCSS));

        //Address textbox
        String txtAddressContainsCSS = "input[test-id*='address']";
        WebElement txtAddressContainsEle = webDriver.findElement(By.cssSelector(txtAddressContainsCSS));

        String txtAddressStartsWithCSS = "input[test-id^='textbox-form-input-a']";
        WebElement txtAddressStartsWithEle = webDriver.findElement(By.cssSelector(txtAddressStartsWithCSS));

        //Button submit
        String btnSubmitContainsCSS = "button[test-id*='form-submit']";
        WebElement btnSubmitContainsEle = webDriver.findElement(By.cssSelector(btnSubmitContainsCSS));

        String btnSubmitStartsWithCSS = "button[test-id^='textbox-form-s']";
        WebElement btnSubmitStartsWithEle = webDriver.findElement(By.cssSelector(btnSubmitStartsWithCSS));

        //Button clear
        String btnClearContainsCSS = "button[test-id*='form-reset']";
        WebElement btnClearContainsEle = webDriver.findElement(By.cssSelector(btnClearContainsCSS));

        String btnClearStartsWithCSS= "button[test-id^='textbox-form-r']";
        WebElement btnClearStartsWithEle = webDriver.findElement(By.cssSelector(btnClearStartsWithCSS));

        //Textbox form output title
        String lblOutputTitleContainsCSS = "h3[test-id*='output-title']";
        WebElement lblOutputTitleContainsEle = webDriver.findElement(By.cssSelector(lblOutputTitleContainsCSS));

        String lblOutputTitleStartsWithCSS = "h3[test-id^='textbox-form-output']";
        WebElement lblOutputTitleStartsWithEle = webDriver.findElement(By.cssSelector(lblOutputTitleStartsWithCSS));

        //Output textarea
        String taOutputTextContainsCSS = "textarea[test-id*='form-output']";
        WebElement taOutputTextContainsEle = webDriver.findElement(By.cssSelector(taOutputTextContainsCSS));

        String taOutputTextStartsWithCSS = "textarea[test-id^='textbox-fo']";
        WebElement taOutputTextStartsWithEle = webDriver.findElement(By.cssSelector(taOutputTextStartsWithCSS));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // Handle other elements similarly

        //Textbox form title
        String lblTextboxFormTitleContainsXPath = "//h3[contains(@test-id,'form-title')]";
        WebElement lblTextboxFormTitleContainsEle = webDriver.findElement(By.xpath(lblTextboxFormTitleContainsXPath));

        String lblTextboxFormTitleStartWithXPath = "//h3[starts-with(@test-id,'textbox-form-t')]";
        WebElement lblTextboxFormTitleStartsWithEle = webDriver.findElement(By.xpath(lblTextboxFormTitleStartWithXPath));

        String lblTextboxFormTitleTextXPath = "//h3[text()='Nhập thông tin người dùng:']";
        WebElement lblTextboxFormTitleTextEle = webDriver.findElement(By.xpath(lblTextboxFormTitleTextXPath));

        String lblTextboxFormTitleDescendantXPath = "//div[@test-id='textbox-section']/descendant::h3[@test-id='textbox-form-title']";
        WebElement lblTextboxFormTitleDescendantELe = webDriver.findElement(By.xpath(lblTextboxFormTitleDescendantXPath));

        String lblTextboxFormTitlePrecedingXPath = "//h3[@test-id='textbox-form-output-title']/preceding::h3[@test-id='textbox-form-title']";
        WebElement lblTextboxFormTitlePrecedingEle = webDriver.findElement(By.xpath(lblTextboxFormTitlePrecedingXPath));

        String lblTextboxFormTitleChildXPath = "//div[@test-id='textbox-form-container']/child::h3[@test-id='textbox-form-title']";
        WebElement lblTextboxFormTitleChildEle = webDriver.findElement(By.xpath(lblTextboxFormTitleChildXPath));

        //Name label
        String lblNameContainsXPath = "//label[contains(@test-id,'label-name')]";
        WebElement lblNameContainsEle = webDriver.findElement(By.xpath(lblNameContainsXPath));

        String lblNameStartsWithXPath = "//label[starts-with(@test-id,'textbox-form-label-n')]";
        WebElement lblNameStartsWithEle = webDriver.findElement(By.xpath(lblNameStartsWithXPath));

        String lblNameTextXPath = "//label[text()='Họ và tên:']";
        WebElement lblNameTextEle = webDriver.findElement(By.xpath(lblNameTextXPath));

        String lblNameDescendantXPath = "//div[@test-id='textbox-section']/descendant::label[@test-id='textbox-form-label-name']";
        WebElement lblNameDescendantEle = webDriver.findElement(By.xpath(lblNameDescendantXPath));

        String lblNamePrecedingSiblingXPath = "//label[@test-id='textbox-form-label-phone']/preceding-sibling::label[@test-id='textbox-form-label-name']";
        WebElement lblNamePrecedingSiblingEle = webDriver.findElement(By.xpath(lblNamePrecedingSiblingXPath));

        String lblNameFollowingXpath = "//div[@test-id='sidebar-root']/following::label[@test-id='textbox-form-label-name']";
        WebElement lblNameFollowingEle = webDriver.findElement(By.xpath(lblNameFollowingXpath));

        String lblNameChildXPath = "//form[@test-id='textbox-form']/child::label[@test-id='textbox-form-label-name']";
        WebElement lblNameChildEle = webDriver.findElement(By.xpath(lblNameChildXPath));

        //Name textbox
        String txtNameContainsXPath = "//input[contains(@placeholder,'họ tên')]";
        WebElement txtNameContainsEle = webDriver.findElement(By.xpath(txtNameContainsXPath));

        String txtNameStartsWithXPath = "//input[contains(@placeholder,'Nhập h')]";
        WebElement txtNameStartsWithEle = webDriver.findElement(By.xpath(txtNameStartsWithXPath));

        String txtNameDescendantXPath = "//div[@test-id='content-root']/descendant::input[@test-id='textbox-form-input-name']";
        WebElement txtNameDescendantEle = webDriver.findElement(By.xpath(txtNameDescendantXPath));

        String txtNamePrecedingSiblingXPath = "//input[@test-id='textbox-form-input-email']/preceding-sibling::input[@test-id='textbox-form-input-name']";
        WebElement txtNamePrecedingSiblingEle = webDriver.findElement(By.xpath(txtNamePrecedingSiblingXPath));

        String txtNameFollowingSiblingXPath = "//label[@test-id='textbox-form-label-name']/following-sibling::input[@test-id='textbox-form-input-name']";
        WebElement txtNameFollowingSiblingEle = webDriver.findElement(By.xpath(txtNameFollowingSiblingXPath));

        String txtNameFollowingXpath = "//div[@test-id='sidebar-root']/following::input[@test-id='textbox-form-input-name']";
        WebElement txtNameFollowingEle = webDriver.findElement(By.xpath(txtNameFollowingXpath));

        String txtNameChildXPath = "//form[@test-id='textbox-form']/child::input[@test-id='textbox-form-input-name']";
        WebElement txtNameChildEle = webDriver.findElement(By.xpath(txtNameChildXPath));

        //Email label
        String lblEmailContainsXPath = "//label[contains(@test-id,'-label-email')]";
        WebElement lblEmailContainsEle = webDriver.findElement(By.xpath(lblEmailContainsXPath));

        String lblEmailStartsWithXPath = "//label[starts-with(@test-id,'textbox-form-label-e')]";
        WebElement lblEmailStartWithEle = webDriver.findElement(By.xpath(lblEmailStartsWithXPath));

        String lblEmailTextXPath = "//label[text()='Email:'and@test-id='textbox-form-label-email']";
        WebElement lblEmailTextEle = webDriver.findElement(By.xpath(lblEmailTextXPath));

        String lblEmailPrecedingSiblingXPath = "//label[@test-id='textbox-form-label-phone']/preceding-sibling::label[@test-id='textbox-form-label-email']";
        WebElement lblEmailPrecedingSiblingEle = webDriver.findElement(By.xpath(lblEmailPrecedingSiblingXPath));

        String lblEmailFollowingSiblingXPath = "//label[@test-id='textbox-form-label-name']/following-sibling::label[@test-id='textbox-form-label-email']";
        WebElement lblEmailFollowingSiblingEle = webDriver.findElement(By.xpath(lblEmailFollowingSiblingXPath));

        String lblEmailDescendantXPath = "//div[@test-id='textbox-section']/descendant::label[@test-id='textbox-form-label-email']";
        WebElement lblEmailDescendantEle = webDriver.findElement(By.xpath(lblEmailDescendantXPath));

        String lblEmailFollowingXpath = "//div[@test-id='sidebar-root']/following::label[@test-id='textbox-form-label-email']";
        WebElement lblEmailFollowingEle = webDriver.findElement(By.xpath(lblEmailFollowingXpath));

        String lblEmailChildXPath = "//form[@test-id='textbox-form']/child::label[@test-id='textbox-form-label-email']";
        WebElement lblEmailChildXPathEle = webDriver.findElement(By.xpath(lblEmailChildXPath));

        //Email textbox
        String txtEmailContainsXPath = "//input[contains(@test-id,'-input-email')]";
        WebElement txtEmailContainsEle = webDriver.findElement(By.xpath(txtEmailContainsXPath));

        String txtEmailStartsWithXPath = "//input[starts-with(@test-id,'textbox-form-input-e')]";
        WebElement txtEmailStartsWithEle = webDriver.findElement(By.xpath(txtEmailStartsWithXPath));

        String txtEmailDescendantXPath = "//div[@test-id='textbox-section']/descendant::input[@test-id='textbox-form-input-email']";
        WebElement txtEmailDescendantEle = webDriver.findElement(By.xpath(txtEmailDescendantXPath));

        String txtEmailPrecedingSiblingXPath = "//input[@test-id='textbox-form-input-phone']/preceding-sibling::input[@test-id='textbox-form-input-email']";
        WebElement txtEmailPrecedingSiblingEle = webDriver.findElement(By.xpath(txtEmailPrecedingSiblingXPath));

        String txtEmailFollowingSiblingXPath = "//input[@test-id='textbox-form-input-name']/following-sibling::input[@test-id='textbox-form-input-email']";
        WebElement txtEmailFollowingSiblingEle = webDriver.findElement(By.xpath(txtEmailFollowingSiblingXPath));

        String txtEmailFollowingXpath = "//div[@test-id='sidebar-root']/following::input[@test-id='textbox-form-input-email']";
        WebElement txtEmailFollowingEle = webDriver.findElement(By.xpath(txtEmailFollowingXpath));

        String txtEmailChildXPath = "//form[@test-id='textbox-form']/child::input[@test-id='textbox-form-input-email']";
        WebElement txtEmailChildEle = webDriver.findElement(By.xpath(txtEmailChildXPath));

        //Phone label
        String lblPhoneContainsXPath = "//label[contains(@test-id,'form-label-phone')]";
        WebElement lblPhoneContainsEle = webDriver.findElement(By.xpath(lblPhoneContainsXPath));

        String lblPhoneStartsWithXPath = "//label[starts-with(@test-id,'textbox-form-label-p')]";
        WebElement lblPhoneStartsWithEle = webDriver.findElement(By.xpath(lblPhoneStartsWithXPath));

        String lblPhoneTextXPath = "//label[text()='Số điện thoại:']";
        WebElement lblPhoneTextEle = webDriver.findElement(By.xpath(lblPhoneTextXPath));

        String lblPhoneDescendantXPath = "//div[@test-id='textbox-form-container']/descendant::label[@test-id='textbox-form-label-phone']";
        WebElement lblPhoneDescendantEle = webDriver.findElement(By.xpath(lblPhoneDescendantXPath));

        String lblPhonePrecedingSiblingXPath = "//label[@test-id='textbox-form-label-address']/preceding-sibling::label[@test-id='textbox-form-label-phone']";
        WebElement lblPhonePrecedingSiblingEle = webDriver.findElement(By.xpath(lblPhonePrecedingSiblingXPath));

        String lblPhoneFollowingSiblingXPath = "//label[@test-id='textbox-form-label-email']/following-sibling::label[@test-id='textbox-form-label-phone']";
        WebElement lblPhoneFollowingSiblingEle = webDriver.findElement(By.xpath(lblPhoneFollowingSiblingXPath));

        String lblPhoneFollowingXpath = "//div[@test-id='sidebar-root']/following::label[@test-id='textbox-form-label-phone']";
        WebElement lblPhoneFollowingEle = webDriver.findElement(By.xpath(lblPhoneFollowingXpath));

        String lblPhoneChildXPath = "//form[@test-id='textbox-form']/child::label[@test-id='textbox-form-label-phone']";
        WebElement lblPhoneChildEle = webDriver.findElement(By.xpath(lblPhoneChildXPath));

        //Phone textbox
        String txtPhoneContainsXPath = "//input[contains(@test-id,'input-phone')]";
        WebElement txtPhoneContainsEle = webDriver.findElement(By.xpath(txtPhoneContainsXPath));

        String txtPhoneStartsWithXPath = "//input[starts-with(@test-id,'textbox-form-input-p')]";
        WebElement txtPhoneStartsWithEle = webDriver.findElement(By.xpath(txtPhoneStartsWithXPath));

        String txtPhoneDescendantXPath = "//div[@test-id='textbox-section']/descendant::input[@test-id='textbox-form-input-phone']";
        WebElement txtPhoneDescendantEle = webDriver.findElement(By.xpath(txtPhoneDescendantXPath));

        String txtPhonePrecedingSiblingXPath = "//input[@test-id='textbox-form-input-address']/preceding-sibling::input[@test-id='textbox-form-input-phone']";
        WebElement txtPhonePrecedingSiblingEle = webDriver.findElement(By.xpath(txtPhonePrecedingSiblingXPath));

        String txtPhoneFollowingSiblingXPath = "//input[@test-id='textbox-form-input-name']/following-sibling::input[@test-id='textbox-form-input-phone']";
        WebElement txtPhoneFollowingSiblingEle = webDriver.findElement(By.xpath(txtPhoneFollowingSiblingXPath));

        String txtPhoneFollowingXpath = "//div[@test-id='sidebar-root']/following::input[@test-id='textbox-form-input-phone']";
        WebElement txtPhoneFollowingEle = webDriver.findElement(By.xpath(txtPhoneFollowingXpath));

        String PhoneChildXPath = "//form[@test-id='textbox-form']/child::input[@test-id='textbox-form-input-phone']";
        WebElement txtPhoneChildEle = webDriver.findElement(By.xpath(txtEmailChildXPath));

        //Address label
        String lblAddressContainsXPath = "//label[contains(@test-id,'-label-address')]";
        WebElement lblAddressContainsEle = webDriver.findElement(By.xpath(lblAddressContainsXPath));

        String lblAddressStartsWithXPath = "//label[starts-with(@test-id,'textbox-form-label-a')]";
        WebElement lblAddressStartsWithEle = webDriver.findElement(By.xpath(lblAddressStartsWithXPath));

        String lblAddressTextXPath = "//label[text()='Địa chỉ:']";
        WebElement lblAddressTextEle = webDriver.findElement(By.xpath(lblAddressTextXPath));

        String lblAddressDescendantXPath = "//div[@test-id='textbox-form-container']/descendant::label[@test-id='textbox-form-label-address']";
        WebElement lblAddressDescendantEle = webDriver.findElement(By.xpath(lblAddressDescendantXPath));

        String lblAddressPrecedingSiblingXPath = "//input[@test-id='textbox-form-input-address']/preceding-sibling::label[@test-id='textbox-form-label-address']";
        WebElement lblAddressPrecedingSiblingEle = webDriver.findElement(By.xpath(lblAddressPrecedingSiblingXPath));

        String lblAddressFollowingSiblingXPath = "//label[@test-id='textbox-form-label-email']/following-sibling::label[@test-id='textbox-form-label-address']";
        WebElement lblAddressFollowingSiblingEle = webDriver.findElement(By.xpath(lblAddressFollowingSiblingXPath));

        String lblAddressFollowingXpath = "//div[@test-id='sidebar-root']/following::label[@test-id='textbox-form-label-address']";
        WebElement lblAddressFollowingEle = webDriver.findElement(By.xpath(lblAddressFollowingXpath));

        String lblAddressChildXPath = "//form[@test-id='textbox-form']/child::label[@test-id='textbox-form-label-address']";
        WebElement lblAddressChildEle = webDriver.findElement(By.xpath(lblAddressChildXPath));

        //Address textbox
        String txtAddressContainsXPath = "//input[contains(@test-id,'input-address')]";
        WebElement txtAddressContainsEle = webDriver.findElement(By.xpath(txtAddressContainsXPath));

        String txtAddressStartsWithXPath = "//input[starts-with(@test-id,'textbox-form-input-a')]";
        WebElement txtAddressStartsWithEle = webDriver.findElement(By.xpath(txtAddressStartsWithXPath));

        String txtAddressDescendantXPath = "//div[@test-id='textbox-form-container']/descendant::input[@test-id='textbox-form-input-address']";
        WebElement txtAddressDescendantEle = webDriver.findElement(By.xpath(txtAddressDescendantXPath));

        String txtAddressPrecedingSiblingXPath = "//button[@test-id='textbox-form-submit']/preceding-sibling::input[@test-id='textbox-form-input-address']";
        WebElement txtAddressPrecedingSiblingEle = webDriver.findElement(By.xpath(txtAddressPrecedingSiblingXPath));

        String txtAddressFollowingSiblingXPath = "//input[@test-id='textbox-form-input-email']/following-sibling::input[@test-id='textbox-form-input-address']";
        WebElement txtAddressFollowingSiblingEle = webDriver.findElement(By.xpath(txtAddressFollowingSiblingXPath));

        String txtAddressFollowingXpath = "//div[@test-id='sidebar-root']/following::input[@test-id='textbox-form-input-address']";
        WebElement txtAddressFollowingEle = webDriver.findElement(By.xpath(txtAddressFollowingXpath));

        String txtAddressChildXPath = "//form[@test-id='textbox-form']/child::input[@test-id='textbox-form-input-address']";
        WebElement txtAddressChildXPathEle = webDriver.findElement(By.xpath(txtAddressChildXPath));

        //Submit button
        String btnSubmitContainsXPath = "//button[contains(@test-id,'form-submit')]";
        WebElement btnSubmitContainsEle = webDriver.findElement(By.xpath(btnSubmitContainsXPath));

        String btnSubmitStartsWithXPath = "//button[starts-with(@test-id,'textbox-form-s')]";
        WebElement btnSubmitStartsWithEle = webDriver.findElement(By.xpath(btnSubmitStartsWithXPath));

        String btnSubmitTextXPath = "//button[text()='Gửi thông tin']";
        WebElement btnSubmitTextEle = webDriver.findElement(By.xpath(btnSubmitTextXPath));

        String btnSubmitDescendantXPath = "//div[@test-id='textbox-form-container']/descendant::button[@test-id='textbox-form-submit']";
        WebElement btnSubmitDescendantEle = webDriver.findElement(By.xpath(btnSubmitDescendantXPath));

        String btnSubmitPrecedingSiblingXPath = "//button[@test-id='textbox-form-reset']/preceding-sibling::button[@test-id='textbox-form-submit']";
        WebElement btnSubmitPrecedingSiblingEle = webDriver.findElement(By.xpath(btnSubmitPrecedingSiblingXPath));

        String btnSubmitFollowingSiblingXPath = "//input[@test-id='textbox-form-input-phone']/following-sibling::button[@test-id='textbox-form-submit']";
        WebElement btnSubmitFollowingSiblingEle = webDriver.findElement(By.xpath(btnSubmitFollowingSiblingXPath));

        String btnSubmitFollowingXpath = "//div[@test-id='sidebar-root']/following::button[@test-id='textbox-form-submit']";
        WebElement btnSubmitFollowingEle = webDriver.findElement(By.xpath(btnSubmitFollowingXpath));

        String btnSubmitChildXPath = "//form[@test-id='textbox-form']/child::button[@test-id='textbox-form-submit']";
        WebElement btnSubmitChildEle = webDriver.findElement(By.xpath(btnSubmitChildXPath));

        //Button clear
        String btnClearContainsXPath = "//button[contains(@test-id,'form-reset')]";
        WebElement btnClearContainsEle = webDriver.findElement(By.xpath(btnClearContainsXPath));

        String btnClearStartsWithXPath = "//button[starts-with(@test-id,'textbox-form-r')]";
        WebElement btnClearStartsWithEle = webDriver.findElement(By.xpath(btnClearStartsWithXPath));

        String btnClearTextXPath = "//button[text()='Clear']";
        WebElement btnClearTextEle = webDriver.findElement(By.xpath(btnClearTextXPath));

        String btnClearDescendantXPath = "//div[@test-id='textbox-section']/descendant::button[@test-id='textbox-form-reset']";
        WebElement btnClearDescendantEle = webDriver.findElement(By.xpath(btnClearDescendantXPath));

        String btnClearFollowingSiblingXPath = "//input[@test-id='textbox-form-input-name']/following-sibling::button[@test-id='textbox-form-reset']";
        WebElement btnClearFollowingSiblingEle = webDriver.findElement(By.xpath(btnClearFollowingSiblingXPath));

        String btnClearFollowingXpath = "//div[@test-id='sidebar-root']/following::button[@test-id='textbox-form-reset']";
        WebElement btnClearFollowingEle = webDriver.findElement(By.xpath(btnClearFollowingXpath));

        String btnClearPrecedingXPath ="//div[@test-id='checkbox-section']/preceding::button[@test-id='textbox-form-reset']";
        WebElement btnClearPrecedingEle = webDriver.findElement(By.xpath(btnClearPrecedingXPath));

        String btnClearChildXPath = "//form[@test-id='textbox-form']/child::button[@test-id='textbox-form-reset']";
        WebElement btnClearChildEle = webDriver.findElement(By.xpath(btnClearChildXPath));

        //Textbox form output title
        String lblOutputContainsXPath = "//h3[contains(@test-id,'output-title')]";
        WebElement lblOutputContainsEle = webDriver.findElement(By.xpath(lblOutputContainsXPath));

        String lblOutputStartsWithXPath = "//h3[starts-with(@test-id,'textbox-form-o')]";
        WebElement lblOutputStartsWithEle = webDriver.findElement(By.xpath(lblOutputStartsWithXPath));

        String lblOutputTextXPath = "//h3[text()='Thông tin bạn đã nhập:'and@test-id='textbox-form-output-title']";
        WebElement lblOutputTextEle = webDriver.findElement(By.xpath(lblOutputTextXPath));

        String lblOutputDescendantXPath = "//div[@test-id='textbox-form-container']/descendant::h3[@test-id='textbox-form-output-title']";
        WebElement lblOutputDescendantEle = webDriver.findElement(By.xpath(lblOutputDescendantXPath));

        String lblOutputPrecedingSiblingXPath = "//textarea[@test-id='textbox-form-output']/preceding-sibling::h3[@test-id='textbox-form-output-title']";
        WebElement lblOutputPrecedingSiblingEle = webDriver.findElement(By.xpath(lblOutputPrecedingSiblingXPath));

        String lblOutputFollowingSiblingXPath = "//form[@test-id='textbox-form']/following-sibling::h3[@test-id='textbox-form-output-title']";
        WebElement lblOutputFollowingSiblingEle = webDriver.findElement(By.xpath(lblOutputFollowingSiblingXPath));

        String lblOutputPrecedingXPath = "//div[@test-id='checkbox-section']/preceding::h3[@test-id='textbox-form-output-title']";
        WebElement lblOutputPrecedingEle = webDriver.findElement(By.xpath(lblOutputPrecedingXPath));

        String lblOutputFollowingXPath = "//div[@test-id='about-me-section']/following::h3[@test-id='textbox-form-output-title']";
        WebElement lblOutputFollowingEle = webDriver.findElement(By.xpath(lblOutputFollowingXPath));

        String lblOutputChildXPath = "//div[@test-id='textbox-form-container']/child::h3[@test-id='textbox-form-output-title']";
        WebElement lblOutputChildEle = webDriver.findElement(By.xpath(lblOutputChildXPath));

        //Output text
        String taOutputContainsXPath = "//textarea[contains(@test-id,'form-output')]";
        WebElement taOutputContainsEle = webDriver.findElement(By.xpath(taOutputContainsXPath));

        String taOutputStartsWithXPath = "//textarea[starts-with(@test-id,'textb')]";
        WebElement taOutputStartsWithEle = webDriver.findElement(By.xpath(taOutputStartsWithXPath));

        String taOutputDescendantXPath = "//div[@test-id='content-root']/descendant::textarea[@test-id='textbox-form-output']";
        WebElement taOutputDescendantEle = webDriver.findElement(By.xpath(taOutputDescendantXPath));

        String taOutputFollowingSiblingXPath = "//h3[@test-id='textbox-form-output-title']/following-sibling::textarea[@test-id='textbox-form-output']";
        WebElement taOutputFollowingSiblingEle = webDriver.findElement(By.xpath(taOutputFollowingSiblingXPath));

        String taOutputPrecedingXPath = "//div[@test-id='checkbox-section']/preceding::textarea[@test-id='textbox-form-output']";
        WebElement taOutputPrecedingEle = webDriver.findElement(By.xpath(taOutputPrecedingXPath));

        String taOutputFollowingXPath = "//h4[@test-id='about-me-separator']/following::textarea[@test-id='textbox-form-output']";
        WebElement taOutputFollowingEle = webDriver.findElement(By.xpath(taOutputFollowingXPath));

        String taOutputChildXPath = "//div[@test-id='textbox-form-container']/child::textarea[@test-id='textbox-form-output']";
        WebElement taOutputChildEle = webDriver.findElement(By.xpath(taOutputChildXPath));


    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly

        //Radio title
        String lblRadioTitleContainsCSS = "h3[test-id*='radio-title']";
        WebElement lblRadioTitleContainsEle = webDriver.findElement(By.cssSelector(lblRadioTitleContainsCSS));

        String lblRadioTitleStartsWithCSS = "h3[test-id^='radio-t']";
        WebElement lblRadioTitleStartsWithEle = webDriver.findElement(By.cssSelector(lblRadioTitleStartsWithCSS));

        //Radio button yes
        String rdoYesContainsCSS = "label[test-id*='label-yes'";
        WebElement rdoYesContainsEle = webDriver.findElement(By.cssSelector(rdoYesContainsCSS));

        String rdoYesStartsWithCSS = "label[test-id^='radio-label-y']";
        WebElement rdoYesStartsWithEle = webDriver.findElement(By.cssSelector(rdoYesStartsWithCSS));

        //Radio Impressive
        String rdoImpressiveContainsCSS = "label[test-id*='label-impressive']";
        WebElement rdoImpressiveContainsEle = webDriver.findElement(By.cssSelector(rdoImpressiveContainsCSS));

        String rdoImpressiveStartsWithCSS = "label[test-id^='radio-label-i']";
        WebElement rdoImpressiveStartsWithEle = webDriver.findElement(By.cssSelector(rdoImpressiveStartsWithCSS));

        //Radio No
        String rdoNoContainsCSS = "label[test-id*='label-no']";
        WebElement rdoNoContainsEle = webDriver.findElement(By.cssSelector(rdoNoContainsCSS));

        String rdoNoStartsWithCSS = "label[test-id^='radio-label-n']";
        WebElement rdoNoStartsWithEle = webDriver.findElement(By.cssSelector(rdoNoStartsWithCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly

        //Rado title
        String lblRadioTitleContainsXPath = "//h3[contains(@test-id,'radio-title')]";
        WebElement lblRadioTitleContainsEle = webDriver.findElement(By.xpath(lblRadioTitleContainsXPath));

        String lblRadioTitleStartsWithXPath = "//h3[starts-with(@test-id,'radio-')]";
        WebElement lblRadioTitleStartsWithEle = webDriver.findElement(By.xpath(lblRadioTitleStartsWithXPath));

        String lblRadioTitleTextXPath = "//h3[text()='Do you like the site?']";
        WebElement lblRadioTitleTextEle = webDriver.findElement(By.xpath(lblRadioTitleTextXPath));

        String lblRadioTitleDescendantXPath = "//div[@test-id='radio-section']/descendant::h3[@test-id='radio-title']";
        WebElement lblRadioTitleDescendantEle = webDriver.findElement(By.xpath(lblRadioTitleDescendantXPath));

        String lblRadioTitlePrecedingSiblingXpath = "//div[@test-id='radio-group']/preceding-sibling::h3";
        WebElement lblRadioTitlePrecedingSiblingEle = webDriver.findElement(By.xpath(lblRadioTitlePrecedingSiblingXpath));

        String lblRadioTitlePrecedingXPath = "//label[@test-id='radio-label-yes']/preceding::h3[@test-id='radio-title']";
        WebElement lblRadioTitlePrecedingEle = webDriver.findElement(By.xpath(lblRadioTitlePrecedingXPath));

        String lblRadioTitleFollowingXPath = "//div[@test-id='checkbox-section']/following::h3[@test-id='radio-title']";
        WebElement lblRadioTitleFollowingEle = webDriver.findElement(By.xpath(lblRadioTitleFollowingXPath));

        String lblRadioTitleChildXPath = "//div[@test-id='radio-container']/child::h3";
        WebElement lblRadioTitleChildXEle = webDriver.findElement(By.xpath(lblRadioTitleChildXPath));

        //Radio button yes
        String rdoYesContainsXPath = "//input[contains(@test-id,'radio-input-yes')]";
        WebElement rdoYesContainsEle = webDriver.findElement(By.xpath(rdoYesContainsXPath));

        String rdoYesStartsWithXPath = "//input[starts-with(@test-id,'radio-input-y')]";
        WebElement rdoYesStartsWithEle = webDriver.findElement(By.xpath(rdoYesStartsWithXPath));

        String rdoYesDescendantXPath = "//div[@test-id='radio-group']/descendant::input[@test-id='radio-input-yes']";
        WebElement rdoYesDescendantEle = rdoYesStartsWithEle.findElement(By.xpath(rdoYesDescendantXPath));

        String rdoYesPrecedingSiblingXPath = "//label[@test-id='radio-label-impressive']/preceding-sibling::label[@test-id='radio-label-yes']";
        WebElement rdoYesPrecedingSiblingEle = webDriver.findElement(By.xpath(rdoYesPrecedingSiblingXPath));

        String rdoYesNormalizeSpaceXPath = "//label[normalize-space()='Yes']";
        WebElement rdoYesNormalizeSpaceEle = webDriver.findElement(By.xpath(rdoYesNormalizeSpaceXPath));

        String rdoYesFollowingXPath = "//h3[@test-id='radio-title']/following::input[@test-id='radio-input-yes']";
        WebElement rdoYesFollowingEle = webDriver.findElement(By.xpath(rdoYesFollowingXPath));

        String rdoYesPrecedingXPath = "//div[@test-id='webtables-section']/preceding::input[@test-id='radio-input-yes']";
        WebElement rdoYesPrecedingEle = webDriver.findElement(By.xpath(rdoYesPrecedingXPath));

        String rdoYesChildXPath = "//div[@test-id='radio-group']/child::label[@test-id='radio-label-yes']";
        WebElement rdoYesChildEle = webDriver.findElement(By.xpath(rdoYesChildXPath));

        //Radio button impressive
        String rdoImpressiveContainsXPath = "//input[contains(@test-id,'radio-input-impressive')]";
        WebElement rdoImpressiveContainsEle = webDriver.findElement(By.xpath(rdoImpressiveContainsXPath));

        String rdoImpressiveStartsWithXPath = "//input[starts-with(@test-id,'radio-input-i')]";
        WebElement rdoImpressiveStartsWithEle = webDriver.findElement(By.xpath(rdoImpressiveStartsWithXPath));

        String rdoImpressiveDescendantXPath = "//div[@test-id='radio-container']/descendant::input[@test-id='radio-input-impressive']";
        WebElement rdoImpressiveDescendantEle = webDriver.findElement(By.xpath(rdoImpressiveDescendantXPath));

        String rdoImpressivePrecedingSiblingXPath = "//label[@test-id='radio-label-no']/preceding-sibling::label[@test-id='radio-label-impressive']";
        WebElement rdoImpressivePrecedingSiblingEle = webDriver.findElement(By.xpath(rdoImpressivePrecedingSiblingXPath));

        String rdoImpressiveFollowingSiblingXPath = "//label[@test-id='radio-label-yes']/following-sibling::label[@test-id='radio-label-impressive']";
        WebElement rdoImpressiveFollowingSiblingEle = webDriver.findElement(By.xpath(rdoImpressiveFollowingSiblingXPath));

        String rdoImpressiveNormalizeSpaceXPath = "//label[normalize-space()='Impressive']";
        WebElement rdoImpressiveNormalizeSpaceEle = webDriver.findElement(By.xpath(rdoImpressiveNormalizeSpaceXPath));

        String rdoImpressiveFollowingXPath = "//h3[@test-id='radio-title']/following::input[@test-id='radio-input-impressive']";
        WebElement rdoImpressiveFollowingEle = webDriver.findElement(By.xpath(rdoImpressiveFollowingXPath));

        String rdoImpressivePrecedingXPath = "//div[@test-id='webtables-section']/preceding::input[@test-id='radio-input-impressive']";
        WebElement rdoImpressivePrecedingEle = webDriver.findElement(By.xpath(rdoImpressivePrecedingXPath));

        String rdoImpressiveChildXPath = "//div[@test-id='radio-group']/child::label[@test-id='radio-label-impressive']";
        WebElement rdoImpressiveChildEle = webDriver.findElement(By.xpath(rdoImpressiveChildXPath));

        //Radio button no
        String rdoNoContainsXPath = "//input[contains(@test-id,'radio-input-no')]";
        WebElement rdoNoContainsEle = webDriver.findElement(By.xpath(rdoNoContainsXPath));

        String rdoNoStartsWithXPath = "//input[starts-with(@test-id,'radio-input-n')]";
        WebElement rdoNoStartsWithEle = webDriver.findElement(By.xpath(rdoNoStartsWithXPath));

        String rdoNoNormalizeSpaceXPath = "//label[normalize-space()='No']";
        WebElement rdoNoNormalizeSpace = webDriver.findElement(By.xpath(rdoNoNormalizeSpaceXPath));

        String rdoNoChildXPath = "//div[@test-id='radio-group']/child::label[@test-id='radio-label-no']";
        WebElement rdoNoChildEle = webDriver.findElement(By.xpath(rdoNoChildXPath));
    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly

        //Button title
        String lblButtonTitleContainsCSS = "h3[test-id*='buttons-title']";
        WebElement lblButtonTitleContainsEle = webDriver.findElement(By.cssSelector(lblButtonTitleContainsCSS));

        String lblButtonTitleStartsWithCSS = "h3[test-id^='buttons-t']";
        WebElement lblButtonTitleStartsWithEle = webDriver.findElement(By.cssSelector(lblButtonTitleStartsWithCSS));

        //Button click me
        String btnClickMeContainsCSS = "button[test-id*='button-click-me']";
        WebElement btnClickMeContainsEle = webDriver.findElement(By.cssSelector(btnClickMeContainsCSS));

        String btnClickMeStartsWithCSS = "button[test-id^='button-cli']";
        WebElement btnClickMeStartsWithEle = webDriver.findElement(By.cssSelector(btnClickMeStartsWithCSS));

        //Button confirm me
        String btnConfirmMeContainsCSS = "button[test-id*='button-confirm-me']";
        WebElement btnConfirmMeContainsEle = webDriver.findElement(By.cssSelector(btnConfirmMeContainsCSS));

        String btnConfirmMeStartsWithCSS = "button[test-id^='button-conf']";
        WebElement btnConfirmMeStartsWithEle = webDriver.findElement(By.cssSelector(btnConfirmMeStartsWithCSS));

        //Button prompt me
        String btnPromptMeContainsCSS = "button[test-id*='button-prompt-me']";
        WebElement btnPromptMeContainsEle = webDriver.findElement(By.cssSelector(btnPromptMeContainsCSS));

        String btnPromptMeStartsWithCSS = "button[test-id^='button-p']";
        WebElement btnPromptMeStartsWithEle = webDriver.findElement(By.cssSelector(btnPromptMeStartsWithCSS));

        //Button different actions title
        String lblButtonDifferentActionsTitleContainsCSS = "h3[test-id*='actions-title']";
        WebElement lblButtonDifferentActionsTitleContainsEle = webDriver.findElement(By.cssSelector(lblButtonDifferentActionsTitleContainsCSS));

        String lblButtonDifferentActionsTitleStartsWithCSS = "h3[test-id^='buttons-d']";
        WebElement lblButtonDifferentActionsTitleStartsWithEle = webDriver.findElement(By.cssSelector(lblButtonDifferentActionsTitleStartsWithCSS));

        //Button 1
        String btn1ContainsCSS = "button[test-id*='button1']";
        WebElement  btn1ContainsEle = webDriver.findElement(By.cssSelector(btn1ContainsCSS));

        String btn1StartsWithCSS = "button[test-id*='button1']";
        WebElement btn1StartWithEle = webDriver.findElement(By.cssSelector(btn1StartsWithCSS));

        //Button 2
        String btn2CSS = "#button1";
        WebElement btn2Ele = webDriver.findElement(By.cssSelector(btn2CSS));

        //Button3
        String btn3CSS = "#button3";
        WebElement btn3Ele = webDriver.findElement(By.cssSelector(btn3CSS));

        //Result
        String lblResultContainsCSS = "p[test-id*='t-text']";
        WebElement lblResultContainsEle = webDriver.findElement(By.cssSelector(lblResultContainsCSS));

        String lblResultStartsWithCSS = "p[test-id^='buttons-r']";
        WebElement lblResultStartsWithEle = webDriver.findElement(By.cssSelector(lblResultStartsWithCSS));

        String lblResultCSS = "#resultText";
        WebElement lblResultEle = webDriver.findElement(By.cssSelector(lblResultCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly

        //Button title
        String lblButtonTitleDescendantXPath = "//div[@test-id='content-root']/descendant::h3[@test-id='buttons-title']";
        WebElement lblButtonTitleEle = webDriver.findElement(By.xpath(lblButtonTitleDescendantXPath));

        String lblButtonTitleTextXPath = "//h3[text()='Buttons']";
        WebElement lblButtonTitleTextEle = webDriver.findElement(By.xpath(lblButtonTitleTextXPath));

        String lblButtonTitlePrecedingSiblingXPath = "//button[@test-id='button-click-me']/preceding-sibling::h3";
        WebElement lblButtonTitlePrecedingSiblingEle = webDriver.findElement(By.xpath(lblButtonTitlePrecedingSiblingXPath));

        String lblButtonTitleChildXPath = "//div[@test-id='buttons-section']/child::h3[@test-id='buttons-title']";
        WebElement lblButtonTitleChildEle = webDriver.findElement(By.xpath(lblButtonTitleChildXPath));

        //Button click me
        String btnClickMeTextXPath = "//button[text()='Click Me']";
        WebElement btnClickMeTextEle = webDriver.findElement(By.xpath(btnClickMeTextXPath));

        String btnClickMePrecedingSiblingXPath = "//button[@test-id='button-confirm-me']/preceding-sibling::button";
        WebElement btnClickMePrecedingSiblingEle = webDriver.findElement(By.xpath(btnClickMePrecedingSiblingXPath));

        String btnClickMeFollowingSiblingXPath = "//h3[@test-id='buttons-title']/following-sibling::button[@test-id='button-click-me']";
        WebElement btnClickMeFollowingSiblingEle = webDriver.findElement(By.xpath(btnClickMeFollowingSiblingXPath));

        String btnClickMePrecedingXPath = "//div[@test-id='links-section']/preceding::button[@test-id='button-click-me']";
        WebElement btnClickMePrecedingEle = webDriver.findElement(By.xpath(btnClickMePrecedingXPath));

        //Button confirm me
        String btnConfirmMeTextXPath = "//button[text()='Confirm Me']";
        WebElement btnConfirmMeTextEle = webDriver.findElement(By.xpath(btnConfirmMeTextXPath));

        String btnConfirmMeFollowingXPath = "//button[@test-id='button-click-me']/following::button[@test-id='button-confirm-me']";
        WebElement btnConfirmMeFollowingEle = webDriver.findElement(By.xpath(btnConfirmMeFollowingXPath));

        //Button Prompt me
        String btnPromptMeTextXPath = "//button[text()='Prompt Me']";
        WebElement btnPromptMeTextEle = webDriver.findElement(By.xpath(btnPromptMeTextXPath));

        String btnPromptMePrecedingSiblingXPath = "//button[@test-id='button1']/preceding-sibling::button[@test-id='button-prompt-me']";
        WebElement btnPromptMePrecedingSiblingEle = webDriver.findElement(By.xpath(btnPromptMePrecedingSiblingXPath));

        //Buttons different actions title
        String lblButtonDifferentActionsTitleNormalizeSpaceXPath = "//h3[text()='Buttons with Different Actions (Click, Right-Click, Double-Click)://h3[normalize-space()='Buttons with Different Actions (Click, Right-Click, Double-Click):']";
        WebElement lblButtonDifferentActionsTitleNormalizeSpaceEle = webDriver.findElement(By.xpath(lblButtonDifferentActionsTitleNormalizeSpaceXPath));

        String lblButtonDifferentActionsTitleChildXpath = "//div[@test-id='buttons-section']/h3[@test-id='buttons-different-actions-title']";
        WebElement lblButtonDifferentActionsTitleChildEle = webDriver.findElement(By.xpath(lblButtonDifferentActionsTitleChildXpath));

        //Button 1
        String btn1TextXPath = "//button[text()='Button 1']";
        WebElement btn1TextEle = webDriver.findElement(By.xpath(btn1TextXPath));

        String btn1PrecedingSiblingXPath = "//button[@test-id='button2']/preceding-sibling::button[@test-id='button1']";
        WebElement btn1PrecedingSiblingEle = webDriver.findElement(By.xpath(btn1PrecedingSiblingXPath));

        //Button 2
        String btn2TextXPath = "//button[text()='Button 2']";
        WebElement btn2TextEle = webDriver.findElement(By.xpath(btn2TextXPath));

        String btn2FollowingSiblingXPath = "//button[@test-id='button1']/following-sibling::button[@test-id='button2']";
        WebElement btn2FollowingSibling = webDriver.findElement(By.xpath(btn2FollowingSiblingXPath));

        //Button 3
        String btn3TextXPath = "//button[text()='Button 3']";
        WebElement btn3TextEle = webDriver.findElement(By.xpath(btn3TextXPath));

        String btn3FollowingXPath = "//div[@test-id='radio-section']/following::button[@test-id='button3']";
        WebElement btn3FollowingEle = webDriver.findElement(By.xpath(btn3FollowingXPath));

        //Interaction result
        String lblResultTextXPath = "p[text()='Hãy nhấn vào một nút để kiểm tra sự kiện.']";
        WebElement lblResultTextEle = webDriver.findElement(By.xpath(lblResultTextXPath));

        String lblResultDescendantXPath = "//div[@test-id='buttons-section']/descendant::p";
        WebElement lblResultDescendantEle = webDriver.findElement(By.xpath(lblResultDescendantXPath));

    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly

        //Dynamic properties title
        String lblDynamicPropertiesTitleContainsCSS = "h3[test-id*='ies-title']";
        WebElement lblDynamicPropertiesTitleContainsEle = webDriver.findElement(By.cssSelector(lblDynamicPropertiesTitleContainsCSS));

        String lblDynamicPropertiesTitleStartsWithCSS = "h3[test-id^='dynamic-properties']";
        WebElement blDynamicPropertiesTitleStartsWithEle = webDriver.findElement(By.cssSelector(lblDynamicPropertiesTitleStartsWithCSS));

        String lblDynamicPropertiesTitleCSS = "#dynamic-properties-title";
        WebElement lblDynamicPropertiesTitleEle = webDriver.findElement(By.cssSelector(lblDynamicPropertiesTitleCSS));

        //Change color button
        String btnChangeColorContainsCSS = "button[test-id*='change-color-button']";
        WebElement btnChangeColorContainsEle = webDriver.findElement(By.cssSelector(btnChangeColorContainsCSS));

        String btnChangeColorStartsWithCSS = "button[test-id^='change']";
        WebElement btnChangeColorStartsWithEle = webDriver.findElement(By.cssSelector(btnChangeColorStartsWithCSS));

        String btnChangeColorCSS = "#change-color-button";
        WebElement btnChangeColorEle = webDriver.findElement(By.cssSelector(btnChangeColorCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly

        //Dynamic properties title
        String lblDynamicPropertiesTitleContainsXPath = "//h3[contains(@test-id,'dynamic-properties-title')]";
        WebElement lblDynamicPropertiesTitleContainsEle = webDriver.findElement(By.xpath(lblDynamicPropertiesTitleContainsXPath));

        String lblDynamicPropertiesTitleStartsWithXPath = "//h3[starts-with(@test-id,'dynamic-pro')]";
        WebElement lblDynamicPropertiesTitleStartsWithEle = webDriver.findElement(By.xpath(lblDynamicPropertiesTitleStartsWithXPath));

        String lblDynamicPropertiesTitleTextXPath = "//h3[text()='Dynamic Properties']";
        WebElement lblDynamicPropertiesTitleTextEle = webDriver.findElement(By.xpath(lblDynamicPropertiesTitleTextXPath));

        String lblDynamicPropertiesTitleDescendantXPath = "//div[@test-id='content-root']/descendant::h3[@test-id='dynamic-properties-title']";
        WebElement lblDynamicPropertiesTitleDescendantEle = webDriver.findElement(By.xpath(lblDynamicPropertiesTitleDescendantXPath));

        String lblDynamicPropertiesTitlePrecedingSiblingXPath = "//button[@test-id='change-color-button']/preceding-sibling::h3";
        WebElement lblDynamicPropertiesTitlePrecedingSiblingEle = webDriver.findElement(By.xpath(lblDynamicPropertiesTitlePrecedingSiblingXPath));

        String lblDynamicPropertiesTitleFollowingXPath = "//div[@test-id='buttons-section']/following::h3[@test-id='dynamic-properties-title']";
        WebElement lblDynamicPropertiesTitleFollowingEle = webDriver.findElement(By.xpath(lblDynamicPropertiesTitleFollowingXPath));

        String lblDynamicPropertiesTitlePrecedingXPath = "//div[@test-id='browser-windows-section']/preceding::h3[@test-id='dynamic-properties-title']";
        WebElement lblDynamicPropertiesTitlePrecedingEle = webDriver.findElement(By.xpath(lblDynamicPropertiesTitlePrecedingXPath));

        String lblDynamicPropertiesTitleChildXPath = "//div[@test-id='dynamic-section']/child::h3";
        WebElement lblDynamicPropertiesTitleChildEle = webDriver.findElement(By.xpath(lblDynamicPropertiesTitleChildXPath));

        //Change color button
        String btnChangeColorContainsXPath = "//button[contains(@test-id,'color-button')]";
        WebElement btnChangeColorContainsEle = webDriver.findElement(By.xpath(btnChangeColorContainsXPath));

        String btnChangeColorStartsWithXPath = "//button[starts-with(@test-id,'change')]";
        WebElement btnChangeColorStartsWithEle = webDriver.findElement(By.xpath(btnChangeColorStartsWithXPath));

        String btnChangeColorTextXPath = "//button[text()='Click to Change Color']";
        WebElement btnChangeColorTextEle = webDriver.findElement(By.xpath(btnChangeColorTextXPath));

        String btnChangeColorDescendantXPath = "//div[@test-id='content-root']/descendant::button[@test-id='change-color-button']";
        WebElement btnChangeColorDescendant = webDriver.findElement(By.xpath(btnChangeColorDescendantXPath));

        String btnChangeColorFollowingSiblingXPath = "//h3[@test-id='dynamic-properties-title']/following-sibling::button";
        WebElement btnChangeColorFollowingSiblingEle = webDriver.findElement(By.xpath(btnChangeColorFollowingSiblingXPath));

        String btnChangeColorFollowingXPath = "//div[@test-id='checkbox-section']/following::button[@test-id='change-color-button']";
        WebElement btnChangeColorFollowingEle = webDriver.findElement(By.xpath(btnChangeColorFollowingXPath));

        String  btnChangeColorPrecedingXPath = "//div[@test-id='frame-section']/preceding::button[@test-id='change-color-button']";
        WebElement btnChangeColorPrecedingEle = webDriver.findElement(By.xpath(btnChangeColorPrecedingXPath));

        String btnChangeColorChildXPath = "//div[@test-id='dynamic-section']/child::button";
        WebElement btnChangeColorChildEle = webDriver.findElement(By.xpath(btnChangeColorChildXPath));

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
