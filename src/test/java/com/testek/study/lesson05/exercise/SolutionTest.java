package com.testek.study.lesson05.exercise;

import com.testek.study.common.Menu;
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


    @Test(description = "Find element with CSS")
    public void findBasicLocatorWithCSS() {
        gotoTestWebsite();

        // Handle other elements similarly

    }

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

        // Handle other elements similarly

    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();

        // title TESTEK - KIỂM THỬ THỰC CHIẾN
        String lblTitleContainsCSS = "h2[test-id*= 'about'] > b";
        webDriver.findElement(By.cssSelector(lblTitleContainsCSS));
        String lblTittleStartCSS = "h2[test-id^= 'about'] > b";
        webDriver.findElement(By.cssSelector(lblTittleStartCSS));

        // Đào tạo API Testing, Performance Testing, Automation Testing
        String lblTrainingTitleContainsCSS = "h4[name*= 'name']";
        webDriver.findElement(By.cssSelector(lblTrainingTitleContainsCSS));
        String lblTittleStartWithCSS = "h4[name^= 'db-title']";
        webDriver.findElement(By.cssSelector(lblTittleStartWithCSS));

        // https://testek.vn
        String lblWebContainsCSS = "h4[test-id*= 'website']";
        webDriver.findElement(By.cssSelector(lblWebContainsCSS));
        String lblWebStartWithCSS = "h4[test-id^= 'db-web']";
        webDriver.findElement(By.cssSelector(lblWebStartWithCSS));

        // https://testek.vn
        String linkWebsiteContainsCSS = "a[test-id*= 'website-link']";
        webDriver.findElement(By.cssSelector(linkWebsiteContainsCSS));
        String linkWebsiteStartWithCSS = "a[test-id^= 'db-website-l']";
        webDriver.findElement(By.cssSelector(linkWebsiteStartWithCSS));

        // Facebook: Testek - Kiểm thử thực chiến
        String lblFbContainsCSS = "h4[test-id*= 'face']";
        webDriver.findElement(By.cssSelector(lblFbContainsCSS));
        String lblFbStartWithCSS = "h4[test-id^= 'db']";
        webDriver.findElement(By.cssSelector(lblFbStartWithCSS));

        // Link face Testek - Kiểm thử thực chiến
        String linkFaceContainsCSS = "a[test-id*= 'facebook']";
        webDriver.findElement(By.cssSelector(linkFaceContainsCSS));
        String linkFaceStartWithCSS = "a[test-id^= 'db-facebook']";
        webDriver.findElement(By.cssSelector(linkFaceStartWithCSS));

        // Hotline: 083.286.8822 / Email: vntestek@gmail.com
        String lblContactContainsCSS = "h4[test-id*= 'contact']";
        webDriver.findElement(By.cssSelector(lblContactContainsCSS));
        String lblContactStartCSS = "h4[test-id^= 'db-con']";
        webDriver.findElement(By.cssSelector(lblContactStartCSS));

        // Img
        String imgContainsCSS = "img[test-id*= 'coffee']";
        webDriver.findElement(By.cssSelector(imgContainsCSS));
        String imgStartCSS = "img[test-id^= 'about-me']";
        webDriver.findElement(By.cssSelector(imgStartCSS));

        // Link Swagger
        String lblLinkAPIContainsCSS = "a[test-id*= 'api']";
        webDriver.findElement(By.cssSelector(lblLinkAPIContainsCSS));
        String lblLinkAPIStartCSS = "a[test-id^= 'db-api']";
        webDriver.findElement(By.cssSelector(lblLinkAPIStartCSS));

        // API System: Swagger
        String lblAPIContainsCSS = "li[test-id*= 'api']";
        webDriver.findElement(By.cssSelector(lblAPIContainsCSS));
        String lblAPIStartWithCSS = "li[test-id^= 'db-api']";
        webDriver.findElement(By.cssSelector(lblAPIStartWithCSS));


        // Automation Web: Product Management
        String lblAutoWebContainsCSS = "li[test-id*= 'auto']";
        webDriver.findElement(By.cssSelector(lblAutoWebContainsCSS));
        String lblAutoWebStartWithCSS = "li[test-id^= 'db-auto']";
        webDriver.findElement(By.cssSelector(lblAutoWebStartWithCSS));

        // Link Product Management
        String lblLinkAutoWebContainsCSS = "a[test-id*= 'auto']";
        webDriver.findElement(By.cssSelector(lblLinkAutoWebContainsCSS));
        String lblLinkAutoWebStartWithCSS = "a[test-id^= 'db-auto']";
        webDriver.findElement(By.cssSelector(lblLinkAutoWebStartWithCSS));

        // Admin: admin_com_role
        String lblAdminContainsCSS = "li[test-id*= 'admin']";
        webDriver.findElement(By.cssSelector(lblAdminContainsCSS));
        String lblAdminStartWithCSS = "li[test-id^= 'db-account-ad']";
        webDriver.findElement(By.cssSelector(lblAdminStartWithCSS));

        // User: user_com_role
        String lblUserContainsCSS = "li[test-id*= 'user']";
        webDriver.findElement(By.cssSelector(lblUserContainsCSS));
        String lblUserStartWithCSS = "li[test-id^= 'db-account-u']";
        webDriver.findElement(By.cssSelector(lblUserStartWithCSS));

        // Guest: guest_com_role
        String lblGuestContainsCSS = "li[test-id*= 'guest']";
        webDriver.findElement(By.cssSelector(lblGuestContainsCSS));
        String lblGuestStartWithCSS = "li[test-id^= 'db-account-g']";
        webDriver.findElement(By.cssSelector(lblGuestStartWithCSS));

        // HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!
        String lblTextContainsCSS = "h4[test-id*= 'about'] > b";
        webDriver.findElement(By.cssSelector(lblTextContainsCSS));
        String lblTextStartWithCSS = "h4[test-id^= 'about'] > b";
        webDriver.findElement(By.cssSelector(lblTextStartWithCSS));

    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.FORM.getName())));
        mnuElementEle.click();

        WebElement mnuEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.STUDENT_FORM.getName())));
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
