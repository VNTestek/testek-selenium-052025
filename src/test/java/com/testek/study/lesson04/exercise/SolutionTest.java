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
        String txtTitleWebCssContainOfTextBox = "h3[test-id *='textbox-form-title']";
        WebElement txtTitleWebCssContainEle = webDriver.findElement(By.cssSelector(txtTitleWebCssContainOfTextBox));

        String lblNameCssContainOfTextBox = "label[test-id *='textbox-form-label-name']";
        WebElement lblLabelNameCssContainEle = webDriver.findElement(By.cssSelector(lblNameCssContainOfTextBox));

        String txtLabelNameCssContainOfTextBox = "input[placeholder *='Nhập họ tên']";
        WebElement txtLabelNameCssContainEle = webDriver.findElement(By.cssSelector(txtLabelNameCssContainOfTextBox));

        String lblEmailCssContainOfTextBox = "label[test-id *='textbox-form-label-email']";
        WebElement lblEmailCssContainEle = webDriver.findElement(By.cssSelector(lblEmailCssContainOfTextBox));

        String txtEmailCssContainOfTextBox = "input[placeholder *='Nhập email']";
        WebElement txtEmailCssContainEle = webDriver.findElement(By.cssSelector(txtEmailCssContainOfTextBox));

        String lblPhoneCssContainOfTextBox = "label[test-id *='textbox-form-label-phone']";
        WebElement lblPhoneCssContainEle = webDriver.findElement(By.cssSelector(lblPhoneCssContainOfTextBox));

        String txtPhoneCssOfTextBox = "input[placeholder *='Nhập số điện thoại']";
        WebElement txtPhoneCssContainEle = webDriver.findElement(By.cssSelector(txtPhoneCssOfTextBox));

        String btnSubmitCssContainOfTextBox = "button[test-id *='textbox-form-submit']";
        WebElement btnSubmitCssContainEle = webDriver.findElement(By.cssSelector(btnSubmitCssContainOfTextBox));

        String btnResetCssContainOfTextBox = "button[test-id *='textbox-form-reset']";
        WebElement btnResetCssContainEle = webDriver.findElement(By.cssSelector(btnResetCssContainOfTextBox));

        String txtOutputTitleContainCssOfTextBox = "h3[test-id *='textbox-form-output-title']";
        WebElement txtOutputTitleCssContainEle = webDriver.findElement(By.cssSelector(txtOutputTitleContainCssOfTextBox));

        String txtAreaOutputCssContainOfTextBox = "textarea[test-id *='textbox-form-output']";
        WebElement txtAreaOutputCssContainEle = webDriver.findElement(By.cssSelector(txtAreaOutputCssContainOfTextBox));
        // Start-with
        String txtTitleWebCssStartOfTextBox = "h3[test-id^='textbox-form-title']";
        WebElement txtTitleCssStartEle = webDriver.findElement(By.cssSelector(txtTitleWebCssStartOfTextBox));
        String lblNameCssStartOfTextBox = "label[test-id ^='textbox-form-label-name']";
        WebElement lblLabelNameCssStartEle = webDriver.findElement(By.cssSelector(lblNameCssStartOfTextBox));

        String txtLabelNameCssStartOfTextBox = "input[placeholder ^='Nhập họ tên']";
        WebElement txtLabelNameCssStartEle = webDriver.findElement(By.cssSelector(txtLabelNameCssStartOfTextBox));

        String lblEmailCssStartOfTextBox = "label[test-id ^='textbox-form-label-email']";
        WebElement lblEmailCssStartEle = webDriver.findElement(By.cssSelector(lblEmailCssStartOfTextBox));

        String txtEmailCssStartOfTextBox = "input[placeholder ^='Nhập email']";
        WebElement txtEmailCssStartEle = webDriver.findElement(By.cssSelector(txtEmailCssStartOfTextBox));

        String lblPhoneCssStartOfTextBox = "label[test-id ^='textbox-form-label-phone']";
        WebElement lblPhoneCssStartEle = webDriver.findElement(By.cssSelector(lblPhoneCssStartOfTextBox));

        String txtPhoneCssStartOfTextBox = "input[placeholder ^='Nhập số điện thoại']";
        WebElement txtPhoneCssStartEle = webDriver.findElement(By.cssSelector(txtPhoneCssStartOfTextBox));

        String btnSubmitCssStartOfTextBox = "button[test-id ^='textbox-form-submit']";
        WebElement btnSubmitCssStartEle = webDriver.findElement(By.cssSelector(btnSubmitCssStartOfTextBox));

        String btnResetCssStartOfTextBox = "button[test-id ^='textbox-form-reset']";
        WebElement btnResetCssStartEle = webDriver.findElement(By.cssSelector(btnResetCssStartOfTextBox));

        String txtOutputTitleStartCssOfTextBox = "h3[test-id ^='textbox-form-output-title']";
        WebElement txtOutputTitleCssStartEle = webDriver.findElement(By.cssSelector(txtOutputTitleStartCssOfTextBox));

        String txtAreaOutputCssStartOfTextBox = "textarea[test-id ^='textbox-form-output']";
        WebElement txtAreaOutputCssStartEle = webDriver.findElement(By.cssSelector(txtAreaOutputCssStartOfTextBox));


    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // Handle other elements similarly
        // Nhập thông tin người dùng
        String txtTitleWebXpathContainOfTextBox = "//h3[contains(@test-id ,'textbox-form-title')]";
        WebElement txtTitleXpathContainsEle = webDriver.findElement(By.xpath(txtTitleWebXpathContainOfTextBox));
        String txtTitleWebXpathStartOfTextBox = "//h3[starts-with(@test-id ,'textbox-form-title')]";
        WebElement txtTitleWebXpathStartEle = webDriver.findElement(By.xpath(txtTitleWebXpathStartOfTextBox));
        String txtTitleWebXpathTextOfTextBox = "//h3[normalize-space() = 'Nhập thông tin người dùng:']";
        WebElement txtTitleWebXpathTextEle = webDriver.findElement(By.xpath(txtTitleWebXpathTextOfTextBox));
        String txtTitleWebXpathDescendantOfTextBox = "//div[@test-id='textbox-form-container']/descendant::h3[@test-id='textbox-form-title']";
        WebElement txtTitleWebXpathDescendantEle = webDriver.findElement(By.xpath(txtTitleWebXpathDescendantOfTextBox));
        String txtTitleWebXpathPrecedingOfTextBox = "//input[@placeholder='Nhập họ tên']/preceding::h3[@test-id='textbox-form-title']";
        WebElement txtTitleWebXpathPrecedingEle = webDriver.findElement(By.xpath(txtTitleWebXpathPrecedingOfTextBox));
        String txtTitleWebXpathFollowingOfTextBox = "//h4[@test-id='about-me-separator']/following::h3[@test-id='textbox-form-title']";
        WebElement txtTitleWebXpathFollowingEle = webDriver.findElement(By.xpath(txtTitleWebXpathFollowingOfTextBox));
        String txtTitleWebXpathChildOfTextBox = "//div[@test-id='textbox-form-container']/child::h3[@test-id='textbox-form-title']";
        WebElement txtTitleWebXpathChildEle = webDriver.findElement(By.xpath(txtTitleWebXpathChildOfTextBox));


    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        String txtRadioTitleCssContainOfRadioButton = "h3[test-id *='radio-title']";
        WebElement txtRadioTileCssContainEle = webDriver.findElement(By.cssSelector(txtRadioTitleCssContainOfRadioButton));
        String btnYesCssContainOfRadioButton = "input[test-id *='radio-input-yes']";
        WebElement btnYesCssContainEle = webDriver.findElement(By.cssSelector(btnYesCssContainOfRadioButton));
        String lblYesCssContainOfRadioButton = "label[test-id *='radio-label-yes']";
        WebElement lblYesCssContainEle = webDriver.findElement(By.cssSelector(lblYesCssContainOfRadioButton));
        String btnImpressiveCssContainOfRadioButton = "input[test-id *='radio-input-impressive']";
        WebElement btnImpressiveSiteCssContainEle = webDriver.findElement(By.cssSelector(btnImpressiveCssContainOfRadioButton));
        String lblImpressiveCssContainOfRadioButton = "label[test-id *='radio-label-impressive']";
        WebElement lblImpressiveCssContainEle = webDriver.findElement(By.cssSelector(lblImpressiveCssContainOfRadioButton));
        String btnNoCssContainOfRadioButton = "input[test-id *='radio-input-no']";
        WebElement btnNoSiteCssContainEle = webDriver.findElement(By.cssSelector(btnNoCssContainOfRadioButton));
        String lblNoCssContainOfRadioButton = "label[test-id *='radio-label-no']";
        WebElement lblNoCssContainEle = webDriver.findElement(By.cssSelector(lblNoCssContainOfRadioButton));

        //Starts-with
        String txtRadioTitleCssStartsWithRadioButton = "h3[test-id ^='radio-title']";
        WebElement txtRadioTileCssStartsWithEle = webDriver.findElement(By.cssSelector(txtRadioTitleCssStartsWithRadioButton));
        String btnYesCssStartsWithRadioButton = "input[test-id ^='radio-input-yes']";
        WebElement btnYesCssStartsWithEle = webDriver.findElement(By.cssSelector(btnYesCssStartsWithRadioButton));
        String lblYesCssStartsWithRadioButton = "label[test-id ^='radio-label-yes']";
        WebElement lblYesCssStartsWithEle = webDriver.findElement(By.cssSelector(lblYesCssStartsWithRadioButton));
        String btnImpressiveCssStartsWithRadioButton = "input[test-id ^='radio-input-impressive']";
        WebElement btnImpressiveSiteCssStartsWithEle = webDriver.findElement(By.cssSelector(btnImpressiveCssStartsWithRadioButton));
        String lblImpressiveCssStartsWithRadioButton = "label[test-id ^='radio-label-impressive']";
        WebElement lblImpressiveCssStartsWithEle = webDriver.findElement(By.cssSelector(lblImpressiveCssStartsWithRadioButton));
        String btnNoCssStartsWithRadioButton = "input[test-id ^='radio-input-no']";
        WebElement btnNoSiteCssStartsWithEle = webDriver.findElement(By.cssSelector(btnNoCssStartsWithRadioButton));
        String lblNoCssStartsWithRadioButton = "label[test-id ^='radio-label-no']";
        WebElement lblNoCssStartsWithEle = webDriver.findElement(By.cssSelector(lblNoCssStartsWithRadioButton));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        //Do you like the site?
        String txtRadioTitleXpathContainOfRadioButton = "//h3[contains(@test-id ,'radio-title')]";
        WebElement txtRadioTitleXpathContainsEle = webDriver.findElement(By.xpath(txtRadioTitleXpathContainOfRadioButton));
        String txtRadioTitleXpathStartOfRadioButton = "//h3[starts-with(@test-id ,'radio-title')]";
        WebElement txtRadioTitleXpathStartEle = webDriver.findElement(By.xpath(txtRadioTitleXpathStartOfRadioButton));
        String txtRadioTitleXpathTextOfRadioButton = "//h3[normalize-space() = 'Do you like the site?']";
        WebElement txtRadioTitleXpathTextEle = webDriver.findElement(By.xpath(txtRadioTitleXpathTextOfRadioButton));
        String txtRadioTitleXpathDescendantOfRadioButton = "//div[@test-id='radio-section']/descendant::h3[@test-id='radio-title']";
        WebElement txtTitleWebXpathDescendantEle = webDriver.findElement(By.xpath(txtRadioTitleXpathDescendantOfRadioButton));
        String txtRadioTitleXpathPrecedingOfRadioButton = "//input[@test-id='radio-input-yes']/preceding::h3[@test-id='radio-title']";
        WebElement txtRadioTitleXpathPrecedingEle = webDriver.findElement(By.xpath(txtRadioTitleXpathPrecedingOfRadioButton));
        String txtRadioTitleXpathFollowingOfRadioButton = "//div[@test-id='checkbox-section']/following::h3[@test-id='radio-title']";
        WebElement txtRadioTitleXpathFollowingEle = webDriver.findElement(By.xpath(txtRadioTitleXpathFollowingOfRadioButton));
        String txtRadioTitleXpathChildOfRadioButton = "//div[@test-id='radio-container']/child::h3[@test-id='radio-title']";
        WebElement txtRadioTitleXpathChildEle = webDriver.findElement(By.xpath(txtRadioTitleXpathChildOfRadioButton));


    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly

    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly

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
