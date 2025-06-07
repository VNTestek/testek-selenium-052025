package com.testek.study.lesson08;

import com.testek.study.common.Menu;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

/**
 * Class for Window interaction
 */
@Slf4j
public class ActionsAPITest {
    private WebDriver mWebDriver;

    @BeforeMethod
    public void beforeTestMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
    }

    @AfterMethod
    public void afterMethod() {
        if (mWebDriver != null) {
            mWebDriver.quit();
            mWebDriver = null;
        }
    }


    /**
     * Access website and interact with frame
     */

    @Test
    public void testActionClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);

        //Click Giảng viên là các chuyên gia đầu ngành
        String firstAccordionId = "accordion-header-1";
        WebElement firstAccordionEle = mWebDriver.findElement(By.id(firstAccordionId));
        firstAccordionEle.click();
        waitForDebug(2000);
        String firstAccordionContentId = "accordion-body-1";
        WebElement firstAccordionContentEle = mWebDriver.findElement(By.id(firstAccordionContentId));
        System.out.println("firstAccordionContent value: " + firstAccordionContentEle.getText());
        firstAccordionEle.click();

        //double-click
        Actions actions = new Actions(mWebDriver);
        actions.doubleClick(firstAccordionEle).perform();
        System.out.println("firstAccordionContent value after double click: " + firstAccordionContentEle.getText());

        //Học để làm KHÔNG học để biết
        String secondAccordionId = "accordion-header-2";
        WebElement secondAccordionEle = mWebDriver.findElement(By.id(secondAccordionId));
        secondAccordionEle.click();
        waitForDebug(2000);
        String secondAccordionContentId = "accordion-body-2";
        WebElement secondAccordionContentEle = mWebDriver.findElement(By.id(secondAccordionContentId));
        System.out.println("secondAccordionContent value: " + secondAccordionContentEle.getText());
        secondAccordionEle.click();

        //double-click
        actions.doubleClick(secondAccordionEle).perform();
        System.out.println("secondAccordionContent value after double click: " + secondAccordionContentEle.getText());

        // Định hướng nghề nghiệp
        String thirdAccordionId = "accordion-header-3";
        WebElement thirdAccordionEle = mWebDriver.findElement(By.id(thirdAccordionId));
        thirdAccordionEle.click();
        waitForDebug(2000);
        String thirdAccordionContentId = "accordion-body-3";
        WebElement thirdAccordionContentEle = mWebDriver.findElement(By.id(thirdAccordionContentId));
        System.out.println("thirdAccordionContent value: " + thirdAccordionContentEle.getText());
        thirdAccordionEle.click();

        //double-click
        actions.doubleClick(thirdAccordionEle).perform();
        System.out.println("thirdAccordionContent value after double click: " + thirdAccordionContentEle.getText());
    }

    @Test
    public void testActionPractice() {
        gotoTestWebsite(Menu.WIDGETS, Menu.TOOL_TIPS);
        Actions mActions = new Actions(mWebDriver);

        //hover to tooltip-button-1
        String hoverXPath = "//button[@test-id='tooltip-button-1']";
        WebElement hoverEle = mWebDriver.findElement(By.xpath(hoverXPath));

        mActions.moveToElement(hoverEle).click().build().perform();

        //get text & print
        String hoverTextXPath = "//div[@test-id='tooltip-1']";
        WebElement hoverTextEle = mWebDriver.findElement(By.xpath(hoverTextXPath));
        System.out.println("hoverTextValue: " + hoverTextEle.getText());

        //tooltip-link-2
        String hoverLinkXPath = "//a[@test-id='tooltip-link-2']";
        WebElement hoverLinkEle = mWebDriver.findElement(By.xpath(hoverLinkXPath));

        mActions.moveToElement(hoverLinkEle).click().build().perform();

        //get text & print
        String hoverLinkTextXPath = "//div[@test-id='tooltip-2']";
        WebElement hoverLinkTextEle = mWebDriver.findElement(By.xpath(hoverLinkTextXPath));
        System.out.println("hoverLinkTextValue: " + hoverLinkTextEle.getText());

        //span tooltip-text-3
        String hoverText3XPath = "//span[@test-id='tooltip-text-3']";
        WebElement hoverText3Ele = mWebDriver.findElement(By.xpath(hoverText3XPath));
        mActions.moveToElement(hoverText3Ele).click().build().perform();

        String hoverText3ValueXPath = "//div[@test-id='tooltip-3']";
        WebElement hoverText3ValueEle = mWebDriver.findElement(By.xpath(hoverText3ValueXPath));
        System.out.println("hoverText3Value: " + hoverText3ValueEle.getText());
    }


    @Test
    public void testAction() {
        // Access to the website
        gotoTestWebsite(Menu.WIDGETS, Menu.TOOL_TIPS);

        // Create a new Actions
        Actions mActions = new Actions(mWebDriver);

        // Hover to elements
        String hoverXPath = "//button[@test-id='tooltip-button-1']";
        WebElement hoverElement = mWebDriver.findElement(By.xpath(hoverXPath));


        mActions.moveToElement(hoverElement).click().build().perform();

        // Verify the hover. The elements had a new attribute "aria-describedby"
        String tooltipXPath = "//div[@test-id='tooltip-1']";
        WebElement hoverEle = mWebDriver.findElement(By.xpath(tooltipXPath));
        String hoverText = hoverEle.getText();
        log.info("Tooltip text: {}", hoverText);
        waitForDebug(5000);

        // Click via Actions
        String clickXPath = "//div[@test-id='submenu-auto-complete']";
        WebElement btnAutoCompletedEle = mWebDriver.findElement(By.xpath(clickXPath));
        mActions.click(btnAutoCompletedEle).perform();
        log.info("Click to: {}", btnAutoCompletedEle.getText());
        waitForDebug(5000);
    }

    @Test
    public void testDragAndDrop() {
        // Access to the website
        gotoTestWebsite(Menu.INTERACTIONS, Menu.DROPPABLE);

        // Create a new Actions
        Actions mActions = new Actions(mWebDriver);

        // Drag and drop
        String dragXPath = "//div[@test-id='draggable']";
        WebElement dragEle = mWebDriver.findElement(By.xpath(dragXPath));

        String dropXPath = "//div[@test-id='droppable']";
        WebElement dropEle = mWebDriver.findElement(By.xpath(dropXPath));

        log.info("Drag and drop: {} to {}", dragEle.getText(), dropEle.getText());
        mActions.dragAndDrop(dragEle, dropEle).perform();
        waitForDebug(5000);

        // Release the element
        WebElement btnResetEle = mWebDriver.findElement(By.id("draggableBtn"));
        mActions.click(btnResetEle).perform();
        log.info("Reset Drag & Drop: {}", btnResetEle.getText());
        waitForDebug(5000);
    }


    @Test
    public void testDoubleClick() {
        // Access to the website
        gotoTestWebsite(Menu.ELEMENTS, Menu.BUTTONS);

        // Create a new Actions
        Actions mActions = new Actions(mWebDriver);

        // Double click
        WebElement doubleClickEle = mWebDriver.findElement(By.id("button2"));

        mActions.doubleClick(doubleClickEle).perform();
        waitForDebug(5000);

        // Verify the double click
        String lblDoubleClickXPath = "//p[@test-id='buttons-result-text']";
        WebElement lblDoubleClickEle = mWebDriver.findElement(By.xpath(lblDoubleClickXPath));
        String actDoubleClickText = lblDoubleClickEle.getText();
        log.info("Double click text: {}", actDoubleClickText);

    }

    @Test
    public void testRightClick() {
        // Access to the website
        gotoTestWebsite(Menu.ELEMENTS, Menu.BUTTONS);

        // Create a new Actions
        Actions mActions = new Actions(mWebDriver);

        // Right click
        WebElement rightClickEle = mWebDriver.findElement(By.id("button2"));

        mActions.contextClick(rightClickEle).perform();
        waitForDebug(5000);

        // Verify the double click
        String lblDoubleClickXPath = "//p[@test-id='buttons-result-text']";
        WebElement lblDoubleClickEle = mWebDriver.findElement(By.xpath(lblDoubleClickXPath));
        String actDoubleClickText = lblDoubleClickEle.getText();
        log.info("Right click text: {}", actDoubleClickText);
        waitForDebug(5000);
    }

    @Test
    public void testKeyBoard() {
        // Access to the website
        gotoTestWebsite(Menu.ELEMENTS, Menu.TEXT_BOX);

        // Create a new Actions
        Actions mActions = new Actions(mWebDriver);

        WebElement keyBoardEle = mWebDriver.findElement(By.id("name"));

        mActions.keyDown(keyBoardEle, Keys.SHIFT).sendKeys("Hello Vincent - upperCase nhé").keyUp(Keys.SHIFT).perform();
        waitForDebug(5000);
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
