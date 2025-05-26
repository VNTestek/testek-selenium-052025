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

        // find element by contains CSS
        String textHeaderCSS = "h2[test-id *= 'about-me']";
        WebElement titleHeaderElement = webDriver.findElement(By.cssSelector(textHeaderCSS));

        // find element by start-with CSS
        String textFindOutByStartWith = "h2[test-id ^= 'about']";
        WebElement titleFindOutByStartWithCSS = webDriver.findElement(By.cssSelector(textFindOutByStartWith));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findAdvanceLocatorWithXPath() {
        gotoTestWebsite();

        findTitleWithContains();
        findTitleByStartWith();
        findTitleByText();
        findTitleByNormalizeSpace();
        findTitleByAncestor();
        findTitleByDescendant();
        findTitleByPreceding();
        findTitleByFollowing();
        findTitleByFollowingSibling();
        findTitleByPrecedingSibling();
    }

    private void findTitleByFollowingSibling() {
        String titleFindOutByFollowingSibling = "//h4[@test-id='db-title']/following-sibling::h4[@test-id='db-website']";
        WebElement titleFindOutByFollowingSiblingWithXpath = webDriver.findElement(By.xpath(titleFindOutByFollowingSibling));
    }

    private void findTitleByPrecedingSibling() {
        String titleFindOutByPrecedingSibling = "//h4[@test-id='db-website']/preceding-sibling::h4[@test-id='db-title']";
        WebElement titleFindOutByPrecedingSiblingWithXpath = webDriver.findElement(By.xpath(titleFindOutByPrecedingSibling));
    }

    private void findTitleByFollowing() {
        String titleFindOutByFollowing = "//h2[@test-id='about-me-title']/following::h4[@test-id='db-facebook']";
        WebElement titleFindOutByFlowingWithXpath = webDriver.findElement(By.xpath(titleFindOutByFollowing));
    }

    private void findTitleByPreceding() {
        String titleFindOutByPreceding = "//h4[@test-id='db-website']/preceding::h2[@test-id='about-me-title']";
        WebElement titleFindOutByPrecedingWithXpath = webDriver.findElement(By.xpath(titleFindOutByPreceding));
    }

    private void findTitleByDescendant() {
        String titleFindOutByDescendant = "//div[@test-id='container-root']/descendant::h4[@test-id='db-website']";
        WebElement titleFindOutByDescendantWithXpath = webDriver.findElement(By.xpath(titleFindOutByDescendant));
    }

    private void findTitleByAncestor() {
        String titleFindOutByAncestor = "//h4[@test-id='db-website']/ancestor::div[@test-id='container-root']";
        WebElement titleFindOutByAncestorWithXpath = webDriver.findElement(By.xpath(titleFindOutByAncestor));
    }

    private void findTitleByNormalizeSpace() {
        String titleFindOutByNormalizeSpace = "//h4[normalize-space()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        WebElement titleFindOutByNormalizeSpaceWithXpath = webDriver.findElement(By.xpath(titleFindOutByNormalizeSpace));
    }

    private void findTitleByText() {
        String titleFindOutByText = "//h4[text()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        WebElement titleFindOutByTextWithXpath = webDriver.findElement(By.xpath(titleFindOutByText));
    }


    private void findTitleByStartWith() {
        String textFindOutByStartWith = "//h2[starts-with(@test-id, 'about-me')]";
        WebElement titleFindOutByStartWithCSS = webDriver.findElement(By.xpath(textFindOutByStartWith));   //HoangBH: Tên biến chưa phù hợp
    }

    private void findTitleWithContains() {
        String textHeaderXpath = "//h2[contains(@test-id,'about-me')]";
        WebElement titleHeaderElement = webDriver.findElement(By.xpath(textHeaderXpath));
    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

    }
}
