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

        // Handle other elements similarly

        //<h2 style="font-size: xx-large; color: #007bff;" test-id="about-me-title" xpath="1"><b>TESTEK - KIỂM THỬ THỰC CHIẾN</b></h2>
        String lblAboutMeTitleStartCSS = "h2[test-id^='about']";
        webDriver.findElement(By.cssSelector(lblAboutMeTitleStartCSS));

        String lblAboutMeTitleContainsCSS = "h2[test-id*='about-me']";
        webDriver.findElement(By.cssSelector(lblAboutMeTitleContainsCSS));

        //<h4 id="db-title-id" test-id="db-title" name="db-title-name" class="db-title-class" xpath="1">Đào tạo API Testing, Performance Testing, Automation Testing</h4>
        String lblDbTitleStartCSS = "h4[name^='db-title']";
        webDriver.findElement(By.cssSelector(lblDbTitleStartCSS));

        String lblDbTitleContainsCSS = "h4[name*='db-title']";
        webDriver.findElement(By.cssSelector(lblDbTitleContainsCSS));

        //<h4 test-id="db-website" xpath="1">Website: <a href="https://testek.vn" target="_blank" test-id="db-website-link">https://testek.vn</a></h4>
        String lblWebsiteStartCSS = "h4[test-id^='db-website']";
        webDriver.findElement(By.cssSelector(lblWebsiteStartCSS));

        String lblWebsiteContainsCSS = "h4[test-id*='website']";
        webDriver.findElement(By.cssSelector(lblWebsiteContainsCSS));

        //<h4 test-id="db-discord" id="db-discord" xpath="1">Discord: <a href="https://discord.gg/jC7ZtmvuDX" target="_blank" test-id="db-discord-link">Testek - Kiểm thử thực chiến</a></h4>
        String lblDiscordStartCSS = "h4[test-id^='db-discord']";
        webDriver.findElement(By.cssSelector(lblDiscordStartCSS));

        String lblDiscordContainsCSS = "h4[test-id*='discord']";
        webDriver.findElement(By.cssSelector(lblDiscordContainsCSS));

        //<h4 test-id="db-facebook" xpath="1">Facebook: <a href="https://www.facebook.com/share/g/15m67fr73k/" target="_blank" test-id="db-facebook-link">Testek - Kiểm thử thực chiến</a></h4>
        String lblFacebookStartCSS = "h4[test-id^='db-facebook']";
        webDriver.findElement(By.cssSelector(lblFacebookStartCSS));

        String lblFacebookContainsCSS = "h4[test-id*='facebook']";
        webDriver.findElement(By.cssSelector(lblFacebookContainsCSS));

        //<h4 test-id="db-contact" xpath="1">Hotline: 083.286.8822 / Email: vntestek@gmail.com</h4>
        String lblContactStartCSS = "h4[test-id^='db-contact']";
        webDriver.findElement(By.cssSelector(lblContactStartCSS));

        String lblContactContainsCSS = "h4[test-id*='contact']";
        webDriver.findElement(By.cssSelector(lblContactContainsCSS));

        //<h4 test-id="db-systems" xpath="1">Các hệ thống Testek cung cấp</h4>
        String lblSystemsStartCSS = "h4[test-id^='db-systems']";
        webDriver.findElement(By.cssSelector(lblSystemsStartCSS));

        String lblSystemsContainsCSS = "h4[test-id*='systems']";
        webDriver.findElement(By.cssSelector(lblSystemsContainsCSS));

        //<li test-id="db-api-system" xpath="1">API System: <a href="https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/" target="_blank" test-id="db-api-system-link">Swagger</a></li>
        String lblApiSystemStartCSS = "li[test-id^='db-api']";
        webDriver.findElement(By.cssSelector(lblApiSystemStartCSS));

        String lblApiSystemContainsCSS = "li[test-id*='api']";
        webDriver.findElement(By.cssSelector(lblApiSystemContainsCSS));

        //<li test-id="db-automation-web" xpath="1">Automation Web: <a href="https://testek.vn/lab/auto/login" target="_blank" test-id="db-automation-web-link">Product Management</a></li>
        String lblAutomationWebStartCSS ="li[test-id^='db-automation-web']";
        webDriver.findElement(By.cssSelector(lblAutomationWebStartCSS));

        String lblAutomationWebContainsCSS = "li[test-id*='automation-web']";
        webDriver.findElement(By.cssSelector(lblAutomationWebContainsCSS));

        //<li test-id="db-web-element" xpath="1">Web Element:<a href="https://testek.vn/lab/auto/web-elements" target="_blank" test-id="db-web-element-link"> Basic Web Elements</a></li>
        String lblWebElementStartCSS = "li[test-id^='db-web-element']";
        webDriver.findElement(By.cssSelector(lblWebElementStartCSS));

        String lblWebElementContainsCSS = "li[test-id*='web-element']";
        webDriver.findElement(By.cssSelector(lblWebElementContainsCSS));

        //<li test-id="db-account" xpath="1">Account (<b><i style="">for API System &amp; Automation Web</i></b>) </li>
        String lblAccountStartCSS = "li[test-id^='db-account']";
        webDriver.findElement(By.cssSelector(lblAccountStartCSS));

        String lblAccountContainsCSS = "li[test-id*='account']";
        webDriver.findElement(By.cssSelector(lblAccountContainsCSS));

        //<li test-id="db-account-admin" xpath="1">Admin: admin_com_role </li>
        String lblAccountAdminStartCSS = "li[test-id^='db-account-admin']";
        webDriver.findElement(By.cssSelector(lblAccountAdminStartCSS));

        String lblAccountAdminContainsCSS = "li[test-id*='account-admin']";
        webDriver.findElement(By.cssSelector(lblAccountAdminContainsCSS));

        //<li test-id="db-account-user" xpath="1">User: user_com_role </li>
        String lblAccountUserStartCSS = "li[test-id^='db-account-user']";
        webDriver.findElement(By.cssSelector(lblAccountUserStartCSS));

        String lblAccountUserContainsCSS = "li[test-id*='account-user']";
        webDriver.findElement(By.cssSelector(lblAccountUserContainsCSS));

        //<li test-id="db-account-guest" xpath="1">Guest: guest_com_role </li>
        String lblAccountGuestStartCSS = "li[test-id^='db-account-guest']";
        webDriver.findElement(By.cssSelector(lblAccountGuestStartCSS));

        String lblAccountGuestContainsCSS = "li[test-id*='account-guest']";
        webDriver.findElement(By.cssSelector(lblAccountGuestContainsCSS));

        //<li test-id="db-account-password" xpath="1">Password: aA12345678@ </li>
        String lblAccountPasswordStartCSS = "li[test-id^='db-account-password']";
        webDriver.findElement(By.cssSelector(lblAccountPasswordStartCSS));

        String lblAccountPasswordContainsCSS = "li[test-id*='account-password']";
        webDriver.findElement(By.cssSelector(lblAccountPasswordContainsCSS));

        //<li test-id="db-database" xpath="1">Database: Updating... </li>
        String lblDatabaseStartCSS = "li[test-id^='db-database']";
        webDriver.findElement(By.cssSelector(lblDatabaseStartCSS));

        String lblDatabaseContainsCSS = "li[test-id*='database']";
        webDriver.findElement(By.cssSelector(lblDatabaseContainsCSS));

        //<p test-id="about-me-coffee-text" style="" xpath="1">Buy Me a Coffee </p>
        String lblAboutMeCoffeeTextStartCSS = "p[test-id^='about-me-coffee-text']";
        webDriver.findElement(By.cssSelector(lblAboutMeCoffeeTextStartCSS));

        String lblAboutMeCoffeeTextContainsCSS ="p[test-id*='coffee-text']";
        webDriver.findElement(By.cssSelector(lblAboutMeCoffeeTextContainsCSS));

        //<img test-id="about-me-coffee-img" src="https://lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR=s220" style="width: 216px; height: 300px;" xpath="1">
        String lblAboutMeCoffeeImgStartCSS = "img[src^='https://lh3.googleusercontent.com/d/']";
        webDriver.findElement(By.cssSelector(lblAboutMeCoffeeImgStartCSS));

        String lblAboutMeCoffeeImgContainsCSS = "img[src*='1jomM5CqmS7JPuI9docJdnBeYil5vR_yR=s220']";
        webDriver.findElement(By.cssSelector(lblAboutMeCoffeeImgContainsCSS));

        //<h4 test-id="about-me-web-elements" xpath="1"><b>HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG
        //                        CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!</b></h4>

        String lblAboutMeWebElementsStartCSS = "h4[test-id^='about-me-web']";
        webDriver.findElement(By.cssSelector(lblAboutMeWebElementsStartCSS));

        String lblAboutMeWebElementsContainsCSS = "h4[test-id*='me-web-elements']";
        webDriver.findElement(By.cssSelector(lblAboutMeWebElementsContainsCSS));
    }


    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findAdvanceLocatorWithXPath() {
        gotoTestWebsite();

        // Full Name Component
        String lblTitleAncestorXPath = "//h4[@test-id='db-title']/ancestor::div[@test-id='about-me-grid']";
        WebElement lblTitleElement = webDriver.findElement(By.xpath(lblTitleAncestorXPath));

        // Handle other elements similarly
        //<h2 style="font-size: xx-large; color: #007bff;" test-id="about-me-title" xpath="1"><b>TESTEK - KIỂM THỬ THỰC CHIẾN</b></h2>
        String lblAboutMeTitleTextXPath = "//b[normalize-space()='TESTEK - KIỂM THỬ THỰC CHIẾN']";
        webDriver.findElement(By.xpath(lblAboutMeTitleTextXPath));

        String lblABoutMeTitlePrecedingXPath = "//h4[@test-id='about-me-web-elements']/preceding::h2[@test-id='about-me-title']";
        webDriver.findElement(By.xpath(lblABoutMeTitlePrecedingXPath));

        String lblABoutMeTitleFollowingXPath = "//div[@test-id='sidebar-root']/following::h2[@test-id='about-me-title']";
        webDriver.findElement(By.xpath(lblABoutMeTitleFollowingXPath));

        String lblABoutMeTitleChildXPath = "//div[@test-id='about-me-section']/child::h2[@test-id='about-me-title']";
        webDriver.findElement(By.xpath(lblABoutMeTitleChildXPath));

        //<h4 test-id="db-discord" id="db-discord" xpath="1">Discord: <a href="https://discord.gg/jC7ZtmvuDX" target="_blank" test-id="db-discord-link">Testek - Kiểm thử thực chiến</a></h4>
        String lblDiscordPrecedingSiblingXPath = "//h4[@test-id='db-facebook']/preceding-sibling::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordPrecedingSiblingXPath));

        String lblDiscordFollowingSiblingXPath = "//h4[@test-id='db-website']/following-sibling::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordFollowingSiblingXPath));

        String lblDiscordChildXPath = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordChildXPath));

        String lblDiscordDescendantXPath = "//div[@test-id='about-me-grid']/descendant::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordDescendantXPath));

        //<li test-id="db-account" xpath="1">Account (<b><i style="">for API System &amp; Automation Web</i></b>) </li>
        String lblAccountAncestorXPath = "//li[@test-id='db-account-admin']/ancestor::li[@test-id='db-account']";
        webDriver.findElement(By.xpath(lblAccountAncestorXPath));

        String lblAccountChildXPath = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-account']";
        webDriver.findElement(By.xpath(lblAccountChildXPath));

        String lblAccountPrecedingSiblingXPath = "//li[@test-id='db-database']/preceding-sibling::li[@test-id='db-account']";
        webDriver.findElement(By.xpath(lblAccountPrecedingSiblingXPath));

        String lblAccountFollowingSiblingXPath = "//li[@test-id='db-api-system']/following-sibling::li[@test-id='db-account']";
        webDriver.findElement(By.xpath(lblAccountFollowingSiblingXPath));

        String lblAccountPrecedingXPath = "//h4[@test-id='about-me-web-elements']/preceding::li[@test-id='db-account']";
        webDriver.findElement(By.xpath(lblAccountPrecedingXPath));

        String lblAccountFollowingXPath = "//h4[@test-id='db-contact']/following::li[@test-id='db-account']";
        webDriver.findElement(By.xpath(lblAccountFollowingXPath));
    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
