package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    // locators
    private By productTitle = By.cssSelector(".product-title> a");

    // operations
    public String getProductTitle ()
    {
        return getTextOfElement(productTitle);
    }
}
