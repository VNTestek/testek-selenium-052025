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
    private WebElement webElement;
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

        String containsTitleCSS = "[test-id*='me-title']";
        webElement = webDriver.findElement(By.cssSelector(containsTitleCSS));
        String startsTitleCSS = "[test-id^='about-me-t']";
        webElement = webDriver.findElement(By.cssSelector(startsTitleCSS));
        String lastTitle = "[test-id$='me-title']";
        webElement = webDriver.findElement(By.cssSelector(lastTitle));

        String containsDescriptionCSS = "[test-id*='db-t']";
        webElement = webDriver.findElement(By.cssSelector(containsDescriptionCSS));
        String startsDescriptionCSS = "[id^='db-t']";
        webElement = webDriver.findElement(By.cssSelector(startsDescriptionCSS));
        String lastDescription = "[id$='e-id']";
        webElement = webDriver.findElement(By.cssSelector(lastDescription));

        String containsDiscordCSS = "[id*='db-dis']";
        webElement = webDriver.findElement(By.cssSelector(containsDiscordCSS));
        String startsDiscordCSS = "[id^='db-dis']";
        webElement = webDriver.findElement(By.cssSelector(startsDiscordCSS));
        String lastDiscord = "[id$='discord']";
        webElement = webDriver.findElement(By.cssSelector(lastDiscord));

        String containsWebsiteCSS = "h4[test-id*='website']";
        webElement = webDriver.findElement(By.cssSelector(containsWebsiteCSS));
        String startsWebsiteCSS = "h4[test-id^='db-web']";
        webElement = webDriver.findElement(By.cssSelector(startsWebsiteCSS));
        String lastWebsite = "[test-id$='website-link']";
        webElement = webDriver.findElement(By.cssSelector(lastWebsite));

        String containsFbCSS = "[test-id*='facebook-link']";
        webElement = webDriver.findElement(By.cssSelector(containsFbCSS));
        String startsFbCSS = "h4[test-id^='db-fa']";
        webElement = webDriver.findElement(By.cssSelector(startsFbCSS));
        String lastFb = "[test-id$='facebook']";
        webElement = webDriver.findElement(By.cssSelector(lastFb));

        String containsSystemTitleCSS = "h4[test-id*='systems']";
        webElement = webDriver.findElement(By.cssSelector(containsSystemTitleCSS));
        String startsSystemTitleCSS = "h4[test-id^='db-sys']";
        webElement = webDriver.findElement(By.cssSelector(startsSystemTitleCSS));
        String lastSystemTitle = "h4[test-id$='systems']";
        webElement = webDriver.findElement(By.cssSelector(lastSystemTitle));

        String containsHotlineCSS = "h4[test-id*='contact']";
        webElement = webDriver.findElement(By.cssSelector(containsFbCSS));
        String startsHotlineCSS = "h4[test-id^='db-con']";
        webElement = webDriver.findElement(By.cssSelector(startsHotlineCSS));
        String lastHotline = "h4[test-id$='contact']";
        webElement = webDriver.findElement(By.cssSelector(lastHotline));

        String containsApiSystemCSS = "li[test-id*='db-api']";
        webElement = webDriver.findElement(By.cssSelector(containsApiSystemCSS));
        String startsApiSystemCSS = "a[test-id^='db-api']";
        webElement = webDriver.findElement(By.cssSelector(startsApiSystemCSS));
        String lastApiSystem = "[test-id$='api-system-link']";
        webElement = webDriver.findElement(By.cssSelector(lastApiSystem));

        String containsWebEleCSS = "[test-id*='element-link']";
        webElement = webDriver.findElement(By.cssSelector(containsWebEleCSS));
        String startsWebEleCSS = "li[test-id^='db-web']";
        webElement = webDriver.findElement(By.cssSelector(startsWebEleCSS));
        String lastWebEle = "[test-id$='element-link']";
        webElement = webDriver.findElement(By.cssSelector(lastWebEle));


        String containsAutoWebCSS = "li[test-id*='automation']";
        webElement = webDriver.findElement(By.cssSelector(containsAutoWebCSS));
        String startsAutoWebCSS = "li[test-id^='db-auto']";
        webElement = webDriver.findElement(By.cssSelector(startsAutoWebCSS));
        String lastAutoWeb = "[test-id$='automation-web-link']";
        webElement = webDriver.findElement(By.cssSelector(lastAutoWeb));


        String containsAccountCSS = "[test-id*='systems-'] li[test-id*='db-'] b";
        webElement = webDriver.findElement(By.cssSelector(containsAccountCSS));
        String startsAccountCSS = "[test-id^='db-acc'] b";
        webElement = webDriver.findElement(By.cssSelector(startsAccountCSS));
        String lastAccount = "[test-id$='account'] b";
        webElement = webDriver.findElement(By.cssSelector(lastAccount));

        String containsAdminComRoleCSS = "li[test-id*='account-ad']";
        webElement = webDriver.findElement(By.cssSelector(containsAdminComRoleCSS));
        String startsAdminComRoleCSS = "li[test-id^='db-account-a']";
        webElement = webDriver.findElement(By.cssSelector(startsAdminComRoleCSS));
        String lastAdminComRole = "li[test-id$='admin']";
        webElement = webDriver.findElement(By.cssSelector(lastAdminComRole));

        String containsUserComRoleCSS = "li[test-id*='account-us']";
        webElement = webDriver.findElement(By.cssSelector(containsUserComRoleCSS));
        String startsUserComRoleCSS = "li[test-id^='db-account-u']";
        webElement = webDriver.findElement(By.cssSelector(startsUserComRoleCSS));
        String lastUserComRole = "li[test-id$='user']";
        webElement = webDriver.findElement(By.cssSelector(lastUserComRole));

        String containsGuestComRoleCSS = "li[test-id*='account-gu']";
        webElement = webDriver.findElement(By.cssSelector(containsGuestComRoleCSS));
        String startsGuestComRoleCSS = "li[test-id^='db-account-g']";
        webElement = webDriver.findElement(By.cssSelector(startsGuestComRoleCSS));
        String lastGuestComRole = "li[test-id$='guest']";
        webElement = webDriver.findElement(By.cssSelector(lastGuestComRole));

        String containsPasswordCss = "li[test-id*='pass']";
        webElement = webDriver.findElement(By.cssSelector(containsPasswordCss));
        String startsPasswordCSS = "li[test-id^='db-account-p']";
        webElement = webDriver.findElement(By.cssSelector(startsPasswordCSS));
        String lastPassword = "li[test-id$='password']";
        webElement = webDriver.findElement(By.cssSelector(lastPassword));

        String containsDbCss = "li[test-id*='-data']";
        webElement = webDriver.findElement(By.cssSelector(containsDbCss));
        String startsDbCSS = "li[test-id^='db-da']";
        webElement = webDriver.findElement(By.cssSelector(startsDbCSS));
        String lastDb = "[test-id$='database']";
        webElement = webDriver.findElement(By.cssSelector(lastDb));

        String containsQrCss = "img[test-id*='coffee']";
        webElement = webDriver.findElement(By.cssSelector(containsQrCss));
        String startsQrCSS = "img[test-id^='about-me-co']";
        webElement = webDriver.findElement(By.cssSelector(startsQrCSS));
        String lastQr = "[test-id$='coffee-img']";
        webElement = webDriver.findElement(By.cssSelector(lastQr));

        String containsAboutMeWebEleCss = "h4[test-id*='web-ele']";
        webElement = webDriver.findElement(By.cssSelector(containsAboutMeWebEleCss));
        String startsAboutMeWebEleCSS = "[test-id^='about-me-web']";
        webElement = webDriver.findElement(By.cssSelector(startsAboutMeWebEleCSS));
        String lastAboutMeWebEle = "[test-id$='web-elements']";
        webElement = webDriver.findElement(By.cssSelector(lastAboutMeWebEle));

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
        String containsTitleXpath = "//h2[contains(@test-id,'about-me')]";
        webElement = webDriver.findElement(By.xpath(containsTitleXpath));
        String descendantTitle = "//div[@test-id='content-root']/descendant::h2";
        webElement = webDriver.findElement(By.xpath(descendantTitle));
        String followingSibTitle = "//div[@test-id='sidebar-root']/following-sibling::div/descendant::h2";
        webElement = webDriver.findElement(By.xpath(followingSibTitle));
        String precedingTitle = "//h4[@test-id='about-me-web-elements']/preceding::h2";
        webElement = webDriver.findElement(By.xpath(precedingTitle));
        String followingTitle = "//div[@test-id='sidebar-root']/following::div[@test-id='content-root']";
        webElement = webDriver.findElement(By.xpath(followingTitle));
        String parentTitle = "//b/parent::h2[@test-id='about-me-title']";
        webElement = webDriver.findElement(By.xpath(parentTitle));
        String childTitle = "//div[@id='about-me']/child::h2";
        webElement = webDriver.findElement(By.xpath(childTitle));

        String txtDescription = "//h4[text()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        webElement = webDriver.findElement(By.xpath(txtDescription));
        String containsDescription = "//h4[contains(@id,'db-t')]";
        webElement = webDriver.findElement(By.xpath(containsDescription));
        String startsDescription = "//h4[starts-with(@id,'db-t')]";
        webElement = webDriver.findElement(By.xpath(startsDescription));
        String normalizeDescription = "//h4[normalize-space()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        webElement = webDriver.findElement(By.xpath(normalizeDescription));
        String ancestorDescription = "//a[@test-id='db-website-link']/ancestor::h4/preceding-sibling::h4";
        webElement = webDriver.findElement(By.xpath(ancestorDescription));
        String precedingSibDescription = "//h4[@test-id='db-website']/preceding-sibling::h4";
        webElement = webDriver.findElement(By.xpath(precedingSibDescription));

        String txtWebsite = "//h4[text()='Website: ']";
        webElement = webDriver.findElement(By.xpath(txtWebsite));
        String containsWebsite = "//h4[contains(text(),'Web')]";
        webElement = webDriver.findElement(By.xpath(containsWebsite));
        String startsWebsite = "//h4[starts-with(text(),'Web')]";
        webElement = webDriver.findElement(By.xpath(startsWebsite));
        String normalizeWebsite = "//a[normalize-space()='https://testek.vn']";
        webElement = webDriver.findElement(By.xpath(normalizeWebsite));
        String ancestorWebsite = "//a[@test-id='db-website-link']/ancestor::h4";
        webElement = webDriver.findElement(By.xpath(ancestorWebsite));
        String parentWebsite = "//a[@test-id='db-website-link']/parent::h4";
        webElement = webDriver.findElement(By.xpath(parentWebsite));

        String txtDiscord = "//h4[text()='Discord: ']";
        webElement = webDriver.findElement(By.xpath(txtDiscord));
        String containsDiscord = "//h4[contains(text(),'Dis')]";
        webElement = webDriver.findElement(By.xpath(containsDiscord));
        String startsDiscord = "//h4[starts-with(text(),'Dis')]";
        webElement = webDriver.findElement(By.xpath(startsDiscord));
        String ancestorDiscord = "//a[@test-id='db-discord-link']/ancestor::h4";
        webElement = webDriver.findElement(By.xpath(ancestorDiscord));
        String precedingSibDiscord = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-discord']";
        webElement = webDriver.findElement(By.xpath(precedingSibDiscord));
        String childDiscord = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-discord']";
        webElement = webDriver.findElement(By.xpath(childDiscord));

        String txtHotline = "//h4[text()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        webElement = webDriver.findElement(By.xpath(txtHotline));
        String containsHotline = "//h4[contains(text(),'Email')]";
        webElement = webDriver.findElement(By.xpath(containsHotline));
        String startsHotline = "//h4[starts-with(text(),'Hotline')]";
        webElement = webDriver.findElement(By.xpath(startsHotline));
        String normalizeHotline = "//h4[normalize-space()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        webElement = webDriver.findElement(By.xpath(normalizeHotline));
        String precedingSibHotline = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-contact']";
        webElement = webDriver.findElement(By.xpath(precedingSibHotline));

        String txtFb = "//h4[text()='Facebook: ']";
        webElement = webDriver.findElement(By.xpath(txtFb));
        String followingFb = "//h4[@test-id='db-title']/following::h4[@test-id='db-facebook']";
        webElement = webDriver.findElement(By.xpath(followingFb));
        String parentFb = "//a[@test-id='db-facebook-link']/parent::h4";
        webElement = webDriver.findElement(By.xpath(parentFb));
        String childFb = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-facebook']";
        webElement = webDriver.findElement(By.xpath(childFb));


        String txtSystemTitle = "//h4[text()='Các hệ thống Testek cung cấp']";
        webElement = webDriver.findElement(By.xpath(txtSystemTitle));
        String containsSystemTitle = "//h4[contains(@test-id,'db-sys')]";
        webElement = webDriver.findElement(By.xpath(containsSystemTitle));
        String precedingSibSystemTitle = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-contact']";
        webElement = webDriver.findElement(By.xpath(precedingSibSystemTitle));

        String descendantApiSystem = "//div[@test-id='about-me-grid-item']/descendant::li[@test-id='db-api-system']";
        webElement = webDriver.findElement(By.xpath(descendantApiSystem));
        String followingSibApiSystem = "//h4[@id='db-title-id']/following-sibling::ul/li[@test-id='db-api-system']";
        webElement = webDriver.findElement(By.xpath(followingSibApiSystem));
        String childApiSystem = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-api-system']";
        webElement = webDriver.findElement(By.xpath(childApiSystem));

        String parentAutoWeb = "//a[contains(text(),'Management')]/parent::li";
        webElement = webDriver.findElement(By.xpath(parentAutoWeb));
        String txtAutoWeb = "//a[text()='Product Management']";
        webElement = webDriver.findElement(By.xpath(txtAutoWeb));

        String containsWebEle = "//li[contains(@test-id,'db-web')]";
        webElement = webDriver.findElement(By.xpath(containsWebEle));
        String startsWebEle = "//li[starts-with(@test-id,'db-web')]";
        webElement = webDriver.findElement(By.xpath(startsWebEle));

        String normalizeAccount = "//b[normalize-space()='for API System & Automation Web']";
        webElement = webDriver.findElement(By.xpath(normalizeAccount));
        String precedingSibAccount = "//li[@test-id='db-database']/preceding-sibling::li[@test-id='db-account']";
        webElement = webDriver.findElement(By.xpath(precedingSibAccount));

        String descendantAdminComRole = "//li[@test-id='db-account']/descendant::li[@test-id='db-account-admin']";
        webElement = webDriver.findElement(By.xpath(descendantAdminComRole));
        String precedingAdminComRole = "//div[contains(@test-id,'item-coffee')]/preceding::li[@test-id='db-account-admin']";
        webElement = webDriver.findElement(By.xpath(precedingAdminComRole));

        String followingSibUserComRole = "//li[@test-id='db-account-admin']/following-sibling::li[@test-id='db-account-user']";
        webElement = webDriver.findElement(By.xpath(followingSibUserComRole));
        String normalizeUserComRole = "//li[normalize-space()='User: user_com_role']";
        webElement = webDriver.findElement(By.xpath(normalizeUserComRole));

        String startsDb = "//li[starts-with(@test-id,'db-da')]";
        webElement = webDriver.findElement(By.xpath(startsDb));
        String normalizeDb = "//li[normalize-space()='Database: Updating...']";
        webElement = webDriver.findElement(By.xpath(normalizeDb));

        String followingGuestComRole = "//li[@test-id='db-account-admin']/following::li[@test-id='db-account-guest']";
        webElement = webDriver.findElement(By.xpath(followingGuestComRole));
        String childGuestComRole = "//ul[@class='custom-resource']/child::li[@test-id='db-account-guest']";
        webElement = webDriver.findElement(By.xpath(childGuestComRole));

        String followingSibQr = "//div[@class='grid-item']/following-sibling::div/img";
        webElement = webDriver.findElement(By.xpath(followingSibQr));

        String txtPassword = "//li[text()='Password: aA12345678@ ']";
        webElement = webDriver.findElement(By.xpath(txtPassword));
        String containsPassword = "//li[contains(text(),'12345678@')]";
        webElement = webDriver.findElement(By.xpath(containsPassword));


        String ancestorAboutMeWebEle = "//b[contains(text(),'VIỆT NAM LỚN MẠNH!!!')]/ancestor::h4";
        webElement = webDriver.findElement(By.xpath(ancestorAboutMeWebEle));
        String precedingSibAboutMeWebEle = "//h4[@test-id='about-me-separator']/preceding-sibling::h4";
        webElement = webDriver.findElement(By.xpath(precedingSibAboutMeWebEle));


    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
