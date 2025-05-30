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
        //Nhập thông tin người dùng:
        String lblTitleCSS = "h3[test-id = 'textbox-form-title']";
        WebElement lblTitleEle = webDriver.findElement(By.cssSelector(lblTitleCSS));

        //Họ và tên:
        String lblNameCSS = "label[test-id = 'textbox-form-label-name']";
        WebElement lblNameEle = webDriver.findElement(By.cssSelector(lblNameCSS));

        //Nhập họ tên:
        String txtInputNameCSS = "label[test-id = 'textbox-form-label-name']";
        WebElement txtInputNameEle = webDriver.findElement(By.cssSelector(txtInputNameCSS));

        //Gửi thông tin:
        String btnSubmitCSS = "label[test-id = 'textbox-form-label-name']";
        WebElement btnSubmitEle = webDriver.findElement(By.cssSelector(btnSubmitCSS));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // Handle other elements similarly
        //Nhập thông tin người dùng:
        String lblTitleXPath = "//h3[@test-id = 'textbox-form-title']";
        WebElement lblTitleEle = webDriver.findElement(By.xpath(lblTitleXPath));

        //Họ và tên:
        String lblNameXpath = "//label[@test-id = 'textbox-form-label-name']";
        WebElement lblNameEle = webDriver.findElement(By.cssSelector(lblNameXpath));

        //Nhập họ tên:
        String txtInputNameXpath = "//label[@test-id = 'textbox-form-label-name']";
        WebElement txtInputNameEle = webDriver.findElement(By.cssSelector(txtInputNameXpath));

        //Gửi thông tin:
        String btnSubmitXpath = "//label[@test-id = 'textbox-form-label-name']";
        WebElement btnSubmitEle = webDriver.findElement(By.cssSelector(btnSubmitXpath));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        //Do you like the site?
        String lblTitleCSS = "h3[test-id = 'radio-input-yes']";
        WebElement lblTitleEle = webDriver.findElement(By.cssSelector(lblTitleCSS));

        //Yes
        String rdoYesCSS = "input[test-id = 'radio-input-yes']";
        WebElement rdoYesEle = webDriver.findElement(By.cssSelector(rdoYesCSS));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // Handle other elements similarly
        //Do you like the site?
        String lblTitleXpath = "//h3[@test-id = 'radio-input-yes']";
        WebElement lblTitleEle = webDriver.findElement(By.cssSelector(lblTitleXpath));

        //Yes
        String rdoYesXpath = "//input[@test-id = 'radio-input-yes']";
        WebElement rdoYesEle = webDriver.findElement(By.cssSelector(rdoYesXpath));
    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly
        //Buttons
        String lblButtonCSS = "h3[test-id = 'buttons-title']";
        WebElement lblTitleEle = webDriver.findElement(By.cssSelector(lblButtonCSS));

        //Click me
        String btnClickCSS = "button[test-id = 'button-click-me']";
        WebElement btnClickEle = webDriver.findElement(By.cssSelector(btnClickCSS));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);

        // Handle other elements similarly
        //Buttons
        String lblButtonXpath = "//h3[@test-id = 'buttons-title']";
        WebElement lblTitleEle = webDriver.findElement(By.cssSelector(lblButtonXpath));

        //Click me
        String btnClickXpath = "//button[@test-id = 'button-click-me']";
        WebElement btnClickEle = webDriver.findElement(By.cssSelector(btnClickXpath));
    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly
        //Dynamic Properties
        String lblDynamicPropCSS = "h3[test-id = 'dynamic-properties-title']";
        WebElement lblTitleEle = webDriver.findElement(By.cssSelector(lblDynamicPropCSS));

        //Click me
        String btnChangeColorCSS = "button[test-id = 'button-click-me']";
        WebElement btnChangeColorEle = webDriver.findElement(By.cssSelector(btnChangeColorCSS));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly
        //Dynamic Properties
        String lblDynamicPropXpath = "//h3[@test-id = 'dynamic-properties-title']";
        WebElement lblTitleEle = webDriver.findElement(By.cssSelector(lblDynamicPropXpath));

        //Click me
        String btnChangeColorXpath = "//button[@test-id = 'button-click-me']";
        WebElement btnChangeColorEle = webDriver.findElement(By.cssSelector(btnChangeColorXpath));
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
