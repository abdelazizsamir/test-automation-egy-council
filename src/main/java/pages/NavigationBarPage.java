package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationBarPage extends BasePage {

    private By loginNavBar = By.className("ico-login");
    private By registerNavBar = By.cssSelector(".ico-register");
    private By myAccountNavBar = By.className("ico-account");
    private By searchInputField = By.id("small-searchterms");

    public NavigationBarPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginFromNavigationBar() {
        clickElement(loginNavBar);
        return new LoginPage(driver);
    }

    public RegistratioPage clickRegisterFromNavigationBar() {
        clickElement(registerNavBar);
        return new RegistratioPage(driver);
    }

    public MyAccountPage clickMyAccountFromNavigationBar() {
        clickElement(myAccountNavBar);
        return new MyAccountPage(driver);
    }

    public ProductDetailsPage searchForProduct(String productName) {
        typeOnInputField(searchInputField, productName + Keys.ENTER);
        return new ProductDetailsPage(driver);
    }
}
