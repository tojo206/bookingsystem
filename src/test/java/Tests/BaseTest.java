package Tests;

import CommonBase.BrowserConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    WebDriver driver;
    protected String browser;
    protected String BaseUrl;
    protected String headless;

    private String getEnv(String variable, String defaultValue){
        String value = System.getenv(variable);
        return (value == null || value.isEmpty()) ? defaultValue : value;
    }


    @BeforeMethod
    public void setup(){


        browser = getEnv("Browser","chrome");
        BaseUrl = getEnv("Url","https://automationintesting.online/");
        headless = getEnv("Headless","false");
        driver = BrowserConfiguration.startBrowser(browser, BaseUrl, Boolean.valueOf(headless));
    }


    @AfterMethod
    public void close(){
        driver.close();
        driver.quit();
    }





}
