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
        //Contains
        String lblTitleWebCss = "h2[test-id *='about-me-title']";
        WebElement lblTitleCssContainEle = webDriver.findElement(By.cssSelector(lblTitleWebCss));

        String txtTitleIntroduceCss = "h4[id *='db-title-id']";
        WebElement txtTitleIntroduceCssContainEle = webDriver.findElement((By.cssSelector(txtTitleIntroduceCss)));

        String linkWebsiteCss = "a[test-id *='db-website-link']";
        WebElement websiteCssContainEle = webDriver.findElement((By.cssSelector(linkWebsiteCss)));

        String linkDiscordCss = "a[test-id *='db-discord-link']";
        WebElement linkDiscordCssContainEle = webDriver.findElement((By.cssSelector(linkDiscordCss)));

        String linkFacebookCss = "a[test-id *='db-facebook-link']";
        WebElement linkFacebookCssContainEle = webDriver.findElement((By.cssSelector(linkFacebookCss)));

        String txtHotlineCss = "h4[test-id *='db-contact']";
        WebElement txtHotlineCssContainEle = webDriver.findElement((By.cssSelector(txtHotlineCss)));

        String txtSystemTextCss = "h4[test-id *='db-systems']";
        WebElement txtSystemTextCssContainEle = webDriver.findElement((By.cssSelector(txtSystemTextCss)));

        String linkApiSystemCss = "a[test-id *='db-api-system-link']";
        WebElement linkApiSystemCssContainEle = webDriver.findElement((By.cssSelector(linkApiSystemCss)));

        String linkAutomationWebCss = "a[test-id *='db-automation-web-link']";
        WebElement linkAutomationWebCssContainEle = webDriver.findElement((By.cssSelector(linkAutomationWebCss)));

        String linkWebElementCss = "a[test-id *='db-web-element-link']";
        WebElement linkWebElementCssContainEle = webDriver.findElement((By.cssSelector(linkWebElementCss)));

        String imgQrCodeCss = "img[test-id *='about-me-coffee-img']";
        WebElement imgQrCodeCssContainEle = webDriver.findElement((By.cssSelector(imgQrCodeCss)));

        // Starts-with
        String lblTitleWebCssSw = "h2[test-id ^='about-']";
        WebElement lblTitleWebCssSwEle = webDriver.findElement(By.cssSelector(lblTitleWebCssSw));

        String txtTitleIntroduceCssSw = "h4[name ^='db-']";
        WebElement txtTitleIntroduceCssSwEle = webDriver.findElement((By.cssSelector(txtTitleIntroduceCssSw)));

        String linkWebsiteCssSw = "a[test-id ^='db-website']";
        WebElement linkWebsiteCssSwEle = webDriver.findElement((By.cssSelector(linkWebsiteCssSw)));

        String linkDiscordCssSw = "a[test-id ^='db-discord']";
        WebElement linkDiscordCssSwEle = webDriver.findElement((By.cssSelector(linkDiscordCssSw)));

        String linkFacebookCssSw = "a[test-id ^='db-facebook']";
        WebElement linkFacebookCssSwEle = webDriver.findElement((By.cssSelector(linkFacebookCssSw)));

        String txtHotlineCssSw = "h4[test-id ^='db-c']";
        WebElement txtHotlineCssSwEle = webDriver.findElement((By.cssSelector(txtHotlineCssSw)));

        String txtSystemCssSw = "h4[test-id ^='db-s']";
        WebElement txtSystemCssSwEle = webDriver.findElement((By.cssSelector(txtSystemCssSw)));

        String linkApiSystemCssSw = "a[test-id ^='db-api']";
        WebElement linkApiCssSwEle = webDriver.findElement((By.cssSelector(linkApiSystemCssSw)));

        String linkAutomationWebCssSw = "a[test-id ^='db-au']";
        WebElement linkAutomationWebCssSwEle = webDriver.findElement((By.cssSelector(linkAutomationWebCssSw)));

        String linkWebElementCssSw = "a[test-id ^='db-web-e']";
        WebElement linkWebElementCssSwEle = webDriver.findElement((By.cssSelector(linkWebElementCssSw)));

        String imgQrCodeCssSw = "img[test-id ^='about']";
        WebElement imgQrCodeCssSh4Ele = webDriver.findElement((By.cssSelector(imgQrCodeCssSw)));


    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findAdvanceLocatorWithXPath() {
        gotoTestWebsite();

        // Full Name Component
        //TESTEK - KIỂM THỬ THỰC CHIẾN
        String lblTitleAncestorXPath = "//h4[@test-id='db-title']/ancestor::div[@test-id='about-me-grid']";
        WebElement lblTitleElement = webDriver.findElement(By.xpath(lblTitleAncestorXPath));

        String lblTitleContainsXPath = "//h2[contains(@test-id,'about-me-title')]";
        WebElement lblTitleContainsElement = webDriver.findElement(By.xpath(lblTitleAncestorXPath));

        String lblTitleStartsWithXPath = "//h2[starts-with(@test-id,'a')]";
        WebElement lblTitleStartsWithElement = webDriver.findElement(By.xpath(lblTitleStartsWithXPath));

        String lblTitleTextXPath = "//h2[normalize-space() = 'TESTEK - KIỂM THỬ THỰC CHIẾN']";
        WebElement lblTitleTextElement = webDriver.findElement(By.xpath(lblTitleTextXPath));

        String lblTitleDescendantXPath = "//body[@test-id='body-root']/descendant::h4[@id='db-title-id']";
        WebElement lbTitleDescendantEle = webDriver.findElement(By.xpath(lblTitleDescendantXPath));

        String lblTitlePrecedingXPath = "//h4[@test-id='db-website']/preceding::h2[@test-id='about-me-title']";
        WebElement lblTitlePrecedingElement = webDriver.findElement(By.xpath(lblTitlePrecedingXPath));

        String lblTitleFollowingXPath = "//div[@class='sidebar']/following::h2[@test-id='about-me-title']";
        WebElement lblTitleFollowingElement = webDriver.findElement(By.xpath(lblTitleFollowingXPath));

        String lblTitlePrecedingSiblingXPath = "//div[@class='grid-container']/preceding-sibling::h2[@test-id='about-me-title']";
        WebElement lblTitlePrecedingSiblingElement = webDriver.findElement(By.xpath(lblTitlePrecedingSiblingXPath));

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


    // Handle other elements similarly


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}

