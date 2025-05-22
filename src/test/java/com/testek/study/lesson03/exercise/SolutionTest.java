package com.testek.study.lesson03.exercise;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

@Getter
@Setter
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver webDriver;
    private WebElement webElement;

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

        //TÌM KIẾM ĐOẠN TEXT: “TESTEK - KIỂM THỬ THỰC CHIẾN”
        String containsTitleCSS = "[test-id*='me-title']";
        webElement = webDriver.findElement(By.cssSelector(containsTitleCSS));
        String startsTitleCSS = "[test-id^='about-me-t']";
        webElement = webDriver.findElement(By.cssSelector(startsTitleCSS));
        String lastTitle = "[test-id$='me-title']";
        webElement = webDriver.findElement(By.cssSelector(lastTitle));

        //TÌM KIẾM ĐOẠN TEXT: "Đào tạo API Testing, Performance Testing, Automation Testing"
        String containsDescriptionCSS = "[test-id*='db-t']";
        webElement = webDriver.findElement(By.cssSelector(containsDescriptionCSS));
        String startsDescriptionCSS = "[id^='db-t']";
        webElement = webDriver.findElement(By.cssSelector(startsDescriptionCSS));
        String lastDescription = "[id$='e-id']";
        webElement = webDriver.findElement(By.cssSelector(lastDescription));

        //TÌM KIẾM LINK Website
        String containsWebsiteCSS = "h4[test-id*='website']";
        webElement = webDriver.findElement(By.cssSelector(containsWebsiteCSS));
        String startsWebsiteCSS = "h4[test-id^='db-web']";
        webElement = webDriver.findElement(By.cssSelector(startsWebsiteCSS));
        String lastWebsite = "[test-id$='website-link']";
        webElement = webDriver.findElement(By.cssSelector(lastWebsite));

        //TÌM KIÊM LINK: Discord:
        String containsDiscordCSS = "[id*='db-dis']";
        webElement = webDriver.findElement(By.cssSelector(containsDiscordCSS));
        String startsDiscordCSS = "[id^='db-dis']";
        webElement = webDriver.findElement(By.cssSelector(startsDiscordCSS));
        String lastDiscord = "[id$='discord']";
        webElement = webDriver.findElement(By.cssSelector(lastDiscord));

        //TÌM KIẾM LINK: Facebook:
        String containsFbCSS = "[test-id*='facebook-link']";
        webElement = webDriver.findElement(By.cssSelector(containsFbCSS));
        String startsFbCSS = "h4[test-id^='db-fa']";
        webElement = webDriver.findElement(By.cssSelector(startsFbCSS));
        String lastFb = "[test-id$='facebook']";
        webElement = webDriver.findElement(By.cssSelector(lastFb));

        //TÌM KIẾM ĐOẠN TEXT: Hotline:
        String containsHotlineCSS = "h4[test-id*='contact']";
        webElement = webDriver.findElement(By.cssSelector(containsFbCSS));
        String startsHotlineCSS = "h4[test-id^='db-con']";
        webElement = webDriver.findElement(By.cssSelector(startsHotlineCSS));
        String lastHotline = "h4[test-id$='contact']";
        webElement = webDriver.findElement(By.cssSelector(lastHotline));

        //TÌM KIẾM ĐOẠN TEXT: Các hệ thống Testek cung cấp
        String containsSystemTitleCSS = "h4[test-id*='systems']";
        webElement = webDriver.findElement(By.cssSelector(containsSystemTitleCSS));
        String startsSystemTitleCSS = "h4[test-id^='db-sys']";
        webElement = webDriver.findElement(By.cssSelector(startsSystemTitleCSS));
        String lastSystemTitle = "h4[test-id$='systems']";
        webElement = webDriver.findElement(By.cssSelector(lastSystemTitle));

        //TÌM KIẾM LINK TEXT: API System
        String containsApiSystemCSS = "li[test-id*='db-api']";
        webElement = webDriver.findElement(By.cssSelector(containsApiSystemCSS));
        String startsApiSystemCSS = "a[test-id^='db-api']";
        webElement = webDriver.findElement(By.cssSelector(startsApiSystemCSS));
        String lastApiSystem = "[test-id$='api-system-link']";
        webElement = webDriver.findElement(By.cssSelector(lastApiSystem));

        //TÌM KIẾM LINK TEXT: Automation Web:
        String containsAutoWebCSS = "li[test-id*='automation']";
        webElement = webDriver.findElement(By.cssSelector(containsAutoWebCSS));
        String startsAutoWebCSS = "li[test-id^='db-auto']";
        webElement = webDriver.findElement(By.cssSelector(startsAutoWebCSS));
        String lastAutoWeb = "[test-id$='automation-web-link']";
        webElement = webDriver.findElement(By.cssSelector(lastAutoWeb));

        //TÌM KIẾM LINK TEXT: Web Element
        String containsWebEleCSS = "[test-id*='element-link']";
        webElement = webDriver.findElement(By.cssSelector(containsWebEleCSS));
        String startsWebEleCSS = "li[test-id^='db-web']";
        webElement = webDriver.findElement(By.cssSelector(startsWebEleCSS));
        String lastWebEle = "[test-id$='element-link']";
        webElement = webDriver.findElement(By.cssSelector(lastWebEle));

        //TÌM KIẾM ĐOẠN TEXT: ACCOUNT
        String containsAccountCSS = "[test-id*='systems-'] li[test-id*='db-'] b";
        webElement = webDriver.findElement(By.cssSelector(containsAccountCSS));
        String startsAccountCSS = "[test-id^='db-acc'] b";
        webElement = webDriver.findElement(By.cssSelector(startsAccountCSS));
        String lastAccount = "[test-id$='account'] b";
        webElement = webDriver.findElement(By.cssSelector(lastAccount));

        //TÌM KIẾM ĐOẠN TEXT Admin_com_role
        String containsAdminComRoleCSS = "li[test-id*='account-ad']";
        webElement = webDriver.findElement(By.cssSelector(containsAdminComRoleCSS));
        String startsAdminComRoleCSS = "li[test-id^='db-account-a']";
        webElement = webDriver.findElement(By.cssSelector(startsAdminComRoleCSS));
        String lastAdminComRole = "li[test-id$='admin']";
        webElement = webDriver.findElement(By.cssSelector(lastAdminComRole));

        //TÌM KIẾM ĐOẠN TEXT user_com_role
        String containsUserComRoleCSS = "li[test-id*='account-us']";
        webElement = webDriver.findElement(By.cssSelector(containsUserComRoleCSS));
        String startsUserComRoleCSS = "li[test-id^='db-account-u']";
        webElement = webDriver.findElement(By.cssSelector(startsUserComRoleCSS));
        String lastUserComRole = "li[test-id$='user']";
        webElement = webDriver.findElement(By.cssSelector(lastUserComRole));

        //TÌM KIẾM ĐOẠN TEXT guest_com_role
        String containsGuestComRoleCSS = "li[test-id*='account-gu']";
        webElement = webDriver.findElement(By.cssSelector(containsGuestComRoleCSS));
        String startsGuestComRoleCSS = "li[test-id^='db-account-g']";
        webElement = webDriver.findElement(By.cssSelector(startsGuestComRoleCSS));
        String lastGuestComRole = "li[test-id$='guest']";
        webElement = webDriver.findElement(By.cssSelector(lastGuestComRole));

        //TÌM KIẾM ĐOẠN TEXT Password: aA12345678@
        String containsPasswordCss = "li[test-id*='pass']";
        webElement = webDriver.findElement(By.cssSelector(containsPasswordCss));
        String startsPasswordCSS = "li[test-id^='db-account-p']";
        webElement = webDriver.findElement(By.cssSelector(startsPasswordCSS));
        String lastPassword = "li[test-id$='password']";
        webElement = webDriver.findElement(By.cssSelector(lastPassword));

        //TÌM KIẾM ĐOẠN TEXT Database: Updating...
        String containsDbCss = "li[test-id*='-data']";
        webElement = webDriver.findElement(By.cssSelector(containsDbCss));
        String startsDbCSS = "li[test-id^='db-da']";
        webElement = webDriver.findElement(By.cssSelector(startsDbCSS));
        String lastDb = "[test-id$='database']";
        webElement = webDriver.findElement(By.cssSelector(lastDb));

        //TÌM KIẾM ĐOẠN TEXT HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN
        String containsAboutMeWebEleCss = "h4[test-id*='web-ele']";
        webElement = webDriver.findElement(By.cssSelector(containsAboutMeWebEleCss));
        String startsAboutMeWebEleCSS = "[test-id^='about-me-web']";
        webElement = webDriver.findElement(By.cssSelector(startsAboutMeWebEleCSS));
        String lastAboutMeWebEle = "[test-id$='web-elements']";
        webElement = webDriver.findElement(By.cssSelector(lastAboutMeWebEle));

        //TÌM KIẾM HÌNH QR CODE
        String containsQrCss = "img[test-id*='coffee']";
        webElement = webDriver.findElement(By.cssSelector(containsQrCss));
        String startsQrCSS = "img[test-id^='about-me-co']";
        webElement = webDriver.findElement(By.cssSelector(startsQrCSS));
        String lastQr= "[test-id$='coffee-img']";
        webElement = webDriver.findElement(By.cssSelector(lastQr));

        webDriver.switchTo().frame(0); //2. Element nằm trong iframe: Phần TikTok được nhúng từ bên ngoài (ví dụ iframe),
        //cần chuyển vào iframe trước: Cách kiểm tra: mở DevTools → xem phần tử #embed-profile-container có nằm trong <iframe> không.
        //TÌM KIẾM HÌNH ẢNH TIKTOK
        String containsTiktokImgCss = "[id*='profile']";
        webElement = webDriver.findElement(By.cssSelector(containsTiktokImgCss));
        String startsTiktokImgCSS = "[id^='embed']";
        webElement = webDriver.findElement(By.cssSelector(startsTiktokImgCSS));
        String lastTiktokImg = "[class$='e1i34kcw1']";
        webElement = webDriver.findElement(By.cssSelector(lastTiktokImg));

        //TÌM KIẾM BUTTON OPEN TIK TOK
        String containsTiktokBtnCss = "[class*='1f603so']";
        webElement = webDriver.findElement(By.cssSelector(containsTiktokBtnCss));
        String startsTiktokBtnCSS = "[class^='css-1f603so']";
        webElement = webDriver.findElement(By.cssSelector(startsTiktokBtnCSS));
        String lastTiktokBtn = "[class$='e1v8cfre1']";
        webElement = webDriver.findElement(By.cssSelector(lastTiktokBtn));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findAdvanceLocatorWithXPath() {
        gotoTestWebsite();

        //TÌM KIẾM ĐOẠN TEXT: “TESTEK - KIỂM THỬ THỰC CHIẾN”
        String containsTitleXpath = "//h2[contains(@test-id,'about-me')]";
        webElement = webDriver.findElement(By.xpath(containsTitleXpath));
        String startsTitleXpath = "//h2[starts-with(@test-id,'about-')]";
        webElement = webDriver.findElement(By.xpath(startsTitleXpath));
        String normalizeTitle = "//b[normalize-space()='TESTEK - KIỂM THỬ THỰC CHIẾN']";
        webElement = webDriver.findElement(By.xpath(normalizeTitle));
        String ancestorTitle = "//b[normalize-space()='TESTEK - KIỂM THỬ THỰC CHIẾN']/ancestor::h2";
        webElement = webDriver.findElement(By.xpath(ancestorTitle));
        String precedingSibTitle = "//h4[starts-with(@test-id,'about-me-web')]/preceding-sibling::h2/b";
        webElement = webDriver.findElement(By.xpath(precedingSibTitle));
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

        //TÌM KIẾM ĐOẠN TEXT: "Đào tạo API Testing, Performance Testing, Automation Testing"
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
        String descendantDescription = "//body[@test-id='body-root']/descendant::h4[@id='db-title-id']";
        webElement = webDriver.findElement(By.xpath(descendantDescription));
        String followingSibDescription = "//h2[@test-id='about-me-title']/following-sibling::div/div/h4[@id='db-title-id']";
        webElement = webDriver.findElement(By.xpath(followingSibDescription));
        String precedingDescription = "//h4[@test-id='db-facebook']/preceding::h4[@id='db-title-id']";
        webElement = webDriver.findElement(By.xpath(precedingDescription));
        String followingDescription = "//h2[@test-id='about-me-title']/following::div[@test-id='about-me-grid']/div/h4[@id='db-title-id']";
        webElement = webDriver.findElement(By.xpath(followingDescription));
        String childDescription = "//div[@test-id='about-me-grid-item']/child::h4[@id='db-title-id']";
        webElement = webDriver.findElement(By.xpath(childDescription));

        //TÌM KIẾM LINK Website
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
        String precedingSibWebsite = "//h4[@test-id='db-contact']/preceding-sibling::h4[@test-id='db-website']";
        webElement = webDriver.findElement(By.xpath(precedingSibWebsite));
        String descendantWebsite = "//div[@test-id='about-me-grid']/descendant::h4[@test-id='db-website']";
        webElement = webDriver.findElement(By.xpath(descendantWebsite));
        String followingSibWebsite= "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-website']";
        webElement = webDriver.findElement(By.xpath(followingSibWebsite));
        String precedingWebsite = "//h4[@test-id='db-systems']/preceding::h4[@test-id='db-website']";
        webElement = webDriver.findElement(By.xpath(precedingWebsite));
        String followingWebsite = "//h4[@test-id='db-title']/following::h4[@test-id='db-website']";
        webElement = webDriver.findElement(By.xpath(followingWebsite));
        String parentWebsite = "//a[@test-id='db-website-link']/parent::h4";
        webElement = webDriver.findElement(By.xpath(parentWebsite));
        String childWebsite = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-website']";
        webElement = webDriver.findElement(By.xpath(childWebsite));

        //TÌM KIÊM LINK: Discord:
        String txtDiscord = "//h4[text()='Discord: ']";
        webElement = webDriver.findElement(By.xpath(txtDiscord));
        String containsDiscord = "//h4[contains(text(),'Dis')]";
        webElement = webDriver.findElement(By.xpath(containsDiscord));
        String startsDiscord = "//h4[starts-with(text(),'Dis')]";
        webElement = webDriver.findElement(By.xpath(startsDiscord));
        String normalizeDiscord = "//a[normalize-space()='Testek - Kiểm thử thực chiến']/ancestor::h4[@id='db-discord']";
        webElement = webDriver.findElement(By.xpath(normalizeDiscord));
        String ancestorDiscord = "//a[@test-id='db-discord-link']/ancestor::h4";
        webElement = webDriver.findElement(By.xpath(ancestorDiscord));
        String precedingSibDiscord = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-discord']";
        webElement = webDriver.findElement(By.xpath(precedingSibDiscord));
        String descendantDiscord = "//h4[@test-id='db-discord']/descendant::a";
        webElement = webDriver.findElement(By.xpath(descendantDiscord));
        String followingSibDiscord = "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-discord']";
        webElement = webDriver.findElement(By.xpath(followingSibDiscord));
        String precedingDiscord = "//h4[@test-id='db-systems']/preceding::h4[@test-id='db-discord']";
        webElement = webDriver.findElement(By.xpath(precedingDiscord));
        String followingDiscord = "//h4[@test-id='db-title']/following::h4[@test-id='db-discord']";
        webElement = webDriver.findElement(By.xpath(followingDiscord));
        String parentDiscord = "//a[@test-id='db-discord-link']/parent::h4";
        webElement = webDriver.findElement(By.xpath(parentDiscord));
        String childDiscord = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-discord']";
        webElement = webDriver.findElement(By.xpath(childDiscord));

        //TÌM KIẾM LINK: Facebook:
        String txtFb = "//h4[text()='Facebook: ']";
        webElement = webDriver.findElement(By.xpath(txtFb));
        String containsFb = "//h4[contains(text(),'Fa')]";
        webElement = webDriver.findElement(By.xpath(containsFb));
        String startsFb = "//h4[starts-with(text(),'Fa')]";
        webElement = webDriver.findElement(By.xpath(startsFb));
        String normalizeFb = "//a[normalize-space()='Testek - Kiểm thử thực chiến']/ancestor::h4[@test-id='db-facebook']";
        webElement = webDriver.findElement(By.xpath(normalizeFb));
        String ancestorFb = "//a[@test-id='db-facebook-link']/ancestor::h4";
        webElement = webDriver.findElement(By.xpath(ancestorFb));
        String precedingSibFb = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-facebook']";
        webElement = webDriver.findElement(By.xpath(precedingSibFb));
        String descendantFb = "//h4[@test-id='db-facebook']/descendant::a";
        webElement = webDriver.findElement(By.xpath(descendantFb));
        String followingSibFb = "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-facebook']";
        webElement = webDriver.findElement(By.xpath(followingSibFb));
        String precedingFb = "//h4[@test-id='db-systems']/preceding::h4[@test-id='db-facebook']";
        webElement = webDriver.findElement(By.xpath(precedingFb));
        String followingFb = "//h4[@test-id='db-title']/following::h4[@test-id='db-facebook']";
        webElement = webDriver.findElement(By.xpath(followingFb));
        String parentFb = "//a[@test-id='db-facebook-link']/parent::h4";
        webElement = webDriver.findElement(By.xpath(parentFb));
        String childFb = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-facebook']";
        webElement = webDriver.findElement(By.xpath(childFb));

        //TÌM KIẾM ĐOẠN TEXT: Hotline:
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
        String descendantHotline = "//div[@test-id='about-me-grid-item']/descendant::h4[@test-id='db-contact']";
        webElement = webDriver.findElement(By.xpath(descendantHotline));
        String followingSibHotline = "//h4[@id='db-discord']/following-sibling::h4[@test-id='db-contact']";
        webElement = webDriver.findElement(By.xpath(followingSibHotline));
        String precedingHotline = "//ul[@test-id='db-systems-list']/preceding::h4[@test-id='db-contact']";
        webElement = webDriver.findElement(By.xpath(precedingHotline));
        String followingHotline = "//h4[@test-id='db-website']/following::h4[@test-id='db-contact']";
        webElement = webDriver.findElement(By.xpath(followingHotline));
        String childHotline = "//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-contact']";
        webElement = webDriver.findElement(By.xpath(childHotline));

        //TÌM KIẾM ĐOẠN TEXT: Các hệ thống Testek cung cấp
        String txtSystemTitle = "//h4[text()='Các hệ thống Testek cung cấp']";
        webElement = webDriver.findElement(By.xpath(txtSystemTitle));
        String containsSystemTitle = "//h4[contains(@test-id,'db-sys')]";
        webElement = webDriver.findElement(By.xpath(containsSystemTitle));
        String startsSystemTitle = "//h4[starts-with(@test-id,'db-s')]";
        webElement = webDriver.findElement(By.xpath(startsSystemTitle));
        String normalizeSystemTitle = "//h4[normalize-space()='Các hệ thống Testek cung cấp']";
        webElement = webDriver.findElement(By.xpath(normalizeSystemTitle));
        String precedingSibSystemTitle = "//ul[@test-id='db-systems-list']/preceding-sibling::h4[@test-id='db-contact']";
        webElement = webDriver.findElement(By.xpath(precedingSibSystemTitle));

        //TÌM KIẾM LINK TEXT: API System
        String descendantApiSystem = "//div[@test-id='about-me-grid-item']/descendant::li[@test-id='db-api-system']";
        webElement = webDriver.findElement(By.xpath(descendantApiSystem));
        String followingSibApiSystem = "//h4[@id='db-title-id']/following-sibling::ul/li[@test-id='db-api-system']";
        webElement = webDriver.findElement(By.xpath(followingSibApiSystem));
        String precedingApiSystem = "//div[@test-id='about-me-grid-item-coffee']/preceding::li[@test-id='db-api-system']";
        webElement = webDriver.findElement(By.xpath(precedingApiSystem));
        String followingApiSystem = "//h2[@test-id='about-me-title']/following::li[@test-id='db-api-system']";
        webElement = webDriver.findElement(By.xpath(followingApiSystem));
        String childApiSystem = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-api-system']";
        webElement = webDriver.findElement(By.xpath(childApiSystem));

        //TÌM KIẾM LINK TEXT: Automation Web:
        String parentAutoWeb = "//a[contains(text(),'Management')]/parent::li";
        webElement = webDriver.findElement(By.xpath(parentAutoWeb));
        String txtAutoWeb = "//a[text()='Product Management']";
        webElement = webDriver.findElement(By.xpath(txtAutoWeb));

        //TÌM KIẾM LINK TEXT: Web Element
        String containsWebEle = "//li[contains(@test-id,'db-web')]";
        webElement = webDriver.findElement(By.xpath(containsWebEle));
        String startsWebEle = "//li[starts-with(@test-id,'db-web')]";
        webElement = webDriver.findElement(By.xpath(startsWebEle));

        //TÌM KIẾM ĐOẠN TEXT: ACCOUNT
        String normalizeAccount = "//b[normalize-space()='for API System & Automation Web']";
        webElement = webDriver.findElement(By.xpath(normalizeAccount));
        String precedingSibAccount = "//li[@test-id='db-database']/preceding-sibling::li[@test-id='db-account']";
        webElement = webDriver.findElement(By.xpath(precedingSibAccount));

        //TÌM KIẾM ĐOẠN TEXT Admin_com_role
        String descendantAdminComRole = "//li[@test-id='db-account']/descendant::li[@test-id='db-account-admin']";
        webElement = webDriver.findElement(By.xpath(descendantAdminComRole));
        String precedingAdminComRole = "//div[contains(@test-id,'item-coffee')]/preceding::li[@test-id='db-account-admin']";
        webElement = webDriver.findElement(By.xpath(precedingAdminComRole));

        //TÌM KIẾM ĐOẠN TEXT user_com_role
        String followingSibUserComRole = "//li[@test-id='db-account-admin']/following-sibling::li[@test-id='db-account-user']";
        webElement = webDriver.findElement(By.xpath(followingSibUserComRole));
        String normalizeUserComRole = "//li[normalize-space()='User: user_com_role']";
        webElement = webDriver.findElement(By.xpath(normalizeUserComRole));

        //TÌM KIẾM ĐOẠN TEXT guest_com_role
        String followingGuestComRole = "//li[@test-id='db-account-admin']/following::li[@test-id='db-account-guest']";
        webElement = webDriver.findElement(By.xpath(followingGuestComRole));
        String childGuestComRole = "//ul[@class='custom-resource']/child::li[@test-id='db-account-guest']";
        webElement = webDriver.findElement(By.xpath(childGuestComRole));

        //TÌM KIẾM ĐOẠN TEXT Password: aA12345678@
        String txtPassword = "//li[text()='Password: aA12345678@ ']";
        webElement = webDriver.findElement(By.xpath(txtPassword));
        String containsPassword = "//li[contains(text(),'aA12345678@')]";
        webElement = webDriver.findElement(By.xpath(containsPassword));

        //TÌM KIẾM ĐOẠN TEXT Database: Updating...
        String startsDb = "//li[starts-with(@test-id,'db-da')]";
        webElement = webDriver.findElement(By.xpath(startsDb));
        String normalizeDb = "//li[normalize-space()='Database: Updating...']";
        webElement = webDriver.findElement(By.xpath(normalizeDb));

        //TÌM KIẾM ĐOẠN TEXT HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN
        String ancestorAboutMeWebEle = "//b[contains(text(),'HỆ THỐNG')]/ancestor::h4";
        webElement = webDriver.findElement(By.xpath(ancestorAboutMeWebEle));
        String precedingSibAboutMeWebEle = "//h4[@test-id='about-me-separator']/preceding-sibling::h4";
        webElement = webDriver.findElement(By.xpath(precedingSibAboutMeWebEle));

        //TÌM KIẾM HÌNH QR CODE
        String descendantQr = "//div[@class='grid-item']/descendant::img";
        webElement = webDriver.findElement(By.xpath(descendantWebsite));
        String followingSibQr = "//div[@class='grid-item']/following-sibling::div/img";
        webElement = webDriver.findElement(By.xpath(followingSibQr));

        webDriver.switchTo().frame(0); //2. Element nằm trong iframe: Phần TikTok được nhúng từ bên ngoài (ví dụ iframe),
        //cần chuyển vào iframe trước: Cách kiểm tra: mở DevTools → xem phần tử #embed-profile-container có nằm trong <iframe> không.

        //TÌM KIẾM HÌNH ẢNH TIKTOK
        String containsTiktokImg = "//div[contains(@id,'profile-container')]";
        webElement = webDriver.findElement(By.xpath(containsTiktokImg));
        String startsTiktokImg = "//div[starts-with(@id,'embed-profile')]";
        webElement = webDriver.findElement(By.xpath(startsTiktokImg));
//        String precedingTiktokImg = "//h4[@test-id='about-me-separator']/preceding::div[@class='grid-container']/div[@test-id='about-me-grid-item-coffee']/img";
//        webElement = webDriver.findElement(By.xpath(precedingTiktokImg));
//        String followingTiktokImg = "//h2[@test-id='about-me-title']/following::img[@test-id='about-me-coffee-img']";
//        webElement = webDriver.findElement(By.xpath(followingTiktokImg));

        //TÌM KIẾM BUTTON OPEN TIK TOK
        String parentTiktokBtn = "//div[contains(@class,'1db5cpb')]/parent::button";
        webElement = webDriver.findElement(By.xpath(parentTiktokBtn));
        String childTiktokBtn = "//a[@target='_blank']/child::button";
        webElement = webDriver.findElement(By.xpath(childTiktokBtn));
    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
