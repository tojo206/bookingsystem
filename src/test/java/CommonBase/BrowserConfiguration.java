package CommonBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserConfiguration {

    public static WebDriver driver;

    public static WebDriver startBrowser(String browserChoice, String url, Boolean isheadless) {
        if ("edge".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();

            if (isheadless) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=2560,1440");
            }else {
                options.addArguments("--start-maximized");
            }

            driver = new EdgeDriver(options);

        } else if ("chrome".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            if (isheadless) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=2560,1440");
            }else {
                options.addArguments("--start-maximized");
            }
            driver = new ChromeDriver(options);


        }

        driver.get(url);
        return driver;
    }










}
