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
        Actions action = new Actions(mWebDriver);

        // Handle your code here
        System.out.println("--------------BAI 1--------------");
        // Define the locator format then apply to elements
        // Init format
        String FORM_H3_TEXT = "//h3[normalize-space()='%s']";
        String FORM_INPUT_PLACEHOLDER = "//input[@placeholder='%s']";
        String FORM_RADIO_CHECKBOX_DAT = "//input[@id='%s' and @type='%s']";
        String FORM_BUTTON_TEXT = "//button[normalize-space()='%s']";
        String FORM_TEXTAREA_ID = "//textarea[@id='%s']";

        // Find elements with dynamic locator
        //Title
        String lblTitleXpath = String.format(FORM_H3_TEXT,"Form đăng ký sinh viên");
        mWebDriver.findElement(By.xpath(lblTitleXpath));

        String lblResTitleXpath = String.format(FORM_H3_TEXT,"Thông tin bạn đã nhập:");
        mWebDriver.findElement(By.xpath(lblResTitleXpath));

        //TEXT BOX
        String txtFirstNameXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your first name");
        WebElement txtFirstNameEle = mWebDriver.findElement(By.xpath(txtFirstNameXpath));
        txtFirstNameEle.clear();
        action.sendKeys(txtFirstNameEle, "Kim").perform();

        String txtLastNameXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your last name");
        WebElement txtLastNameEle = mWebDriver.findElement(By.xpath(txtLastNameXpath));
        txtLastNameEle.clear();
        action.sendKeys(txtLastNameEle, "Chi").perform();

        String txtEmailXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your email");
        WebElement txtEmailEle = mWebDriver.findElement(By.xpath(txtEmailXpath));
        txtEmailEle.clear();
        action.sendKeys(txtEmailEle, "vukimchi023@gmail.com").perform();

        String txtPhoneXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your mobile number");
        WebElement txtPhoneEle = mWebDriver.findElement(By.xpath(txtPhoneXpath));
        txtPhoneEle.clear();
        action.sendKeys(txtPhoneEle, "0374975400").perform();

        String txtSubjectXpath = String.format(FORM_INPUT_PLACEHOLDER,"Enter your subjects");
        WebElement txtSubjectEle = mWebDriver.findElement(By.xpath(txtSubjectXpath));
        txtSubjectEle.clear();
        action.sendKeys(txtSubjectEle, "Automation Test").perform();

        //RADIO BUTTON
        String radioMaleXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"male","radio");
        WebElement radioMaleEle = mWebDriver.findElement(By.xpath(radioMaleXpath));
        boolean radioMaleIsSelect = radioMaleEle.isSelected();
        if(!radioMaleIsSelect) {
            action.click(radioMaleEle).perform();
            System.out.println("Radio button Male is select: " + radioMaleEle.isSelected());
        }

        String radioFemaleXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"female","radio");
        WebElement radioFemaleEle = mWebDriver.findElement(By.xpath(radioFemaleXpath));
        boolean radioFemaleIsSelect = radioFemaleEle.isSelected();
        if(!radioFemaleIsSelect) {
            action.click(radioFemaleEle).perform();
            System.out.println("Radio button Female is select: " + radioFemaleEle.isSelected());
        }

        //CHECK BOX
        String chkReadingXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"reading","checkbox");
        WebElement chkReadingEle = mWebDriver.findElement(By.xpath(chkReadingXpath));
        boolean chkReadingIsSelect = chkReadingEle.isSelected();
        if(!chkReadingIsSelect) {
            action.click(chkReadingEle).perform();
        }

        String chkSportsXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"sports","checkbox");
        WebElement chkSportsEle = mWebDriver.findElement(By.xpath(chkSportsXpath));
        boolean chkSportsIsSelect = chkSportsEle.isSelected();
        if(!chkSportsIsSelect) {
            action.click(chkSportsEle).perform();
        }

        String checkboxMusicXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"music","checkbox");
        WebElement chkMusicEle = mWebDriver.findElement(By.xpath(checkboxMusicXpath));
        boolean chkMusicIsSelect = chkMusicEle.isSelected();
        if(!chkMusicIsSelect) {
            action.doubleClick(chkMusicEle).perform();
        }

        //BIRTHDAY
        String datXpath = String.format(FORM_RADIO_CHECKBOX_DAT,"dob","date");
        WebElement datXpathEle = mWebDriver.findElement(By.xpath(datXpath));
        datXpathEle.clear();
        action.sendKeys(datXpathEle, "18102000").perform();

        //TEXTAREA
        String textareaAddressXpath = String.format(FORM_TEXTAREA_ID,"address");
        WebElement textareaAddressEle = mWebDriver.findElement(By.xpath(textareaAddressXpath));
        textareaAddressEle.clear();
        action.sendKeys(textareaAddressEle, "Ha Noi").perform();

        //BUTTON SUBMIT
        String btnSubmitXpath = String.format(FORM_BUTTON_TEXT,"Submit");
        WebElement btnSubmitEle = mWebDriver.findElement(By.xpath(btnSubmitXpath));
        action.click(btnSubmitEle).perform();

        //TEXTAREA RESULT
        String textareaResXpath = String.format(FORM_TEXTAREA_ID,"outputTextStudent");
        WebElement textareaResEle = mWebDriver.findElement(By.xpath(textareaResXpath));
        String result = textareaResEle.getAttribute("value");
        System.out.println("Information: " + result);

        //BUTTON RESET
        String btnResetXpath = String.format(FORM_BUTTON_TEXT,"Clear");
        WebElement btnResetEle = mWebDriver.findElement(By.xpath(btnResetXpath));
        action.click(btnResetEle);

        waitForDebug(2000);
    }

    @Test(description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);
        Actions action = new Actions(mWebDriver);

        // Handle your code here
        System.out.println("--------------BAI 2--------------");
        // Define the locator format then apply to elements
        // Init format
        String FORM_INPUT_ID = "//input[@id='%s']";

        // Find elements with dynamic locator
        //TEXT BOX
        String txtAccount = String.format(FORM_INPUT_ID,"normal_login_username");
        WebElement txtAccountEle = mWebDriver.findElement(By.xpath(txtAccount));
        txtAccountEle.clear();
        action.sendKeys(txtAccountEle, "admin_com_role").perform();

        String txtPass = String.format(FORM_INPUT_ID,"normal_login_password");
        WebElement txtPassEle = mWebDriver.findElement(By.xpath(txtPass));
        txtPassEle.clear();
        action.sendKeys(txtPassEle, "aA12345678@").perform();

        //BUTTON SUBMIT
        String btnSubmit = "//button[@type='submit']";
        WebElement btnSubmitEle = mWebDriver.findElement(By.xpath(btnSubmit));
        action.click(btnSubmitEle).perform();
        waitForDebug(5000);

        //MENU PRODUCT
        String mnuProduct = "//div[@class='flex items-center']//div[normalize-space()='Sản phẩm']";
        WebElement mnuProductEle = mWebDriver.findElement(By.xpath(mnuProduct));
        action.moveToElement(mnuProductEle).click().build().perform();

        //SEARCH PRODUCT
        String txtSearch = "//input[@class='ant-input css-16pw25h h-8']";
        WebElement txtSearchEle = mWebDriver.findElement(By.xpath(txtSearch));
        txtSearchEle.clear();
        action.sendKeys(txtSearchEle, "Tivi").perform();

        //BUTTON SEARCH
        String btnSearch = "//button[@testek='btn-search']";
        WebElement btnSearchEle = mWebDriver.findElement(By.xpath(btnSearch));
        action.click(btnSearchEle).perform();
    }

    @Test(description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);
        Actions action = new Actions(mWebDriver);
        // Handle your code here
        System.out.println("--------------BAI 3--------------");
        // Define the locator format then apply to elements
        // Init format
        String FORM_INPUT_ID = "//div[@id='%s']";
        // Find elements with dynamic locator
        //CLICK ACCORDING 1
        String accordion1 = String.format(FORM_INPUT_ID,"accordion-header-1");
        WebElement accordion1Ele = mWebDriver.findElement(By.xpath(accordion1));
        action.click(accordion1Ele).perform();

        String accordion1Desc = String.format(FORM_INPUT_ID,"accordion-body-1");
        WebElement accordion1DescEle = mWebDriver.findElement(By.xpath(accordion1Desc));
        System.out.println("Mo ta cua Accordion 1: " + accordion1DescEle.getText());
        waitForDebug(2000);

        //CLICK ACCORDING 2
        String accordion2 = String.format(FORM_INPUT_ID,"accordion-header-2");
        WebElement accordion2Ele = mWebDriver.findElement(By.xpath(accordion2));
        action.click(accordion2Ele).perform();

        String accordion2Desc = String.format(FORM_INPUT_ID,"accordion-body-2");
        WebElement accordion2DescEle = mWebDriver.findElement(By.xpath(accordion2Desc));
        System.out.println("Mo ta cua Accordion 2: " + accordion2DescEle.getText());
        waitForDebug(2000);

        //CLICK ACCORDING 3
        String accordion3 = String.format(FORM_INPUT_ID,"accordion-header-3");
        WebElement accordion3Ele = mWebDriver.findElement(By.xpath(accordion3));
        action.click(accordion3Ele).perform();

        String accordion3Desc = String.format(FORM_INPUT_ID,"accordion-body-3");
        WebElement accordion3DescEle = mWebDriver.findElement(By.xpath(accordion3Desc));
        System.out.println("Mo ta cua Accordion 3: " + accordion3DescEle.getText());
        waitForDebug(2000);

        //DOUBLE CLICK
        action.doubleClick(accordion1Ele).perform();
        waitForDebug(2000);
        action.doubleClick(accordion2Ele).perform();
        waitForDebug(2000);
        action.doubleClick(accordion3Ele).perform();
        waitForDebug(2000);
    }

    @Test(description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);
        Actions action = new Actions(mWebDriver);
        // Handle your code here
        System.out.println("--------------BAI 4--------------");
        // Define the locator format then apply to elements
        // Init format
        String mnuList = "a[test-id^='menu']";
        // Find elements with dynamic locator
        List<WebElement> mnuListEle = mWebDriver.findElements(By.cssSelector(mnuList));
        //MENU
        for (WebElement menu : mnuListEle) {
            action.moveToElement(menu).perform();
            waitForDebug(2000);
            String menuText = menu.getText();
            System.out.println("Menu text: " + menuText);

            //SUB MENU
            String subMenuList = "a[test-id^='submenu']";
            // Find elements with dynamic locator
            List<WebElement> subMenuListEle = mWebDriver.findElements(By.cssSelector(subMenuList));
            for (WebElement subMenu : subMenuListEle) {
                String subMenuText = subMenu.getText();
                if (!subMenuText.isBlank()) {
                    System.out.println("Sub Menu text: " + subMenuText);
                }
            }
        }
    }

//    @Test(description = "Element Interaction: Hover")
//    public void testHover() {
//        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);
//        Actions actions = new Actions(mWebDriver);
//
//        //define list menu element
//        String mnuLstXPath = "//a[starts-with(@test-id,'menu')]";
//        List<WebElement> mnuEleLst = mWebDriver.findElements(By.xpath(mnuLstXPath));
//        for (WebElement menu : mnuEleLst) {
//            actions.moveToElement(menu).perform();
//            waitForDebug(5000);
//
//            String menuTitle = menu.getText();
//            System.out.print(menuTitle + ": ");
//
//            List<WebElement> subMenus = mWebDriver.findElements(By.xpath("//a[starts-with(@test-id,'submenu')]"));
//            if (!subMenus.isEmpty()) {
//                System.out.print("[");
//                for (int i = 0; i < subMenus.size(); i++) {
//                    System.out.print(subMenus.get(i).getText());
//                    if (i < subMenus.size() - 1) System.out.print(", ");
//                }
//                System.out.println("]");
//            } else {
//                System.out.println("[No submenu]");
//            }
//
//            waitForDebug(3000);
//
//        }
//
//    }

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
