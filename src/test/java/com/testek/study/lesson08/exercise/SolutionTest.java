package com.testek.study.lesson08.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

import static java.lang.Thread.sleep;

@Getter
@Setter
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(mWebDriver)) mWebDriver.quit();
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Element Interaction: Student Form")
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Handle your code here
        //Input (textbox)
        String FORM_XPATH_INPUT_TEXT = "//input[@placeholder='%s']";

        //Input (textarea)
        String FORM_XPATH_INPUT_TA = "//textarea[@id='%s']";

        //Input (radiobutton)
        String FORM_XPATH_INPUT_RDO = "//label[@test-id='%s']";

        //Input (datetime picker)
        String FORM_XPATH_INPUT_DTP = "//input[@id='%s']";

        //Button
        String FORM_XPATH_BTN = "//button[@id='%s']";

        //Create a new Action
        Actions mActions = new Actions(mWebDriver);


        //Input valid value into all fields and click Accept button
        String inputFstNmXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your first name");
        WebElement inputFstNmEle = mWebDriver.findElement(By.xpath(inputFstNmXPath));
        inputFstNmEle.sendKeys("Thao");

        String inputLstNmXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your last name");
        WebElement inputLstNmEle = mWebDriver.findElement(By.xpath(inputLstNmXPath));
        inputLstNmEle.sendKeys("BP64");

        String inputEmailXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your email");
        WebElement inputEmailEle = mWebDriver.findElement(By.xpath(inputEmailXPath));
        inputEmailEle.sendKeys("marukochan6497@gmail.com");

        //Use the Action
        String clickFemaleXPath = String.format(FORM_XPATH_INPUT_RDO, "label-female");
        WebElement clickFemaleEle = mWebDriver.findElement(By.xpath(clickFemaleXPath));
        mActions.moveToElement(clickFemaleEle).click().build().perform();

        String inputMobileXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your mobile number");
        WebElement inputMobileEle = mWebDriver.findElement(By.xpath(inputMobileXPath));
        inputMobileEle.sendKeys("0363294476");

        String inputDTPXPath = String.format(FORM_XPATH_INPUT_DTP, "dob");
        WebElement inputDTPEle = mWebDriver.findElement(By.xpath(inputDTPXPath));
        inputDTPEle.sendKeys("06/04/1997");

        String inputSubjectsXpath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your subjects");
        WebElement inputSubjectsEle = mWebDriver.findElement(By.xpath(inputSubjectsXpath));
        inputSubjectsEle.sendKeys("Automation Testing");

        //Use the Action
        String clickReadingXPath = String.format(FORM_XPATH_INPUT_RDO, "label-reading");
        WebElement clickReadingEle = mWebDriver.findElement(By.xpath(clickReadingXPath));
        mActions.moveToElement(clickReadingEle).click().build().perform();

        //Use the Action
        String clickSportsXPath = String.format(FORM_XPATH_INPUT_RDO, "label-sports");
        WebElement clickSportsEle = mWebDriver.findElement(By.xpath(clickSportsXPath));
        mActions.moveToElement(clickSportsEle).click().build().perform();

        //Use the Action
        String clickMusicXPath = String.format(FORM_XPATH_INPUT_RDO, "label-music");
        WebElement clickMusicEle = mWebDriver.findElement(By.xpath(clickMusicXPath));
        mActions.moveToElement(clickMusicEle).click().build().perform();

        String inputAddressXPath = String.format(FORM_XPATH_INPUT_TA, "address");
        WebElement inputAddressEle = mWebDriver.findElement(By.xpath(inputAddressXPath));
        inputAddressEle.sendKeys("Ha Noi, Viet Nam");

        //Use the Action
        String btnSubmitXPath = String.format(FORM_XPATH_BTN, "submit-button");
        WebElement btnSubmitEle = mWebDriver.findElement(By.xpath(btnSubmitXPath));
        mActions.moveToElement(btnSubmitEle).click().build().perform();

    }

    @Test(description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

        // Handle your code here
        //Input (textbox)
        String FORM_XPATH_INPUT_TEXT = "//input[@placeholder='%s']";

        //Buton (login)
        String FORM_XPATH_BTN = "//button[@type='%s']";

        //Create a new Action
        Actions mActions = new Actions(mWebDriver);

        //Input value into the fields and click on Login button
        String iptAccountXPath = String.format(FORM_XPATH_INPUT_TEXT, "Tài khoản");
        WebElement iptAccountEle = mWebDriver.findElement(By.xpath(iptAccountXPath));
        iptAccountEle.sendKeys("admin_com_role");

        String iptPasswordXPath = String.format(FORM_XPATH_INPUT_TEXT, "Mật khẩu");
        WebElement iptPasswordEle = mWebDriver.findElement(By.xpath(iptPasswordXPath));
        iptPasswordEle.sendKeys("aA12345678@");

        String btnLoginXPath = String.format(FORM_XPATH_BTN, "submit");
        WebElement btnLoginEle = mWebDriver.findElement(By.xpath(btnLoginXPath));
        mActions.moveToElement(btnLoginEle).click().build().perform();

        waitForDebug(5000);

        String urlProduct = "https://testek.vn/lab/auto/product";
        mWebDriver.get(urlProduct);

        String iptSearchXPath = String.format(FORM_XPATH_INPUT_TEXT, "keyword");
        WebElement iptSearchEle = mWebDriver.findElement(By.xpath(iptSearchXPath));
        iptSearchEle.sendKeys("Tivi");

    }

    @Test(description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);

        // Handle your code here
        //Section
        String FORM_XPATH_SECTION = "//div[@id='%s']";

        //Create a new action
        Actions mActions = new Actions(mWebDriver);

        //Click, get the content and double click (The first section)
        String stnXPath = String.format(FORM_XPATH_SECTION, "accordion-item-1");
        WebElement stnEle = mWebDriver.findElement(By.xpath(stnXPath));
        mActions.moveToElement(stnEle).click().build().perform();

        String stnText = String.format(FORM_XPATH_SECTION, "accordion-body-1");
        WebElement stnTextEle = mWebDriver.findElement(By.xpath(stnText));
        String prtFirstText = stnTextEle.getText();
        System.out.println("The content of section 1 is: " + prtFirstText);

        String stnDoubleClick = String.format(FORM_XPATH_SECTION, "accordion-item-1");
        WebElement stnDoubleClickEle = mWebDriver.findElement(By.xpath(stnDoubleClick));
        mActions.moveToElement(stnDoubleClickEle).doubleClick().build().perform();

        //Click, get the content and double click (The second section)
        String stnSecondXPath = String.format(FORM_XPATH_SECTION, "accordion-header-2");
        WebElement stnSecondEle = mWebDriver.findElement(By.xpath(stnSecondXPath));
        mActions.moveToElement(stnSecondEle).click().build().perform();

        String stnSecondText = String.format(FORM_XPATH_SECTION, "accordion-body-2");
        WebElement stnSecondTextEle = mWebDriver.findElement(By.xpath(stnSecondText));
        String prtSecondText = stnSecondTextEle.getText();
        System.out.println("The content of section 2 is: " + prtSecondText);

        String stn2DoubleClick = String.format(FORM_XPATH_SECTION, "accordion-header-2");
        WebElement stn2DoubleClickEle = mWebDriver.findElement(By.xpath(stn2DoubleClick));
        mActions.moveToElement(stn2DoubleClickEle).doubleClick().build().perform();

        //Click, get the content and double click (The third section)
        String stnThirdXPath = String.format(FORM_XPATH_SECTION, "accordion-header-3");
        WebElement stnThirdEle = mWebDriver.findElement(By.xpath(stnThirdXPath));
        mActions.moveToElement(stnThirdEle).click().build().perform();

        String stnThirdText = String.format(FORM_XPATH_SECTION, "accordion-body-3");
        WebElement stnThirdTextEle = mWebDriver.findElement(By.xpath(stnThirdText));
        String prtThirdText = stnThirdTextEle.getText();
        System.out.println("The content of section 3 is: " + prtThirdText);

        String stn3DoubleClick = String.format(FORM_XPATH_SECTION, "accordion-header-3");
        WebElement stn3DoubleClickEle = mWebDriver.findElement(By.xpath(stn3DoubleClick));
        mActions.moveToElement(stn3DoubleClickEle).doubleClick().build().perform();
    }

    @Test(description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.MENU);

        // Handle your code here
        //Menu
        String FORM_XPATH_MENU = "//li[@id='%s']";

        //Create a new action
        Actions mActions = new Actions(mWebDriver);

        //Create a WebDriverWait
        WebDriverWait wait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));

        //Hover and print the title of child-menu (if have)
        String mnuHomeXPath = String.format(FORM_XPATH_MENU, "menu-item-home");
        WebElement mnuHomeEle = mWebDriver.findElement(By.xpath(mnuHomeXPath));
        mActions.moveToElement(mnuHomeEle).click().build().perform();

        String mnServicesXPath = String.format(FORM_XPATH_MENU, "menu-item-services");
        WebElement mnuServicesEle = mWebDriver.findElement(By.xpath(mnServicesXPath));
        mActions.moveToElement(mnuServicesEle).click().build().perform();

        //Child-menu của Services
        String mnuWebDesignXPath = String.format(FORM_XPATH_MENU, "submenu-item-web-design");
        WebElement mnuWebDesignEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mnuWebDesignXPath)));
        String prtWebDesignText = mnuWebDesignEle.getText();
        System.out.println("Title of child-menu: " + prtWebDesignText);

        String mnuDevelopmentXPath = String.format(FORM_XPATH_MENU, "submenu-item-development");
        WebElement mnuDevelopmentEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mnuDevelopmentXPath)));
        String prtDevelopmentText = mnuDevelopmentEle.getText();
        System.out.println("Title of child-menu: " + prtDevelopmentText);

        String mnuMarketingXPath = String.format(FORM_XPATH_MENU, "submenu-item-marketing");
        WebElement mnuMarketingEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mnuMarketingXPath)));
        String prtMarketingText = mnuMarketingEle.getText();
        System.out.println("Title of child-menu: " + prtMarketingText);

        String mnuAboutXPath = String.format(FORM_XPATH_MENU, "menu-item-about");
        WebElement mnuAboutEle = mWebDriver.findElement(By.xpath(mnuAboutXPath));
        mActions.moveToElement(mnuAboutEle).click().build().perform();

        String mnuContactXPath = String.format(FORM_XPATH_MENU, "menu-item-contact");
        WebElement mnuContactEle = mWebDriver.findElement(By.xpath(mnuContactXPath));
        mActions.moveToElement(mnuContactEle).clickAndHold().build().perform();

        //Child-menu của Contact
        String mnuEmailXPath = String.format(FORM_XPATH_MENU, "submenu-item-email");
        WebElement mnuEmailEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mnuEmailXPath)));
        String prtEmailText = mnuEmailEle.getText();
        System.out.println("Title of child-menu: " + prtEmailText);

        String mnuPhoneXPath = String.format(FORM_XPATH_MENU, "submenu-item-phone");
        WebElement mnuPhoneEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mnuPhoneXPath)));
        String prtPhoneText = mnuPhoneEle.getText();
        System.out.println("Title of child-menu: " + prtPhoneText);

    }

     /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu parent, Menu subMenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        mWebDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, parent.getName())));
        mnuElementEle.click();

        WebElement mnuEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, subMenu.getName())));
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
