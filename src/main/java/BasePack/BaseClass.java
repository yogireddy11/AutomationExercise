package BasePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait driverWait;
    public Properties properties;
    FileInputStream inputStream;

    public void initialBaseSetup(String browser) {
        System.out.println("initialBaseSetup");
        switch (browser.toLowerCase()) {
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "internet explorer":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("No browser found!!!!");
                return;
        }
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        properties = new Properties();
        try {
            String file = "C:\\Users\\MusumYogireddy\\eclipse-workspace1\\AutomationExercise\\src\\main\\propertiesData.Properties";
            inputStream = new FileInputStream(file);
            properties.load(inputStream);  // Load the properties file
        } catch (FileNotFoundException e) {
            System.out.println(STR."Properties file not found: \{e.getMessage()}");
        } catch (IOException e) {
            System.out.println(STR."IOException: \{e.getMessage()}");
        }
    }
}
