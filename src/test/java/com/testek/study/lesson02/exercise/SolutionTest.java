package com.testek.study.lesson02.exercise;

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
    public void findLocatorWithCSS() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteCSS = "h4#db-title-id";
        WebElement lblWebsiteEle = webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Handle other elements similarly
        String descriptionCss = ".db-title-class";
        WebElement descriptionCssEle = webDriver.findElement(By.cssSelector(descriptionCss));

        String websiteCss = "a[href='https://testek.vn']";
        WebElement websiteCssEle = webDriver.findElement((By.cssSelector(websiteCss)));

        String discordCss = "#db-discord";
        WebElement discrodCssEle = webDriver.findElement((By.cssSelector(discordCss)));

        String facebookCss = "h4[test-id= 'db-facebook']";
        WebElement facebookCssEle = webDriver.findElement((By.cssSelector(facebookCss)));

        String hotlineCss = "h4[test-id= 'db-contact']";
        WebElement hotlineCssEle = webDriver.findElement((By.cssSelector(hotlineCss)));

        String systemCss = "h4[test-id= 'db-systems']";
        WebElement systemCssEle = webDriver.findElement((By.cssSelector(systemCss)));

        String accountCss = "li[test-id= 'db-account']";
        WebElement accountCssEle = webDriver.findElement((By.cssSelector(accountCss)));

        String imgCss = "img[test-id= 'about-me-coffee-img']";
        WebElement imgCssEle = webDriver.findElement((By.cssSelector(imgCss)));

        String aboutMeCss = "h4[test-id= 'about-me-web-elements']";
        WebElement aboutMeCssEle = webDriver.findElement((By.cssSelector(aboutMeCss)));

//        String avatarCss = "img[data-e2e='creator-profile-userInfo-Avatar']";
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        WebElement avatarCssEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(avatarCss)));


//        String vntestekCss = "span[data-e2e='creator-profile-userInfo-UsernameContent']";
//        WebElement vntestekCssEle = webDriver.findElement((By.cssSelector(vntestekCss)));

//        String numberFollowingCss = "div[data-e2e='creator-profile-userInfo-NumberContainer'][1]/a";
//        WebElement numberFollowingCssEle = webDriver.findElement((By.cssSelector(numberFollowingCss)));
//
//        String numberFollowersCss = "div[data-e2e='creator-profile-userInfo-NumberContainer'][2]/a";
//        WebElement numberFollowersCssEle = webDriver.findElement((By.cssSelector(numberFollowersCss)));
//
//        String numberLikesCss = "div[data-e2e='creator-profile-userInfo-NumberContainer'][3]/a";
//        WebElement numberLikesCssEle = webDriver.findElement((By.cssSelector(numberLikesCss)));

//        String buttonCss = "button[data-e2e='common-cardFooter-TUXButton']";
//        WebElement buttonCssEle = webDriver.findElement((By.cssSelector(buttonCss)));

    }

    @Test(description = "Find element with XPath")
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteXPath = "//h4[@test-id='db-website']";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Handle other elements similarly
        //aboutMeTitle Element
        String pageTitleXpath = "//b[normalize-space(.)='TESTEK - KIỂM THỬ THỰC CHIẾN']";
        WebElement pageTitleEle = webDriver.findElement(By.xpath(pageTitleXpath));

        String descriptionXpath = "//h4[@id='db-title-id']";
        WebElement descriptionXpathEle = webDriver.findElement((By.xpath(descriptionXpath)));

        String websiteXpath = "//a[@href='https://testek.vn']";
        WebElement websiteXpathEle = webDriver.findElement((By.xpath(websiteXpath)));

        String discordXpath = "//h4[@id ='db-discord']";
        WebElement discrodXpathEle = webDriver.findElement((By.xpath(discordXpath)));

        String facebookXpath = "//h4[@test-id= 'db-facebook']";
        WebElement facebookXpathEle = webDriver.findElement((By.xpath(facebookXpath)));

        String hotlineXpath = "//h4[@test-id= 'db-contact']";
        WebElement hotlineXpathEle = webDriver.findElement((By.xpath(hotlineXpath)));

        String systemXpath = "//h4[@test-id= 'db-systems']";
        WebElement systemXpathEle = webDriver.findElement((By.xpath(systemXpath)));

        String accountXpath = "//li[@test-id= 'db-account']";
        WebElement accountXpathEle = webDriver.findElement((By.xpath(accountXpath)));

        String imgXpath = "//img[@test-id= 'about-me-coffee-img']";
        WebElement imgXpathEle = webDriver.findElement((By.xpath(imgXpath)));

        String aboutMeXpath = "//h4[@test-id= 'about-me-web-elements']";
        WebElement aboutMeXpathEle = webDriver.findElement((By.xpath(aboutMeXpath)));

        String avatarXpath = "//img[@data-e2e='creator-profile-userInfo-Avatar']";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        //WebElement avatarXpathEle = webDriver.findElement((By.xpath(avatarXpath)));
        WebElement avatarCssEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(avatarXpath)));


        String vntestekXpath = "//span[text()='vntestek']";
       // WebElement vntestekXpathEle = webDriver.findElement((By.xpath(vntestekXpath)));
        WebElement vntestekXpathEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(vntestekXpath)));

        String numberFollowingXpath = "//div[@data-e2e='creator-profile-userInfo-NumberContainer'][1]/a";
        WebElement numberFollowingXpathEle = webDriver.findElement((By.xpath(numberFollowingXpath)));

        String numberFollowersXpath = "//div[@data-e2e='creator-profile-userInfo-NumberContainer'][2]/a";
        WebElement numberFollowersXpathEle = webDriver.findElement((By.xpath(numberFollowersXpath)));

        String numberLikesXpath = "//div[@data-e2e='creator-profile-userInfo-NumberContainer'][3]/a";
        WebElement numberLikesXpathEle = webDriver.findElement((By.xpath(numberLikesXpath)));

        String buttonXpath = "//button[@data-e2e='common-cardFooter-TUXButton']";
        WebElement buttonXpathEle = webDriver.findElement((By.xpath(buttonXpath)));
    }

    /**
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
