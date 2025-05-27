package com.testek.study.lesson03.exercise;

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
        webDriver.manage().window().maximize(); // Set the window size to maximum
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
    public void findAdvanceLocatorWithCSS() {
        gotoTestWebsite();

        // Handle other elements similarly CSS Selector (với các loại contains, starts-with)

        // Header title TESTEK - KIỂM THỬ THỰC CHIẾN
        String lblTitleContainsCSS = "h2[test-id*= 'about'] > b";
        webDriver.findElement(By.cssSelector(lblTitleContainsCSS));
        String lblTittleStartCSS = "h2[test-id^= 'about'] > b";
        webDriver.findElement(By.cssSelector(lblTittleStartCSS));

        // Đào tạo API Testing, Performance Testing, Automation Testing
        String lblDBTitleContainsCSS = "h4[name*= 'name']";
        webDriver.findElement(By.cssSelector(lblDBTitleContainsCSS));
        String lblDBTittleStartCSS = "h4[name^= 'db-title']";
        webDriver.findElement(By.cssSelector(lblDBTittleStartCSS));

        // Website: https://testek.vn
        String lblWebsiteContainsCSS = "h4[test-id*= 'website']";
        webDriver.findElement(By.cssSelector(lblWebsiteContainsCSS));
        String lblWebsiteStartCSS = "h4[test-id^= 'db-web']";
        webDriver.findElement(By.cssSelector(lblWebsiteStartCSS));

        // https://testek.vn
        String linkWebsiteContainsCSS = "a[test-id*= 'website-link']";
        webDriver.findElement(By.cssSelector(linkWebsiteContainsCSS));
        String linkWebsiteStartCSS = "a[test-id^= 'db-website-l']";
        webDriver.findElement(By.cssSelector(linkWebsiteStartCSS));

        // Facebook: Testek - Kiểm thử thực chiến
        String lblFacebookContainsCSS = "h4[test-id*= 'face']";
        webDriver.findElement(By.cssSelector(lblFacebookContainsCSS));
        String lblFacebookStartCSS = "h4[test-id^= 'db-face']";
        webDriver.findElement(By.cssSelector(lblFacebookStartCSS));

        // Link face Testek - Kiểm thử thực chiến
        String linkFaceContainsCSS = "a[test-id*= 'facebook']";
        webDriver.findElement(By.cssSelector(linkFaceContainsCSS));
        String linkFaceStartCSS = "a[test-id^= 'db-facebook']";
        webDriver.findElement(By.cssSelector(linkFaceStartCSS));

        // Hotline: 083.286.8822 / Email: vntestek@gmail.com
        String lblContactContainsCSS = "h4[test-id*= 'contact']";
        webDriver.findElement(By.cssSelector(lblContactContainsCSS));
        String lblContactStartCSS = "h4[test-id^= 'db-con']";
        webDriver.findElement(By.cssSelector(lblContactStartCSS));

        // Image
        String imageContainsCSS = "img[test-id*= 'coffee']";
        webDriver.findElement(By.cssSelector(imageContainsCSS));
        String imageStartCSS = "img[test-id^= 'about-me']";
        webDriver.findElement(By.cssSelector(imageStartCSS));

        // API System: Swagger
        String lblAPIContainsCSS = "li[test-id*= 'api']";
        webDriver.findElement(By.cssSelector(lblAPIContainsCSS));
        String lblAPIStartCSS = "li[test-id^= 'db-api']";
        webDriver.findElement(By.cssSelector(lblAPIStartCSS));

        // Link Swagger
        String lblLinkAPIContainsCSS = "a[test-id*= 'api']";
        webDriver.findElement(By.cssSelector(lblLinkAPIContainsCSS));
        String lblLinkAPIStartCSS = "a[test-id^= 'db-api']";
        webDriver.findElement(By.cssSelector(lblLinkAPIStartCSS));

        // Automation Web: Product Management
        String lblAutoWebContainsCSS = "li[test-id*= 'auto']";
        webDriver.findElement(By.cssSelector(lblAutoWebContainsCSS));
        String lblAutoWebStartCSS = "li[test-id^= 'db-auto']";
        webDriver.findElement(By.cssSelector(lblAutoWebStartCSS));

        // Link Product Management
        String lblLinkAutoWebContainsCSS = "a[test-id*= 'auto']";
        webDriver.findElement(By.cssSelector(lblLinkAutoWebContainsCSS));
        String lblLinkAutoWebStartCSS = "a[test-id^= 'db-auto']";
        webDriver.findElement(By.cssSelector(lblLinkAutoWebStartCSS));

        // Admin: admin_com_role
        String lblAdminContainsCSS = "li[test-id*= 'admin']";
        webDriver.findElement(By.cssSelector(lblAdminContainsCSS));
        String lblAdminStartCSS = "li[test-id^= 'db-account-ad']";
        webDriver.findElement(By.cssSelector(lblAdminStartCSS));

        // User: user_com_role
        String lblUserContainsCSS = "li[test-id*= 'user']";
        webDriver.findElement(By.cssSelector(lblUserContainsCSS));
        String lblUserStartCSS = "li[test-id^= 'db-account-u']";
        webDriver.findElement(By.cssSelector(lblUserStartCSS));

        // Guest: guest_com_role
        String lblGuestContainsCSS = "li[test-id*= 'guest']";
        webDriver.findElement(By.cssSelector(lblGuestContainsCSS));
        String lblGuestStartCSS = "li[test-id^= 'db-account-g']";
        webDriver.findElement(By.cssSelector(lblGuestStartCSS));

        // HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!
        String lblTextContainsCSS = "h4[test-id*= 'about'] > b";
        webDriver.findElement(By.cssSelector(lblTextContainsCSS));
        String lblTextStartCSS = "h4[test-id^= 'about'] > b";
        webDriver.findElement(By.cssSelector(lblTextStartCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findAdvanceLocatorWithXPath() {
        gotoTestWebsite();

        // Full Name Component

        // Handle other elements similarly
        // Bao gồm: contains, start-with, text(), ancestor, descendant, sibling, following, preceding

        // Header title TESTEK - KIỂM THỬ THỰC CHIẾN
        String lblTittleContainsXPath = "//h2[contains(@test-id, 'about')]/b";
        webDriver.findElement(By.xpath(lblTittleContainsXPath));
        String lblTittleStartXPath = "//h2[starts-with(@test-id, 'about')]/b";
        webDriver.findElement(By.xpath(lblTittleStartXPath));

        // Đào tạo API Testing, Performance Testing, Automation Testing
        String lblDBTitleTextXPath = "//h4[text() ='Đào tạo API Testing, Performance Testing, Automation Testing']";
        webDriver.findElement(By.xpath(lblDBTitleTextXPath));
        String lblDBTitleDescendantXPath = "//div[@test-id = 'about-me-grid']/descendant::h4[@test-id='db-title']";
        webDriver.findElement(By.xpath(lblDBTitleDescendantXPath));

        // Website: https://testek.vn
        String lblWebsitePreSibXPath = "//h4[@test-id = 'db-discord']/preceding-sibling::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblWebsitePreSibXPath));
        String lblWebsiteFloSibXpath = "//h4[@test-id = 'db-title']/following-sibling::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblWebsiteFloSibXpath));

        // https://testek.vn
        String linkWebsiteFloXPath = "//h4[@test-id = 'db-title']/following::a[@test-id='db-website-link']";
        webDriver.findElement(By.xpath(linkWebsiteFloXPath));
        String linkWebsitePreXPath = "//h4[@test-id = 'db-facebook']/preceding::a[@test-id='db-website-link']";
        webDriver.findElement(By.xpath(linkWebsitePreXPath));

        // Facebook: Testek - Kiểm thử thực chiến
        String lblFaceAncestorXPath = "//a[@test-id='db-facebook-link']/ancestor::h4";
        webDriver.findElement(By.xpath(lblFaceAncestorXPath));
        String lblFaceParentXPath = "//a[@test-id='db-facebook-link']/parent::h4";
        webDriver.findElement(By.xpath(lblFaceParentXPath));

        // Link face Testek - Kiểm thử thực chiến
        String linkFaceChildXPath = "//h4[@test-id='db-facebook']/child::a";
        webDriver.findElement(By.xpath(linkFaceChildXPath));
        String linkFaceTextXPath = "//a[normalize-space()='Testek - Kiểm thử thực chiến']";
        webDriver.findElement(By.xpath(linkFaceTextXPath));

        // Hotline: 083.286.8822 / Email: vntestek@gmail.com
        String lblContactContainsXPath = "//h4[contains(@test-id, 'contact')]";
        webDriver.findElement(By.xpath(lblContactContainsXPath));
        String lblContactFloSilConXPath = "//h4[contains(@test-id, 'facebook')]/following-sibling::h4[contains(@test-id, 'contact')]";
        webDriver.findElement(By.xpath(lblContactFloSilConXPath));

        // Image
        String imageChildXPath = "//div[@test-id='about-me-grid-item-coffee']/child::img";
        webDriver.findElement(By.xpath(imageChildXPath));
        String imagePreXPath = "//h4[@test-id='about-me-separator']/preceding::img";
        webDriver.findElement(By.xpath(imagePreXPath));

        // API System: Swagger
        String lblAPIParentXPath = "//a[@test-id='db-api-system-link']/parent::li";
        webDriver.findElement(By.xpath(lblAPIParentXPath));
        String lblAPIPreSibXPath = "//li[@test-id='db-automation-web']/preceding-sibling::li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(lblAPIPreSibXPath));

        // Link Swagger
        String linkSwaggerDescendantXPath = "//ul[@test-id='db-systems-list']/descendant::a";
        webDriver.findElement(By.xpath(linkSwaggerDescendantXPath));
        String linkSwaggerStartXPath = "//a[contains(@test-id, 'db-api')]";
        webDriver.findElement(By.xpath(linkSwaggerStartXPath));

        // Web Element: Basic Web Elements
        String lblEleAncestorXPath = "//a[@test-id = 'db-web-element-link']/ancestor::li";
        webDriver.findElement(By.xpath(lblEleAncestorXPath));
        String lblEleFloSibXPath = "//li[@test-id = 'db-api-system']/following-sibling::li[@test-id = 'db-web-element']";
        webDriver.findElement(By.xpath(lblEleFloSibXPath));

        // Link Basic Web Elements
        String linkEleTextXPath = "//a[text() = ' Basic Web Elements']";
        webDriver.findElement(By.xpath(linkEleTextXPath));
        String linkEleFolXPath = "//a[text() = 'Product Management']/following::a[@test-id = 'db-web-element-link']";
        webDriver.findElement(By.xpath(linkEleFolXPath));

        // Admin: admin_com_role
        String lblAdminChildXPath = "//ul[@test-id = 'db-account-list']/child::li[@test-id = 'db-account-admin']";
        webDriver.findElement(By.xpath(lblAdminChildXPath));
        String lblAdminContainsXPath = "//li[contains(@test-id,'admin')]";
        webDriver.findElement(By.xpath(lblAdminContainsXPath));

        // User: user_com_role
        String lblUserPreSibXPath = "//li[@test-id = 'db-account-guest']/preceding-sibling::li[contains(@test-id,'user')]";
        webDriver.findElement(By.xpath(lblUserPreSibXPath));
        String lblUserFolSibXPath = "//li[@test-id = 'db-account-admin']/following-sibling::li[contains(@test-id,'user')]";
        webDriver.findElement(By.xpath(lblUserFolSibXPath));

        // Guest: guest_com_role
        String lblGuestPreXPath = "//h4[@test-id = 'about-me-web-elements']/preceding::li[@test-id = 'db-account-guest']";
        webDriver.findElement(By.xpath(lblGuestPreXPath));
        String lblGuestFloXPath = "//li[@test-id = 'db-web-element']/following::li[@test-id = 'db-account-guest']";
        webDriver.findElement(By.xpath(lblGuestFloXPath));

        // HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!
        String lblTextStartXPath = "//h4[starts-with(@test-id, 'about-me-web')]/b";
        webDriver.findElement(By.xpath(lblTextStartXPath));
        String lblTextPreSibXPath = "//h4[@test-id = 'about-me-separator']/preceding-sibling::h4";
        webDriver.findElement(By.xpath(lblTextPreSibXPath));

        String text = "//input[@test-id = 'textbox-form-input-%s')]";
        String editText = String.format(text, "address");
        System.out.println(editText);
        //input[@test-id = 'textbox-form-input-%s')]
        //button[@test-id = 'textbox-form-%s')]
        //textarea[@test-id = 'textbox-form-output']
        //h3[normalize-space() = '%s']
        //label[@test-id = 'textbox-form-label-%s']
    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
