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
        // Họ và tên
        String txtNameCSS = "input[placeholder='Nhập họ tên']";
        webDriver.findElement(By.cssSelector(txtNameCSS));
        String txtNameStartCSS = "input[placeholder^='Nhập họ']";
        webDriver.findElement(By.cssSelector(txtNameStartCSS));
        String txtNameContainCSS = "input[placeholder*='Nhập họ']";
        webDriver.findElement(By.cssSelector(txtNameContainCSS));
        String txtNameIdCSS = "#name";
        webDriver.findElement(By.cssSelector(txtNameIdCSS));

        // Email
        String txtEmailCSS = "input[placeholder='Nhập email']";
        webDriver.findElement(By.cssSelector(txtEmailCSS));
        String txtEmailStartCSS = "input[placeholder^='Nhập ema']";
        webDriver.findElement(By.cssSelector(txtEmailStartCSS));
        String txtEmailContainCSS = "input[placeholder*='Nhập ema']";
        webDriver.findElement(By.cssSelector(txtEmailContainCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // Handle other elements similarly

        //Họ và tên
        String txtNameXpath = "//input[@placeholder='Nhập họ tên']";
        webDriver.findElement(By.xpath(txtNameXpath));
        String txtNameStartXpath = "//input[starts-with(@placeholder,'Nhập họ ')]";
        webDriver.findElement(By.xpath(txtNameStartXpath));
        String txtNameContainXpath = "//input[contains(@placeholder,'Nhập họ ')]";
        webDriver.findElement(By.xpath(txtNameContainXpath));
        String txtNameFollowingSiblingXpath = "//label[text()='Họ và tên:']/following-sibling::input[@placeholder='Nhập họ tên']";
        webDriver.findElement(By.xpath(txtNameFollowingSiblingXpath));
        String txtNameDescendantXpath = "//div[@class='form-container']/descendant::input[@placeholder='Nhập họ tên']";
        webDriver.findElement(By.xpath(txtNameDescendantXpath));

        //Email:
        String txtEmailXpath = "//input[@placeholder='Nhập email']";
        webDriver.findElement(By.xpath(txtEmailXpath));
        String txtEmailStartXpath = "//input[starts-with(@placeholder,'Nhập em')]";
        webDriver.findElement(By.xpath(txtEmailStartXpath));
        String txtEmailContainXpath = "//input[contains(@placeholder,'Nhập em')]";
        webDriver.findElement(By.xpath(txtEmailContainXpath));
        String txtEmailFollowingSiblingXpath = "//label[text()='Họ và tên:']/following-sibling::input[@placeholder='Nhập email']";
        webDriver.findElement(By.xpath(txtEmailFollowingSiblingXpath));
        String txtEmailDescendantXpath = "//div[@class='form-container']/descendant::input[@placeholder='Nhập email']";
        webDriver.findElement(By.xpath(txtEmailDescendantXpath));

        //Số điện thoại:
        String txtPhoneXpath = "//input[@placeholder='Nhập số điện thoại']";
        webDriver.findElement(By.xpath(txtPhoneXpath));
        String txtPhoneStartXpath = "//input[starts-with(@placeholder,'Nhập số ')]";
        webDriver.findElement(By.xpath(txtPhoneStartXpath));
        String txtPhoneContainXpath = "//input[contains(@placeholder,'Nhập số ')]";
        webDriver.findElement(By.xpath(txtPhoneContainXpath));
        String txtPhoneFollowingSiblingXpath = "//label[text()='Họ và tên:']/following-sibling::input[@placeholder='Nhập số điện thoại']";
        webDriver.findElement(By.xpath(txtPhoneFollowingSiblingXpath));
        String txtPhoneDescendantXpath = "//div[@class='form-container']/descendant::input[@placeholder='Nhập số điện thoại']";
        webDriver.findElement(By.xpath(txtPhoneDescendantXpath));

        //Địa chỉ:
        String txtAddressXpath = "//input[@placeholder='Nhập địa chỉ']";
        webDriver.findElement(By.xpath(txtAddressXpath));
        String txtAddressStartXpath = "//input[starts-with(@placeholder,'Nhập địa')]";
        webDriver.findElement(By.xpath(txtAddressStartXpath));
        String txtAddressContainXpath = "//input[contains(@placeholder,'Nhập địa')]";
        webDriver.findElement(By.xpath(txtAddressContainXpath));
        String txtAddressFollowingSiblingXpath = "//label[text()='Họ và tên:']/following-sibling::input[@placeholder='Nhập địa chỉ']";
        webDriver.findElement(By.xpath(txtAddressFollowingSiblingXpath));
        String txtAddressDescendantXpath = "//div[@class='form-container']/descendant::input[@placeholder='Nhập địa chỉ']";
        webDriver.findElement(By.xpath(txtAddressDescendantXpath));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        //Radio btn Impressive
        String rdoImpressiveCSS = "input[value='Impressive']";
        webDriver.findElement(By.cssSelector(rdoImpressiveCSS));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        String rdoImpressiveXpath = "//input[@value='Impressive']";
        webDriver.findElement(By.xpath(rdoImpressiveXpath));
    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly
        // Button 1
        String btnButtonOneCSS = "button[id='button1']";
        webDriver.findElement(By.cssSelector(btnButtonOneCSS));
        String btnButtonOneIdCSS = "#button1";
        webDriver.findElement(By.cssSelector(btnButtonOneIdCSS));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly
        // Button 1
        String btnButtonOneXpath = "//button[@id='button1']";
        webDriver.findElement(By.xpath(btnButtonOneXpath));
    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly
        String btnDynamicPropertiesCSS = "button[id='change-color-button']";
        webDriver.findElement(By.cssSelector(btnDynamicPropertiesCSS));
        String btnDynamicPropertiesIdCSS = "#change-color-button";
        webDriver.findElement(By.cssSelector(btnDynamicPropertiesCSS));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly
        String btnDynamicPropertiesXpath = "//button[@id='change-color-button']";
        webDriver.findElement(By.xpath(btnDynamicPropertiesXpath));
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
