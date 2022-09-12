package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    // Locators
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginBtn = By.cssSelector(".login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Operations on locators
    // successful login
    public HomePage loginToAppWithValidCredentials (String email, String password)
    {
        typeOnInputField(emailField, email);
        typeOnInputField(passwordField, password);
        clickElement(loginBtn);
        return new HomePage(driver);
    }
    public LoginPage loginToAppWithInvalidCredentials (String invalidEmail, String invalidPassword)
    {
        typeOnInputField(emailField, invalidEmail);
        typeOnInputField(passwordField, invalidPassword);
        clickElement(loginBtn);
        return new LoginPage(driver);
    }


}
