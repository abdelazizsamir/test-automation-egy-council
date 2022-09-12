package tests;

import fileReaderManager.ReadFromFiles;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationBarPage;
import pages.ProductDetailsPage;


public class ProductDetailsTests extends BaseTests_Parent{

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
    public void checkProductDetailsDisplayed ()
    {
        String productTitle = "Apple MacBook Pro 13-inch" ;
        ProductDetailsPage productDetailsPage = navigationBarPage.searchForProduct(productTitle);
        Assert.assertEquals(productDetailsPage.getProductTitle(), productTitle);
    }
}
