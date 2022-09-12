package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistratioPage extends BasePage{


    // locators
    By firstNameField = By.id("FirstName");
    By lastNameField  = By.id("LastName");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By confirmPasswordField = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");

    public RegistratioPage(WebDriver driver) {
        super(driver);
    }

    public SuccessfulRegistrationPage registerNewUser (String fname, String lname, String email, String password, String confirmPassword)
    {
        typeOnInputField(firstNameField, fname);
        typeOnInputField(lastNameField, lname);
        typeOnInputField(emailField, email);
        typeOnInputField(passwordField, password);
        typeOnInputField(confirmPasswordField, confirmPassword);
        clickElement(registerBtn);
        return new SuccessfulRegistrationPage(driver);
    }
}
