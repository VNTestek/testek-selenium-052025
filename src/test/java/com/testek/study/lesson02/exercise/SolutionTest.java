package com.testek.study.lesson02.exercise;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


    @Test(description = "Find element with CSS")
    public void findLocatorWithCSS() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteCSS = "h4#db-title-id";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Handle other elements similarly

        //<h2 style="font-size: xx-large; color: #007bff;" test-id="about-me-title" xpath="1"><b>TESTEK - KIỂM THỬ THỰC CHIẾN</b></h2>
        String lblAboutMeTitleCSS = "h2[test-id='about-me-title']";
        webDriver.findElement(By.cssSelector(lblAboutMeTitleCSS));

        //<h4 id="db-title-id" test-id="db-title" name="db-title-name" class="db-title-class" xpath="1">Đào tạo API Testing, Performance Testing, Automation Testing</h4>
        String lblDbTitleCSSWithTestIdAndTag = "h4[test-id='db-title']";
        webDriver.findElement(By.cssSelector(lblDbTitleCSSWithTestIdAndTag));

        String lblDbTitleCSSWithIdAndTag = "h4[id='db-title-id']";
        webDriver.findElement(By.cssSelector(lblDbTitleCSSWithIdAndTag));

        String lblDbTitleCSSWithNameAndTag = "h4[name='db-title-name']";
        webDriver.findElement(By.cssSelector(lblDbTitleCSSWithNameAndTag));

        String lblDbTitleCSSWithClassAndTag = "h4[class='db-title-class']";
        webDriver.findElement(By.cssSelector(lblDbTitleCSSWithClassAndTag));

        String lblDbTitleCSSWithId = "#db-title-id";
        webDriver.findElement(By.cssSelector(lblDbTitleCSSWithId));

        String lblDbTitleCSSWithClass = ".db-title-class";
        webDriver.findElement(By.cssSelector(lblDbTitleCSSWithClass));

        //<h4 test-id="db-website" xpath="1">Website: <a href="https://testek.vn" target="_blank" test-id="db-website-link">https://testek.vn</a></h4>
        String lblDbWebsiteCSSWithTestIdAndTag = "h4[test-id='db-website']";
        webDriver.findElement(By.cssSelector(lblDbWebsiteCSSWithTestIdAndTag));

        String lblDbWebsiteLinkCSSWithHrefAndTag = "a[href='https://testek.vn']";
        webDriver.findElement(By.cssSelector(lblDbWebsiteLinkCSSWithHrefAndTag));

        String lblDbWebsiteLinkCSSWithTestIdAndTag = "a[test-id='db-website-link']";
        webDriver.findElement(By.cssSelector(lblDbWebsiteLinkCSSWithTestIdAndTag));

        //<h4 test-id="db-discord" id="db-discord" xpath="1">Discord: <a href="https://discord.gg/jC7ZtmvuDX" target="_blank" test-id="db-discord-link">Testek - Kiểm thử thực chiến</a></h4>
        String lblDbDiscordCSSWithTestIdAndTag = "h4[test-id='db-discord']";
        webDriver.findElement(By.cssSelector(lblDbDiscordCSSWithTestIdAndTag));

        String lblDbDiscordLinkCSSWithHrefAndTag = "a[href='https://discord.gg/jC7ZtmvuDX']";
        webDriver.findElement(By.cssSelector(lblDbDiscordLinkCSSWithHrefAndTag));

        String lblDbDiscordLinkCSSWithTestIdAndTag = "a[test-id='db-discord-link']";
        webDriver.findElement(By.cssSelector(lblDbDiscordLinkCSSWithTestIdAndTag));

        //<h4 test-id="db-facebook" xpath="1">Facebook: <a href="https://www.facebook.com/share/g/15m67fr73k/" target="_blank" test-id="db-facebook-link">Testek - Kiểm thử thực chiến</a></h4>
        String lblDbFacebookCSSWithTestIdAndTag = "h4[test-id='db-facebook']";
        webDriver.findElement(By.cssSelector(lblDbFacebookCSSWithTestIdAndTag));

        String lblDbFacebookLinkCSSWithHrefAndTag = "a[href='https://www.facebook.com/share/g/15m67fr73k/']";
        webDriver.findElement(By.cssSelector(lblDbFacebookLinkCSSWithHrefAndTag));

        String lblDbFacebookLinkCSSWithTestIdAndTag = "a[test-id='db-facebook-link']";
        webDriver.findElement(By.cssSelector(lblDbFacebookLinkCSSWithTestIdAndTag));

        //<h4 test-id="db-contact" xpath="1">Hotline: 083.286.8822 / Email: vntestek@gmail.com</h4>
        String lblDbContactCSSWithTestIdAndTag = "h4[test-id='db-contact']";
        webDriver.findElement(By.cssSelector(lblDbContactCSSWithTestIdAndTag));

        //<h4 test-id="db-systems" xpath="1">Các hệ thống Testek cung cấp</h4>
        String lblDbSystemsCSSWithTestIdAndTag = "h4[test-id='db-systems']";
        webDriver.findElement(By.cssSelector(lblDbSystemsCSSWithTestIdAndTag));

        //<li test-id="db-api-system" xpath="1">API System: <a href="https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/" target="_blank" test-id="db-api-system-link">Swagger</a></li>
        String lblDbApiSystemCSSWithTestIdAndTag = "li[test-id='db-api-system']";
        webDriver.findElement(By.cssSelector(lblDbApiSystemCSSWithTestIdAndTag));

        String lblDbApiSystemLinkCSSWithHrefAndTag = "a[href='https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/']";
        webDriver.findElement(By.cssSelector(lblDbApiSystemLinkCSSWithHrefAndTag));

        String lblDbApiSystemLinkCSSWithTestIdAndTag = "a[test-id='db-api-system-link']";
        webDriver.findElement(By.cssSelector(lblDbApiSystemLinkCSSWithTestIdAndTag));

        //<li test-id="db-automation-web" xpath="1">Automation Web: <a href="https://testek.vn/lab/auto/login" target="_blank" test-id="db-automation-web-link">Product Management</a></li>
        String lblDbAutomationWebCSSWithTestIdAndTag = "li[test-id='db-automation-web']";
        webDriver.findElement(By.cssSelector(lblDbAutomationWebCSSWithTestIdAndTag));

        String lblDbAutomationWebLinkCSSWithHrefAndTag = "a[href='https://testek.vn/lab/auto/login']";
        webDriver.findElement(By.cssSelector(lblDbAutomationWebLinkCSSWithHrefAndTag));

        String lblDbAutomationWebLinkCSSWithTestIdAndTag = "a[test-id='db-automation-web-link']";
        webDriver.findElement(By.cssSelector(lblDbAutomationWebLinkCSSWithTestIdAndTag));

        //<li test-id="db-web-element" xpath="1">Web Element:<a href="https://testek.vn/lab/auto/web-elements" target="_blank" test-id="db-web-element-link"> Basic Web Elements</a></li>
        String lblDbWebElementCSSWithTestIdAndTag = "li[test-id='db-web-element']";
        webDriver.findElement(By.cssSelector(lblDbWebElementCSSWithTestIdAndTag));

        String lblDbWebElementLinkCSSWithHrefAndTag = "a[href='https://testek.vn/lab/auto/web-elements']";
        webDriver.findElement(By.cssSelector(lblDbWebElementLinkCSSWithHrefAndTag));

        String lblDbWebElementLinkCSSWithTestIdAndTag = "a[test-id='db-web-element-link']";
        webDriver.findElement(By.cssSelector(lblDbWebElementLinkCSSWithTestIdAndTag));

        //<li test-id="db-account" xpath="1">Account (<b><i style="">for API System &amp; Automation Web</i></b>) </li>
        String lblDbAccountCSSWithTestIdAndTag = "li[test-id='db-account']";
        webDriver.findElement(By.cssSelector(lblDbAccountCSSWithTestIdAndTag));

        //<li test-id="db-account-admin" xpath="1">Admin: admin_com_role </li>
        String lblDbAccountAdminCSSWithTestIdAndTag = "li[test-id='db-account-admin']";
        webDriver.findElement(By.cssSelector(lblDbAccountAdminCSSWithTestIdAndTag));

        //<li test-id="db-account-user" xpath="1">User: user_com_role </li>
        String lblDbAccountUserCSSWithTestIdAndTag = "li[test-id='db-account-user']";
        webDriver.findElement(By.cssSelector(lblDbAccountUserCSSWithTestIdAndTag));

        //<li test-id="db-account-guest" xpath="1">Guest: guest_com_role </li>
        String lblDbAccountGuestCSSWithTestIdAndTag = "li[test-id='db-account-guest']";
        webDriver.findElement(By.cssSelector(lblDbAccountGuestCSSWithTestIdAndTag));

        //<li test-id="db-account-password" xpath="1">Password: aA12345678@ </li>
        String lblDbAccountPasswordCSSWithTestIdAndTag = "li[test-id='db-account-password']";
        webDriver.findElement(By.cssSelector(lblDbAccountPasswordCSSWithTestIdAndTag));

        //<li test-id="db-database" xpath="1">Database: Updating... </li>
        String lblDbDatabaseCSSWithTestIdAndTag = "li[test-id='db-database']";
        webDriver.findElement(By.cssSelector(lblDbWebElementCSSWithTestIdAndTag));

        //<p test-id="about-me-coffee-text" style="" xpath="1">Buy Me a Coffee </p>
        String lblAboutMeCoffeeTextCSSWithTestIdAndTag = "p[test-id='about-me-coffee-text']";
        webDriver.findElement(By.cssSelector(lblAboutMeCoffeeTextCSSWithTestIdAndTag));

        //<img test-id="about-me-coffee-img" src="https://lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR=s220" style="width: 216px; height: 300px;" xpath="1">
        String lblAboutMeCoffeeImgCSSWithTestIdAndTag = "img[test-id='about-me-coffee-img']";
        webDriver.findElement(By.cssSelector(lblAboutMeCoffeeImgCSSWithTestIdAndTag));

        String lblAboutMeCoffeeImgCSSWithSrcAndTag = "img[src='https://lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR=s220']";
        webDriver.findElement(By.cssSelector(lblAboutMeCoffeeImgCSSWithSrcAndTag));

        //<h4 test-id="about-me-web-elements" xpath="1"><b>HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG
        //                        CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!</b></h4>
        String lblAboutMeWebElementsCSSWithTestIdAndTag = "h4[test-id='about-me-web-elements']";
        webDriver.findElement(By.cssSelector(lblAboutMeWebElementsCSSWithTestIdAndTag));
    }

    @Test(description = "Find element with XPath")
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteXPath = "//h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Handle other elements similarly

        //<h2 style="font-size: xx-large; color: #007bff;" test-id="about-me-title" xpath="1"><b>TESTEK - KIỂM THỬ THỰC CHIẾN</b></h2>
        String lblAboutMeTitleXPath = "//h2[@test-id='about-me-title']";
        webDriver.findElement(By.xpath(lblAboutMeTitleXPath));

        //<h4 id="db-title-id" test-id="db-title" name="db-title-name" class="db-title-class" xpath="1">Đào tạo API Testing, Performance Testing, Automation Testing</h4>
        String lblDbTitleXPathWithTestIdAndTag = "//h4[@test-id='db-title']";
        webDriver.findElement(By.xpath(lblDbTitleXPathWithTestIdAndTag));

        String lblDbTitleXPathWithIdAndTag = "//h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(lblDbTitleXPathWithIdAndTag));

        String lblDbTitleXPathWithNameAndTag = "//h4[@name='db-title-name']";
        webDriver.findElement(By.xpath(lblDbTitleXPathWithNameAndTag));

        String lblDbTitleXPathWithClassAndTag = "//h4[@class='db-title-class']";
        webDriver.findElement(By.xpath(lblDbTitleXPathWithClassAndTag));

        //<h4 test-id="db-website" xpath="1">Website: <a href="https://testek.vn" target="_blank" test-id="db-website-link">https://testek.vn</a></h4>
        String lblDbWebsiteXPathWithTestIdAndTag = "//h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblDbWebsiteXPathWithTestIdAndTag));

        String lblDbWebsiteLinkXPathWithHrefAndTag = "//a[@href='https://testek.vn']";
        webDriver.findElement(By.xpath(lblDbWebsiteLinkXPathWithHrefAndTag));

        String lblDbWebsiteLinkXPathWithTestIdAndTag = "//a[@test-id='db-website-link']";
        webDriver.findElement(By.xpath(lblDbWebsiteLinkXPathWithTestIdAndTag));

        //<h4 test-id="db-discord" id="db-discord" xpath="1">Discord: <a href="https://discord.gg/jC7ZtmvuDX" target="_blank" test-id="db-discord-link">Testek - Kiểm thử thực chiến</a></h4>
        String lblDbDiscordXPathWithTestIdAndTag = "//h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDbDiscordXPathWithTestIdAndTag));

        String lblDbDiscordLinkXPathWithHrefAndTag = "//a[@href='https://discord.gg/jC7ZtmvuDX']";
        webDriver.findElement(By.xpath(lblDbDiscordLinkXPathWithHrefAndTag));

        String lblDbDiscordLinkXPathWithTestIdAndTag = "//a[@test-id='db-discord-link']";
        webDriver.findElement(By.xpath(lblDbDiscordLinkXPathWithTestIdAndTag));

        //<h4 test-id="db-facebook" xpath="1">Facebook: <a href="https://www.facebook.com/share/g/15m67fr73k/" target="_blank" test-id="db-facebook-link">Testek - Kiểm thử thực chiến</a></h4>
        String lblDbFacebookXPathWithTestIdAndTag = "//h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(lblDbFacebookXPathWithTestIdAndTag));

        String lblDbFacebookLinkXPathWithHrefAndTag = "//a[@href='https://www.facebook.com/share/g/15m67fr73k/']";
        webDriver.findElement(By.xpath(lblDbFacebookLinkXPathWithHrefAndTag));

        String lblDbFacebookLinkXPathWithTestIdAndTag = "//a[@test-id='db-facebook-link']";
        webDriver.findElement(By.xpath(lblDbFacebookLinkXPathWithTestIdAndTag));

        //<h4 test-id="db-contact" xpath="1">Hotline: 083.286.8822 / Email: vntestek@gmail.com</h4>
        String lblDbContactXPathWithTestIdAndTag = "//h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(lblDbContactXPathWithTestIdAndTag));

        //<h4 test-id="db-systems" xpath="1">Các hệ thống Testek cung cấp</h4>
        String lblDbSystemsXPathWithTestIdAndTag = "//h4[@test-id='db-systems']";
        webDriver.findElement(By.xpath(lblDbSystemsXPathWithTestIdAndTag));

        //<li test-id="db-api-system" xpath="1">API System: <a href="https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/" target="_blank" test-id="db-api-system-link">Swagger</a></li>
        String lblDbApiSystemXPathWithTestIdAndTag = "//li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(lblDbApiSystemXPathWithTestIdAndTag));

        String lblDbApiSystemLinkXPathWithHrefAndTag = "//a[@href='https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/']";
        webDriver.findElement(By.xpath(lblDbApiSystemLinkXPathWithHrefAndTag));

        String lblDbApiSystemLinkXPathWithTestIdAndTag = "//a[@test-id='db-api-system-link']";
        webDriver.findElement(By.xpath(lblDbApiSystemLinkXPathWithTestIdAndTag));

        //<li test-id="db-automation-web" xpath="1">Automation Web: <a href="https://testek.vn/lab/auto/login" target="_blank" test-id="db-automation-web-link">Product Management</a></li>
        String lblDbAutomationWebXPathWithTestIdAndTag = "//li[@test-id='db-automation-web']";
        webDriver.findElement(By.xpath(lblDbAutomationWebXPathWithTestIdAndTag));

        String lblDbAutomationWebLinkXPathWithHrefAndTag = "//a[@href='https://testek.vn/lab/auto/login']";
        webDriver.findElement(By.xpath(lblDbAutomationWebLinkXPathWithHrefAndTag));

        String lblDbAutomationWebLinkXPathWithTestIdAndTag = "//a[@test-id='db-automation-web-link']";
        webDriver.findElement(By.xpath(lblDbAutomationWebLinkXPathWithTestIdAndTag));

        //<li test-id="db-web-element" xpath="1">Web Element:<a href="https://testek.vn/lab/auto/web-elements" target="_blank" test-id="db-web-element-link"> Basic Web Elements</a></li>
        String lblDbWebElementXPathWithTestIdAndTag = "//li[@test-id='db-web-element']";
        webDriver.findElement(By.xpath(lblDbWebElementXPathWithTestIdAndTag));

        String lblDbWebElementLinkXPathWithHrefAndTag = "//a[@href='https://testek.vn/lab/auto/web-elements']";
        webDriver.findElement(By.xpath(lblDbWebElementLinkXPathWithHrefAndTag));

        String lblDbWebElementLinkXPathWithTestIdAndTag = "//a[@test-id='db-web-element-link']";
        webDriver.findElement(By.xpath(lblDbWebElementLinkXPathWithTestIdAndTag));

        //<li test-id="db-account" xpath="1">Account (<b><i style="">for API System &amp; Automation Web</i></b>) </li>
        String lblDbAccountXPathWithTestIdAndTag = "//li[@test-id='db-account']";
        webDriver.findElement(By.xpath(lblDbAccountXPathWithTestIdAndTag));

        //<li test-id="db-account-admin" xpath="1">Admin: admin_com_role </li>
        String lblDbAccountAdminXPathWithTestIdAndTag = "//li[@test-id='db-account-admin']";
        webDriver.findElement(By.xpath(lblDbAccountAdminXPathWithTestIdAndTag));

        //<li test-id="db-account-user" xpath="1">User: user_com_role </li>
        String lblDbAccountUserXPathWithTestIdAndTag = "//li[@test-id='db-account-user']";
        webDriver.findElement(By.xpath(lblDbAccountUserXPathWithTestIdAndTag));

        //<li test-id="db-account-guest" xpath="1">Guest: guest_com_role </li>
        String lblDbAccountGuestXPathWithTestIdAndTag = "//li[@test-id='db-account-guest']";
        webDriver.findElement(By.xpath(lblDbAccountGuestXPathWithTestIdAndTag));

        //<li test-id="db-account-password" xpath="1">Password: aA12345678@ </li>
        String lblDbAccountPasswordXPathWithTestIdAndTag = "//li[@test-id='db-account-password']";
        webDriver.findElement(By.xpath(lblDbAccountPasswordXPathWithTestIdAndTag));

        //<li test-id="db-database" xpath="1">Database: Updating... </li>
        String lblDbDatabaseXPathWithTestIdAndTag = "//li[@test-id='db-database']";
        webDriver.findElement(By.xpath(lblDbWebElementXPathWithTestIdAndTag));

        //<p test-id="about-me-coffee-text" style="" xpath="1">Buy Me a Coffee </p>
        String lblAboutMeCoffeeTextXPathWithTestIdAndTag = "//p[@test-id='about-me-coffee-text']";
        webDriver.findElement(By.xpath(lblAboutMeCoffeeTextXPathWithTestIdAndTag));

        //<img test-id="about-me-coffee-img" src="https://lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR=s220" style="width: 216px; height: 300px;" xpath="1">
        String lblAboutMeCoffeeImgXPathWithTestIdAndTag = "//img[@test-id='about-me-coffee-img']";
        webDriver.findElement(By.xpath(lblAboutMeCoffeeImgXPathWithTestIdAndTag));

        String lblAboutMeCoffeeImgXPathWithSrcAndTag = "//img[@src='https://lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR=s220']";
        webDriver.findElement(By.xpath(lblAboutMeCoffeeImgXPathWithSrcAndTag));

        //<h4 test-id="about-me-web-elements" xpath="1"><b>HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG
        //                        CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!</b></h4>
        String lblAboutMeWebElementsXPathWithTestIdAndTag = "//h4[@test-id='about-me-web-elements']";
        webDriver.findElement(By.xpath(lblAboutMeWebElementsXPathWithTestIdAndTag));
    }

    /**
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}