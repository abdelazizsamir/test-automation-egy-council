package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulRegistrationPage extends BasePage{

    By successfulRegitration = By.className("result");

    public SuccessfulRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessfulRegistrationMsg ()
    {
        return getTextOfElement(successfulRegitration);
    }
}
