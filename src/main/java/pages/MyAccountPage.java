package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private By myAccountPageTitle = By.cssSelector(".page-title > h1");
    private By emailField = By.id("Email");


    public String getMyAccountPageTitle ()
    {
        return getTextOfElement(myAccountPageTitle);
    }

    public String getEmailFromMyAccountPage ()
    {
        return getAttributeOfElement(emailField, "value");
    }

}
