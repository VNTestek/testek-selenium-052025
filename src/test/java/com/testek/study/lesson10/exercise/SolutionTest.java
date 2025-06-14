package com.testek.study.lesson10.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static java.lang.Thread.sleep;

@Getter
@Setter
@Slf4j
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;
    private WebDriverWait wait;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(mWebDriver)) mWebDriver.quit();
    }

    @Test(priority = 1, description = "Login > Dashboard > Sản phẩm")
    public void testDemo() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);
        Actions action = new Actions(mWebDriver);

        // Define the locator format then apply to elements
        //TEXT BOX
        String txtAccount = "normal_login_username";
        inputValue(txtAccount, "admin_com_role", "username");

        String txtPass = "normal_login_password";
        sendKeys(By.id(txtPass),"aA12345678@", "Text box Password", true);

        //BUTTON SUBMIT
        String btnSubmit = "//button[@type='submit']";
        clickOnEle(By.xpath(btnSubmit), "Button Submit");

        //MENU PRODUCT
        String mnuProduct = "//div[@class='flex items-center']//div[normalize-space()='Sản phẩm']";
        clickTo(mnuProduct, "Button San pham");

        //BUTTON ADD PRODUCT
        String btnAddProduct = "//span[normalize-space()='Thêm sản phẩm']";
        clickTo(btnAddProduct, "Button Them San pham");

        //DROP LIST DANH MUC
        String drpCate = "form_item_category";
        String optionCate = "//td[normalize-space()='Máy giặt']";
        selectOption(drpCate, optionCate, "Danh muc");

        //TEXT BOX MA
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String yourName = "KIM CHI";

        String txtId = "form_item_code";
        String valueId = "AUTO202505_LG_" + yourName + "_" + timeStamp;
        inputValue(txtId, valueId, "Text box ma SP");

        //TEXT BOX TEN SP
        String txtName = "form_item_name";
        String valueName = "Máy giặt AUTO202505_LG_" + yourName + "_" + timeStamp;
        inputValue(txtName, valueName, "Text box ten SP");

        //TEXT BOX MO TA
        String txtDesc = "form_item_description";
        String valueDesc = "Máy giặt LG - Được xây dựng bởi AUTO202505_LG_" + yourName + "_" + timeStamp;
        sendKeys(By.id(txtDesc), valueDesc, "Text box Mo ta",true);

        //TEXT BOX GIA
        String txtPrice = "form_item_price";
        sendKeys(By.id(txtPrice), "10000000", "Text box Gia", true);

        //DROP LIST NCC
        String drpSupplier = "form_item_supplier";
        String optionSupplier = "//td[normalize-space()='LG VietNam']";
        selectOption(drpSupplier, optionSupplier, "Nha cung cap");

        //TEXT BOX DON VI TINH
        String txtUnit = "form_item_unit";
        inputValue(txtUnit, "Chiếc", "Text box don vi tinh");

        //TEXT BOX SO LUONG
        String txtQuantity = "form_item_quantity";
        inputValue(txtQuantity, "10", "Text box so luong");

        //BUTTON ADD
        String btnAdd = "//button[@testek='btn-add']";
        clickOnEle(By.xpath(btnAdd), "Click on button Add");

        //In thong tin
        String txtProductId = "//input[@placeholder='Mã sản phẩm']";
        String textareaError = "//textarea[@data-v-0367fd5e='']";
        printInfo(By.xpath(txtProductId), "Mo ta");
        printInfo(By.xpath(textareaError), "Error message");
    }

    /**
     * Wait for element visible
     */
    private WebElement waitForEleVisible(By by, String title) {
        log.info("Wait for element [{}] visible: [{}]", title, by);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (Exception e) {
            log.error("Element [{}] not found or timeout: [{}]", title, by, e);
            throw new RuntimeException("Failed to find element [{}]: [{}]" + title + by, e);
        }
    }

    /**
     * Send keys to element
     */
    //C1: Send Keys
    private void inputValue(String id, String value, String title) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.clear();
        element.sendKeys(value);
        log.info("Input: [{}] to [{}]", value, title);
    }

    //C2: Send Keys
    private WebElement sendKeys(By by, String text, String title, boolean isClear) {
        WebElement element = waitForEleVisible(by, title);
        if (element == null) {
            log.error("Element [{}] not found [{}]", title, by);
            throw new RuntimeException("Cannot send keys to null element [{}]: [{}]" + title + by);
        }
        if (isClear){
            element.clear();
        }
        element.sendKeys(text);
        log.info("Send keys to element [{}]: [{}] with text: [{}]", title, by, text);
        return element;
    }

    /**
     * Wait for element clickable
     */
    private WebElement waitForEleClickable(By by, String title) {
        waitForEleVisible(by, title);
        log.info("Waiting for element [{}] clickable: [{}]", title, by);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        }
        catch (Exception e) {
            log.error("Cannot click this element [{}]: [{}]", title, by, e);
            throw new RuntimeException("Click this element [{}] failed: [{}]" + title + by, e);
        }
    }

    /**
     * Click on element
     */
    //C1:
    private WebElement clickOnEle(By by, String title) {
        WebElement element = waitForEleClickable(by, title);
        element.click();
        log.info("Click on element [{}] successful: [{}]", title, by);
        return element;
    }

    //C2:
    private void clickTo(String xpath, String title) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.click();
        log.info("Click to: [{}]", title);
    }

    /**
     * Select option
     */
    private void selectOption(String drpId, String optionXpath, String title) {
        WebElement drpEle = waitForEleVisible(By.id(drpId), title);
        drpEle.click(); //Mở drop list

        // Đợi option hiển thị rồi click
        WebElement optionEle = waitForEleVisible(By.xpath(optionXpath), title);
        optionEle.click(); //Chon option
        log.info("Selected [{}] là [{}]", title, optionEle.getText());
    }

    /**
     * Log information
     */
    private WebElement printInfo(By by, String title) {
        WebElement element = waitForEleVisible(by, title);
        waitForDebug(3000);
        log.info("Information [{}] la [{}]",title,element.getAttribute("value"));
        return element;
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to @link{Menu#FORM} navigation
     */
    @Test(description = "Element Interaction")
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Handle your code here
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
