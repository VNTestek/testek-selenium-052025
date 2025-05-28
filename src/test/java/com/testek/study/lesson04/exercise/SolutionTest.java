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
        String containsTitleCss = "[test-id*='form-t']";
        WebElement containsTitleCssEle = webDriver.findElement(By.cssSelector(containsTitleCss));
        String startsTitleCss = "[test-id*='textbox-form-t']";
        WebElement startsTitleCssEle = webDriver.findElement(By.cssSelector(startsTitleCss));
        String lastTitle = "[test-id$='m-title']";
        WebElement lastTitleEle = webDriver.findElement(By.cssSelector(lastTitle));

        String lblContainsNameCss = "[test-id*='label-na']";
        WebElement lblContainsNameCssEle = webDriver.findElement(By.cssSelector(lblContainsNameCss));
        String lblNameLast = "[test-id$='label-name']";
        WebElement lblNameLastEle = webDriver.findElement(By.cssSelector(lblNameLast));

        String txtNameIdCss = "#name";
        WebElement txtNameIdCssEle = webDriver.findElement(By.cssSelector(txtNameIdCss));
        String txtContainsNameCss = "[test-id*='m-input-n']";
        WebElement txtContainsNameCssEle = webDriver.findElement(By.cssSelector(txtContainsNameCss));

        String lblContainsEmailCss = "[test-id*='-label-e']";
        WebElement lblContainsEmailCssEle = webDriver.findElement(By.cssSelector(lblContainsEmailCss));

        String txtStartsEmailCss = "[test-id^='textbox-form-input-e']";
        WebElement txtStartsEmailCssEle = webDriver.findElement(By.cssSelector(txtStartsEmailCss));

        String containsPhoneCss = "[test-id*='label-ph']";
        WebElement containsPhoneCssEle = webDriver.findElement(By.cssSelector(containsPhoneCss));
        String lastPhone = "[test-id$='l-phone']";
        WebElement phoneLastEle = webDriver.findElement(By.cssSelector(lastPhone));

        String txtContainsPhoneCss = "[test-id*='textbox-form-input-p']";
        WebElement txtContainsPhoneCssEle = webDriver.findElement(By.cssSelector(txtContainsPhoneCss));
        String txtPhoneIdCss = "#phone";
        WebElement txtPhoneIdCssEle = webDriver.findElement(By.cssSelector(txtPhoneIdCss));

        String lastAddress = "[test-id$='-label-address']";
        WebElement phoneAddressEle = webDriver.findElement(By.cssSelector(lastAddress));

        String txtContainsAddressCss = "[test-id*='textbox-form-input-a']";
        WebElement txtContainsAddressCssEle = webDriver.findElement(By.cssSelector(txtContainsAddressCss));
        String txtAddressIdCss = "#address";
        WebElement txtAddressIdCssEle = webDriver.findElement(By.cssSelector(txtAddressIdCss));

        String containsResTitleCss = "[test-id*='-form-output-']";
        WebElement containsResTitleCssEle = webDriver.findElement(By.cssSelector(containsResTitleCss));
        String lastResTitle = "[test-id$='put-title']";
        WebElement lastResTitleEle = webDriver.findElement(By.cssSelector(lastResTitle));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // Handle other elements similarly
        String containsTitleXpath = "//h3[contains(@test-id,'m-title')]";
        WebElement containsTitleXpathEle = webDriver.findElement(By.xpath(containsTitleXpath));
        String startsTitleXpath = "//h3[starts-with(@test-id,'textbox-form-t')]";
        WebElement startsTitleXpathEle = webDriver.findElement(By.xpath(startsTitleXpath));
        String normalizeTitle = "//h3[normalize-space()='Nhập thông tin người dùng:']";
        WebElement normalizeTitleEle = webDriver.findElement(By.xpath(normalizeTitle));
        String ancestorTitle = "//input[@id='email']/ancestor::form/preceding::h3[@test-id='textbox-form-title']";
        WebElement ancestorTitleEle = webDriver.findElement(By.xpath(ancestorTitle));
        String descendantTitle = "//div[@test-id='textbox-form-container']/descendant::h3[text()='Nhập thông tin người dùng:']";
        WebElement descendantTitleEle = webDriver.findElement(By.xpath(descendantTitle));
        String followingSibTitle = "//div[@id='about-me']/following-sibling::div/div/h3[@test-id='textbox-form-title']";
        WebElement followingSibTitleEle = webDriver.findElement(By.xpath(followingSibTitle));
        String precedingTitle = "//input[@id='name']/preceding::h3";
        WebElement precedingTitleEle = webDriver.findElement(By.xpath(precedingTitle));
        String followingTitle = "//div[@id='about-me']/following::h3[@test-id='textbox-form-title']";
        WebElement followingTitleEle = webDriver.findElement(By.xpath(followingTitle));
        String childTitle = "//div[@class='form-container']/child::h3[@test-id='textbox-form-title']";
        WebElement childTitleEle = webDriver.findElement(By.xpath(childTitle));


        String lblContainsNameXpath = "//label[contains(@test-id,'label-name')]";
        WebElement lblContainsNameXpathEle = webDriver.findElement(By.xpath(lblContainsNameXpath));
        String lblNormalizeName = "//label[normalize-space()='Họ và tên:']";
        WebElement lblNormalizeNameEle = webDriver.findElement(By.xpath(lblNormalizeName));
        String txtName = "//label[text()='Họ và tên:']";
        WebElement txtNameEle = webDriver.findElement(By.xpath(txtName));

        String txtChildName = "//form[@id='userInfoForm']/child::input[@id='name']";
        WebElement txtChildNameEle = webDriver.findElement(By.xpath(txtChildName));
        String txtFollowingName = "//div[@test-id='menu-interactions']/following::input[@id='name']";
        WebElement txtFollowingNameEle = webDriver.findElement(By.xpath(txtFollowingName));

        String precedingSibEmail = "//label[@test-id='textbox-form-label-phone']/preceding-sibling::label[@test-id='textbox-form-label-email']";
        WebElement precedingSibEmailEle = webDriver.findElement(By.xpath(precedingSibEmail));
        String descendantEmail = "//form[@id='userInfoForm']/descendant::label[@test-id='textbox-form-label-email']";
        WebElement descendantEmailEle = webDriver.findElement(By.xpath(descendantEmail));
        String followingSibEmail = "//label[@test-id='textbox-form-label-name']/following-sibling::label[@test-id='textbox-form-label-email']";
        WebElement followingSibEmailEle = webDriver.findElement(By.xpath(followingSibEmail));

        String txtFollowingSibEmail = "//label[contains(@test-id,'form-label-n')]/following-sibling::input[@id='email']";
        WebElement txtFollowingSibEmailEle = webDriver.findElement(By.xpath(txtFollowingSibEmail));
        String txtPrecedingEmail = "//div[@id='checkbox-section']/preceding::input[@id='email']";
        WebElement txtPrecedingEmailEle = webDriver.findElement(By.xpath(txtPrecedingEmail));

        String precedingPhone = "//button[@test-id='textbox-form-submit']/preceding::label[@test-id='textbox-form-label-phone']";
        WebElement precedingPhoneEle = webDriver.findElement(By.xpath(precedingPhone));
        String followingPhone = "//div[@test-id='menu-interactions']/following::label[@test-id='textbox-form-label-phone']";
        WebElement followingPhoneEle = webDriver.findElement(By.xpath(followingPhone));
        String childPhone = "//form[@id='userInfoForm']/child::label[@test-id='textbox-form-label-phone']";
        WebElement childPhoneEle = webDriver.findElement(By.xpath(childPhone));

        String txtPrecedingSibPhone = "//input[@id='address']/preceding-sibling::input[@id='phone']";
        WebElement txtPrecedingSibPhoneEle = webDriver.findElement(By.xpath(txtPrecedingSibPhone));
        String txtDescendantPhone = "//div[@id='textbox-section']/descendant::input[@id='phone']";
        WebElement txtDescendantPhoneEle = webDriver.findElement(By.xpath(txtDescendantPhone));

        String txtAddress = "//input[@placeholder='Nhập địa chỉ']";
        WebElement txtAddressEle = webDriver.findElement(By.xpath(txtAddress));
        String txtDescendantAddress = "//div[@class='form-container']/descendant::input[@placeholder='Nhập địa chỉ']";
        WebElement txtDescendantAddressEle = webDriver.findElement(By.xpath(txtDescendantAddress));

        String lblStartsAddressXpath = "//label[starts-with(@test-id,'textbox-form-label-a')]";
        WebElement lblStartsAddressXpathEle = webDriver.findElement(By.xpath(lblStartsAddressXpath));
        String lblNormalizeAddress = "//label[normalize-space()='Địa chỉ:']";
        WebElement lblNormalizeAddressEle = webDriver.findElement(By.xpath(lblNormalizeAddress));

        String followingSibResTitle = "//input[@id='email']/following-sibling::input[@id='address']";
        WebElement followingSibResTitleEle = webDriver.findElement(By.xpath(followingSibResTitle));
        String childResTitle = "//form[@id='userInfoForm']/child::input[@id='address']";
        WebElement childResTitleEle = webDriver.findElement(By.xpath(childResTitle));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfCheckbox() {
        gotoTestWebsite(Menu.CHECK_BOX);

        // Handle other elements similarly
        String chkCss = "[test-id='checkbox-title']";
        WebElement chkCssEle = webDriver.findElement(By.cssSelector(chkCss));
        String lastChkCss = "[test-id$='x-title']";
        WebElement lastChkCssEle = webDriver.findElement(By.cssSelector(lastChkCss));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXpathOfCheckbox() {
        gotoTestWebsite(Menu.CHECK_BOX);

        // Handle other elements similarly
        String containsChkXpath = "//h3[contains(@test-id,'x-title')]";
        WebElement containsChkXpathEle = webDriver.findElement(By.xpath(containsChkXpath));
        String chkXpath = "//h3[text()='Check Box']";
        WebElement chkXpathEle = webDriver.findElement(By.xpath(chkXpath));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        String rdoCss = "[name='likeSite'][value='Yes']";
        WebElement rdoCssEle = webDriver.findElement(By.cssSelector(rdoCss));
        String containsRdoCss = "[test-id*='t-yes']";
        WebElement containsRdoCssEle = webDriver.findElement(By.cssSelector(containsRdoCss));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        String containsRdoXpath = "//input[contains(@test-id,'t-impressive')]";
        WebElement containsRdoXpathEle = webDriver.findElement(By.xpath(containsRdoXpath));
        String RdoXpath = "//input[@name='likeSite' and @value='Impressive']";
        WebElement RdoXpathEle = webDriver.findElement(By.xpath(RdoXpath));
    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly
        String btnLastCss = "[test-id$='click-me']";
        WebElement btnLastCssEle = webDriver.findElement(By.cssSelector(btnLastCss));
        String btnStartsCss = "[test-id^='button-click']";
        WebElement btnStartsCssEle = webDriver.findElement(By.cssSelector(btnStartsCss));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly
        String btnNormalize = "//button[normalize-space()='Confirm Me']";
        WebElement btnNormalizeEle = webDriver.findElement(By.xpath(btnNormalize));
        String btnPrecedingSib = "//button[@id='button1']/preceding-sibling::button[@test-id='button-confirm-me']";
        WebElement btnPrecedingSibEle = webDriver.findElement(By.xpath(btnPrecedingSib));
    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly
        String btnContainsCss = "[id*='color-b']";
        WebElement btnContainsCssEle = webDriver.findElement(By.cssSelector(btnContainsCss));
        String btnIdCss = "#change-color-button";
        WebElement btnIdCssEle = webDriver.findElement(By.cssSelector(btnIdCss));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly
        String btnFollowingSib = "//h3[@id='dynamic-properties-title']/following-sibling::button[@id='change-color-button']";
        WebElement btnFollowingSibEle = webDriver.findElement(By.xpath(btnFollowingSib));
        String btnPreceding = "//h3[@id='browser-windows-title']/preceding::button[@id='change-color-button']";
        WebElement btnPrecedingEle = webDriver.findElement(By.xpath(btnPreceding));
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