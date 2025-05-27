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
        //div[test-id^='submenu-textbox']
        String txtStartsWithCSS = "div[test-id^='submenu-textbox']";
        WebElement txtStartsWithEle = webDriver.findElement(By.cssSelector(txtStartsWithCSS));
        //div[test-id *= '-textbox']
        String txtContainsCSS = "div[test-id *= '-textbox']";
        WebElement txtContainsEle = webDriver.findElement(By.cssSelector(txtContainsCSS));
        //Nhập thông tin người dùng:
        //h3[test-id*='-form-title']
        String lblTitleContainsCSS = "h3[test-id*='-form-title']";
        WebElement lblTitleContainsEle = webDriver.findElement(By.cssSelector(lblTitleContainsCSS));
        //h3[test-id^='textbox-f']
        String lblTitleStartsWithCSS = "h3[test-id^='textbox-f']";
        WebElement lblTitleStartsEle = webDriver.findElement(By.cssSelector(lblTitleStartsWithCSS));

        //Họ và tên:
        //label[test-id*='-label-name']
        String lblFullNameContainsCSS = "label[test-id*='-label-name']";
        WebElement lblFullNameContainsEle = webDriver.findElement(By.cssSelector(lblFullNameContainsCSS));
        //label[test-id^='textbox-form-label-n']
        String lblFullNameStartsWithCSS = "label[test-id^='textbox-form-label-n']";
        WebElement lblNameStartEle = webDriver.findElement(By.cssSelector(lblFullNameStartsWithCSS));
        //Textbox (Nhập họ tên):
        //input[placeholder*='Nhập họ t']
        String lblFullNamePlaceholderContainsCSS = "input[placeholder*='Nhập họ t']";
        WebElement lblNamePlaceholderContainsEle = webDriver.findElement(By.cssSelector(lblFullNamePlaceholderContainsCSS));
        //input[placeholder^='Nhập họ tê']
        String lblPlaceholderStartsWithCSS = "input[placeholder^='Nhập họ tê']";
        WebElement lblNamePlaceholderStartsEle = webDriver.findElement(By.cssSelector(lblPlaceholderStartsWithCSS));

        //Email:
        //label[test-id*='-label-e']
        String lblEmailContainsCSS = "label[test-id*='-label-e']";
        WebElement lblEmailContainsEle = webDriver.findElement(By.cssSelector(lblEmailContainsCSS));
        //label[test-id^='textbox-form-label-e']
        String lblEmailStartsWithCSS = "label[test-id^='textbox-form-label-e']";
        WebElement lblEmailStartsEle = webDriver.findElement(By.cssSelector(lblEmailStartsWithCSS));
        //Textbox (Nhập email):
        //input[test-id*='-input-email']
        String lblEmailPlaceholderContainsCSS = "input[test-id*='-input-email']";
        WebElement lblEmailPlaceholderContainsEle = webDriver.findElement(By.cssSelector(lblEmailPlaceholderContainsCSS));
        //input[test-id^='textbox-form-input-e']
        String lblEmailPlaceholderStartsWithCSS = "input[test-id^='textbox-form-input-e']";
        WebElement lblEmailPlaceholderStartsEle = webDriver.findElement(By.cssSelector(lblEmailPlaceholderStartsWithCSS));

        //Số điện thoại
        //label[test-id*='-label-phone']
        String lblPhoneNumberContainsCSS = "label[test-id*='-label-phone']";
        WebElement lblPhoneNumberContainsEle = webDriver.findElement(By.cssSelector(lblPhoneNumberContainsCSS));
        //label[test-id^='textbox-form-label-p']
        String lblPhoneNumberStartsWithCSS = "label[test-id^='textbox-form-label-p']";
        WebElement lblPhoneNumberStartsEle = webDriver.findElement(By.cssSelector(lblPhoneNumberStartsWithCSS));
        //Textbox(Nhập số điện thoại)
        //input[test-id*='-input-ph']
        String lblPhoneNumberPlaceholderContainsCSS = "input[test-id*='-input-ph']";
        WebElement lblPhoneNumberPlaceHolderContainsEle = webDriver.findElement(By.cssSelector(lblPhoneNumberPlaceholderContainsCSS));
        //input[test-id^='textbox-form-input-p']
        String lblPhoneNumberPlaceholderStartsWithCSS = "input[test-id^='textbox-form-input-p']";
        WebElement lblPhoneNumberPlaceholderStartsEle = webDriver.findElement(By.cssSelector(lblPhoneNumberPlaceholderStartsWithCSS));

        //Địa chỉ:
        //label[test-id*='-label-ad']
        String lblAddressContainsCSS = "label[test-id*='-label-ad']";
        WebElement lblAddressContainsEle = webDriver.findElement(By.cssSelector(lblAddressContainsCSS));
        //label[test-id^='textbox-form-label-a']
        String lblAddressStartsWithCSS = "label[test-id^='textbox-form-label-a']";
        WebElement lblAddressStartsEle = webDriver.findElement(By.cssSelector(lblAddressStartsWithCSS));
        //Textbox(Nhập địa chỉ)
        //input[test-id*='-input-add']
        String lblAddressPlaceholderContainsCSS = "input[test-id*='-input-add']";
        WebElement lblAddressPlaceholderContainsEle = webDriver.findElement(By.cssSelector(lblAddressPlaceholderContainsCSS));
        //input[test-id^='textbox-form-input-ad']
        String lblAddressPlaceholderStartsWithCSS = "input[test-id^='textbox-form-input-ad']";
        WebElement lblAddressPlaceholderStartsEle = webDriver.findElement(By.cssSelector(lblAddressPlaceholderStartsWithCSS));

        //Button 'Gửi thông tin'
        //button[test-id*='-form-s']
        String btnSendInfoContainsCSS = "button[test-id*='-form-s']";
        WebElement btnSendInfoContainsEle = webDriver.findElement(By.cssSelector(btnSendInfoContainsCSS));
        //button[test-id^='textbox-form-s']
        String btnSendInfoStartsWithCSS = "button[test-id^='textbox-form-s']";
        WebElement btnSendInfoStartsEle = webDriver.findElement(By.cssSelector(btnSendInfoStartsWithCSS));
        //Button 'Clear'
        //button[test-id*='-form-r']
        String btnClearContainsCSS = "button[test-id*='-form-r']";
        WebElement btnClearContainsEle = webDriver.findElement(By.cssSelector(btnClearContainsCSS));
        //button[test-id^='textbox-form-r']
        String btnClearStartsWithCSS = "button[test-id^='textbox-form-r']";
        WebElement btnClearStartsEle = webDriver.findElement(By.cssSelector(btnClearStartsWithCSS));

        //Thông tin bạn đã nhập:
        //h3[test-id*='output-title']
        String lblInfoContainsCSS = "h3[test-id*='output-title']";
        WebElement lblInfoContainsEle = webDriver.findElement(By.cssSelector(lblInfoContainsCSS));
        //h3[test-id^='textbox-form-o']
        String lblInfoStartsWithCSS = "h3[test-id^='textbox-form-o']";
        WebElement lblInfoStartsEle = webDriver.findElement(By.cssSelector(lblInfoStartsWithCSS));

        //Textarea
        //textarea[test-id*='-form-']
        String textareaContainsCSS = "textarea[test-id*='-form-']";
        WebElement textareaContainsEle = webDriver.findElement(By.cssSelector(textareaContainsCSS));
        //textarea[test-id^='textbox-form-o']
        String textareaStartsWithCSS = "textarea[test-id^='textbox-form-o']";
        WebElement textareaStartsEle = webDriver.findElement(By.cssSelector(textareaStartsWithCSS));


    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // Handle other elements similarly
        //div[contains(@test-id, 'submenu-textbox')]
        String txtContainsXPath = "//div[contains(@test-id, 'submenu-textbox')]";
        WebElement txtContainsEle = webDriver.findElement(By.xpath(txtContainsXPath));

        //Nhập thông tin người dùng:
        //h3[normalize-space()='Nhập thông tin người dùng:']
        String lblTitleNormalizeSpaceXPath = "//h3[normalize-space()='Nhập thông tin người dùng:']";
        WebElement lblTitleNormalizeEle = webDriver.findElement(By.xpath(lblTitleNormalizeSpaceXPath));

        //Họ và tên:
        //label[starts-with(@test-id,'textbox-form-label-n')]
        String lblFullNameStartsWithXPath = "//label[starts-with(@test-id,'textbox-form-label-n')]";
        WebElement lblFullNameStartsEle = webDriver.findElement(By.xpath(lblFullNameStartsWithXPath));

        //Textbox (Nhập họ tên):
        //form[@test-id='textbox-form']/child::input[@test-id='textbox-form-input-name']
        String fullNamePlaceholderChildXPath = "//form[@test-id='textbox-form']/child::input[@test-id='textbox-form-input-name']";
        WebElement lblFullNamePlaceholderEle = webDriver.findElement(By.xpath(fullNamePlaceholderChildXPath));

        //Email:
        //input[@type='email' and @placeholder = 'Nhập email']/preceding::label[@test-id='textbox-form-label-email']
        String lblEmailPrecedingXPath = "//input[@type='email' and @placeholder = 'Nhập email']/preceding::label[@test-id='textbox-form-label-email']";
        WebElement lblEmailPrecedingEle = webDriver.findElement(By.xpath(fullNamePlaceholderChildXPath));

        //Textbox (Nhập email):
        //label[contains(@test-id,'-label-e')]/following::input[contains(@test-id,'-input-email')]
        String emailPlaceholderFollowingXPath = "//label[contains(@test-id,'-label-e')]/following::input[contains(@test-id,'-input-email')]";
        WebElement lblEmailPlaceholderFollowingEle = webDriver.findElement(By.xpath(fullNamePlaceholderChildXPath));

        //Số điện thoại
        //input[contains(@test-id,'-input-email')]/following::input[@placeholder='Nhập số điện thoại']
        String lblPhoneNumberFollowingXPath = "//input[contains(@test-id,'-input-email')]/following::input[@placeholder='Nhập số điện thoại']";
        WebElement lblPhoneNumberFollowingEle = webDriver.findElement(By.xpath(fullNamePlaceholderChildXPath));

        //Textbox(Nhập số điện thoại)
        //form[@test-id='textbox-form']/descendant::input[@placeholder='Nhập số điện thoại']
        String lblPhoneNumberPlaceholderDescendantXPath = "//form[@test-id='textbox-form']/descendant::input[@placeholder='Nhập số điện thoại']";
        WebElement lblPhoneNumberPlaceholderEle = webDriver.findElement(By.xpath(fullNamePlaceholderChildXPath));

        //Địa chỉ:
        //form[@test-id='textbox-form']/child::label[contains(@test-id,'-label-add')]
        String lblAddressChildXPath = "//form[@test-id='textbox-form']/child::label[contains(@test-id,'-label-add')]";
        WebElement lblAddressChildEle = webDriver.findElement(By.xpath(fullNamePlaceholderChildXPath));

        //Textbox(Nhập địa chỉ)
        //label[contains(@test-id,'-label-add')]/following-sibling::input[@test-id='textbox-form-input-address']
        String lblAddressPlaceholderFollowingSibXPath = "//label[contains(@test-id,'-label-add')]/following-sibling::input[@test-id='textbox-form-input-address']";
        WebElement lblAddressChildPlaceholderEle = webDriver.findElement(By.xpath(fullNamePlaceholderChildXPath));

        //Button 'Gửi thông tin':
        //input[@id='address']/following::button[@test-id='textbox-form-submit']
        String btnSendInfoFollowingXPath = "//input[@id='address']/following::button[@test-id='textbox-form-submit']";
        WebElement btnFollowingEle = webDriver.findElement(By.xpath(btnSendInfoFollowingXPath));
        //Button 'Clear'
        //button[@test-id='textbox-form-submit']/following-sibling::button[@test-id='textbox-form-reset']
        String btnClearFollowingSibXPath = "//button[@test-id='textbox-form-submit']/following-sibling::button[@test-id='textbox-form-reset']";
        WebElement btnClearEle = webDriver.findElement(By.xpath(btnClearFollowingSibXPath));

        //Thông tin bạn đã nhập:
        //textarea[@id='outputText']/preceding-sibling::h3[contains(@test-id,'-output-title')]
        String lblInfoPreSibXPath = "//textarea[@id='outputText']/preceding-sibling::h3[contains(@test-id,'-output-title')]";
        WebElement textareaPreSibEle = webDriver.findElement(By.xpath(lblInfoPreSibXPath));

        //Textarea
        //h3[contains(@test-id,'-output-title')]/following-sibling::textarea[@test-id='textbox-form-output']
        String textareaFollowingSibXPath = "//h3[contains(@test-id,'-output-title')]/following-sibling::textarea[@test-id='textbox-form-output']";
        WebElement textareaFollowingSibEle = webDriver.findElement(By.xpath(textareaFollowingSibXPath));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        //Do you like the site?
        //h3[test-id*='io-title']
        String lblTitleContainsCSS = "h3[test-id*='io-title']";
        WebElement lblTitleContainsEle = webDriver.findElement(By.cssSelector(lblTitleContainsCSS));
        //h3[style^='margin-bo']
        String lblTitleStartsWithCSS = "h3[style^='margin-bo']";
        WebElement lblTitleStartsWithEle = webDriver.findElement(By.cssSelector(lblTitleStartsWithCSS));

        //Yes
        //label[test-id*='-label-y']
        String lblYesContainsCSS = "label[test-id*='-label-y']";
        WebElement lblYesContainsEle = webDriver.findElement(By.cssSelector(lblYesContainsCSS));
        //label[test-id^='radio-label-y']
        String lblYesStartsWithCSS = "label[test-id^='radio-label-y']";
        WebElement lblYesStartsWithEle = webDriver.findElement(By.cssSelector(lblYesStartsWithCSS));
        //Radio btn Yes:
        //input[test-id*='yes']
        String rdoYesContainsCSS = "input[test-id*='yes']";
        WebElement rdoYesContainsEle = webDriver.findElement(By.cssSelector(rdoYesContainsCSS));
        //input[test-id^='radio-input-y']
        String rdoYesStartsWithCSS = "input[test-id^='radio-input-y']";
        WebElement rdoYesStartsWithEle = webDriver.findElement(By.cssSelector(rdoYesStartsWithCSS));

        //Impressive
        //label[test-id*='-label-i']
        String lblImpressiveContainsCSS = "label[test-id*='-label-i']";
        WebElement lblImpressiveContainsEle = webDriver.findElement(By.cssSelector(lblImpressiveContainsCSS));
        //label[test-id^='radio-label-i']
        String lblImpressiveStartsWithCSS = "label[test-id^='radio-label-i']";
        WebElement lblImpressiveStartsWithEle = webDriver.findElement(By.cssSelector(lblImpressiveStartsWithCSS));
        //Radio btn Impressive
        //input[test-id*='-input-i']
        String rdoImpressiveContainsCSS = "input[test-id*='-input-i']";
        WebElement rdoImpressiveContainsEle = webDriver.findElement(By.cssSelector(rdoImpressiveContainsCSS));
        //input[test-id^='radio-input-i']
        String rdoImpressiveStartsWithCSS = "input[test-id^='radio-input-i']";
        WebElement rdoImpressiveStartsWithEle = webDriver.findElement(By.cssSelector(rdoImpressiveStartsWithCSS));

        //No
        //label[test-id*='-label-no']
        String lblNoContainsCSS = "label[test-id*='-label-no']";
        WebElement lblNoContainsEle = webDriver.findElement(By.cssSelector(lblNoContainsCSS));
        //label[test-id^='radio-label-n']
        String lblNoStartsWithCSS = "label[test-id^='radio-label-n']";
        WebElement lblNoStartsWithEle = webDriver.findElement(By.cssSelector(lblNoStartsWithCSS));
        // Radio btn No
        //input[test-id*='-input-no']
        String rdoNoContainsCSS = "input[test-id*='-input-no']";
        WebElement rdoNoContainsEle = webDriver.findElement(By.cssSelector(rdoNoContainsCSS));
        //input[test-id^='radio-input-n']
        String rdoNoStartsWithCSS = "input[test-id^='radio-input-n']";
        WebElement rdoNoStartsWithEle = webDriver.findElement(By.cssSelector(rdoNoStartsWithCSS));


    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        //Do you like the site?
        //div[@test-id='radio-container']/child::h3[@test-id='radio-title']
        String lblTitleChildXPath = "//div[@test-id='radio-container']/child::h3[@test-id='radio-title']";
        WebElement lblTitleChildEle = webDriver.findElement(By.xpath(lblTitleChildXPath));

        //Yes
        //input[@test-id='radio-input-yes']/parent::label[@test-id='radio-label-yes']
        String lblYesParentXPath = "//input[@test-id='radio-input-yes']/parent::label[@test-id='radio-label-yes']";
        WebElement lblYesParentEle = webDriver.findElement(By.xpath(lblYesParentXPath));
        //Radio btn Yes:
        //label[contains(@test-id,'-impressive')]/preceding::input[@test-id='radio-input-yes']
        String rdoYesPrecedingXPath = "//label[contains(@test-id,'-impressive')]/preceding::input[@test-id='radio-input-yes']";
        WebElement rdoYesPreEle = webDriver.findElement(By.xpath(rdoYesPrecedingXPath));

        //Impressive
        //input[@test-id='radio-input-impressive']/parent::label[@test-id='radio-label-impressive']
        String lblImpressiveParentXPath = "//input[@test-id='radio-input-impressive']/parent::label[@test-id='radio-label-impressive']";
        WebElement lblImpressiveParentEle = webDriver.findElement(By.xpath(lblImpressiveParentXPath));
        //Radio btn Impressive
        //label[@test-id='radio-label-impressive']/child::input[@test-id='radio-input-impressive']
        String rdoImpressiveChildXPath = "//label[@test-id='radio-label-impressive']/child::input[@test-id='radio-input-impressive']";
        WebElement lblImpressiveChildEle = webDriver.findElement(By.xpath(rdoImpressiveChildXPath));

        //No
        //label[@test-id='radio-label-impressive']/following::label[contains(@test-id,'-label-n')]
        String lblNoFollowingXPath = "//label[@test-id='radio-label-impressive']/following::label[contains(@test-id,'-label-n')]";
        WebElement lblNoFollowingEle = webDriver.findElement(By.xpath(lblNoFollowingXPath));
        // Radio btn No
        //input[@test-id='radio-input-impressive']/following::input[@test-id='radio-input-no']
        String rdoNoFollowingXPath = "//input[@test-id='radio-input-impressive']/following::input[@test-id='radio-input-no']";
        WebElement rdoNoFollowingEle = webDriver.findElement(By.xpath(rdoNoFollowingXPath));


    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly
        //Buttons
        //h3[test-id*='buttons-t']
        String lblButtonsContainsCSS = "h3[test-id*='buttons-t']";
        WebElement lblButtonsContainsEle = webDriver.findElement(By.cssSelector(lblButtonsContainsCSS));
        //h3[test-id^='buttons-t']
        String lblButtonsStartsWithCSS = "h3[test-id^='buttons-t']";
        WebElement lblButtonStartsWithEle = webDriver.findElement(By.cssSelector(lblButtonsStartsWithCSS));

        //Btn Click me
        //button[onclick*='clicked me']
        String btnClickMeContainsCSS = "button[onclick*='clicked me']";
        WebElement btnClickMeContainsEle = webDriver.findElement(By.cssSelector(btnClickMeContainsCSS));
        //button[onclick^='alert']
        String btnClickMeStartsWithCSS = "button[onclick^='alert']";
        WebElement btnClickMeStartsWithEle = webDriver.findElement(By.cssSelector(btnClickMeStartsWithCSS));

        //Btn Confirm me
        //button[onclick*='sure?']
        String btnConfirmMeContainsCSS = "button[onclick*='sure?']";
        WebElement btnConfirmMeContainsEle = webDriver.findElement(By.cssSelector(btnConfirmMeContainsCSS));
        //button[onclick^='confirm']
        String btnConfirmMeStartsWithCSS = "button[onclick^='confirm']";
        WebElement btnConfirmMeStartsWithEle = webDriver.findElement(By.cssSelector(btnConfirmMeContainsCSS));

        //Btn Prompt me
        //button[onclick*='Enter your']
        String btnPromptMeContainsCSS = "button[onclick*='Enter your']";
        WebElement btnPromptMeContainsEle = webDriver.findElement(By.cssSelector(btnPromptMeContainsCSS));
        //button[onclick^='prompt']
        String btnPromptMeStartsWithCSS = "button[onclick^='prompt']";
        WebElement btnPromptMeStartsWithEle = webDriver.findElement(By.cssSelector(btnPromptMeContainsCSS));

        //Buttons with Different Actions (Click, Right-Click, Double-Click):
        //h3[test-id*='-actions-t']
        String lblDifferentActionsContainsCSS = "h3[test-id*='-actions-t']";
        WebElement lblDiffActionContainsEle = webDriver.findElement(By.cssSelector(lblDifferentActionsContainsCSS));
        //h3[test-id^='buttons-different-a']
        String lblDifferentActionsStartsWithCSS = "h3[test-id^='buttons-different-a']";
        WebElement lblDiffActionStartsWithEle = webDriver.findElement(By.cssSelector(lblDifferentActionsStartsWithCSS));
        //Btn 1
        //button[test-id*='n1']
        String btn1ContainsCSS = "button[test-id*='n1']";
        WebElement btn1ContainsEle = webDriver.findElement(By.cssSelector(btn1ContainsCSS));
        //button[test-id^='button1']
        String btn1StartsWithCSS = "button[test-id^='button1']";
        WebElement btn1StartsWithEle = webDriver.findElement(By.cssSelector(btn1StartsWithCSS));
        //Btn2
        //button[test-id*='n2']
        String btn2ContainsCSS = "button[test-id*='n2']";
        WebElement btn2ContainsEle = webDriver.findElement(By.cssSelector(btn2ContainsCSS));
        //button[test-id^='button2']
        String btn2StartsWithCSS = "button[test-id^='button2']";
        WebElement btn2StartsWithEle = webDriver.findElement(By.cssSelector(btn2StartsWithCSS));
        //Btn3
        //button[test-id*='n3']
        String btn3ContainsCSS = "button[test-id*='n3']";
        WebElement btn3ContainsEle = webDriver.findElement(By.cssSelector(btn3ContainsCSS));
        //button[test-id^='button3']
        String btn3StartsWithCSS = "button[test-id^='button3']";
        WebElement btn3StartsWithEle = webDriver.findElement(By.cssSelector(btn3StartsWithCSS));

        //Hãy nhấn vào một nút để kiểm tra sự kiện.
        //p[test-id*='-result-t']
        String lblPressBtnContainsCSS = "p[test-id*='-result-t']";
        WebElement lblPressBtnContainsEle = webDriver.findElement(By.cssSelector(lblPressBtnContainsCSS));
        //p[test-id^='buttons-re']
        String lblPressBtnStartsWithCSS = "p[test-id^='buttons-re']";
        WebElement lblPressBtnStartsWithEle = webDriver.findElement(By.cssSelector(lblPressBtnStartsWithCSS));


    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly
        //Buttons
        //div[@id='buttons-section']/child::h3[@test-id='buttons-title']
        String lblButtonsChildXPath = "//div[@id='buttons-section']/child::h3[@test-id='buttons-title']";
        WebElement lblButtonsChildEle = webDriver.findElement(By.xpath(lblButtonsChildXPath));

        //Btn Click me
        //h3[@test-id='buttons-title']/following::button[contains(@onclick,'alert(')]
        String btnClickMeFollowingXPath = "//h3[@test-id='buttons-title']/following::button[contains(@onclick,'alert(')]";
        WebElement btnClickMeFollowingEle = webDriver.findElement(By.xpath(btnClickMeFollowingXPath));

        //Btn Confirm me
        //button[contains(@onclick,'alert(')]/following-sibling::button[contains(@onclick,'confirm')]
        String btnConfirmMeFollowingSibXPath = "//button[contains(@onclick,'alert(')]/following-sibling::button[contains(@onclick,'confirm')]";
        WebElement btnConfirmMeFollowingSibEle = webDriver.findElement(By.xpath(btnConfirmMeFollowingSibXPath));

        //Btn Prompt me
        //button[contains(@onclick,'alert(')]/following::button[contains(@onclick,'prompt')]
        String btnPromptMeFollowingXPath = "//button[contains(@onclick,'alert(')]/following::button[contains(@onclick,'prompt')]";
        WebElement btnPromptMeFollowingEle = webDriver.findElement(By.xpath(btnPromptMeFollowingXPath));

        //Buttons with Different Actions (Click, Right-Click, Double-Click):
        //div[@id='buttons-section']/child::h3[@test-id='buttons-different-actions-title']
        String lblDifferentActionsButtonChildXPath = "//div[@id='buttons-section']/child::h3[@test-id='buttons-different-actions-title']";
        WebElement lblDiffActionsChildEle = webDriver.findElement(By.xpath(lblDifferentActionsButtonChildXPath));

        //Btn 1
        //h3[contains(@test-id,'-actions-t')]/following::button[@test-id='button1']
        String btn1FollowingXPath = "//h3[contains(@test-id,'-actions-t')]/following::button[@test-id='button1']";
        WebElement btn1FollowingEle = webDriver.findElement(By.xpath(btn1FollowingXPath));

        //Btn2
        //h3[contains(@test-id,'-actions-t')]/following::button[@test-id='button2']
        String btn2FollowingXPath = "//h3[contains(@test-id,'-actions-t')]/following::button[@test-id='button2']";
        WebElement btn2FollowingEle = webDriver.findElement(By.xpath(btn2FollowingXPath));

        //Btn3
        //h3[contains(@test-id,'-actions-t')]/following::button[@test-id='button3']
        String btn3FollowingXPath = "//h3[contains(@test-id,'-actions-t')]/following::button[@test-id='button3']";
        WebElement btn3FollowingEle = webDriver.findElement(By.xpath(btn3FollowingXPath));

        //Hãy nhấn vào một nút để kiểm tra sự kiện.
        //div[@id='interactionResult']/child::p[@test-id='buttons-result-text']
        String lblPressBtnChildXPath = "//div[@id='interactionResult']/child::p[@test-id='buttons-result-text']";
        WebElement lblPressBtnChildEle = webDriver.findElement(By.xpath(lblPressBtnChildXPath));


    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly
        //h3[id*='ties-t']
        String lblTitleContainsCSS = "h3[id*='ties-t']";
        WebElement lblTitleContainsEle = webDriver.findElement(By.cssSelector(lblTitleContainsCSS));
        //h3[id^='dynamic-p']
        String lblTitleStartsWithCSS = "h3[id^='dynamic-p']";
        WebElement lblTitleStartsWithEle = webDriver.findElement(By.cssSelector(lblTitleStartsWithCSS));

        //Btn Click to change color
        //button[id*='or-b']
        String btnChangeColorContainsCSS = "button[id*='or-b']";
        WebElement btnChangeColorContainsEle = webDriver.findElement(By.cssSelector(btnChangeColorContainsCSS));
        //button[id^='change-c']
        String btnChangeColorStartsWithCSS = "button[id^='change-c']";
        WebElement btnChangeColorStartsWithEle = webDriver.findElement(By.cssSelector(btnChangeColorStartsWithCSS));


    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly
        //div[@id='dynamic-section']/child::h3[@id='dynamic-properties-title']
        String lblTitleChildXPath = "//div[@id='dynamic-section']/child::h3[@id='dynamic-properties-title']";
        WebElement lblTitleChildEle = webDriver.findElement(By.xpath(lblTitleChildXPath));

        //Btn Click to change color
        //div[@id='dynamic-section']/child::button
        String btnChangeColorChildXPath = "//div[@id='dynamic-section']/child::button";
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
