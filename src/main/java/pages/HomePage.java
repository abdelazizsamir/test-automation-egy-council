package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    By welcomeMsg = By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMsg ()
    {
        return getTextOfElement(welcomeMsg);
    }
}
