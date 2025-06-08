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
    @Test(priority = 1, description = "Element Interaction: Student Form")
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Handle your code here

        Actions actions = new Actions(mWebDriver);

        //Form đăng ký sinh viên
        String lblTtlXPath = "//h3[@test-id='textbox-form-output-title']";
        WebElement lblTtlEle = mWebDriver.findElement(By.xpath(lblTtlXPath));

        //First name
        String txtFirstNameXPath = "//input[@test-id='input-firstName']";
        WebElement txtFirstNameEle = mWebDriver.findElement(By.xpath(txtFirstNameXPath));
        txtFirstNameEle.clear();
        actions.sendKeys(txtFirstNameEle, "a").perform();

        //Last name
        String txtLastNameXPath = "//input[@test-id='input-lastName']";
        WebElement txtLastNameEle = mWebDriver.findElement(By.xpath(txtLastNameXPath));
        txtLastNameEle.clear();
        actions.sendKeys(txtLastNameEle, "b").perform();

        //Email
        String txtEmailXPath = "//input[@test-id='input-email']";
        WebElement txtEmailEle = mWebDriver.findElement(By.xpath(txtEmailXPath));
        txtEmailEle.clear();
        actions.sendKeys(txtEmailEle, "c@gmail.com");

        //Gender
        String rdoMaleXPath = "//input[@test-id='input-male']";
        WebElement rdoMaleEle = mWebDriver.findElement(By.xpath(rdoMaleXPath));
        String rdoFemaleXPath = "//input[@id='female']";
        WebElement rdoFemaleEle = mWebDriver.findElement(By.xpath(rdoFemaleXPath));
        actions.click(rdoFemaleEle).perform();

        boolean isFemaleChecked = rdoFemaleEle.isSelected();
        System.out.println("isFemaleChecked " + isFemaleChecked);
        boolean isMaleChecked = rdoMaleEle.isSelected();
        System.out.println("isMaleChecked " + isMaleChecked);

        //Mobile
        String txtMobileXPath = "//input[@test-id='input-mobile']";
        WebElement txtMobileEle = mWebDriver.findElement(By.xpath(txtMobileXPath));
        txtMobileEle.clear();
        actions.sendKeys(txtMobileEle, "123").perform();

        //Date of Birth
        String txtPickerXPath = "//input[@test-id='input-dob']";
        WebElement txtPickerEle = mWebDriver.findElement(By.xpath(txtPickerXPath));
        txtPickerEle.clear();
        txtPickerEle.sendKeys("01/06/2025");

        //Subjects
        String txtSubjectXPath = "//input[@test-id='input-subjects']";
        WebElement txtSubjectEle = mWebDriver.findElement(By.xpath(txtSubjectXPath));
        txtSubjectEle.clear();
        actions.sendKeys(txtSubjectEle, "d").perform();

        //Hobbies
        String chkReadingXPath = "//label[@test-id='label-reading']";
        WebElement chkReadingEle = mWebDriver.findElement(By.xpath(chkReadingXPath));
        if (!chkReadingEle.isSelected()) {
            chkReadingEle.click();
        }
        String chkSportsXPath = "//label[@test-id='label-sports']";
        WebElement chkSportsEle = mWebDriver.findElement(By.xpath(chkSportsXPath));
        String chkMusicXPath = "//label[@test-id='label-music']";
        WebElement chkMusicEle = mWebDriver.findElement(By.xpath(chkMusicXPath));

        boolean isReadingChecked = chkReadingEle.isSelected();
        boolean isSportChecked = chkSportsEle.isSelected();
        boolean isMusicChecked = chkMusicEle.isSelected();
        System.out.println("isReadingChecked " + isReadingChecked);
        System.out.println("isSportChecked " + isSportChecked);
        System.out.println("isMusicChecked " + isMusicChecked);

        //Address
        String txtAddressXPath = "//textarea[@test-id='textarea-address']";
        WebElement txtAddressEle = mWebDriver.findElement(By.xpath(txtAddressXPath));
        txtAddressEle.clear();
        actions.sendKeys(txtAddressEle, "e").perform();

        //Button Submit
        String btnSubmitXPath = "//button[@test-id='submit-button']";
        WebElement btnSubmitEle = mWebDriver.findElement(By.xpath(btnSubmitXPath));
        actions.click(btnSubmitEle).perform();

        waitForDebug(5000);

        //Thông tin bạn đã nhập
        String txtInfoXPath = "//textarea[@test-id='outputTextStudent']";
        WebElement txtInfoEle = mWebDriver.findElement(By.xpath(txtInfoXPath));
        System.out.println("Info: " + txtInfoEle.getAttribute("value"));

        //Button Clear
        String btnClearXPath = "//button[@test-id='reset-button']";
        WebElement btnClearEle = mWebDriver.findElement(By.xpath(btnClearXPath));
        actions.click(btnClearEle).perform();
        System.out.println("Info" + txtInfoEle.getAttribute("value"));
    }

    @Test(priority = 2, description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

        // Handle your code here
        Actions actions = new Actions(mWebDriver);

        //Login
        // Tài khoản
        String txtAccountXPath = "//input[@id='normal_login_username']";
        WebElement txtAccountXPathEle = mWebDriver.findElement(By.xpath(txtAccountXPath));
        txtAccountXPathEle.clear();
        actions.sendKeys(txtAccountXPathEle, "admin_com_role").perform();

        // Mật khẩu
        String txtPasswordXPath = "//input[@id='normal_login_password']";
        WebElement txtPasswordEle = mWebDriver.findElement(By.xpath(txtPasswordXPath));
        txtPasswordEle.clear();
        actions.sendKeys(txtPasswordEle, "aA12345678@").perform();
        waitForDebug(2000);

        // Đăng nhập

        String btnLoginXpath = "//span[text()='Đăng nhập']/parent::button";
        WebElement btnLoginEle = mWebDriver.findElement(By.xpath(btnLoginXpath));
        actions.click(btnLoginEle).perform();
        waitForDebug(5000);

        // Truy cập [Sản phẩm]
        String mnuBtnProductXpath = "//div[text()='Sản phẩm']/ancestor::div[contains(@class, 'menu flex')]";
        WebElement mnuBtnProductEle = mWebDriver.findElement(By.xpath(mnuBtnProductXpath));
        actions.click(mnuBtnProductEle).perform();

        // Tìm kiếm sản phẩm với từ khóa: "Tivi"
        String txtKeywordXPath = "//input[@placeholder= 'keyword' and @class = 'ant-input css-16pw25h h-8']";
        WebElement txtKeywordEle = mWebDriver.findElement(By.xpath(txtKeywordXPath));
        txtKeywordEle.clear();
        actions.sendKeys(txtKeywordEle, "tivi").perform();

        String btnSearchXpath = "//button[contains(@class, 'ant-btn-primary') and .//span[text()='Tìm kiếm']]";
        WebElement btnSearchEle = mWebDriver.findElement(By.xpath(btnSearchXpath));
        actions.click(btnSearchEle).perform();
    }

    @Test(priority = 3, description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);

        // Handle your code here
        Actions mActions = new Actions(mWebDriver);

        //Accordion 1
        String accordionXPath1 = "//div[@test-id='accordion-header-1']";
        WebElement accordionXPathEle1 = mWebDriver.findElement(By.xpath(accordionXPath1));
        mActions.click(accordionXPathEle1).perform();

        String lbtAccordionXPath1 = "//div[@test-id='accordion-body-1']";
        WebElement lbtAccordionXPathEle1 = mWebDriver.findElement(By.xpath(lbtAccordionXPath1));
        System.out.println(lbtAccordionXPathEle1.getText());
        mActions.click(accordionXPathEle1).perform();

        mActions.doubleClick(accordionXPathEle1).perform();
        System.out.println(lbtAccordionXPathEle1.getText());

        //Accordion 2
        String accordionXPath2 = "//div[@test-id='accordion-header-2']";
        WebElement accordionXPathEle2 = mWebDriver.findElement(By.xpath(accordionXPath2));
        mActions.click(accordionXPathEle2).perform();

        String lbtAccordionXPath2 = "//div[@test-id='accordion-header-2']/following-sibling::div";
        WebElement lbtAccordionXPathEle2 = mWebDriver.findElement(By.xpath(lbtAccordionXPath2));
        System.out.println(lbtAccordionXPathEle2.getText());
        mActions.click(accordionXPathEle2).perform();

        mActions.doubleClick(accordionXPathEle2).perform();
        System.out.println(lbtAccordionXPathEle2.getText());

        //Accordion 3
        String accordionXPath3 = "//div[@test-id='accordion-header-3']";
        WebElement accordionXPathEle3 = mWebDriver.findElement(By.xpath(accordionXPath3));
        mActions.click(accordionXPathEle3).perform();

        String lbtAccordionXPath3 = "//div[@test-id='accordion-header-3']/following-sibling::div";
        WebElement lbtAccordionXPathEle3 = mWebDriver.findElement(By.xpath(lbtAccordionXPath3));
        System.out.println(lbtAccordionXPathEle3.getText());
        mActions.click(accordionXPathEle3).perform();

        mActions.doubleClick(accordionXPathEle3).perform();
        System.out.println(lbtAccordionXPathEle3.getText());
    }

    @Test(priority = 4, description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);

        // Handle your code here
        Actions Actions = new Actions(mWebDriver);

        //Home
        String lblHomeXPath = "//a[@test-id='menu-link-home']";
        WebElement lblHomeEle = mWebDriver.findElement(By.xpath(lblHomeXPath));
        Actions.moveToElement(lblHomeEle).click().build().perform();

        //Services
        String lblServicesXPath = "//a[@test-id='menu-link-services']";
        WebElement lblServiceEle = mWebDriver.findElement(By.xpath(lblServicesXPath));
        Actions.moveToElement(lblServiceEle).click().build().perform();

        String lblWebDesignXPath = "//a[@test-id='submenu-link-web-design']";
        WebElement lblWebDesignEle = mWebDriver.findElement(By.xpath(lblWebDesignXPath));
        System.out.println(lblWebDesignEle.getText());

        String lblDevelopmentXPath = "//a[@test-id='submenu-link-development']";
        WebElement lblDevelopmentEle = mWebDriver.findElement(By.xpath(lblDevelopmentXPath));
        System.out.println(lblDevelopmentEle.getText());

        String lblMarketingXPath = "//a[@test-id='submenu-link-marketing']";
        WebElement lblMarketingEle = mWebDriver.findElement(By.xpath(lblMarketingXPath));
        System.out.println(lblMarketingEle.getText());

        //About
        String lblAboutXPath = "//a[@test-id='menu-link-about']";
        WebElement lblAboutEle = mWebDriver.findElement(By.xpath(lblAboutXPath));
        Actions.moveToElement(lblAboutEle).click().build().perform();

        //Contact
        String lblContactXPath = "//a[@test-id='menu-link-contact']";
        WebElement lblContactEle = mWebDriver.findElement(By.xpath(lblContactXPath));
        Actions.moveToElement(lblContactEle).click().build().perform();

        String lblEmailXPath = "//a[@test-id='submenu-link-email']";
        WebElement lblEmailEle = mWebDriver.findElement(By.xpath(lblEmailXPath));
        System.out.println(lblEmailEle.getText());

        String lblPhoneXPath = "//a[@test-id='submenu-link-phone']";
        WebElement lblPhoneEle = mWebDriver.findElement(By.xpath(lblPhoneXPath));
        System.out.println(lblPhoneEle.getText());
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
