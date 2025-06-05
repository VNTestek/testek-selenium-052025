package com.testek.study.lesson07.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

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

    }

    @Test(description = "Element Interaction: Small Frame")
    public void testSmallFrame() {
        System.out.println("--------------------BÀI 1--------------------");
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);
        //Tim kiem frame
        String frmSmallId = "small-frame";
        WebElement frmSmallIdEle = mWebDriver.findElement(By.id(frmSmallId));
        //Chuyen sang small frame
        mWebDriver.switchTo().frame(frmSmallIdEle);
        //Tim kiem title cua small frame
        String lblFrmTitle = "//h1[text()='This is a Small Frame']";
        WebElement lblFrmTitleEle = mWebDriver.findElement(By.xpath(lblFrmTitle));
        System.out.println("Title small frame: " + lblFrmTitleEle.getText());
        //Tim kiem description cua small frame
        WebElement lblFrmDescEle = mWebDriver.findElement(By.tagName("p"));
        String lblFrmDescText = lblFrmDescEle.getAttribute("outerText");
        System.out.println("Description small frame: " + lblFrmDescText);
    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        System.out.println("--------------------BÀI 3--------------------");
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);
        //Tim kiem button Simple Alert
        String btnSimpleAlert = "simpleAlert";
        WebElement btnSimpleAlertEle = mWebDriver.findElement(By.id(btnSimpleAlert));
        //Click button
        btnSimpleAlertEle.click();
        //Chuyen sang alert
        Alert simpleAlert = mWebDriver.switchTo().alert();
        //In ra text alert
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        //Accept alert
        simpleAlert.accept();

        //Tim kiem button Confirm Alert
        String btnConfirmAlert = "confirmAlert";
        WebElement btnConfirmAlertEle = mWebDriver.findElement(By.id(btnConfirmAlert));
        //Click button
        btnConfirmAlertEle.click();
        //Chuyen sang Alert
        Alert confirmAlert = mWebDriver.switchTo().alert();
        //In ra text alert
        System.out.println("Confirm ALert text: " + confirmAlert.getText());
        //Cancel alert
        confirmAlert.dismiss();

        //Tim kiem button Prompt Alert
        String btnPromptAlert = "promptAlert";
        WebElement btnPromptAlertEle = mWebDriver.findElement(By.id(btnPromptAlert));
        //Click button
        btnPromptAlertEle.click();
        //Chuyen sang Alert
        Alert promptAlert = mWebDriver.switchTo().alert();
        //In ra text alert
        System.out.println("Prompt ALert text: " + promptAlert.getText());
        //Nhap text vào alert
        promptAlert.sendKeys("Kim Chi");
        //Accept alert
        promptAlert.accept();

        //Tim kiem button Timed Alert
        String btnTimedAlert = "timedAlert";
        WebElement btnTimedAlertEle = mWebDriver.findElement(By.id(btnTimedAlert));
        //Click button
        btnTimedAlertEle.click();
        // Chờ alert xuất hiện
        waitForDebug(5000);
//        WebDriverWait wait = new WebDriverWait(mWebDriver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.alertIsPresent());
        //Chuyen sang Alert
        Alert timedAlert = mWebDriver.switchTo().alert();
        //In ra text alert
        System.out.println("TImed ALert text: " + timedAlert.getText());
        //Accept alert
        timedAlert.accept();
    }

    @Test(description = "Element Interaction: Window and Tab")
    public void testPracticeWindow() {
        System.out.println("--------------------BÀI 2--------------------");
        String url = "https://testek.vn/lab/auto/web-elements/";
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.WINDOWS);

        //Danh sach sub-menu
        String[] subMenuList = {
                "#browser-windows",
                "#alerts",
                "#frames",
                "#nested-frames",
                "#modal-dialogs",
        };

        //1. Mở các sub-menu trong tab mới
        for (String subMenu : subMenuList) {
            WebDriver newTab = mWebDriver.switchTo().newWindow(WindowType.TAB);
            newTab.get(url + subMenu);
        }
        waitForDebug(2000);

        //2. Mở trong windows mới (mỗi windows đều có chứa 2 tab: Home và Tab được mở từ menu)
        for (String menu : subMenuList) {
            //Mở tab Home trong window mới
            WebDriver newWindow = mWebDriver.switchTo().newWindow(WindowType.WINDOW);
            newWindow.get(url); // Home
            //Mở sub-menu sang tab mới trong window mới
            WebDriver secondTab = mWebDriver.switchTo().newWindow(WindowType.TAB);
            secondTab.get(url + menu); // submenu
        }
        waitForDebug(2000);

        //3. Thực hiện switch các tab về home page
        Set<String> windowHandles = mWebDriver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            mWebDriver.switchTo().window(windowHandle);
            mWebDriver.get(url);
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
