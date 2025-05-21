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

        // Title TESTEK - KIỂM THỬ THỰC CHIẾN
        String lblMainTitleStartCSS = "h2[test-id^='about-me-tit']>b";
        webDriver.findElement(By.cssSelector(lblMainTitleStartCSS));
        String lblMainTitleContainsCSS = "h2[test-id*='-me-tit']>b";
        webDriver.findElement(By.cssSelector(lblMainTitleContainsCSS));

        // Đào tạo API Testing, Performance Testing, Automation Testing
        String lblSubTitleStartCSS = "h4[test-id^='db-titl']";
        webDriver.findElement(By.cssSelector(lblSubTitleStartCSS));
        String lblSubTitleContainsCSS = "h4[test-id*='b-titl']";
        webDriver.findElement(By.cssSelector(lblSubTitleContainsCSS));

        // Link Website
        String lnkWebsiteStartCSS = "a[test-id^='db-website']";
        webDriver.findElement(By.cssSelector(lnkWebsiteStartCSS));
        String lnkWebsiteContainsCSS = "a[test-id*='website']";
        webDriver.findElement(By.cssSelector(lnkWebsiteContainsCSS));

        // Link Discord
        String lnkDiscordStartCSS = "a[test-id^='db-discord']";
        webDriver.findElement(By.cssSelector(lnkDiscordStartCSS));
        String lnkDiscordContainsCSS = "a[test-id*='discord']";
        webDriver.findElement(By.cssSelector(lnkDiscordContainsCSS));

        //Link Facebook
        String lnkFacebookStartCSS = "a[test-id^='db-facebook']";
        webDriver.findElement(By.cssSelector(lnkFacebookStartCSS));
        String lnkFacebookContainsCSS = "a[test-id*='facebook']";
        webDriver.findElement(By.cssSelector(lnkFacebookContainsCSS));

        // Thông tin liên hệ SĐT email
        String lblContactStartCss = "h4[test-id^='db-contac']";
        webDriver.findElement(By.cssSelector(lblContactStartCss));
        String lblContactContainsCSS = "h4[test-id*='contac']";
        webDriver.findElement(By.cssSelector(lblContactContainsCSS));

        // API System
        String lnkApiSystemStartCSS = "a[href^='https://testek.vn/lab/api/v0/prod-man/swagger-ui']";
        webDriver.findElement(By.cssSelector(lnkApiSystemStartCSS));
        String lnkApiSystemContainsCSS = "a[href*='testek.vn/lab/api/v0/prod-man/swagger-ui']";
        webDriver.findElement(By.cssSelector(lnkApiSystemContainsCSS));

        // Automation Web
        String lnkAutomationWebStartCSS = "a[href^='https://testek.vn/lab/auto/lo']";
        webDriver.findElement(By.cssSelector(lnkAutomationWebStartCSS));
        String lnkAutomationWebContainsCSS = "a[href*='//testek.vn/lab/auto/lo']";
        webDriver.findElement(By.cssSelector(lnkAutomationWebContainsCSS));

        // Web Element
        String lnkWebElementStartCSS = "a[test-id^='db-web-element']";
        webDriver.findElement(By.cssSelector(lnkWebElementStartCSS));
        String lnkWebElementContainsCSS = "a[test-id*='web-element']";
        webDriver.findElement(By.cssSelector(lnkWebElementContainsCSS));

        // Image
        String imgCoffeeQrStartCSS = "img[src^='https://lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR']";
        webDriver.findElement(By.cssSelector(imgCoffeeQrStartCSS));
        String imgCoffeeQrContainsCSS = "img[src*='lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR']";
        webDriver.findElement(By.cssSelector(imgCoffeeQrContainsCSS));
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
//        String StartCSS= ;
//        webDriver.findElement(By.xpath(StartCSS));
//        String ContainsCSS = ;
//        webDriver.findElement(By.xpath(ContainsCSS));
//        String TextCSS = ;
//        webDriver.findElement(By.xpath(TextCSS));
//        String AncestorCSS = ;
//        webDriver.findElement(By.xpath(AncestorCSS));
//        String DescendantCSS = ;
//        webDriver.findElement(By.xpath(DescendantCSS));
//        String SiblingCSS = ;
//        webDriver.findElement(By.xpath(SiblingCSS));
//        String PrecedingCSS = ;
//        webDriver.findElement(By.xpath(PrecedingCSS));

        // Title TESTEK - KIỂM THỬ THỰC CHIẾN
        String lblMainTitleStartCSS = "//h2[starts-with(@test-id,'about-me-titl')]" ;
        webDriver.findElement(By.xpath(lblMainTitleStartCSS));
        String lblMainTitleContainsCSS = "//h2[contains(@test-id,'ut-me-titl')]";
        webDriver.findElement(By.xpath(lblMainTitleContainsCSS));
        String lblMainTitleTextCSS = "//b[normalize-space()='TESTEK - KIỂM THỬ THỰC CHIẾN']";
        webDriver.findElement(By.xpath(lblMainTitleTextCSS));
        String lblMainTitleDescendantCSS = "//h2[starts-with(@test-id,'about-me-titl')]/descendant::b";
        webDriver.findElement(By.xpath(lblMainTitleDescendantCSS));
        String lblMainTitleFollowwingCSS = "//div[@test-id='submenu-interactions']/following::b[normalize-space()='TESTEK - KIỂM THỬ THỰC CHIẾN']";
        webDriver.findElement(By.xpath(lblMainTitleFollowwingCSS));

        // Label API System
        String lblApiSystemStartCSS = "//li[starts-with(@test-id,'db-api-syste')]";
        webDriver.findElement(By.xpath(lblApiSystemStartCSS));
        String lblApiSystemContainsCSS = "//li[contains(@test-id,'api-syste')]";
        webDriver.findElement(By.xpath(lblApiSystemContainsCSS));
        String lblApiSystemTextCSS = "//li[text()='API System: ']" ;
        webDriver.findElement(By.xpath(lblApiSystemTextCSS));
        String lblApiSystemAncestorCSS = "//a[@href='https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/']/ancestor::li";
        webDriver.findElement(By.xpath(lblApiSystemAncestorCSS));
        String lblApiSystemDescendantCSS = "//ul[@class='custom-resource']/descendant::li[text()='API System: ']";
        webDriver.findElement(By.xpath(lblApiSystemDescendantCSS));
        String lblApiSystemPrecedingSiblingCSS = "//li[@test-id='db-automation-web']/preceding-sibling::li";
        webDriver.findElement(By.xpath(lblApiSystemPrecedingSiblingCSS));
        String lblApiSystemPrecedingCSS = "//a[@href='https://testek.vn/lab/auto/login']/preceding::li";
        webDriver.findElement(By.xpath(lblApiSystemPrecedingCSS));
    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
