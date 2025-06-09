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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
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

        Actions mActions = new Actions(mWebDriver);

        // Define the locator format
        String FORM_XPATH_TITLE = "//h3[@test-id='%s']";
        String FORM_XPATH_LABEL = "//label[@test-id='%s']";
        String FORM_XPATH_PLACEHOLDER_INPUT = "//input[@placeholder='%s']";
        String FORM_XPATH_RADIOBUTTON_INPUT = "//label[@test-id='%s']";
        String dateDobXPath = "//input[@test-id='input-dob']";
        String FORM_XPATH_CHECKBOX_INPUT = "//label[@test-id='%s']";
        String FORM_XPATH_BUTTON = "//button[@test-id='%s']";
        String FORM_XPATH_TEXTAREA = "//textarea[@test-id='%s']";

        //Form Label
        String lblFirstName = String.format(FORM_XPATH_LABEL, "label-firstName");
        String lblLastName = String.format(FORM_XPATH_LABEL, "label-lastName");
        String lblEmail = String.format(FORM_XPATH_LABEL, "label-email");
        String lblGender = String.format(FORM_XPATH_LABEL, "label-gender");
        String lblMobile = String.format(FORM_XPATH_LABEL, "label-mobile");
        String lblDateOfBirth = String.format(FORM_XPATH_LABEL, "label-dob");
        String lblSubjects = String.format(FORM_XPATH_LABEL, "label-subjects");
        String lblHobbies = String.format(FORM_XPATH_LABEL, "label-hobbies");
        String lblAddress = String.format(FORM_XPATH_LABEL, "label-address");

        //Find Element label
        mWebDriver.findElement(By.xpath(lblFirstName));
        mWebDriver.findElement(By.xpath(lblLastName));
        mWebDriver.findElement(By.xpath(lblEmail));
        mWebDriver.findElement(By.xpath(lblMobile));
        mWebDriver.findElement(By.xpath(lblGender));
        mWebDriver.findElement(By.xpath(lblDateOfBirth));
        mWebDriver.findElement(By.xpath(lblSubjects));
        mWebDriver.findElement(By.xpath(lblHobbies));
        mWebDriver.findElement(By.xpath(lblAddress));

        //Title
        String lblBrowserWindowsXPath = String.format(FORM_XPATH_TITLE, "browser-windows-title");
        String lblStudentRegistrationXpath = String.format(FORM_XPATH_TITLE, "student-registration-title");
        String lblSubmittedInfoXPath = String.format(FORM_XPATH_TITLE, "submitted-info-title");

        WebElement lblBrowserWindowsEle = mWebDriver.findElement(By.xpath(lblBrowserWindowsXPath));
        WebElement lblStudentRegistrationEle = mWebDriver.findElement(By.xpath(lblStudentRegistrationXpath));
        WebElement lblSubmittedInfoEle = mWebDriver.findElement(By.xpath(lblSubmittedInfoXPath));


        //Form textbox
        String txtFirstNameXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your first name");
        WebElement txtFirstNameEle = mWebDriver.findElement(By.xpath(txtFirstNameXPath));
        txtFirstNameEle.clear();
        mActions.sendKeys(txtFirstNameEle,"Vu").perform();

        String txtLastNameXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your last name");
        WebElement txtLastNameEle = mWebDriver.findElement(By.xpath(txtLastNameXPath));
        txtLastNameEle.clear();
        mActions.sendKeys(txtLastNameEle,"Hiep").perform();

        String txtEmailXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your email");
        WebElement txtEmailEle = mWebDriver.findElement(By.xpath(txtEmailXPath));
        txtEmailEle.clear();
        mActions.sendKeys(txtEmailEle,"vuhiep465@gmail.com").perform();

        String txtMobileXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your mobile number");
        WebElement txtMobileEle = mWebDriver.findElement(By.xpath(txtMobileXPath));
        txtMobileEle.clear();
        mActions.sendKeys(txtMobileEle,"0327457186").perform();

        String txtSubjectsXPath = String.format(FORM_XPATH_PLACEHOLDER_INPUT, "Enter your subjects");
        WebElement txtSubjectsEle = mWebDriver.findElement(By.xpath(txtSubjectsXPath));
        txtSubjectsEle.clear();
        mActions.sendKeys(txtSubjectsEle,"Automation Web Testing").perform();

        //Gender Radio button
        String rdoMaleXPath = String.format(FORM_XPATH_RADIOBUTTON_INPUT, "label-male");
        WebElement rdoMaleEle = mWebDriver.findElement(By.xpath(rdoMaleXPath));

        String rdoFemaleXPath = String.format(FORM_XPATH_RADIOBUTTON_INPUT, "label-female");
        WebElement rdoFemaleEle = mWebDriver.findElement(By.xpath(rdoFemaleXPath));

        mActions.click(rdoFemaleEle).perform();
        waitForDebug(2000);
        mActions.click(rdoMaleEle).perform();

        //Hobbies Checkbox
        String chkReadingXPath = String.format(FORM_XPATH_CHECKBOX_INPUT, "label-reading");
        WebElement chkReadingEle = mWebDriver.findElement(By.xpath(chkReadingXPath));
        mActions.click(chkReadingEle).perform();

        String chkSportsXPath = String.format(FORM_XPATH_CHECKBOX_INPUT, "label-sports");
        WebElement chkSportSEle = mWebDriver.findElement(By.xpath(chkSportsXPath));
        mActions.click(chkSportSEle).perform();

        String chkMusicXPath = String.format(FORM_XPATH_CHECKBOX_INPUT, "label-music");
        WebElement chkMusicEle = mWebDriver.findElement(By.xpath(chkMusicXPath));
        mActions.click(chkMusicEle).perform();


        //dob
        WebElement dateDobEle = mWebDriver.findElement(By.xpath(dateDobXPath));
        dateDobEle.clear();
        mActions.sendKeys(dateDobEle,"09102003").perform();

        //Address
        String taAddressXPath = String.format(FORM_XPATH_TEXTAREA, "textarea-address");
        WebElement taAddressEle = mWebDriver.findElement(By.xpath(taAddressXPath));
        taAddressEle.clear();
        mActions.sendKeys(taAddressEle, "Ha Noi").perform();

        waitForDebug(3000);

        //Submit Button
        String btnSubmitXPath = String.format(FORM_XPATH_BUTTON, "submit-button");
        WebElement btnSubmitELe = mWebDriver.findElement(By.xpath(btnSubmitXPath));
        mActions.click(btnSubmitELe).perform();


        waitForDebug(5000);

        //Text area
        String taOutputTextXPath = String.format(FORM_XPATH_TEXTAREA, "outputTextStudent");
        WebElement taOutputTextEle = mWebDriver.findElement(By.xpath(taOutputTextXPath));
        String info = taOutputTextEle.getAttribute("value");
        System.out.println("Your information: " + info);

        //Clear button
        String btnClearXPath = String.format(FORM_XPATH_BUTTON, "reset-button");
        WebElement btnClearEle = mWebDriver.findElement(By.xpath(btnClearXPath));
        btnClearEle.click();

        waitForDebug(3000);
    }

    @Test(description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

        // Handle your code here

        Actions mActions = new Actions(mWebDriver);

        //Log in
        //input username
        WebElement txtUsernameEle = mWebDriver.findElement(By.id("normal_login_username"));
        txtUsernameEle.clear();
        mActions.sendKeys(txtUsernameEle, "admin_com_role").perform();

        //input password
        WebElement txtPasswordEle = mWebDriver.findElement(By.id("normal_login_password"));
        txtPasswordEle.clear();
        mActions.sendKeys(txtPasswordEle, "aA12345678@").perform();

        //CLick login button
        WebElement btnLoginEle = mWebDriver.findElement(By.cssSelector("button[type='submit']"));
        mActions.click(btnLoginEle).perform();

        waitForDebug(3000);

        //Access product
        String menuProductXPath = "//div[@class='menus mt-4 pl-3 pr-3']//div[contains(text(),'Sản phẩm')]";
        WebElement menuProductEle = mWebDriver.findElement(By.xpath(menuProductXPath));
        mActions.moveToElement(menuProductEle).click().build().perform();
        waitForDebug(3000);

        //Find product
        String txtKeywordXPath = "//input[@class='ant-input css-16pw25h']";
        WebElement txtKeywordEle = mWebDriver.findElement(By.xpath(txtKeywordXPath));
        txtKeywordEle.clear();
        mActions.sendKeys(txtKeywordEle, "Tivi").perform();

        String btnSearchXPath = "//span[@class='ant-input-group-addon']";
        WebElement btnSearchEle = mWebDriver.findElement(By.xpath(btnSearchXPath));
        mActions.moveToElement(btnSearchEle).click().build().perform();

        waitForDebug(5000);

    }

    @Test(description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);

        // Handle your code here

        Actions mActions = new Actions(mWebDriver);

        //Accordion 1
        //Click
        WebElement firstAccordionHeaderEle = mWebDriver.findElement(By.id("accordion-header-1"));
        mActions.click(firstAccordionHeaderEle).perform();
        waitForDebug(3000);
        WebElement accordionBody1Ele = mWebDriver.findElement(By.id("accordion-body-1"));
        System.out.println(" First Accordion text: " + accordionBody1Ele.getText());
        waitForDebug(3000);
        mActions.click(firstAccordionHeaderEle).perform();
        waitForDebug(2000);

        //Double Click
        mActions.doubleClick(firstAccordionHeaderEle).perform();

        //Accordion 2
        //Click
        WebElement secondAccordionHeaderEle = mWebDriver.findElement(By.id("accordion-header-2"));
        mActions.click(secondAccordionHeaderEle).perform();
        waitForDebug(3000);
        WebElement accordionBody2Ele = mWebDriver.findElement(By.id("accordion-body-2"));
        System.out.println("Second Accordion text: " + accordionBody2Ele.getText());
        waitForDebug(3000);
        mActions.click(secondAccordionHeaderEle).perform();
        waitForDebug(2000);

        //Double Click
        mActions.doubleClick(secondAccordionHeaderEle).perform();

        //Accordion 3
        //Click
        WebElement thirdAccordionHeaderEle = mWebDriver.findElement(By.id("accordion-header-3"));
        mActions.click(thirdAccordionHeaderEle).perform();
        waitForDebug(3000);
        WebElement accordionBody3Ele = mWebDriver.findElement(By.id("accordion-body-3"));
        System.out.println("Third Accordion text: " + accordionBody3Ele.getText());
        waitForDebug(3000);
        mActions.click(thirdAccordionHeaderEle).perform();
        waitForDebug(2000);

        //Double Click
        mActions.doubleClick(thirdAccordionHeaderEle);
    }

    @Test(description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);

        // Handle your code here
        Actions mActions = new Actions(mWebDriver);

        // Find all main menu items
        List<WebElement> menuList = mWebDriver.findElements(By.cssSelector("li[id^='menu']"));

        // browse through each menu
        for (WebElement menu : menuList) {
            mActions.moveToElement(menu).perform();
            waitForDebug(3000);

            // Get and print main menu name
            String menuName = menu.getText();
            System.out.print(menuName + ": ");

            // Find submenus inside the current menu (if any)
            List<WebElement> subMenus = menu.findElements(By.xpath(".//ul[starts-with(@id, 'submenu')]"));

            if (!subMenus.isEmpty()) {
                System.out.print("[");
                for (int i = 0; i < subMenus.size(); i++) {
                    String subMenuName = subMenus.get(i).getText();
                    System.out.print(subMenuName);

                    if (i < subMenus.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[No submenu]");
            }
        }
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
