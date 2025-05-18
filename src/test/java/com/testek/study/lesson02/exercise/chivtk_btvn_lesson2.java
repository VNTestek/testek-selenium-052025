package com.testek.study.lesson02.exercise;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Objects;

@Getter
@Setter
public class chivtk_btvn_lesson2 {
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
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }

    //BTVN LESSON 2:
    @Test(description = "Find elements")
    public void lesson2() {
        gotoTestWebsite();
        //TÌM KIẾM ĐOẠN TEXT: “TESTEK - KIỂM THỬ THỰC CHIẾN”
        String cssText = "[test-id='about-me-title']  b";
        webElement = webDriver.findElement(By.cssSelector(cssText));
        String xpathText = "//b[contains(text(),'TESTEK - KIỂM THỬ')]";
        webElement = webDriver.findElement(By.xpath(xpathText));

        //TÌM KIẾM ĐOẠN TEXT: "Đào tạo API Testing, Performance Testing, Automation Testing"
        String cssId = "[id='db-title-id']";
        webElement = webDriver.findElement(By.cssSelector(cssId));
        String xpathId = "//h4[@id='db-title-id']";
        webElement = webDriver.findElement(By.xpath(xpathId));
        String xpathClass = "//h4[@class='db-title-class']";
        webElement = webDriver.findElement(By.xpath(xpathClass));
        String cssClass = ".db-title-class";
        webElement = webDriver.findElement(By.cssSelector(cssClass));
        String cssclassAttr = "db-title-class";
        webElement = webDriver.findElement(By.className(cssclassAttr));
        String idAttr = "db-title-id";
        webElement = webDriver.findElement(By.id(idAttr));
        String cssName = "[name='db-title-name']";
        webElement = webDriver.findElement(By.cssSelector(cssName));
        String nameAttr = "db-title-name";
        webElement = webDriver.findElement(By.name(nameAttr));
        String xpathName = "//h4[@name='db-title-name']";
        webElement = webDriver.findElement(By.xpath(xpathName));

        //TÌM KIẾM LINK: Website: https://testek.vn
        String csslinkWebsite = "[test-id='db-website']";
        webElement = webDriver.findElement(By.cssSelector(csslinkWebsite));
        String xpathLink = "//h4[@test-id='db-website']";
        webElement = webDriver.findElement(By.xpath(xpathLink));
        String linktextWeb = "https://testek.vn";
        webElement = webDriver.findElement(By.linkText(linktextWeb));

        //TÌM KIÊM LINK: Discord: Testek - Kiểm thử thực chiến
        String idDiscord = "db-discord";
        webElement = webDriver.findElement(By.id(idDiscord));
        String cssselectorDiscord = "#db-discord";
        webElement = webDriver.findElement(By.cssSelector(cssselectorDiscord));

        //TÌM KIẾM LINK: Facebook: Testek - Kiểm thử thực chiến
        String xpathFb = "//a[@test-id='db-facebook-link']";
        webElement = webDriver.findElement(By.xpath(xpathFb));
        String cssFB = "[test-id='db-facebook']";
        webElement = webDriver.findElement(By.cssSelector(cssFB));

        //TÌM KIẾM ĐOẠN TEXT: Hotline: 083.286.8822 / Email: vntestek@gmail.com
        String xpathHotline = "//h4[contains(text(),'Hotline')]";
        webElement = webDriver.findElement(By.xpath(xpathHotline));
        String cssselectorHotline = "[test-id='db-contact']";
        webElement = webDriver.findElement(By.cssSelector(cssselectorHotline));

        //TÌM KIẾM ĐOẠN TEXT: Các hệ thống Testek cung cấp
        String cssselector = "[test-id$='-systems']";
        webElement = webDriver.findElement(By.cssSelector(cssselector));
        String xpathTextHT = "//h4[text()='Các hệ thống Testek cung cấp']";
        webElement = webDriver.findElement(By.xpath(xpathTextHT));

        //TÌM KIẾM LINK TEXT: API System: Swagger
        String partiallinktextAPI = "Swag";
        webElement = webDriver.findElement(By.partialLinkText(partiallinktextAPI));
        String cssselectorAPI = "[test-id*='-api-system-']";
        webElement = webDriver.findElement(By.cssSelector(cssselectorAPI));

        //TÌM KIẾM LINK TEXT: Automation Web: Product Management
        String partiallinktextAuto = "Management";
        webElement = webDriver.findElement(By.partialLinkText(partiallinktextAuto));
        String linktextAuto = "Product Management";
        webElement = webDriver.findElement(By.linkText(linktextAuto));

        //TÌM KIẾM LINK TEXT: Web Element: Basic Web Elements
        String partiallinktextWE = "Web Elements";
        webElement = webDriver.findElement(By.partialLinkText(partiallinktextWE));
        String cssWE = "[test-id^=\"db-web-element-\"]";
        webElement = webDriver.findElement(By.cssSelector(cssWE));

        //TÌM KIẾM ĐOẠN TEXT: ACCOUNT
        String xpathAcc = "//li[@test-id='db-account']";
        webElement = webDriver.findElement(By.xpath(xpathAcc));
        String cssAcc = "[test-id='db-account']";
        webElement = webDriver.findElement(By.cssSelector(cssAcc));

        //TÌM KIẾM ĐOẠN TEXT: Database: Updating...
        String xpathDB = "//li[contains(text(),'Updating...')]";
        webElement = webDriver.findElement(By.xpath(xpathDB));
        String cssDB = "[test-id='db-database']";
        webElement = webDriver.findElement(By.cssSelector(cssDB));

        //TÌM KIẾM ĐOẠN TEXT: Buy Me a Coffee
        String xpathtextBuy = "//p[contains(text(),'Coffee')]";
        webElement = webDriver.findElement(By.xpath(xpathtextBuy));
        String csstextBuy = "[test-id$='coffee-text']";
        webElement = webDriver.findElement(By.cssSelector(csstextBuy));

        //TÌM KIẾM HÌNH QR CODE
        String xpathQRcode = "//img[@test-id='about-me-coffee-img']";
        webElement = webDriver.findElement(By.xpath(xpathQRcode));
        String cssQRcode = "[test-id='about-me-coffee-img']";
        webElement = webDriver.findElement(By.cssSelector(cssQRcode));

        //TÌM KIẾM ĐOẠN TEXT: HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!
        String xpathtextCB = "//b[contains(text(),'CƠ BẢN')]";
        webElement = webDriver.findElement(By.xpath(xpathtextCB));
        String csstextCB = "[test-id*='web-elements']";
        webElement = webDriver.findElement(By.cssSelector(csstextCB));

        //TÌM KIẾM HÌNH ẢNH TIKTOK: vntestek
        webDriver.switchTo().frame(0); //2. Element nằm trong iframe: Phần TikTok được nhúng từ bên ngoài (ví dụ iframe),
        //cần chuyển vào iframe trước: Cách kiểm tra: mở DevTools → xem phần tử #embed-profile-container có nằm trong <iframe> không.
        String cssImg = "#embed-profile-container > div";
        webElement = webDriver.findElement(By.cssSelector(cssImg));
        String xpathImg = "//div[@id='embed-profile-container']/div[1]";
        webElement = webDriver.findElement(By.xpath(xpathImg));

        //TÌM KIẾM BUTTON OPEN TIK TOK
        String xpathopenTiktok = "//div[@class='css-1f603so e1v8cfre1']";
        webElement = webDriver.findElement(By.xpath(xpathopenTiktok));
        String cssopenTiktok = "[class$='e1v8cfre1']";
        webElement = webDriver.findElement(By.cssSelector(cssopenTiktok));
    }
}

