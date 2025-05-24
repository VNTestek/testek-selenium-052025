package com.testek.study.lesson03.exercise;

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
    /**
     * Description:
     * This method demonstrates how to locate various elements on a webpage using CSS selectors.
     * It navigates to the test website and uses different CSS selector strategies such as `contains`, `starts-with`, etc.
     **/
    public void findAdvanceLocatorWithCSS() {
        // Navigate to the test website
        gotoTestWebsite();

        // Locate the text: “TESTEK - KIỂM THỬ THỰC CHIẾN”
        String lblTitleCSSWithContains = "[test-id*='me-title']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblTitleCSSWithContains));
        String lblTitleCSSWithStarts = "[test-id^='about-me-t']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblTitleCSSWithStarts));

        // Locate the text: "Đào tạo API Testing, Performance Testing, Automation Testing"
        String lblDescriptionCSSWithContains = "[test-id*='db-t']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblDescriptionCSSWithContains));
        String lblDescriptionCSSWithStarts = "[id^='db-t']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblDescriptionCSSWithStarts));

        // Locate the link: Website
        String lblWebsiteCSSWithContains = "h4[test-id*='website']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblWebsiteCSSWithContains));
        String lblWebsiteCSSWithStarts = "h4[test-id^='db-web']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblWebsiteCSSWithStarts));

        // Locate the link: Discord
        String lblDiscordCSSWithContains = "[id*='db-dis']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblDiscordCSSWithContains));
        String lblDiscordCSSWithStarts = "[id^='db-dis']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblDiscordCSSWithStarts));

        // Locate the link: Facebook
        String lblFbCSSWithContains = "[test-id*='facebook-link']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblFbCSSWithContains));
        String lblFbCSSWithStarts = "h4[test-id^='db-fa']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblFbCSSWithStarts));

        // Locate the text: Hotline
        String lblHotlineCSSWithContains = "h4[test-id*='contact']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblHotlineCSSWithContains));
        String lblHotlineCSSWithStarts = "h4[test-id^='db-con']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblHotlineCSSWithStarts));

        // Locate the text: Các hệ thống Testek cung cấp
        String lblSystemTitleCSSWithContains = "h4[test-id*='systems']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblSystemTitleCSSWithContains));
        String lblSystemTitleCSSWithStarts = "h4[test-id^='db-sys']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblSystemTitleCSSWithStarts));

        // Locate the link text: API System
        String lblApiSystemCSSWithContains = "li[test-id*='db-api']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblApiSystemCSSWithContains));
        String lblApiSystemCSSWithStarts = "a[test-id^='db-api']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblApiSystemCSSWithStarts));

        // Locate the link text: Automation Web
        String lblAutoWebCSSWithContains = "li[test-id*='automation']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblAutoWebCSSWithContains));
        String lblAutoWebCSSWithStarts = "li[test-id^='db-auto']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblAutoWebCSSWithStarts));

        // Locate the link text: Web Element
        String lblWebEleCSSWithContains = "[test-id*='element-link']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblWebEleCSSWithContains));
        String lblWebEleCSSWithStarts = "li[test-id^='db-web']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblWebEleCSSWithStarts));

        // Locate the text: ACCOUNT
        String lblAccountCSSWithContains = "[test-id*='systems-'] li[test-id*='db-'] b"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblAccountCSSWithContains));
        String lblAccountCSSWithStarts = "[test-id^='db-acc'] b"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblAccountCSSWithStarts));

        // Locate the text: Admin_com_role
        String lblAdminComRoleCSSWithContains = "li[test-id*='account-ad']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblAdminComRoleCSSWithContains));
        String lblAdminComRoleCSSWithStarts = "li[test-id^='db-account-a']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblAdminComRoleCSSWithStarts));

        // Locate the text: user_com_role
        String lblUserComRoleCSSWithContains = "li[test-id*='account-us']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblUserComRoleCSSWithContains));
        String lblUserComRoleCSSWithStarts = "li[test-id^='db-account-u']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblUserComRoleCSSWithStarts));

        // Locate the text: guest_com_role
        String lblGuestComRoleCSSWithContains = "li[test-id*='account-gu']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblGuestComRoleCSSWithContains));
        String lblGuestComRoleCSSWithStarts = "li[test-id^='db-account-g']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblGuestComRoleCSSWithStarts));

        // Locate the text: Password: aA12345678@
        String lblPasswordCssWithContains = "li[test-id*='pass']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblPasswordCssWithContains));
        String lblPasswordCSSWithStarts = "li[test-id^='db-account-p']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblPasswordCSSWithStarts));

        // Locate the text: Database: Updating...
        String lblDbCssWithContains = "li[test-id*='-data']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblDbCssWithContains));
        String lblDbCSSWithStarts = "li[test-id^='db-da']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblDbCSSWithStarts));

        // Locate the text: HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN
        String lblAboutMeWebEleCssWithContains = "h4[test-id*='web-ele']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblAboutMeWebEleCssWithContains));
        String lblAboutMeWebEleCSSWithStarts = "[test-id^='about-me-web']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblAboutMeWebEleCSSWithStarts));

        // Locate the QR code image
        String lblQrCssWithContains = "img[test-id*='coffee']"; // CSS selector using `contains`
        webDriver.findElement(By.cssSelector(lblQrCssWithContains));
        String lblQrCSSWithStarts = "img[test-id^='about-me-co']"; // CSS selector using `starts-with`
        webDriver.findElement(By.cssSelector(lblQrCSSWithStarts));
    }


    @Test(description = "Find element with XPath")
    /*
     * Description:
     * This method demonstrates how to locate various elements on a webpage using XPath selectors.
     * It navigates to the test website and uses different XPath selector strategies such as `contains`, `starts-with`, etc.
     */
    public void findAdvanceLocatorWithXPath() {
        gotoTestWebsite();

        // Locate the text: “TESTEK - KIỂM THỬ THỰC CHIẾN”
        String lblTitleXPathWithContains = "//h2[contains(@test-id,'about-me')]";
        webDriver.findElement(By.xpath(lblTitleXPathWithContains));
        String lblTitleXPathWithStarts = "//h2[starts-with(@test-id,'about-')]";
        webDriver.findElement(By.xpath(lblTitleXPathWithStarts));
        String lblTitleXPathWithNormalize = "//b[normalize-space()='TESTEK - KIỂM THỬ THỰC CHIẾN']";
        webDriver.findElement(By.xpath(lblTitleXPathWithNormalize));
        String lblTitleXPathWithAncestor = "//b[normalize-space()='TESTEK - KIỂM THỬ THỰC CHIẾN']/ancestor::h2";
        webDriver.findElement(By.xpath(lblTitleXPathWithAncestor));
        String lblTitleXPathWithPrecedingSibling = "//h4[starts-with(@test-id,'about-me-web')]/preceding-sibling::h2/b";
        webDriver.findElement(By.xpath(lblTitleXPathWithPrecedingSibling));
        String lblTitleXPathWithDescendant = "//div[@test-id='content-root']/descendant::h2";
        webDriver.findElement(By.xpath(lblTitleXPathWithDescendant));
        String lblTitleXPathWithFollowingSibling = "//div[@test-id='sidebar-root']/following-sibling::div/descendant::h2";
        webDriver.findElement(By.xpath(lblTitleXPathWithFollowingSibling));
        String lblTitleXPathWithPreceding = "//h4[@test-id='about-me-web-elements']/preceding::h2";
        webDriver.findElement(By.xpath(lblTitleXPathWithPreceding));
        String lblTitleXPathWithFollowing = "//div[@test-id='sidebar-root']/following::div[@test-id='content-root']";
        webDriver.findElement(By.xpath(lblTitleXPathWithFollowing));
        String lblTitleXPathWithParent = "//b/parent::h2[@test-id='about-me-title']";
        webDriver.findElement(By.xpath(lblTitleXPathWithParent));
        String lblTitleXPathWithChild = "//div[@id='about-me']/child::h2";
        webDriver.findElement(By.xpath(lblTitleXPathWithChild));

        // Locate the text: "Đào tạo API Testing, Performance Testing, Automation Testing"
        String lblDescriptionXPathWithExactText = "//h4[text()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithExactText));
        String lblDescriptionXPathWithContains = "//h4[contains(@id,'db-t')]";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithContains));
        String lblDescriptionXPathWithStarts = "//h4[starts-with(@id,'db-t')]";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithStarts));
        String lblDescriptionXPathWithNormalize = "//h4[normalize-space()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithNormalize));
        String lblDescriptionXPathWithAncestor = "//a[@test-id='db-website-link']/ancestor::h4/preceding-sibling::h4";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithAncestor));
        String lblDescriptionXPathWithPrecedingSibling = "//h4[@test-id='db-website']/preceding-sibling::h4";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithPrecedingSibling));
        String lblDescriptionXPathWithDescendant = "//body[@test-id='body-root']/descendant::h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithDescendant));
        String lblDescriptionXPathWithFollowingSibling = "//h2[@test-id='about-me-title']/following-sibling::div/div/h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithFollowingSibling));
        String lblDescriptionXPathWithPreceding = "//h4[@test-id='db-facebook']/preceding::h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithPreceding));
        String lblDescriptionXPathWithFollowing = "//h2[@test-id='about-me-title']/following::div[@test-id='about-me-grid']/div/h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithFollowing));
        String lblDescriptionXPathWithChild = "//div[@test-id='about-me-grid-item']/child::h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(lblDescriptionXPathWithChild));

        //TÌM KIẾM ĐOẠN TEXT: “TESTEK - KIỂM THỬ THỰC CHIẾN”
        String containsTitleXpath = "//h2[contains(@test-id,'about-me')]";
        webDriver.findElement(By.xpath(containsTitleXpath));
        String startsTitleXpath = "//h2[starts-with(@test-id,'about-')]";
        webDriver.findElement(By.xpath(startsTitleXpath));
        String normalizeTitle = "//b[normalize-space()='TESTEK - KIỂM THỬ THỰC CHIẾN']";
        webDriver.findElement(By.xpath(normalizeTitle));
        String ancestorTitle = "//b[normalize-space()='TESTEK - KIỂM THỬ THỰC CHIẾN']/ancestor::h2";
        webDriver.findElement(By.xpath(ancestorTitle));
        String precedingSibTitle = "//h4[starts-with(@test-id,'about-me-web')]/preceding-sibling::h2/b";
        webDriver.findElement(By.xpath(precedingSibTitle));
        String descendantTitle = "//div[@test-id='content-root']/descendant::h2";
        webDriver.findElement(By.xpath(descendantTitle));
        String followingSibTitle = "//div[@test-id='sidebar-root']/following-sibling::div/descendant::h2";
        webDriver.findElement(By.xpath(followingSibTitle));
        String precedingTitle = "//h4[@test-id='about-me-web-elements']/preceding::h2";
        webDriver.findElement(By.xpath(precedingTitle));
        String followingTitle = "//div[@test-id='sidebar-root']/following::div[@test-id='content-root']";
        webDriver.findElement(By.xpath(followingTitle));
        String parentTitle = "//b/parent::h2[@test-id='about-me-title']";
        webDriver.findElement(By.xpath(parentTitle));
        String childTitle = "//div[@id='about-me']/child::h2";
        webDriver.findElement(By.xpath(childTitle));

        //TÌM KIẾM ĐOẠN TEXT: "Đào tạo API Testing, Performance Testing, Automation Testing"
        String txtDescription = "//h4[text()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        webDriver.findElement(By.xpath(txtDescription));
        String containsDescription = "//h4[contains(@id,'db-t')]";
        webDriver.findElement(By.xpath(containsDescription));
        String startsDescription = "//h4[starts-with(@id,'db-t')]";
        webDriver.findElement(By.xpath(startsDescription));
        String normalizeDescription = "//h4[normalize-space()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        webDriver.findElement(By.xpath(normalizeDescription));
        String ancestorDescription = "//a[@test-id='db-website-link']/ancestor::h4/preceding-sibling::h4";
        webDriver.findElement(By.xpath(ancestorDescription));
        String precedingSibDescription = "//h4[@test-id='db-website']/preceding-sibling::h4";
        webDriver.findElement(By.xpath(precedingSibDescription));
        String descendantDescription = "//body[@test-id='body-root']/descendant::h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(descendantDescription));
        String followingSibDescription = "//h2[@test-id='about-me-title']/following-sibling::div/div/h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(followingSibDescription));
        String precedingDescription = "//h4[@test-id='db-facebook']/preceding::h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(precedingDescription));
        String followingDescription = "//h2[@test-id='about-me-title']/following::div[@test-id='about-me-grid']/div/h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(followingDescription));
        String childDescription = "//div[@test-id='about-me-grid-item']/child::h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(childDescription));

        //TÌM KIẾM LINK Website
        String txtWebsite = "//h4[text()='Website: ']";
        webDriver.findElement(By.xpath(txtWebsite));
        String containsWebsite = "//h4[contains(text(),'Web')]";
        webDriver.findElement(By.xpath(containsWebsite));
        String startsWebsite = "//h4[starts-with(text(),'Web')]";
        webDriver.findElement(By.xpath(startsWebsite));
        String normalizeWebsite = "//a[normalize-space()='https://testek.vn']";
        webDriver.findElement(By.xpath(normalizeWebsite));
        String ancestorWebsite = "//a[@test-id='db-website-link']/ancestor::h4";
        webDriver.findElement(By.xpath(ancestorWebsite));
        String precedingSibWebsite = "//h4[@test-id='db-contact']/preceding-sibling::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(precedingSibWebsite));
        String descendantWebsite = "//div[@test-id='about-me-grid']/descendant::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(descendantWebsite));
        String followingSibWebsite = "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(followingSibWebsite));
        String precedingWebsite = "//h4[@test-id='db-systems']/preceding::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(precedingWebsite));
        String followingWebsite = "//h4[@test-id='db-title']/following::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(followingWebsite));
        String parentWebsite = "//a[@test-id='db-website-link']/parent::h4";
        webDriver.findElement(By.xpath(parentWebsite));
        String childWebsite = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(childWebsite));

        //TÌM KIÊM LINK: Discord:
        String txtDiscord = "//h4[text()='Discord: ']";
        webDriver.findElement(By.xpath(txtDiscord));
        String containsDiscord = "//h4[contains(text(),'Dis')]";
        webDriver.findElement(By.xpath(containsDiscord));
        String startsDiscord = "//h4[starts-with(text(),'Dis')]";
        webDriver.findElement(By.xpath(startsDiscord));
        String normalizeDiscord = "//a[normalize-space()='Testek - Kiểm thử thực chiến']/ancestor::h4[@id='db-discord']";
        webDriver.findElement(By.xpath(normalizeDiscord));
        String ancestorDiscord = "//a[@test-id='db-discord-link']/ancestor::h4";
        webDriver.findElement(By.xpath(ancestorDiscord));
        String precedingSibDiscord = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(precedingSibDiscord));
        String descendantDiscord = "//h4[@test-id='db-discord']/descendant::a";
        webDriver.findElement(By.xpath(descendantDiscord));
        String followingSibDiscord = "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(followingSibDiscord));
        String precedingDiscord = "//h4[@test-id='db-systems']/preceding::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(precedingDiscord));
        String followingDiscord = "//h4[@test-id='db-title']/following::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(followingDiscord));
        String parentDiscord = "//a[@test-id='db-discord-link']/parent::h4";
        webDriver.findElement(By.xpath(parentDiscord));
        String childDiscord = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(childDiscord));

        //TÌM KIẾM LINK: Facebook:
        String txtFb = "//h4[text()='Facebook: ']";
        webDriver.findElement(By.xpath(txtFb));
        String containsFb = "//h4[contains(text(),'Fa')]";
        webDriver.findElement(By.xpath(containsFb));
        String startsFb = "//h4[starts-with(text(),'Fa')]";
        webDriver.findElement(By.xpath(startsFb));
        String normalizeFb = "//a[normalize-space()='Testek - Kiểm thử thực chiến']/ancestor::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(normalizeFb));
        String ancestorFb = "//a[@test-id='db-facebook-link']/ancestor::h4";
        webDriver.findElement(By.xpath(ancestorFb));
        String precedingSibFb = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(precedingSibFb));
        String descendantFb = "//h4[@test-id='db-facebook']/descendant::a";
        webDriver.findElement(By.xpath(descendantFb));
        String followingSibFb = "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(followingSibFb));
        String precedingFb = "//h4[@test-id='db-systems']/preceding::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(precedingFb));
        String followingFb = "//h4[@test-id='db-title']/following::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(followingFb));
        String parentFb = "//a[@test-id='db-facebook-link']/parent::h4";
        webDriver.findElement(By.xpath(parentFb));
        String childFb = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(childFb));

        //TÌM KIẾM ĐOẠN TEXT: Hotline:
        String txtHotline = "//h4[text()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        webDriver.findElement(By.xpath(txtHotline));
        String containsHotline = "//h4[contains(text(),'Email')]";
        webDriver.findElement(By.xpath(containsHotline));
        String startsHotline = "//h4[starts-with(text(),'Hotline')]";
        webDriver.findElement(By.xpath(startsHotline));
        String normalizeHotline = "//h4[normalize-space()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        webDriver.findElement(By.xpath(normalizeHotline));
        String precedingSibHotline = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(precedingSibHotline));
        String descendantHotline = "//div[@test-id='about-me-grid-item']/descendant::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(descendantHotline));
        String followingSibHotline = "//h4[@id='db-discord']/following-sibling::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(followingSibHotline));
        String precedingHotline = "//ul[@test-id='db-systems-list']/preceding::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(precedingHotline));
        String followingHotline = "//h4[@test-id='db-website']/following::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(followingHotline));
        String childHotline = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(childHotline));

        //TÌM KIẾM ĐOẠN TEXT: Các hệ thống Testek cung cấp
        String txtSystemTitle = "//h4[text()='Các hệ thống Testek cung cấp']";
        webDriver.findElement(By.xpath(txtSystemTitle));
        String containsSystemTitle = "//h4[contains(@test-id,'db-sys')]";
        webDriver.findElement(By.xpath(containsSystemTitle));
        String startsSystemTitle = "//h4[starts-with(@test-id,'db-s')]";
        webDriver.findElement(By.xpath(startsSystemTitle));
        String normalizeSystemTitle = "//h4[normalize-space()='Các hệ thống Testek cung cấp']";
        webDriver.findElement(By.xpath(normalizeSystemTitle));
        String precedingSibSystemTitle = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(precedingSibSystemTitle));

        //TÌM KIẾM LINK TEXT: API System
        String descendantApiSystem = "//div[@test-id='about-me-grid-item']/descendant::li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(descendantApiSystem));
        String followingSibApiSystem = "//h4[@id='db-title-id']/following-sibling::ul/li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(followingSibApiSystem));
        String precedingApiSystem = "//div[@test-id='about-me-grid-item-coffee']/preceding::li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(precedingApiSystem));
        String followingApiSystem = "//h2[@test-id='about-me-title']/following::li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(followingApiSystem));
        String childApiSystem = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(childApiSystem));

        //TÌM KIẾM LINK TEXT: Automation Web:
        String parentAutoWeb = "//a[contains(text(),'Management')]/parent::li";
        webDriver.findElement(By.xpath(parentAutoWeb));
        String txtAutoWeb = "//a[text()='Product Management']";
        webDriver.findElement(By.xpath(txtAutoWeb));

        //TÌM KIẾM LINK TEXT: Web Element
        String containsWebEle = "//li[contains(@test-id,'db-web')]";
        webDriver.findElement(By.xpath(containsWebEle));
        String startsWebEle = "//li[starts-with(@test-id,'db-web')]";
        webDriver.findElement(By.xpath(startsWebEle));

        //TÌM KIẾM ĐOẠN TEXT: ACCOUNT
        String normalizeAccount = "//b[normalize-space()='for API System & Automation Web']";
        webDriver.findElement(By.xpath(normalizeAccount));
        String precedingSibAccount = "//li[@test-id='db-database']/preceding-sibling::li[@test-id='db-account']";
        webDriver.findElement(By.xpath(precedingSibAccount));

        //TÌM KIẾM ĐOẠN TEXT Admin_com_role
        String descendantAdminComRole = "//li[@test-id='db-account']/descendant::li[@test-id='db-account-admin']";
        webDriver.findElement(By.xpath(descendantAdminComRole));
        String precedingAdminComRole = "//div[contains(@test-id,'item-coffee')]/preceding::li[@test-id='db-account-admin']";
        webDriver.findElement(By.xpath(precedingAdminComRole));

        //TÌM KIẾM ĐOẠN TEXT user_com_role
        String followingSibUserComRole = "//li[@test-id='db-account-admin']/following-sibling::li[@test-id='db-account-user']";
        webDriver.findElement(By.xpath(followingSibUserComRole));
        String normalizeUserComRole = "//li[normalize-space()='User: user_com_role']";
        webDriver.findElement(By.xpath(normalizeUserComRole));

        //TÌM KIẾM ĐOẠN TEXT guest_com_role
        String followingGuestComRole = "//li[@test-id='db-account-admin']/following::li[@test-id='db-account-guest']";
        webDriver.findElement(By.xpath(followingGuestComRole));
        String childGuestComRole = "//ul[@class='custom-resource']/child::li[@test-id='db-account-guest']";
        webDriver.findElement(By.xpath(childGuestComRole));

        //TÌM KIẾM ĐOẠN TEXT Password: aA12345678@
        String txtPassword = "//li[text()='Password: aA12345678@ ']";
        webDriver.findElement(By.xpath(txtPassword));
        String containsPassword = "//li[contains(text(),'aA12345678@')]";
        webDriver.findElement(By.xpath(containsPassword));

        //TÌM KIẾM ĐOẠN TEXT Database: Updating...
        String startsDb = "//li[starts-with(@test-id,'db-da')]";
        webDriver.findElement(By.xpath(startsDb));
        String normalizeDb = "//li[normalize-space()='Database: Updating...']";
        webDriver.findElement(By.xpath(normalizeDb));

        //TÌM KIẾM ĐOẠN TEXT HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN
        String ancestorAboutMeWebEle = "//b[contains(text(),'HỆ THỐNG')]/ancestor::h4";
        webDriver.findElement(By.xpath(ancestorAboutMeWebEle));
        String precedingSibAboutMeWebEle = "//h4[@test-id='about-me-separator']/preceding-sibling::h4";
        webDriver.findElement(By.xpath(precedingSibAboutMeWebEle));

        //TÌM KIẾM HÌNH QR CODE
        String descendantQr = "//div[@class='grid-item']/descendant::img";
        webDriver.findElement(By.xpath(descendantWebsite));
        String followingSibQr = "//div[@class='grid-item']/following-sibling::div/img";
        webDriver.findElement(By.xpath(followingSibQr));
    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}