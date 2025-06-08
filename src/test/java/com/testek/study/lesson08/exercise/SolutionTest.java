package com.testek.study.lesson08.exercise;

import com.testek.study.common.Menu;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

@Slf4j
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
        mWebDriver.manage().window().maximize();
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
    @Test(description = "BT1: Element Interaction: Student Form")
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Declare Dynamic XPath
        String DYNAMIC_TITLE_TEXT = "//h3[@test-id='%s']";
        String DYNAMIC_LABEL_TEXT = "//label[@test-id='%s']";
        String DYNAMIC_INPUT_TEXT = "//input[@test-id = '%s']";
        String DYNAMIC_TEXTAREA_INPUT = "//textarea[@id='%s']";
        String DYNAMIC_BUTTON_TEXT = "//button[@id='%s']";

        // Verify text title form is displayed
        String tblTitleXPath = String.format(DYNAMIC_TITLE_TEXT, "student-registration-title");
        WebElement tblTitleEle = mWebDriver.findElement(By.xpath(tblTitleXPath));
        Assert.assertTrue(tblTitleEle.isDisplayed(), "First Name label is not displayed");
        Assert.assertEquals(tblTitleEle.getText(), "Form đăng ký sinh viên", "Title text is not correct");

        // Verify all labels are displayed
        String[] labelIds = {
                "label-firstName", "label-lastName", "label-email", "label-email", "label-gender",
                "label-mobile", "label-dob", "label-subjects", "label-hobbies", "label-address",
        };
        for (String labelId : labelIds) {
            String labelXPath = String.format(DYNAMIC_LABEL_TEXT, labelId);
            WebElement labelEle = mWebDriver.findElement(By.xpath(labelXPath));
            Assert.assertTrue(labelEle.isDisplayed(), labelId + " is not displayed");
        }

        // Verify submit info title Form is displayed
        String submitTitleXPath = String.format(DYNAMIC_TITLE_TEXT, "submitted-info-title");
        WebElement submitTitleEle = mWebDriver.findElement(By.xpath(submitTitleXPath));
        Assert.assertEquals(submitTitleEle.getText(), "Thông tin bạn đã nhập:");

        // Interact with element
        // 1. Input First Name
        String txtFistNameXPath = String.format(DYNAMIC_INPUT_TEXT, "input-firstName");
        WebElement txtFistNameEle = mWebDriver.findElement(By.xpath(txtFistNameXPath));
        txtFistNameEle.clear();
        txtFistNameEle.sendKeys("Lien");

        // 2. Input Last Name
        String txtLastNameXPath = String.format(DYNAMIC_INPUT_TEXT, "input-lastName");
        WebElement txtLastNameEle = mWebDriver.findElement((By.xpath(txtLastNameXPath)));
        txtLastNameEle.clear();
        txtLastNameEle.sendKeys("Bi");

        // 3. Input Email
        String txtEmailXPath = String.format(DYNAMIC_INPUT_TEXT, "input-email");
        WebElement txtEmailEle = mWebDriver.findElement((By.xpath(txtEmailXPath)));
        txtEmailEle.clear();
        txtEmailEle.sendKeys("lien@gmail.com");

        // 4. Select gender is male
        String rdoMaleXPath = String.format(DYNAMIC_LABEL_TEXT, "label-male");
        WebElement rdoMaleEle = mWebDriver.findElement((By.xpath(rdoMaleXPath)));
        rdoMaleEle.click();

        // 5. Input Phone
        String txtMobileXPath = String.format(DYNAMIC_INPUT_TEXT, "input-mobile");
        WebElement txtMobileEle = mWebDriver.findElement((By.xpath(txtMobileXPath)));
        txtMobileEle.clear();
        txtMobileEle.sendKeys("0387123123");

        // 6. Select date
        String datDobXPath = String.format(DYNAMIC_INPUT_TEXT, "input-dob");
        WebElement datDobEle = mWebDriver.findElement((By.xpath(datDobXPath)));
        datDobEle.click();
        datDobEle.sendKeys("06/01/2025");

        // 7. Input Subject
        String txtSubjectsXPath = String.format(DYNAMIC_INPUT_TEXT, "input-subjects");
        WebElement txtSubjectsEle = mWebDriver.findElement((By.xpath(txtSubjectsXPath)));
        txtSubjectsEle.clear();
        txtSubjectsEle.sendKeys("Subject test");

        // 8. Select hobbies
        String chkRedingXPath = String.format(DYNAMIC_LABEL_TEXT, "label-reading");
        String chkSportsXPath = String.format(DYNAMIC_LABEL_TEXT, "label-sports");
        String chkMusicXPath = String.format(DYNAMIC_LABEL_TEXT, "label-music");
        WebElement chkRedingXEle = mWebDriver.findElement((By.xpath(chkRedingXPath)));
        WebElement chkSportsEle = mWebDriver.findElement((By.xpath(chkSportsXPath)));
        WebElement chkMusicEle = mWebDriver.findElement((By.xpath(chkMusicXPath)));
        chkRedingXEle.click();
        chkSportsEle.click();
        chkMusicEle.click();

        //9. Input Address
        String txtAddressXPath = String.format(DYNAMIC_TEXTAREA_INPUT, "address");
        WebElement txtAddressEle = mWebDriver.findElement((By.xpath(txtAddressXPath)));
        txtAddressEle.clear();
        txtAddressEle.sendKeys("Hà nội");

        // 10. Submit
        String bntSubmitXPath = String.format(DYNAMIC_BUTTON_TEXT, "submit-button");
        WebElement bntSubmitEle = mWebDriver.findElement((By.xpath(bntSubmitXPath)));
        bntSubmitEle.click();

        // 11. Get info and verify
        String txaOutputTextXPath = String.format(DYNAMIC_TEXTAREA_INPUT, "outputTextStudent");
        WebElement txaOutputTextEle = mWebDriver.findElement((By.xpath(txaOutputTextXPath)));
        String actualText = txaOutputTextEle.getAttribute("value");
        System.out.println("Info Student: " + actualText);
        waitForDebug(5000);

        // Verify contain "First Name: Lien"
        Assert.assertTrue(actualText.contains("First Name: Lien"),
                "Not found line First Name in output"
        );

        // Verify contain "Last Name: Lien"
        Assert.assertTrue(
                actualText.contains("Last Name: Bi"),
                "Not found line Last Name in output"
        );

        // Verify contain "Email: lien@gmail.com"
        Assert.assertTrue(
                actualText.contains("Email: lien@gmail.com"),
                "Not found line Email in output"
        );

        // Verify contain "Subjects: Subject test"
        Assert.assertTrue(
                actualText.contains("Subjects: Subject test"),
                "Not found line Subjects in output"
        );

        // Verify contain "Address: Hà nội"
        Assert.assertTrue(
                actualText.contains("Address: Hà nội"),
                "Not found line Address in output"
        );

        System.out.println("All fields have been verified successfully!!");

    }

    @Test(description = "BT2: Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

        // Declare XPATH, Dynamic XPath
        String DYNAMIC_INPUT_TEXT = "//input[@id='%s']";
        String DYNAMIC_BUTTON_TEXT = "//span[text()='%s']";
        String txtSearchTextXPath = "//div/input[@placeholder='keyword']";
        String txtMenuProductsXPath = "//div[contains(@class,'menu') and normalize-space(.) = 'Sản phẩm']";

        // Login
        WebElement txtUsernameEle = mWebDriver.findElement(By.xpath(String.format(DYNAMIC_INPUT_TEXT, "normal_login_username")));
        txtUsernameEle.clear();
        txtUsernameEle.sendKeys("admin_com_role");
        waitForDebug(2000);
        WebElement txtPasswordEle = mWebDriver.findElement(By.xpath(String.format(DYNAMIC_INPUT_TEXT, "normal_login_password")));
        txtPasswordEle.clear();
        txtPasswordEle.sendKeys("aA12345678@");
        waitForDebug(2000);
        WebElement btnLoginEle = mWebDriver.findElement(By.xpath(String.format(DYNAMIC_BUTTON_TEXT, "Đăng nhập")));
        btnLoginEle.click();
        waitForDebug(2000);

        // Verify login success
        WebElement txtMenuProductsEle = mWebDriver.findElement(By.xpath(txtMenuProductsXPath));
        Assert.assertTrue(txtMenuProductsEle.isDisplayed(), "Menu Sản phẩm is not displayed");

        // Click on Products menu
        txtMenuProductsEle.click();
        waitForDebug(2000);

        // Input search text "Tivi"
        WebElement txtSearchEle = mWebDriver.findElement(By.xpath(txtSearchTextXPath));
        txtSearchEle.clear();
        txtSearchEle.sendKeys("Tivi");
        waitForDebug(2000);

        // Click on Search button
        WebElement btnSearchEle = mWebDriver.findElement(By.xpath(String.format(DYNAMIC_BUTTON_TEXT, "Tìm kiếm")));
        btnSearchEle.click();
        waitForDebug(5000);

        // Verify search results
        String searchResultXPath = "//tr[starts-with(@class, 'ant-table-row')]";
        List<WebElement> rows = mWebDriver.findElements(By.xpath(searchResultXPath));
        Assert.assertFalse(rows.isEmpty(), "No search results found");

        // Check each row contains the keyword "Tivi" in Name or Description
        String[] keywords = {"Tivi", "TV" };
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String tdNameCol = row.findElement(By.xpath(".//td[2]")).getText();
            String tdDescCol = row.findElement(By.xpath(".//td[3]")).getText();

            boolean isMatch = false;
            for (String keyword : keywords) {
                if (tdNameCol.toLowerCase().contains(keyword.toLowerCase()) || tdDescCol.toLowerCase().contains(keyword.toLowerCase())) {
                    isMatch = true;
                    break;
                }
            }
            System.out.println("Row " + (i + 1) + ": Match: " + isMatch + ": Name: " + tdNameCol + ", Description: " + tdDescCol);
            Assert.assertTrue(isMatch, "Result return in row " + (i + 1) + "does not contain 'Tivi' in Name or Description");

        }

    }

    @Test(description = "BT3: Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);

        // Declare Dynamic XPath
        String DYNAMIC_MENU_ITEM = "//div[@test-id='%s']";
        String DYNAMIC_TEXT_ITEM = "//div[@test-id='%s']/following-sibling::div";
        String accMenu1XPath = String.format(DYNAMIC_MENU_ITEM, "accordion-header-1");
        String accMenu2XPath = String.format(DYNAMIC_MENU_ITEM, "accordion-header-2");
        String accMenu3XPath = String.format(DYNAMIC_MENU_ITEM, "accordion-header-3");
        String ltbTextMenu1XPath = String.format(DYNAMIC_TEXT_ITEM, "accordion-header-1");
        String ltbTextMenu2XPath = String.format(DYNAMIC_TEXT_ITEM, "accordion-header-2");
        String ltbTextMenu3XPath = String.format(DYNAMIC_TEXT_ITEM, "accordion-header-3");

        // Create a new Actions
        Actions mActions = new Actions(mWebDriver);

        // Click: accordion-header-1
        WebElement accMenu1Ele = mWebDriver.findElement(By.xpath(accMenu1XPath));
        mActions.click(accMenu1Ele).perform();

        // Get text after the click
        WebElement ltbTextMenu1Ele = mWebDriver.findElement(By.xpath(ltbTextMenu1XPath));
        log.info("Text after click accordion-header-1: {}", ltbTextMenu1Ele.getText());

        // Double click: accordion-header-1
        mActions.doubleClick(ltbTextMenu1Ele).perform();
        log.info("Double click to close accordion: {}", ltbTextMenu1Ele.getText());
        waitForDebug(5000);

        // Click: accordion-header-2
        WebElement accMenu2Ele = mWebDriver.findElement(By.xpath(accMenu2XPath));
        mActions.click(accMenu2Ele).perform();

        // Get text after the click
        WebElement ltbTextMenu2Ele = mWebDriver.findElement(By.xpath(ltbTextMenu2XPath));
        log.info("Text after click accordion-header-1: {}", ltbTextMenu2Ele.getText());

        // Double click: accordion-header-2
        mActions.doubleClick(ltbTextMenu2Ele).perform();
        log.info("Double click to close accordion: {}", ltbTextMenu2Ele.getText());
        waitForDebug(5000);

        // Click: accordion-header-1 3
        WebElement accMenu3Ele = mWebDriver.findElement(By.xpath(accMenu3XPath));
        mActions.click(accMenu3Ele).perform();

        // Get text after the click
        WebElement ltbTextMenu3Ele = mWebDriver.findElement(By.xpath(ltbTextMenu3XPath));
        log.info("Text after click accordion-header-1: {}", ltbTextMenu3Ele.getText());

        // Double click: accordion-header-3
        mActions.doubleClick(ltbTextMenu3Ele).perform();
        log.info("Double click to close accordion: {}", ltbTextMenu3Ele.getText());
        waitForDebug(5000);
    }

    @Test(description = "BT4: Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);

        // Declare Dynamic XPath
        String DYNAMIC_MENU_ITEM = "//a[@test-id='%s']";
        String DYNAMIC_TOOLTIP_TEXT = "//a[@test-id='%s']/following-sibling::ul";

        String hoverHomeXPath = String.format(DYNAMIC_MENU_ITEM, "menu-link-home");
        String hoverServicesXPath = String.format(DYNAMIC_MENU_ITEM, "menu-link-services");
        String hoverAboutXPath = String.format(DYNAMIC_MENU_ITEM, "menu-link-about");
        String hoverContactXPath = String.format(DYNAMIC_MENU_ITEM, "menu-link-contact");

        String toolTipServicesXPath = String.format(DYNAMIC_TOOLTIP_TEXT, "menu-link-services");
        String toolTipContactXPath = String.format(DYNAMIC_TOOLTIP_TEXT, "menu-link-contact");

        // Create a new Actions
        Actions mActions = new Actions(mWebDriver);

        // Hover over: Home
        WebElement hoverHomeEle = mWebDriver.findElement(By.xpath(hoverHomeXPath));
        mActions.moveToElement(hoverHomeEle).perform();
        waitForDebug(2000);

        // Hover over: menu-link-services
        WebElement hoverServicesEle = mWebDriver.findElement(By.xpath(hoverServicesXPath));
        mActions.moveToElement(hoverServicesEle).perform();
        waitForDebug(2000);

        // Print tooltip text for Services
        WebElement toolTipServicesEle = mWebDriver.findElement(By.xpath(toolTipServicesXPath));
        System.out.println("Tooltip for Services: " + toolTipServicesEle.getText());
        waitForDebug(2000);

        // Hover over: menu-link-about
        WebElement hoverAboutEle = mWebDriver.findElement(By.xpath(hoverAboutXPath));
        mActions.moveToElement(hoverAboutEle).perform();
        waitForDebug(2000);

        // Hover over: menu-link-contact
        WebElement hoverContactEle = mWebDriver.findElement(By.xpath(hoverContactXPath));
        mActions.moveToElement(hoverContactEle).perform();
        waitForDebug(2000);

        // Print tooltip text for Contact
        WebElement toolTipContactEle = mWebDriver.findElement(By.xpath(toolTipContactXPath));
        System.out.println("Tooltip for Contact: " + toolTipContactEle.getText());
        waitForDebug(2000);

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
