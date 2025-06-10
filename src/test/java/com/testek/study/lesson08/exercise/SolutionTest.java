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
        Actions action = new Actions(mWebDriver);

        //Title
        String lblTitleXpath = "//h3[normalize-space()='Form đăng ký sinh viên']";
        mWebDriver.findElement(By.xpath(lblTitleXpath));

        //First Name
        String lblFirstNameXPath = "//label[normalize-space()='First Name:']";
        mWebDriver.findElement(By.xpath(lblFirstNameXPath));
        WebElement txtFirstNameXpath = mWebDriver.findElement(By.xpath("//input[@type='text' and @id='firstName']"));
        txtFirstNameXpath.clear();
        action.sendKeys(txtFirstNameXpath, "Doãn").perform();

        // Last Name
        String lblLastNameXPath = "//label[normalize-space()='Last Name:']";
        mWebDriver.findElement(By.xpath(lblLastNameXPath));
        WebElement txtLastNameXpath = mWebDriver.findElement(By.xpath("//input[@type='text' and @id='lastName']"));
        txtLastNameXpath.clear();
        action.sendKeys(txtLastNameXpath, "Kiên").perform();

        // Email
        String lblEmailXpath = "//label[normalize-space()='Email:']";
        mWebDriver.findElement(By.xpath(lblEmailXpath));
        WebElement txtEmailXpath = mWebDriver.findElement(By.xpath("//input[@test-id='input-email']"));
        txtEmailXpath.clear();
        action.sendKeys(txtEmailXpath, "kiendoan796@gmail.com").perform();

        // Gender:
        String lblGenderXpath = "//label[normalize-space()='Gender:']";
        mWebDriver.findElement(By.xpath(lblGenderXpath));
        WebElement rdoMaleXpath = mWebDriver.findElement(By.xpath("//label[@test-id='label-male']"));
        WebElement rdoFemaleXpath = mWebDriver.findElement(By.xpath("//label[@test-id='label-female']"));
        action.click(rdoMaleXpath).perform();
        action.click(rdoFemaleXpath).perform();

        // Mobile
        String lblMobileXpath = "//label[normalize-space()='Mobile:']";
        mWebDriver.findElement(By.xpath(lblMobileXpath));
        WebElement txtMobileXpath = mWebDriver.findElement(By.xpath("//input[@test-id='input-mobile']"));
        txtMobileXpath.clear();
        action.sendKeys(txtMobileXpath, "0989261459").perform();

        // DOB
        String lblDOBXpath = "//label[normalize-space()='Date of Birth:']";
        mWebDriver.findElement(By.xpath(lblDOBXpath));
        WebElement txtDOBXpath = mWebDriver.findElement(By.xpath("//input[@test-id='input-dob']"));
        txtDOBXpath.clear();
        action.sendKeys(txtDOBXpath, "14/04/1999").perform();

        //Subjects
        String lblSubjectsXpath = "//label[normalize-space()='Subjects:']";
        mWebDriver.findElement(By.xpath(lblSubjectsXpath));
        WebElement txtSubjectXpath = mWebDriver.findElement(By.xpath("//input[@test-id='input-subjects']"));
        txtSubjectXpath.clear();
        action.sendKeys(txtSubjectXpath, "Java").perform();

        // Hobbies
        String lblHobbiesXpath = "//label[normalize-space()='Hobbies:']";
        mWebDriver.findElement(By.xpath(lblHobbiesXpath));
        WebElement chkReadingXpath = mWebDriver.findElement(By.xpath("//label[@test-id='label-reading']"));
        WebElement chkSportsXpath = mWebDriver.findElement(By.xpath("//label[@test-id='label-sports']"));
        WebElement chkMusicXpath = mWebDriver.findElement(By.xpath("//label[@test-id='label-music']"));
        action.click(chkReadingXpath).perform();
        action.click(chkSportsXpath).perform();
        action.click(chkMusicXpath).perform();

        // Address
        String lblAddressXpath = "//label[normalize-space()='Address:']";
        mWebDriver.findElement(By.xpath(lblAddressXpath));
        WebElement txtAddressXpath = mWebDriver.findElement(By.xpath("//textarea[@test-id='textarea-address']"));
        txtAddressXpath.clear();
        action.sendKeys(txtAddressXpath, "Số 6 ngõ 89").perform();

        // Click btn Gửi thông tin
        WebElement btnSubmitXpath = mWebDriver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        action.click(btnSubmitXpath).perform();

        // Click btn Clear
        WebElement btnClearXpath = mWebDriver.findElement(By.xpath("//button[@test-id='reset-button']"));
        action.click(btnClearXpath).perform();
    }

    @Test(description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

        // Handle your code here
        Actions action = new Actions(mWebDriver);

        // Input account
        WebElement txtUsernameEle = mWebDriver.findElement(By.id("normal_login_username"));
        action.sendKeys(txtUsernameEle, "admin_com_role").perform();
        WebElement txtPasswordEle = mWebDriver.findElement(By.id("normal_login_password"));
        action.sendKeys(txtPasswordEle, "aA12345678@").perform();

        // Click btn Login
        WebElement btnLoginEle = mWebDriver.findElement(By.xpath("//button[normalize-space()='Đăng nhập']"));
        action.click(btnLoginEle).perform();

        waitForDebug(5000);

        // Click menu>Product
        String menuProductXpath = "//div[@class='menus mt-4 pl-3 pr-3']/child::div[normalize-space()='Sản phẩm']";
        WebElement menuProductEle = mWebDriver.findElement(By.xpath(menuProductXpath));
        action.click(menuProductEle).perform();

        // Input keyword search
        String txtKeywordXpath = "//div[@class='filters flex items-center']/descendant::input[@placeholder='keyword']";
        WebElement txtKeywordEle = mWebDriver.findElement(By.xpath(txtKeywordXpath));
        action.sendKeys(txtKeywordEle, "Tivi").perform();

        String btnSearchCenterXpath = "//div[@class='filters flex items-center']/descendant::button[normalize-space()='Tìm kiếm']";
        WebElement btnSearchCenterEle = mWebDriver.findElement(By.xpath(btnSearchCenterXpath));
        action.click(btnSearchCenterEle).perform();
    }

    @Test(description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);

        // Handle your code here
        Actions action = new Actions(mWebDriver);

        // Accordions Xpath
        List<WebElement> accordionHeaderList = mWebDriver.findElements(By.xpath("//div[starts-with(@id, 'accordion-header-')]"));

        String XPATH_BODY_ACCORDION = "//div[@id='accordion-body-%s']";
        // Click
        for (int i = 0; i < accordionHeaderList.size(); i++) {
            // Click Header accordion
            action.click(accordionHeaderList.get(i)).perform();
            System.out.println(accordionHeaderList.get(i).getText());

            // Xpath body accordion
            String accordionBodyXpath = String.format(XPATH_BODY_ACCORDION, i + 1);
            WebElement accordionBodyEle = mWebDriver.findElement(By.xpath(accordionBodyXpath));

            System.out.println(accordionBodyEle.getText());
        }

        // Double Click
        for (WebElement element : accordionHeaderList) {
            action.doubleClick(element).perform();
        }
    }

    @Test(description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);

        // Handle your code here
        Actions action = new Actions(mWebDriver);

        // List menu
        List<WebElement> menuList = mWebDriver.findElements(By.xpath("//a[starts-with(@test-id, 'menu-link-')]"));
        for (WebElement element : menuList) {
            action.moveToElement(element).perform();
            System.out.println(element.getText());

            // List submenu
            List<WebElement> submenuList = mWebDriver.findElements(By.xpath("//a[starts-with(@test-id, 'submenu-link-')]"));
            if (!submenuList.isEmpty()) {
                for (int i = 0; i < submenuList.size(); i++) {
                    System.out.println(submenuList.get(i).getText());
                }
            } else {
                System.out.println();
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
