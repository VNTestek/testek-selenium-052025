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

        // admin_com_role
        String lblAdminContainsCSS = "li[test-id*= 'admin']";
        webDriver.findElement(By.cssSelector(lblAdminContainsCSS));
        String lblAdminStartWithCSS = "li[test-id^= 'db-account-ad']";
        webDriver.findElement(By.cssSelector(lblAdminStartWithCSS));

        // user_com_role
        String lblUserContainsCSS = "li[test-id*= 'user']";
        webDriver.findElement(By.cssSelector(lblUserContainsCSS));
        String lblUserStartWithCSS = "li[test-id^= 'db-account-u']";
        webDriver.findElement(By.cssSelector(lblUserStartWithCSS));

        // guest_com_role
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

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

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
        String followingSibWebsite= "//h4[@id='db-title-id']/following-sibling::h4[@test-id='db-website']";
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

        //Hotline:
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
        String txtHotline = "//h4[text()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        webDriver.findElement(By.xpath(txtHotline));
        String containsHotline = "//h4[contains(text(),'Email')]";
        webDriver.findElement(By.xpath(containsHotline));
        String startsHotline = "//h4[starts-with(text(),'Hotline')]";
        webDriver.findElement(By.xpath(startsHotline));
        String normalizeHotline = "//h4[normalize-space()='Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        webDriver.findElement(By.xpath(normalizeHotline));


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
        webDriver.findElement(By.xpath(descendantQr));
        String followingSibQr = "//div[@class='grid-item']/following-sibling::div/img";
        webDriver.findElement(By.xpath(followingSibQr));

        //TÌM KIẾM HÌNH ẢNH TIKTOK
        String containsTiktokImg = "//div[contains(@id,'embed-profile-container')]";
        webDriver.findElement(By.xpath(containsTiktokImg));


        //TÌM KIẾM BUTTON OPEN TIK TOK
        String parentTiktokBtn = "//div[contains(@class,'1db5cpb')]/parent::button";
        webDriver.findElement(By.xpath(parentTiktokBtn));
        String childTiktokBtn = "//a[@target='_blank']/child::button";
        webDriver.findElement(By.xpath(childTiktokBtn));
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();
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
