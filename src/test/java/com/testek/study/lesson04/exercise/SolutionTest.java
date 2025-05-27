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

        // Nhập thông tin người dùng:
        String lblTitleContainsCSS = "h3[test-id*= 'form-title']";
        webDriver.findElement(By.cssSelector(lblTitleContainsCSS));
        String lblTitleStartCSS = "h3[test-id^= 'textbox-form-t']";
        webDriver.findElement(By.cssSelector(lblTitleStartCSS));

        // Họ và tên (label and textbox)
        String lblNameContainsCSS = "label[test-id*= 'label-name']";
        webDriver.findElement(By.cssSelector(lblNameContainsCSS));
        String lblNameStartCSS = "label[test-id^= 'textbox-form-label-na']";
        webDriver.findElement(By.cssSelector(lblNameStartCSS));

        String txtNameId = "name";
        webDriver.findElement(By.id(txtNameId));
        String txtNameContainsCSS = "input[placeholder*= 'họ tên']";
        webDriver.findElement(By.cssSelector(txtNameContainsCSS));
        String txtNameStartCSS = "input[title^= 'Nhập họ tên']";
        webDriver.findElement(By.cssSelector(txtNameStartCSS));

        // Email (label and textbox)
        String lblEmailContainsCSS = "label[test-id*= 'label-email']";
        webDriver.findElement(By.cssSelector(lblEmailContainsCSS));
        String lblEmailStartCSS = "label[test-id^= 'textbox-form-label-em']";
        webDriver.findElement(By.cssSelector(lblEmailStartCSS));

        String txtEmailId = "email";
        webDriver.findElement(By.id(txtEmailId));
        String txtEmailContainsCSS = "input[placeholder*= 'email']";
        webDriver.findElement(By.cssSelector(txtEmailContainsCSS));
        String txtEmailStartCSS = "input[placeholder^= 'Nhập ema']";
        webDriver.findElement(By.cssSelector(txtEmailStartCSS));

        // Số điện thoại (label and textbox)
        String lblPhoneContainsCSS = "label[test-id*= 'label-phone']";
        webDriver.findElement(By.cssSelector(lblPhoneContainsCSS));
        String lblPhoneStartCSS = "label[test-id^= 'textbox-form-label-ph']";
        webDriver.findElement(By.cssSelector(lblPhoneStartCSS));

        String txtPhoneId = "phone";
        webDriver.findElement(By.id(txtPhoneId));
        String txtPhoneContainsCSS = "input[placeholder*= 'số điện thoại']";
        webDriver.findElement(By.cssSelector(txtPhoneContainsCSS));
        String txtPhoneStartCSS = "input[placeholder^= 'Nhập số điện']";
        webDriver.findElement(By.cssSelector(txtPhoneStartCSS));

        // Địa chỉ (label and textbox)
        String lblAddressContainsCSS = "label[test-id*= 'label-address']";
        webDriver.findElement(By.cssSelector(lblAddressContainsCSS));
        String lblAddressStartCSS = "label[test-id^= 'textbox-form-label-add']";
        webDriver.findElement(By.cssSelector(lblAddressStartCSS));

        String txtAddressId = "address";
        webDriver.findElement(By.id(txtAddressId));
        String txtAddressContainsCSS = "input[placeholder*= 'địa chỉ']";
        webDriver.findElement(By.cssSelector(txtAddressContainsCSS));
        String txtAddressStartCSS = "input[placeholder^= 'Nhập địa']";
        webDriver.findElement(By.cssSelector(txtAddressStartCSS));

        // Gui thong tin button
        String btnSubmitContainsCSS = "button[test-id*= 'form-submit']";
        webDriver.findElement(By.cssSelector(btnSubmitContainsCSS));
        String btnSubmitStartCSS = "button[test-id^= 'textbox-form-sub']";
        webDriver.findElement(By.cssSelector(btnSubmitStartCSS));

        // Clear button
        String btnResetContainsCSS = "button[test-id*= 'form-reset']";
        webDriver.findElement(By.cssSelector(btnResetContainsCSS));
        String btnResetStartCSS = "button[test-id^= 'textbox-form-re']";
        webDriver.findElement(By.cssSelector(btnResetStartCSS));

        // Thông tin bạn đã nhập (label and textbox)
        String lblOutputInfoContainsCSS = "h3[test-id*='output-title']";
        webDriver.findElement(By.cssSelector(lblOutputInfoContainsCSS));
        String lblOutputInfoStartCSS = "h3[test-id^='textbox-form-output']";
        webDriver.findElement(By.cssSelector(lblOutputInfoContainsCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // Handle other elements similarly

        // Nhập thông tin người dùng:
        String lblTitleContainsXpath = "//h3[contains(@test-id,'form-title')]";
        webDriver.findElement(By.xpath(lblTitleContainsXpath));
        String lblTitleStartXPath = "//h3[starts-with(@test-id,'textbox-form-t')]";
        webDriver.findElement(By.xpath(lblTitleStartXPath));

        // Họ và tên (label and textbox)
        String lblNameTextXPath = "//label[text()= 'Họ và tên:']";
        webDriver.findElement(By.xpath(lblNameTextXPath));
        String lblNameNormalXPath = "//label[normalize-space()= 'Họ và tên:']";
        webDriver.findElement(By.xpath(lblNameNormalXPath));

        String txtNameFolSibXPath = "//label[@test-id = 'textbox-form-label-name']/following-sibling::input[@placeholder='Nhập họ tên']";
        webDriver.findElement(By.xpath(txtNameFolSibXPath));
        String txtNameDesXPath = "//div[@test-id = 'textbox-form-container']/descendant::input[@placeholder='Nhập họ tên']";
        webDriver.findElement(By.xpath(txtNameDesXPath));

        // Email (label and textbox)
        String lblEmailPreSibXPath = "//label[@test-id = 'textbox-form-label-phone']/preceding-sibling::label[@test-id = 'textbox-form-label-email']";
        webDriver.findElement(By.xpath(lblEmailPreSibXPath));
        String lblEmailFolXPath = "//label[@test-id = 'textbox-form-label-name']/following::label[@test-id = 'textbox-form-label-email']";
        webDriver.findElement(By.xpath(lblEmailFolXPath));

        String txtEmailFolXPath = "//label[@test-id = 'textbox-form-label-email']/following::input[@test-id = 'textbox-form-input-email']";
        webDriver.findElement(By.xpath(txtEmailFolXPath));
        String txtEmailPreXPath = "//input[@test-id = 'textbox-form-input-phone']/preceding::input[@test-id = 'textbox-form-input-email']";
        webDriver.findElement(By.xpath(txtEmailPreXPath));

        // Số điện thoại (label and textbox)
        String lblPhoneContainsXPath = "//label[contains(@test-id, 'textbox-form-label-phone')]";
        webDriver.findElement(By.xpath(lblPhoneContainsXPath));
        String lblPhoneTextXPath = "//label[text() = 'Số điện thoại:']";
        webDriver.findElement(By.xpath(lblPhoneTextXPath));

        String txtPhoneStartXPath = "//input[starts-with(@test-id, 'textbox-form-input-ph')]";
        webDriver.findElement(By.xpath(txtPhoneStartXPath));
        String txtPhoneFolSibXPath = "//label[@test-id = 'textbox-form-label-phone']//following-sibling::input[starts-with(@test-id, 'textbox-form-input-ph')]";
        webDriver.findElement(By.xpath(txtPhoneFolSibXPath));

        // Địa chỉ (label and textbox)
        String lblAddressPreXPath = "//input[@test-id = 'textbox-form-input-address']/preceding::label[@test-id = 'textbox-form-label-address']";
        webDriver.findElement(By.xpath(lblAddressPreXPath));
        String lblAddressFolSibXPath = "//label[@test-id = 'textbox-form-label-phone']/following-sibling::label[@test-id = 'textbox-form-label-address']";
        webDriver.findElement(By.xpath(lblAddressFolSibXPath));

        String txtAddressPreSibXPath = "//button[@test-id = 'textbox-form-submit']/preceding-sibling::input[@test-id = 'textbox-form-input-address']";
        webDriver.findElement(By.xpath(txtAddressPreSibXPath));
        String txtAddressDesXPath = "//form[@test-id = 'textbox-form']/descendant::input[@test-id = 'textbox-form-input-address']";
        webDriver.findElement(By.xpath(txtAddressDesXPath));

        // Gui thong tin button
        String btnSubmitPreXPath = "//button[text() = 'Clear']/preceding::button[@test-id = 'textbox-form-submit']";
        webDriver.findElement(By.xpath(btnSubmitPreXPath));
        String btnSubmitFolXPath = "//label[text() = 'Địa chỉ:']/following::button[@test-id = 'textbox-form-submit']";
        webDriver.findElement(By.xpath(btnSubmitFolXPath));

        // Clear button
        String btnResetContainsXPath = "//button[contains(@test-id, 'textbox-form-reset')]";
        webDriver.findElement(By.xpath(btnResetContainsXPath));
        String btnResetStartXPath = "//button[starts-with(@test-id, 'textbox-form-re')]";
        webDriver.findElement(By.xpath(btnResetStartXPath));

        // Thông tin bạn đã nhập (label and textbox)
        String lblOutputInfoFolXPath = "//button[@test-id = 'textbox-form-reset']/following::h3";
        webDriver.findElement(By.xpath(lblOutputInfoFolXPath));
        String lblOutputInfoDesXPath = "//div[@class = 'form-container']/descendant::h3[@test-id = 'textbox-form-output-title']";
        webDriver.findElement(By.xpath(lblOutputInfoDesXPath));


    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly

        // Do you like the site?
        String lblTitleContainsCSS = "h3[test-id*= 'radio-tit']";
        webDriver.findElement(By.cssSelector(lblTitleContainsCSS));
        String lblTitleStartCSS = "h3[test-id^= 'radio']";
        webDriver.findElement(By.cssSelector(lblTitleStartCSS));

        // Yes
        String rdoYesContainCSS = "input[test-id*= 'yes']";
        webDriver.findElement(By.cssSelector(rdoYesContainCSS));
        String rdoYesStartCSS = "input[test-id^= 'radio-input-y']";
        webDriver.findElement(By.cssSelector(rdoYesStartCSS));

        // Impressive
        String rdoImpressiveContainCSS = "input[test-id*='impressive']";
        webDriver.findElement(By.cssSelector(rdoImpressiveContainCSS));
        String rdoImpressiveStartCSS = "input[test-id^= 'radio-input-imp']";
        webDriver.findElement(By.cssSelector(rdoImpressiveStartCSS));

        // No
        String rdoNoContainCSS = "input[test-id*= 'no']";
        webDriver.findElement(By.cssSelector(rdoNoContainCSS));
        String rdoNoStartCSS = "input[test-id^= 'radio-input-n']";
        webDriver.findElement(By.cssSelector(rdoNoStartCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        // Do you like the site?
        String lblTitleContainsXPath = "//h3[contains(@test-id, 'radio-title')]";
        webDriver.findElement(By.xpath(lblTitleContainsXPath));
        String lblTitleStartXPath = "//h3[starts-with(@test-id, 'radio')]";
        webDriver.findElement(By.xpath(lblTitleStartXPath));

        // Yes
        String rdoYesDesXPath = "//div[@test-id ='radio-container']/descendant::input[@test-id = 'radio-input-yes']";
        webDriver.findElement(By.xpath(rdoYesDesXPath));
        String rdoYesPreXPath = "//input[@value ='Impressive']/preceding::input[@test-id = 'radio-input-yes']";
        webDriver.findElement(By.xpath(rdoYesPreXPath));

        // Impressive
        String rdoImpressiveFolXPath = "//input[@value ='Yes']/following::input[@test-id = 'radio-input-impressive']";
        webDriver.findElement(By.xpath(rdoImpressiveFolXPath));
        String rdoImpressivePreXPath = "//input[@value ='No']/preceding::input[@test-id = 'radio-input-impressive']";
        webDriver.findElement(By.xpath(rdoImpressivePreXPath));

        // No
        String rdoNoContainXPath = "//input[contains(@test-id, 'no')]";
        webDriver.findElement(By.xpath(rdoNoContainXPath));
        String rdoNoStartXPath = "//input[starts-with(@test-id, 'radio-input-n')]";
        webDriver.findElement(By.xpath(rdoNoStartXPath));

    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly

        // Click me button
        String btnClickContainsCSS = "button[test-id*='click-me']";
        webDriver.findElement(By.cssSelector(btnClickContainsCSS));
        String btnClickStartCSS = "button[test-id^='button-click']";
        webDriver.findElement(By.cssSelector(btnClickStartCSS));

        // Confirm me button
        String btnConfirmContainsCSS = "button[test-id*='confirm-me']";
        webDriver.findElement(By.cssSelector(btnConfirmContainsCSS));
        String btnConfirmStartCSS = "button[test-id^='button-confirm']";
        webDriver.findElement(By.cssSelector(btnConfirmStartCSS));

        // Prompt me button
        String btnPromptContainsCSS = "button[test-id*='prompt-me']";
        webDriver.findElement(By.cssSelector(btnPromptContainsCSS));
        String btnPromptStartCSS = "button[test-id^='button-prompt']";
        webDriver.findElement(By.cssSelector(btnPromptStartCSS));

        // Button 1
        String btnButton1ContainsCSS = "button[test-id*='1']";
        webDriver.findElement(By.cssSelector(btnButton1ContainsCSS));
        String btnButton1StartCSS = "button[test-id^='button1']";
        webDriver.findElement(By.cssSelector(btnButton1StartCSS));

        // Button 2
        String btnButton2ContainsCSS = "button[test-id*='2']";
        webDriver.findElement(By.cssSelector(btnButton2ContainsCSS));
        String btnButton2StartCSS = "button[test-id^='button2']";
        webDriver.findElement(By.cssSelector(btnButton2StartCSS));

        // Button 3
        String btnButton3ContainsCSS = "button[test-id*='3']";
        webDriver.findElement(By.cssSelector(btnButton3ContainsCSS));
        String btnButton3StartCSS = "button[test-id^='button3']";
        webDriver.findElement(By.cssSelector(btnButton3StartCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly

        // Click me button
        String btnClickContainsXPath = "//button[contains(@test-id, 'click-me')]";
        webDriver.findElement(By.xpath(btnClickContainsXPath));
        String btnClickStartXPath = "//button[starts-with(@test-id, 'button-click')]";
        webDriver.findElement(By.xpath(btnClickStartXPath));

        // Confirm me button
        String btnConfirmDesXPath = "//div[@test-id='buttons-section']/descendant::button[@test-id = 'button-confirm-me']";
        webDriver.findElement(By.xpath(btnConfirmDesXPath));
        String btnConfirmTextXPath = "//button[text() = 'Confirm Me']";
        webDriver.findElement(By.xpath(btnConfirmTextXPath));

        // Prompt me button
        String btnPromptNormalXPath = "//button[normalize-space() = 'Prompt Me']";
        webDriver.findElement(By.xpath(btnPromptNormalXPath));
        String btnPromptFolXPath = "//button[@test-id = 'button-confirm-me']/following::button[@test-id = 'button-prompt-me']";
        webDriver.findElement(By.xpath(btnPromptFolXPath));

        // Button 1
        String btnButton1ContainsXPath = "//button[contains(@test-id,'1')]";
        webDriver.findElement(By.xpath(btnButton1ContainsXPath));
        String btnButton1StartXPath = "//button[starts-with(@test-id,'button1')]";
        webDriver.findElement(By.xpath(btnButton1StartXPath));

        // Button 2
        String btnButton2PreSibXPath = "//button[@test-id = 'button3']/preceding-sibling::button[@test-id = 'button2']";
        webDriver.findElement(By.xpath(btnButton2PreSibXPath));
        String btnButton2FolSibXPath = "//button[@test-id = 'button1']/following-sibling::button[@test-id = 'button2']";
        webDriver.findElement(By.xpath(btnButton2FolSibXPath));

        // Button 3
        String btnButton3TextXPath = "//button[text() = 'Button 3']";
        webDriver.findElement(By.xpath(btnButton3TextXPath));
        String btnButton3FolXPath = "//button[@test-id = 'button1']/following::button[@test-id = 'button3']";
        webDriver.findElement(By.xpath(btnButton3FolXPath));

    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly

        // Dynamic Properties
        String lblDynamicId = "dynamic-properties-title";
        webDriver.findElement(By.id(lblDynamicId));
        String lblDynamicContainsCSS = "h3[test-id*= 'dynamic']";
        webDriver.findElement(By.cssSelector(lblDynamicContainsCSS));
        String lblDynamicStartCSS = "h3[test-id^= 'dynamic']";
        webDriver.findElement(By.cssSelector(lblDynamicStartCSS));

        // Click to Change Color button
        String btnChangeId = "change-color-button";
        webDriver.findElement(By.id(btnChangeId));
        String btnChangeContainsCSS = "button[test-id*= 'change']";
        webDriver.findElement(By.cssSelector(btnChangeContainsCSS));
        String btnChangeStartCSS = "button[test-id^= 'change']";
        webDriver.findElement(By.cssSelector(btnChangeStartCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly

        // Dynamic Properties
        String lblDynamicContainsXPath = "//h3[contains(@test-id, 'dynamic')]";
        webDriver.findElement(By.xpath(lblDynamicContainsXPath));
        String lblDynamicStartXPath = "//h3[starts-with(@test-id, 'dynamic')]";
        webDriver.findElement(By.xpath(lblDynamicStartXPath));

        // Click to Change Color button
        String btnChangeFolXPath = "//h3[@test-id ='dynamic-properties-title']/following::button[@test-id = 'change-color-button']";
        webDriver.findElement(By.xpath(btnChangeFolXPath));
        String btnChangeTextXPath = "//button[text() = 'Click to Change Color']";
        webDriver.findElement(By.xpath(btnChangeTextXPath));

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
