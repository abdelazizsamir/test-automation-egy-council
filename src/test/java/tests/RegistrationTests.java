package tests;


import static fileReaderManager.ReadFromFiles.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NavigationBarPage;
import pages.RegistratioPage;
import pages.SuccessfulRegistrationPage;


public class RegistrationTests extends BaseTests_Parent {
    String fname;
    String lname;
    String email;
    String password;
    String confirmPassword;

    @BeforeClass
    public void loadTestData() {
        String testDataJsonFile = "registrationTestData.json" ;
        fname = getJsonValueByKey(testDataJsonFile, "fnameKey");
        lname = getJsonValueByKey(testDataJsonFile, "lnameKey");
        email = getJsonValueByKey(testDataJsonFile, "emailKey");
        email = email.format(email, System.currentTimeMillis());
        password =  getJsonValueByKey(testDataJsonFile, "passwordKey");
        confirmPassword = getJsonValueByKey(testDataJsonFile, "confirmPasswordKey");
    }

    @Test(priority = 1)
    public void testRegisterNewUser() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        RegistratioPage registratioPage = navigationBarPage.clickRegisterFromNavigationBar();
        SuccessfulRegistrationPage successfulRegistrationPage =
                registratioPage.registerNewUser(fname, lname, email, password, confirmPassword);
        Assert.assertEquals(successfulRegistrationPage.getSuccessfulRegistrationMsg(),
                "Your registration co mpleted", "error registration message");
    }

    @Test(priority = 1)
    public void testDuplicateUser() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        RegistratioPage registratioPage = navigationBarPage.clickRegisterFromNavigationBar();
        SuccessfulRegistrationPage successfulRegistrationPage =
                registratioPage.registerNewUser(fname, lname, email, password, confirmPassword);
        Assert.assertEquals(successfulRegistrationPage.getSuccessfulRegistrationMsg(),
                "Your registration c ompleted", "error registration message");
    }


}
