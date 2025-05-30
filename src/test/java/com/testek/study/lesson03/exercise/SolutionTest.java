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

        // Locate the link: Website
        String lblWebsiteXPathWithExactText = "//h4[text()='Website: ']";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithExactText));
        String lblWebsiteXPathWithContains = "//h4[contains(text(),'Web')]";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithContains));
        String lblWebsiteXPathWithStarts = "//h4[starts-with(text(),'Web')]";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithStarts));
        String lblWebsiteXPathWithNormalize = "//a[normalize-space()='https://testek.vn']";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithNormalize));
        String lblWebsiteXPathWithAncestor = "//a[@test-id='db-website-link']/ancestor::h4";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithAncestor));
        String lblWebsiteXPathWithPrecedingSibling = "//h4[@test-id='db-contact']/preceding-sibling::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithPrecedingSibling));
        String lblWebsiteXPathWithDescendant = "//div[@test-id='about-me-grid']/descendant::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithDescendant));
        String lblWebsiteXPathWithFollowingSibling = "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithFollowingSibling));
        String lblWebsiteXPathWithPreceding = "//h4[@test-id='db-systems']/preceding::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithPreceding));
        String lblWebsiteXPathWithFollowing = "//h4[@test-id='db-title']/following::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithFollowing));
        String lblWebsiteXPathWithParent = "//a[@test-id='db-website-link']/parent::h4";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithParent));
        String lblWebsiteXPathWithChild = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(lblWebsiteXPathWithChild));

        // Locate the link: Discord
        String lblDiscordXPathWithExactText = "//h4[text()='Discord: ']";
        webDriver.findElement(By.xpath(lblDiscordXPathWithExactText));
        String lblDiscordXPathWithContains = "//h4[contains(text(),'Dis')]";
        webDriver.findElement(By.xpath(lblDiscordXPathWithContains));
        String lblDiscordXPathWithStarts = "//h4[starts-with(text(),'Dis')]";
        webDriver.findElement(By.xpath(lblDiscordXPathWithStarts));
        String lblDiscordXPathWithNormalize = "//a[normalize-space()='Testek - Kiểm thử thực chiến']/ancestor::h4[@id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordXPathWithNormalize));
        String lblDiscordXPathWithAncestor = "//a[@test-id='db-discord-link']/ancestor::h4";
        webDriver.findElement(By.xpath(lblDiscordXPathWithAncestor));
        String lblDiscordXPathWithPrecedingSibling = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordXPathWithPrecedingSibling));
        String lblDiscordXPathWithDescendant = "//h4[@test-id='db-discord']/descendant::a";
        webDriver.findElement(By.xpath(lblDiscordXPathWithDescendant));
        String lblDiscordXPathWithFollowingSibling = "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordXPathWithFollowingSibling));
        String lblDiscordXPathWithPreceding = "//h4[@test-id='db-systems']/preceding::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordXPathWithPreceding));
        String lblDiscordXPathWithFollowing = "//h4[@test-id='db-title']/following::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordXPathWithFollowing));
        String lblDiscordXPathWithParent = "//a[@test-id='db-discord-link']/parent::h4";
        webDriver.findElement(By.xpath(lblDiscordXPathWithParent));
        String lblDiscordXPathWithChild = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(lblDiscordXPathWithChild));

        // Locate the Facebook section
        String lblFbXPathWithExactText = "//h4[text()='Facebook: ']";
        webDriver.findElement(By.xpath(lblFbXPathWithExactText));
        String lblFbXPathWithContains = "//h4[contains(text(),'Fa')]";
        webDriver.findElement(By.xpath(lblFbXPathWithContains));
        String lblFbXPathWithStarts = "//h4[starts-with(text(),'Fa')]";
        webDriver.findElement(By.xpath(lblFbXPathWithStarts));
        String lblFbXPathWithNormalize = "//a[normalize-space()='Testek - Kiểm thử thực chiến']/ancestor::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(lblFbXPathWithNormalize));
        String lblFbXPathWithAncestor = "//a[@test-id='db-facebook-link']/ancestor::h4";
        webDriver.findElement(By.xpath(lblFbXPathWithAncestor));
        String lblFbXPathWithPrecedingSibling = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(lblFbXPathWithPrecedingSibling));
        String lblFbXPathWithDescendant = "//h4[@test-id='db-facebook']/descendant::a";
        webDriver.findElement(By.xpath(lblFbXPathWithDescendant));
        String lblFbXPathWithFollowingSibling = "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(lblFbXPathWithFollowingSibling));
        String lblFbXPathWithPreceding = "//h4[@test-id='db-systems']/preceding::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(lblFbXPathWithPreceding));
        String lblFbXPathWithFollowing = "//h4[@test-id='db-title']/following::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(lblFbXPathWithFollowing));
        String lblFbXPathWithParent = "//a[@test-id='db-facebook-link']/parent::h4";
        webDriver.findElement(By.xpath(lblFbXPathWithParent));
        String lblFbXPathWithChild = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(lblFbXPathWithChild));

        // Locate the text: Hotline
        String lblHotlineXPathWithExactText = "//h4[text()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        webDriver.findElement(By.xpath(lblHotlineXPathWithExactText));
        String lblHotlineXPathWithContains = "//h4[contains(text(),'Email')]";
        webDriver.findElement(By.xpath(lblHotlineXPathWithContains));
        String lblHotlineXPathWithStarts = "//h4[starts-with(text(),'Hotline')]";
        webDriver.findElement(By.xpath(lblHotlineXPathWithStarts));
        String lblHotlineXPathWithNormalize = "//h4[normalize-space()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        webDriver.findElement(By.xpath(lblHotlineXPathWithNormalize));
        String lblHotlineXPathWithPrecedingSibling = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(lblHotlineXPathWithPrecedingSibling));
        String lblHotlineXPathWithDescendant = "//div[@test-id='about-me-grid-item']/descendant::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(lblHotlineXPathWithDescendant));
        String lblHotlineXPathWithFollowingSibling = "//h4[@id='db-discord']/following-sibling::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(lblHotlineXPathWithFollowingSibling));
        String lblHotlineXPathWithPreceding = "//ul[@test-id='db-systems-list']/preceding::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(lblHotlineXPathWithPreceding));
        String lblHotlineXPathWithFollowing = "//h4[@test-id='db-website']/following::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(lblHotlineXPathWithFollowing));
        String lblHotlineXPathWithChild = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(lblHotlineXPathWithChild));

        // Locate the text: Các hệ thống Testek cung cấp
        String lblSystemTitleXPathWithExactText = "//h4[text()='Các hệ thống Testek cung cấp']";
        webDriver.findElement(By.xpath(lblSystemTitleXPathWithExactText));
        String lblSystemTitleXPathWithContains = "//h4[contains(@test-id,'db-sys')]";
        webDriver.findElement(By.xpath(lblSystemTitleXPathWithContains));
        String lblSystemTitleXPathWithStarts = "//h4[starts-with(@test-id,'db-s')]";
        webDriver.findElement(By.xpath(lblSystemTitleXPathWithStarts));
        String lblSystemTitleXPathWithNormalize = "//h4[normalize-space()='Các hệ thống Testek cung cấp']";
        webDriver.findElement(By.xpath(lblSystemTitleXPathWithNormalize));
        String lblSystemTitleXPathWithPrecedingSibling = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(lblSystemTitleXPathWithPrecedingSibling));


        // Locate the link text: API System
        String lblApiSystemXPathWithDescendant = "//div[@test-id='about-me-grid-item']/descendant::li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(lblApiSystemXPathWithDescendant));
        String lblApiSystemXPathWithFollowingSibling = "//h4[@id='db-title-id']/following-sibling::ul/li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(lblApiSystemXPathWithFollowingSibling));
        String lblApiSystemXPathWithPreceding = "//div[@test-id='about-me-grid-item-coffee']/preceding::li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(lblApiSystemXPathWithPreceding));
        String lblApiSystemXPathWithFollowing = "//h2[@test-id='about-me-title']/following::li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(lblApiSystemXPathWithFollowing));
        String lblApiSystemXPathWithChild = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(lblApiSystemXPathWithChild));

        // Locate the link text: Automation Web:
        String lblAutoWebXPathWithParent = "//a[contains(text(),'Management')]/parent::li";
        webDriver.findElement(By.xpath(lblAutoWebXPathWithParent));
        String lblAutoWebXPathWithText = "//a[text()='Product Management']";
        webDriver.findElement(By.xpath(lblAutoWebXPathWithText));

        // Locate the link text: Web Element
        String lblWebElementXPathWithContains = "//li[contains(@test-id,'db-web')]";
        webDriver.findElement(By.xpath(lblWebElementXPathWithContains));
        String lblWebElementXPathWithStartsWith = "//li[starts-with(@test-id,'db-web')]";
        webDriver.findElement(By.xpath(lblWebElementXPathWithStartsWith));

        // Locate the text: ACCOUNT
        String lblAccountXPathWithNormalize = "//b[normalize-space()='for API System & Automation Web']";
        webDriver.findElement(By.xpath(lblAccountXPathWithNormalize));
        String lblAccountXPathWithPrecedingSibling = "//li[@test-id='db-database']/preceding-sibling::li[@test-id='db-account']";
        webDriver.findElement(By.xpath(lblAccountXPathWithPrecedingSibling));

        // Locate the text: Admin_com_role
        String lblAdminComRoleXPathWithDescendant = "//li[@test-id='db-account']/descendant::li[@test-id='db-account-admin']";
        webDriver.findElement(By.xpath(lblAdminComRoleXPathWithDescendant));
        String lblAdminComRoleXPathWithPreceding = "//div[contains(@test-id,'item-coffee')]/preceding::li[@test-id='db-account-admin']";
        webDriver.findElement(By.xpath(lblAdminComRoleXPathWithPreceding));

        // Locate the text: user_com_role
        String lblUserComRoleXPathWithFollowingSibling = "//li[@test-id='db-account-admin']/following-sibling::li[@test-id='db-account-user']";
        webDriver.findElement(By.xpath(lblUserComRoleXPathWithFollowingSibling));
        String lblUserComRoleXPathWithNormalize = "//li[normalize-space()='User: user_com_role']";
        webDriver.findElement(By.xpath(lblUserComRoleXPathWithNormalize));

        // Locate the text: guest_com_role
        String lblGuestComRoleXPathWithFollowing = "//li[@test-id='db-account-admin']/following::li[@test-id='db-account-guest']";
        webDriver.findElement(By.xpath(lblGuestComRoleXPathWithFollowing));
        String lblGuestComRoleXPathWithChild = "//ul[@class='custom-resource']/child::li[@test-id='db-account-guest']";
        webDriver.findElement(By.xpath(lblGuestComRoleXPathWithChild));

        // Locate the text: Password: aA12345678@
        String lblPasswordXPathWithText = "//li[text()='Password: aA12345678@ ']";
        webDriver.findElement(By.xpath(lblPasswordXPathWithText));
        String lblPasswordXPathWithContains = "//li[contains(text(),'aA12345678@')]";
        webDriver.findElement(By.xpath(lblPasswordXPathWithContains));
        String lblPasswordXPathWithContainsTestId = "//li[contains(@test-id ,'db-account-password')]";
        webDriver.findElement(By.xpath(lblPasswordXPathWithContainsTestId));
        String lblPasswordXPathWithStartWith = "//li[starts-with(@test-id ,'db-account-password')]";
        webDriver.findElement(By.xpath(lblPasswordXPathWithStartWith));

        // Locate the text: Database: Updating...
        String lblDbXPathWithStartsWith = "//li[starts-with(@test-id,'db-da')]";
        webDriver.findElement(By.xpath(lblDbXPathWithStartsWith));
        String lblDbXPathWithNormalize = "//li[normalize-space()='Database: Updating...']";
        webDriver.findElement(By.xpath(lblDbXPathWithNormalize));
        String lblDbXPathWithContains = "//li[contains(@test-id ,'db-database')]";
        webDriver.findElement(By.xpath(lblDbXPathWithContains));
        String lblDbXPathWithStartWith = "//li[starts-with(@test-id ,'db-database')]";
        webDriver.findElement(By.xpath(lblDbXPathWithStartWith));

        // Locate the text: HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN
        String lblAboutMeWebEleXPathWithAncestor = "//b[contains(text(),'HỆ THỐNG')]/ancestor::h4";
        webDriver.findElement(By.xpath(lblAboutMeWebEleXPathWithAncestor));
        String lblAboutMeWebEleXPathWithPrecedingSibling = "//h4[@test-id='about-me-separator']/preceding-sibling::h4";
        webDriver.findElement(By.xpath(lblAboutMeWebEleXPathWithPrecedingSibling));
        String lblAboutMeWebEleXPathWithContains = "//h4[contains(@test-id ,'about-me-web-elements')]";
        webDriver.findElement(By.xpath(lblAboutMeWebEleXPathWithContains));
        String lblAboutMeWebEleXPathWithStartWith = "//h4[starts-with(@test-id ,'about-me-web-elements')]";
        webDriver.findElement(By.xpath(lblAboutMeWebEleXPathWithStartWith));

        // Locate the QR code image
        String lblQrXPathWithDescendant = "//div[@class='grid-item']/descendant::img";
        webDriver.findElement(By.xpath(lblQrXPathWithDescendant));
        String lblQrXPathWithFollowingSibling = "//div[@class='grid-item']/following-sibling::div/img";
        webDriver.findElement(By.xpath(lblQrXPathWithFollowingSibling));
        String lblQrXPathWithContains = "//img[contains(@test-id ,'about-me-coffee-img')]";
        webDriver.findElement(By.xpath(lblQrXPathWithContains));
        String lblQrXPathWithStartWith = "//img[starts-with(@test-id ,'about-me-coffee-img')]";
        webDriver.findElement(By.xpath(lblQrXPathWithStartWith));
    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}