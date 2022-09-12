package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement locateElement (By elementLocator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        return driver.findElement(elementLocator);
    }

    public void clickElement (By elementLocator)
    {
        locateElement(elementLocator).click();
    }

    public void typeOnInputField (By elementLocator, String text)
    {
        locateElement(elementLocator).sendKeys(text);
    }

    public String getTextOfElement (By elementLocator)
    {
        return locateElement(elementLocator).getText();
    }


    public String getAttributeOfElement (By elementLocator, String attributeKey)
    {
        return locateElement(elementLocator).getAttribute(attributeKey);
    }
    // select from drop by visibleb text

    // accespt alert

    // dismiss alert

    // hover

    // context click

    // ...................

}
