package tests;

import static  fileReaderManager.ReadFromFiles.getPropertyByKey;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;



public class BaseTests_Parent {

    public static String configPropertyFileName =  "configData.properties" ;
    WebDriver driver;

    @BeforeMethod
    public void setup_initiateDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //driver.manage().window().maximize();
        driver.get(getPropertyByKey(configPropertyFileName , "APP_URL"));
    }

    @AfterMethod
    public void a_takeScreenshotForFailedTests(ITestResult result) {
        String destination = "./screenshots/" + result.getName() + ".png" ;
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                //To add it in the extent report
                FileUtils.copyFile(screenshot, new File(destination));
            } catch (IOException e) {
                // handle
            }
        }
    }

    @AfterMethod
    public void z_quitDriver() {

        driver.quit();
    }

}
