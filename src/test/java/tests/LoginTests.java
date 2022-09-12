package tests;

import fileReaderManager.ReadFromFiles;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.NavigationBarPage;

import static fileReaderManager.ReadFromFiles.getPropertyByKey;


public class LoginTests extends BaseTests_Parent{

    @Test(priority = 1)
    public void testLoginToApp ()
    {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        LoginPage loginPage = navigationBarPage.clickLoginFromNavigationBar();
        HomePage homePage = loginPage.
                loginToAppWithValidCredentials(
                        getPropertyByKey(configPropertyFileName , "APP_URL")
                       , getPropertyByKey(configPropertyFileName , "APP_URL"));
        Assert.assertEquals(homePage.getWelcomeMsg(), "WELCOME TO OUR STORE");
    }

}
