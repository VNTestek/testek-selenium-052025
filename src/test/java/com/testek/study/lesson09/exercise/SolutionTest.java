package com.testek.study.lesson09.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

@Getter
@Setter
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
//    @AfterClass
//    public void afterClass() {
//        if (Objects.nonNull(mWebDriver)) mWebDriver.quit();
//    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to @link{Menu#FORM} navigation
     */
    @Test(description = "Element Interaction")
    public void testStudentForm() {
        JavascriptExecutor javaScripts = (JavascriptExecutor) mWebDriver;
        WebDriverWait wait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
        Actions actions = new Actions(mWebDriver);
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);
//        Title
        String h3Title = "//h3[@id = 'student-registration-title']";
        WebElement h3TitleEle = mWebDriver.findElement(By.xpath(h3Title));
//        firstName
        String lblFirstName = "//label[@test-id = 'label-firstName']";
        WebElement lblFirstNameEle = mWebDriver.findElement(By.xpath(lblFirstName));
        String inputFirstName = "//input[@id = 'firstName']";
        WebElement inputFirstNameEle = mWebDriver.findElement(By.xpath(inputFirstName));
        actions.moveToElement(inputFirstNameEle).click().sendKeys("Nga").build().perform();

        String lblLastName = "//label[@test-id = 'label-lastName']";
        WebElement lblLastNameEle = mWebDriver.findElement(By.xpath(lblLastName));
        String inputLastName = "//input[@id = 'lastName']";
        WebElement inputLastNameEle = mWebDriver.findElement(By.xpath(inputLastName));
        actions.moveToElement(inputLastNameEle).click().sendKeys("Dinh").build().perform();

        String lblEmail = "//label[@test-id = 'label-email']";
        WebElement lblEmailEle = mWebDriver.findElement(By.xpath(lblEmail));
        String inputEmail = "//input[@id = 'email']";
        WebElement inputEmailEle = mWebDriver.findElement(By.xpath(inputEmail));
//        actions.moveToElement(inputEmailEle).click().sendKeys("Dinh").build().perform();
        javaScripts.executeScript("arguments[0].value='ngadinh0406@gmail.com';", inputEmailEle);


        String lblGender = "//label[@test-id = 'label-gender']";
        WebElement lblGenderEle = mWebDriver.findElement(By.xpath(lblGender));
        String inputGenderMale = "//input[@id = 'male']";
        WebElement inputGenderMaleEle = mWebDriver.findElement(By.xpath(inputGenderMale));
        javaScripts.executeScript("arguments[0].click();", inputGenderMaleEle);
        String inputGenderFemale = "//input[@id = 'female']";
        WebElement inputGenderFemaleEle = mWebDriver.findElement(By.xpath(inputGenderFemale));
//        javaScripts.executeScript("arguments[0].click();", inputGenderMaleEle);

        String lblMobi = "//label[@test-id = 'label-mobile']";
        WebElement lblMobiEle = mWebDriver.findElement(By.xpath(lblMobi));
        String inputMobi = "//input[@id = 'mobile']";
        WebElement inputMobiEle = mWebDriver.findElement(By.xpath(inputMobi));
        actions.moveToElement(inputMobiEle).click().sendKeys("092083377333").build().perform();

        String lblDOB = "//label[@test-id = 'label-dob']";
        WebElement lblDOBEle = mWebDriver.findElement(By.xpath(lblDOB));
        String inputDOB = "//input[@id = 'dob']";
        WebElement inputDOBEle = mWebDriver.findElement(By.xpath(inputDOB));
        javaScripts.executeScript("arguments[0].value='2025-06-01';", inputDOBEle);

        String lblSubjects = "//label[@test-id = 'label-subjects']";
        WebElement lblSubjectsEle = mWebDriver.findElement(By.xpath(lblSubjects));
        String inputSubjects = "//input[@id = 'subjects']";
        WebElement inputSubjectsEle = mWebDriver.findElement(By.xpath(inputSubjects));
        actions.moveToElement(inputSubjectsEle).click().sendKeys("test").build().perform();

        String lblHobbies = "//label[@test-id = 'label-hobbies']";
        WebElement lblHobbiesEle = mWebDriver.findElement(By.xpath(lblHobbies));
        String inputReading = "//input[@id = 'reading']";
        WebElement inputReadingEle = mWebDriver.findElement(By.xpath(inputReading));
        javaScripts.executeScript("arguments[0].click();", inputReadingEle);
        String inputSports = "//input[@id = 'sports']";
        WebElement inputSportsEle = mWebDriver.findElement(By.xpath(inputSports));
        javaScripts.executeScript("arguments[0].click();", inputSportsEle);
        String inputMusic = "//input[@id = 'music']";
        WebElement inputMusicEle = mWebDriver.findElement(By.xpath(inputMusic));
        javaScripts.executeScript("arguments[0].click();", inputMusicEle);

        String lblAddress = "//label[@test-id = 'label-address']";
        WebElement lblAddressEle = mWebDriver.findElement(By.xpath(lblAddress));
        String inputAddress = "//textarea[@id = 'address']";
        WebElement inputAddressEle = mWebDriver.findElement(By.xpath(inputAddress));
        actions.moveToElement(inputAddressEle).click().sendKeys("HN").build().perform();

        String btnSubmit = "//button[@id = 'submit-button']";
        WebElement btnSubmitEle = mWebDriver.findElement(By.xpath(btnSubmit));
        javaScripts.executeScript("arguments[0].click();", btnSubmitEle);
//        String btnClear = "//button[@id = 'clear-button']";
//        WebElement btnClearEle = mWebDriver.findElement(By.xpath(btnClear));



    }



    /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu parent, Menu subMenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        mWebDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, parent.getName())));
        mnuElementEle.click();

        WebElement mnuEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, subMenu.getName())));
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
