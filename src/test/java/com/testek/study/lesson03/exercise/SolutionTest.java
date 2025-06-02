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

        //TESTEK - KIỂM THỬ THỰC CHIẾN
        String titleWebContainsCSS = "h2[test-id *='about-me']";
        WebElement titleWebContainsEle = webDriver.findElement(By.cssSelector(titleWebContainsCSS));

        String titleWebStartWithCSS = "h2[test-id ^='about-']";
        WebElement titleWebStartWithEle = webDriver.findElement(By.cssSelector(titleWebStartWithCSS));

        // Đào tạo API Testing, Performance Testing, Automation Testing
        String lblWebsiteContainsCSS = "h4[name*= 'name']";
        WebElement lblWebsiteContainsEle = webDriver.findElement(By.cssSelector(lblWebsiteContainsCSS));

        String lblWebsiteStartWithCSS = "h4[name^= 'db-title']";
        WebElement lblWebsiteStartWithEle = webDriver.findElement(By.cssSelector(lblWebsiteStartWithCSS));

        // Website: https://testek.vn
        String txtWebContainsCSS = "h4[test-id *='website']";
        WebElement txtWebContainsEle = webDriver.findElement(By.cssSelector(txtWebContainsCSS));

        String txtWebStartWithCSS = "h4[test-id ^='db-website']";
        WebElement txtWebStartWithEle = webDriver.findElement(By.cssSelector(txtWebStartWithCSS));

        String linkWebContainsCSS = "a[test-id *= 'website-link']";
        WebElement linkWebContainsEle = webDriver.findElement(By.cssSelector(linkWebContainsCSS));

        String linkWebStartWithCSS = "a[test-id ^= 'db-website-link']";
        WebElement linkWebStartWithEle = webDriver.findElement(By.cssSelector(linkWebStartWithCSS));

        //Discord: Testek - Kiểm thử thực chiến
        String txtDiscordContainsCSS = "h4[test-id *= 'db-discord']";
        WebElement txtDiscordContainsEle = webDriver.findElement(By.cssSelector(txtDiscordContainsCSS));

        String txtDiscordStartWithCSS = "h4[test-id ^= 'db-disco']";
        WebElement txtDiscordStartWithEle = webDriver.findElement(By.cssSelector(txtDiscordStartWithCSS));

        String linkDiscordContainsCSS = "a[href *= 'https://discord.gg/jC7ZtmvuDX']";
        WebElement linkDiscordContainsEle = webDriver.findElement(By.cssSelector(linkDiscordContainsCSS));

        String linkDiscordStartWithCSS = "a[href ^= 'https://discord.gg/']";
        WebElement linkDiscordStartWithEle = webDriver.findElement(By.cssSelector(linkDiscordStartWithCSS));

        //Facebook: Testek - Kiểm thử thực chiến
        String txtFbContainsCSS = "h4[test-id *= 'facebook']";
        WebElement txtFbContainsEle = webDriver.findElement(By.cssSelector(txtFbContainsCSS));

        String txtFbStartWithCSS = "h4[test-id ^= 'db-facebook']";
        WebElement txtFbStartWithEle = webDriver.findElement(By.cssSelector(txtFbStartWithCSS));

        String linkFbContainsCSS = "a[href *= 'facebook.com']";
        WebElement linkFbContainsEle = webDriver.findElement(By.cssSelector(linkFbContainsCSS));

        String linkFbStartWithCSS = "a[href ^= 'https://www.facebook.com']";
        WebElement linkFbStartWithEle = webDriver.findElement(By.cssSelector(linkFbStartWithCSS));

        //Hotline Email
        String txtContactContainsCSS = "h4[test-id *= 'db-contact']";
        WebElement txtContactContainsEle = webDriver.findElement(By.cssSelector(txtContactContainsCSS));

        String txtContactStartWithCSS = "h4[test-id ^='db-contact']";
        WebElement txtContactStartWithEle = webDriver.findElement(By.cssSelector(txtContactStartWithCSS));

        //Các hệ thống Testek cung cấp
        String txtSystemContainsCSS = "h4[test-id *='db-systems']";
        WebElement txtSystemContainsEle = webDriver.findElement(By.cssSelector(txtSystemContainsCSS));

        String txtSystemStartWithCSS = "h4[test-id ^='db-systems']";
        WebElement txtSystemStartWithEle = webDriver.findElement(By.cssSelector(txtSystemStartWithCSS));

        //API
        String txtApiContainsCSS = "li[test-id *='db-api-system']";
        WebElement txtApiContainsEle = webDriver.findElement(By.cssSelector(txtApiContainsCSS));
        String apiSysLinkContainsCSS = "a[test-id *='db-api-system-link']";
        WebElement apiSysLinkContainsEle = webDriver.findElement(By.cssSelector(apiSysLinkContainsCSS));

        String txtApiStartWithCSS = "li[test-id ^='db-api-system']";
        WebElement txtApiStartWithEle = webDriver.findElement(By.cssSelector(txtApiStartWithCSS));
        String apiSysLinkStartWithCSS = "a[test-id ^='db-api-system-link']";
        WebElement apiSysLinkStartWithEle = webDriver.findElement(By.cssSelector(apiSysLinkStartWithCSS));

        //Auto web
        String txtAutoWebContainsCSS = "li[test-id *='db-automation-web']";
        WebElement txtAutoWebContainsEle = webDriver.findElement(By.cssSelector(txtAutoWebContainsCSS));
        String autoWebLinkContainsCSS = "a[test-id *='db-automation-web-link']";
        WebElement autoWebLinkContainsEle = webDriver.findElement(By.cssSelector(autoWebLinkContainsCSS));

        String txtAutoWebStartWithCSS = "li[test-id ^='db-automation-web']";
        WebElement txtAutoWebStartWithEle = webDriver.findElement(By.cssSelector(txtAutoWebStartWithCSS));
        String autoWebLinkStartWithCSS = "a[test-id ^='db-automation-web-link']";
        WebElement autoWebLinkStartWithEle = webDriver.findElement(By.cssSelector(autoWebLinkStartWithCSS));

        //Web Element
        String txtEleWebContainsCSS = "li[test-id *='db-web-element']";
        WebElement txtEleWebContainsEle = webDriver.findElement(By.cssSelector(txtEleWebContainsCSS));
        String txtEleWebLinkContainsCSS = "a[test-id *='db-web-element-link']";
        WebElement txtEleWebLinkContainsEle = webDriver.findElement(By.cssSelector(txtEleWebLinkContainsCSS));

        String txtEleWebStartWithCSS = "li[test-id ^= 'db-web-element']";
        WebElement txtEleWebStartWithEle = webDriver.findElement(By.cssSelector(txtEleWebStartWithCSS));
        String txtEleWebLinkStartWithCSS = "a[test-id ^= 'db-web-element-link']";
        WebElement txtEleWebLinkStartWithEle = webDriver.findElement(By.cssSelector(txtEleWebLinkStartWithCSS));

        // Account
        String txtAccountContainsCSS = "li[test-id *='db-account']";
        WebElement txtAccountContainsEle = webDriver.findElement(By.cssSelector(txtAccountContainsCSS));
        String txtAccountStartWithCSS = "li[test-id ^='db-account']";
        WebElement txtAccountStartWithEle = webDriver.findElement(By.cssSelector(txtAccountStartWithCSS));
        //Admin
        String txtAdminAccountContainsCSS = "li[test-id *='db-account-admin']";
        WebElement txtAdminAccountContainsEle = webDriver.findElement(By.cssSelector(txtAdminAccountContainsCSS));
        String txtAdminAccountStartWithCSS = "li[test-id ^='db-account-admin']";
        WebElement txtAdminAccountStartWithEle = webDriver.findElement(By.cssSelector(txtAdminAccountStartWithCSS));
        //User
        String txtUserAccountContainsCSS = "li[test-id *='db-account-user']";
        WebElement txtUserAccountContainsEle = webDriver.findElement(By.cssSelector(txtUserAccountContainsCSS));
        String txtUserAccountStartWithCSS = "li[test-id ^='db-account-user']";
        WebElement txtUserAccountStartWithEle = webDriver.findElement(By.cssSelector(txtUserAccountStartWithCSS));
        //Guest
        String txtGuestAccountContainsCSS = "li[test-id *='db-account-guest']";
        WebElement txtGuestAccountContainsEle = webDriver.findElement(By.cssSelector(txtGuestAccountContainsCSS));
        String txtGuestAccountStartWithCSS = "li[test-id ^='db-account-guest']";
        WebElement txtGuestAccountStartWithEle = webDriver.findElement(By.cssSelector(txtGuestAccountStartWithCSS));
        //Pass
        String txtAccountPasswdContainsCSS = "li[test-id *='db-account-password']";
        WebElement txtAccountPasswdContainsEle = webDriver.findElement(By.cssSelector(txtAccountPasswdContainsCSS));
        String txtAccountPasswdStartWithCSS = "li[test-id ^='db-account-password']";
        WebElement txtAccountPasswdStartWithEle = webDriver.findElement(By.cssSelector(txtAccountPasswdStartWithCSS));

        //DB
        String txtDatabaseContainsCSS = "li[test-id *='db-database']";
        WebElement txtDatabaseContainsEle = webDriver.findElement(By.cssSelector(txtDatabaseContainsCSS));
        String txtDatabaseStartWithCSS = "li[test-id ^='db-database']";
        WebElement txtDatabaseStartWithEle = webDriver.findElement(By.cssSelector(txtDatabaseStartWithCSS));

        //HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!
        String txtAboutMeContainsCSS = "h4[test-id *='about-me-web-elements']";
        WebElement txtAboutMeContainsEle = webDriver.findElement(By.cssSelector(txtAboutMeContainsCSS));
        String txtAboutMeStartWithCSS = "h4[test-id ^='about-me-web-elements']";
        WebElement txtAboutMeStartWithEle = webDriver.findElement(By.cssSelector(txtAboutMeStartWithCSS));

        // Buy Me a Coffee IMG
        String qrImgContainsCSS = "img[test-id *='about-me-coffee-img']";
        WebElement qrImgContainsEle = webDriver.findElement(By.cssSelector(qrImgContainsCSS));
        String qrImgStartWithCSS = "img[test-id ^='about-me-coffee-img']";
        WebElement qrImgStartWithEle = webDriver.findElement(By.cssSelector(qrImgStartWithCSS));

        ;

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
        //TESTEK - KIỂM THỬ THỰC CHIẾN
        String titleWebContainsXPath = "//h2[contains(@test-id ,'about-me')]";
        WebElement titleWebContainsEle = webDriver.findElement(By.xpath(titleWebContainsXPath));

        String titleWebStartWithXPath = "//h2[starts-with(@test-id ,'about-')]";
        WebElement titleWebStartWithEle = webDriver.findElement(By.xpath(titleWebStartWithXPath));

        String titleWebNormalSpaceXPath = "//h2[normalize-space() = 'TESTEK - KIỂM THỬ THỰC CHIẾN']";
        WebElement titleWebTextEle = webDriver.findElement(By.xpath(titleWebNormalSpaceXPath));

        String titleWebAncestorXPath = "//h2[@test-id='about-me-title']/ancestor::div[@test-id='about-me-section']";
        WebElement titleWebAncestorEle = webDriver.findElement(By.xpath(titleWebAncestorXPath));

        // Đào tạo API Testing, Performance Testing, Automation Testing
        String lblWebsiteContainsXPath = "//h4[contains(@name, 'name')]";
        WebElement lblWebsiteContainsEle = webDriver.findElement(By.xpath(lblWebsiteContainsXPath));

        String lblWebsiteStartWithXPath = "//h4[starts-with(@name, 'db-title')]";
        WebElement lblWebsiteStartWithEle = webDriver.findElement(By.xpath(lblWebsiteStartWithXPath));

        String lblWebsiteTextXPath = "//h4[text()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        WebElement lblWebsiteTextEle = webDriver.findElement(By.xpath(lblWebsiteTextXPath));

        String lblWebsiteDescendantXPath = "//body[@test-id='body-root']/descendant::h4[@id='db-title-id']";
        WebElement lblWebsiteDescendantEle = webDriver.findElement(By.xpath(lblWebsiteDescendantXPath));

        // Website: https://testek.vn
        String txtWebContainsXPath = "//h4[contains(@test-id ,'website')]";
        WebElement txtWebContainsEle = webDriver.findElement(By.xpath(txtWebContainsXPath));

        String txtWebStartWithXPath = "//h4[starts-with(@test-id ,'db-website')]";
        WebElement txtWebStartWithEle = webDriver.findElement(By.xpath(txtWebStartWithXPath));

        String txtWebsiteFollowingXpath = "//h4[@test-id='db-title']/following::h4[@test-id='db-website']";
        WebElement txtWebsiteFollowingEle = webDriver.findElement(By.xpath(txtWebsiteFollowingXpath));

        String linkWebContainsXPath = "//a[contains(@test-id , 'website-link')]";
        WebElement linkWebContainsEle = webDriver.findElement(By.xpath(linkWebContainsXPath));

        String linkWebStartWithXPath = "//a[starts-with(@test-id , 'db-website-link')]";
        WebElement linkWebStartWithEle = webDriver.findElement(By.xpath(linkWebStartWithXPath));

        //Discord: Testek - Kiểm thử thực chiến
        String txtDiscordContainsXPath = "//h4[contains(@test-id , 'db-discord')]";
        WebElement txtDiscordContainsEle = webDriver.findElement(By.xpath(txtDiscordContainsXPath));

        String txtDiscordStartWithXPath = "//h4[starts-with(@test-id , 'db-disco')]";
        WebElement txtDiscordStartWithEle = webDriver.findElement(By.xpath(txtDiscordStartWithXPath));

        String txtDiscordPreSibXpath = "//h4[@test-id='db-contact']/preceding-sibling::h4[@test-id='db-discord']";
        WebElement txtDiscordPreSibEle = webDriver.findElement(By.xpath(txtDiscordPreSibXpath));

        String linkDiscordContainsXPath = "//a[contains(@href , 'https://discord.gg/jC7ZtmvuDX')]";
        WebElement linkDiscordContainsEle = webDriver.findElement(By.xpath(linkDiscordContainsXPath));

        String linkDiscordStartWithXPath = "//a[starts-with(@href , 'https://discord.gg/')]";
        WebElement linkDiscordStartWithEle = webDriver.findElement(By.xpath(linkDiscordStartWithXPath));

        //Facebook: Testek - Kiểm thử thực chiến
        String txtFbContainsXPath = "//h4[contains(@test-id , 'facebook')]";
        WebElement txtFbContainsEle = webDriver.findElement(By.xpath(txtFbContainsXPath));

        String txtFbStartWithXPath = "//h4[starts-with(@test-id , 'db-facebook')]";
        WebElement txtFbStartWithEle = webDriver.findElement(By.xpath(txtFbStartWithXPath));

        String txtFbFollowingSibXpath = "//h4[@test-id='db-website']/following-sibling::h4[@test-id='db-facebook']";
        WebElement txtFbFollowingSibEle = webDriver.findElement(By.xpath(txtFbFollowingSibXpath));

        String linkFbContainsXPath = "//a[contains(@href , 'facebook.com')]";
        WebElement linkFbContainsEle = webDriver.findElement(By.xpath(linkFbContainsXPath));

        String linkFbStartWithXPath = "//a[starts-with(@href , 'https://www.facebook.com')]";
        WebElement linkFbStartWithEle = webDriver.findElement(By.xpath(linkFbStartWithXPath));

        //Hotline Email
        String txtContactContainsXPath = "//h4[contains(@test-id , 'db-contact')]";
        WebElement txtContactContainsEle = webDriver.findElement(By.xpath(txtContactContainsXPath));

        String txtContactStartWithXPath = "//h4[starts-with(@test-id ,'db-contact')]";
        WebElement txtContactStartWithEle = webDriver.findElement(By.xpath(txtContactStartWithXPath));

        String txtContactTextXpath = "//h4[text()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        WebElement txtContactTextEle = webDriver.findElement(By.xpath(txtContactTextXpath));

        //Các hệ thống Testek cung cấp
        String txtSystemContainsXPath = "//h4[contains(@test-id ,'db-systems')]";
        WebElement txtSystemContainsEle = webDriver.findElement(By.xpath(txtSystemContainsXPath));

        String txtSystemStartWithXPath = "//h4[starts-with(@test-id ,'db-systems')]";
        WebElement txtSystemStartWithEle = webDriver.findElement(By.xpath(txtSystemStartWithXPath));

        String txtSystemChildXPath = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-systems']";
        WebElement txtSystemChildEle = webDriver.findElement(By.xpath(txtSystemChildXPath));

        //API
        String txtApiContainsXPath = "//li[contains(@test-id ,'db-api-system')]";
        WebElement txtApiContainsEle = webDriver.findElement(By.xpath(txtApiContainsXPath));
        String apiSysLinkContainsXPath = "//a[contains(@test-id ,'db-api-system-link')]";
        WebElement apiSysLinkContainsEle = webDriver.findElement(By.xpath(apiSysLinkContainsXPath));
        String txtAPiPreSibXpath = "//li[@test-id='db-automation-web']/preceding-sibling::li[@test-id='db-api-system']";
        WebElement txtAPiPreSibEle = webDriver.findElement(By.xpath(txtAPiPreSibXpath));

        String txtApiStartWithXPath = "//li[starts-with(@test-id ,'db-api-system')]";
        WebElement txtApiStartWithEle = webDriver.findElement(By.xpath(txtApiStartWithXPath));
        String apiSysLinkStartWithXPath = "//a[starts-with(@test-id ,'db-api-system-link')]";
        WebElement apiSysLinkStartWithEle = webDriver.findElement(By.xpath(apiSysLinkStartWithXPath));

        //Auto web
        String txtAutoWebContainsXPath = "//li[contains(@test-id ,'db-automation-web')]";
        WebElement txtAutoWebContainsEle = webDriver.findElement(By.xpath(txtAutoWebContainsXPath));
        String autoWebLinkContainsXPath = "//a[contains(@test-id ,'db-automation-web-link')]";
        WebElement autoWebLinkContainsEle = webDriver.findElement(By.xpath(autoWebLinkContainsXPath));

        String txtAutoWebStartWithXPath = "//li[starts-with(@test-id ,'db-automation-web')]";
        WebElement txtAutoWebStartWithEle = webDriver.findElement(By.xpath(txtAutoWebStartWithXPath));
        String autoWebLinkStartWithXPath = "//a[starts-with(@test-id ,'db-automation-web-link')]";
        WebElement autoWebLinkStartWithEle = webDriver.findElement(By.xpath(autoWebLinkStartWithXPath));

        //Web Element
        String txtEleWebContainsXPath = "//li[contains(@test-id ,'db-web-element')]";
        WebElement txtEleWebContainsEle = webDriver.findElement(By.xpath(txtEleWebContainsXPath));
        String txtEleWebLinkContainsXPath = "//a[contains(@test-id ,'db-web-element-link')]";
        WebElement txtEleWebLinkContainsEle = webDriver.findElement(By.xpath(txtEleWebLinkContainsXPath));

        String txtEleWebStartWithXPath = "//li[starts-with(@test-id , 'db-web-element')]";
        WebElement txtEleWebStartWithEle = webDriver.findElement(By.xpath(txtEleWebStartWithXPath));
        String txtEleWebLinkStartWithXPath = "//a[starts-with(@test-id , 'db-web-element-link')]";
        WebElement txtEleWebLinkStartWithEle = webDriver.findElement(By.xpath(txtEleWebLinkStartWithXPath));

        // Account
        String txtAccountContainsXPath = "//li[contains(@test-id ,'db-account')]";
        WebElement txtAccountContainsEle = webDriver.findElement(By.xpath(txtAccountContainsXPath));
        String txtAccountStartWithXPath = "//li[starts-with(@test-id ,'db-account')]";
        WebElement txtAccountStartWithEle = webDriver.findElement(By.xpath(txtAccountStartWithXPath));
        //Admin
        String txtAdminAccountContainsXPath = "//li[contains(@test-id ,'db-account-admin')]";
        WebElement txtAdminAccountContainsEle = webDriver.findElement(By.xpath(txtAdminAccountContainsXPath));
        String txtAdminAccountStartWithXPath = "//li[starts-with(@test-id ,'db-account-admin')]";
        WebElement txtAdminAccountStartWithEle = webDriver.findElement(By.xpath(txtAdminAccountStartWithXPath));
        //User
        String txtUserAccountContainsXPath = "//li[contains(@test-id ,'db-account-user')]";
        WebElement txtUserAccountContainsEle = webDriver.findElement(By.xpath(txtUserAccountContainsXPath));
        String txtUserAccountStartWithXPath = "//li[starts-with(@test-id ,'db-account-user')]";
        WebElement txtUserAccountStartWithEle = webDriver.findElement(By.xpath(txtUserAccountStartWithXPath));
        //Guest
        String txtGuestAccountContainsXPath = "//li[contains(@test-id ,'db-account-guest')]";
        WebElement txtGuestAccountContainsEle = webDriver.findElement(By.xpath(txtGuestAccountContainsXPath));
        String txtGuestAccountStartWithXPath = "//li[starts-with(@test-id ,'db-account-guest')]";
        WebElement txtGuestAccountStartWithEle = webDriver.findElement(By.xpath(txtGuestAccountStartWithXPath));
        //Pass
        String txtAccountPasswdContainsXPath = "//li[contains(@test-id ,'db-account-password')]";
        WebElement txtAccountPasswdContainsEle = webDriver.findElement(By.xpath(txtAccountPasswdContainsXPath));
        String txtAccountPasswdStartWithXPath = "//li[starts-with(@test-id ,'db-account-password')]";
        WebElement txtAccountPasswdStartWithEle = webDriver.findElement(By.xpath(txtAccountPasswdStartWithXPath));

        //DB
        String txtDatabaseContainsXPath = "//li[contains(@test-id ,'db-database')]";
        WebElement txtDatabaseContainsEle = webDriver.findElement(By.xpath(txtDatabaseContainsXPath));
        String txtDatabaseStartWithXPath = "//li[starts-with(@test-id ,'db-database')]";
        WebElement txtDatabaseStartWithEle = webDriver.findElement(By.xpath(txtDatabaseStartWithXPath));

        //HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!
        String txtAboutMeContainsXPath = "//h4[contains(@test-id ,'about-me-web-elements')]";
        WebElement txtAboutMeContainsEle = webDriver.findElement(By.xpath(txtAboutMeContainsXPath));
        String txtAboutMeStartWithXPath = "//h4[starts-with(@test-id ,'about-me-web-elements')]";
        WebElement txtAboutMeStartWithEle = webDriver.findElement(By.xpath(txtAboutMeStartWithXPath));
        String txtAboutMePreSibXPath = "//h4[@test-id='about-me-separator']/preceding-sibling::h4";
        WebElement txtAboutMePreSibEle = webDriver.findElement(By.xpath(txtAboutMePreSibXPath));


        // Buy Me a Coffee IMG
        String qrImgContainsXPath = "//img[contains(@test-id ,'about-me-coffee-img')]";
        WebElement qrImgContainsEle = webDriver.findElement(By.xpath(qrImgContainsXPath));
        String qrImgStartWithXPath = "//img[starts-with(@test-id ,'about-me-coffee-img')]";
        WebElement qrImgStartWithEle = webDriver.findElement(By.xpath(qrImgStartWithXPath));
        String qrImgDescendantXPath = "//div[@class='grid-item']/descendant::img";
        WebElement qrImgDescendantEle = webDriver.findElement(By.xpath(qrImgDescendantXPath));
    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
