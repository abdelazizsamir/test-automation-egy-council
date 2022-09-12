package tests;

import fileReaderManager.ReadFromFiles;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.NavigationBarPage;


public class MyAccountTests extends BaseTests_Parent{
    NavigationBarPage navigationBarPage;
    @BeforeMethod
    public void loginToApp ()
    {
        navigationBarPage = new NavigationBarPage(driver);
        LoginPage loginPage = navigationBarPage.clickLoginFromNavigationBar();
        loginPage.loginToAppWithValidCredentials((String) ReadFromFiles.getPropertyByKey("configData.properties"
                        , "EMAIL"),
                (String) ReadFromFiles.getPropertyByKey("configData.properties" , "PASSWORD"));
    }

    @Test
    public void testMyAccountData ()
    {
        MyAccountPage myAccountPage = navigationBarPage.clickMyAccountFromNavigationBar();
        Assert.assertEquals(myAccountPage.getMyAccountPageTitle(), "My account - Customer info",
                "the my account page title should be 'My account - Customer info' ");
        Assert.assertEquals(myAccountPage.getEmailFromMyAccountPage(),
                (String) ReadFromFiles.getPropertyByKey("configData.properties", "EMAIL"));
    }
}
