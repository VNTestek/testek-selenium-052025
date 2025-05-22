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
        //Title: TESTEK - KIỂM THỬ THỰC CHIẾN
        //h2[test-id *= 'about-me-title']
        String lblTitleContainsCSS = "h2[test-id *= 'about-me-title']";
        WebElement lblTitleContains = webDriver.findElement(By.cssSelector(lblTitleContainsCSS));
        //h2[test-id ^='about-me-title']
        String lblTitleStartsWithCSS = "h2[test-id ^='about-me-title']";
        WebElement lblTitleText = webDriver.findElement(By.cssSelector(lblTitleStartsWithCSS));

        //Sub-title: Đào tạo API Testing, Performance Testing, Automation Testing
        //h4[name *= 'db-title-name']
        String lblSubTitleContainsCSS = "h4[name *= 'db-title-name']";
        WebElement lblSubTitleContains = webDriver.findElement(By.cssSelector(lblSubTitleContainsCSS));
        //h4[name^='db-']
        String lblSubTitleStartsWithCSS = "h4[name^='db-']";
        WebElement lblSubTitleText = webDriver.findElement(By.cssSelector(lblSubTitleStartsWithCSS));

        //Website: https://testek.vn
        //h4[test-id *= 'db-website']
        String lblWebContainsCSS = "h4[test-id *= 'db-website']";
        WebElement lblWebContains = webDriver.findElement(By.cssSelector(lblWebContainsCSS));
        //h4[test-id ^= 'db-w']
        String lblWebStartsWithCSS = "h4[test-id ^= 'db-w']";
        WebElement lblWebText = webDriver.findElement(By.cssSelector(lblWebStartsWithCSS));

        //Discord: Testek - Kiểm thử thực chiến
        //h4[test-id *= 'db-discord']
        String lblDiscordContainsCSS = "h4[test-id *= 'db-discord']";
        WebElement lblDiscordContains = webDriver.findElement(By.cssSelector(lblDiscordContainsCSS));
        //h4[test-id ^= 'db-d']
        String lblDiscordStartsWithCSS = "h4[test-id ^= 'db-d']";
        WebElement lblDiscordText = webDriver.findElement(By.cssSelector(lblDiscordStartsWithCSS));

        // Facebook: Testek - Kiểm thử thực chiến
        //h4[test-id *= 'db-fac']
        String lblFbContainsCSS = "h4[test-id *= 'db-fac']";
        WebElement lblFbContains = webDriver.findElement(By.cssSelector(lblFbContainsCSS));
        //h4[test-id ^= 'db-f']
        String lblFbStartsWith = "h4[test-id ^= 'db-f']";
        WebElement lblFbText = webDriver.findElement(By.cssSelector(lblFbStartsWith));

        //Hotline: 083.286.8822 / Email: vntestek@gmail.com
        //h4[test-id *= 'db-con']
        String lblContactContainsCSS = "h4[test-id *= 'db-con']";
        WebElement lblContactContains = webDriver.findElement(By.cssSelector(lblContactContainsCSS));
        //h4[test-id ^= 'db-con']
        String lblContactStartsWithCSS = "h4[test-id ^= 'db-con']";
        WebElement lblContactText = webDriver.findElement(By.cssSelector(lblContactStartsWithCSS));

        //Các hệ thống Testek cung cấp
        //h4[test-id *= 'db-sy']
        String lblSystemListContainsCSS = "h4[test-id *= 'db-sy']";
        WebElement lblSystemListContains = webDriver.findElement(By.cssSelector(lblSystemListContainsCSS));
        //h4[test-id ^= 'db-sy']
        String lblSystemListStartsWithCSS = "h4[test-id ^= 'db-sy']";
        WebElement lblSystemListText = webDriver.findElement(By.cssSelector(lblSystemListStartsWithCSS));

        //API System: Swagger
        //li[test-id *= 'db-api']
        String lblAPISystemContainsCSS = "li[test-id *= 'db-api']";
        WebElement lblAPISystemContains = webDriver.findElement(By.cssSelector(lblAPISystemContainsCSS));
        //li[test-id ^= 'db-api']
        String lblAPISystemStartsWithCSS = "h4[test-id ^= 'db-api']";
        WebElement lblAPISystemText = webDriver.findElement(By.cssSelector(lblAPISystemContainsCSS));

        //Automation Web: Product Management
        //li[test-id*='db-auto']
        String lblAutoWebContainsCSS = "li[test-id*='db-auto']";
        WebElement lblAutoWebContains = webDriver.findElement(By.cssSelector(lblAutoWebContainsCSS));
        //li[test-id^='db-auto']
        String lblAutoWebStartsWithCSS = "li[test-id^='db-auto']";
        WebElement lblAutoWebText = webDriver.findElement(By.cssSelector(lblAutoWebContainsCSS));

        //Web Element: Basic Web Elements
        //li[test-id*='web-el']
        String lblBasicWebContainsCSS = "li[test-id*='web-el']";
        WebElement lblBasicWebContains = webDriver.findElement(By.cssSelector(lblBasicWebContainsCSS));
        //li[test-id^='db-w']
        String lblBasicWebStartsWithCSS = "li[test-id^='db-w']";
        WebElement lblBasicWebText = webDriver.findElement(By.cssSelector(lblBasicWebContainsCSS));

        //Account List
        //[test-id*='systems-'] li[test-id*='db-'] b
        String lblAccountListContainsCSS = "[test-id*='systems-'] li[test-id*='db-'] b";
        WebElement lblAccountListContains = webDriver.findElement(By.cssSelector(lblAccountListContainsCSS));
        //li[test-id^='db-acc'] b
        String lblAccountListStartsWithCSS = "li[test-id^='db-acc'] b";
        WebElement lblAccountListText = webDriver.findElement(By.cssSelector(lblAccountListStartsWithCSS));

        //Admin: admin_com_role
        //li[test-id*='account-ad']
        String lblAdminRoleContainsCSS = "li[test-id*='account-ad'] ";
        WebElement lblAdminRoleContains = webDriver.findElement(By.cssSelector(lblAdminRoleContainsCSS));
        //li[test-id^='db-account-ad']
        String lblAdminRoleStartsWithCSS = "li[test-id^='db-account-ad']";
        WebElement lblAdminRoleText = webDriver.findElement(By.cssSelector(lblAdminRoleContainsCSS));

        //User: user_com_role
        //li[test-id*='-u']
        String lblUserRoleContainsCSS = "li[test-id*='-u'] ";
        WebElement lblUserRoleContains = webDriver.findElement(By.cssSelector(lblUserRoleContainsCSS));
        //li[test-id^='db-account-u']
        String lblUserRoleStartsWithCSS = "li[test-id^='db-account-u'] ";
        WebElement lblUserRoleText = webDriver.findElement(By.cssSelector(lblUserRoleContainsCSS));

        //Guest: guest_com_role
        //li[test-id*='-g']
        String lblGuestRoleContainsCSS = "li[test-id*='-g'] ";
        WebElement lblGuestRoleContain = webDriver.findElement(By.cssSelector(lblGuestRoleContainsCSS));
        //li[test-id*='db-account-g']
        String lblGuestRoleStartsWithCSS = "li[test-id*='db-account-g'] ";
        WebElement lblGuestRoleStarts = webDriver.findElement(By.cssSelector(lblGuestRoleContainsCSS));

        //Password: aA12345678@
        //li[test-id*='-pa']
        String lblPwdContainsCSS = "li[test-id*='-pa'] ";
        WebElement lblPwdContains = webDriver.findElement(By.cssSelector(lblPwdContainsCSS));
        //li[test-id^='db-account-pa']
        String lblPwdStartsWithCSS = "li[test-id^='db-account-pa'] ";
        WebElement lblPwdText = webDriver.findElement(By.cssSelector(lblPwdContainsCSS));

        //Database: Updating...
        //li[test-id*='-da']
        String lblDBContainsCSS = "li[test-id*='-da'] ";
        WebElement lblDBContains = webDriver.findElement(By.cssSelector(lblDBContainsCSS));
        //li[test-id^='db-da']
        String lblDBStartsWithCSS = "li[test-id^='db-da'] ";
        WebElement lblDBText = webDriver.findElement(By.cssSelector(lblDBContainsCSS));

        //QR: Buy me a coffee
        //img[test-id*='-coff']
        String lblQRImageContainCSS = "img[test-id*='-coff'] ";
        WebElement lblQRImageContains = webDriver.findElement(By.cssSelector(lblQRImageContainCSS));
        //img[test-id^='about-me-coff']
        String lblQRImageStartsWithCSS = "img[test-id^='about-me-coff'] ";
        WebElement lblQRImageText = webDriver.findElement(By.cssSelector(lblQRImageContainCSS));

        //About me
        //h4[test-id*='-me-w']
        String lblAboutMeContainsCSS = "h4[test-id*='-me-w'] ";
        WebElement lblAboutMeContains = webDriver.findElement(By.cssSelector(lblAboutMeContainsCSS));
        //h4[test-id^='about-me-w']
        String lblAboutMeStartsWithCSS = "h4[test-id^='about-me-w'] ";
        WebElement lblAboutMeText = webDriver.findElement(By.cssSelector(lblAboutMeContainsCSS));

        //Separator
        //h4[test-id*='-sepa']
        String lblSeparatorContainsCSS = "h4[test-id*='-sepa'] ";
        WebElement lblSeparatorContains = webDriver.findElement(By.cssSelector(lblSeparatorContainsCSS));
        //h4[test-id^='about-me-sepa']
        String lblSeparatorStartsWithCSS = "h4[test-id^='about-me-sepa'] ";
        WebElement lblSeparatorText = webDriver.findElement(By.cssSelector(lblSeparatorContainsCSS));


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
        //Title: TESTEK - KIỂM THỬ THỰC CHIẾN
        //h2[contains(@test-id,"about-me-title")]
        String lblTitleContainsXpath = "//h2[contains(@test-id,'about-me-title')]";
        WebElement lblTitleContains = webDriver.findElement(By.xpath(lblTitleContainsXpath));
        //h2[starts-with(@test-id,"about-me-title")]
        String lblTitleStartsWithXpath = "//h2[starts-with(@test-id,'about-me-title')]";
        WebElement lblTitleStart = webDriver.findElement(By.xpath(lblTitleStartsWithXpath));
        //b[normalize-space()= 'TESTEK - KIỂM THỬ THỰC CHIẾN']
        String lblTitleNormalSpaceXpath = "//b[normalize-space()= 'TESTEK - KIỂM THỬ THỰC CHIẾN']";
        WebElement lblTitleNormalSpace = webDriver.findElement(By.xpath(lblTitleNormalSpaceXpath));
        //h2[@test-id='about-me-title']/ancestor::div[@test-id='about-me-section']
        String lblTitleAncestorXpath = "//h2[@test-id='about-me-title']/ancestor::div[@test-id='about-me-section']";
        WebElement lblTitleAncestor = webDriver.findElement(By.xpath(lblTitleAncestorXpath));
        //h2[@test-id='about-me-title']/descendant::*
        String lblTitleDescendantXpath = "//h2[@test-id='about-me-title']/descendant::*";
        WebElement lblTitleDescend = webDriver.findElement(By.xpath(lblTitleDescendantXpath));

        //Sub-title: Đào tạo API Testing, Performance Testing, Automation Testing
        //h4[contains(@name, 'db-title-name')]
        String lblSubTitleContainsXpath = "//h4[contains(@name, 'db-title-name')]";
        WebElement lblSubTitleContains = webDriver.findElement(By.xpath(lblSubTitleContainsXpath));
        //h4[starts-with(@name,'db-')]
        String lblSubTitleStartsWithXpath = "//h4[starts-with(@name,'db-')]";
        WebElement lblSubTitleStart = webDriver.findElement(By.xpath(lblSubTitleStartsWithXpath));
        //h4[text()='Đào tạo API Testing, Performance Testing, Automation Testing']
        String lblSubtitleTextXpath = "//h4[text()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        WebElement lblSubTitleText = webDriver.findElement(By.xpath(lblSubtitleTextXpath));
        //h4[@test-id = 'db-title']/ancestor::div[@test-id='about-me-grid-item']
        String lblSubTitleAncestorXpath = "//h4[@test-id = 'db-title']/ancestor::div[@test-id='about-me-grid-item']";
        WebElement lblSubtitleAncestor = webDriver.findElement(By.xpath(lblSubTitleAncestorXpath));
        //h2[@test-id='about-me-title']/following::h4[@class='db-title-class']
        String lblSubtitleFollowingXpath = "//h2[@test-id='about-me-title']/following::h4[@class='db-title-class']";
        WebElement lblSubtitleFollowing = webDriver.findElement(By.xpath(lblSubtitleFollowingXpath));

        //Website: https://testek.vn
        //h4[starts-with(@test-id,'db-w')]
        String lblWebsiteStartsWithXpath = "//h4[starts-with(@test-id,'db-w')]";
        WebElement lblWebStartsWith = webDriver.findElement(By.xpath(lblWebsiteStartsWithXpath));
        //h4[contains(@test-id,'website')]
        String lblWebsiteContainsXpath = "//h4[contains(@test-id,'website')]";
        WebElement lblWebContains = webDriver.findElement(By.xpath(lblWebsiteContainsXpath));
        //div[@test-id='about-me-grid']/descendant::h4[@test-id = 'db-website']
        String lblWebsiteDescendantXpath = "//div[@test-id='about-me-grid']/descendant::h4[@test-id = 'db-website']";
        WebElement lblWebDescendant = webDriver.findElement(By.xpath(lblWebsiteDescendantXpath));
        //h4[@test-id='db-title']/following::h4[@test-id='db-website']
        String lblWebsiteFollowingXpath = "//h4[@test-id='db-title']/following::h4[@test-id='db-website']";
        WebElement lblWebsiteFollowing = webDriver.findElement(By.xpath(lblWebsiteFollowingXpath));
        //h4[@test-id='db-facebook']/preceding-sibling::h4[@test-id='db-website']
        String lblWebsitePreSibXpath = "//h4[@test-id='db-facebook']/preceding-sibling::h4[@test-id='db-website']";
        WebElement lblWebsitePreSib = webDriver.findElement(By.xpath(lblWebsitePreSibXpath));

        //Discord: Testek - Kiểm thử thực chiến
        //h4[contains(@test-id,'discord')]
        String lblDiscordContainsXpath = "//h4[contains(@test-id,'discord')]";
        WebElement lblDiscordContains = webDriver.findElement(By.xpath(lblDiscordContainsXpath));
        //h4[text()='Discord: ']
        String lblDiscordTextXpath = "//h4[text()='Discord: ']";
        WebElement lblDiscordText = webDriver.findElement(By.xpath(lblDiscordTextXpath));
        //div[@test-id='about-me-grid']/descendant::h4[@test-id = 'db-discord']
        String lblDiscordDescendantXpath = "//div[@test-id='about-me-grid']/descendant::h4[@test-id = 'db-discord']";
        WebElement lblDiscordDes = webDriver.findElement(By.xpath(lblDiscordDescendantXpath));
        //h4[@test-id='db-facebook']/preceding-sibling::h4[@test-id='db-discord']
        String lblDiscordPreSibXpath = "//h4[@test-id='db-facebook']/preceding-sibling::h4[@test-id='db-discord']";
        WebElement lblDiscordPreSib = webDriver.findElement(By.xpath(lblDiscordPreSibXpath));
        //h4[@test-id='db-website']/following-sibling::h4[@test-id='db-discord']
        String lblDiscordFollowingSibXpath = "//h4[@test-id='db-website']/following-sibling::h4[@test-id='db-discord']";
        WebElement lblDiscordFollowingSib = webDriver.findElement(By.xpath(lblDiscordFollowingSibXpath));

        // Facebook: Testek - Kiểm thử thực chiến
        //h4[contains(@test-id,'db-f')]
        String lblFbContainsXpath = "//h4[contains(@test-id,'db-f')]";
        WebElement lblFbContains = webDriver.findElement(By.xpath(lblFbContainsXpath));
        //h4[text()='Facebook: ']
        String lblFbTextXpath = "//h4[text()='Facebook: ']";
        WebElement lblFbText = webDriver.findElement(By.xpath(lblFbTextXpath));
        //div[@test-id='about-me-grid']/descendant::h4[@test-id='db-facebook']
        String lblFbDescendantXpath = "//div[@test-id='about-me-grid']/descendant::h4[@test-id='db-facebook']";
        WebElement lblFbDescend = webDriver.findElement(By.xpath(lblFbDescendantXpath));
        //h4[@test-id='db-contact']/preceding-sibling::h4[@test-id='db-facebook']
        String lblFbPreSibXpath = "//h4[@test-id='db-contact']/preceding-sibling::h4[@test-id='db-facebook']";
        WebElement lblFbPreSib = webDriver.findElement(By.xpath(lblFbPreSibXpath));
        //h4[@test-id='db-discord']/following-sibling::h4[@test-id='db-facebook']
        String lblFbFollowingSibXpath = "//h4[@test-id='db-discord']/following-sibling::h4[@test-id='db-facebook']";
        WebElement lblFbFollowingSib = webDriver.findElement(By.xpath(lblFbFollowingSibXpath));

        //Hotline: 083.286.8822 / Email: vntestek@gmail.com
        //h4[text()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']
        String lblContactTextXpath = "//h4[text()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        WebElement lblContactText = webDriver.findElement(By.xpath(lblContactTextXpath));
        //h4[starts-with(@test-id,'db-c')]
        String lblContactStartsWithXpath = "//h4[starts-with(@test-id,'db-c')]";
        WebElement lblContactStart = webDriver.findElement(By.xpath(lblContactStartsWithXpath));
        //h4[normalize-space() ='Hotline: 083.286.8822 / Email: vntestek@gmail.com']
        String lblContactNormalizeSpaceXpath = "//h4[normalize-space() ='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        WebElement lblContactNormalize = webDriver.findElement(By.xpath(lblContactNormalizeSpaceXpath));
        //div[@test-id='about-me-grid']/descendant::h4[@test-id='db-contact']
        String lblContactDescendantXpath = "//div[@test-id='about-me-grid']/descendant::h4[@test-id='db-contact']";
        WebElement lblContactDescend = webDriver.findElement(By.xpath(lblContactDescendantXpath));
        //h4[@test-id='db-systems']/preceding-sibling::h4[@test-id='db-contact']
        String lblContactPreSibXpath = "//h4[@test-id='db-systems']/preceding-sibling::h4[@test-id='db-contact']";
        WebElement lblContactPreSib = webDriver.findElement(By.xpath(lblContactPreSibXpath));

        //Các hệ thống Testek cung cấp
        //h4[contains(@test-id,'db-sy')]
        String lblSystemListContainsXpath = "//h4[contains(@test-id,'db-sy')]";
        WebElement lblSystemContains = webDriver.findElement(By.xpath(lblSystemListContainsXpath));
        //h4[starts-with(@test-id,'db-s')]
        String lblSystemListStartsWithXpath = "//h4[starts-with(@test-id,'db-s')]";
        WebElement lblSystemStart = webDriver.findElement(By.xpath(lblSystemListStartsWithXpath));
        //h4[text()='Các hệ thống Testek cung cấp']
        String lblSystemListTextXpath = "//h4[text()='Các hệ thống Testek cung cấp']";
        WebElement lblSystemText = webDriver.findElement(By.xpath(lblSystemListTextXpath));
        //div[@test-id='about-me-grid-item']/child::h4[@test-id='db-systems']
        String lblSystemListChildXpath = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-systems']";
        WebElement lblSystemChild = webDriver.findElement(By.xpath(lblSystemListChildXpath));

        //API System: Swagger
        //li[contains(@test-id,'db-api')]
        String lblAPISystemContainsXpath = "//li[contains(@test-id,'db-api')]";
        WebElement lblAPISystem = webDriver.findElement(By.xpath(lblAPISystemContainsXpath));
        //li[starts-with(@test-id,'db-ap')]
        String lblAPISystemStartsWithXpath = "//li[starts-with(@test-id,'db-ap')]";
        WebElement lblAPISystemStart = webDriver.findElement(By.xpath(lblAPISystemStartsWithXpath));
        //ul[@test-id='db-systems-list']/child::li[@test-id='db-api-system']
        String lblAPISystemChildXpath = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-api-system']";
        WebElement lblAPISystemChild = webDriver.findElement(By.xpath(lblAPISystemChildXpath));
        //li[@test-id='db-automation-web']/preceding-sibling::li[@test-id='db-api-system']
        String lblAPISystemPreSibXpath = "//li[@test-id='db-automation-web']/preceding-sibling::li[@test-id='db-api-system']";
        WebElement lblAPISystemPreSib = webDriver.findElement(By.xpath(lblAPISystemPreSibXpath));

        //Automation Web: Product Management
        //li[contains(@test-id,'db-web')]
        String AutoWebContainsXpath = "//li[contains(@test-id,'db-web')]";
        WebElement lblAutoWeb = webDriver.findElement(By.xpath(AutoWebContainsXpath));
        //li[starts-with(@test-id,'db-w')]
        String AutoWebStartsWithXpath = "//li[starts-with(@test-id,'db-w')]";
        WebElement lblAutoWebStart = webDriver.findElement(By.xpath(AutoWebStartsWithXpath));
        //ul[@test-id='db-systems-list']/child::li[@test-id='db-web-element']
        String lblAutoWebChildXpath = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-web-element']";
        WebElement lblAutoWebChild = webDriver.findElement(By.xpath(lblAutoWebChildXpath));
        //li[@test-id='db-automation-web']/following-sibling::li[@test-id='db-web-element']
        String lblAutoWebFollowingSibXpath = "//li[@test-id='db-automation-web']/following-sibling::li[@test-id='db-web-element']";
        WebElement lblAutoWebFollowingSib = webDriver.findElement(By.xpath(lblAutoWebFollowingSibXpath));


        //Web Element: Basic Web Elements
        //li[text()='Web Element:']
        String lblBasicWebTextXpath = "//li[text()='Web Element:']";
        WebElement lblBasicWebText = webDriver.findElement(By.xpath(lblBasicWebTextXpath));
        //li[contains(normalize-space(), 'Web Element')]
        String lblBasicWebNormalizeSpaceXpath = "//li[contains(normalize-space(), 'Web Element')]";
        WebElement lblABasicWebNormalize = webDriver.findElement(By.xpath(lblBasicWebNormalizeSpaceXpath));
        //li[starts-with(@test-id,'db-we')]
        String lblBasicWebStartsWithXpath = "//li[starts-with(@test-id,'db-we')]";
        WebElement lblBasicWebStart = webDriver.findElement(By.xpath(lblBasicWebStartsWithXpath));
        //ul[@test-id='db-systems-list']/child::li[@test-id='db-web-element']
        String lblBasicWebChildXpath = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-web-element']";
        WebElement lblBasicWebChild = webDriver.findElement(By.xpath(lblBasicWebChildXpath));
        //li[@test-id='db-automation-web']/following-sibling::li[@test-id='db-web-element']
        String lblBasicWebFollowingSibXpath = "//li[@test-id='db-automation-web']/following-sibling::li[@test-id='db-web-element']";
        WebElement lblBasicWebFollowing = webDriver.findElement(By.xpath(lblBasicWebFollowingSibXpath));

        //Account list:
        //li[contains(normalize-space(), 'for API System & Automation Web')]
        String lblAccListNormalizeSpaceXpath = "//li[contains(normalize-space(), 'for API System & Automation Web')]";
        WebElement lblAccListNormalSpace = webDriver.findElement(By.xpath(lblAccListNormalizeSpaceXpath));
        //li[@test-id='db-account-password']/ancestor::li[@test-id='db-account']
        String lblAccListAncestorXpath = "//li[@test-id='db-account-password']/ancestor::li[@test-id='db-account']";
        WebElement lblAccListAncestor = webDriver.findElement(By.xpath(lblAccListAncestorXpath));
        //ul[@test-id='db-systems-list']/child::li[@test-id='db-account']
        String lblAccListChildXpath = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-account']";
        WebElement lblAccListChild = webDriver.findElement(By.xpath(lblAccListChildXpath));
        //ul[@test-id='db-account-list']/parent::li[@test-id='db-account']
        String lblAccListParentXpath = "//ul[@test-id='db-account-list']/parent::li[@test-id='db-account']";
        WebElement lblAccListParent = webDriver.findElement(By.xpath(lblAccListParentXpath));
        //li[@test-id='db-database']/preceding-sibling::li[@test-id='db-account']
        String lblAccListPreSibXpath = "//li[@test-id='db-database']/preceding-sibling::li[@test-id='db-account']";
        WebElement lblAccListPreSib = webDriver.findElement(By.xpath(lblAccListPreSibXpath));

        //Admin: admin_com_role
        //li[text()='Admin: admin_com_role ']
        String lblAdminRoleTextXpath = "//li[text()='Admin: admin_com_role ']";
        WebElement lblAdminRoleText = webDriver.findElement(By.xpath(lblAdminRoleTextXpath));
        //li[starts-with(@test-id,'db-account-a')]
        String lblAdminRoleStartsWithXpath = "//li[starts-with(@test-id,'db-account-a')]";
        WebElement lblAdminRoleStart = webDriver.findElement(By.xpath(lblAdminRoleStartsWithXpath));
        //li[@test-id='db-account']/descendant::li[@test-id='db-account-admin']
        String lblAdminRoleDescendantXpath = "//li[@test-id='db-account']/descendant::li[@test-id='db-account-admin']";
        WebElement lblAdminRoleDescend = webDriver.findElement(By.xpath(lblAdminRoleDescendantXpath));
        //li[@test-id='db-account-user']/preceding-sibling::li[@test-id='db-account-admin']
        String lblAdminRolePreSibXpath = "//li[@test-id='db-account-user']/preceding-sibling::li[@test-id='db-account-admin']";
        WebElement lblAdminRolePreSib = webDriver.findElement(By.xpath(lblAdminRolePreSibXpath));

        //User: user_com_role
        //li[text()='User: user_com_role ']
        String lblUserRoleTextXpath = "//li[text()='User: user_com_role ']";
        WebElement lblUserRoleText = webDriver.findElement(By.xpath(lblUserRoleTextXpath));
        //li[starts-with(@test-id,'db-account-u')]
        String lblUserRoleStartsWithXpath = "//li[starts-with(@test-id,'db-account-u')]";
        WebElement lblUserRoleStart = webDriver.findElement(By.xpath(lblUserRoleStartsWithXpath));
        //li[@test-id='db-account']/descendant::li[@test-id='db-account-user']
        String lblUserRoleDescendantXpath = "//li[@test-id='db-account']/descendant::li[@test-id='db-account-user']";
        WebElement lblUserRoleDescend = webDriver.findElement(By.xpath(lblUserRoleDescendantXpath));
        //li[@test-id='db-account-admin']/following-sibling::li[@test-id='db-account-user']
        String lblUserRoleFollowingSibXpath = "//li[@test-id='db-account-admin']/following-sibling::li[@test-id='db-account-user']";
        WebElement lblUserRoleFollowing = webDriver.findElement(By.xpath(lblUserRoleFollowingSibXpath));

        //Guest: guest_com_role
        //li[text()='Guest: guest_com_role ']
        String lblGuestRoleTextXpath = "//li[text()='Guest: guest_com_role ']";
        WebElement lblGuestRoleText = webDriver.findElement(By.xpath(lblGuestRoleTextXpath));
        //li[starts-with(@test-id,'db-account-g')]
        String lblGuestRoleStartsWith = "//li[starts-with(@test-id,'db-account-g')]";
        WebElement lblGuestRoleStart = webDriver.findElement(By.xpath(lblGuestRoleStartsWith));
        //li[@test-id='db-account']/descendant::li[@test-id='db-account-guest']
        String lblGuestRoleDescendantXpath = "//li[@test-id='db-account']/descendant::li[@test-id='db-account-guest']";
        WebElement lblGuestRoleDescend = webDriver.findElement(By.xpath(lblGuestRoleDescendantXpath));
        //li[@test-id='db-account-password']/preceding-sibling::li[@test-id='db-account-guest']
        String lblGuestRolePreSibXpath = "//li[@test-id='db-account-password']/preceding-sibling::li[@test-id='db-account-guest']";
        WebElement lblGuestRolePreSib = webDriver.findElement(By.xpath(lblGuestRolePreSibXpath));
        //li[@test-id='db-account-user']/following-sibling::li[@test-id='db-account-guest']
        String lblGuestRoleFollowingSibXpath = "//li[@test-id='db-account-user']/following-sibling::li[@test-id='db-account-guest']";
        WebElement lblGuestRoleFollowingSib = webDriver.findElement(By.xpath(lblGuestRoleFollowingSibXpath));

        //Password: aA12345678@
        //li[text()='Password: aA12345678@ ']
        String lblPwdTextXpath = "//li[text()='Password: aA12345678@ ']";
        WebElement lblPwdText = webDriver.findElement(By.xpath(lblPwdTextXpath));
        //li[starts-with(@test-id,'db-account-pa')]
        String lblPwdStartsWithXpath = "//li[starts-with(@test-id,'db-account-pa')]";
        WebElement lblPwdStart = webDriver.findElement(By.xpath(lblPwdStartsWithXpath));
        //li[@test-id='db-account']/descendant::li[@test-id='db-account-password']
        String lblPwdDescendantXpath = "//li[@test-id='db-account']/descendant::li[@test-id='db-account-password']";
        WebElement lblPwdDescend = webDriver.findElement(By.xpath(lblPwdDescendantXpath));
        //li[@test-id='db-account-guest']/following-sibling::li[@test-id='db-account-password']
        String lblPwdFollowingSib = "//li[@test-id='db-account-guest']/following-sibling::li[@test-id='db-account-password']";
        WebElement lblPwdFollowing = webDriver.findElement(By.xpath(lblPwdFollowingSib));

        //Database: Updating...
        //li[contains(normalize-space(), 'Database: Updating...')]
        String lblDBContainsXpath = "//li[contains(normalize-space(), 'Database: Updating...')]";
        WebElement lblDBNormalize = webDriver.findElement(By.xpath(lblDBContainsXpath));
        //li[starts-with(@test-id,'db-da')]
        String lblDBStartsWithXpath = "//li[starts-with(@test-id,'db-da')]";
        WebElement lblDBStart = webDriver.findElement(By.xpath(lblDBStartsWithXpath));
        //ul[@test-id='db-systems-list']/child::li[@test-id='db-database']
        String lblDBChildXpath = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-database']";
        WebElement lblDBChild = webDriver.findElement(By.xpath(lblDBChildXpath));
        //li[@test-id='db-account']/following-sibling::li[@test-id='db-database']
        String lblDBFollowingSibXpath = "//li[@test-id='db-account']/following-sibling::li[@test-id='db-database']";
        WebElement lblDBFollowing = webDriver.findElement(By.xpath(lblDBFollowingSibXpath));

        //QR: Buy me a coffee
        //p[@test-id='about-me-coffee-text']/ancestor::div[@class='grid-item']
        String lblQRImageAncestorXpath = "//p[@test-id='about-me-coffee-text']/ancestor::div[@class='grid-item']";
        WebElement lblQRImageAncestor = webDriver.findElement(By.xpath(lblQRImageAncestorXpath));
        //h4[@test-id='about-me-separator']/preceding::img[@test-id='about-me-coffee-img']
        String lblQRImagePreXpath = "//h4[@test-id='about-me-separator']/preceding::img[@test-id='about-me-coffee-img']";
        WebElement lblQRImage = webDriver.findElement(By.xpath(lblQRImagePreXpath));
        //div[@class='grid-item']/following-sibling::div/img
        String lblQRImageFollowingSibXpath = "//div[@class='grid-item']/following-sibling::div/img";
        WebElement lblQRImageFollowingSib = webDriver.findElement(By.xpath(lblQRImageFollowingSibXpath));
        //div[@class='grid-item']/descendant::img
        String lblQRImageDescendantXpath = "//div[@class='grid-item']/descendant::img";
        WebElement lblQRImageDescend = webDriver.findElement(By.xpath(lblQRImageDescendantXpath));

        //About me
        //h4[contains(normalize-space(), 'HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING')]
        String lblAboutMeNormalizeSpaceXpath = "//h4[contains(normalize-space(), 'HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING')]";
        WebElement lblAboutMeNormalize = webDriver.findElement(By.xpath(lblAboutMeNormalizeSpaceXpath));
        //h4[starts-with(@test-id,'about-me-w')]
        String lblAboutMeStartsWithXpath = "//h4[starts-with(@test-id,'about-me-w')]";
        WebElement lblAboutMeStart = webDriver.findElement(By.xpath(lblAboutMeStartsWithXpath));
        //h2[@test-id='about-me-title']/following::h4[@test-id='about-me-web-elements']
        String lblAboutMeFollowingXpath = "//h2[@test-id='about-me-title']/following::h4[@test-id='about-me-web-elements']";
        WebElement lblAboutMeFollowing = webDriver.findElement(By.xpath(lblAboutMeFollowingXpath));
        //h4[@test-id='about-me-separator']/preceding::h4[@test-id='about-me-web-elements']
        String lblAboutMePreXpath = "//h4[@test-id='about-me-separator']/preceding::h4[@test-id='about-me-web-elements']";
        WebElement lblAboutMePre = webDriver.findElement(By.xpath(lblAboutMePreXpath));

        //Separator
        //h4[contains(normalize-space(), '--------------')]
        String lblSeparatorContainsXpath = "//h4[contains(normalize-space(), '--------------')]";
        WebElement lblSeparator = webDriver.findElement(By.xpath(lblSeparatorContainsXpath));
        //h4[starts-with(@test-id,'about-me-se')]
        String lblSeparatorStartsWithXpath = "//h4[starts-with(@test-id,'about-me-se')]";
        WebElement lblSeparatorStart = webDriver.findElement(By.xpath(lblSeparatorStartsWithXpath));
        //h2[@test-id='about-me-title']/following::h4[@test-id='about-me-separator']
        String lblSeparatorFollowingXpath = "//h2[@test-id='about-me-title']/following::h4[@test-id='about-me-separator']";
        WebElement lblSeparatorFollowing = webDriver.findElement(By.xpath(lblSeparatorFollowingXpath));
        //blockquote[@test-id='tiktok-embed']/preceding::h4[@test-id='about-me-separator']
        String lblSeparatorPreXpath = "//blockquote[@test-id='tiktok-embed']/preceding::h4[@test-id='about-me-separator']";
        WebElement lblSeparatorPre = webDriver.findElement(By.xpath(lblSeparatorPreXpath));


    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
