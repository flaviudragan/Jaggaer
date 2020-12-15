package jaggaer.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static final String BROWSER = "chrome";
    private static final String WINDOW_WIDTH = System.getenv("window_width");
    private static final String WINDOW_HEIGHT = System.getenv("window_height");
    private static final String HEADLESS_CHROME = "headless-chrome";
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String HEADLESS_FIREFOX = "headless-firefox";
    private static final String IE = "ie";
    private static final String EDGE = "edge";
    private static final String SAFARI = "safari";
    private static final String WINDOW_SIZE = "--window-size="+WINDOW_WIDTH+"x"+WINDOW_HEIGHT;

    public static WebDriver getDriver() {
        System.out.println("getDriver");

        WebDriver driver = null;

            switch (BROWSER.toLowerCase())
            {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case HEADLESS_CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
                    chromeOptions.addArguments("disable-infobars"); // disabling infobars
                    chromeOptions.addArguments("--disable-extensions"); // disabling extensions
                    chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
                    chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                    chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case HEADLESS_FIREFOX:
                    FirefoxBinary firefoxBinary = new FirefoxBinary();
                    firefoxBinary.addCommandLineOptions("--headless");
                    firefoxBinary.addCommandLineOptions(WINDOW_SIZE);
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setBinary(firefoxBinary);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case SAFARI:
                    driver = new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }


        return driver;
    }
}
